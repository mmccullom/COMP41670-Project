public class Checker {

	private boolean black;
	private boolean white;

	/**
	 * Create checker object in one of two colors
	 * 
	 * @param color			Must be 'b' or 'w' 
	 * @throws Exception	Thrown when color parameter is invalid
	 */
	public Checker(char color) throws Exception{
		if (color == 'w') {
			black = false;
			white = true;
		}
		else if (color == 'b') {
			black = true;
			white = false;
		}
		else
			throw new Exception("Invalid Color");
	}

	public boolean isBlack() {
		return(black);
	}
	
	public boolean isWhite() {
		return(white);
	}

	@Override
	public String toString() {
		if (black)
			return("B");
		else
			return("W");
	}

}
