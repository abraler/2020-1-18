package HTTP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPserver {
    public static void main(String[] args) throws IOException {
        ExecutorService pool=Executors.newFixedThreadPool(10);
        ServerSocket serverSocket=new  ServerSocket(8080);
        while(true){
            Socket socket=serverSocket.accept();
            pool.execute(new Task(socket));
        }
    }
}
