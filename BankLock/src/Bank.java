import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private int iloscKont;
	private int[] konta;
	private int maxKwota = 1000;
	private ReentrantLock lock;
	private Condition wystSrodki;
	

	int getIloscKont() {
		return this.iloscKont-1;
	}
	int getMaxKwota() {
		return this.maxKwota;
	}
	
	public Bank(int iloscKont) {		
		this.iloscKont = iloscKont;
		konta=new int[iloscKont];
		for (int i=0; i<iloscKont; i++) {
			konta[i]=maxKwota;
		}
		lock = new ReentrantLock();
		wystSrodki = lock.newCondition();
		
	
	}
	
	void transfer(int from, int to, int kwota) throws InterruptedException {
		long startTime=System.currentTimeMillis();
		lock.lock();//czekaj, do konca wykonania metody
		try {
		while (konta[from]<kwota) {
			wystSrodki.await();//warunek niespelniony, czekaj na notifyall
		}
		assert konta[from]>=kwota;
		konta[from]-= kwota;
		System.out.println("przelano na: "+ to+" w¹tek: "+ Thread.currentThread().getName());
		konta[to]+= kwota;
		System.out.println("Saldo: "+getBalance());
		wystSrodki.signalAll();
		} finally {
			lock.unlock();
		}
		long endTime=System.currentTimeMillis();
		System.out.println(">>"+(int)(endTime-startTime));		
	}


	
	
	int getBalance() {
		int suma =0;
		for (int i : this.konta) {
			suma+=i;
		}
		return suma;
	}
	


}
