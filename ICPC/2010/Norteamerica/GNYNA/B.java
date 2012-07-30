import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class B
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int aa = 0; aa < n; aa++)
        {
            int nn = sc.nextInt();
            String s = sc.next();
            int ttt = 0;
            int tth = 0;
            int tht = 0;
            int thh = 0;
            int htt = 0;
            int hth = 0;
            int hht = 0;
            int hhh = 0;
            for(int i = 0; i <= s.length() - 3; i++)
            {
                String ss = s.substring(i, i + 3);
                if(ss.equals("TTT"))
                    ttt++;
                else if(ss.equals("TTH"))
                    tth++;
                else if(ss.equals("THT"))
                    tht++;
                else if(ss.equals("THH"))
                    thh++;
                else if(ss.equals("HTT"))
                    htt++;
                else if(ss.equals("HTH"))
                    hth++;
                else if(ss.equals("HHT"))
                    hht++;
                else if(ss.equals("HHH"))
                    hhh++;
            }
            System.out.println(nn + " " + ttt + " " + tth + " " + tht + " " + thh + " " + htt + " " + hth + " " + hht + " " + hhh);
        }
    }
}
