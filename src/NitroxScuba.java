import java.util.Scanner;
//=============================================================================
public class NitroxScuba {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int fPerAtmosphere = 33;
    private static final double maximalPartialPressure = 1.4;
    private static final double cMaximalPressure = 1.6;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {
        int depth;
        int percentO;
        System.out.print("Enter depth and percentage O : ");
        depth = keyboard.nextInt();
        percentO = keyboard.nextInt();
        double ambientPressure = computeAmbientPressure(depth, percentO);
        System.out.println("Ambient Pressure :" + ambientPressure);
        double partialPressure = computePartialPressure(ambientPressure, percentO);
        System.out.println("O2 Pressure :" + partialPressure);
        char oxygenGroup = oxygenGroup(partialPressure);
        System.out.println("O2 group: " + oxygenGroup);
        boolean partialPressure1 = exceedPressure(partialPressure);
        System.out.println("Exceeds maximal O2 pressure: " + partialPressure1);
        boolean partialPressure2 = exceedContingencyPressure(partialPressure);
        System.out.println("Exceeds contingency O2 pressure: " + partialPressure2);

    }
    //-----------------------------------------------------------------------------
    private static double computeAmbientPressure(int depth, int percentO) {
        double ambientPressure;
        ambientPressure = ((depth/fPerAtmosphere)+1);
        return(ambientPressure);
    }
    //-----------------------------------------------------------------------------
    private static double computePartialPressure(double ambientPressure, int percentO) {
        double partialPressure = (percentO/100.0)* ambientPressure;
        return(partialPressure);
    }
    //-----------------------------------------------------------------------------
    private static char oxygenGroup(double partialPressure) {
        int group = (int) ((partialPressure *10) +65);
        char group1 = (char)group;
        return(group1);

    }
    //-----------------------------------------------------------------------------
    private static boolean exceedPressure(double partialPressure) {
        boolean partialPressure1;
        if (partialPressure > maximalPartialPressure) {
            partialPressure1 = true;
        } else{
            partialPressure1 = false;
        }
        return(partialPressure1);

    }
    //-----------------------------------------------------------------------------
    private static boolean exceedContingencyPressure(double partialPressure) {
        boolean partialPressure1;
        if (partialPressure > cMaximalPressure) {
            partialPressure1 = true;
        } else{
            partialPressure1 = false;
        }
        return(partialPressure1);

    }


}