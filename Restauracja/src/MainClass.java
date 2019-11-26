import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) {		
		Restauracja rest = new Restauracja(100);
		ExecutorService pool = Executors.newFixedThreadPool(10);
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.execute(new Kelner(rest));
		pool.shutdown();
		try {
			if(pool.awaitTermination(20, TimeUnit.SECONDS)) {
				System.out.println("Cos sie popsulo");
			} else {
				System.out.println("Zakonczono robotki na talerzach");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
//		for(int i=0; i<10; i++) {
//			Thread t = new Thread(new Kelner(rest));
//			t.start();
//			
//		}

	}

}
