import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(FileOutputStream fos = new FileOutputStream("archiwum.zip");
				ZipOutputStream zos = new ZipOutputStream(fos)){
			for(String fname: args) {
				try(FileInputStream fis = new FileInputStream(fname)){		
				
					//System.out.println(fname);
					ZipEntry ze = new ZipEntry(fname);
					zos.putNextEntry(ze);
					int bufsize = 1024;
					int c;
					byte[] bufor = new byte[bufsize];
					while((c = fis.read(bufor, 0, bufsize)) >-1) {
						zos.write(bufor, 0, c);
				}
				zos.closeEntry();
				
				}
				System.out.println("Spakowano plik: "+fname);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
