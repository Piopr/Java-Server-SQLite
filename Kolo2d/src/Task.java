import java.util.concurrent.Callable;

public class Task implements Callable<Info> {
	private final CopyMatrix cm;
	
	public Task(CopyMatrix cm) {
		super();
		this.cm = cm;
	}

	@Override
	public Info call() throws Exception {
		while(cm.matrixFilleed()) {
			cm.moveElement();
			//Thread.currentThread().sleep(100);
			System.out.println("Watek " + Thread.currentThread().getName() + "Wykonuje zadanie");

		}
		return new Info(cm.getTabB());
	}

}

class Info{
	int tab[];
	
	public Info(int[] tab) {
		this.tab = tab;
	}
	
	public int[] getTab() {
		return tab;
	}
	
	public void printTab() {
		for(int i:tab) {
			System.out.println(i);
		}
	}
}