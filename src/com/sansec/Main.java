package com.sansec;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;


public class Main {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int result = 0;
        int len = 0;
        String substr = "";
        for (int i = 0; i < s.length(); i++) {
            substr = "" +  s.charAt(i);
            len = 1;
            int j = i + 1;
            while (j < s.length()) {
                if (substr.indexOf(s.charAt(j)) < 0) {
                    substr = substr +  s.charAt(j);
                    len++;
                    j++;
                } else {
                    result = result < len ? len : result;
                    break;
                }
            }
            result = result < len ? len : result;
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==0)
            return 0;
        int max=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0,j=0;i!=s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
 //      ArrayList<Integer> al = new ArrayList<Integer>(10000);
//        LinkedList<Object> al = new LinkedList<Object>();

        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(100);
        ts.add(10);
        ts.add(105);
        for(Iterator<Integer> ite = ts.iterator();ite.hasNext();){
            Integer i = (Integer)ite.next();
            System.out.println(i);
        }
        Class c1= ts.getClass();

        Class c3= TreeSet.class;
        Method[] methods = c3.getDeclaredMethods();
        for (Method m:methods
             ) {
            System.out.println(m.toString());
        }

        Object o = c3.newInstance();

        Field a = c3.getDeclaredField("");

        System.out.println(c1.toString());

        System.out.println(c3.toString());
        System.out.println(Class.forName("com.sansec.Main").toString());


//        for(int i=0;i<1000000;i++){
//            al.add(i);
//        }
//        Integer tmp  ;
//        long beginTime = System.currentTimeMillis();
////        for (Integer i:al
////             ) {
////            tmp = i;
////        }
//        for(Iterator<Integer> it = al.iterator();it.hasNext();)
//        {
//            tmp = it.next();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-beginTime);

    }
}
