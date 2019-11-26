import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) throws ExecutionException {
		List<Future<Info>> futureList=new ArrayList<>();
		ExecutorService pool=Executors.newFixedThreadPool(10);
		
		CopyMatrix cm = new CopyMatrix();
		for(int i=0;i<10;i++) {
			futureList.add(pool.submit(new Task(cm)));
		}
		pool.shutdown();
		

		try {
			if(pool.awaitTermination(30, TimeUnit.SECONDS)) {
				
				for(int i : futureList.stream().findFirst().get().get().getTab()) {
					System.out.println(i);
				} 
			}
			else{
				System.out.println("UpupÅ‚ynal limit czasu");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
