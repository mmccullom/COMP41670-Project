public class Die {

	private int val;

	public Die() {
		val = (int) Math.ceil(Math.random()*6);
	}

	public int roll() {
		val = (int) Math.ceil(Math.random()*6);
		return(val);
	}


	public int getVal() {
		return(val);
	}
}