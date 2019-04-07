package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {
    
    // TODO - Put your code here.
    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    //constructor
    public Building(int length,int width,int lotLength,int lotWidth){
        setLength(length);
        setWidth(width);
        setLotLength(lotLength);
        setLotWidth(lotWidth);
    }

    //getter functions
    public int getLength(){
        return mLength;
    }

    public int getWidth(){
        return mWidth;
    }

    public int getLotLength(){
        return mLotLength;
    }

    public int getLotWidth(){
        return mLotWidth;
    }

    //setter functions
    public void setLength(int length){
        mLength=length;
    }

    public void setWidth(int width){
        mWidth=width;
    }

    public void setLotLength(int lotLength){
        mLotLength=lotLength;
    }

    public void setLotWidth(int lotWidth){
        mLotWidth=lotWidth;
    }

    //building area
    public int calcBuildingArea(){
        return mLength*mWidth;
    }

    //lot area
    public int calcLotArea(){
        return mLotLength*mLotWidth;
    }

    public String toString(){
        String part1="Building:\nLength="+mLength+"\nWidth="+mWidth+"\n";
        String part2="Lot:\nLength="+mLotLength+"\nWidth="+mLotWidth+"\n";
        return part1+part2;
    }
    
}
