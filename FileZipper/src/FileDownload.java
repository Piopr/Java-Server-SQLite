import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownload {
	private static final String PATH="http://ii.up.krakow.pl/pdf/schedules/2018-19/stacjonarne/III%20rok/INF%20III%20s5%202018-19.pdf";
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL(PATH);
			try(InputStream is = url.openStream();
				FileOutputStream fos = new FileOutputStream(extractFileName(PATH))){
				int buforSize=1024;
				int c;//
				byte[] bufor = new byte[buforSize];
				while((c = is.read(bufor, 0, buforSize) )>-1) {
					//System.out.println(c);
					fos.write(bufor);
				}
				System.out.println("Pobrano "+extractFileName(PATH));
				
			} catch (Exception e) {
				
			}
				

			
		} catch (Exception e) {
			// TODO: handle exception
		} 	
		
		
		
		
	}

	private static String extractFileName(String path) {
		return path.substring(path.lastIndexOf("/")+1);
	}
}
