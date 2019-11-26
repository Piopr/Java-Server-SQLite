import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;

public class DownloadTaskCallable implements Callable<DownloadInfo>{
	private String path;
	private long startTime, endTime;
	private int downloadTime, fileSize=0;
	private String fileName;
	
	public DownloadTaskCallable(String path) {
		this.path = path;
		fileName = extractFileName(path);
	}
	
	@Override
	public DownloadInfo call() throws Exception {
		URL url = new URL(path);
		startTime=System.currentTimeMillis();
		try(InputStream is = url.openStream();
				FileOutputStream fos = new FileOutputStream(fileName)){
			int bufsize=1024, c;
			byte[] bufor = new byte[bufsize];
			while((c=is.read(bufor, 0, bufsize))>-1) {
				fos.write(bufor, 0, c);
				fileSize+=c;
			}
		}
		endTime=System.currentTimeMillis();
		downloadTime = (int)((double)(endTime-startTime)/1000);
		return new DownloadInfo(downloadTime, fileSize/1000, fileName);
	}
	
	
	private String extractFileName(String path) {
		return path.substring(path.lastIndexOf("/")+1);
	}	
}

class DownloadInfo{
	private int downloadTime, fileSize;
	private String fileName;
	public DownloadInfo(int downloadTime, int fileSize, String fileName) {
		super();
		this.downloadTime = downloadTime;
		this.fileSize = fileSize;
		this.fileName = fileName;
	}
	public int getDownloadTime() {
		return downloadTime;
	}
	public int getFileSize() {
		return fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	
}
