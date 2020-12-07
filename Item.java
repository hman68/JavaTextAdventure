

public class Item {
    private String name;
    public Item(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void pickUp(){
        if(this.name == "noI"){System.out.println("There is no item here");return;}
        Item[] temp = new Item[textAdventure.inv.length+1];
        for(int i = 0; i< temp.length-1; i++){
            temp[i] = textAdventure.inv[i];
        }
        temp[temp.length-1] = this;
        textAdventure.inv = temp;
        textAdventure.map[textAdventure.posY][textAdventure.posX].removeItem();
    }
    public static String tostring(){
        String temp = "";
        for(int i=0;i<textAdventure.inv.length;i++){
            temp = temp + textAdventure.getInv(i).getName()+"    ";
        }
        return temp;
    }
}
