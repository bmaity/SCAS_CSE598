import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.Serializable;

public class Athlete{
    String name;
    int athleteID;
    int[][] symptomArray = new int[5][22];

    //constructor
    public Athlete(){
        this.athleteID = 1000 + (int)(Math.random() * 9999);
        System.out.println("Your athleteID is: " + this.athleteID);
    }

    public Athlete(String name){
        this.name = name;
        this.athleteID = 1000 + (int)(Math.random() * 9999);
        System.out.println("Your username is: " + this.name);
        System.out.println("Your athleteID is: " + this.athleteID);
    }

    public void viewSymptomSummary(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Select the Game for which you want to view symptoms summary: Enter a number between 0 to 4");
        int gameNum = scan.nextInt();
        int totalSymptoms = 0;
        for(int i = 0; i < symptomArray[gameNum].length; i++){
            if(symptomArray[gameNum][i] != 0){
                totalSymptoms++;
            }
        }
        int symptomSeverityScore = calculateSymptomSeverityScore(gameNum);
        // int symptomSeverityScore = 0;
        // for(int i = 0; i < symptomArray[gameNum].length; i++){
        //     symptomSeverityScore += symptomArray[gameNum][i];
        // }
        System.out.printf("Total Number Of Symptoms: %d",totalSymptoms);
        System.out.println("");
        System.out.printf("Symptom Severity Score: %d",symptomSeverityScore);
        System.out.println("");
        System.out.println("Enter two games for which you want to see overall severity indicator. Enter 2 numbers between 0 to 4:");
        System.out.println("Enter first number: ");
        int row1 = scan.nextInt();
        System.out.println("Enter second number: ");
        int row2 = scan.nextInt();
        int symptomDifference = calculateSymptomSeverityScore(row1) - calculateSymptomSeverityScore(row2);
        System.out.printf("The follwing is the overall severity indicator for Games %d and %d: ",row1,row2);
        System.out.println("");
        String overallRating = "";
        if(symptomDifference < 3 && symptomSeverityScore < 10){
            System.out.println("No Difference");
            overallRating = "No Difference";
        }else if(symptomDifference < 3 && symptomSeverityScore >=10){
            System.out.println("Unsure");
            overallRating = "Unsure";
        }else if(symptomDifference >= 3 && symptomSeverityScore >= 15){
            System.out.println("Very Different");
            overallRating = "Very Different";
        }
        //display Risky condition indicator
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

        System.out.println("The following is the Risky Condition indicator :");
        System.out.println("");
        if(overallRating.equals("Very Different")){
            System.out.println(ANSI_RED_BACKGROUND + overallRating.toString() + ANSI_RESET);
        }else if(overallRating.equals("Unsure")){
            System.out.println(ANSI_YELLOW_BACKGROUND + overallRating.toString() + ANSI_RESET);
        }else if(overallRating.equals("No Difference")){
            System.out.println(ANSI_GREEN_BACKGROUND + overallRating.toString() + ANSI_RESET);
        }
        
    }

    public int calculateSymptomSeverityScore(int gameNum){
        int symptomSeverityScore = 0;
        for(int i = 0; i < symptomArray[gameNum].length; i++){
            symptomSeverityScore += symptomArray[gameNum][i];
        }
        return symptomSeverityScore;
    }

    //inputSymptoms
    public void inputSymptoms(){
        for(int i = 0; i < 5; i++){
            Scanner scan = new Scanner(System.in);
            System.out.printf("Please enter Symptoms for Game %d: ",i);
            System.out.println("Please enter your score on the following symptoms on a scale of 0(none) to 6(severe)");
            System.out.println("Headache: ");
            symptomArray[i][0] = scan.nextInt(); 
            System.out.println("Pressure in head: ");
            symptomArray[i][1] = scan.nextInt(); 
            System.out.println("Neck Pain: ");
            symptomArray[i][2] = scan.nextInt(); 
            System.out.println("Nausea or Vomiting: ");
            symptomArray[i][3] = scan.nextInt(); 
            System.out.println("Dizziness: ");
            symptomArray[i][4] = scan.nextInt(); 
            System.out.println("Blurred Vision: ");
            symptomArray[i][5] = scan.nextInt();
            System.out.println("Balance Problems: ");
            symptomArray[i][6] = scan.nextInt(); 
            System.out.println("Sensitivity to light: ");
            symptomArray[i][7] = scan.nextInt(); 
            System.out.println("Sensitivity to noise: ");
            symptomArray[i][8] = scan.nextInt(); 
            System.out.println("Feeling slowed down: ");
            symptomArray[i][9] = scan.nextInt(); 
            System.out.println("Feeling like in a fog: ");
            symptomArray[i][10] = scan.nextInt(); 
            System.out.println("Don't feel right: ");
            symptomArray[i][11] = scan.nextInt(); 
            System.out.println("Difficulty concentrating: ");
            symptomArray[i][12] = scan.nextInt(); 
            System.out.println("Difficulty Remembering: ");
            symptomArray[i][13] = scan.nextInt();
            System.out.println("Fatigue or low energy: ");
            symptomArray[i][14] = scan.nextInt(); 
            System.out.println("Confusion: ");
            symptomArray[i][15] = scan.nextInt(); 
            System.out.println("Drowsiness: ");
            symptomArray[i][16] = scan.nextInt(); 
            System.out.println("Trouble falling asleep: ");
            symptomArray[i][17] = scan.nextInt(); 
            System.out.println("More Emotional: ");
            symptomArray[i][18] = scan.nextInt(); 
            System.out.println("Irritability: ");
            symptomArray[i][19] = scan.nextInt(); 
            System.out.println("Sadness: ");
            symptomArray[i][20] = scan.nextInt(); 
            System.out.println("Nervous or anxious: ");
            symptomArray[i][21] = scan.nextInt(); 
            System.out.println("Thank you!");  
        }
    }

}
