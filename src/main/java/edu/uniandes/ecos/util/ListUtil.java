/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.util;

import edu.uniandes.ecos.vo.ParVO;
import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class ListUtil {
    
    public static LinkedList<Double> getSingleList(LinkedList<ParVO> list, boolean x){
        LinkedList<Double> result = new LinkedList<Double>();
        for(ParVO vo : list){
            if(x){
                result.add(vo.getX());
            } else {
                result.add(vo.getY());
            }
        }
        return result;
    }
}
