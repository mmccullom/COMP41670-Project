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

	public boolean checkWin() {
		return(false);
	}
	
	public void roll(Die die) {
		int val1 = die.roll();
		int val2 = die.roll();

		int total = val1 + val2;

		System.out.print("Dice 1: "+ val1 + "\nDice 2: " + val2 + "\n");
		System.out.print("Total Roll Value: " + total + "\n");
	}
	
	public void quit() {
		System.out.println("Exiting Game");
		System.exit(0);
	}
	
	public void printBoard(String currentPlayer) {
		int maxTopHeight = 0;
		int maxBottomHeight = 0;
		for (int i=0; i<=11; i++) {
			if(cols.get(i).size()>maxBottomHeight)
				maxBottomHeight = cols.get(i).size();
		}
		
		for (int i=12; i<=23; i++) {
			if(cols.get(i).size()>maxTopHeight)
				maxTopHeight = cols.get(i).size();
		}
		
		System.out.printf("\n%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n\n", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
		for (int j=0; j<maxTopHeight; j++) {
			for (int i=12; i<=23; i++) {
				try {
					System.out.printf("%-10s", " " + cols.get(i).get(j));
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.printf("%-10s", " ");
				}
			}
			System.out.println();
		}
		
		System.out.printf("\n\n%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n\n", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--", "--");
		
		for (int j=maxBottomHeight; j>=0; j--) {
			for (int i=11; i>=0; i--) {
				try {
					System.out.printf("%-10s", " " + cols.get(i).get(j));
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.printf("%-10s", " ");
				}
			}
			System.out.println();
		}
		
		System.out.printf("\n%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n\n", "12", "11", "10", " 9", " 8", " 7", " 6", " 5", " 4", " 3", " 2", " 1");
		System.out.println("Current Player: " + currentPlayer);
	}

	public void move() {
		// TODO Auto-generated method stub
		
	}

}
