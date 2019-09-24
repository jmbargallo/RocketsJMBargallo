package Phase4;

public class Main {

    public static void main(String[] args) {

        //init rockets
        Rocket rocket1 = null;
        Rocket rocket2 = null;
        int[] rocket1Propellers = {10, 30, 80};
        int[] rocket2Propellers = {30, 40, 50, 50, 30, 10};
        int i = 0;

        //Create rockets add propellers
        try {
            rocket1 = new Rocket("32WESSDS");
            for (i = 0; i < rocket1Propellers.length; i++) {
                rocket1.addPropeller("Propulsor " + (i+1) + " " + rocket1.getCode(), rocket1Propellers[i]);
            }
            rocket2 = new Rocket("LDSFJA32");
            for (i = 0; i < rocket2Propellers.length; i++) {
                rocket2.addPropeller("Propulsor " + (i+1) + " " + rocket2.getCode(), rocket2Propellers[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Printing Rockets data
        System.out.println("Rocket 1: " + rocket1.toString());
        System.out.println("Rocket 2: " + rocket2.toString());

        //print Speed
        printSpeed(rocket1, rocket2);

        //Accelerate 3 times both rockets
        for (i = 0; i < 3; i++) {
            rocket1.accelerate();
            rocket2.accelerate();
        }

        printSpeed(rocket1, rocket2);

        //Brake rocket1 accelerate rocket2 5 times
        for (i = 0; i < 5; i++) {
            rocket1.brake();
            rocket2.accelerate();
        }

        //Accelerate rocket2 2 times

        for (i = 0; i < 2; i++) {
            rocket2.accelerate();
        }

        printSpeed(rocket1, rocket2);

        //Accelerate both rockets 15 times

        for (i = 0; i < 15; i++) {
            rocket1.accelerate();
            rocket2.accelerate();
        }

        printSpeed(rocket1, rocket2);

    }

    public static void printSpeed(Rocket rocket1, Rocket rocket2) {
        System.out.println("\nCohet " + rocket1.getCode() + " Velocitat actual: " + rocket1.getCurrentSpeed());
        System.out.println("Cohet " + rocket2.getCode() + " Velocitat actual: " + rocket2.getCurrentSpeed());
    }

}