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

		Die die = new Die();
		
		boolean player1Going = true;

		
		while (!b.checkWin()) {
			b.printBoard(player1Going ? player1 : player2);
			
			System.out.print("\nEnter Command: ");

			String entry = scanner.nextLine();
			Command command = new Command(entry);
			
			if (command.isRoll()) {
				b.roll(die);
				player1Going = !player1Going;
			} else if (command.isQuit()) {
				b.quit();
			} else if (command.isMove()) {
				b.move();
			}

		}

	}
}