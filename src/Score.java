public class Score {
	
	private int player1Score;
	private int player2Score;
	private String player1Name;
	private String player2Name;
	private boolean player1HasCube;
	private boolean player2HasCube;
	private int stake;
	private int length;
	
	public Score(String name1, String name2, int l) {
		player1Score = 0;
		player2Score = 0;
		player1Name = name1;
		player2Name = name2;
		player1HasCube = false;
		player2HasCube = false;
		stake = 1;
		length = l;
	}
	
	public int getPlayer1Score() {
		return(player1Score);
	}
	
	public int getPlayer2Score() {
		return(player2Score);
	}
	
	public int getStake() {
		return(stake);
	}
	
	public String getPlayer1Name() {
		return(player1Name);
	}
	
	public String getPlayer2Name() {
		return(player2Name);
	}
	
	public boolean getPlayer1HasCube() {
		return(player1HasCube);
	}
	
	public boolean getPlayer2HasCube() {
		return(player2HasCube);
	}
	
	public void doubleStake() {
		stake*=2;
	}
	
	public void incrementPlayer1Score(int multiplier) {
		player1Score+=stake*multiplier;
		stake=1;
		player1HasCube=false;
		player2HasCube=false;
	};
	
	public void incrementPlayer2Score(int multiplier) {
		player2Score+=stake*multiplier;
		stake=1;
		player1HasCube=false;
		player2HasCube=false;
	};
	
	public void givePlayer1Cube() {
		player1HasCube = true;
		player2HasCube = false;
	}
	
	public void givePlayer2Cube() {
		player1HasCube = false;
		player2HasCube = true;
	}
	
	public int getLength() {
		return(length);
	}

	public String toString() {
		return  (getPlayer1HasCube() ? "[D] " : "") + 
				getPlayer1Name() + ": " + getPlayer1Score() + " | "
				+ (getPlayer2HasCube() ? "[D] " : "") + getPlayer2Name()
				+ ": " + getPlayer2Score() + " | Match Length: " + length +"\n";
		
	}
	
	public String toStringWithStake() {
		return  (getPlayer1HasCube() ? "[D] " : "") + 
				getPlayer1Name() + ": " + getPlayer1Score() + " | "
				+ (getPlayer2HasCube() ? "[D] " : "") + getPlayer2Name()
				+ ": " + getPlayer2Score()+ " | Current Stake: " + getStake()
				+ " | Match Length: " + length + "\n";
	}
	
}
