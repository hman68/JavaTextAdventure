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
    public Room(String Exits, int rmNum, Item itemName){
        if(Exits.indexOf("n")!=-1){north=true;}else{north=false;}
        if(Exits.indexOf("e")!=-1){east=true;}else{east=false;}
        if(Exits.indexOf("s")!=-1){south=true;}else{south=false;}
        if(Exits.indexOf("w")!=-1){west=true;}else{west=false;}
        num = rmNum;
        item = itemName;
    }
    public int getNum() {
        return num;
    }
    public boolean getExit(String dir){
        if(dir == "n"){return north;}
        else if(dir == "e"){return east;}
        else if(dir == "s"){return south;}
        else if(dir == "w"){return west;}
        else{
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
    public String getAllExits(){
        String exits = "";
        if(north){exits = exits + "n";}
        if(east){exits = exits+"e";}
        if(south){exits = exits+"s";}
        if(west){exits = exits+"w";}
        return exits;
    }
}