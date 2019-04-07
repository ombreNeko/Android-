package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office 
       extends Building {
       
    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices =0;

    //constructors
    public Office(int length,int width,int lotLength,int lotWidth){
        super(length,width,lotLength,lotWidth);
        sTotalOffices++;
    }

    public Office(int length,int width,int lotLength,int lotWidth,String businessName){
        super(length,width,lotLength,lotWidth);
        setBusinessName(businessName);
        sTotalOffices++;
    }

    public Office(int length,int width,int lotLength,int lotWidth,String businessName
                ,int parkingSpaces){
        this(length,width,lotLength,lotWidth,businessName);
        setParkingSpaces(parkingSpaces);
    }

    //getters
    public String getBusinessName(){
        return mBusinessName;
    }

    public int getParkingSpaces(){
        return mParkingSpaces;
    }

    //setters
    public void setBusinessName(String businessName){
        mBusinessName=businessName;
    }

    public void setParkingSpaces(int parkingSpaces){
        mParkingSpaces=parkingSpaces;
    }

    //overriding toString method
    public String toString(){
        String part1="Business: ";
        if(getBusinessName()== null){
            part1+="unoccupied";
        }
        else
        {
            part1+=getBusinessName();
        }
        if(getParkingSpaces()!=0)
        {
            part1+="; has "+getParkingSpaces()+" parking spaces";
        }
        if(sTotalOffices!=0)
        {
            part1+=" (total offices: "+ sTotalOffices+")";
        }

        return part1;
    }

    public boolean equals(Object other){
        boolean result=false;
        if(other instanceof Office)
        {
            Office otherOffice=(Office)other;
            result = (this.calcBuildingArea()==otherOffice.calcBuildingArea()
                      && this.getParkingSpaces()==otherOffice.getParkingSpaces());
        }
        return result;
    }
}
