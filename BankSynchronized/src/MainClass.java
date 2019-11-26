
public class MainClass {

	public static void main(String[] args) {
		Bank bank = new Bank(100);
		for(int i=0; i<100; i++) {
			Thread t = new Thread(new User(i, bank));
			t.start();
		}

	}

}
