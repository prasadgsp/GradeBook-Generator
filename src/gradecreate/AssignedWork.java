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
public class AssignedWork {
    
    public ArrayList<GradedWork> GradedWork;
    
    @JsonProperty("-category")
    public String category;

    public ArrayList<GradedWork> getGradedwork() {
        return GradedWork;
    }

    public void setGradedwork(ArrayList<GradedWork> GradedWork) {
        this.GradedWork = GradedWork;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
