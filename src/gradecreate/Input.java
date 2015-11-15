/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecreate;

import abstractinterfaces.Formatter;
import abstractinterfaces.Reader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Prasad
 */
public class Input {


    public static void main(String[] args) {
        
        InputValidator inputValidator=new InputValidator();
        GradeCalculator gradeCalculator = new GradeCalculator();
        
        ReaderFactory rf=new ReaderFactory();
        FormatterFactory ff = new FormatterFactory();
        
        String readerch="";
        String outputch="";
        
        Scanner sc=new Scanner(System.in);
		
        System.out.println("GRADEBOOK GENERATION");
	System.out.println("****************************\n");
	System.out.println("Do you wish to retrieve gradebooks of Graduate or Undergraduate students?\nType Grad for Graduate Students or Undergrad for Undergraduate Students");
	readerch=sc.next();
	if(readerch==null||(!readerch.equalsIgnoreCase("Grad")&&!readerch.equalsIgnoreCase("Undergrad")))
	{
		System.out.println("As no proper input was given assuming default input Grad student");
		readerch="Grad";
	}
               
        System.out.println("\nWhat File Output would you prefer?\nType either HTML, XML or CSV");
	outputch=sc.next();
	if(outputch==null||(!outputch.equalsIgnoreCase("HTML")&&!outputch.equalsIgnoreCase("CSV")&&!outputch.equalsIgnoreCase("XML")))
	{
		System.out.println("As no proper input was given assuming default input HTML");
		outputch="HTML";
	}
                
        Reader read = rf.createReader(readerch);
        GradeMain gradeMain = read.read();
        
        System.out.println("\n\nValidating Input.....");
        Boolean valid = inputValidator.Validate(gradeMain);
        if(valid==false) {
               System.out.println("Input is of wrong format and cannot be processed!!");
               return;
        }
                
        System.out.println("\n\nCalculating Final Grades....\n");
        gradeMain = gradeCalculator.calculate(gradeMain);

                
        Formatter formatter = ff.createFormat(outputch);
        formatter.format(gradeMain);

    }
    
}


//                GradeBook gb = gradeMain.getGradeBook();
//                GradingSchema gSchema = gb.getGradingSchema();
//                ArrayList<GradeItem> gItem = gSchema.getItem();
//        
//                for(GradeItem g:gItem) {
//                  System.out.println(g.getCategory()+"-"+g.getPercentage());
//                 }
//                Grades g = gb.getGrades();
//                ArrayList<Student> sgrade = g.getStudent();
//                for(Student s:sgrade) {
//                     System.out.println(s.getID()+" "+s.getName());
//                     ArrayList<AssignedWork> aw = s.getAssignedWork();
//                for(AssignedWork aww:aw) {
//                     System.out.println("\n"+aww.getCategory());
//                     ArrayList<GradedWork> gw = aww.getGradedwork();
//                for(GradedWork gww:gw) {
//                    System.out.println(gww.getName()+"-"+gww.getGrade());
//                }
//            }
//        }