import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SocketHandler implements Runnable {
	private Server server;
	private Scanner scanner;
	private PrintWriter printWriter;
	private boolean end = false;
	private LocalTime lastTime;
	
	public SocketHandler(Server server, InputStream sc, OutputStream pw) {
		this.server = server;
		this.scanner = new Scanner(sc);
		this.printWriter = new PrintWriter(pw, true);
	}

	@Override
	public void run() {
		while(!end && scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			if(line.length()!=0) {
				StringTokenizer st = new StringTokenizer(line);
				String firstToken = st.nextToken();
				switch(firstToken) {
					case "q":
						printWriter.println("wpisano q");
					case "time":{
						lastTime = LocalTime.now();
						printWriter.println(LocalTime.now());
						break;
					}
					case "interval":{
						if(lastTime!=null) {
							
							int godz = LocalTime.now().getHour() - lastTime.getHour();
							int min = LocalTime.now().getMinute() - lastTime.getMinute();
							int sec = LocalTime.now().getSecond() - lastTime.getSecond();
							
							printWriter.println("Od ostatniego uzycia time minelo"+godz+"h "+min+"m "+sec+"s");
							
						} else {
							printWriter.println("nie uzyto jeszce komendy time!");
						}
						break;
					}
					case "stop":{
						printWriter.println("Nastapilo wylogowanie");
						end=true;
						break;
					}
					case "end":{
						printWriter.println("Serwer zostanie wylaczony.");
						System.exit(0);
					}
							
					
						
					default:
						printWriter.println("Domyslny case");
			}
		}

	}
		}

}
