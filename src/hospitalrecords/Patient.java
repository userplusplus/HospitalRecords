/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

public class Patient {
    
    //Class fields
    private String patientID;
    private String name;
    private String checkInDate;
    private String assignedPersonnel;
    
    //Getter
    public String getPatientID(){
        return patientID;
    }
    
    @Override
    public String toString(){
        //Returns formatted string so that it is printed when the 
        //Patient object is 'Patient.toString'ed 
        return "\nPatient ID: " + patientID +
                "\nName:" + name +
                "\nCheck In Date:" + checkInDate + 
                "\nAssigned Medical Personnel:" + assignedPersonnel;
    }

    /**
     * A constructor for creating a Patient.
     * 
     * @param patientID the ID of the patient
     * @param name the name of the patient
     * @param checkInDate the date the patient was checked into hospital
     * @param assignedPersonnel the doctor/staff assigned to the patient
     */
    public Patient(String patientID, String name, String checkInDate,
            String assignedPersonnel){
        this.patientID = patientID;
        this.name = name;
        this.checkInDate = checkInDate;
        this.assignedPersonnel = assignedPersonnel;
    }
    
}
