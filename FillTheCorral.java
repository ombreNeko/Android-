package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }
    //Method to set all gates either In.out,or closed
    public void setCorralGates(Gate[]gate,Random selectDirection)
    {
        //random no. to select one of in,out or closed
        int dir= selectDirection.nextInt(3);

        if(dir==2)
            dir= Gate.OUT;

        //loop for setting each gate in array
        for(int i=0;i<gate.length;i++)
        {
            gate[i].setSwing(dir);
        }
    }

    //Method for determining if atleast one gate is set to IN
    public boolean anyCorralAvailable(Gate[] corral)
    {   //iterator
        int i=0;
        while(i<corral.length)
        {
            if(corral[i].getSwingDirection()== Gate.IN)
            {
                return true;
            }
            i++;
        }
        return false;

    }

    //Method to corral all the snails
    public int corralSnails(Gate[] corral,Random rand)
    {
        //No. of snails out to pasture
        int outToPasture=5;

        //Total attempts required to corral all snails
        int iterations=0;

        //loop
        while(outToPasture>0)
        {
            iterations++;

            //random no. determining the no. of snails trying to move
            //from one place to another
            int movingSnails = rand.nextInt(outToPasture + 1);

            //Random number to select a gate out of the 4 given
            int selectGate = rand.nextInt(4);


            mOut.println(movingSnails+" are trying to move through coral "+ selectGate);

            int num=corral[selectGate].thru(movingSnails);

            outToPasture-=num;

        }
        mOut.println("It took "+iterations+" attempts to corral all of the snails");
        return iterations;
    }

}
