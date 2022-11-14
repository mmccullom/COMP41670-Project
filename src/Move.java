public class Move {
	
	private int srcCol;
	private int destCol;
	private int spaces;
	private boolean removeOpponent;
	private boolean dieOne;
	
	
	public Move(int srcCol, int destCol, boolean removeOpponent, boolean d1) {
		this.srcCol = srcCol;
		this.destCol = destCol;
		this.spaces = srcCol-destCol;
		this.removeOpponent = removeOpponent;
		this.dieOne = d1;
	}
	
	public int getSrcCol() {
		return(srcCol);
	}
	
	public int getDestCol() {
		return(destCol);
	}
	
	public String toString() {
		return("Move piece from col " + (srcCol) + " to col " + (destCol));
	}
	
	public boolean getRemoveOpponent() {
		return(removeOpponent);
	}
	
	public boolean isDieOne() {
		return(dieOne);
	}
}
