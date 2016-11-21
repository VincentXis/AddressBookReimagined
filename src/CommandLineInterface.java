import java.util.Scanner;

public class CommandLineInterface {
    private ContactRegister reg = new ContactRegister();
    private boolean run = true;

    public CommandLineInterface() {
        runCLI();
    }

    private void commandReader(String[] inputArray) {
        switch (inputArray[0].toLowerCase()) {
            case "add":
                reg.addContactToList(inputArray[1], inputArray[2], inputArray[3]);
                break;
            case "list":
                reg.printConatctList();
                break;
            case "search":
                reg.searchContact(inputArray[1]);
                break;
            case "exit":
                flipSwitch();
                break;
        }
    }

    private void flipSwitch() {
        run = !run;
    }

    private String readUserInput() {
        return new Scanner(System.in).nextLine();
    }

    private void runCLI() {
        System.out.println("\t\tWelcome\nAdd\tList\tSearch\tExit");
        String input;
        String[] inputSplit;
        while (run) {
            input = readUserInput();
            inputSplit = input.split(" ");
            commandReader(inputSplit);
        }
        reg.saveList();
    }
}
