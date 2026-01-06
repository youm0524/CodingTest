import java.io.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String s;
        while ((s = br.readLine()) != null) {
            char[] ss = s.toCharArray();
            int small = 0;
            int big = 0;
            int blank = 0;
            int num = 0;
        
            for(int i = 0; i<ss.length; i++){
                char c = ss[i];
                if(Character.isUpperCase(c))big++;
                else if(Character.isLowerCase(c))small++;
                else if(c==' ')blank++;
                else num++;   
            }
                sb.append(small + " " + big + " " + num + " " + blank + "\n");  
        
        }
        System.out.print(sb);
    }
}