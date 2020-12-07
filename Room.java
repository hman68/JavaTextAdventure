public class Room{
    private boolean north;
    private boolean west;
    private boolean east;
    private boolean south;
    private int num;
    private Item item;
    public Room(String Exits, int rmNum){
        if(Exits.indexOf("n")!=-1){north=true;}else{north=false;}
        if(Exits.indexOf("e")!=-1){east=true;}else{east=false;}
        if(Exits.indexOf("s")!=-1){south=true;}else{south=false;}
        if(Exits.indexOf("w")!=-1){west=true;}else{west=false;}
        num = rmNum;
        item = new Item("noI");
    }
    public Room(String Exits, int rmNum, String itemName){
        if(Exits.indexOf("n")!=-1){north=true;}else{north=false;}
        if(Exits.indexOf("e")!=-1){east=true;}else{east=false;}
        if(Exits.indexOf("s")!=-1){south=true;}else{south=false;}
        if(Exits.indexOf("w")!=-1){west=true;}else{west=false;}
        num = rmNum;
        item = new Item(itemName);
    }
    public int getNum() {
        return num;
    }
    public boolean getExit(String dir){
        switch(dir){
            case "n":
                return north;
            case "e":
                return east;
            case "s":
                return south;
            case "w":
                return west;
            default:
                System.out.println("Error: Incorrect statement for getExit()");
                return false;
        }
    }
    public void removeItem(){
        item = new Item("noI");
    }
    public Item getItem(){
        return item;
    }
}