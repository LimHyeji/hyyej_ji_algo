package programmers;

public class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        int count=countOne(n);
        while(true){
            n++;
            int newCount=countOne(n);
            if(count==newCount){
                answer=n;
                break;
            }
        }

        return answer;
    }

    public int countOne(int n){
        int cnt=0;
        while(n>1){
            if(n%2==1) {
                cnt++;
            }
            n/=2;
        }
        if(n%2==1) cnt++;

        return cnt;
    }
}
