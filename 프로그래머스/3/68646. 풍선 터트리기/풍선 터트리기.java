class Solution {
    public int solution(int[] a) {
        //양쪽 끝은 무조건 생존 가능
        int answer = 0;
        
        int idx = 1;
        int n = a.length; 
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[0] = a[n-1];
        //왼쪽 기준 나보다 작은애
        for(int i = 1; i<n; i++){
            if(a[i]<left[i-1])left[i] = a[i];
            else left[i] = left[i-1];
        }
        
        //오른쪽 기준
        for(int i = n-2; i>0; i--){
            if(a[i]<right[n-i-2])right[n-i-1] = a[i];
            else right[n-i-1] = right[n-i-2];
            
        }
        // for(int i = 0; i<n; i++){
        //     System.out.println(right[i]);
        // }
        //System.out.println(left[i]);
        for(int i = 0; i<n; i++){
            if(left[i]==a[i] || right[n-i-1]==a[i])answer++;
        }
        return answer;
    }
}