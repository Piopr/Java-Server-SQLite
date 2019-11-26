import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CzlowiekDeserialize {

	public static void main(String[] args) {
		try(FileInputStream fis=new FileInputStream("ludzie.ser");
				ObjectInputStream ois=new ObjectInputStream(fis)){
			Czlowiek c;
			while((c=(Czlowiek)ois.readObject())!=null)
				System.out.println(c.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Nie znaleziono pliku");
			//e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("Koniec danych");
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
