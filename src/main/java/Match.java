/**
 * Team name: Group 46
 * Student names: Mark Turley, Mike McCullom
 * GitHub IDs: @markturley123 & @mmccullom
 *
 */
import java.util.Scanner;

public class Match {
	private static String player1;
	private static String player2;
	
	/**
	 * Main method for the entire match, asks if players wish to repeat at match conclusion
	 * 
	 * @param args 			Main method args
	 * @throws Exception 	Exception necessary for potential issues in board creation
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Backgammon");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the match length: ");
		int matchLength = 5;
		try {
			matchLength = Integer.parseInt(scanner.nextLine());
		} catch(Exception InputMismatchException) {
			System.out.println("Invalid entry, setting length to 5");
		}
		System.out.print("\nPlayer 1 Enter Name: ");
		player1 = scanner.nextLine();
		System.out.print("\nPlayer 2 Enter Name: ");
		player2 = scanner.nextLine();

		
		Score score = new Score(player1, player2, matchLength);
		
		Board b = new Board();

		Die die1 = new Die();
		Die die2 = new Die();
		
		
		
		boolean player1Going = b.start(player1, player2, die1, die2);
		boolean rolled = true;
		boolean keepPlaying = true;
		View.display(player1Going, b, score);
	
		while(keepPlaying) {
			
			Game.play(b, score, die1, die2, scanner, player1Going, rolled);
			
			// Player 1 wins the previous game
			if (b.getPlayer1Win()) {
				System.out.println(player1 + " Wins the game!");
				int multiplier = b.winMultiplier();
				if (multiplier==2)
					System.out.println("Gammon Win! x2 Points");
				if (multiplier==3)
					System.out.println("Backgammon Win! x3 Points");
				score.incrementPlayer1Score(multiplier);
			}
			
			// Player 2 wins the previous game
			else {
				System.out.println(player2 + " Wins the game!");
				int multiplier = b.winMultiplier();
				if (multiplier==2)
					System.out.println("Gammon Win! x2 Points");
				if (multiplier==3)
					System.out.println("Backgammon Win! x3 Points");
				score.incrementPlayer2Score(multiplier);
			}
			System.out.print(score.toString());
			
			// Match conclusion
			if (score.getPlayer1Score() >= matchLength || score.getPlayer2Score() >= matchLength) {
				if (b.getPlayer1Win())
					System.out.println(player1 + " Wins the match!");
				else
					System.out.println(player2 + " Wins the match!");
				System.out.println("Do you want to play another match (Y) or not (any other key): ");
				String selection = scanner.nextLine().toUpperCase();
				if ("Y".equals(selection)) {
					System.out.println("\n\n\nNEW MATCH\n\n\n");
					System.out.print("\nEnter the match length: ");
					try {
						matchLength = Integer.parseInt(scanner.nextLine());
					} catch(Exception InputMismatchException) {
						System.out.println("Invalid entry, keeping length the same");
					}
					b = new Board();
					player1Going = b.start(player1, player2, die1, die2);
					score = new Score(player1, player2, matchLength);
					rolled = true;
					View.display(player1Going, b, score);
				} else
					keepPlaying = false;
			} else {
				System.out.println("\n\n\nNEW GAME\n\n\n");
				b = new Board();
				player1Going = b.start(player1, player2, die1, die2);
				rolled = true;
				View.display(player1Going, b, score);
				
			}
			
		}
		System.out.println("\n\n\nFinal Score: " + score.toString());
		scanner.close();
	}
}