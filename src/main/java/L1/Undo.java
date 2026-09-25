package L1;

import java.util.ArrayList;
import java.util.List;

public class Undo {
   private List<String> commands;
   private static Undo instance;

    private Undo() {
        this.commands = new ArrayList<>();
    }

    public static synchronized Undo getInstance() {
        if (instance == null){
            instance = new Undo();
        }
        return instance;
    }

    public String addCommand (String command){
        commands.add(command);
        return command + " added.";
    }

    public String unDo (){

        if (commands.isEmpty()){
            throw new NoComands();
        }

        String command = commands.getLast();
        commands.removeLast();

        if (commands.isEmpty()){
            return "previous command: " +
                    command + " undo. No more commands to undo.";
        }

        return "previous command: " + command
                + " undo. Now on command: " + commands.getLast() + ".";
    }

    public String getCommands() {
        if(commands.isEmpty()){
            throw new NoComands();
        }
        return String.join("\n", commands);
    }

    public void clearHistory(){
        commands.clear();
    }
}
