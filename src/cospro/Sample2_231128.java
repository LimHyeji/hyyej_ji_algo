package cospro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Sample2_231128 {
    static class Solution {
        int[] func_a(int[] arr) {
            int length = arr.length;
            int[] ret = new int[length*2];
            for(int i = 0; i < length; i++)
                ret[i + length] = ret[i] = arr[i];
            return ret;
        }

        boolean func_b(int[] first, int[] second){
            int[] counter = new int[1001];
            for(int i = 0; i < first.length; i++){
                counter[first[i]]++;
                counter[second[i]]--;
            }
            for(int i = 0; i < 1001; i++)
                if(counter[i] != 0)
                    return false;
            return true;
        }

        boolean func_c(int[] first, int[] second){
            int length = second.length;
            for(int i = 0; i < length; i++){
                int j;
                for(j = 0; j < length; j++)
                    if(first[i + j] != second[j])
                        break;
                if(j == length)
                    return true;
            }
            return false;
        }

        public boolean 문제1(int[] arrA, int[] arrB) {
            if(arrA.length != arrB.length)
                return false;
            if(func_b(arrA,arrB)) {
                int[] arrAtemp = func_a(arrA);
                if(func_c(arrAtemp,arrB))
                return true;
            }
            return false;
        }

        public boolean func_a2(ArrayList<String> list, String s) {
            for (int i = 0; i < list.size(); i++)
                if (s.equals(list.get(i)))
                    return true;
            return false;
        }

        public boolean func_b2(String s) {
            int length = s.length();
            for (int i = 0; i < length / 2; i++)
                if (s.charAt(i) != s.charAt(length - i - 1))
                    return false;
            return true;
        }

        public String func_c2(ArrayList<String> palindromes, int k) {
            Collections.sort(palindromes);
            if (palindromes.size() < k)
                return "NULL";
            else
                return palindromes.get(k-1);
        }

        public String 문제2(String s, int k) {
            ArrayList<String> palindromes = new ArrayList<String>();
            int length = s.length();
            for (int startIdx = 0; startIdx < length; startIdx++) {
                for (int cnt = 1; cnt < length - startIdx + 1; cnt++) {
                    String subStr = s.substring(startIdx, startIdx + cnt);
                    if (func_b2(subStr)) {
                        if (func_a2(palindromes,subStr) == false)
                            palindromes.add(subStr);
                    }
                }
            }

            String answer = func_c2(palindromes,k);
            return answer;
        }

        public int 문제3(String[] bishops) {
            int answer = 0;
            boolean[][] visit=new boolean[8][8];
            int[] dirR={-1,-1,1,1};
            int[] dirC={-1,1,-1,1};
            for(int i=0;i<bishops.length;i++){
                int row=8-(bishops[i].charAt(1)-'0');
                int col=bishops[i].charAt(0)-'A';

                for(int dir=0;dir<4;dir++){
                    int newR=row;
                    int newC=col;
                    while(true){
                        visit[newR][newC]=true;
                        newR+=dirR[dir];
                        newC+=dirC[dir];
                        if(newR<0||newR>=8||newC<0||newC>=8) break;
                    }
                }
            }

            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(!visit[i][j]) answer++;
                }
            }
            return answer;
        }

        public int 문제4(String s1, String s2) {
            int startIdx=0,size=0;
            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    if(i+j== s1.length()) return s1.length()+s2.length()-size;
                    if(s1.charAt(i+j)!=s2.charAt(j)){
                        size=0;
                        break;
                    }
                    if(size==0) startIdx=i;
                    size++;
                }
            }

            return s1.length()+s2.length();
        }

        public String 문제5(String phrases, int second) {
            String answer = "";
            second%=28;
            if(second<=14){
                for(int i=0;i<14-second;i++){
                    answer+="_";
                }
                answer+=phrases.substring(0,second);
            }
            else{
                answer+=phrases.substring(second-14,phrases.length());
                for(int i=0;i<second-14;i++){
                    answer+="_";
                }
            }
            return answer;
        }

        public int 문제6(int n) {
            int answer = 0;
            ArrayList<Integer> primes = new ArrayList<Integer>();
            primes.add(2);
            for (int i = 3; i <= n; i += 2) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++)
                    if (i % j == 0){
                        isPrime = false;
                        break;
                    }
                if (isPrime)
                    primes.add(i);
            }

            int primeLen = primes.size();
            for (int i = 0; i < primeLen - 2; i++)
                for (int j = i + 1; j < primeLen - 1; j++)
                    for (int k = j + 1; k < primeLen; k++)
                        if (primes.get(i)+primes.get(j)+primes.get(k)==n)
                            answer++;
            return answer;
        }

        public int[] 문제7(int k) {
            int[] kaprekarArr = new int[k];
            int count = 0;
            for (int i = 1; i <= k; i++) {
                long squareNum = i * i;
                long divisor = 1;
                while (squareNum / divisor != 0) {
                    long front = squareNum / divisor;
                    long back = squareNum % divisor;
                    divisor *= 10;
                    if (back != 0 && front != 0)
                        if (front + back == i) {
                            kaprekarArr[count] = i;
                            count++;
                        }
                }
            }
            int[] answer = new int[count];
            for (int i = 0; i < count; i++)
                answer[i] = kaprekarArr[i];
            return answer;
        }

        public int 문제8(int k, int[] student) {
            int answer = 0;
            for(int i = 0; i < student.length; i++){
                student[i] -= 4*k;
                if(student[i] <= 0)
                    continue;
                answer += (student[i] + k - 1) / k;
            }
            return answer;
        }

        public int 문제9(int[] revenue, int k) {
            int answer = 0;
            int n = revenue.length;
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += revenue[i];
            }
            answer = sum;
            for (int i = k; i < n; i++) {
                sum = sum - revenue[i - k] + revenue[i];
                if (answer < sum)
                    answer = sum;
            }
            return answer;
        }

        class Shop{
            protected ArrayList<Customer> reserveList;
            public Shop() {
                this.reserveList = new ArrayList<Customer>();
            }
            public boolean reserve(Customer customer){
                reserveList.add(customer);
                return true;
            }
        }
        class Customer{
            public int id;
            public int time;
            public int numOfPeople;
            public Customer(int id, int time, int numOfPeople){
                this.id = id;
                this.time = time;
                this.numOfPeople = numOfPeople;
            }
        }
        class HairShop extends Shop {
        public HairShop(){
                super();
            }

            public boolean reserve(Customer customer){
                if(customer.numOfPeople != 1)
                    return false;

                Iterator<Customer> iter = reserveList.iterator();
                while (iter.hasNext()) {
                    Customer r = iter.next();
                    if(r.time==customer.time)
                        return false;
                }
                reserveList.add(customer);
                return true;
            }
        }
        class Restaurant extends Shop {
        public Restaurant(){
                super();
            }

            public boolean reserve(Customer customer){
                if(customer.numOfPeople<2||customer.numOfPeople>8)
                    return false;
                int count = 0;

                Iterator<Customer> iter = reserveList.iterator();
                while (iter.hasNext()) {
                    Customer r = iter.next();
                    if(r.time==customer.time)
                        count += 1;
                }
                if(count >= 2)
                    return false;
                reserveList.add(customer);
                return true;
            }
        }

        public int 문제10(int[][] customers, String[] shops) {
            Shop hairshop = new HairShop();
            Shop restaurant = new Restaurant();
            int count = 0;
            for(int i = 0; i < shops.length; i++){
                if(shops[i].equals("hairshop")){
                    if(hairshop.reserve(new Customer(customers[i][0], customers[i][1], customers[i][2])))
                        count += 1;
                }
                else if(shops[i].equals("restaurant")){
                    if(restaurant.reserve(new Customer(customers[i][0], customers[i][1], customers[i][2])))
                        count += 1;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            Solution sol = new Solution();

            /** 문제1 **/
            int[] arrA1 = {1, 2, 3, 4};
            int[] arrB1 = {3, 4, 1, 2};
            boolean ret1 = sol.문제1(arrA1, arrB1);

            System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

            int[] arrA2 = {1, 2, 3, 4};
            int[] arrB2 = {1, 4, 2, 3};
            ret1 = sol.문제1(arrA2, arrB2);

            System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

            /** 문제2 **/
            String s1 = new String("abcba");
            int k1 = 4;
            String ret2 = sol.문제2(s1, k1);

            System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

            String s2 = new String("ccddcc");
            int k2 = 7;
            ret2 = sol.문제2(s2, k2);

            System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

            /** 문제3 **/
            String[] bishops1 = {new String("D5")};
            int ret3 = sol.문제3(bishops1);

            System.out.println("solution 메소드의 반환 값은 " + ret3 + " 입니다.");

            String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
            ret3 = sol.문제3(bishops2);

            System.out.println("solution 메소드의 반환 값은 " + ret3 + " 입니다.");

            /** 문제4 **/
            s1 = new String("ababc");
            s2 = new String("abcdab");
            int ret4 = sol.문제4(s1, s2);

            System.out.println("solution 메소드의 반환 값은 " + ret4 + " 입니다.");

            /** 문제5 **/
            String phrases = new String("happy-birthday");
            int second = 3;
            String ret5 = sol.문제5(phrases, second);

            System.out.println("solution 메소드의 반환 값은 " + ret5 + " 입니다.");

            /** 문제6 **/
            int n1 = 33;
            int ret6 = sol.문제6(n1);

            System.out.println("solution 메소드의 반환 값은 " + ret6 + " 입니다.");

            int n2 = 9;
            ret6 = sol.문제6(n2);

            System.out.println("solution 메소드의 반환 값은 " + ret6 + " 입니다.");

            /** 문제7 **/
            int k = 500;
            int[] ret = sol.문제7(k);

            System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");

            /** 문제8 **/
            k1 = 1;
            int[] student1 = {4, 4, 4, 4};
            int ret8 = sol.문제8(k1, student1);

            System.out.println("solution 메소드의 반환 값은 " + ret8 + " 입니다.");

            k2 = 3;
            int[] student2 = {15, 17, 19, 10, 23};
            ret8 = sol.문제8(k2, student2);

            System.out.println("solution 메소드의 반환 값은 " + ret8 + " 입니다.");

            /** 문제9 **/
            int[] revenue1 = {1, 1, 9, 3, 7, 6, 5, 10};
            k1 = 4;
            int ret9 = sol.문제9(revenue1, k1);

            System.out.println("solution 메소드의 반환 값은 " + ret9 + " 입니다.");

            int[] revenue2 = {1, 1, 5, 1, 1};
            k2 = 1;
            ret9 = sol.문제9(revenue2, k2);

            System.out.println("solution 메소드의 반환 값은 " + ret9 + " 입니다.");

            /** 문제10 **/
            int[][] customers = {{1000, 2, 1},{2000, 2, 4},{1234, 5, 1},{4321, 2, 1}, {1111, 3, 10}};
            String[] shops = {"hairshop", "restaurant", "hairshop", "hairshop", "restaurant"};
            int ret10 = sol.문제10(customers, shops);

            System.out.println("solution 메소드의 반환 값은 " + ret10 + " 입니다.");
        }
    }

}
