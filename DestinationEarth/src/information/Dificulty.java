/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public enum Dificulty {
    DEFAULT("S", "2A", "3A", "4A", "5A*", "R", "4A", "5A", "6A*", "R", "6A", "7A*", "R", "8A", "E"),
    MEDIUM("S", "2A", "3A", "3A", "5A", "2A*", "R", "5A", "4A", "6A*", "R", "7A*", "R", "8A", "E"),
    HARD("S", "4A", "3A", "3A", "3A", "2A*", "R", "5A", "4A*", "R", "9A", "6A*", "R", "9A", "E");
    
    final private List <String> journey;
    
    Dificulty(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String l, String m, String n, String o, String p ){
        journey = Arrays.asList(a,b,c,d,e,f,g,h,i,j,l,m,n,o,p);
    }
    
    public List<String> getJourney(){
        return this.journey;
    }
}
