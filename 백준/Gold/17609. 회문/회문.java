
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- >0){
            String s = sc.nextLine();
            int left = 0;
            int right = s.length()-1;
            int cnt = 0;
            boolean done = false;
           while(left<right){
               if (s.charAt(left) == s.charAt(right)) {
                   left++;
                   right--;
               }else {
                   if (panlidrome(left + 1, right, s) || panlidrome(left, right - 1, s)) {
                       System.out.println("1");
                   } else System.out.println("2");
                   done = true;
                   break;
               }
            }
            if(!done) System.out.println("0");
        }
    }
    public static boolean panlidrome(int left, int right, String s){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
