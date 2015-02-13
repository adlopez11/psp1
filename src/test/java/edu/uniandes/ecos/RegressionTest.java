package edu.uniandes.ecos;

import edu.uniandes.ecos.biz.RegressionBiz;
import edu.uniandes.ecos.vo.ParVO;
import java.io.IOException;
import java.util.LinkedList;
import junit.framework.TestCase;

public class RegressionTest extends TestCase {

    public void testCalculateMean() throws IOException {
        String file = "test1.txt";
        String xkString = "386";

        LinkedList<ParVO> listPar = edu.uniandes.ecos.util.FileUtil.getListNumbers(file);

        Double xk = Double.parseDouble(xkString);

        Double b1 = RegressionBiz.getB1(listPar);

        Double b0 = RegressionBiz.getB0(listPar, b1);

        Double r = RegressionBiz.getR(listPar);

        Double yk = RegressionBiz.getYk(b0, b1, xk);

        System.out.println("xk: " + xk);
        System.out.println("b0: " + b0);
        System.out.println("b1: " + b1);
        System.out.println("rXY: " + r);
        System.out.println("r2: " + (r * r));
        System.out.println("yk: " + yk);

        assertEquals(-22.55 , b0, 0.001d);
        assertEquals(1.7279, b1, 0.001d);
        assertEquals(0.9545, r, 0.001d);
        assertEquals(0.9111, (r*r), 0.001d);
        assertEquals(644.429, yk, 0.001d);
    }
}
