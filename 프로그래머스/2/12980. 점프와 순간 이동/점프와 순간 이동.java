import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        if(n==1)return 1;
        while(n>3){
            if(n%2!=0){
                n-=1;
                ans++;
            }
            n/=2;
            //ystem.out.println(n);
        }
        //System.out.println(n);
        if(n==3)ans+=2;
        if(n%2==0)ans++;
        return ans;
    }
}