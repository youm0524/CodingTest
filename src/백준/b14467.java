package 백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> maps = new HashMap<>();
        int count = 0;

        for(int i = 0; i<N; i++){
            int key = sc.nextInt();
            int value = sc.nextInt();

            if(maps.containsKey(key)){
                if(maps.get(key)==value) continue;
                else{
                    maps.put(key,value);
                    count++;
                }
            }
            else{
                maps.put(key,value);
            }
        }

        System.out.println(count);
    }
}
