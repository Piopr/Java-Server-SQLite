
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank(100);
		for(int i = 0; i<100; i++) {
			Thread t = new Thread(new UserTask(i, bank));
			t.start();
		}
	}

}
