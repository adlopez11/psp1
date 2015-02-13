/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.util;

import edu.uniandes.ecos.vo.ParVO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Alvaro
 */
public class FileUtil {

    public static LinkedList<ParVO> getListNumbers(final String nameFile) throws FileNotFoundException, IOException, NumberFormatException {
        final LinkedList<ParVO> list = new LinkedList<ParVO>();
        final File file = new File("src/test/resources/"+nameFile);
        final FileReader fr = new FileReader(file);
        final BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            list.add(getPar(line));
            line = br.readLine();
        }
        fr.close();
        return list;
    }
    
    private static ParVO getPar(String line){
        
        int i = line.indexOf("\t");
        return new ParVO(Double.parseDouble(line.substring(0, i)), Double.parseDouble(line.substring(i+1)));
        
    }

}
