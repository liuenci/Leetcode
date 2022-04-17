package com.cier.solution.string;

// https://leetcode-cn.com/problems/count-and-say/
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String s = countAndSay(n - 1);
        int i = 0;
        String out = "";
        while (i < s.length()){
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            out = out + (j - i) + s.charAt(i);
            i = j;
        }
        return out;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        countAndSay.countAndSay(4);
        System.out.println("end");
    }
}
