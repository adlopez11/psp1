package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class MeanService {
    
    public static Double calculateMean(final LinkedList<Double> nums){
        double size = nums.size();
        double acum =0d;
        double mean;
        
        for(Double num : nums){
            acum = acum + num;
        }
        mean = acum/size;
        return mean ;
    }
    
}
