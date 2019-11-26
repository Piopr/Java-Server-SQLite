import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainCallable {

	private static final String URL1="http://www.library.uwa.edu.au/__data/assets/pdf_file/0003/568146/UWA_Library_standards_for_Acrobat_8.pdf";
	private static final String URL2="http://www.just.edu.jo/~mqais/CIS99/PDF/Ch.01_Introduction_%20to_computers.pdf";
	private static final String URL3="https://enauczanie.pg.edu.pl/moodle/pluginfile.php/305313/mod_resource/content/1/01%20Introduction.pdf";
	private static final String URL4="https://cran.r-project.org/doc/manuals/r-release/R-intro.pdf";
	
	public static void main(String[] args) {
		ArrayList<Future<DownloadInfo>> futureList = new ArrayList<>();
		ExecutorService pool=Executors.newFixedThreadPool(2);
		futureList.add(pool.submit(new DownloadTaskCallable(URL1)));
		futureList.add(pool.submit(new DownloadTaskCallable(URL2)));
		futureList.add(pool.submit(new DownloadTaskCallable(URL3)));
		futureList.add(pool.submit(new DownloadTaskCallable(URL4)));
		pool.shutdown();//nie przyjmuje kolejnuch zadan
		

		for(Future<DownloadInfo> f : futureList) {
			try {
				//czeka az skoncza sie wykonywac wszystkie poprzednie zadania
				if(pool.awaitTermination(15, TimeUnit.SECONDS)) {
				System.out.println("Plik "+f.get().getFileName()+" o rozmiarze "+
						  f.get().getFileSize()+" zaladowano w czasie "+f.get().getDownloadTime());
} else {
				System.out.println("Uplynal limit czasu.");
}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
