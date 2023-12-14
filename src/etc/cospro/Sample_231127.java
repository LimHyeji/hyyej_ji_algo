package etc.cospro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Sample_231127 {
    static class Solution {
        public long 문제1(long num) {
            StringBuilder answer = new StringBuilder();

            num++;
            String temp = String.valueOf(num);
            for (int i = 0; i < temp.length(); i++) {
                answer.append(temp.charAt(i) == '0' ? '1' : temp.charAt(i));
            }

            return Long.parseLong(answer.toString());
        }

        public int 문제2(int n) {
            if(n==1) return 1;
            if(n==2) return 4;

            int answer = 0;

            if(n%2==1){
                int end=n*n;
                answer+=end;
                int sub=0;
                while(true){
                    sub+=4;
                    if(end-2*sub<1) break;
                    answer+=(end-sub)+(end-sub*2);
                    end-=sub*2;
                }
            }
            else{
                int end=n*n-1;
                answer+=end;
                int sub=2;
                end-=sub;
                answer+=end;
                while(true){
                    sub+=4;
                    if(end-2*sub<1) break;
                    answer+=(end-sub)+(end-sub*2);
                    end-=sub*2;
                }
            }

            return answer;
        }

        public int 문제3(String pos) {
            int answer = 0;

            int row=8-(pos.charAt(1)-'0');
            int col=pos.charAt(0)-'A';

            int[] dirR={-2,-2,-1,1,2,2,1,-1};
            int[] dirC={-1,1,2,2,1,-1,-2,-2};

            for(int dir=0;dir<8;dir++){
                int newR=row+dirR[dir];
                int newC=col+dirC[dir];
                if(newR>=0&&newR<8&&newC>=0&&newC<8) answer++;
            }

            return answer;
        }

        public int[] 문제4(int[] arrA, int[] arrB) {
            int arrA_idx = 0, arrB_idx = 0;
            int arrA_len = arrA.length;
            int arrB_len = arrB.length;
            int answer[] = new int[arrA_len + arrB_len];
            int answer_idx = 0;
            while(arrA_idx<arrA_len&&arrB_idx<arrB_len){
                if(arrA[arrA_idx] < arrB[arrB_idx])
                    answer[answer_idx++] = arrA[arrA_idx++];
                else
                    answer[answer_idx++] = arrB[arrB_idx++];
            }
            while(arrA_idx<arrA_len)
                answer[answer_idx++] = arrA[arrA_idx++];
            while(arrB_idx<arrB_len)
                answer[answer_idx++] = arrB[arrB_idx++];
            return answer;
        }

        public int[] 문제5(int N, int[] votes) {
            int voteCounter[] = new int[11];
            for (int i = 0; i < votes.length; i++) {
                voteCounter[votes[i]] += 1;
            }
            int maxVal = 0;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (maxVal < voteCounter[i]) {
                    maxVal = voteCounter[i];
                    cnt = 1;
                }
                else if(maxVal == voteCounter[i]){
                    cnt += 1;
                }
            }
            int answer[] = new int[cnt];
            for (int i = 1, idx = 0; i <= N; i++){
                if (voteCounter[i] == maxVal) {
                    answer[idx] = i;
                    idx += 1;
                }
            }
            return answer;
        }

        public int func6(int record){
            if(record == 0) return 1;
            else if(record == 1) return 2;
            return 0;
        }

        public int 문제6(int[] recordA, int[] recordB){
            int cnt = 0;
            for(int i = 0; i < recordA.length; i++){
                if(recordA[i] == recordB[i])
                    continue;
                else if(recordA[i] == func6(recordB[i]))
                    cnt = cnt + 3;
                else// if(cnt>0)
                    cnt = Math.max(0,cnt-1);//cnt - 1;
            }
            return cnt;
        }

        int 문제7(int[] prices){
            int INF = 1000000001;
            int tmp = INF;
            int answer = -INF;
            for(int price : prices){
                if(tmp != INF)
                    answer = Math.max(answer, price-tmp);
                tmp = Math.min(tmp, price);
            }
            return answer;
        }

        public int 문제8(String[] orderList) {
            DeliveryStore deliveryStore = new PizzaStore();

            deliveryStore.setOrderList(orderList);
            int totalPrice = deliveryStore.getTotalPrice();

            return totalPrice;
        }

        public String func9(String str, int len){
            String padZero = "";
            int padSize = len-str.length();
            for(int i = 0; i < padSize; i++)
                padZero += "0";
            return padZero + str;
        }

        public int 문제9(String binaryA, String binaryB) {
            int maxLength = Math.max(binaryA.length(), binaryB.length());
            binaryA = func9(binaryA, maxLength);
            binaryB = func9(binaryB, maxLength);

            int hammingDistance = 0;
            for(int i = 0; i < maxLength; i++)
                if(binaryA.charAt(i)!=binaryB.charAt(i))
                    hammingDistance += 1;
            return hammingDistance;
        }

        public int func10_a(int numA, int numB, char exp){
            if (exp == '+')
                return numA + numB;
            else if (exp == '-')
                return numA - numB;
            else
                return numA * numB;
        }

        public int func10_b(String exp){
            for(int i = 0; i < exp.length(); i++){
                char e = exp.charAt(i);
                if(e == '+' || e == '-' || e == '*')
                    return i;
            }
            return -1;
        }
        public Pair func10_c(String exp, int idx){
            Pair ret = new Pair();
            ret.firstNum = Integer.parseInt(exp.substring(0, idx));
            ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
            return ret;
        }

        public int 문제10(String expression) {
            int expIndex = func10_b(expression);
            Pair numbers = func10_c(expression,expIndex);
            int result = func10_a(numbers.firstNum,numbers.secondNum,expression.charAt(expIndex));
            return result;
        }
    }

    interface DeliveryStore{
        public void setOrderList(String[] orderList);
        public int getTotalPrice();
    }

    static class Food{
        public String name;
        public int price;
        public Food(String name, int price){
            this.name = name;
            this.price = price;
        }
    }

    static class PizzaStore implements DeliveryStore {
        private ArrayList<Food> menuList;
        private ArrayList<String> orderList;

        public PizzaStore(){
            //init menuList
            menuList = new ArrayList<Food>();
            String[] menuNames = {"Cheese", "Potato", "Shrimp", "Pineapple", "Meatball"};
            int[] menuPrices = {11100, 12600, 13300, 21000, 19500};
            for(int i = 0; i < 5; i++)
                menuList.add(new Food(menuNames[i], menuPrices[i]));

            //init orderList
            orderList = new ArrayList<String>();
        }

        public void setOrderList(String[] orderList){
            for(int i = 0; i < orderList.length; i++)
                this.orderList.add(orderList[i]);
        }

        public int getTotalPrice(){
            int totalPrice = 0;
            Iterator<String> iter = orderList.iterator();
            while (iter.hasNext()) {
                String order = iter.next();
                for(int i = 0; i < menuList.size(); i++)
                    if(order.equals(menuList.get(i).name))
                        totalPrice += menuList.get(i).price;
            }
            return totalPrice;
        }
    }

    static class Pair{
        public int firstNum;
        public int secondNum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        /** 문제1 **/
        long num = 9949999;
        long retLong = sol.문제1(num);

        System.out.println("Solution: return value of the method is " + retLong + " .");

        /** 문제2 **/
        int n1 = 3;
        int retInt = sol.문제2(n1);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        int n2 = 2;
        retInt = sol.문제2(n2);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        /** 문제3 **/
        String pos = "A7";
        retInt = sol.문제3(pos);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        /** 문제4 **/
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] retIntArr = sol.문제4(arrA, arrB);

        System.out.println("Solution: return value of the method is " + Arrays.toString(retIntArr) + " .");

        /** 문제5 **/
        int N1 = 5;
        int[] votes1 = {1,5,4,3,2,5,2,5,5,4};
        retIntArr = sol.문제5(N1, votes1);

        System.out.println("Solution: return value of the method is " + Arrays.toString(retIntArr) + " .");


        int N2 = 4;
        int[] votes2 = {1, 3, 2, 3, 2};
        retIntArr = sol.문제5(N2, votes2);

        System.out.println("Solution: return value of the method is " + Arrays.toString(retIntArr) + " .");

        /** 문제6 **/
        int[] recordA = {2,0,0,0,0,0,1,1,0,0};
        int[] recordB = {0,0,0,0,2,2,0,2,2,2};
        retInt = sol.문제6(recordA, recordB);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        /** 문제7 **/
        int[] prices1 = {1, 2, 3};
        retInt = sol.문제7(prices1);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        int[] prices2 = {3, 1};
        retInt = sol.문제7(prices2);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        /** 문제8 **/
        String[] orderList = {"Cheese", "Pineapple", "Meatball"};
        retInt = sol.문제8(orderList);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        /** 문제9 **/
        String binaryA = "10010";
        String binaryB = "110";
        retInt = sol.문제9(binaryA, binaryB);

        System.out.println("Solution: return value of the method is " + retInt + " .");

        /** 문제10 **/
        String expression = "123+12";
        retInt = sol.문제10(expression);

        System.out.println("Solution: return value of the method is " + retInt + " .");

    }
}
