import java.util.ArrayList;
import java.util.Stack;

public class Board {
	private ArrayList<Stack<Checker>> cols;
	private static final int colNum = 26;

	public Board() throws Exception {
		cols = new ArrayList<>(24);
		for (int i=0; i < colNum; i++) {
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
		if (cols.get(0).size() == 15 || cols.get(25).size() == 15)
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

		int total = val1 + val2;

		System.out.print("Die 1: "+ val1 + "\nDie 2: " + val2 + "\n");
	}
	
	public void quit() {
		System.out.println("Exiting Game");
		System.exit(0);
	}
	
	public void move(Move m) {
		cols.get(m.getDestCol()).push(cols.get(m.getSrcCol()).pop());
	}
	
	public ArrayList<Move> list(Die die1, Die die2, boolean player1Going) {
		ArrayList<Move> moves = checkMoves(die1.getVal(), die2.getVal(), !player1Going);
		int count = 1;
		for (Move m : moves) {
			System.out.println(count + ": " + m.toString());
			count++;
		}
		return(moves);
	}
	
	public ArrayList<Move> list(Die die1, boolean player1Going) {
		ArrayList<Move> moves = checkMoves(die1.getVal(), !player1Going);
		int count = 1;
		for (Move m : moves) {
			System.out.println(count + ": " + m.toString());
			count++;
		}
		return(moves);
	}
	
	public ArrayList<Move> checkMoves(int d1, int d2, boolean isBlack) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
			
		
		for (int i=24; i>=1; i--) {
			if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
				if (isBlack) {
				// First die moves
					if(i+d1 > 24) {
						if (isBlackFull())
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
						if (isBlackFull())
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
						if (isWhiteFull())
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
							if (isWhiteFull())
								validMoves.add(new Move(i, 0, false, false));
					}
					else if (cols.get(i-d2).empty())
						validMoves.add(new Move(i, i-d2, false, false));
					else if (cols.get(i-d2).peek().isBlack() == isBlack)
						validMoves.add(new Move(i, i-d2, false, false));
					else if ((cols.get(i-d2).peek().isBlack() != isBlack) && cols.get(i-d1).size()==1)
						validMoves.add(new Move(i, i-d2, true, false));
				}
			}
		}
		
		return(validMoves);
	}
	
	public ArrayList<Move> checkMoves(int d1, boolean isBlack) {
		ArrayList<Move> validMoves = new ArrayList<Move>();
		for (int i=24; i>=1; i--) {
			if(!cols.get(i).empty() && (cols.get(i).peek().isBlack() == isBlack)) {
				if (isBlack) {
					if(i+d1 > 24) {
						if (isBlackFull())
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
							if (isWhiteFull())
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
	
	public boolean isBlackFull() {
		int count = 0;
		for (int i=19; i<=24; i++) {
			if(!cols.get(i).empty() && cols.get(i).peek().isBlack()) {
				count+=cols.get(i).size();
			}
		}
		return(count==15);
	}
	
	public boolean isWhiteFull() {
		int count = 0;
		for (int i=1; i<=6; i++) {
			if(!cols.get(i).empty() && cols.get(i).peek().isWhite()) {
				count+=cols.get(i).size();
			}
		}
		return(count==15);
	}
	
	public ArrayList<Stack<Checker>> getCols() {
		return(cols);
	}

}
