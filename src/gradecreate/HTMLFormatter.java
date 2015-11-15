package gradecreate;
import java.io.PrintWriter;

import abstractinterfaces.Formatter;
import java.util.ArrayList;

public class HTMLFormatter implements Formatter{
	
	public void format(GradeMain gradeMain)
	{
		try
		{

		PrintWriter writer = new PrintWriter("GradeBookHTML.html", "UTF-8");
		writer.println("<HTML>");
		writer.println("<HEAD>");
		writer.println("<TITLE>GradeBook</TITLE>");
		writer.println("</HEAD>");
		writer.println("<BODY><TABLE>\n");
                
		writer.print("<tr>\n<th>Name</th> <th>ID</th>");
                ArrayList<AssignedWork> assignedWorkArr = gradeMain.getGradeBook().getGrades().getStudent().get(0).getAssignedWork();
                for(AssignedWork assignedWork:assignedWorkArr) {
                    ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
                    for(GradedWork gradedWork:gradedWorkArr) {
                        writer.print("<th>" + gradedWork.getName() + "</th>");
                    }
                }
                
                writer.print("<th>Grade</th>\n</tr>");
		for(Student student : gradeMain.getGradeBook().getGrades().getStudent())
		{
                        writer.println("\n<tr>");
                        writer.print("<td>"+student.getName()+"</td> <td>"+student.getID()+"</td>");
                         assignedWorkArr = student.getAssignedWork();
                        for(AssignedWork assignedWork:assignedWorkArr) {
                            ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
                            for(GradedWork gradedWork:gradedWorkArr) {
                                writer.print("<td>" + gradedWork.getGrade() + "</td>");
                    }
                }
                        writer.print("<td>" + student.getLetterGrade() +"</td>");
                        writer.println("</tr>");
                }
		writer.println("\n</TABLE></BODY>");
		writer.println("</HTML>");
		writer.close();
                System.out.println("HTML File Created in project folder");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
