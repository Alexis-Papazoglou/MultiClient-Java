import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{

		ServerSocket ss = new ServerSocket(1234);
		
		while(true) {
			
			System.out.println("Waiting for clients..");
			Socket client = ss.accept();
			System.out.println("Client Connected..");
			
			ClientHandler thread = new ClientHandler(client);
			thread.start();
			System.out.println("Thread Started");
		}
		
	}

}
