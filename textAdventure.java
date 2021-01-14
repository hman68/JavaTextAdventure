import java.util.Scanner;
public class textAdventure {
    private static Dialogue d = new Dialogue();
    //The map of the area
    public static Room map[][] = {
        {new Room("e",0),new Room("ws",1,new Item("Bronze Key")),new Room("s",2,new Item("Note",0))},
        {new Room("e",3,new Item("Lead Key")),new Room("nwes",4,new Item("Bronze Door",true,"Bronze Key","s")),new Room("wn",5)},
        {new Room("e",6),new Room("nwe",7),new Room("w",8,new Item("Gold Chest",true,"Gold Key"))}
    };
    //This is the players inventory
    public static Item[] inv = new Item[0];
    //The X and Y coordinates of the player, X is positive towards the right and Y is positive downwards
    public static int posX = 0;
    public static int posY = 0;
    //Whether the player wishes to exit or not
    public static boolean exit = false;
    //Main
    public static void main(String[] args){
        final Scanner in = new Scanner(System.in);
        d.speakRoom(map[posY][posX]);
        while(!exit){
            String inp = in.nextLine();
            textAdventure.inputHandler(inp);
            
        }
        in.close();
    }
    //Returns the item at a certain position
    public static Item getInv(int pos){return inv[pos];}
    public static String getFullInv(){
        String fullInv="";
        for(int i = 0; i <inv.length;i++){
            fullInv = fullInv + inv[i].getName();
        }
        return fullInv;
    }
    //Replaces the inventory with the given one
    public static void setInv(Item[] newInv){inv = newInv;}
    //Moves the player in a given direction
    public static void move(String dir){
        Item rmItem = map[posY][posX].getItem(); 
        if(rmItem.isDoor()&&rmItem.getDir()==dir&&rmItem.isLocked()){
            System.out.println("The door is locked");
            return;
        }
        if(map[posY][posX].getExit(dir)){
            if(dir == "n"){
                    posY--;
                    d.speakRoom(map[posY][posX]);
                    return;
            }
            if(dir =="s"){
                    posY++;
                    d.speakRoom(map[posY][posX]);
                    return;
            }
            if(dir =="e"){
                    posX++;
                    d.speakRoom(map[posY][posX]);
                    return;
            }
            if(dir =="w"){
                    posX--;
                    d.speakRoom(map[posY][posX]);
                    return;
            }
            
        }
        else{System.out.println("You cannot go that way");}
    }
    //Handles the input of a player
    public static void inputHandler(String input){
        if(input.toLowerCase().equals("n") || input.toLowerCase().equals("north")){
            textAdventure.move("n");
            return;
        }
        if(input.toLowerCase().equals("e") || input.toLowerCase().equals("east")){
            textAdventure.move("e");
            return;
        }
        if(input.toLowerCase().equals("s") || input.toLowerCase().equals("south")){
            textAdventure.move("s");
            return;
        }
        if(input.toLowerCase().equals("w")|| input.toLowerCase().equals("west")){
            textAdventure.move("w");
            return;
        }
        if(input.length() >=6 && (input.substring(0,6).equals("pickup"))){
            map[posY][posX].getItem().pickUp();
            return;
        }
        if(input.toLowerCase().equals("inv")||input.toLowerCase().equals("inventory")){
            System.out.println("Your Inventory Consists Of :");
            if(inv.length == 0){System.out.println("Nothing");}else{System.out.println(Item.getInv());}
            return;
        }
        if(input.toLowerCase().equals("unlock")){
            map[posY][posX].getItem().unlock();
            return;
        }
        if(input.toLowerCase().equals("read")){
            d.read(map[posY][posX]);
            return;
        }
        if(input.equals("goodbye")){
            exit = true;
            return;
        }
        else{
            System.out.println("That is not a command");
            return;
        }
    }
}