package View;

import ADT.MyADTExc;
import ADT.MyDictionary;
import Model.Command;

import java.util.Scanner;

public class TextMenu {

    private MyDictionary<String, Command> commands;
    public TextMenu() { commands = new MyDictionary<>();}
    public void addCommand(Command c){ commands.put(c.getKey(),c);}
    private void printMenu(){
        for(Command com : commands.getValues()){
            String line=String.format("%4s : %s", com.getKey(), com.getDescr());
            System.out.println(line);
        }
    }
    public void show() throws MyADTExc

    {
        Scanner scanner=new Scanner(System.in);
        while(true){
            printMenu();
            System.out.printf("Input the option: ");
            String key=scanner.nextLine();
            Command com=commands.get(key);
            if (com==null){
                System.out.println("Invalid Option");
                continue; }
            com.execute();
        }
    }

}
