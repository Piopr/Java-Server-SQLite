import java.sql.Time;

public class Bank {
	private int accountMax;
	private int[] accounts;
	private int maxAmount=1000;
	public int getMaxAmount() {
		return maxAmount;
	}

	
	public Bank(int accountMax) {
		super();
		this.accountMax = accountMax;
		accounts=new int[accountMax];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i]=maxAmount;
		}
	}
	
	public synchronized void Transfer(int from, int to, int amount) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		while(accounts[from]<amount) {
			wait();
		}
		accounts[from]-=amount;
		System.out.println("Watek "+Thread.currentThread().getName()+"zrobil przelew z "+from+" na "+to);
		accounts[to]+=amount;
		System.out.println("Saldo: "+getBalance());
		notifyAll();
		long endTime=System.currentTimeMillis();
		System.out.println(">>"+(int)(endTime-startTime));	
		
	}
	
	public synchronized int getBalance() {
		int suma =0;
		for (int i : this.accounts) {
			suma+=i;
		}
		return suma;
	}
	
	public int getAccountMax() {
		return accountMax-1;
	}
	


}
