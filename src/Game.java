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

		boolean quit = false;

		
		while (!b.checkWin()&&!quit) {
			b.printBoard();

			System.out.print("\nEnter Command: ");

			String command = scanner.nextLine();
			Command command1 = new Command(command);
			boolean commandDone= false;

			do {
				if (command1.isRoll()) {
					System.out.print("You have rolled: "+dice.roll() + "\n");
					commandDone = true;

				} else if (command1.isQuit()) {
					quit = true;
					commandDone = true;
				}

			} while (!commandDone);


		}

	}
}
