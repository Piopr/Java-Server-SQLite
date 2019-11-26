import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HTTPClient {

	public static void main(String[] args) {
		try(Socket s=new Socket("www.up.krakow.pl", 80);//otwarcie polaczenia ze strona
				OutputStream os=s.getOutputStream();//zapytania do serwera
				InputStream is=s.getInputStream();//odpowiedzi z serwera
				PrintWriter pw=new PrintWriter(os,false);//wpisywanie zapytan do serwera
				Scanner sc=new Scanner(is)){//wylapywanie odpowiedzi z serwera
			pw.println("GET /index.php HTTP/1.1");
			pw.println("Host: www.up.krakow.pl");
			pw.println("Content-Type: text/html");//zapytania
			pw.println();
			pw.flush();//zakonczenie zapytania
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());//czytanie odpowiedzi
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
