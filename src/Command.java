public class Command {

    private enum CommandType {ROLL, QUIT, MOVE};

    private CommandType commandType;

    public Command (String input) {
        String inputFormatted = input.trim().toUpperCase();
        if (inputFormatted.equals("Q")) {
            commandType = CommandType.QUIT;
        } else if (inputFormatted.equals("R")) {
            commandType = CommandType.ROLL;
        } else if (inputFormatted.equals("M")) {
        	commandType = CommandType.MOVE;
        } else {
            System.out.println("\nInvalid Command");
        }
    }

    public static boolean isValid (String input) {
        String inputFormatted = input.trim().toUpperCase();
        return  inputFormatted.equals("Q") ||
                inputFormatted.equals("R");
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
}
