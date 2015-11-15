/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecreate;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Prasad
 */
public class GradeBook {
    
    @JsonProperty("-class")
    public String clazz;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
                   
    public GradingSchema GradingSchema;

    public GradingSchema getGradingSchema() {
        return GradingSchema;
    }

    public void setGradingSchema(GradingSchema GradingSchema) {
        this.GradingSchema = GradingSchema;
    }
    
    public Grades Grades;

    public Grades getGrades() {
        return Grades;
    }

    public void setGrades(Grades Grades) {
        this.Grades = Grades;
    }
    
}
