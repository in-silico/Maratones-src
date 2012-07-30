import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class D
{
    static LinkedList <Character> lista = new LinkedList <Character> ();

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        String[] pedazos = br.readLine().split("\\s+");
        for(int aa = 0; aa < nt; aa++)
        {
            lista.clear();
            if(pedazos == null)
                break;
            int n = Integer.parseInt(pedazos[0]);
            int np = Integer.parseInt(pedazos[1]);
            StringBuilder sb = new StringBuilder();
            while(true)
            {
                String pp = br.readLine();
                if(pp == null || pp.length() == 0)
                {
                    pedazos = null;
                    break;
                }
                pedazos = pp.split("\\s+");
                if(pedazos.length > 1)
                    break;
                String linea = pedazos[0];
                for(char c : linea.toCharArray())
                {
                    lista.add(c);
                    if(lista.size() == np * 2)
                        break;
                }
            }
            while(!lista.isEmpty())
            {
                    String count = lista.poll() + "" + lista.poll();
                    int countD = Integer.parseInt(count.charAt(0) + "", 16) * 16 + Integer.parseInt(count.charAt(1) + "", 16);
                    int posCero = Integer.parseInt(count.charAt(0) + "", 16);
                    if(posCero >= 8)
                    {
                        countD = countD & 127;
                        countD += 3;
                        String par = leerPar();
                        for(int i = 0; i < countD; i++)
                            sb.append(par);
                    }
                    else
                    {
                        countD++;
                        for(int i = 0; i < countD; i++)
                        {
                            sb.append(leerPar());
                        }
                    }
            }
            System.out.println(n + " " + (sb.length() / 2));
            int actual = 0;
            while(actual < sb.length())
            {
                System.out.println(sb.substring(actual, Math.min(actual + 80, sb.length())));
                actual = Math.min(actual + 80, sb.length());
            }
         }
      }

    private static String leerPar() 
	{
        return lista.poll() + "" + lista.poll();
    }
}
