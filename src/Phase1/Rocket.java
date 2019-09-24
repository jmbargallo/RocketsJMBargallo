package Phase1;


import java.util.ArrayList;

public class Rocket {

    private String code;
    private ArrayList<Propeller> propellers;


    //Constructor with code lenght check
    public Rocket(String code) throws Exception{
        this.code=code;
        this.propellers=new ArrayList<>();
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
    public void addPropeller(String name) {
        propellers.add(new Propeller(name));
    }

    //Get propellers Number
    public int getPropellersNumber() {
        return propellers.size();
    }


}
