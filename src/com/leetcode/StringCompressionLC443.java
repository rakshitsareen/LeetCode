package com.leetcode;

public class StringCompressionLC443 {
    public int compress(char[] chars) {
        int index = 0, indexWrite = 0;
        while(index < chars.length){
            char currChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currChar){
                index++;
                count++;
            }
            chars[indexWrite++] = currChar;
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[indexWrite++] = c;
                }
            }
        }
        return indexWrite;
    }
}
