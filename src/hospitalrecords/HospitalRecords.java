/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

/**
 *
 * @author awall
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.LineNumberReader;

public class HospitalRecords {
    
    static ArrayList<Patient> patientRecords = new ArrayList<>();
    
    public static void obtainRecords(){
        String path = "C:\\Users\\awall\\Documents\\NetBeansProjects"
                + "\\HospitalRecords\\ListOfPatients.txt";
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
                oneRecord[2], oneRecord[3]);
                
                patientRecords.add(pat);
                System.out.println(pat); //adding patient to the ArrayList
                //For future me: why does pat print normally, but when pat
                //is added to patient records, it prints a whole lot of
                //random crap?
            }
        }
        catch(IOException ioe){
            System.out.println("IOExcception occured");
        }
    }
    
    public static void main(String[] args){
        HospitalRecords.obtainRecords();
    }

}
