import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Czlowiek> lista = new ArrayList<>();
		try(FileInputStream fos = new FileInputStream("ludzie.txt")){
			Scanner sc = new Scanner(fos);
			
			while(sc.hasNextLine()) {
				//String linia = sc.nextLine();
				String imie = sc.next();
				String nazwisko = sc.next();
				LocalDate data = LocalDate.parse(sc.next());
				//System.out.println(imie+nazwisko+data.toString());
				lista.add(new Czlowiek(imie, nazwisko, data));				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileOutputStream fos = new FileOutputStream("ludzie.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(lista);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
