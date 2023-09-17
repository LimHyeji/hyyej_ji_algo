package programmers;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";

        boolean flag=true;
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]==' '){
                answer+=' ';
                flag=true;
            }
            else{
                if(flag){
                    answer+=check(c[i],flag);
                    flag=false;
                }
                else{
                    answer+=check(c[i],flag);
                }
            }
        }
        return answer;
    }

    static char check(char c, boolean flag){//flag true(대문자) false(소문자)
        if(c-'A'<0) return c;
        else if(c-'a'<0){//대문자인 경우
            if(flag) return c;
            else return (char)(c+32);
        }
        else{//소문자인 경우
            if(flag) return (char)(c-32);
            else return c;
        }
    }
}
