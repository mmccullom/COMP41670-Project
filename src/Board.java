import java.util.ArrayList;
import java.util.Stack;

public class Board {
	private ArrayList<Stack<Checker>> cols;
	private static final int colNum = 24;

	public Board() throws Exception {
		cols = new ArrayList<>(24);
		for (int i=0; i < colNum; i++) {
			cols.add(new Stack<Checker>());
		}

		// Set up columns of 2
		for (int i=0; i<2; i++) {
			cols.get(0).add(new Checker('w'));
			cols.get(23).add(new Checker('b'));
		}

		// Set up columns of 3
		for (int i=0; i<3; i++) {
			cols.get(7).add(new Checker('b'));
			cols.get(16).add(new Checker('w'));
		}

		// Set up columns of 5
		for (int i=0; i<5; i++) {
			cols.get(5).add(new Checker('b'));
			cols.get(11).add(new Checker('w'));
			cols.get(12).add(new Checker('b'));
			cols.get(18).add(new Checker('w'));
		}
	}

	public void showstuff() {
		for (int i=0; i<colNum; i++) {
			System.out.print(i + ": ");
			System.out.print(cols.get(i));
			System.out.println();
		}
	}

}
