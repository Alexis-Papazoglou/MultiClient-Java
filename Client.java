import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args)throws IOException {
		
		int key_read , res;
		
		Socket soc = new Socket("localhost",1234);
		System.out.println("Connected to server!");
		
		ClientProtocol app = new ClientProtocol(soc);
		
		key_read = app.key_read();
		
		while(key_read != -1) {
			app.contact();
			key_read = app.key_read();
		}
		
		soc.close();
		

	}

}
