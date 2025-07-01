package 자바알고리즘인터뷰.문자열;

public class leet_125 {
    public static void main(String[] args) {
        String input = "race a car";
        leet_125 obj = new leet_125();
        boolean isPalindrome = obj.isPalindrome(input);
        System.out.println(isPalindrome);
    }
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(!Character.isLetterOrDigit(s.charAt(start))) start++;
            else if(!Character.isLetterOrDigit(s.charAt(end))) end--;
            else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;

                start++;
                end--;
            }
        }
        return true;
    }

}
