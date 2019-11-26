import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream(args[0]); 
				ZipInputStream zis = new ZipInputStream(fis)){
			ZipEntry nextEntry;
			while((nextEntry = zis.getNextEntry())!=null	) {
				String fname = nextEntry.getName();
				try(FileOutputStream fos = new FileOutputStream(fname)){
					int bufSize = 1024;
					int c;
					byte[] buffer = new byte[bufSize];
					while((c = zis.read(buffer, 0, bufSize)) >-1) {
						fos.write(buffer, 0, c);
					}
				}
				System.out.println("wypakowano plik: "+fname);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
