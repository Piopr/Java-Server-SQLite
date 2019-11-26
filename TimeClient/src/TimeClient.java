import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TimeClient {

	public static void main(String[] args) {
		try(Socket s=new Socket("ntp-b.nist.gov", 13);
				InputStream is=s.getInputStream();
				Scanner sc=new Scanner(is)){
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
