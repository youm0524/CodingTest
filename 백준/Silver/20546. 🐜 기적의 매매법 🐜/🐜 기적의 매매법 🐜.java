import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] price = new int[14];
        for(int i = 0; i<14; i++){
            price[i] = sc.nextInt();
        }
        int bnp_total = total;
        int bnp_count = 0;
        int bnp_sum = 0;
        for(int a : price){
            if(a<=bnp_total){
                while(bnp_total>=a){
                    bnp_count++;
                    bnp_total = bnp_total-a;
                }
                break;
            }
        }
        bnp_sum = bnp_count*price[13] + bnp_total;
        //System.out.println(bnp_sum);

        int tim_total = total;
        int tim_count = 0;
        int tim_sum = 0;

        for(int i = 0; i<11; i++){
            if(price[i]>price[i+1] && price[i+1]>price[i+2]){
                if(tim_total>price[i+3]){
                    while(tim_total>=price[i+3]){
                        tim_total = tim_total-price[i+3];
                        //System.out.println(tim_total);
                        tim_count++;
                    }
                }

            }
            if(price[i]<price[i+1] && price[i+1]<price[i+2]){
                //매수가 됐냐
                if(tim_count==0) continue;
                tim_total += tim_count*price[i+3];
                tim_count=0;
                //System.out.println(tim_total);
            }
        }
        tim_sum = tim_count*price[13] + tim_total;
       // System.out.println(tim_sum);
        if(bnp_sum>tim_sum)System.out.println("BNP");
        else if(bnp_sum<tim_sum) System.out.println("TIMING");
        else System.out.println("SAMESAME");

    }

}
