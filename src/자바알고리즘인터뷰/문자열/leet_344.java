package 자바알고리즘인터뷰.문자열;

public class leet_344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }
        public static void reverseString(char[] s) {
            // char[] reverse = new char[s.length];
            // for(int i = 0; i<s.length; i++){
            //     reverse[i] = s[s.length-1-i];
            // }

            // for(int i =0; i<s.length;i++){
            //     s[i] = reverse[i];
            //
            int start = 0;
            int end = s.length-1;
            while(start<end){
                //임시 변수를 이용한다
                char tmp = s[start];
                s[start] = s[end];
                s[end] = tmp;
                start ++;
                end--;
            }
            for(int i = 0; i<s.length;i++)System.out.print(s[i]);
        }
    }

