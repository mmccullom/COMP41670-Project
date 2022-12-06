/**
 * Team name: Group 46
 * Student names: Mark Turley, Mike McCullom
 * GitHub IDs: @markturley123 & @mmccullom
 *
 */
public class Die {

	private int val;

	/**
	 * Die assigned an intial random value upon creation
	 */
	public Die() {
		val = (int) Math.ceil(Math.random()*6);
	}

	/**
	 * Die assigned a new random value
	 * @return Value of roll
	 */
	public int roll() {
		val = (int) Math.ceil(Math.random()*6);
		return(val);
	}
	
	/**
	 * Testing purposes only
	 * @param newVal New die value
	 */
	public void setVal(int newVal) {
		val = newVal;
	}

	public int getVal() {
		return(val);
	}
}