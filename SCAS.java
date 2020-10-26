import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public  class SCAS{

    //Athlete and Sport Medical Practitioner data
    ArrayList<Athlete> athletes = new ArrayList<Athlete>();
    ArrayList<MedicalPractitioner> practitioners = new ArrayList<MedicalPractitioner>();

    //
    Scanner scan = new Scanner(System.in);

    public Athlete addAthlete(){
        System.out.println("Please enter your name: ");
        String username = scan.nextLine();
        Athlete a1 = new Athlete(username);
        athletes.add(a1);
        return a1;
    }

    public MedicalPractitioner addPractitioner(){
        System.out.println("Please enter your name: ");
        String username = scan.nextLine();
        MedicalPractitioner mp1 = new MedicalPractitioner(username);
        practitioners.add(mp1);
        return mp1;
    }

    public boolean athleteLogin(){
        System.out.println("Please enter your Username: ");
        String username = scan.nextLine();
        for(Athlete a : athletes){
            if(username.equals(a.name)){
                return true;
            }
        }
        return false;
    }

    public boolean practitionerLogin(){
        System.out.println("Please enter your Username: ");
        String username = scan.nextLine();
        for(MedicalPractitioner p : practitioners){
            if(username.equals(p.name)){
                return true;
            }
        }
        return false;
    }
}
