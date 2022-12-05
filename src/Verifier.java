import java.util.ArrayList;
import java.util.Stack;

public class Verifier {

	/**
	 * Return valid moves for a single die
	 * 
	 * @param cols		Board columns
	 * @param d1		Die value
	 * @param isBlack	Is player 2 moving?
	 * @return			List of valid moves for the die
	 */
	public static ArrayList<Move> checkMoves(ArrayList<Stack<Checker>> cols, int d1, boolean isBlack) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		boolean d1HomeMove=false;
		if (isBlack) {
			for (int i=1; i<=24; i++) {
				if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
					// First die moves
					if(i+d1 == 25) {
						if (isBlackFull(cols)) {
							validMoves.add(new Move(i, 25, false, true));
							d1HomeMove=true;
							}
						}
					else if(i+d1 > 25) {
						if (isBlackFull(cols) && d1HomeMove == false) {
							validMoves.add(new Move(i, 25, false, true));
							d1HomeMove=true;
							}
						}
					else if (cols.get(i+d1).empty())
						validMoves.add(new Move(i, i+d1, false, true));
					else if (cols.get(i+d1).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i+d1, false, true));
					else if ((cols.get(i+d1).peek().isBlack() != isBlack) && cols.get(i+d1).size()==1)
						validMoves.add(new Move(i, i+d1, true, true));
					}
				}
			} else {
				for(int i=24; i>=1; i--) {
					if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
						if(i-d1 == 0) {
							if (isWhiteFull(cols)) {
								validMoves.add(new Move(i, 0, false, true));
								d1HomeMove = true;
								}
							}
						else if(i-d1 < 0) {
							if (isWhiteFull(cols) && d1HomeMove == false) {
								validMoves.add(new Move(i, 0, false, true));
								d1HomeMove = true;
							}
						}
						else if (cols.get(i-d1).empty())
							validMoves.add(new Move(i, i-d1, false, true));
						else if (cols.get(i-d1).peek().isBlack() == isBlack)
							validMoves.add(new Move(i, i-d1, false, true));
						else if ((cols.get(i-d1).peek().isBlack() != isBlack) && cols.get(i-d1).size()==1)
							validMoves.add(new Move(i, i-d1, true, true));
						}
					}
				}
		return(validMoves);
	}
	
	/**
	 * Return valid moves for two die
	 * 
	 * @param cols		Board columns
	 * @param d1		Die 1 value
	 * @param d2		Die 2 value
	 * @param isBlack	Is player 2 going?
	 * @return			Valid moves for both die
	 */
	
	public static ArrayList<Move> checkMoves(ArrayList<Stack<Checker>> cols, int d1, int d2, boolean isBlack) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		boolean d1HomeMove = false;
		boolean d2HomeMove = false;
		if (isBlack) {
			for (int i=1; i<=24; i++) {
				if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
					// First die moves
					if(i+d1 == 25) {
						if (isBlackFull(cols)) {
							validMoves.add(new Move(i, 25, false, true));
							d1HomeMove=true;
							}
						}
					else if(i+d1 > 25) {
						if (isBlackFull(cols) && d1HomeMove == false) {
							validMoves.add(new Move(i, 25, false, true));
							d1HomeMove=true;
							}
						}
					else if (cols.get(i+d1).empty())
						validMoves.add(new Move(i, i+d1, false, true));
					else if (cols.get(i+d1).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i+d1, false, true));
					else if ((cols.get(i+d1).peek().isBlack() != isBlack) && cols.get(i+d1).size()==1)
						validMoves.add(new Move(i, i+d1, true, true));
					
					
					
					// Second die moves
					if(i+d2 == 25) {
						if (isBlackFull(cols)) {
							validMoves.add(new Move(i, 25, false, false));
							d2HomeMove=true;
							}
						}
					else if(i+d2 > 25) {
						if (isBlackFull(cols) && d2HomeMove == false) {
							validMoves.add(new Move(i, 25, false, false));
							d2HomeMove=true;
							}
						}
					else if (cols.get(i+d2).empty())
						validMoves.add(new Move(i, i+d2, false, false));
					else if (cols.get(i+d2).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i+d2, false, false));
					else if ((cols.get(i+d2).peek().isBlack() != isBlack) && cols.get(i+d2).size()==1)
						validMoves.add(new Move(i, i+d2, true, false));
					}
				}
			} else {
				for(int i=24; i>=1; i--) {
					if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
						
						// First die moves
						if(i-d1 == 0) {
							if (isWhiteFull(cols)) {
								validMoves.add(new Move(i, 0, false, true));
								d1HomeMove = true;
								}
							}
						else if(i-d1 < 0) {
							if (isWhiteFull(cols) && d1HomeMove == false) {
								validMoves.add(new Move(i, 0, false, true));
								d1HomeMove = true;
							}
						}
						else if (cols.get(i-d1).empty())
							validMoves.add(new Move(i, i-d1, false, true));
						else if (cols.get(i-d1).peek().isBlack() == isBlack)
							validMoves.add(new Move(i, i-d1, false, true));
						else if ((cols.get(i-d1).peek().isBlack() != isBlack) && cols.get(i-d1).size()==1)
							validMoves.add(new Move(i, i-d1, true, true));
						
						
						
						
						// Second die moves
						if(i-d2 == 0) {
							if (isWhiteFull(cols)) {
								validMoves.add(new Move(i, 0, false, false));
								d2HomeMove = true;
								}
							}
						else if(i-d2 < 0) {
							if (isWhiteFull(cols) && d2HomeMove == false) {
								validMoves.add(new Move(i, 0, false, false));
								d2HomeMove = true;
							}
						}
						else if (cols.get(i-d2).empty())
							validMoves.add(new Move(i, i-d2, false, false));
						else if (cols.get(i-d2).peek().isBlack() == isBlack)
							validMoves.add(new Move(i, i-d2, false, false));
						else if ((cols.get(i-d2).peek().isBlack() != isBlack) && cols.get(i-d2).size()==1)
							validMoves.add(new Move(i, i-d2, true, false));
						}
					}
				}
		return(validMoves);
	}
	
	/**
	 * When white has a checker in reserve and one die, these are the valid moves.
	 * 
	 * @param cols 	Board columns
	 * @param d1 	Die value
	 * @return 		Valid  reserve moves
	 */
	public static ArrayList<Move> whiteReserveMoves(ArrayList<Stack<Checker>> cols, int d1) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		if (cols.get(25-d1).empty())
			validMoves.add(new Move(27, 25-d1, false, true));
		else if (!cols.get(25-d1).peek().isBlack())
			validMoves.add(new Move(27, 25-d1, false, true));
		else if ((cols.get(25-d1).peek().isBlack()) && cols.get(25-d1).size()==1)
			validMoves.add(new Move(27, 25-d1, true, true));
		return(validMoves);
	}
	
	/**
	 * When black has a checker in reserve and one die, these are the valid moves.
	 * 
	 * @param cols 	Board columns
	 * @param d1	Die value
	 * @return		Valid reserve moves
	 */
	public static ArrayList<Move> blackReserveMoves(ArrayList<Stack<Checker>> cols, int d1) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		if (cols.get(d1).empty())
			validMoves.add(new Move(26, d1, false, true));
		else if (cols.get(d1).peek().isBlack())
			validMoves.add(new Move(26, d1, false, true));
		else if (!(cols.get(d1).peek().isBlack()) && cols.get(d1).size()==1)
			validMoves.add(new Move(26, d1, true, true));
		return(validMoves);
	}
	
	/**
	 * When white has a checker in reserve and two die, these are the valid moves
	 * 
	 * @param cols	Board columns
	 * @param d1	Die 1 value
	 * @param d2	Die 2 value
	 * @return		Valid reserve moves
	 */
	public static ArrayList<Move> whiteReserveMoves(ArrayList<Stack<Checker>> cols, int d1, int d2) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		
		if (cols.get(25-d1).empty())
			validMoves.add(new Move(27, 25-d1, false, true));
		else if (!cols.get(25-d1).peek().isBlack())
			validMoves.add(new Move(27, 25-d1, false, true));
		else if ((cols.get(25-d1).peek().isBlack()) && cols.get(25-d1).size()==1)
			validMoves.add(new Move(27, 25-d1, true, true));
		
		if (cols.get(25-d2).empty())
			validMoves.add(new Move(27, 25-d2, false, false));
		else if (!cols.get(25-d2).peek().isBlack())
			validMoves.add(new Move(27, 25-d2, false, false));
		else if ((cols.get(25-d2).peek().isBlack()) && cols.get(25-d2).size()==1)
			validMoves.add(new Move(27, 25-d2, true, false));
		
		return(validMoves);
	}
	
	/**
	 * When black has a checker in reserve and two die, these are the valid moves
	 * 
	 * @param cols	Board columns
	 * @param d1	Die 1 value
	 * @param d2	Die 2 value
	 * @return		Valid reserve moves
	 */
	public static ArrayList<Move> blackReserveMoves(ArrayList<Stack<Checker>> cols, int d1, int d2) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		
		if (cols.get(d1).empty())
			validMoves.add(new Move(26, d1, false, true));
		else if (cols.get(d1).peek().isBlack())
			validMoves.add(new Move(26, d1, false, true));
		else if (!(cols.get(d1).peek().isBlack()) && cols.get(d1).size()==1)
			validMoves.add(new Move(26, d1, true, true));

		if (cols.get(d2).empty())
			validMoves.add(new Move(26, d2, false, false));
		else if (cols.get(d2).peek().isBlack())
			validMoves.add(new Move(26, d2, false, false));
		else if (!(cols.get(d2).peek().isBlack()) && cols.get(d2).size()==1)
			validMoves.add(new Move(26, d2, true, false));
		
		return(validMoves);
	}
	
	/**
	 * Determine whether the game will result in a Backgammon
	 * 
	 * @param cols	Board columns
	 * @return		Are there any black checkers in the white home
	 */
	
	public static boolean blackInWhiteHome(ArrayList<Stack<Checker>> cols) {
		for (int i=1; i<=6; i++)
			if (!cols.get(i).empty() && cols.get(i).peek().isBlack())
				return(true);
		return(false);
	}
	
	/**
	 * Determine whether the game will result in a Backgammon
	 * 
	 * @param cols	Board columns
	 * @return		Are there any white checkers in the black home
	 */
	public static boolean whiteInBlackHome(ArrayList<Stack<Checker>> cols) {
		for (int i=19; i<=24; i++)
			if (!cols.get(i).empty() && cols.get(i).peek().isWhite())
				return(true);
		return(false);
	}
	
	/**
	 * Determine if black can begin bearing off
	 * 
	 * @param cols	Board columns
	 * @return		Are all black checkers in the black home
	 */
	private static boolean isBlackFull(ArrayList<Stack<Checker>> cols) {
		int count = 0;
		for (int i=19; i<=24; i++) {
			if(!cols.get(i).empty() && cols.get(i).peek().isBlack()) {
				count+=cols.get(i).size();
			}
		}
		return(count==(15-cols.get(25).size()));
	}
	
	/**
	 * Determine if white can begin bearing off
	 * 
	 * @param cols	Board columns
	 * @return		Are all the white checkers in the white home
	 */
	private static boolean isWhiteFull(ArrayList<Stack<Checker>> cols) {
		int count = 0;
		for (int i=1; i<=6; i++) {
			if(!cols.get(i).empty() && cols.get(i).peek().isWhite()) {
				count+=cols.get(i).size();
			}
		}
		return(count==(15-cols.get(0).size()));
	}
	
}
