package com.java.algorithm;
import java.util.HashMap;
import java.util.Map;

public class StringAndNumber {
	
	
//  Proble: Roman to Integer	
//	Given a roman numeral, convert it to an integer.
//	Input is guaranteed to be within the range from 1 to 3999.

	static Map<Character,Integer> roman2IntMap;
	static{
		roman2IntMap = new HashMap<Character,Integer>();
	    roman2IntMap.put('I',1);
	    roman2IntMap.put('V',5);
	    roman2IntMap.put('X',10);
	    roman2IntMap.put('L',50);
	    roman2IntMap.put('C',100);
	    roman2IntMap.put('D',500);
	}
    public int romanToInt(String s) {
    	//从前往后扫描，用一个临时变量记录分段数字。
    	//如果当前比前一个大，说明这一段的值应该是当前这个值减去上一个值。比如IV = 5 – 1
    	//否则，将当前值加入到结果中，然后开始下一段记录。比如VI = 5 + 1， II=1+1
    	//http://www.rapidtables.com/convert/number/how-roman-numerals-to-number.htm

        s = s.toUpperCase();
        int sum = roman2IntMap.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            int a = roman2IntMap.get(s.charAt(i));
            int b = roman2IntMap.get(s.charAt(i-1));
            if( a > b){
                sum += a - 2 * b;//pay attention to this, b may be added one more time,so need to reduce it
                
            }else{
                sum += a;
            }
        }
        return sum;
    }
    public int romanToInt2(String s) {
    	//从后往前扫描

         s = s.toUpperCase();
	     int sum = roman2IntMap.get(s.charAt(s.length()-1));
	     int b = 0;;
	     for(int i=s.length()-1; i>= 1; i--){
	         b = roman2IntMap.get(s.charAt(i));
	         int a = roman2IntMap.get(s.charAt(i-1));                
	         if(a < b){
	                 sum =  sum - a;
	         }else{
	                 sum =  sum + a;
	         }
	        
	     }
         return sum;
    }    
}
