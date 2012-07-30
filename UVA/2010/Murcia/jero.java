

import java.util.Scanner;



public class Main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        for(int i=0;i<N;i++)
        {
            String cadena =sc.nextLine();
            boolean incrementar=false;
            char a=cadena.charAt(0);
            boolean Flag=true;
            for(int x=1;x<cadena.length()&&Flag==true;x++)
            {
                if (!(car(cadena.charAt(x))==car(a)))
                {
                    if (car(cadena.charAt(x))<car(a))
                    {
                        incrementar=false;
                        Flag=false;
                    }
                    else
                    {
                        incrementar=true;
                        Flag=false;
                    }
                }

            }
            boolean error=false;
            char variable=cadena.charAt(0);
            int cantidad=1;
            for(int p=1;(p<cadena.length())&&(error==false);p++)
            {
                    if (cadena.charAt(p)==variable)
                    {
                        cantidad++;
                        if (cantidad>9)
                        {
                            error=true;
                        }
                    }
                    else
                    {
                        cantidad=1;
                        variable=cadena.charAt(p);
                    }
            }

            int acumulado=car(a);
            
            for(int j=1;(j<cadena.length())&&(error==false);j++)
            {
                if (incrementar)
                {
                    if (car(cadena.charAt(j))>=car(a))
                    {
                        acumulado+=car(cadena.charAt(j));
                        a=cadena.charAt(j);
                    }
                    else
                        error=true;
                }
                else
                {
                    if (car(cadena.charAt(j))<=car(a))
                    {
                        acumulado+=car(cadena.charAt(j));
                        a=cadena.charAt(j);
                    }
                    else
                        error=true;
                }

            }

            if (error)
            {
                System.out.println("error");
            }
            else
            {
                System.out.println(acumulado);
            }
        }
    }



    public static int car(char A)
    {
        if(A=='B')
            return 1;
        else if(A=='U')
            return 10;
         else if(A=='S')
            return 100;
         else if(A=='P')
            return 1000;
         else if(A=='F')
            return 10000;
         else if(A=='T')
            return 100000;
         else
            return 1000000;
    }
}
