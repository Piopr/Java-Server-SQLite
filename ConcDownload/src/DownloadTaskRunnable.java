import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTaskRunnable implements Runnable {
	private String path;
	public DownloadTaskRunnable(String path){
		this.path=path;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(path);
			try(InputStream is = url.openStream();
	FileOutputStream fos = new FileOutputStream(extractFileName(path))){
				 int bufsize=1024,c;
				 byte[] bufor=new byte[bufsize];
				 while((c=is.read(bufor, 0, bufsize))>-1) {
					 fos.write(bufor, 0, c);
				 }
			System.out.println("Watek: "+Thread.currentThread().getName() +" pobral plik: "+
				 extractFileName(path));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private String extractFileName(String path) {
		return path.substring(path.lastIndexOf("/")+1);
	}	
}
