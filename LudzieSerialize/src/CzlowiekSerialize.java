import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class CzlowiekSerialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Czlowiek> lista=new ArrayList<>();
		lista.add(new Czlowiek("Jan", "Kowalski", LocalDate.of(1987, 11, 11)));
		lista.add(new Czlowiek("Zbigniew", "Nowak", LocalDate.of(1937, 10, 11)));
		lista.add(new Czlowiek("Zofia", "Na³kowska", LocalDate.of(1937, 10, 11)));
		lista.add(new Czlowiek("Maria", "Konopnicka", LocalDate.of(1937, 10, 11)));
		
	    try(FileOutputStream fos=new FileOutputStream("ludzie.ser");
	    		ObjectOutputStream oos=new ObjectOutputStream(fos)){
	    	for(int i=0;i<lista.size();i++)
	    		oos.writeObject(lista.get(i));
	    	System.out.println("Zapis ukoñczono");
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
