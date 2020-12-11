public class Dialogue {
    private String[] d = {"You are standing in a ravine \nYou are surrounded in all directions but east by the stone wall of the ravine.","","","","","","","",""};
    private String[] signs = {"The note on the table reads:\n\nPb-->Au\n\nIt Worked!\n\nPutting the metal into the substance actually turned it to gold.\nI WILL BE RICH"};
    public Dialogue(){System.out.println("You Awaken");}
    public void speakRoom(Room rm){
        System.out.println(d[rm.getNum()]);
        if(rm.getItem().getName() == "noI"){
            System.out.println("There are no objects of interest here");
        }else{
            System.out.println("There is a "+rm.getItem().getName()+" in this room");
        }
    }
    public void read(Room rm){
        System.out.println(signs[rm.getItem().getSignNum()]);
    }
}
