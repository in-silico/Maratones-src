package UVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class archaeologist
{
    public static void main(String [] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double numero = 0;
        double log210 = Math.log(10)/Math.log(2);
        while(true)
        {
            try
            {
                numero = Double.parseDouble(br.readLine());
            }
            catch(Exception e)
            {
                return;
            }
            for(int k = ("" + (int)numero).length() + 1; k < Integer.MAX_VALUE; k++)
            {
                if(Math.ceil((Math.log(numero) / Math.log(2)) + (k * log210)) == Math.floor((Math.log(numero + 1) / Math.log(2)) + (k * log210)))
                {
                    System.out.println((int)Math.ceil((Math.log(numero) / Math.log(2)) + (k * log210)));
                    break;
                }
            }
        }
    }
}
