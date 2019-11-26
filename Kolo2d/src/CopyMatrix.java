import java.util.Random;

public class CopyMatrix {
	public static int TAB_SIZE =100;
	private final int[] tabA;
	private final int[] tabB;
	private final Random r = new Random();
			
	public CopyMatrix() {
		super();
		tabA = new int[TAB_SIZE];
		tabB = new int[TAB_SIZE];
		for(int i=0;i<TAB_SIZE;i++) {
			tabA[i]=1;
			tabB[i]=0;
		}
	}
	
	
	public int[] getTabB() {
		return tabB;
	}

	public synchronized void moveElement() {
		int randomIndexA = r.nextInt(TAB_SIZE);
		int randomIndexB = r.nextInt(TAB_SIZE);
		
		if(tabB[randomIndexB] != tabA[randomIndexA]) {
			System.out.println("watek "+ Thread.currentThread().getName() + "następuje przeniesienie elelemntu z a o indexie "+ randomIndexA + "do b o indexie" + randomIndexB);
			tabB[randomIndexB] = tabA[randomIndexA];
		}
	}
	
	public synchronized boolean matrixFilleed() {
		for(int i : tabB) {
			if(i==0) {
				return false;
			}
		}
		return true;
	}
	

	
	
}
