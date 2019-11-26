import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServerHandler implements Runnable {
	private SerwerClass serwer;
	private Scanner sc;
	private PrintWriter pw;
	private boolean end = false;
	private LocalTime lastTime;
	
	
	public ServerHandler(SerwerClass serwer, InputStream is, OutputStream os ) {
		this.serwer = serwer;
		this.sc = new Scanner(is);
		this.pw = new PrintWriter(os, true);
	}

	@Override
	public void run() {
		pw.println("Witaj na serwerze! wpiszk komende: ");
		while(!end && sc.hasNextLine()) {
			
			StringTokenizer linia = new StringTokenizer(sc.nextLine());
			String komenda = linia.nextToken().trim();
			
			switch(komenda) {
			case "time":{
				lastTime = LocalTime.now();
				pw.println(LocalTime.now());
				break;
			}
			case "interval":{
				if(lastTime!=null) {
					pw.println(LocalTime.now().getSecond() - lastTime.getSecond());
					
				}
				else {
					pw.println("Nie uzyto jescze time");
					
				}
				break;
			}
			case "stop":{
				pw.println("Zostaniesz wylogowany");
				end=!end;
				break;
			}
			case "end":{
				pw.println("Serwer zostanie wylaczony");
				end=!end;
				System.exit(0);
			}
			default:{
				pw.println("niewlasciwa komenda");
			}
				
		}

	}
		System.out.println("Wyjscie z petli");

}
}
