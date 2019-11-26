import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CzlowiekDeserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(FileInputStream fis = new FileInputStream("czlowieki.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Czlowiek c;
			while((c = (Czlowiek)ois.readObject())!=null)	{
				System.out.println(c);
			}
			
		
		}
		catch(EOFException e) {
			System.out.println("Koniec danych");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
