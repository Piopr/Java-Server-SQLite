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
		SerwerClass serwer = new SerwerClass(8186);
		serwer.start();

	}
	
	private void start() {
		try (ServerSocket ss = new ServerSocket(port)){	
			System.out.println("Serwer dziala na porcie: "+ port);
			while(true) {
				Socket s = ss.accept();
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Thread t = new Thread(new ServerHandler(this, is, os));
				t.start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
