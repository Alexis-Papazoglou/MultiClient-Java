import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerProtocol {
	
	private Socket soc;
	private BufferedReader in;
	private PrintWriter out;
	private int req;
	
	public ServerProtocol(Socket soc) {
		this.soc = soc;
		
		try {
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			out = new PrintWriter(soc.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void respone() throws IOException{
		
		System.out.println("Hey");
		req = Integer.parseInt(in.readLine());
		while (req != -1) {
			System.out.println("in while");
			out.println(req * 10);
			
			req = Integer.parseInt(in.readLine());
		}
		out.println("Process Stoped.");
		soc.close();
	}

}
