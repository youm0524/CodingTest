package 프로그래머스.level0;

public class 주사위게임3 {
        public int 주사위게임3(int a, int b, int c, int d) {
            int answer = 0;
            if(a==b && b==c && c==d && d==a)
                answer = 1111*a;
            else if(a==b && b==c && c!=d)
                answer = (10*a + d)*(10*a + d);
            else if(a==b && b!=c && b==d)
                answer = (10*a + c)*(10*a + c);
            else if(a!=b && b==c && c==d)
                answer = (10*b + a)*(10*b + a);
            else if(a!=b && a==c && c==d)
                answer = (10*a + b)*(10*a + b);
            else if(a==b&&b!=c)
                if(c==d)
                    answer = (a+c) * Math.abs(a-c);
                else
                    answer = c*d;
            else if(a==c && c!=b)
                if(b==d)
                    answer = (a+b)*Math.abs(a-b);
                else
                    answer = b*d;
            else if(a==d && d!=b)
                if(b==c)
                    answer = (a+b)*Math.abs(a-b);
                else
                    answer = b*c;
            else if(a!=b && b!=c && c!=d && d!=a){
                int min = a;
                min = Math.min(min,b);
                min = Math.min(min,c);
                min = Math.min(min,d);
                answer = min;
            }

            return answer;
        }

}
