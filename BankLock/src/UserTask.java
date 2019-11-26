import java.util.Random;

public class UserTask implements Runnable{
	private int nrKonta;
	private Bank bank;
	
	public UserTask(int nrKonta, Bank bank) {
		super();
		this.nrKonta = nrKonta;
		this.bank = bank;
	}

	@Override
	public void run() {
		Random r = new Random();
		while(true) {
			int to = r.nextInt(bank.getIloscKont());
			int kwota = r.nextInt(bank.getMaxKwota());			
			try {
				bank.transfer(nrKonta, to, kwota);
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
