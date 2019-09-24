package Phase2;


import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {

        //Init
        Rocket rocket1 = null;
        Rocket rocket2 = null;
        int[] rocket1Propellers = {10, 30, 80};
        int[] rocket2Propellers = {30, 40, 50, 50, 30, 10};
        int i = 0;

        //Create Rockets check lenght error try catch block in Rockets
        rocket1 = new Rocket("32WESSDS");
        rocket2 = new Rocket("LDSFJA32");


        //Add three propellers rocket1
        for (i = 0; i < rocket1Propellers.length; i++) {
            rocket1.addPropeller("Propulsor" + (i + 1), rocket1Propellers[i]);
        }

        //Add six propellers rocket2
        for (i = 0; i < rocket2Propellers.length; i++) {
            rocket2.addPropeller("Propulsor" + (i + 1), rocket2Propellers[i]);
        }
        //Print Rocket data
        System.out.println("Cohet 1: " + rocket1.toString());
        System.out.println("Cohet 2: " + rocket2.toString());

        /* Deprecated changed by a more compact way
        //Print rocket data
        System.out.printf("Cohet 1: " +"Codi"+rocket1.getCode());
        System.out.println(" Numero de propulsors: "+rocket1.getPropellersNumber());
        for(int j = 0; j <rocket1Propellers.length; j++)
        System.out.println("Potencia maxima propulsor "+ (j+1) +" "+rocket1Propellers[j]);

        System.out.printf("Cohet 2: " +" Codi: "+rocket2.getCode());
        System.out.println(" Numero de propulsors: "+rocket2.getPropellersNumber());
        for(int k = 0; k <rocket2Propellers.length; k++)
            System.out.println("Potencia maxima propulsor "+ (k+1) +" "+rocket2Propellers[k]);;
           }
    */


    }
}