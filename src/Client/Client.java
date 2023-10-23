package Client;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {

            // Create an InetAddress object with the specified IP address.
            InetAddress IA = InetAddress.getByName("192.168.1.134");
            InetSocketAddress ISA = new InetSocketAddress(IA, 1234);

            // Create a Socket object and connect to the specified address and port.
            Socket client = new Socket();

            client.connect(ISA);

        } catch (Exception e) {
            // Handle any exceptions that may occur during execution.
            System.out.println("CLient here");
            throw new RuntimeException(e);
        }
    }
}
