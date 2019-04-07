package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage 
       extends House {
       
    // TODO - Put your code here.
    private boolean mSecondFloor;

    //constructors
    public Cottage(int dimension,int lotLength,int lotWidth){
        super(dimension,dimension,lotLength,lotWidth);
    }

    public Cottage(int dimension,int lotLength,int lotWidth,String owner,boolean secondFloor){
        super(dimension,dimension,lotLength,lotWidth,owner);
        mSecondFloor=secondFloor;
    }

    //getter functions
    public boolean hasSecondFloor(){
        return mSecondFloor;
    }

    //overriding toString method
    public String toString(){
        String part1="Cottage: ";
        if(hasSecondFloor())
            part1+="Has a second floor";
        else
            part1+="Doesn't have a second floor";

        return part1;
    }

}

