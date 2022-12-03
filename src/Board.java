import java.util.ArrayList;
import java.util.Stack;

public class Board {
	private ArrayList<Stack<Checker>> cols;
	private static final int WHITE_HOME = 0;
	private static final int BLACK_HOME = 25;
	private static final int BLACK_RESERVE = 26;
	private static final int WHITE_RESERVE = 27;
	private static final int COL_NUM = 28;

	public Board() throws Exception {
		cols = new ArrayList<>();
		for (int i=0; i < COL_NUM; i++) {
			cols.add(new Stack<Checker>());
		}

		// Set up columns of 2
		for (int i=0; i<2; i++) {
			cols.get(1).add(new Checker('b'));
			cols.get(24).add(new Checker('w'));
		}

		// Set up columns of 3
		for (int i=0; i<3; i++) {
			cols.get(8).add(new Checker('w'));
			cols.get(17).add(new Checker('b'));
		}

		// Set up columns of 5
		for (int i=0; i<5; i++) {
			cols.get(6).add(new Checker('w'));
			cols.get(12).add(new Checker('b'));
			cols.get(13).add(new Checker('w'));
			cols.get(19).add(new Checker('b'));
		}
	}

	public boolean checkWin() {
		if (cols.get(WHITE_HOME).size() == 15 || cols.get(BLACK_HOME).size() == 15)
			return(true);
		else
			return(false);
	}
	
	public boolean start(String name1, String name2, Die die1, Die die2) {
		int val1 = die1.roll();
		int val2 = die2.roll();
		System.out.println(name1 + " rolls " + val1);
		System.out.println(name2 + " rolls " + val2);
		if (val1 > val2) {
			System.out.println(name1 + " Goes First");
			return true;
		} else if (val2 > val1) {
			System.out.println(name2 + " Goes First");
			return false;
		} else {
			return start(name1, name2, die1, die2);
		}
	}
	
	public void roll(Die die1, Die die2) {
		int val1 = die1.roll();
		int val2 = die2.roll();

		System.out.print("Die 1: "+ val1 + "\nDie 2: " + val2 + "\n");
	}
	
	public void dice(Die die1, Die die2, int newVal1, int newVal2) {
		die1.setVal(newVal1);
		die2.setVal(newVal2);
		System.out.println("Setting new dice values");
		System.out.print("Die 1: "+ die1.getVal() + "\nDie 2: " + die2.getVal() + "\n");
	}
	
	public void quit() {
		System.out.println("Exiting Game");
		System.exit(0);
	}
	
	public void move(Move m) {
		if (m.getRemoveOpponent()) {
			Checker moving = cols.get(m.getDestCol()).pop();
			if (moving.isBlack())
				cols.get(BLACK_RESERVE).push(moving);
			else
				cols.get(WHITE_RESERVE).push(moving);
			cols.get(m.getDestCol()).push(cols.get(m.getSrcCol()).pop());
		} else {
			cols.get(m.getDestCol()).push(cols.get(m.getSrcCol()).pop());
		}
	}
	
	public ArrayList<Move> list(Die die1, Die die2, boolean player1Going) {
		ArrayList<Move> moves;
		if (player1Going && !cols.get(WHITE_RESERVE).empty())
			moves = Verifier.whiteReserveMoves(cols, die1.getVal(), die2.getVal());
		else if (!player1Going && !cols.get(BLACK_RESERVE).empty())
			moves = Verifier.blackReserveMoves(cols, die1.getVal(), die2.getVal());
		else
			moves =  Verifier.checkMoves(cols, die1.getVal(), die2.getVal(), !player1Going);;
		int count = 1;
		for (Move m : moves) {
			System.out.println(count + ": " + m.toString());
			count++;
		}
		return(moves);
	}
	
	public ArrayList<Move> list(Die die1, boolean player1Going) {
		ArrayList<Move> moves;
		if (player1Going && !cols.get(WHITE_RESERVE).empty())
			moves = Verifier.whiteReserveMoves(cols, die1.getVal());
		else if (!player1Going && !cols.get(BLACK_RESERVE).empty())
			moves = Verifier.blackReserveMoves(cols, die1.getVal());
		else
			moves = Verifier.checkMoves(cols, die1.getVal(), !player1Going);
		int count = 1;
		for (Move m : moves) {
			System.out.println(count + ": " + m.toString());
			count++;
		}
		return(moves);
	}
	
	public void pip() {
		int blackCount = 0;
		int whiteCount = 0;
		for (int i=1; i<=24; i++) {
			if (!cols.get(i).empty()) {
				if (cols.get(i).peek().isBlack())
					blackCount += (25-i) * cols.get(i).size();
				if (cols.get(i).peek().isWhite())
					whiteCount += i * cols.get(i).size();
			}
		}
		System.out.println("Black Pip: " + blackCount + "\nWhite Pipe: " + whiteCount);
	}
	
	public void hint() {
		String[] nonTestCommands = {"ROLL (R)", "QUIT (Q)", "MOVE (M)", "PIP (P)", "HINT (H)"};
		for (String s : nonTestCommands) {
			System.out.println(s);
		}
	}
	

	
	public ArrayList<Stack<Checker>> getCols() {
		return(cols);
	}

}
