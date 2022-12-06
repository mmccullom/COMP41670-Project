/**
 * Team name: Group 46
 * Student names: Mark Turley, Mike McCullom
 * GitHub IDs: @markturley123 & @mmccullom
 *
 */

import java.util.ArrayList;
import java.util.Stack;

public class Board {
	private ArrayList<Stack<Checker>> cols;
	private boolean forfeit = false;
	private boolean player1Win;
	private static final int WHITE_HOME = 0;
	private static final int BLACK_HOME = 25;
	private static final int BLACK_RESERVE = 26;
	private static final int WHITE_RESERVE = 27;
	private static final int COL_NUM = 28;

	/**
	 * Creates the default setup for the Backgammon board with checkers in
	 * the necessary locations 
	 * 
	 * @throws Exception Necessary for checker creation
	 */
	public Board() throws Exception {
		cols = new ArrayList<>();
		for (int i=0; i < COL_NUM; i++) {
			cols.add(new Stack<Checker>());
		}

		// Set up columns of 2
		for (int i=0; i<2; i++) {
			cols.get(1).add(new Checker('b'));
			cols.get(24).add(new Checker('w'));
		}

		// Set up columns of 3
		for (int i=0; i<3; i++) {
			cols.get(8).add(new Checker('w'));
			cols.get(17).add(new Checker('b'));
		}

		// Set up columns of 5
		for (int i=0; i<5; i++) {
			cols.get(6).add(new Checker('w'));
			cols.get(12).add(new Checker('b'));
			cols.get(13).add(new Checker('w'));
			cols.get(19).add(new Checker('b'));
		}
	}
	
	/**
	 * Check if the game has been completed
	 * 
	 * @return Whether or not a player has won the game
	 */
	public boolean checkWin() {
		if (forfeit)
			return(true);
		else if (cols.get(WHITE_HOME).size() == 15) {
			player1Win = true;
			return(true);
		}
		else if (cols.get(BLACK_HOME).size() == 15) {
			player1Win = false;
			return(true);
		}
		else
			return(false);
	}
	
	/**
	 * Check which player 1
	 * 
	 * @return Did player 1 win?
	 */
	public boolean getPlayer1Win() {
		return(player1Win);
	}
	
	/**
	 * Set the end of the game due to a forfeit
	 * 
	 * @param player1Win Did player1 win?
	 */
	public void forfeit(boolean player1Win) {
		this.player1Win = player1Win;
		forfeit = true;
	}
	
	/**
	 * Determine whether the game was a single, gammon, or Backgammon
	 * 
	 * @return 1x, 2x, 3x depending on final results of the game
	 */
	public int winMultiplier() {
		if (forfeit)
			return(1);
		else if (player1Win && cols.get(BLACK_HOME).size()==0) {
			if (cols.get(BLACK_RESERVE).size()!=0 || Verifier.blackInWhiteHome(cols)){
				return(3);
			} else
				return(2);
		} else if (!player1Win && cols.get(WHITE_HOME).size()==0) {
			if (cols.get(WHITE_RESERVE).size()!=0 || Verifier.whiteInBlackHome(cols)){
				return(3);
			} else
				return(2);
		} else
			return(1);
	}
	
	/**
	 * Determine which player is starting the game, continue rolling in case of a tie
	 * 
	 * @param name1	Player 1 name
	 * @param name2	Player 2 name
	 * @param die1	Die 1 object
	 * @param die2	Die 2 object
	 * @return		Is player 1 starting play
	 */
	public boolean start(String name1, String name2, Die die1, Die die2) {
		int val1 = die1.roll();
		int val2 = die2.roll();
		System.out.println(name1 + " rolls " + val1);
		System.out.println(name2 + " rolls " + val2);
		if (val1 > val2) {
			System.out.println(name1 + " Goes First");
			return true;
		} else if (val2 > val1) {
			System.out.println(name2 + " Goes First");
			return false;
		} else {
			return start(name1, name2, die1, die2);
		}
	}
	
	/**
	 * Roll both dice and display the results
	 * 
	 * @param die1 Die 1 object
	 * @param die2 Die 2 object
	 */
	public void roll(Die die1, Die die2) {
		int val1 = die1.roll();
		int val2 = die2.roll();

		System.out.print("Die 1: "+ val1 + "\nDie 2: " + val2 + "\n");
	}
	
	/**
	 * Set dice values for testing purposes
	 * 
	 * @param die1		Die 1 object
	 * @param die2		Die 2 object
	 * @param newVal1	Die 1 new value
	 * @param newVal2	Die 2 new value
	 */
	public void dice(Die die1, Die die2, int newVal1, int newVal2) {
		die1.setVal(newVal1);
		die2.setVal(newVal2);
		System.out.println("Setting new dice values");
		System.out.print("Die 1: "+ die1.getVal() + "\nDie 2: " + die2.getVal() + "\n");
	}
	
	/**
	 * Quit match
	 */
	public void quit() {
		System.out.println("Exiting Game");
		System.exit(0);
	}
	
	/**
	 * Perform the selected move on the board
	 * 
	 * @param m The move to be performed
	 */
	public void move(Move m) {
		if (m.getRemoveOpponent()) {
			Checker moving = cols.get(m.getDestCol()).pop();
			if (moving.isBlack())
				cols.get(BLACK_RESERVE).push(moving);
			else
				cols.get(WHITE_RESERVE).push(moving);
			cols.get(m.getDestCol()).push(cols.get(m.getSrcCol()).pop());
		} else {
			cols.get(m.getDestCol()).push(cols.get(m.getSrcCol()).pop());
		}
	}
	
	/**
	 * Determine all valid moves for the player with two die
	 * 
	 * @param die1			Die 1 object
	 * @param die2			Die 2 object
	 * @param player1Going	Is player 1 going?
	 * @return				List of valid moves for the dice values
	 */
	public ArrayList<Move> list(Die die1, Die die2, boolean player1Going) {
		ArrayList<Move> moves;
		if (player1Going && !cols.get(WHITE_RESERVE).empty())
			moves = Verifier.whiteReserveMoves(cols, die1.getVal(), die2.getVal());
		else if (!player1Going && !cols.get(BLACK_RESERVE).empty())
			moves = Verifier.blackReserveMoves(cols, die1.getVal(), die2.getVal());
		else
			moves =  Verifier.checkMoves(cols, die1.getVal(), die2.getVal(), !player1Going);;
		int count = 1;
		for (Move m : moves) {
			System.out.println(count + ": " + m.toString());
			count++;
		}
		return(moves);
	}
	
	/**
	 * Determine all valid moves for the player with one die
	 * @param die1			Die 1 object
	 * @param player1Going	Is player 1 going?
	 * @return				List of valid moves for the die value
	 */
	public ArrayList<Move> list(Die die1, boolean player1Going) {
		ArrayList<Move> moves;
		if (player1Going && !cols.get(WHITE_RESERVE).empty())
			moves = Verifier.whiteReserveMoves(cols, die1.getVal());
		else if (!player1Going && !cols.get(BLACK_RESERVE).empty())
			moves = Verifier.blackReserveMoves(cols, die1.getVal());
		else
			moves = Verifier.checkMoves(cols, die1.getVal(), !player1Going);
		int count = 1;
		for (Move m : moves) {
			System.out.println(count + ": " + m.toString());
			count++;
		}
		return(moves);
	}
	
	/**
	 * Return remaining pip count for both players
	 */
	public void pip() {
		int blackCount = 0;
		int whiteCount = 0;
		for (int i=1; i<=24; i++) {
			if (!cols.get(i).empty()) {
				if (cols.get(i).peek().isBlack())
					blackCount += (25-i) * cols.get(i).size();
				if (cols.get(i).peek().isWhite())
					whiteCount += i * cols.get(i).size();
			}
		}
		System.out.println("Black Pip: " + blackCount + "\nWhite Pipe: " + whiteCount);
	}
	
	/**
	 * Print all possible commands excluding test commands
	 */
	public void hint() {
		String[] nonTestCommands = {"ROLL (R)", "QUIT (Q)", "MOVE (M)", "PIP (P)", "HINT (H)"};
		for (String s : nonTestCommands) {
			System.out.println(s);
		}
	}
	

	
	public ArrayList<Stack<Checker>> getCols() {
		return(cols);
	}

}
