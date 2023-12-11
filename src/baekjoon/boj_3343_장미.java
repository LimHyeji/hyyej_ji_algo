package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3343_장미 {
    static long n, a, b, c, d;

    public static void main(String[] args) throws IOException {

        init();
        System.out.println(calculate());

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());

    }

    private static long calculate(){

        long lcd = getLCD();
//        System.out.println("최소공배수 : " + lcd);

        long divide = n / lcd;
        long rest = n % lcd;
//        System.out.println("몫과 나머지 : " + divide + " " + rest);

        long aPrice = (lcd / a) * b;
        long cPrice = (lcd / c) * d;
//        System.out.println("최소공배수 각 가격 : "+aPrice+" "+cPrice);

        long totalPrice = getTotalPrice(divide, rest, aPrice,cPrice);

        return totalPrice;

    }

    private static long getTotalPrice(long divide, long rest, long aPrice, long cPrice) {
        long dividePrice = 0;
        dividePrice += Math.min(aPrice,cPrice) * divide;
//        System.out.println("최소 가격 : " + dividePrice);

        if (rest == 0) {
            return dividePrice;
        }

        long divideRestA = rest / a;
        long restA = rest % a;

        if (restA != 0) {
            divideRestA++;
        }

        long divideRestC = rest / c;
        long restC = rest % c;

        if (restC != 0) {
            divideRestC++;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= divideRestA; i++) {

            long sum = b * i;
            for (int j = 0; j <= divideRestC; j++) {

                sum += d * j;
                if (i * a + j * c >= rest) {
                    ans = Math.min(ans,sum);
                }
            }
        }


        long restPrice =  ans;

        return dividePrice + restPrice;
    }


    private static long getLCD(){

        long gcd = getGCD();
//        System.out.println("최대공약수 : " + gcd);

        if(gcd == 1) return a * c;
        else return gcd * (a/gcd) * (c/gcd);
    }

    private static long getGCD(){

        long min = Math.min(a, c);

        for(long i = min; i >= 2 ;i--){
            if( a % i == 0 && c % i == 0 ){
                return i;
            }
        }

        return 1;
    }
}
