import java.util.Scanner;

public class BOJ11052 {

    public static int[] P;
    public static int[] d;
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


    public static void main(String[] args) {
        BOJ11052 boj11052 = new BOJ11052();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        P = new int[n];
        d = new int[n+1];
        for( int i=0 ; i<n ; i++ ){
            P[i] = scan.nextInt();
        }

        int result = 0 ;

        result = boj11052.getMaxPrice(n);

        System.out.println(result);


    }

    int getMaxPrice(int n){
        if(n == 0){
            return 0;
        }

        if(d[n] > 0){
            return d[n];
        }

        for( int i = 1 ; i <= n ; i++ ){
            int temp = P[i-1]+getMaxPrice(n-i);
            d[n] = Math.max(temp,d[n]);
        }


        return d[n];
    }

}
