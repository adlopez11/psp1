package edu.uniandes.ecos;

import java.util.LinkedList;
import junit.framework.TestCase;

public class StandardDeviationTest extends TestCase {

    public void testCalculateMean() {
        LinkedList<Double> nums = new LinkedList<Double>();
        
        nums.add(15.0d);
        nums.add(69.9d);
        nums.add(6.5d);
        nums.add(22.4d);
        nums.add(28.4d);
        nums.add(65.9d);
        nums.add(19.4d);
        nums.add(198.7d);
        nums.add(38.8d);
        nums.add(138.2d);

        assertEquals(62.26d, StandardDeviationService.calculateStandardDeviation(nums), 0.01d);
    }
}
