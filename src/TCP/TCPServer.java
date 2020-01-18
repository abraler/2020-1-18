package TCP;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Task implements   Runnable{
    private final  Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
        InputStream is=socket.getInputStream();
        OutputStream os=socket.getOutputStream();

        Reader reader=new InputStreamReader(is,"utf-8");
        BufferedReader bf=new BufferedReader(reader);

        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter pw=new PrintWriter(writer,false);

        String message;
        while(true){
        while((message=bf.readLine())!=null){
            System.out.println(message);
            pw.println(message);
            pw.flush();
        }
        }
        }catch (IOException e){

        }
    }
}
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService=Executors.newFixedThreadPool(10);

        ServerSocket serverSocket=new ServerSocket(8080);
        while(true){
            Socket socket=serverSocket.accept();
            executorService.execute(new Task(socket));
        }
    }
}
