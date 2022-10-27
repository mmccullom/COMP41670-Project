public class Command {

    private enum CommandType {ROLL, QUIT};

    private CommandType commandType;


    Command (String input) {
        String inputFormatted = input.trim().toUpperCase();
        if (inputFormatted.equals("Q")) {
            commandType = CommandType.QUIT;
        } else if (inputFormatted.equals("R")) {
            commandType = CommandType.ROLL;
        } else {
            //throw new Exception("Invalid Command");
            System.out.print("Invalid Command");
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


}
