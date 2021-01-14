public class Item {
    /*
        name-Name of Item
        type-Type of Item
        sNum-The sign number, is used in the dialogue object
        locked-Determines if the item, if lockable, is currently locked
        key-States the key that is needed to unlock the item, if it has a lock
        dir-If the item is a door, determines the direction in the room that the door is located
        pickupable-Determies if the item is able to be picked up or not
    */
    private String name;
    private String type;
    private int sNum;
    private boolean locked = false;
    private String key = "none";
    private String dir = "none";
    private boolean pickupable;
    //Generic constructor for an Item
    public Item(String name){
        this.name = name;
        this.type = "item";
        this.pickupable = true;
    }
    //Constructor for a chest-type item
    public Item(String name, boolean locked, String key){
        this.name = name;
        this.locked = locked;
        this.key = key;
        this.type = "chest";
        this.pickupable = false;
    }
    //Constructor for a door-type item
    public Item(String name, boolean locked, String key, String dir){
        this.name = name;
        this.locked = locked;
        this.key = key;
        this.dir = dir;
        this.type = "door";
        this.pickupable = false;
    }
    //Constructor for a sign-type item
    public Item(String name, int signNum){
        this.name = name;
        this.type = "sign";
        this.sNum = signNum;
        this.pickupable = false;
    }
    //Returns name of item
    public String getName(){
        return this.name;
    }
    //Picks up the item in the room, if possible. 
    //Works by creating an array that is one larger than the current inventory array, then copies the original over and adds the new item
    public void pickUp(){
        if(!pickupable){System.out.println("This item cannot be picked up"); return;}
        if(this.name == "noI"){System.out.println("There is no item here");return;}
        Item[] temp = new Item[textAdventure.inv.length+1];
        for(int i = 0; i< temp.length-1; i++){
            temp[i] = textAdventure.inv[i];
        }
        temp[temp.length-1] = this;
        textAdventure.inv = temp;
        textAdventure.map[textAdventure.posY][textAdventure.posX].removeItem();
        System.out.println("You have succesfully picked up "+this.name);
    }
    //Returns the current inventory of the person, seperated by spaces
    public static String getInv(){
        String temp = "";
        for(int i=0;i<textAdventure.inv.length;i++){
            temp = temp + textAdventure.getInv(i).getName()+"    ";
        }
        return temp;
    }
    //returns certan variables of the item
    public String getType(){return type;}
    public boolean isLocked(){return locked;}
    public String getKey(){return key;}
    public String getDir(){return dir;}
    public boolean isDoor(){
        if(this.getType() == "door"){
            return true;
        }
        else{
            return false;
        }
    }
    public int getSignNum(){
        return sNum;
    }
    public void unlock(){
        if(textAdventure.getFullInv().indexOf(key)>-1){
            locked = false;
            System.out.println("You have unlocked the "+name);
        }else{
            System.out.println("The "+name+" could not be unlocked");
        }
    }
}
