public class Room{
    private boolean north;
    private boolean west;
    private boolean east;
    private boolean south;
    private int num;
    private Item item;
    public Room(boolean eN, boolean eE, boolean eS, boolean eW, int rmNum){
        north = eN;
        west = eW;
        east = eE;
        south = eS;
        num = rmNum;
        item = null;
    }
    public Room(boolean eN, boolean eE, boolean eS, boolean eW, int rmNum, String itemName){
        north = eN;
        west = eW;
        east = eE;
        south = eS;
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
    public Item getItem(){
        return item;
    }
}