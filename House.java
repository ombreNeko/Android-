package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House 
       extends Building {
       
    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool;

    //constructors
    public House(int length,int width,int lotLength,int lotWidth){
        //calling constructor of super class:Building
        super(length,width,lotLength,lotWidth);
    }

    public House(int length,int width,int lotLength,int lotWidth,String owner){
        super(length,width,lotLength,lotWidth);
        setOwner(owner);
    }

    public House(int length,int width,int lotLength,int lotWidth,String owner,boolean pool){
        this(length,width,lotLength,lotWidth,owner);
        setPool(pool);
    }

    //getter functions
    public String getOwner(){
        return mOwner;
    }

    public boolean hasPool(){
        return mPool;
    }

    //setter functions
    public void setOwner(String owner){
        mOwner=owner;
    }

    public void setPool(boolean pool){
        mPool=pool;
    }

    //overriding toString method
    public String toString(){
        String part1="Owner: ";
        if(getOwner()!= null)
            part1+=getOwner();
        if(hasPool())
            part1+="; has a pool";
        if(calcLotArea()>calcBuildingArea()){
            part1+="; has a big open space";
        }
        return part1;
    }

    public boolean equals(Object other){
        boolean result=false;
        if(other instanceof House){
           House otherHouse=(House)other;
           result=(this.calcBuildingArea()==otherHouse.calcBuildingArea()
                   && this.hasPool()== otherHouse.hasPool());
        }
        return result;
    }
    
}
