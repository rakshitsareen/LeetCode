package com.leetcode;

public class ReadNCharactersGivenRead4 {

    static class Solution implements Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] temp = new char[4];
            int total = 0;
            boolean eof = false;
            while(!eof && total < n){
                int count = read4(temp);
                eof = count  < 4;
                int remainingToRead = n - total;
                count = Math.min(count, remainingToRead);
                for(int i = 0; i < count; ++i){
                    buf[total++] = temp[i];
                }
            }
            return total;
        }

        int previdx = 0;
        int  prevsize = 0;
        char[] prevbuf = new char[4];
        public int readMultipleTimes(char[] buf, int n){
            int counter = 0;
            while(counter < n){
                if(previdx < prevsize){
                    buf[counter++] = prevbuf[previdx++];
                }
                else {
                    prevsize = read4(prevbuf);
                    previdx = 0;
                    if(prevsize == 0) break;
                }
            }
            return counter;
        }
    }
}

interface Reader4 {
    default int read4(char[] buf4) {
        return 0;
    }
}
