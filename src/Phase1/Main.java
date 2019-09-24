package Phase1;

public class Main {

    public static void main(String[] args) throws Exception{

        //Init
        Rocket rocket1 = null;
        Rocket rocket2 = null;
        int i = 0;

        //Create Rockets check lenght error try catch block at Rockets
        rocket1 = new Rocket("32WESSDS");
        rocket2 = new Rocket("LDSFJA32");


        //Add three propellers rocket1
        for (i = 0; i < 3; i++) {
            rocket1.addPropeller("Propulsor " +
                    (i+1) + " " + rocket1.getCode());
        }

        //Add six propellers rocket2
        for (i = 0; i < 6; i++) {
            rocket2.addPropeller("Propulsor " +
                    (i+1) + " " + rocket1.getCode());
        }

        //Print rocket data


        System.out.printf("Cohet 1: " +" Codi: "+ rocket1.getCode());
        System.out.println(" Numero de propulsors: "+rocket1.getPropellersNumber());
        System.out.printf("Cohet 2: " +" Codi: "+rocket2.getCode());
        System.out.println(" Numero de propulsors: "+rocket2.getPropellersNumber());

    }



}
