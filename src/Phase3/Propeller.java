package Phase3;

public class Propeller {

    private String name;
    private int maxPower;
    private int currentPower;


    public Propeller(String name, int maxPower){
        this.name=name;
        this.maxPower=maxPower;
        this.currentPower=0;
    }

    public String getName() {
        return name;
    }

    public int getMaxPower(){
        return maxPower;}

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        if (Math.abs(currentPower) <= maxPower) {
            this.currentPower = currentPower;
        }
    }

    public void addPower() {
        setCurrentPower(currentPower + 10);
    }

    public void reducePower() {
        setCurrentPower(currentPower - 10);
    }

}

