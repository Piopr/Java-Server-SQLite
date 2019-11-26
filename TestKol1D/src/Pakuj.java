import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Pakuj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(FileOutputStream fos = new FileOutputStream("archiwum.zip");
				ZipOutputStream zos = new ZipOutputStream(fos)){
			for(String fname : args) {
				try(FileInputStream fis = new FileInputStream(fname);
						ZipInputStream zis = new ZipInputStream(fis)){
					ZipEntry ze = new ZipEntry(fname);
					zos.putNextEntry(ze);
					System.out.println(fname);
					int bs = 1024, c;
					byte[] buff = new byte[bs];
					while((c = fis.read(buff, 0, bs))>-1) {
						zos.write(buff, 0, c);
					}
					zos.closeEntry();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
