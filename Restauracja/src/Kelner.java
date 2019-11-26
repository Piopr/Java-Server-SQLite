import java.util.Random;

public class Kelner implements Runnable {
	private Restauracja rest;
	
	public Kelner(Restauracja rest) {
		this.rest = rest;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		while(/*!(rest.czyPelny())*/ true) {
			int ileTalerzy = r.nextInt(rest.getIleNaRaz());
			int brudzCzyCzysc = r.nextInt(2);
			try {
			if(brudzCzyCzysc == 0) {
				rest.ubrudz(ileTalerzy);
			}else {
				rest.umyj(ileTalerzy);
			}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		//System.out.println("JEDEN ZE STOSOW PELNY!");
		//Thread.currentThread().stop();
		

	}

}
