package com.cier.solution.string;

// https://leetcode.com/problems/implement-strstr/
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals("")){
            return 0;
        }
        if (haystack.length() > 0 && needle.equals("")) {
            return 0;
        }
        if (needle == null) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() - needle.length() + 1) {
            if (j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                int hindex = i;
                int nindex = 0;
                boolean flag = true;
                for (int k = hindex; k < haystack.length() && nindex < needle.length(); k++) {
                    if (haystack.charAt(k) != needle.charAt(nindex)) {
                        flag = false;
                        break;
                    }
                    nindex++;
                }
                if (flag) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "mississippi";
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr(haystack, needle));
        System.out.println("end");
    }
}
