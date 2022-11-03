import java.util.Scanner;

public class Game {
	private static String player1;
	private static String player2;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Backgammon");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nPlayer 1 Enter Name: ");
		player1 = scanner.nextLine();
		System.out.print("\nPlayer 2 Enter Name: ");
		player2 = scanner.nextLine();
		
		Board b = new Board();

		Die dice = new Die();
		int val1;
		int val2;
		int total;

		boolean quit = false;

		
		while (!b.checkWin()&&!quit) {
			b.printBoard();

			System.out.print("\nEnter Command: ");

			String entry = scanner.nextLine();
			Command command = new Command(entry);
			if (command.isRoll()) {
				val1 = dice.roll();
				val2 = dice.roll();

				total = val1 + val2;

				System.out.print("Dice 1: "+ val1 + "\nDice 2: " + val2 + "\n");
				System.out.print("Total Roll Value: " + total + "\n");

			} else if (command.isQuit()) {
				quit = true;
			}
		}
		
		if (quit)
			System.out.println("Quitting Game");

	}
}