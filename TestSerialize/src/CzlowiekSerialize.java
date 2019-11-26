import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CzlowiekSerialize {

	public static void main(String[] args) {
		ArrayList<Czlowiek> czlowiek = new ArrayList<>();
		czlowiek.add(new Czlowiek("Roman", "Lasota", 12));
		czlowiek.add(new Czlowiek("Elo", "siema", 12));
		czlowiek.add(new Czlowiek("maria", "konopnicka", 12));
		czlowiek.add(new Czlowiek("stefan", "batory", 12));
		czlowiek.add(new Czlowiek("pan", "tadeusz", 12));
		czlowiek.add(new Czlowiek("jacek", "soplica", 12));

		
		try(FileOutputStream fos = new FileOutputStream("czlowieki.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Czlowiek cz : czlowiek) {
					oos.writeObject(cz);
				}
				System.out.println("Koniec zapisu");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
