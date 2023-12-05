package programmers;

public class 아날로그시계 {

/*
시침 1시간-30도, 1분-1/2도, 1초-1/120도
분침 1시간-360도, 1분-6도, 1초-1/10도
초침 1시간-360*60도, 1분-360도, 1초-6도
*/

/*
예제) 420초 - 330초
*/

    class Solution {
        public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int answer = 0;

            double 시침움직인각도1=(h1*30+m1*0.5+s1*(1/120))%360;
            double 분침움직인각도1=(h1*360+m1*6+s1*0.1)%360;
            double 초침움직인각도1=h1*360*60+m1*360+s1*6;

            System.out.println(시침움직인각도1+ " "+분침움직인각도1+ " "+초침움직인각도1);

            double 시침움직인각도2=(h2*30+m2*0.5+s2*(1/120))%360;
            double 분침움직인각도2=(h2*360+m2*6+s2*0.1)%360;
            double 초침움직인각도2=h2*360*60+m2*360+s2*6;

            System.out.println(시침움직인각도2+ " "+분침움직인각도2+ " "+초침움직인각도2);


            return answer;
        }
    }
}
