package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN=1;
    public static final int OUT=-1;
    public static final int CLOSED=0;

    //contains the current swing direction
    private int mswing;

    public Gate(){
        mswing=CLOSED;
    }


    //sets direction to swing and updates mswing. Returns
    //true or false according to the validity of the input
    //provided by open()
    public boolean setSwing(int direction){
        mswing=direction;
        if(direction== IN || direction==OUT || direction==CLOSED)
        {
            return true;
        }
        else
            return false;
    }

    //this function opens the gate, receives an input,
    //checks whether it is valid then returns true or
    //false according to it.It sends the input received
    //to setSwing method.
    public boolean open(int direction){
        if(direction== IN || direction==OUT )
        {
            setSwing(direction);
            return true;
        }
        else
            return false;

    }


    //closes the gate
    public void close(){
        if(mswing==IN || mswing==OUT)
        {
            setSwing(CLOSED);
        }

    }
    //returns current swing direction to user
    public int getSwingDirection(){
        return mswing;
    }
    //returns an integer corresponding to number
    //of snails inc or dec in the pen.
    public int thru(int count){
        if(mswing==IN)
        {
            return count;
        }
        else if (mswing==OUT)
        {
            return -count;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        String s;
        if(mswing==IN) {
            s="This gate is open and swings to enter the pen only";

        }
        else if(mswing==OUT)
        {
            s="This gate is open and swings to exit the pen only";
        }
        else if (mswing==CLOSED) {
            s="This gate is closed";
        }
        else {
            s="This gate has an invalid swing direction";
        }
        return s;
    }
}