import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HTTPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try(Socket s = new Socket("www.onet.pl", 80);
				OutputStream os = s.getOutputStream(); 
				InputStream is = s.getInputStream(); 
				PrintWriter pw = new PrintWriter(os);
				Scanner sc = new Scanner(is);) {
			
			pw.println("GET /index.php HTTP/1.1");
			pw.println("Host: www.onet.pl");
			pw.println("Content-Type: text/html");
			pw.println();
			pw.flush();
			
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
