import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CzlowiekDeserialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try(FileInputStream fis = new FileInputStream("ludzie.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			ArrayList<Czlowiek> lista = (ArrayList<Czlowiek>)ois.readObject();
			for(Czlowiek c : lista) {
				System.out.println(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(EOFException e) {
			System.out.println("Koniec danych");
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NoClassDefFoundError e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
