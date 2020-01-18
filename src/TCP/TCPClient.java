package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8080);

        Scanner in=new Scanner(System.in);

        System.out.println("输入自己的昵称");
        String name=in.next();



        InputStream is=socket.getInputStream();
        OutputStream os=socket.getOutputStream();

        Reader reader=new InputStreamReader(is,"UTF-8");
        BufferedReader bf=new BufferedReader(reader);

        PrintWriter pw=new PrintWriter(new OutputStreamWriter(os,"utf-8"),false);
        while(true) {
            System.out.println("输入要发送的消息");
            String m = in.next();
            pw.println(name + ":" + m);
            pw.flush();
            String message;
            while ((message = bf.readLine()) != null) {
                System.out.println(message);
            }
        }

    }
}
