package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPclient {
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("输入要发送的消息");
            String message=in.nextLine();
            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] bytes = {127, 0, 0, 1};
            InetAddress inetAddress = InetAddress.getByAddress(bytes);
            DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), 0, message.length(), inetAddress, 9999);
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        }
    }
}
