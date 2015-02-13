package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class StandardDeviationService {
    
    public static Double calculateStandardDeviation(final LinkedList<Double> nums){
        double size = nums.size();
        double acum =0d;
        double mean = MeanService.calculateMean(nums);
        
        for(Double num : nums){
            
            acum = acum + Math.pow(num-mean, 2);
        }
        acum = acum/(size - 1d);
        acum = Math.sqrt(acum);
        return acum ;
    }
}
