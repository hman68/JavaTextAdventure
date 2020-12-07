public class textAdventure {
    public static Room map[][] = {
        {new Room("e",0),new Room("ews",1,"Key"),new Room("w",2,"Water"),new Room("",3),new Room("",4),new Room("",5)},
        {new Room("e",6),new Room("nwe",7)}
    };
    public static Item[] inv = new Item[0];
    public static int posX = 0;
    public static int posY = 0;
    public static void main(String[] args){
        System.out.println(map[posY][posX].getNum());
        textAdventure.move("n");
        textAdventure.move("e");
        textAdventure.move("s");
        textAdventure.move("n");
        System.out.println(map[posY][posX].getNum() +" "+ map[posY][posX].getExit("e"));
        System.out.println(Item.tostring());
        map[posY][posX].getItem().pickUp();
        map[posY][posX].getItem().pickUp();
        System.out.println(Item.tostring());
    }
    public static Item getInv(int pos){return inv[pos];}
    public static void setInv(Item[] newInv){inv = newInv;}
    public static void move(String dir){
        if(map[posY][posX].getExit(dir)){
            if(dir=="s"){posY++;}
            else if(dir == "n"){posY--;}
            else if(dir == "e"){posX++;}
            else{posX--;}
        }
        else{System.out.println("You cannot go that way");}
    }
    public static void inputHandler(String input){
        if(input == "n" || input == "N" || input == "North" || input == "north"){
            textAdventure.move("n");
        }
        if(input == "e" || input == "E" || input == "East" || input == "east"){
            textAdventure.move("e");
        }
    }
}