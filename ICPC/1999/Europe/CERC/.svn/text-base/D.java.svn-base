import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;


public class D 
{
	
	
	static BigInteger[] mascaras = new BigInteger[1001];
	
	public static void llenarMascaras()
	{
		mascaras[0] = BigInteger.ZERO;
		for(int i = 1; i < 1001; i++)
			mascaras[i] = mascaras[i - 1].shiftLeft(1).add(BigInteger.ONE);
	}
	
	static int tamFila, d, tamFilaKey, dKey;
	
	static BigInteger[] llave = new BigInteger[101];
	static boolean[] sePuede = new boolean[1001];
	static boolean[] sePuedeAnt = new boolean[1001];
	
	public static void simular() throws IOException
	{
		LinkedList <BigInteger> lista = new LinkedList <BigInteger> ();
		for(int i = 0; i < dKey; i++)
		{
			lista.add(BigInteger.ZERO);
		}
		for(int i = 0; i < tamFila; i++)
		{
			sePuede[i] = false;
		}
		for(int i = 0; i < tamFilaKey; i++)
		{
			sePuedeAnt[i] = false;
		}
		for(int i = tamFilaKey; i <= tamFila; i++)
		{
			sePuedeAnt[i] = true;
		}
//		sePuedeAnt[tamFilaKey] = true;
		int depth = 0;
		for(int i = 0; i < d + dKey; i++)
		{
			lista.poll();
			if(i < d)
			{
				lista.addLast(convertirEntradaBI(br.readLine(), tamFila));
			}
			else
			{
				lista.addLast(BigInteger.ZERO);
			}
			for(int j = tamFilaKey; j <= tamFila; j++)
			{
				boolean sePuedeE = false;
				if(j != 0)
					sePuedeE |= sePuede[j - 1];
				sePuedeE |= sePuedeAnt[j];
				if(sePuedeE)
				{
					int actual = -1;
					boolean termino = false;
					for(BigInteger b : lista)
					{
						actual++;
						if(!darPedazo(b, j - tamFilaKey).and(llave[actual]).equals(BigInteger.ZERO))
						{
							termino = true;
							break;
						}
					}
					if(!termino)
					{
						depth = i + 1;
						sePuede[j] = true;
					}
					else
					{
						sePuede[j] = false;
					}
				}
				else
				{
					sePuede[j] = false;
				}
			}
			boolean[] temp = sePuedeAnt;
			sePuedeAnt = sePuede;
			sePuede = temp;
			for(int j = tamFila; j >= tamFilaKey; j--)
			{
				boolean sePuedeE = false;
				if(j != tamFila)
					sePuedeE |= sePuedeAnt[j + 1];
				if(sePuedeE)
				{
					int actual = -1;
					boolean termino = false;
					for(BigInteger b : lista)
					{
						actual++;
						if(!darPedazo(b, j - tamFilaKey).and(llave[actual]).equals(BigInteger.ZERO))
						{
							termino = true;
							break;
						}
					}
					if(!termino)
					{
						depth = i + 1;
						sePuedeAnt[j] = true;
					}
				}
			}
		}
		System.out.println(depth == d + dKey ? "The key can fall through." : "The key falls to depth " + depth + ".");
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	private static BigInteger darPedazo(BigInteger fila, int inicio)
	{
	//	System.out.println(fila.toString(2) + " " + (tamFila - tamFilaKey - inicio) + " " + inicio + " " + tamFilaKey + " " +  fila.and(mascaras[tamFila - inicio]).shiftRight(tamFila - tamFilaKey - inicio).toString(2));
		return fila.and(mascaras[tamFila - inicio]).shiftRight(tamFila - tamFilaKey - inicio);
	}
	
	private static BigInteger convertirEntradaBI(String entrada, int tam) 
	{
		try
		{
			StringBuilder entradaConvertida = new StringBuilder(tam);
			boolean empezo = false;
			for(int i = 0; i < tam; i++)
			{
				char act = entrada.charAt(i);
				if(act == '.')
				{
					if(empezo)
					{
						entradaConvertida.append('0');
					}
				}
				else 
				{
					empezo = true;
					entradaConvertida.append('1');
				}
			}
			if(entradaConvertida.length() == 0)
				return BigInteger.ZERO;
			return new BigInteger(entradaConvertida.toString(), 2);
		}
		catch(Exception e)
		{
			throw(new RuntimeException());
		}
	}
	
	static String[] filaS = new String[101];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
//		System.setOut(new PrintStream("salida.txt"));
		int t = Integer.parseInt(br.readLine());
		llenarMascaras();
		for(int i = 0; i < t; i++)
		{
			String[] pedazos = br.readLine().split(" ");
			dKey = Integer.parseInt(pedazos[0]);
			tamFilaKey = Integer.parseInt(pedazos[1]);
			for(int j = 0; j < dKey; j++)
			{
				filaS[j] = br.readLine();
			}
			pedazos = br.readLine().split(" ");
			d = Integer.parseInt(pedazos[0]);
			tamFila = Integer.parseInt(pedazos[1]);
			for(int j = 0; j < dKey; j++)
			{
				llave[j] = convertirEntradaBI(filaS[j], tamFilaKey);
			}
			simular();
		}
	}

}
