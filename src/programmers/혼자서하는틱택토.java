package programmers;

public class 혼자서하는틱택토 {
    class Solution {
        public int solution(String[] board) {
            int a=0,b=0;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i].charAt(j)=='O'){
                        a++;
                    }
                    else if(board[i].charAt(j)=='X'){
                        b++;
                    }
                }
            }
            if(a-b>1||a<b) return 0;

            int bingo=0;
            //가로 점검
            for(int i=0;i<3;i++){
                if(board[i].charAt(0)=='O'&&
                        board[i].charAt(1)=='O'&&
                        board[i].charAt(2)=='O'){
                    bingo++;
                }
            }

            //세로 점검
            for(int i=0;i<3;i++){
                if(board[0].charAt(i)=='O'&&
                        board[1].charAt(i)=='O'&&
                        board[2].charAt(i)=='O'){
                    bingo++;
                }
            }

            //대각선 점검
            if(board[0].charAt(0)=='O'&&
                    board[1].charAt(1)=='O'&&
                    board[2].charAt(2)=='O') bingo++;

            if(board[0].charAt(2)=='O'&&
                    board[1].charAt(1)=='O'&&
                    board[2].charAt(0)=='O') bingo++;

            if(bingo>0) {
                if(a!=b+1) return 0;
            }

            int twobingo=0;
            //가로 점검
            for(int i=0;i<3;i++){
                if(board[i].charAt(0)=='X'&&
                        board[i].charAt(1)=='X'&&
                        board[i].charAt(2)=='X'){
                    twobingo++;
                }
            }

            //세로 점검
            for(int i=0;i<3;i++){
                if(board[0].charAt(i)=='X'&&
                        board[1].charAt(i)=='X'&&
                        board[2].charAt(i)=='X'){
                    twobingo++;
                }
            }

            //대각선 점검
            if(board[0].charAt(0)=='X'&&
                    board[1].charAt(1)=='X'&&
                    board[2].charAt(2)=='X') twobingo++;

            if(board[0].charAt(2)=='X'&&
                    board[1].charAt(1)=='X'&&
                    board[2].charAt(0)=='X') twobingo++;

            if(twobingo>0) {
                if(a!=b) return 0;
            }



            return 1;
        }
    }
}
