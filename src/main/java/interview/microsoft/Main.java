package interview.microsoft;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            boolean ans = false;
            int len = in.nextInt();
            String str = in.next();
            for(int j = 0; j < len; j++){
                boolean temp = isBeautiful(str, j, len);
                ans |= isBeautiful(str, j, len);
            }
            if(ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean isBeautiful(String str, int cur, int len){
        int re = 1;
        int itr = cur;
        int total = 1;
        for(itr = itr+1; itr < len; itr++){
            if(str.charAt(cur)==str.charAt(itr)){
                re++;
            }
            else break;
        }
        for(;itr < len; ){
            if(isVali(str, itr, re)){
                itr += re;
                total++;
            }
            else return false;
        }
        if(total == 3) return true;
        else return false;
    }
    public static boolean isVali(String str, int cur, int re){
        if((str.charAt(cur) - str.charAt(cur-1))!=1){
            return false;
        }
        int cnt = 1;
        while(cnt < re && cur < str.length()){
            if(str.charAt(cur) == str.charAt(cur-1)){
                cnt++;
                cur++;
                continue;
            }
            else return false;
        }
        if (cnt == re)
            return true;
        return false;
    }
}