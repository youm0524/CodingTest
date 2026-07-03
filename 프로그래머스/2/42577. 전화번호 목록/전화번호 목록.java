// import java.util.*;
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         Arrays.sort(phone_book,(a,b)->a.length()-b.length());
//         List<String> phones = new ArrayList<>(Arrays.asList(phone_book));
//         //for(String s: phones)System.out.println(s);
//         for(int i = 0; i<phones.size()-1; i++){
//             for(int j = i+1; j<phones.size(); j++){        
//             if(phones.get(j).substring(0,phones.get(i).length()).equals(phones.get(i)))
//             {return false;}
            
//             }
//                 //answer =  false;
//         }
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 사전순 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
