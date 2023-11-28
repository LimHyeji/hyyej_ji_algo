package cospro;

import java.util.Arrays;

public class Sample_231128 {
    static class Solution {
        interface Book {
            public int getRentalPrice(int day);
        }

        class ComicBook implements Book{
            public int getRentalPrice(int day){
                int cost = 500;
                day -= 2;
                if (day > 0)
                    cost += day*200;
                return cost;
            }
        }

        class Novel implements Book{
            public int getRentalPrice(int day){
                int cost = 1000;
                day -= 3;
                if (day > 0)
                    cost += day*300;
                return cost;
            }
        }

        public int 문제1(String[] bookTypes, int day) {
            Book[] books = new Book[50];
            int length = bookTypes.length;
            for (int i = 0; i < length; ++i) {
                if (bookTypes[i].equals("comic"))
                    books[i] = new ComicBook();
                else if (bookTypes[i].equals("novel"))
                    books[i] = new Novel();
            }
            int totalPrice = 0;
            for (int i = 0; i < length; ++i)
                totalPrice += books[i].getRentalPrice(day);
            return totalPrice;
        }

        public int func_a(String times){
            int hour = Integer.parseInt(times.substring(0, 2));
            int minute = Integer.parseInt(times.substring(3));
            return hour*60 + minute;
        }
        public int 문제2(String[] subwayTimes, String currentTime) {
            int currentMinute = func_a(currentTime);
            int INF = 1000000000;
            int answer = INF;
            for(int i = 0; i < subwayTimes.length; ++i){
                int subwayMinute = func_a(subwayTimes[i]);
                if(subwayMinute>=currentMinute){
                    answer = subwayMinute - currentMinute;
                    break;
                }
            }
            if(answer == INF)
                return -1;
            return answer;
        }

        public int func_a(int n){
            int ret = 1;
            while(n > 0){
                ret *= 10;
                n--;
            }
            return ret;
        }

        int func_b(int n){
            int ret = 0;
            while(n > 0){
                ret++;
                n /= 10;
            }
            return ret;
        }

        int func_c(int n){
            int ret = 0;
            while(n > 0){
                ret += n%10;
                n /= 10;
            }
            return ret;
        }

        public int 문제3(int num) {
            int nextNum = num;
            while(true){
                nextNum++;
                int length = func_b(nextNum);
                if(length % 2 != 0)
                    continue;

                int divisor = func_a(length/2);
                int front = nextNum / divisor;
                int back = nextNum % divisor;

                int frontSum = func_c(front);
                int backSum = func_c(back);
                if(frontSum == backSum)
                    break;
            }
            return nextNum - num;
        }

        public int 문제4(int[] arr, int K) {
            int answer = 0;
            int len=arr.length;
            for(int i=0;i<len;i++){
                for(int j=i+1;j<len;j++){
                    for(int k=j+1;k<len;k++){
                        if((arr[i]+arr[j]+arr[k])%K==0) answer++;
                    }
                }
            }
            return answer;
        }

        public int 문제5(int[] arr) {
            int answer = 0,cnt=1;
            int cur=arr[0];
            for(int i=1;i<arr.length;i++){
                if(cur<arr[i]) cnt++;
                else cnt=1;
                cur=arr[i];
                answer=Math.max(answer,cnt);
            }
            return answer;
        }

        public int[] 문제6(String commands) {
            int[] answer = new int[2];
            int len=commands.length();

            int x=0,y=0;
            for(int i=0;i<len;i++){
                switch(commands.charAt(i)){
                    case 'U':
                        y++;
                        break;
                    case 'D':
                        y--;
                        break;
                    case 'L':
                        x--;
                        break;
                    case 'R':
                        x++;
                        break;
                }
            }

            answer[0]=x;
            answer[1]=y;
            return answer;
        }

        public int 문제7(int money) {
            int coin[] = {10, 50, 100, 500, 1000, 5000, 10000, 50000};
            int counter = 0;
            int idx = coin.length - 1;
            while (money > 0){
                counter += money/coin[idx];
                money %= coin[idx];
                idx -= 1;
            }
            return counter;
        }

        public int[] 문제8(int[] arr) {
            int left = 0, right = arr.length - 1;
            int idx = 0;
            int[] answer = new int[arr.length];
            while(left <= right){
                if(idx % 2 == 0){
                    answer[idx] = arr[left];
                    left += 1;
                }
                else{
                    answer[idx] = arr[right];
                    right -= 1;
                }
                idx += 1;
            }
            return answer;
        }

        public boolean 문제9(String password) {
            int length = password.length();
            for(int i = 0; i < length - 2; ++i){
                int firstCheck = password.charAt(i + 1) - password.charAt(i);
                int secondCheck = password.charAt(i+2) - password.charAt(i+1);
                if(firstCheck == secondCheck && (firstCheck == 1 || firstCheck == -1))
                    return false;
            }
            return true;
        }

        public String 문제10(String s) {
            s += '#';
            String answer = "";
            for(int i = 0; i < s.length(); ++i){
                if (s.charAt(i) == '0' && s.charAt(i+1) != '0')
                    answer += "0";
                else if(s.charAt(i)=='1')
                    answer += "1";
            }
            return answer;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        /** 문제1 **/
        String[] bookTypes = {"comic", "comic", "novel"};
        int day = 4;
        int retInt = sol.문제1(bookTypes, day);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        /** 문제2 **/
        String[] subwayTimes1 = {"05:31", "11:59", "13:30", "23:32"};
        String currentTime1 = "12:00";
        retInt = sol.문제2(subwayTimes1, currentTime1);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        String[] subwayTimes2 = {"14:31", "15:31"};
        String currentTime2 = "15:31";
        retInt = sol.문제2(subwayTimes2, currentTime2);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        /** 문제3 **/
        int num1 = 1;
        retInt = sol.문제3(num1);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        int num2 = 235386;
        retInt = sol.문제3(num2);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        /** 문제4 **/
        int[] arr = {1, 2, 3, 4, 5};
        int K = 3;
        retInt = sol.문제4(arr, K);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        /** 문제5 **/
        int[] arr2 = {3, 1, 2, 4, 5, 1, 2, 2, 3, 4};
        retInt = sol.문제5(arr2);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        /** 문제6 **/
        String commands = "URDDL";
        int[] retIntArr = sol.문제6(commands);

        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(retIntArr) + " 입니다.");

        /** 문제7 **/
        int money = 2760;
        retInt = sol.문제7(money);

        System.out.println("solution 메소드의 반환 값은 " + retInt + " 입니다.");

        /** 문제8 **/
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        retIntArr = sol.문제8(arr3);

        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(retIntArr) + " 입니다.");

        /** 문제9 **/
        String password1 = "cospro890";
        boolean ret1 = sol.문제9(password1);

        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");


        String password2 = "cba323";
        boolean ret2 = sol.문제9(password2);

        System.out.println("solution 메소드의 반환 값은 " + ret2+ " 입니다.");

        /** 문제10 **/
        String s = "101100011100";
        String ret = sol.문제10(s);

        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
