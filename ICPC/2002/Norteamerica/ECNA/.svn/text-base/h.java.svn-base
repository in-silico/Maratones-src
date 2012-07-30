import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;


public class h 
{
	static char[][] tablero = new char[600][1010];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.setOut(new PrintStream("salida.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int aa = 0; aa < t; aa++)
		{
			String entrada = br.readLine();
			int operador = 0;
			String[] pedazos = null;
			if(entrada.contains("+"))
			{
				operador = 0;
				pedazos = entrada.split("\\+");
			}
			else if(entrada.contains("-"))
			{
				operador = 1;
				pedazos = entrada.split("\\-");
			}
			else
			{
				operador = 2;
				pedazos = entrada.split("\\*");
			}
			int ultima = 1010;
			BigInteger a = new BigInteger(pedazos[0]);
			BigInteger b = new BigInteger(pedazos[1]);
			int filaActual = 0;
			int columnaActual = 1009;
			ultima = imprimir(filaActual++, columnaActual, a.toString(), ultima);
			char ope = operador == 0 ? '+' : operador == 1 ? '-' : '*';
			int raya = imprimir(filaActual++, columnaActual, ope + b.toString(), 1010);
			ultima = Math.min(raya, ultima);
			int rayaGuardada = filaActual++;
			if(operador < 2)
			{
				BigInteger respuesta = operador == 1 ? a.subtract(b) : a.add(b);
				raya = imprimir(filaActual++, columnaActual, respuesta.toString(), raya);
				imprimirRayas(rayaGuardada, raya);
				ultima = Math.min(raya, ultima);
				for(int i = 0; i < 4; i++)
				{
					for(int j = ultima; j < 1010; j++)
					{
						System.out.print(tablero[i][j] == 0 ? ' ' : tablero[i][j]);
						tablero[i][j] = 0;
					}
					System.out.print("\n");
				}
			}
			else
			{
				char[] aMult = b.toString().toCharArray();
				for(int i = aMult.length - 1; i >= 0; i--)
				{
					if(i == aMult.length - 1)
					{
						raya = imprimir(filaActual++, columnaActual--, a.multiply(BigInteger.valueOf(aMult[i] - '0')).toString(), raya);
						imprimirRayas(rayaGuardada, raya);
						ultima = Math.min(raya, ultima);
						raya = 1010;
					}
					else
					{
						raya = imprimir(filaActual++, columnaActual--, a.multiply(BigInteger.valueOf(aMult[i] - '0')).toString(), raya);
					}
				}
				if(aMult.length > 1)
				{
					filaActual++;
					raya = imprimir(filaActual, 1009, a.multiply(b).toString(), raya);
					imprimirRayas(--filaActual, raya);
					filaActual++;
					filaActual++;
				}
				ultima = Math.min(ultima, raya);
				for(int i = 0; i < filaActual; i++)
				{
					for(int j = ultima; j < 1010; j++)
					{
						System.out.print(tablero[i][j] == 0 ? ' ' : tablero[i][j]);
						tablero[i][j] = 0;
					}
					System.out.print("\n");
				}
			}
			System.out.print("\n");
		}
	}

	private static void imprimirRayas(int filaActual, int ultima)
	{
		for(int i = 1009; i >= ultima; i--)
			tablero[filaActual][i] = '-';
	}

	private static int imprimir(int filaActual, int columnaActual, String string, int ultima)
	{
		int j = 0;
		for(int i = columnaActual; i > columnaActual - string.length(); i--)
		{
			tablero[filaActual][i] = string.charAt(string.length() - 1 - j++);
		}
		return Math.min(ultima, columnaActual - string.length() + 1);
	}
}
