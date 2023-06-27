package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name= {"may", "kein", "kain", "radi"};
        int[] yearning={5, 10, 1, 3};
        String[][] photo={{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        int len=photo.length;
        int[] answer=new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<photo[i].length;j++){
                for(int k=0;k<name.length;k++){
                    if(photo[i][j].equals(name[k])){
                        answer[i]+=yearning[k];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
