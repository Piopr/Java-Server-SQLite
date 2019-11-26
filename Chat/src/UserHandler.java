import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserHandler implements Runnable {

	private InputStream inStream;
	private OutputStream outStream;
	private ChatMain server;
	private String login;
	private Scanner sc;
	private PrintWriter pw;
	private boolean loggedIn = false;
	private boolean end = false;
	
	public UserHandler(InputStream inStream, OutputStream outStream, ChatMain server) {
		this.inStream = inStream;
		this.outStream = outStream;
		this.server = server;
		sc = new Scanner(inStream);
		pw = new PrintWriter(outStream, true);
	}
	
	@Override
	public void run() {
		pw.println("Podaj login: ");
		printMonit();
		if(!(loggedIn=acceptedLogin())) {
			pw.println("Niepoprawny login.");
			return;
		}
		server.loginUser(login, this);
		pw.println("Jestes nowym uzytkownikiem na czacie.");
		printMonit();
		while(!end && sc.hasNextLine()) {
			String line = sc.nextLine().trim();
			if(line.length()!=0) {
				StringTokenizer st = new StringTokenizer(line);
				String firstToken = st.nextToken();
				switch(firstToken) {
				case "q":{
					end=true;
					server.logoutUser(login);
					break;
				}
				case "stop":
					server.broadcastMsg(login, "Serwer zostanie wylaczony");
					System.exit(0);
				
				case "count":{
					pw.println("Obecnie jest zalogowanych: " + server.getLoggedUsers() + " uzytkownikow");
				}
				case "list":{
					for(String user: server.listLoggedUsers()) {
						pw.println(user);
					}
				}
				default:{
					if(!server.userLoggedIn(firstToken)) {
						pw.println("Uzytkownik niezalogowany!");
						break;
					}
					String msg=line.substring(firstToken.length()+1);
					if(msg.length()==0) {
						pw.println("Brak wiadomosci");
						break;
					}
					server.sendMsg(login, firstToken, msg);
					break;
				}
				}
			}
			printMonit();
		}
	}



	
	public boolean acceptedLogin() {
		boolean accept = false;
		String line=sc.nextLine();
		if(line.length()>0) {
			accept=true;
			login=line;
		}
		return accept;
	}
	
	
	
	public void printMonit() {
		if(!loggedIn)
			pw.print(">");
		else
			pw.print(login+">");
		pw.flush();
	}
	public Scanner getScanner() {
		return sc;
	}

	public PrintWriter getPrintWriter() {
		return pw;
	}
}
