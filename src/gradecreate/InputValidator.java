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
public class InputValidator {
    
    public Boolean Validate(GradeMain gradeMain) {
        
        GradingSchema gradingSchema = gradeMain.getGradeBook().getGradingSchema();
        int sum = 0;
        
        ArrayList<String> categoryList = new ArrayList<String>();
        ArrayList<GradeItem> gradeItemArr = gradingSchema.getItem();
        
        for(GradeItem gradeItem:gradeItemArr) {
            sum+=gradeItem.getPercentage();
            categoryList.add(gradeItem.getCategory());
        }
        if(sum!=100)
            return false;
        
       ArrayList<Student> studentArr = gradeMain.getGradeBook().getGrades().getStudent();
       
       for(Student student:studentArr) {
           
           ArrayList<AssignedWork> assignedWorkArr = student.getAssignedWork();
           for(AssignedWork assignedWork:assignedWorkArr) {
               
               if(!categoryList.contains((String)assignedWork.getCategory()))
                  return false;
               
               ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
               for(GradedWork gradedWork:gradedWorkArr) {
                   if(Integer.parseInt(gradedWork.getGrade())>100||Integer.parseInt(gradedWork.getGrade())<0)
                       return false;
               }
           }
       }
        
        
        return true;
    }
    
}
