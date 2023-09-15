package programmers;

import java.util.Arrays;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int size=A.length;
        for(int i=0;i<size;i++){
            answer+=A[i]*B[size-i-1];
        }

        return answer;
    }
}
