import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Serializacja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(FileOutputStream fos = new FileOutputStream("data.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileOutputStream fos2 = new FileOutputStream("archiwum.zip");
				ZipOutputStream zos = new ZipOutputStream(fos2);
				FileInputStream fis = new FileInputStream("data.ser")
				){
				oos.writeObject(new Czlowiek(args[0], args[1], LocalDate.parse(args[2])));
				ZipEntry ze = new ZipEntry("data.ser");
				zos.putNextEntry(ze);
				int bs = 1024, c;
				byte[] buff = new byte[bs];
				while((c = fis.read(buff, 0, bs))>-1) {
					zos.write(buff, 0, c);
				}
				zos.closeEntry();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
