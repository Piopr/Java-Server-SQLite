import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> nazwy= new ArrayList<>();
		try(FileInputStream fis = new FileInputStream("ludzie.txt")){
			Scanner sc = new Scanner(fis);
			while(sc.hasNextLine()) {
				String imie = sc.next();
				String nazwisko = sc.next();
				String data = sc.next().toString();
				nazwy.add(imie+nazwisko);
				try(FileOutputStream fos = new FileOutputStream(imie+nazwisko+".txt")){
					PrintWriter pw = new PrintWriter(fos);
					pw.println(imie+' '+nazwisko+' '+data);
					pw.close();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String f : nazwy) {
			try (FileOutputStream fos = new FileOutputStream(f+".zip");
					ZipOutputStream zos = new ZipOutputStream(fos);
					FileInputStream pliki = new FileInputStream(f+".txt")){
				ZipEntry ze = new ZipEntry(f+".txt");
				zos.putNextEntry(ze);
				int bufSize = 1024, c;
				byte[] buff = new byte[bufSize];
				while((c = pliki.read(buff, 0, bufSize))>-1) {
					zos.write(buff, 0, c);
				}
				zos.closeEntry();
				
			} catch (FileNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		
		


	}

}
