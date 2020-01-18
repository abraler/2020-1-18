package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPserver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket =new DatagramSocket(9999);
        while(true){
            byte[]bytes=new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(bytes,1024);
            datagramSocket.receive(datagramPacket);
            InetAddress inetAddress= datagramPacket.getAddress();
            System.out.println(inetAddress.getHostName());
            System.out.println(datagramPacket.getLength());
            //String message=datagramPacket.getData().toString();
            String message=new String(bytes,0,datagramPacket.getLength(),"utf-8");
            System.out.println(message);
    }
    }
}
