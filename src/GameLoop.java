import java.util.ArrayList;
import java.util.Scanner;

public class GameLoop {
	
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
	
	public static String getString(Scanner scanner) {
		String selection = scanner.nextLine().toUpperCase().substring(0,1);
		if ("A".equals(selection) | "R".equals(selection))
			return(selection);
		else {
			System.out.print("\nInvalid, please enter 'A'/'R': ");
			return(getString(scanner));
		}
	}
	
	public static void play(Board b, Score score, Die die1, Die die2,
			Scanner scanner, boolean player1Going, boolean rolled) {
		while (!b.checkWin()) {
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
			}
			else if (command.isDice()) {
				b.dice(die1, die2, command.getArg1(), command.getArg2());
				rolled = true;
			} else if (command.isQuit()) {
				b.quit();
			} else if (command.isPip()) {
				b.pip();
			} else if (command.isHint()) {
				b.hint();
			} else if (command.isMove()) {
				if (rolled) {
					if (die1.getVal()==die2.getVal()) {
						System.out.println("Doubles! Go four times");
						for (int i=0; i<=3; i++) {
							ArrayList<Move> moves = b.list(die1,  player1Going);
							if (moves.isEmpty()) {
								System.out.println("No available moves, press enter");
								scanner.nextLine();
								break;
							} else {
								System.out.print("\nSelect a move by number: ");
								int selection = getInteger(scanner, moves);
								b.move(moves.get(selection-1));
								if(i!=3)
									View.display(player1Going, b, score);
							}
						}
						rolled = false;
						player1Going = !player1Going;
						View.display(player1Going, b, score);
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
							View.display(player1Going, b, score);
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
						View.display(player1Going, b, score);
					}
				}
				else {
					System.out.println("Roll (R) before making a move");
				}
			}  else if (command.isDouble()){
				if (!rolled) {
					if ((player1Going && !score.getPlayer2HasCube()) | (!player1Going && !score.getPlayer1HasCube())) {
						System.out.println((player1Going ? score.getPlayer2Name() : score.getPlayer1Name()) + ", you have been offered a double");
						System.out.print("Do you choose to accept (A) or refuse and forfeit (R): ");
						String selection = getString(scanner);
						if (selection.equals("A")) {
							score.doubleStake();
							if (player1Going)
								score.givePlayer2Cube();
							else
								score.givePlayer1Cube();
							System.out.println("Stake doubled, " + (player1Going ? score.getPlayer2Name() : score.getPlayer1Name()) + " has doubling cube");
						} else {
							b.forfeit(player1Going);
						}
					} else {
						System.out.println("You are not eligible to double");
					}

					
				} else {
					System.out.println("You have already rolled");
				}
			}
		}
	}
}
