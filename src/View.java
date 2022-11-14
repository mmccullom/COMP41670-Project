import java.util.ArrayList;
import java.util.Stack;

public class View {
	
	public static void display(String currentPlayer, Board b) {
		ArrayList<Stack<Checker>> cols = b.getCols();
		int maxTopHeight = 0;
		int maxBottomHeight = 0;
		for (int i=1; i<=12; i++) {
			if(cols.get(i).size()>maxBottomHeight)
				maxBottomHeight = cols.get(i).size();
		}
		
		for (int i=13; i<=24; i++) {
			if(cols.get(i).size()>maxTopHeight)
				maxTopHeight = cols.get(i).size();
		}
		
		System.out.printf("\n%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n\n", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
		for (int j=0; j<maxTopHeight; j++) {
			for (int i=13; i<=24; i++) {
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
			for (int i=12; i>=1; i--) {
				try {
					System.out.printf("%-10s", " " + cols.get(i).get(j));
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.printf("%-10s", " ");
				}
			}
			System.out.println();
		}
		
		System.out.printf("\n%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n\n", "12", "11", "10", " 9", " 8", " 7", " 6", " 5", " 4", " 3", " 2", " 1");
		if (!cols.get(26).empty())
			System.out.println("Black Reserve" + cols.get(26).toString());
		if (!cols.get(27).empty())
			System.out.println("White Reserve" + cols.get(27).toString());
		System.out.println("Current Player: " + currentPlayer);
	}

}
