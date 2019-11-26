import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainRunnable {
	private static final String URL1="http://www.library.uwa.edu.au/__data/assets/pdf_file/0003/568146/UWA_Library_standards_for_Acrobat_8.pdf";
	private static final String URL2="http://www.just.edu.jo/~mqais/CIS99/PDF/Ch.01_Introduction_%20to_computers.pdf";
	private static final String URL3="https://enauczanie.pg.edu.pl/moodle/pluginfile.php/305313/mod_resource/content/1/01%20Introduction.pdf";
	private static final String URL4="https://cran.r-project.org/doc/manuals/r-release/R-intro.pdf";
	public static void main(String[] args) {
		ExecutorService pool=Executors.newFixedThreadPool(3);
		pool.execute(new DownloadTaskRunnable(URL1));
		pool.execute(new DownloadTaskRunnable(URL2));
		pool.execute(new DownloadTaskRunnable(URL3));
		pool.execute(new DownloadTaskRunnable(URL4));
		pool.shutdown();
		try {
			if(pool.awaitTermination(15, TimeUnit.SECONDS)) {
				System.out.println("Pobrano elegancko.");
			}else {
					System.out.println("Uplynal limit czasu");
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}


