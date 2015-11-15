package gradecreate;
import java.util.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import abstractinterfaces.Formatter;

public class XMLFormatter implements Formatter{
	
	public void format(GradeMain gradeMain)
	{
            try {
			
                    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
                    // root elements
                    Document doc = docBuilder.newDocument();
                    Element rootElement = doc.createElement("GradeBook");
                    doc.appendChild(rootElement);
                        
                    Attr rootAttr = doc.createAttribute("category");
                    rootAttr.setValue(gradeMain.getGradeBook().getClazz());
		    rootElement.setAttributeNode(rootAttr);
	 
                    Element Grades = doc.createElement("Grades");
                    rootElement.appendChild(Grades);

                    for(Student student : gradeMain.getGradeBook().getGrades().getStudent())    {
                        
                        Element Student = doc.createElement("Student");
                        Grades.appendChild(Student);
			
			Element Name = doc.createElement("Name");
			Name.appendChild(doc.createTextNode(student.getName()));
			Student.appendChild(Name);
                        
			Element ID = doc.createElement("ID");
			ID.appendChild(doc.createTextNode(student.getID()));
			Student.appendChild(ID);
	 
                        ArrayList<AssignedWork> assignedWorkArr = student.getAssignedWork();
                        
                        for(AssignedWork assignedWork:assignedWorkArr) {
                            
                            Element AssignedWork = doc.createElement("AssignedWork");
                            Student.appendChild(AssignedWork);
                            
                            Attr attr = doc.createAttribute("category");
                            attr.setValue(assignedWork.getCategory());
                            AssignedWork.setAttributeNode(attr);
                            
                            ArrayList<GradedWork> gradedWorkArr = assignedWork.getGradedwork();
                            
                            for(GradedWork gradedWork:gradedWorkArr) {
                                
                                Element GradedWork = doc.createElement("GradedWork");
                                AssignedWork.appendChild(GradedWork);
                                
                                Element GradedWorkName = doc.createElement("Name");
                                GradedWorkName.appendChild(doc.createTextNode(gradedWork.getName()));
                                GradedWork.appendChild(GradedWorkName);
                                
                                Element GradedWorkGrade = doc.createElement("Grade");
                                GradedWorkGrade.appendChild(doc.createTextNode(gradedWork.getGrade()));
                                GradedWork.appendChild(GradedWorkGrade);
                                
                            }
                            
                        }
                      
                        Element LetterGrade = doc.createElement("LetterGrade");
                        LetterGrade.appendChild(doc.createTextNode(student.getLetterGrade()));
                        Student.appendChild(LetterGrade);
                        
                    }
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("GradeBookXML.xml"));
			
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);
	 
			System.out.println("XML File Created in project folder");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}

}
