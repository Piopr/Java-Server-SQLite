import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SerwerHandler implements Runnable {
	SerwerClass serwer;
	Scanner sc;
	PrintWriter pw;
	boolean end = false;
	private static int users =0;
	

	
	public SerwerHandler(SerwerClass serwer, InputStream is, OutputStream os) {
		this.serwer = serwer;
		this.sc = new Scanner(is);
		this.pw = new PrintWriter(os, true);
		
	}
	
	@Override
	public void run() {
		pw.println("Witaj na serwerze! Wpisz komende: ");
		users++;
		while(!end && sc.hasNextLine()) {
			String linia = sc.nextLine().trim();
			StringTokenizer st = new StringTokenizer(linia);
			String firstToken = st.nextToken();
			switch(firstToken) {
			case "count":{
				pw.println("Ilosc zalogowanych uzytkownikow: " + users);
				break;
			}
			case "myip": {
				pw.println(serwer.ip.toString());
				break;
			}
			case "stop":{
				pw.println("Zostajesz wylogowany");
				//users--;
				end=!end;
				break;
			}
			case "end":{
				pw.println("Serwer zostanir zamkniety");
				System.exit(0);
			}
			default:{
				pw.println("Niewlasciwa komenda");
				break;
			}
			}
			
		}
		users--;
		

	}

}
