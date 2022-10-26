public class Checker {

	private boolean black;

	public Checker() {
		black = true;
	}

	public Checker(char color) throws Exception{
		if (color == 'w')
			black = false;
		else if (color == 'b')
			black = true;
		else
			throw new Exception("Invalid Color");
	}

	public boolean isBlack() {
		return(black);
	}

	@Override
	public String toString() {
		if (black)
			return("B");
		else
			return("W");
	}

}
