import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServerSocketHandle {
	
	public static void main(String[] args) {
		boolean end = false;
		
		try(ServerSocket ss = new ServerSocket(8189)){
			try(Socket s = ss.accept()){
				try(InputStream is = s.getInputStream();
						OutputStream os = s.getOutputStream();
						Scanner sc = new Scanner(is);
						PrintWriter pw = new PrintWriter(os, true)){
				pw.println("Witaj na serwerze, byku");
				while(!end && sc.hasNextLine()) {
					String linia = sc.nextLine();					
					
					pw.println("Komenda: " + linia);
					StringTokenizer st = new StringTokenizer(linia);
					String pierwsze = st.nextToken();
					if(pierwsze.equals("q")) {
						pw.println(st.nextToken());
						end=!end;
					}
					else if(pierwsze.equals("sum")) {
						//pw.println("Wpisales: " + linia);
						if(st.countTokens()==2) {
							int l1 = Integer.parseInt(st.nextToken());
							int l2 = Integer.parseInt(st.nextToken());
							
							int dzialanie = l1+l2;
							
							pw.println("Wynik: " + dzialanie);
						} else {
							pw.println("Podano nieodpowiednia ilosc tokenow. Wymaganae 3, podano: "+(st.countTokens()+1));
						}
					} else if(pierwsze.equals("sub")) {
						//pw.println("Wpisales: " + linia);
						if(st.countTokens()==2) {
							int l1 = Integer.parseInt(st.nextToken());
							int l2 = Integer.parseInt(st.nextToken());
							
							int dzialanie = l1-l2;
							
							pw.println("Wynik: " + dzialanie);
						} else {
							pw.println("Podano nieodpowiednia ilosc tokenow. Wymaganae 3, podano: "+(st.countTokens()+1));
						}
					}
					else {
						pw.println("Nieprawidlowa komenda");
						pw.println("Dostepne komendy: \"sum liczba1 liczba2\" = dodawanie");
						pw.println("\"sub liczba1 liczba2\" = odejmowanie");
						pw.println("\"q\" = odejmowanie");
					}
					
				}
				pw.println("Sesja zakonczona");
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
