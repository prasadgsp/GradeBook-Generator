/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecreate;

import abstractinterfaces.Formatter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Prasad
 */
public class CSVFormatter implements Formatter {
    
    
    public void format(GradeMain gradeMain)     {
		try
		{

		FileWriter writer = new FileWriter("GradeBookCSV.csv");
		writer.append("Name,ID");

                ArrayList<AssignedWork> assignedWorkArr = gradeMain.getGradeBook().getGrades().getStudent().get(0).getAssignedWork();
                for(AssignedWork assignedWork:assignedWorkArr) {
                    ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
                    for(GradedWork gradedWork:gradedWorkArr) {
                        writer.append("," + gradedWork.getName());
                    }
                }
                writer.append(",Grade\n");
                
                for(Student student : gradeMain.getGradeBook().getGrades().getStudent())
		{
                        writer.append(student.getName()+","+student.getID());
                        assignedWorkArr = student.getAssignedWork();
                        for(AssignedWork assignedWork:assignedWorkArr) {
                            ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
                            for(GradedWork gradedWork:gradedWorkArr) {
                                writer.append("," + gradedWork.getGrade());
                            } 
                        }
                        writer.append(","+student.getLetterGrade()+"\n");
                }
             
                writer.flush();
		writer.close();
                
                System.out.println("CSV File Created in project folder");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
