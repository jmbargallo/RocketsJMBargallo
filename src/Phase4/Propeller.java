package Phase4;

import java.util.concurrent.CountDownLatch;

//Propeller extends Thread to allow multiple threads
public class Propeller extends Thread {

    //Init
    private int maxPower;
    private int currentPower;
    private RocketAction action;
    private Propeller propeller = null;
    private CountDownLatch doneSignal = null;

    //Creating propeller with error check and inheritance

    public Propeller(String name, int maxPower) throws Exception {
        super(name);
        if (maxPower <= 0) throw new Exception("Potencia maxima ha de ser mes gran que 0");

        this.maxPower = maxPower;
        this.currentPower = 0;
    }

    //Multiple propellers
    public Propeller(Propeller propeller) {
        super(propeller.getName());
        this.propeller = propeller;
        this.maxPower = propeller.getMaxPower();
        this.currentPower = propeller.getCurrentPower();
        this.action = propeller.getAction();
    }
    //getters
    public int getMaxPower() {
        return maxPower;
    }

    public int getCurrentPower() {
        return currentPower;
    }
    //Setters
    public void setCurrentPower(int currentPower) {
        if (Math.abs(currentPower) <= maxPower) {
            this.currentPower = currentPower;
        }
    }
    //Action (enum as help for easy reference)
    public RocketAction getAction() {
        return action;
    }

    public void setAction(RocketAction action) {
        this.action = action;
    }
    //Countdownlatch class to trigger and maintain threads
    public void setSignal(CountDownLatch doneSignal) {
        this.doneSignal = doneSignal;
    }
    //Increase and decrease power methods
    public void addPower() {
        propeller.setCurrentPower(currentPower + 10);
    }

    public void reducePower() {
        propeller.setCurrentPower(currentPower - 10);
    }

    //Multiple propellers
    @Override
    public Propeller clone() {
        return new Propeller(this);
    }
    //Action definition thread launch
    @Override
    public void run() {
        if (action.equals(RocketAction.ACCELERATE)) {
            addPower();
        } else if (action.equals(RocketAction.BRAKE)) {
            reducePower();
        }
        System.out.println(propeller.getName() + " Potencia actual: " + propeller.getCurrentPower());
        doneSignal.countDown();
    }

}