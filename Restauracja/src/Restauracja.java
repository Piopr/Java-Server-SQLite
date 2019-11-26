
public class Restauracja {
	private int  stosTalerzy[];//[0] - czyste, [1] - brudne
	private int ileNaRaz = 10;
	static int krok =0;
	
	public int getIleNaRaz() {
		return ileNaRaz;
	}

	public Restauracja(int ileTalerzy) {
		stosTalerzy = new int[2];
		stosTalerzy[0] = ileTalerzy;
		stosTalerzy[1] = ileTalerzy;
	}
	
	public synchronized void ubrudz(int ile) throws InterruptedException{
		
		while(stosTalerzy[0]<ile) {
			wait();
		}
		stosTalerzy[0]-=ile;
		System.out.println("Watek: "+Thread.currentThread().getName()+
				" ubrudzil talerze w liczbie: "+ ile);
		stosTalerzy[1]+=ile;
		krok++;
		System.out.println("Czyste:"+getCzyste()+" brudne: "+getBrudne() +" krok: "+Restauracja.krok);
		
		notifyAll();
	}

	public synchronized void umyj(int ile) throws InterruptedException{
		while(stosTalerzy[0]<ile) {
			wait();
		}
		stosTalerzy[1]-=ile;
		System.out.println("Watek: "+Thread.currentThread().getName()+
				" umyl talerze w liczbie: "+ ile);
		stosTalerzy[0]+=ile;
		krok++;
		System.out.println("Czyste:"+getCzyste()+" brudne: "+getBrudne()+" krok: "+Restauracja.krok);
		
		notifyAll();	
	}
	
	public synchronized int getCzyste() {
		return this.stosTalerzy[0];
	}
	public synchronized int getBrudne() {
		return this.stosTalerzy[1];
	}
	public synchronized boolean czyPelny() {
		if((stosTalerzy[0]==stosTalerzy[0]+stosTalerzy[1]) || (stosTalerzy[1]==stosTalerzy[0]+stosTalerzy[1])) {
			return true;} else {
				return false;
		}
	}
}
