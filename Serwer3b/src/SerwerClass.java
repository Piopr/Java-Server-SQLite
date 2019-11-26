import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SerwerClass {
	private int port;
	
	public SerwerClass(int port) {
		this.port = port;
	}
	
	
	public static void main(String[] args) {
		SerwerClass serwer = new SerwerClass(8185);
		serwer.start();

	}
	
	private void start() {
		System.out.println("Serwer dzia³a na porcie: " + port);
		try(ServerSocket ss = new ServerSocket(port)){
			while(true) {
				Socket s = ss.accept();			
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Thread t = new Thread(new SerwerHandler(this, is, os));
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
