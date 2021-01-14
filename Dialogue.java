public class Dialogue {
    private String[] d = {"You are standing in a ravine \nYou are surrounded in all directions but east by the stone wall of the ravine.","The ravine narrows to a close in front of you.\nHowever, there is a cave entrance to the south. ","Against the north wall of the room, there is a table, on this table, a note has been nailed to it.\nAlso on this table is a bowl with an unknown liquid and several chunks of what appears to be gold.",
                          "The room is barren, with unmarked stone walls in all directions except east.","This room opens to the east and west, with the cave entrance to the north\nTo the south lies a large bronze door, on the door is a keyhole.","This room decorated with carvings along the walls to the south and east.\nTo the north lies a human-sized hole leading into another room.",
                          "The room is a dead-end, however the walls and floor are carved with intricate patterns.","This room splits to the east and to the west\nThe eastern corridor is well lit, with torches burning along its path.\nThe western corridor is dark, but a path through it can still be made out.","The room is unnaturally well lit, with light eminating from the celing. In the center of the room lies a treasure chest made out of gold."};
    private String[] signs = {"The note on the table reads:\n\nPb-->Au\n\nIt Worked!\n\nPutting the metal into the substance actually turned it to gold.\nI WILL BE RICH"};
    public Dialogue(){System.out.println("You Awaken");}
    public void speakRoom(Room rm){
        for(int i = 0; i<11;i++){
            System.out.println();
        }
        System.out.println(d[rm.getNum()]);
        if(rm.getItem().getName() == "noI"){
            System.out.println("There are no objects of interest here");
        }else{
            System.out.println("There is a "+rm.getItem().getName()+" in this room");
        }
        if(rm.getAllExits().length() == 1){
                System.out.println("There is an exit to the: ");
        }else{
                System.out.println("There are exits to the: ");
        }
        if(rm.getExit("n")){System.out.print("north ");}
        if(rm.getExit("s")){System.out.print("south ");}
        if(rm.getExit("e")){System.out.print("east ");}
        if(rm.getExit("w")){System.out.print("west");}
        System.out.println();
    }
    public void read(Room rm){
        if(rm.getItem().getType()!="sign"){
            System.out.println("There is no sign in this room");
            return;
        }
        System.out.println(signs[rm.getItem().getSignNum()]);
    }
}
