package programmers;

public class 숫자문자열과영단어 {
    class Solution {
        String[] words
                ={"zero","one","two","three","four","five","six","seven","eight","nine"};

        public int solution(String s) {
            StringBuilder str=new StringBuilder();

            int len=s.length();
            for(int i=0;i<len;i++){
                int c=s.charAt(i)-'0';
                if(0<=c&&c<=9){
                    str.append(c);
                }
                else{
                    boolean flag=false;
                    for(int j=0;j<words.length;j++){
                        if(words[j].charAt(0)==s.charAt(i)){
                            flag=true;
                            for(int k=1;k<words[j].length();k++){
                                if(i+k>=len||words[j].charAt(k)!=s.charAt(i+k)){
                                    flag=false;
                                    break;
                                }
                            }
                            if(flag){//찾았다
                                str.append(j);
                                break;
                            }
                            else{//못 찾았다
                                continue;
                            }
                        }
                        if(flag){
                            i+=words[j].length();
                        }
                    }
                }
            }

            return Integer.parseInt(str.toString());
        }
    }
}
