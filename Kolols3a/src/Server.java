import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port;
	
	
	public Server(int port) {
		this.port = port;
		
	}
	
	public static void main(String[] args) {
		Server server = new Server(8189);
		server.start();
	}
	
	private void start() {
		try(ServerSocket sc = new ServerSocket(port)){
			System.out.println("Serwer dziala na porcie: " + port);
			while(true) {
				Socket s = sc.accept();
				InputStream is = s.getInputStream();//odpowiedzi z serwera
				OutputStream os = s.getOutputStream();
				Thread t = new Thread(new SocketHandler(this, is, os));
				t.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
