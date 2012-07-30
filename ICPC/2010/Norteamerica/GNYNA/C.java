import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class C
{
    static LinkedList <Character> lista = new LinkedList <Character> ();


    public static  String pasarHexa(int n)
    {
        return (Integer.toHexString(n / 16) + "" + Integer.toHexString(n % 16)).toUpperCase();
    }
    
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
                int iguales = 0;
                String anterior = "";
                StringBuilder interno = new StringBuilder();
                String parejaAnterior = "";
                while(!lista.isEmpty())
                {
                    String pareja = leerPar();
                    if(iguales != 130 && pareja.equals(anterior))
                    {
                        interno.append(pareja);
                        iguales++;
                        if(iguales == 3)
                        {
                            interno.setLength(interno.length() - 6);
                            int nParejas = interno.length() / 2;
                            while(nParejas > 127)
                            {
                                        sb.append("7F");
                                        sb.append(interno.substring(0, 128 * 2));
                                        nParejas -= 128;
                                		String a = interno.toString();
                                        interno.setLength(0);
                                        interno.append(a.substring(128 * 2, a.length()));
                            }
                            if(nParejas != 0)
                            {
                                sb.append(pasarHexa(nParejas - 1));
                                sb.append(interno);
                            }
                        }
                    }
                    else
                    {
                        if(iguales >= 3)
                        {
                            iguales -= 3;
                            iguales += 128;
                            sb.append(pasarHexa(iguales));
                            sb.append(parejaAnterior);
                            interno.setLength(0);
                        }
                        anterior = pareja;
                        iguales = 1;
                        interno.append(pareja);
                    }
                    parejaAnterior = pareja;
                }
                if(iguales >= 3)
                {
                    iguales -= 3;
                    iguales += 128;
                    sb.append(pasarHexa(iguales));
                    sb.append(parejaAnterior);
                }
                else
                {
                    int nParejas = interno.length() / 2;
                    while(nParejas > 127)
                    {
                                sb.append("7F");
                                sb.append(interno.substring(0, 128 * 2));
                                nParejas -= 128;
                                String a = interno.toString();
                                interno.setLength(0);
                                interno.append(a.substring(128 * 2, a.length()));
                    }
                    if(nParejas != 0)
                    {
                        sb.append(pasarHexa(nParejas - 1));
                        sb.append(interno);
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
        return (lista.poll() + "" + lista.poll()).toUpperCase();
    }
}
