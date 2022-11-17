public class Die {

	private int val;

	public Die() {
		val = (int) Math.ceil(Math.random()*6);
	}

	public int roll() {
		val = (int) Math.ceil(Math.random()*6);
		return(val);
	}
	
	public void setVal(int newVal) {
		val = newVal;
	}


	public int getVal() {
		return(val);
	}
}