package Phase3;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

    private String code;
    private List<Propeller> propellers;


    //Constructor with code lenght check
    public Rocket(String code) throws Exception {
        this.code = code;
        this.propellers = new ArrayList<>();
        checkCodeLenght(code);
    }

    //Exception handling

    public void checkCodeLenght(String code) throws Exception {
        if (this.code.length() != 8) {
            throw new Exception("El codi del cohet ha de ser de 8 caracters");
        }
    }

    //Getters & Setters
    public String getCode() {
        return code;
    }

    //Add propellers
    public void addPropeller(String name, int maxPower) {
        propellers.add(new Propeller(name, maxPower));
    }

    //Get propellers Number
    public int getPropellersNumber() {
        return propellers.size();
    }
    //Method accelerate
    public void accelerate() {
        for (Propeller propeller : propellers) {
            propeller.addPower();
        }
    }
    //Method Brake
    public void brake() {
        for (Propeller propeller : propellers) {
            propeller.reducePower();
        }
    }




    @Override
    //Print Rocket data in a compact way
    public String toString() {
        int i = 0;
        StringBuilder sb = new StringBuilder()
                .append("Cohet = ").append(code)
                .append(", Numero de Propulsors = ").append(getPropellersNumber())
                .append(", Potencia max propulsors = ");
        for (i = 0; i < propellers.size(); i++) {
            sb.append(propellers.get(i).getMaxPower() + " ");
        }
        return sb.toString();

    }
}
