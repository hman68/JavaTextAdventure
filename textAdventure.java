public class textAdventure {
    public static Room[] map = {new Room(false,true, false, false,0),new Room(false, true,true,true,1,"Key"),new Room(false,false,false,true,2,"Water")};
    public static Item[] inv = new Item[0];
    public static void main(String[] args){
        System.out.println(map[0].getNum());
        System.out.println(map[0].getExit("n"));
        System.out.println(map[1].getNum() +" "+ map[1].getExit("e"));
        System.out.println(Item.tostring());
        map[1].getItem().pickUp();
        map[2].getItem().pickUp();
        System.out.println(Item.tostring());
    }
    public static Item getInv(int pos){return inv[pos];}
    public static void setInv(Item[] newInv){inv = newInv;}
}