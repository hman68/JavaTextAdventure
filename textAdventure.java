import java.util.Scanner;
public class textAdventure {
    public static Room map[][] = {
        {new Room("e",0),new Room("ews",1,new Item("Key")),new Room("w",2,new Item("Water")),new Room("",3),new Room("",4),new Room("",5)},
        {new Room("e",6),new Room("nwe",7)}
    };
    public static Item[] inv = new Item[0];
    public static int posX = 0;
    public static int posY = 0;
    public static boolean exit = false;
    public static void main(String[] args){
        final Scanner in = new Scanner(System.in);
        System.out.println(map[posY][posX].getNum());
        while(!exit){
            String inp = in.nextLine();
            System.out.println(inp);
            textAdventure.inputHandler(inp);
        }
        System.out.println(map[posY][posX].getNum() +" "+ map[posY][posX].getExit("e"));
        System.out.println(Item.getInv());
        map[posY][posX].getItem().pickUp();
        map[posY][posX].getItem().pickUp();
        System.out.println(Item.getInv());
        in.close();
    }
    public static Item getInv(int pos){return inv[pos];}
    public static void setInv(Item[] newInv){inv = newInv;}
    public static void move(String dir){
        if(map[posY][posX].getExit(dir)){
            switch(dir){
                case "n":
                    posY--;
                    break;
                case "s":
                    posY++;
                    break;
                case "e":
                    posX++;
                    break;
                case "w":
                    posX--;
                    break;
            }
            System.out.println(posY+" "+posX);
        }
        else{System.out.println("You cannot go that way");}
    }
    public static void inputHandler(String input){
        if(input.equals("n") || input.equals("N") || input.equals("North") || input.equals("north")){
            textAdventure.move("n");
            return;
        }
        if(input.equals("e") || input.equals("E") || input.equals("East") || input.equals("east")){
            textAdventure.move("e");
            return;
        }
        if(input.equals("s") || input.equals("S") || input.equals("South") || input.equals("south")){
            textAdventure.move("s");
            return;
        }
        if(input.equals("w") || input.equals("W") || input.equals("West") || input.equals("west")){
            textAdventure.move("w");
            return;
        }
        if(input.length() >=6 && (input.substring(0,6).equals("pickup"))){
            map[posY][posX].getItem().pickUp();
        }
        else{
            System.out.println("That is not a command");
            return;
        }
    }
}