package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) {

        String string = "1234567891012";

        System.out.println(missing(string));
    }



    public static int missing(String s){
        int res = 0, limit = Math.min(8,s.length()/2);
        for (int c = 1; c < limit; ++c) {
            int temp = 1;
            int m = Integer.parseInt(s.substring(0, c));
            int hold = c;
            while (hold < s.length()) {
                m++;
                String n = String.valueOf(m);
                if (!n.equals(s.substring(hold, hold+n.length()))) {
                    res = m;
                    temp--;
                    if (temp < 0) break;
                }
                else hold += n.length();
            }
            if (temp == 0 && hold == s.length()) return (int)res;
        }
        return -1;
    }
}