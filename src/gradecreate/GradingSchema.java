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
public class GradingSchema {
    
    public ArrayList<GradeItem> GradeItem;
    
    public ArrayList<GradeItem> getItem() {
        return GradeItem;
    }

    public void setItem(ArrayList<GradeItem> GradeItem) {
        this.GradeItem = GradeItem;
    }
    
}
