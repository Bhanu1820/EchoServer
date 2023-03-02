
package echo;
import java.io.*;
import java.net.*;

public class ClientEcho {
	public static void main(String[] args) throws UnknownHostException, IOException{
		
		Socket skt = new Socket("localhost",2000);
		
		
		// for input from keyboard
		BufferedReader keyread=new BufferedReader(new InputStreamReader(System.in));
		//for input stream
		BufferedReader br=new BufferedReader(new InputStreamReader(skt.getInputStream()));
		//for output
		PrintStream ps=new PrintStream(skt.getOutputStream());
		
		String msg;
		do {
			msg=keyread.readLine();
			ps.println(msg);
			msg=br.readLine();
			System.out.println("From Server:"+msg);
		}
		while(msg!="end");
		skt.close();
	}
}