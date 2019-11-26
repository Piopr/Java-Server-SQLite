import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatMain {
	//Mapa przechowujaca NazwaUsera - watek
	private Map<String, UserHandler> loggedUserTasks;
	private int port;
	private int loggedUsers;
	
	public int getLoggedUsers() {
		return loggedUsers;
	}
	
	private ChatMain(int port) {
		this.port = port;
		loggedUserTasks = new HashMap<String, UserHandler>();		
	}
	
	private void start() throws IOException {
		try(ServerSocket ss = new ServerSocket(port)){
			System.out.println("Server nasluchuje na porcie: "+ port);
			while(true) {
				Socket s=ss.accept();
				InputStream is = s.getInputStream();//informacje przychodzace
				OutputStream os = s.getOutputStream();//informacje wysylane
				Thread t = new Thread(new UserHandler(is, os, this));//nowy watek 
				t.start();
				
			}
		}
	}
	public void loginUser(String user, UserHandler handler) {
		loggedUserTasks.put(user, handler);
		loggedUsers++;
	}
	
	public void logoutUser(String user) {
		loggedUserTasks.remove(user);
		loggedUsers--;
	}
	
	public static void main(String[] args) throws IOException {
		ChatMain cm = new ChatMain(8189);
		cm.start();
	}
	
	public boolean userLoggedIn(String user) {
		if(loggedUserTasks.containsKey(user)) {
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized void sendMsg(String from, String user, String msg) {
		UserHandler task = loggedUserTasks.get(user); //pobieranie watku usera, do ktorego bedzie wysylana wiadomosc
		task.getPrintWriter().print("<<od " + from +">>");
		task.getPrintWriter().println(msg);
		task.printMonit();
	}
	//TODO
	public void broadcastMsg(String from, String msg) {
		for(String user: loggedUserTasks.keySet()) {
			sendMsg(from, user, msg);
		}
	}
	
	public ArrayList<String> listLoggedUsers(){
		return new ArrayList<>(loggedUserTasks.keySet());
	}
	
}
