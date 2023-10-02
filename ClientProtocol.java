import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientProtocol {
	
	int key_read , res;
	private Socket soc;
	private BufferedReader in;
	private BufferedReader kb;
	private PrintWriter out;
	
	public ClientProtocol(Socket soc) {
		this.soc = soc;
		
		try {
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			kb = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(soc.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public int key_read() throws IOException{
		System.out.println("Dwse arithmo gia ypologismo kai -1 gia termatismo");
		key_read = Integer.parseInt(kb.readLine());
		return key_read;
	}
	
	public void contact() throws IOException {
		out.println(key_read);
		System.out.println(in.readLine());
	}

}
