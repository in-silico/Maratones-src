

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {

    static class face implements Comparable<face>{
        int w;
        int h;
        public face(int x,int y)
        {
            w=Math.min(x, y);
            h=Math.max(x, y);
        }
        public int compareTo(face o) {
            if (this.w==o.w)
                return this.h-o.h;
            return this.w-o.w;
        }
    }



    static face[] array=new face[6];

    public static void main(String[] args) throws IOException {
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int a,b,tmp;
        while(true)
        {
            String cad=rd.readLine();
            if (cad==null)
                break;
            tk=new StringTokenizer(cad);
            a=Integer.valueOf(tk.nextToken());
            b=Integer.valueOf(tk.nextToken());
            array[0]=new face(a,b);
            for(int i=1;i<6;i++)
            {
                tk=new StringTokenizer(rd.readLine());
                a=Integer.valueOf(tk.nextToken());
                b=Integer.valueOf(tk.nextToken());
                array[i]=new face(a,b);
            }

            Arrays.sort(array,0,6);
            int var1,var2;


            if (array[0].h!=array[1].h || array[0].w!=array[1].w)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            if (array[2].h!=array[3].h || array[2].w!=array[3].w)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            if (array[4].h!=array[5].h || array[4].w!=array[5].w)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            if (array[0].w==array[2].w)
            {
                var1=array[0].h;
                var2=array[2].h;
            }
            else if (array[0].w==array[2].h)
            {
                var1=array[0].h;
                var2=array[2].w;
            }
            else
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }


            if ((array[4].h==var1 && array[4].w==var2) || (array[4].h==var2 && array[4].w==var1))
                System.out.println("POSSIBLE");
            else
                System.out.println("IMPOSSIBLE");
        }
    }

}
