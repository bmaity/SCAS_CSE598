import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SCAS_UI{

    private static final String filePath = "/Users/bmaity/SCAS_CSE598/Sport-Concussion-Assessment-System/Athlete_symptom_data.ser";

    public void serializeAthlete(Athlete a1){
          try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(a1);
            objectOut.close();
            System.out.println("The Athlete object has been succesfully written to a file");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        SCAS_UI scas_ui = new SCAS_UI();

        SCAS scas = new SCAS();
        for(Athlete a : scas.athletes){
            System.out.println(a.name);
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Sport Concussion Assessment System!");
        System.out.println("Please enter A for Athelete and S if you are a Sport Medical Practitioner");
        String userType = scan.nextLine();
        

        //if user is 
        if(userType.equals("A")){
            Athlete a1 = scas.addAthlete();
            System.out.println("Please enter your symptoms for last five games: ");
            a1.inputSymptoms();
            System.out.println("Here are the symptoms for last five games: ");
            System.out.println(Arrays.deepToString(a1.symptomArray));
            a1.viewSymptomSummary();
        }else{
            scas.addPractitioner();
            System.out.println("Hi Sport Medical Practitioner. This console app collects data of atheletes health conditions.Please select A for athelete ");
        }
    }
}
