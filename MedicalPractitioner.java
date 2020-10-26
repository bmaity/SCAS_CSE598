import java.util.Scanner;
import java.util.ArrayList;

public class MedicalPractitioner{
    String name;
    int practitionerID;

    //constructor
    public MedicalPractitioner(){
        this.practitionerID = 1000 + (int)(Math.random() * 9999);
        System.out.println("Your practitionerID is: " + this.practitionerID);
    }

    public MedicalPractitioner(String name){
        this.name = name;
        this.practitionerID = 1000 + (int)(Math.random() * 9999);
        System.out.println("Your username is: "+this.name);
        System.out.println("Your practitionerID is: "+this.practitionerID);
    }

    //**** public methods ****//
    //inputSymptoms
}
