class Solution {
    static int[] rate = {40,30,20,10};
    static int[] result;
    static int total_sub;
    static int total_sell;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        result = new int[emoticons.length];
        //가능한 할인율 조합(중복순열)
        dfs(0,users,emoticons);
        answer[0] = total_sub;
        answer[1] = total_sell;
        return answer;
    }
    public void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            //사용자 계산
            int subscribe = 0;
            int sell = 0;
            for(int[] user : users){
                int r = user[0];
                int limit = user[1];
                int buy = 0;
                for(int i = 0; i<result.length; i++){
                    if(r<=result[i]){
                        buy += 0.01 * (100-result[i]) * emoticons[i];
                        //System.out.println(buy);
                    }
                }
                if(buy>=limit){
                    subscribe++;
                }else{
                    sell += buy;
                }
            }
            // System.out.print(subscribe+" "+sell);
            // System.out.println(" ");
            if(subscribe>total_sub){
                total_sub = subscribe;
                total_sell = sell;
            }else if(subscribe == total_sub){
                if(sell>total_sell)total_sell = sell;
            }
            return;
        }
        for(int i = 0; i<4; i++){
            result[depth] = rate[i];
            dfs(depth+1,users,emoticons);
        }
    }
}