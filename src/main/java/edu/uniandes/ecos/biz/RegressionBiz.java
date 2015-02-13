/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.biz;

import edu.uniandes.ecos.util.ListUtil;
import edu.uniandes.ecos.util.MeanUtil;
import edu.uniandes.ecos.vo.ParVO;
import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class RegressionBiz {
    
    public static Double getB1(LinkedList<ParVO> lista){
        
        double n = lista.size();
        double acum1 = 0d;
        for(ParVO vo : lista){
            acum1 = acum1 + (vo.getX()*vo.getY());
        }
        
        double promX = MeanUtil.calculateMean(ListUtil.getSingleList(lista, true));
        
        double promY = MeanUtil.calculateMean(ListUtil.getSingleList(lista, false));
        
        double acum2 = 0d;
        for(ParVO vo : lista){
            acum2 = acum2 + (vo.getX()*vo.getX());
        }
        
        return (acum1-(n*promX*promY))/(acum2-(n*promX*promX));
    }
    
    public static Double getB0(LinkedList<ParVO> lista, Double b1){
        
        double promX = MeanUtil.calculateMean(ListUtil.getSingleList(lista, true));
        
        double promY = MeanUtil.calculateMean(ListUtil.getSingleList(lista, false));
        
        return promY - b1*promX;
    }
    
    public static double getR(LinkedList<ParVO> lista){
        
        double n = lista.size();
        
        double acum1 = 0d;
        for(ParVO vo : lista){
            acum1 = acum1 + (vo.getX()*vo.getY());
        }
        
        double acum2 = 0d;
        for(ParVO vo : lista){
            acum2 = acum2 + vo.getX();
        }
        
        double acum3 = 0d;
        for(ParVO vo : lista){
            acum3 = acum3 + vo.getY();
        }
        
        double acum4 = 0d;
        for(ParVO vo : lista){
            acum4 = acum4 + (vo.getX() *vo.getX());
        }
        
        double acum5 = 0d;
        for(ParVO vo : lista){
            acum5 = acum5 + (vo.getY() *vo.getY());
        }
        
        
        return ((n * acum1) - (acum2*acum3))/Math.sqrt(((n*acum4)-(acum2*acum2))*((n*acum5)-(acum3*acum3)));
        
    }
    
    public static Double getYk(Double b0, Double b1, Double xk){
        return b0 + (b1*xk);
    }
}
