package echo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
public class ServerEcho {

	public static void main(String args[]) throws IOException {
		
		System.out.println("server started");
		
		ServerSocket ss=new ServerSocket(2000);
		
		Socket skt=ss.accept();	
		
		//for input stream
		BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
		//for output
		PrintStream ps=new PrintStream(skt.getOutputStream());
		String msg;
		
		do {
			
			msg=br.readLine();
			ps.println("prossed:"+msg);
		}
		while(msg!="end");
		
		ss.close();
		
	}
	
}
