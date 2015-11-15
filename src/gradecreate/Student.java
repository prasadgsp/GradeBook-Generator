/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecreate;

import java.util.ArrayList;

/**
 *
 * @author Prasad
 */
public class Student {
    
    public String Name;
    
    public String ID;
    
    public ArrayList<AssignedWork> AssignedWork;
    
    public String LetterGrade;

    public String getLetterGrade() {
        return LetterGrade;
    }

    public void setLetterGrade(String LetterGrade) {
        this.LetterGrade = LetterGrade;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<AssignedWork> getAssignedWork() {
        return AssignedWork;
    }

    public void setAssignedWork(ArrayList<AssignedWork> AssignedWork) {
        this.AssignedWork = AssignedWork;
    }
    
    
    
}