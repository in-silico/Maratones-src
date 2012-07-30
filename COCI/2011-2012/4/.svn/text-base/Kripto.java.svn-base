import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Kripto
{
	static final long MASCARA = 0xffffffffL;
	
	
	static Long[][] modDp = new Long[2][1000000];
	
     static long modPow(int b, int n)
     {
    	 	if(modDp[b][n] != null)
    	 		return modDp[b][n];
            if(n == 0)
                return modDp[b][n] = 1L;
            if(n == 1)
                return modDp[b][n] = (long) (b == 0 ? 31 : 37);
            long res = modPow(b, n / 2);
            res *= res;
            res &= MASCARA;
            if((n & 1) == 1)
            {
                res *= b == 0 ? 31 : 37;
                res &= MASCARA;
            }
            return modDp[b][n] = res;
     }
     
     static long modAdd1(long a, long b)
     {
    	 return (a + b) & MASCARA;
     }
     
     static long modSub(long a, long b)
     {
    	 return ((a - b) + (MASCARA + 1)) & MASCARA;
     }
     
     static long modMul1(long a, long b)
     {
    	 return (a * b) & MASCARA;
     }

    static boolean[] visitados = new boolean[1000000];

    private static boolean iguales(Palabra[] palabrasArriba, Palabra[] palabrasAbajo, int i, int actual)
    {
        for(int j = 0; j < actual; j++)
            visitados[palabrasArriba[i + j].posiciones.peek()] = false;
        for(int j = 0; j < actual; j++)
        {
            if(!visitados[palabrasArriba[i + j].posiciones.peek()])
            {
                Palabra p1 = palabrasArriba[i + j];
                Palabra p2 = palabrasAbajo[j];
                if(p1.posiciones.size() != p2.posiciones.size())
                    return false;
                Iterator <Integer> it = p1.posiciones.iterator();
                Iterator <Integer> it1 = p2.posiciones.iterator();
                for(int k = 0; k < p1.posiciones.size(); k++)
                {
                    int x = it.next();
                    int y = it1.next();
                    if(x != y + i)
                        return false;
                }
            }
            visitados[palabrasArriba[i + j].posiciones.peek()] = true;
        }
        return true;
    }

    static long modInverse(long a)
    {
             long i = MASCARA + 1, v = 0, d = 1;
             while (a > 0)
             {
                  long t = i/a, x = a;
                  a = i % x;
                  i = x;
                  x = d;
                  d = v - t * x;
                  v = x;
             }
             v &= MASCARA;
             if (v < 0) v = (v + (MASCARA + 1)) & MASCARA;
             return v;
    }
    
    static class Palabra
    {
        LinkedList <Integer> posiciones = new LinkedList <Integer> ();
        long hash;

        static final long mod31 = modInverse(31);

        void eliminarPrimera()
        {
        	hash = modSub(hash, posiciones.pollFirst());
            hash = (hash * mod31) & MASCARA;
        }

        void agregar(int a)
        {
            posiciones.add(a);
            hash = (hash + ((modPow(0, posiciones.size() - 1) * a) & MASCARA)) & MASCARA;
        }
    }

    public static void main(String[] args) throws IOException
    {
        HashMap <String, Palabra> hashArriba = new HashMap <String, Palabra> (1000000);
        HashMap <String, Palabra> hashAbajo = new HashMap <String, Palabra> (1000000);
        Palabra[] palabrasArriba = new Palabra[1000000];
        Palabra[] palabrasAbajo = new Palabra[1000000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int actual = 0;
        while(true)
        {
            String siguiente = st.nextToken();
            if(siguiente.equals("$"))
                break;
            Palabra p = hashArriba.get(siguiente);
            if(p == null)
            {
                hashArriba.put(siguiente, new Palabra());
                p = hashArriba.get(siguiente);
            }
            palabrasArriba[actual++] = p;
        }
        st = new StringTokenizer(br.readLine());
        actual = 0;
        while(true)
        {
            String siguiente = st.nextToken();
            if(siguiente.equals("$"))
                break;
            Palabra p = hashAbajo.get(siguiente);
            if(p == null)
            {
                hashAbajo.put(siguiente, new Palabra());
                p = hashAbajo.get(siguiente);
            }
            p.agregar(actual);
            palabrasAbajo[actual++] = p;
        }
        long hash = 0;
        long cambioHash = 0;
        long[] sumas = new long[1000000];
        sumas[0] = 1;
        sumas[1] = 1;
        long act = 31;
        for(int i = 2; i < 500000; i++)
        {
        	sumas[i] = (sumas[i - 1] + act) & MASCARA;
        	act = act * 31;
        	act &= MASCARA;
        }
        for(int i = 0; i < actual; i++)
        {
            if(palabrasAbajo[i].posiciones.peek().intValue() == i)
            {
                long hashElemento = modPow(1, i);
                hashElemento = (hashElemento * palabrasAbajo[i].hash) & MASCARA;
                hash = (hash + hashElemento) & MASCARA;
                long cambioTemp = sumas[palabrasAbajo[i].posiciones.size()];
                cambioTemp = (cambioTemp * modPow(1, i)) & MASCARA;
                cambioHash = (cambioHash + cambioTemp) & MASCARA;
            }
        }
        long hashA = 0;
        for(int i = 0; i < actual; i++)
            palabrasArriba[i].agregar(i);
        for(int i = 0; i < actual; i++)
        {
            if(palabrasArriba[i].posiciones.peek().intValue() == i)
            {
                long hashElemento = modPow(1, i);
                hashElemento = (hashElemento * palabrasArriba[i].hash) & MASCARA;
                hashA = (hashA + hashElemento) & MASCARA;
            }
        }
        for(int i = 0; true; i++)
        {
            if(hash == hashA && iguales(palabrasArriba, palabrasAbajo, i, actual))
            {
                System.out.println(i + 1);
                return;
            }
            Palabra aQuitar = palabrasArriba[i];
            long hashElemento = modPow(1, aQuitar.posiciones.peek());
            hashElemento = (hashElemento * aQuitar.hash) & MASCARA;
            hashA = modSub(hashA, hashElemento);
            aQuitar.eliminarPrimera();
            if(!aQuitar.posiciones.isEmpty())
            {
                hashElemento = modPow(1, aQuitar.posiciones.peek());
                hashElemento = (hashElemento * aQuitar.hash) & MASCARA;
                hashA = (hashA + hashElemento) & MASCARA;
            }
            aQuitar = palabrasArriba[i + actual];
            if(!aQuitar.posiciones.isEmpty())
            {
                hashElemento = modPow(1, aQuitar.posiciones.peek());
                hashElemento = (hashElemento * aQuitar.hash) & MASCARA;
                hashA = modSub(hashA, hashElemento);
            }
            aQuitar.agregar(i + actual);
            hashElemento = modPow(1, aQuitar.posiciones.peek());
            hashElemento = (hashElemento * aQuitar.hash) & MASCARA;
            hashA = (hashA + hashElemento) & MASCARA;
            cambioHash = (cambioHash * 37) & MASCARA;
            hash = (hash * 37) & MASCARA;
            hash = (hash + cambioHash) & MASCARA;
        }
    }
}