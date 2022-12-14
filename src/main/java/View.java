/**
 * Team name: Group 46
 * Student names: Mark Turley, Mike McCullom
 * GitHub IDs: @markturley123 & @mmccullom
 *
 */
import java.util.ArrayList;
import java.util.Stack;

public class View {
	
	/**
	 * Method for displaying board and score each turn
	 * 
	 * @param player1Going 	Is player 1 going?
	 * @param b				Current board object
	 * @param score			Current score object
	 */
	public static void display(boolean player1Going, Board b, Score score) {
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
			System.out.println("Black Reserve: " + cols.get(26).toString() + "\n");
		if (!cols.get(27).empty())
			System.out.println("White Reserve: " + cols.get(27).toString() + "\n");
		
		System.out.println(score.toStringWithStake());
		System.out.println("Current Player: " +  (player1Going ? score.getPlayer1Name() + " (W)" : score.getPlayer2Name() + " (B)"));
	}

}
