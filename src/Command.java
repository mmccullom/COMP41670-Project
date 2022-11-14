public class Command {

    private enum CommandType {ROLL, QUIT, MOVE, PIP};

    private CommandType commandType;
    
    private int arg1 = -1;
    
    private int arg2 = -1;

    public Command (String input) {
        String inputFormatted = input.trim().toUpperCase();
        if (inputFormatted.equals("Q")) {
            commandType = CommandType.QUIT;
        } else if (inputFormatted.equals("R")) {
            commandType = CommandType.ROLL;
        } else if (inputFormatted.equals("M")) {
        	commandType = CommandType.MOVE;
        } else if (inputFormatted.equals("P")) {
        	commandType = CommandType.PIP;
        }
        else{
            System.out.println("\nInvalid Command");
        }
    }

    public boolean isValid (String input) {
        String inputFormatted = input.trim().toUpperCase();
        return  inputFormatted.equals("Q") ||
                inputFormatted.equals("R");
    }
    
    public int getArg1() {
    	return(arg1);
    }
    
    public int getArg2() {
    	return(arg2);
    }

    public boolean isQuit() {
        return commandType == CommandType.QUIT;
    }

    public boolean isRoll () {
        return commandType == CommandType.ROLL;
    }

	public boolean isMove() {
		return commandType == CommandType.MOVE;
	}
	
	public boolean isPip() {
		return commandType == CommandType.PIP;
	}
}
