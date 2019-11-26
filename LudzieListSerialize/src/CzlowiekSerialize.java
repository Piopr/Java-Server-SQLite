import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CzlowiekSerialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Czlowiek> lista = new ArrayList<>();

		try {
			File file = new File("ludzie.dat");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String linia = sc.nextLine();
				StringTokenizer st = new StringTokenizer(linia);				
				String imie = st.nextToken();
				String nazwisko = st.nextToken();
				LocalDate dataUr = LocalDate.parse(st.nextToken());
				//System.out.println(imie+nazwisko+dataUr);
				lista.add(new Czlowiek(imie, nazwisko, dataUr));
				
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(FileOutputStream fos = new FileOutputStream("ludzie.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(lista);				
				System.out.println("Zapis ukonczono");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
