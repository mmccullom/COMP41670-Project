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

		
		Score score = new Score(player1, player2);
		
		Board b = new Board();

		Die die1 = new Die();
		Die die2 = new Die();
		
		
		
		boolean player1Going = b.start(player1, player2, die1, die2);
		boolean rolled = true;
		boolean keepPlaying = true;
		View.display(player1Going, b, score);
	
		while(keepPlaying) {
			
			GameLoop.play(b, score, die1, die2, scanner, player1Going, rolled);
			
			if (b.getPlayer1Win()) {
				System.out.println(player1 + " Wins!");
				int multiplier = b.winMultiplier();
				if (multiplier==2)
					System.out.println("Gammon Win! x2 Points");
				if (multiplier==3)
					System.out.println("Backgammon Win! x3 Points");
				score.incrementPlayer1Score(multiplier);
			}
			else {
				System.out.println(player2 + " Wins!");
				int multiplier = b.winMultiplier();
				if (multiplier==2)
					System.out.println("Gammon Win! x2 Points");
				if (multiplier==3)
					System.out.println("Backgammon Win! x3 Points");
				score.incrementPlayer2Score(multiplier);
			}
			System.out.print(score.toString());
			System.out.println("Do you want to continue playing (Y) or not (any other key): ");
			String selection = scanner.nextLine().toUpperCase();
			if ("Y".equals(selection)) {
				System.out.println("\n\n\nNEW GAME\n\n\n");
				b = new Board();
				player1Going = b.start(player1, player2, die1, die2);
				rolled = true;
				View.display(player1Going, b, score);
				
			} else
				keepPlaying = false;
		}
		System.out.println("\n\n\nFinal Score: " + score.toString());
		scanner.close();
	}
}