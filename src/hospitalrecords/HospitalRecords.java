/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.LineNumberReader;
import java.util.Scanner;

public class HospitalRecords {
    
    static ArrayList<Patient> patientRecords = new ArrayList<>();
    
    public static void obtainRecords(){
        String path = "ListOfPatients.txt";
        //Use path to the ListOfPatients.txt here
        
        LineNumberReader lr = null;
        //allows to read information from the file line by line
        
        String[] oneRecord = new String[4];
        //an array to store info about one patient
        
        Patient pat;
        try { 
            //using try-catch for exception handling to catch
            //possible errors with i/o operations
            
            FileReader inputStream = new FileReader(path);
            //FileReader reads the file’s contents
            
            lr = new LineNumberReader(inputStream);
            String str;
            
            while((str = lr.readLine())!= null) {
                //while the next line exists
                
                oneRecord = str.split(",");
                //dividing one file line by commas and assigning to array
                
                pat = new Patient(oneRecord[0], oneRecord[1],
                oneRecord[2], oneRecord[3]);//creating patient objects
                
                patientRecords.add(pat);//adding patients to the ArrayList
            }
        }
        catch(IOException ioe){
            System.out.println("IOExcception occured");
        }
    }
    
    public static void main(String[] args){
        HospitalRecords.obtainRecords();
        //Get the reocrds and put them into an arraylist
        
        System.out.println("**Patient records have been recorded"
                        + " successfully**"); 
        
        Scanner sc = new Scanner(System.in);
        //Set up scanner
        
        while(true){
            System.out.println("Press S for search, Press E for exit\n"); 
            String userInput = sc.next(); //obtain user input
            
            if("E".equalsIgnoreCase(userInput)){
                 System.out.println("Bye...");
                 break;
                 //End while loop, "exiting" the program
                 
            } else if("S".equalsIgnoreCase(userInput)){
                System.out.println("Enter Patient ID to search");
                userInput = sc.next();//Get user input
                
                for (int i = 0; i < patientRecords.size(); i++) {
                    
                    if(patientRecords.get(i).getPatientID()
                            .equalsIgnoreCase(userInput)){
                        //If the patient record ID matches the user input
                        
                        System.out.println(patientRecords.get(i).toString());
                        System.out.println("\nWould you like to remove the "
                                + "patient's record(s)?\nY or N?");
                        userInput = sc.next();//Get user input
                        
                        if("Y".equalsIgnoreCase(userInput)){
                            patientRecords.remove(i);
                            System.out.println("\nRecord(s) removed successfully");
                            break; //break out of for loop, back to S to search
                            // and E to exit
                            
                        } else if(!"N".equalsIgnoreCase(userInput)){
                            //Not a "Y" or "N"
                            System.out.println("Input not recognized,"
                                    + " please try again.");
                        }
                        
                    }else if(i + 1 == patientRecords.size()){
                        //true at end of loop and if there was no match
                        System.out.println("\nThe search found no"
                                + " matching patient.");
                    }
                    
                }
                
            } else {
                //Input is neither "E" or "S"
                System.out.println("Input not recognized, please try again.");
            }
        }
    }

}
