import java.util.ArrayList;
import java.util.Stack;

public class Verifier {

	public static ArrayList<Move> checkMoves(ArrayList<Stack<Checker>> cols, int d1, boolean isBlack) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		for (int i=24; i>=1; i--) {
			if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
				if (isBlack) {
					if(i+d1 > 24) {
						if (isBlackFull(cols))
							validMoves.add(new Move(i, 25, false, false));
					}
					else if (cols.get(i+d1).empty())
						validMoves.add(new Move(i, i+d1, false, false));
					else if (cols.get(i+d1).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i+d1, false, false));
					else if ((cols.get(i+d1).peek().isBlack() != isBlack) && cols.get(i+d1).size()==1)
						validMoves.add(new Move(i, i+d1, true, false));
				} else {
					if(i-d1 < 1) {
							if (isWhiteFull(cols))
								validMoves.add(new Move(i, 0, false, false));
					}
					else if (cols.get(i-d1).empty())
						validMoves.add(new Move(i, i-d1, false, false));
					else if (cols.get(i-d1).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i-d1, false, false));
					else if ((cols.get(i-d1).peek().isBlack() != isBlack) && cols.get(i-d1).size()==1)
						validMoves.add(new Move(i, i-d1, true, false));
				}
			}
		}
		
		return(validMoves);
	}
	
	public static ArrayList<Move> checkMoves(ArrayList<Stack<Checker>> cols, int d1, int d2, boolean isBlack) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
			
		
		for (int i=24; i>=1; i--) {
			if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
				if (isBlack) {
					
					
					
					// First die moves
					if(i+d1 > 24) {
						if (isBlackFull(cols))
							validMoves.add(new Move(i, 25, false, true));
					}
					else if (cols.get(i+d1).empty())
						validMoves.add(new Move(i, i+d1, false, true));
					else if (cols.get(i+d1).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i+d1, false, true));
					else if ((cols.get(i+d1).peek().isBlack() != isBlack) && cols.get(i+d1).size()==1)
						validMoves.add(new Move(i, i+d1, true, true));
					
					
					
					// Second die moves
					if(i+d2 > 24) {
						if (isBlackFull(cols))
							validMoves.add(new Move(i, 25, false, false));
					}
					else if (cols.get(i+d2).empty())
						validMoves.add(new Move(i, i+d2, false, false));
					else if (cols.get(i+d2).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i+d2, false, false));
					else if ((cols.get(i+d2).peek().isBlack() != isBlack) && cols.get(i+d2).size()==1)
						validMoves.add(new Move(i, i+d2, true, false));
					
					
				} else {
					
					
					if(i-d1 < 1) {
						if (isWhiteFull(cols))
							validMoves.add(new Move(i, 0, false, true));
					}
					else if (cols.get(i-d1).empty())
						validMoves.add(new Move(i, i-d1, false, true));
					else if (cols.get(i-d1).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i-d1, false, true));
					else if ((cols.get(i-d1).peek().isBlack() != isBlack) && cols.get(i-d1).size()==1)
						validMoves.add(new Move(i, i-d1, true, true));
					
					
					
					
					// Second die moves
					if(i-d2 < 1) {
							if (isWhiteFull(cols))
								validMoves.add(new Move(i, 0, false, false));
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
	
	
	private static boolean isBlackFull(ArrayList<Stack<Checker>> cols) {
		int count = 0;
		for (int i=19; i<=24; i++) {
			if(!cols.get(i).empty() && cols.get(i).peek().isBlack()) {
				count+=cols.get(i).size();
			}
		}
		return(count==(15-cols.get(25).size()));
	}
	
	
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
