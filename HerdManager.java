package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    public static final int HERD=24;
    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here
    public void simulateHerd(Random rand){
        //NO. of snails inside pen
        int pen=HERD;

        //NO.of snails out to pasture
        int pasture=0;

        //Random number of snails
        int num;

        //NO. of snails moving at once(in or out)
        int count;

        //iterator for loop
        int i=0;

        //initially all 24 sheep are inside pen
        mOut.print("There are currently "+pen+" snails in the pen");
        mOut.println(" and "+pasture+ " snails in the pasture");

        //loop
        while(i<MAX_ITERATIONS)
        {
            //random number to select gate
            boolean selectGate;
            if(pen==0)
            {
                num=rand.nextInt(pasture)+1;
                count=mWestGate.thru(num);
                pen+=count;
            }
            else if(pasture==0)
            {
                num=rand.nextInt(pen)+1;
                count=mEastGate.thru(num);
                pen+=count;
            }
            else {
                selectGate = rand.nextBoolean();

                //if East gate is chosen
                if (selectGate == false) {
                    int noOfSnails = rand.nextInt(pen) + 1;
                    count = mEastGate.thru(noOfSnails);
                    pen += count;
                }

                //if West gate is chosen
                else {
                    int noOfSnails = rand.nextInt(pasture) + 1;
                    count = mWestGate.thru(noOfSnails);
                    pen += count;
                }
            }
            pasture=HERD-pen;
            mOut.print("There are currently "+pen+" snails in the pen");
            mOut.println(" and "+(pasture)+" snails in the pasture");

            i++;
        }
        mWestGate.close();
        mEastGate.close();
    }

}
