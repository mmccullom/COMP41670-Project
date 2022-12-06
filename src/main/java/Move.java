public class Move {
	
	private int srcCol;
	private int destCol;
	private boolean removeOpponent;
	private boolean dieOne;
	
	private static final int WHITE_HOME = 0;
	private static final int BLACK_HOME = 25;
	private static final int BLACK_RESERVE = 26;
	private static final int WHITE_RESERVE = 27;
	
	
	/**
	 * Constructor for a move, validation does not take place here but
	 * rather in the validation class
	 * 
	 * @param srcCol			Checker source column
	 * @param destCol			Checker destination column
	 * @param removeOpponent	Will the move remove the opponent?
	 * @param d1				Was first die used?
	 */
	public Move(int srcCol, int destCol, boolean removeOpponent, boolean d1) {
		this.srcCol = srcCol;
		this.destCol = destCol;
		this.removeOpponent = removeOpponent;
		this.dieOne = d1;
	}

	public int getSrcCol() {
		return(srcCol);
	}
	
	public int getDestCol() {
		return(destCol);
	}
	
	@Override
	public String toString() {
		
		String source;
		String dest;
		
		switch (srcCol) {
			case WHITE_HOME:
				source = "white home";
				break;
			case BLACK_HOME:
				source = "black home";
				break;
			case BLACK_RESERVE:
				source = "black reserve";
				break;
			case WHITE_RESERVE:
				source = "white reserve";
				break;
			default:
				source = "col " + srcCol;
		}
		
		switch (destCol) {
			case WHITE_HOME:
				dest = "white home";
				break;
			case BLACK_HOME:
				dest = "black home";
				break;
			case BLACK_RESERVE:
				dest = "black reserve";
				break;
			case WHITE_RESERVE:
				dest = "white reserve";
				break;
			default:
				dest = "col " + destCol;
			
		}
		
		return("Move piece from " + source + " to " + dest);
	}
	
	public boolean getRemoveOpponent() {
		return(removeOpponent);
	}
	
	public boolean isDieOne() {
		return(dieOne);
	}
}
