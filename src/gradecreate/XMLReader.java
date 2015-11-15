package gradecreate;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.*;

import org.w3c.dom.*;

import abstractinterfaces.Reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class XMLReader implements Reader{

    public GradeMain read() {
       try {
             GradeBook gradebook = new GradeBook();
             File fXmlFile = new File("xmlGradesGoodData.xml");
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse(fXmlFile);
             
             doc.getDocumentElement().normalize();
             
             NodeList rootNodeList = doc.getElementsByTagName("GradeBook");
             Node rootNode = rootNodeList.item(0);
             Element rootElement = (Element) rootNode;
             gradebook.setClazz(rootElement.getAttribute("class"));

             
             NodeList nList = doc.getElementsByTagName("GradeItem");
             
             ArrayList<GradeItem> gradeItem = new ArrayList<GradeItem>();
             
             for (int temp = 0; temp < nList.getLength(); temp++) {
		     
                                GradeItem schema = new GradeItem();
		    		Node nNode = nList.item(temp);
		    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		    			Element eElement = (Element) nNode;
                                        schema.setCategory(eElement.getElementsByTagName("Category").item(0).getTextContent());
                                        schema.setPercentage(Integer.parseInt(eElement.getElementsByTagName("Percentage").item(0).getTextContent()));
		    			gradeItem.add(schema);
		    			
		    		}
            }
            
            GradingSchema gradeSchema = new GradingSchema();
            gradeSchema.setItem(gradeItem);
            
            gradebook.setGradingSchema(gradeSchema);
            
            
            
            
            nList = doc.getElementsByTagName("Student");
           
            ArrayList<Student> students = new ArrayList<Student>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
		     
                                Student sgrade = new Student();
		    		Node nNode = nList.item(temp);
                                
		    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		    			Element eElement = (Element) nNode;
                                        
                                        sgrade.setName(eElement.getElementsByTagName("Name").item(0).getTextContent());
                                        sgrade.setID(eElement.getElementsByTagName("ID").item(0).getTextContent());
                                        
                                        ArrayList<AssignedWork> assignedWork = new ArrayList<AssignedWork>();
                                        
                                        
                                        NodeList childNodeList = eElement.getElementsByTagName("AssignedWork");                                    
                                        
                                        for (int temp2 = 0; temp2 < childNodeList.getLength(); temp2++) {
                                            
                                            AssignedWork aWork = new AssignedWork();
                                            ArrayList<GradedWork> gradedwork = new ArrayList<GradedWork>();
                                            Node cNode = childNodeList.item(temp2);
                                            Element cElement = (Element) cNode;
                                            aWork.setCategory(cElement.getAttribute("category"));
                                            
                                            NodeList gradedNodeList = cElement.getElementsByTagName("GradedWork");
                                            
                                             for (int temp3 = 0; temp3 < gradedNodeList.getLength(); temp3++) {
                                                 GradedWork gwork = new GradedWork();
                                                 Node gNode = gradedNodeList.item(temp3);
                                                 Element gElement = (Element) gNode;
                                                 gwork.setName(gElement.getElementsByTagName("Name").item(0).getTextContent());
                                                 gwork.setGrade(gElement.getElementsByTagName("Grade").item(0).getTextContent());
                                                 gradedwork.add(gwork);  
                                             }
                                             aWork.setGradedwork(gradedwork);
                                             assignedWork.add(aWork);
                                        }
                                        sgrade.setAssignedWork(assignedWork);

		    			students.add(sgrade);
		    			
		    		}
            }
            Grades grades = new Grades();
            grades.setStudent(students);
            
            gradebook.setGrades(grades);
            GradeMain gradeMain = new GradeMain();
            gradeMain.setGradeBook(gradebook);
            return gradeMain;
       } catch(Exception e) {
           e.printStackTrace();
           return null;
       }
    }

}

