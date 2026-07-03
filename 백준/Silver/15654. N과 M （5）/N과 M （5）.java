
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int[] nums = new int[N];
        for(int i =0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        dfs(nums,result,path,M);

        for(List<Integer> re : result){
            for(int i=0; i<re.size(); i++){
                System.out.print(re.get(i));
                if(i < re.size()-1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void dfs(int[] nums, List<List<Integer>> result, List<Integer> path,int M){
        if(path.size()==M){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i: nums){
            if(!path.contains(i)){
                path.add(i);
                dfs(nums, result, path, M);
                path.remove(path.size()-1);
            }
        }
    }
}
