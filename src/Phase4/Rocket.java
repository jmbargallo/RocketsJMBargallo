package Phase4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Rocket {

    //Init rocket
    private String code;
    private List<Propeller> propellers;
    private float currentSpeed;
    private CountDownLatch doneSignal = null;

    //Create Rocket with exception handling
    public Rocket(String code) throws Exception {
        if (code.length() != 8) throw new Exception("El codi del cohet ha de ser de 8 caracters");

        this.code = code;
        this.propellers = new ArrayList<>();
        this.currentSpeed = 0;
    }
    //Get Rocket name
    public String getCode() {
        return code;
    }
    //Adding Propellers
    public void addPropeller(String name, int maxPower) throws Exception {
        propellers.add(new Propeller(name, maxPower));
    }
    //Get propellers number
    public int getPropellerNumber() {
        return propellers.size();
    }
    //Get current speed
    public float getCurrentSpeed() {
        return currentSpeed;
    }
    //Set current speed
    public void setCurrentSpeed() {
        this.currentSpeed = calculateSpeed();
    }
    //Speed calculations
    public float calculateSpeed() {
        int propellersPower = 0;
        float speed = currentSpeed;
        for (Propeller propeller : propellers) {
            propellersPower += propeller.getCurrentPower();
        }
        int sign = (propellersPower >= 0)? 1:-1;
        speed += sign * 100 * ((float) Math.sqrt(Math.abs(propellersPower)));
        return speed;
    }
    //Printing action
    public void printAction(String action) {
        System.out.println("\nCohet " + code + " " + action);
        System.out.println("...........................");
    }
    //Actions
    public synchronized void accelerate() {
        printAction("accelera");
        runPropellers(RocketAction.ACCELERATE);
    }

    public synchronized void brake() {
        printAction("frena");
        runPropellers(RocketAction.BRAKE);
    }
    //Propellers running
    public void runPropellers(RocketAction action) {
        doneSignal = new CountDownLatch(getPropellerNumber());
        for (Propeller propeller : propellers) {
            propeller.setAction(action);
            Propeller t = propeller.clone();
            t.setSignal(doneSignal);
            t.start();
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setCurrentSpeed();
        try {
            wait(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Printing Rocket data
    @Override
    public String toString() {
        int i = 0;
        StringBuilder sb = new StringBuilder()
                .append("Codi = ").append(code)
                .append(", Numero de Propulsors = ").append(getPropellerNumber())
                .append(", Potencia max propulsors = ");
        for (i = 0; i < getPropellerNumber(); i++) {
            sb.append(propellers.get(i).getMaxPower() + " ");
        }
        return sb.toString();
    }

}

