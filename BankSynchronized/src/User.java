import java.util.Random;

public class User implements Runnable{
	private int accountNo;
	private Bank bank;
	
	public User(int accountNo, Bank bank) {
		this.accountNo = accountNo;
		this.bank = bank;
	}

	@Override
	public void run() {
		Random r = new Random();
		while(true) {
			int toAccount = r.nextInt(bank.getAccountMax());
			int amount = r.nextInt(bank.getMaxAmount());
			try {
				bank.Transfer(accountNo, toAccount, amount);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
