import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
	
	private Socket soc;
	
	private ServerProtocol app;

	public ClientHandler(Socket client) {
		this.soc = client;
		app = new ServerProtocol(soc);
	}

	@Override
	public void run() {
		try {
			app.respone();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
