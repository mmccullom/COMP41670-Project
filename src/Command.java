public class Command {

    private enum CommandType {ROLL, QUIT, MOVE, PIP, DICE, TEST, HINT};

    private CommandType commandType;
    
    private int arg1 = -1;
    
    private int arg2 = -1;
    
    private String filename = "";

    public Command (String input) {
        String inputFormatted = input.trim().toUpperCase().substring(0,1);
        String[] inputArgs = input.split(" ");
        if (inputFormatted.equals("Q")) {
            commandType = CommandType.QUIT;
        } else if (inputFormatted.equals("R")) {
            commandType = CommandType.ROLL;
        } else if (inputFormatted.equals("M")) {
        	commandType = CommandType.MOVE;
        } else if (inputFormatted.equals("P")) {
        	commandType = CommandType.PIP;
        } else if (inputFormatted.equals("H")) {
        	commandType = CommandType.HINT;
        } else if (inputFormatted.equals("T")) {
        	commandType = CommandType.TEST;
        	filename = inputArgs[1];
        } else if (inputFormatted.equals("D")) {
        	commandType = CommandType.DICE;
        	int d1 = Integer.parseInt(inputArgs[1]);
        	if (d1>0 && d1<7) {
        		arg1 = d1;
        	}
        	int d2 = Integer.parseInt(inputArgs[2]);
        	if (d2>0 && d1<7) {
        		arg2 = d2;
        	}
        	
        } else if (inputFormatted.equals("T")) {
        	
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
    
    public String getFilename() {
    	return(filename);
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
	
	public boolean isDice() {
		return commandType == CommandType.DICE;
	}
	
	public boolean isHint() {
		return commandType == CommandType.HINT;
	}
	
	public boolean isTest() {
		return commandType == CommandType.TEST;
	}
	
}
