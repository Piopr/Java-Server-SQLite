import java.util.Random;

public class User implements Runnable{

	private int nrKonta;
	private Bank bank;
	public User(int nrKonta, Bank bank) {
		super();
		this.nrKonta = nrKonta;
		this.bank = bank;
	}
@Override
public void run() {
	Random r = new Random();
	while(true) {
		int transferTo = r.nextInt(bank.getIloscKont());
		int transferKwota = r.nextInt(bank.getMaxKwota()+1);	
		bank.transfer(this.nrKonta, transferTo, transferKwota);
		try {			
			Thread.currentThread().sleep(100);
		} catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
	
}
