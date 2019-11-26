import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SerwerClass {
	private int port;
	SocketAddress ip;
	
	
	public SerwerClass(int port) {
		this.port = port;
		
	}	
	
	public static void main(String[] args) {
		SerwerClass serwer = new SerwerClass(8184);
		serwer.start();

	}

	private void start() {
		try(ServerSocket ss = new ServerSocket(port)){
			System.out.println("Serwer nasluchuje na: " + port);
			while(true) {
				Socket s = ss.accept();
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Thread t = new Thread(new SerwerHandler(this, is, os));
				System.out.println("Tu dochodze");
				ip = s.getRemoteSocketAddress();
				System.out.println("Tu tez dochodze");
				t.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
