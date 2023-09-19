package programmers;

public class 숫자의표현 {
    public int solution(int n) {
    int answer = 1;
    for(int i=1;i<=n/2;i++){
        int sum=0; boolean f=false;
        for(int j=i;j<=n;j++){
            sum+=j;
            if (sum>n) {
                break;
            }
            if(sum==n){
                f=true;
                break;
            }
        }
        if(f) answer++;
    }
    return answer;
}
}
