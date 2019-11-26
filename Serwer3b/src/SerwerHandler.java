import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SerwerHandler implements Runnable {
	private SerwerClass serwer;
	private Scanner sc;
	private PrintWriter pw;
	private boolean end =false;
	private static int licz;
	
	public SerwerHandler(SerwerClass serwer, InputStream sc, OutputStream pw) {
		this.serwer = serwer;
		this.sc = new Scanner(sc);
		this.pw = new PrintWriter(pw, true);
		
	}
	
	@Override
	public void run() {
		pw.println("Witaj na serwerze! Wpiszk komende");		
		while(!end && sc.hasNextLine()) {
			
			String komenda = sc.nextLine().trim();
			StringTokenizer st = new StringTokenizer(komenda);
			String firstToken = st.nextToken();
			switch(firstToken) {
			case "invert":{
				SerwerHandler.licz++;
				System.out.println("Ilosc tokenow: " + st.countTokens());
				if(st.countTokens()==2) {
				
					String drugi, pierwszy;
					drugi = st.nextToken();
					pierwszy = st.nextToken();
					if(drugi!=null && pierwszy!=null) {
						pw.println("Invert: "+ pierwszy + " " + drugi);
				} 
				}else {
					pw.println("Podano zla liczbe argumentow");
				}
				break;
			
			}
			case "count":{
				pw.println("Polecenia invert uzyto tyle razy: " + licz);
				break;
			}
			case "stop":{
				pw.println("Zostaniesz wylogowany z serwera");
				end=!end;
				break;
			}
			case "end":{
				pw.println("Serwer zostanie wylaczony!");
				System.exit(0);
			}
			default:{
				pw.println("Podano zla komende");
			}
			
			}
			
		}

	}

}
