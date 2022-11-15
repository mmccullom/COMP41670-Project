import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private static String player1;
	private static String player2;
	
	public static int getInteger(Scanner scanner, ArrayList<Move> moves) {
		int selection = 0;
		try {
			selection = Integer.parseInt(scanner.nextLine());
			moves.get(selection-1);
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			System.out.print("\nInvalid move, enter another move: ");
			return(getInteger(scanner, moves));
		}
		return (selection);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Backgammon");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlayer 1 Enter Name: ");
		player1 = scanner.nextLine();
		System.out.print("\nPlayer 2 Enter Name: ");
		player2 = scanner.nextLine();
		
		Board b = new Board();

		Die die1 = new Die();
		Die die2 = new Die();
		
		boolean player1Going = b.start(player1, player2, die1, die2);
		boolean rolled = true;
		
		player1 += " (W)";
		player2 += " (B)";
		
		while (!b.checkWin()) {
			View.display(player1Going ? player1 : player2, b);
			
			System.out.print("\nEnter Command: ");


			String entry = scanner.nextLine();

			Command command = new Command(entry);
			
			if (command.isRoll()) {
				if (!rolled) {
					b.roll(die1, die2);
					rolled = true;
				} else {
					System.out.println("You have already rolled");
				}
			} else if (command.isQuit()) {
				b.quit();
			} else if (command.isPip()) {
				b.pip();
			} else if (command.isMove()) {
				if (rolled) {//IndexOutOfBoundsException NumberFormatException
					if (die1.getVal()==die2.getVal()) {
						System.out.println("Doubles! Go four times");
						for (int i=0; i<=3; i++) {
							ArrayList<Move> moves = b.list(die1,  player1Going);
							if (moves.isEmpty()) {
								System.out.println("No available moves, press enter");
								scanner.nextLine();
							} else {
								System.out.print("\nSelect a move by number: ");
								int selection = getInteger(scanner, moves);
								b.move(moves.get(selection-1));
								if (i!=3)
									View.display(player1Going ? player1 : player2, b);
							}
						}
						rolled = false;
						player1Going = !player1Going;
					} else {
						ArrayList<Move> moves = b.list(die1, die2, player1Going);
						if (moves.isEmpty()) {
							System.out.println("\nNo available moves, press enter");
							scanner.nextLine();
						} else {
							System.out.print("\nSelect a move by number: ");
							int selection = getInteger(scanner, moves);
							Move firstMove = moves.get(selection-1);						
							b.move(firstMove);
							View.display(player1Going ? player1 : player2, b);
							ArrayList<Move> moves2;
							if (firstMove.isDieOne()) {
								moves2 = b.list(die2, player1Going);
							} else {
								moves2 = b.list(die1, player1Going);
							}
							if (moves2.isEmpty()) {
								System.out.println("\nNo available moves, press enter");
								scanner.nextLine();
							} else {
								System.out.print("\nSelect a move by number: ");
								int selection2 = getInteger(scanner, moves2);
								Move secondMove = moves2.get(selection2-1);
								b.move(secondMove);	
							}
						}
						rolled = false;
						player1Going = !player1Going;
					}
				}
				else {
					System.out.println("Roll (R) before making a move");
				}
			}
		}
		scanner.close();
	}
}