/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecreate;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Prasad
 */
public class GradeCalculator {
    
    public GradeMain calculate(GradeMain gradeMain) {
        ArrayList<GradeItem> gradeItems = gradeMain.getGradeBook().getGradingSchema().getItem();
        ArrayList<Student> studentArr = gradeMain.getGradeBook().getGrades().getStudent();
        double total = 0;
        String finalGrade="";
        for(Student student:studentArr) {
            ArrayList<AssignedWork> assignedWorkArr = student.getAssignedWork();
            total = 0;
            for(AssignedWork assignedWork:assignedWorkArr) {
                int weightage = 0;
                String category = assignedWork.getCategory();
                ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
                
                Iterator i = gradeItems.iterator();
                while(i.hasNext()) {
                    GradeItem gradeItem = (GradeItem) i.next();
                    if(gradeItem.getCategory().equals(category)) {
                       weightage = gradeItem.getPercentage();
                       break;
                    }
                }
                int size = gradedWorkArr.size();
                for(GradedWork gradedWork:gradedWorkArr) {
                    total = total + (double)((Double.parseDouble(gradedWork.getGrade()))*(weightage)/(size))/(double)100;
                }
                
                if(total>=99)
                    finalGrade="A+";
                else if(total>=95)
                    finalGrade="A";
                else if(total>=90)
                    finalGrade="A-";
                else if(total>=87)
                    finalGrade="B+";
                else if(total>=84)
                    finalGrade="B";
                else if(total>=80)
                    finalGrade="B-";
                else if(total>=75)
                    finalGrade="C+";
                else if(total>=70)
                    finalGrade="C";
                else if(total>=60)
                    finalGrade="D";
                else if(total<60)
                    finalGrade="E";
                
                student.setLetterGrade(finalGrade);
            }            
        }

        return gradeMain;
    }
    
}
