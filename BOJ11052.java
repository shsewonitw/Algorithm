import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ11052 {
    /*
    입력
        첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)

        둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)


    출력
        첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최댓값을 출력한다.
     */


    /*

        점화식 : D(i) = Pn + D(i-n)

     */
    int solution(int num , int[] inputData){
        int result = 0;

        result = getResult(num, inputData);

        return result;
    };


    int getResult(int num, int[] inputData){

        if (num == 0){
            return 0;
        }
        int result = 0;
        int max = -999;
        for(int i = 0 ; i < num ; i++){
            result = inputData[i] + getResult(num-i, inputData);
            if(result >= max) { max = result; }
        }
        result = max;

        return result;
    };

    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);

        int result = 0;

        int[] inputData = new int[1000];

        int num = 0;

        num = scan.nextInt();

        for(int i = 0 ; i < num ; i++){
            inputData[i] = scan.nextInt();
        }

        BOJ11052 boj11052 = new BOJ11052();
        
        result = boj11052.solution(num, inputData);

        System.out.println(result);
    }

}
