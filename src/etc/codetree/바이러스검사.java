package etc.codetree;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 바이러스검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        int n=Integer.parseInt(in.readLine());

        int[] store=new int[n];
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            store[i]=Integer.parseInt(st.nextToken());
        }

        int a,b;
        st=new StringTokenizer(in.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());

        Arrays.sort(store);

        long res=n;
        for(int i=0;i<n;i++){
            store[i]-=a;

            if(store[i]<=0) continue;

            int temp=0;
            if(store[i]%b==0){
                temp=store[i]/b;
            }
            else{
                temp=store[i]/b+1;
            }
            res+=temp;
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
