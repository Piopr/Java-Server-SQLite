
public class Bank {
	private int iloscKont;
	private int[] konta;
	private int maxKwota = 1000;
	

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
	
	}
	
	void transfer(int from, int to, int kwota) {
	konta[to]+= kwota;
	System.out.println("przelano na: "+ to+" w¹tek: "+ Thread.currentThread().getName());
	konta[from]-= kwota;
	System.out.println("Saldo: "+getBalance());

	}
	
	int getBalance() {
		int suma =0;
		for (int i : this.konta) {
			suma+=i;
		}
		return suma;
	}
	


}
