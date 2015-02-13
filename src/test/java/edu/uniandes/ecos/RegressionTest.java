package edu.uniandes.ecos;

import edu.uniandes.ecos.biz.RegressionBiz;
import edu.uniandes.ecos.vo.ParVO;
import java.io.IOException;
import java.util.LinkedList;
import junit.framework.TestCase;

public class RegressionTest extends TestCase {

    public void test1() throws IOException {
        String file = "test1.txt";
        String xkString = "386";

        LinkedList<ParVO> listPar = edu.uniandes.ecos.util.FileUtil.getListNumbers(file);

        Double xk = Double.parseDouble(xkString);

        Double b1 = RegressionBiz.getB1(listPar);

        Double b0 = RegressionBiz.getB0(listPar, b1);

        Double r = RegressionBiz.getR(listPar);

        Double yk = RegressionBiz.getYk(b0, b1, xk);

        System.out.println("TEST 1");
        System.out.println("xk: " + xk);
        System.out.println("b0: " + b0);
        System.out.println("b1: " + b1);
        System.out.println("rXY: " + r);
        System.out.println("r2: " + (r * r));
        System.out.println("yk: " + yk);
        System.out.println("");

        assertEquals(-22.55 , b0, 0.01d);
        assertEquals(1.7279, b1, 0.01d);
        assertEquals(0.9545, r, 0.01d);
        assertEquals(0.9111, (r*r), 0.01d);
        assertEquals(644.429, yk, 0.01d);
    }
    
    public void test2() throws IOException {
        String file = "test2.txt";
        String xkString = "386";

        LinkedList<ParVO> listPar = edu.uniandes.ecos.util.FileUtil.getListNumbers(file);

        Double xk = Double.parseDouble(xkString);

        Double b1 = RegressionBiz.getB1(listPar);

        Double b0 = RegressionBiz.getB0(listPar, b1);

        Double r = RegressionBiz.getR(listPar);

        Double yk = RegressionBiz.getYk(b0, b1, xk);

        System.out.println("TEST 2");
        System.out.println("xk: " + xk);
        System.out.println("b0: " + b0);
        System.out.println("b1: " + b1);
        System.out.println("rXY: " + r);
        System.out.println("r2: " + (r * r));
        System.out.println("yk: " + yk);
        System.out.println("");

        assertEquals(-4.039d , b0, 0.01d);
        assertEquals(0.1681d, b1, 0.01d);
        assertEquals(0.9333d, r, 0.01d);
        assertEquals(0.8711d, (r*r), 0.01d);
        assertEquals(60.858d, yk, 0.01d);
    }
    
    public void test3() throws IOException {
        String file = "test3.txt";
        String xkString = "386";

        LinkedList<ParVO> listPar = edu.uniandes.ecos.util.FileUtil.getListNumbers(file);

        Double xk = Double.parseDouble(xkString);

        Double b1 = RegressionBiz.getB1(listPar);

        Double b0 = RegressionBiz.getB0(listPar, b1);

        Double r = RegressionBiz.getR(listPar);

        Double yk = RegressionBiz.getYk(b0, b1, xk);

        System.out.println("TEST 3");
        System.out.println("xk: " + xk);
        System.out.println("b0: " + b0);
        System.out.println("b1: " + b1);
        System.out.println("rXY: " + r);
        System.out.println("r2: " + (r * r));
        System.out.println("yk: " + yk);
        System.out.println("");

        assertEquals(-23.92d , b0, 0.01d);
        assertEquals(1.43097d, b1, 0.01d);
        assertEquals(0.9631d, r, 0.01d);
        assertEquals(0.9276d, (r*r), 0.01d);
        assertEquals(528.4294, yk, 0.01d);
    }
    
    public void test4() throws IOException {
        String file = "test4.txt";
        String xkString = "386";

        LinkedList<ParVO> listPar = edu.uniandes.ecos.util.FileUtil.getListNumbers(file);

        Double xk = Double.parseDouble(xkString);

        Double b1 = RegressionBiz.getB1(listPar);

        Double b0 = RegressionBiz.getB0(listPar, b1);

        Double r = RegressionBiz.getR(listPar);

        Double yk = RegressionBiz.getYk(b0, b1, xk);

        System.out.println("TEST 4");
        System.out.println("xk: " + xk);
        System.out.println("b0: " + b0);
        System.out.println("b1: " + b1);
        System.out.println("rXY: " + r);
        System.out.println("r2: " + (r * r));
        System.out.println("yk: " + yk);
        System.out.println("");

        assertEquals(-4.604d , b0, 0.01d);
        assertEquals(0.140164d, b1, 0.01d);
        assertEquals(0.9480d, r, 0.01d);
        assertEquals(0.8988d, (r*r), 0.01d);
        assertEquals(49.4994, yk, 0.01d);
    }
}
