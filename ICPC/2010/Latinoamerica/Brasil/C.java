import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Map.Entry;


public class C 
{
	
	static TreeMap <Integer, byte[]> mapa;
	
	
	public static void llenar(TreeMap <Integer, byte[]> mapaNuevo, int valor, int sumaResta, byte[] arregloActual, int i, int n)
	{
		if(mapaNuevo.containsKey(valor))
		{
			byte[] arregloSuma = mapaNuevo.get(valor);
			for(int j = 0; j < i; j++)
				if(arregloSuma[j] != arregloActual[j])
					arregloSuma[j] = 3;
			arregloSuma[i] = (byte) (arregloSuma[i] == sumaResta ? sumaResta : 3);
		}
		else
		{
			byte[] arregloNuevo = new byte[n];
			for(int j = 0; j < i; j++)
				arregloNuevo[j] = arregloActual[j];
			arregloNuevo[i] = (byte) sumaResta;
			mapaNuevo.put(valor, arregloNuevo);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int n = Integer.parseInt(pedazos[0]);
			int f = Integer.parseInt(pedazos[1]);
			if(n == 0 && f == 0)
				return;
			mapa = null;
			mapa = new TreeMap <Integer, byte[]> ();
			byte[] unoR = new byte[n];
			byte[] unoS = new byte[n];
			unoS[0] = 1;
			int primerValor = Integer.parseInt(br.readLine());
			mapa.put(primerValor, unoS);
			mapa.put(-primerValor, unoR);
			for(int i = 1; i < n; i++)
			{
				TreeMap <Integer, byte[]> mapaNuevo = new TreeMap <Integer, byte[]> ();
				int actual = Integer.parseInt(br.readLine());
				for(Entry <Integer, byte[]> entrada : mapa.entrySet())
				{
					int suma = entrada.getKey() + actual;
					int resta = entrada.getKey() - actual;
					byte[] arregloActual = entrada.getValue();
					llenar(mapaNuevo, suma, 1, arregloActual, i, n);
					llenar(mapaNuevo, resta, 0, arregloActual, i, n);
				}
				mapa = null;
				mapa = mapaNuevo;
			}
			if(mapa.containsKey(f))
			{
				byte[] solucion = mapa.get(f);
				for(int i = 0; i < n; i++)
				{
					System.out.print(solucion[i] == 3 ? "?" : solucion[i] == 1 ? "+" : "-");
				}
				System.out.println();
			}
			else
			{
				System.out.println("*"); 
			}
		}
	}
}
