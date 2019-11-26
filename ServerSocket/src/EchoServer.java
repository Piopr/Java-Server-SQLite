import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	
	public static void main(String[] args) {
		boolean end = false;
		
		try(ServerSocket ss = new ServerSocket(8189)){
			try(Socket s = ss.accept()){
				try(InputStream is = s.getInputStream();
						OutputStream os = s.getOutputStream();
						Scanner sc = new Scanner(is);
						PrintWriter pw = new PrintWriter(os, true)){
				pw.println("Witaj na serwerze, byku");
				while(!end && sc.hasNextLine()) {
					String linia = sc.nextLine();
					pw.println("echo: " + linia);
					
					if(linia.equals("end")) {
						end=!end;
					}
					
				}
				pw.println("Sesja zakonczona");
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
