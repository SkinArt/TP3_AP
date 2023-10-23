package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    int ord = 0;
    ServerSocket ss;

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void run(){
        try(ServerSocket ss = new ServerSocket(1234);){
            while(true){
                Socket s = ss.accept();
                new ClientProcess(s,ord++).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class ClientProcess extends Thread{
        Socket s;
        int ord;
        public ClientProcess(Socket s, int ord){
            this.s = s;
            this.ord = ord;
        }

        public void run(){
            System.out.println("client connecté " + s.getRemoteSocketAddress() + " ordre : " + this.ord );
            try {
                s.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}

