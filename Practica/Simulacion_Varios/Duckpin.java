import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Duckpin 
{
	static class Juego
	{
		int[][] juego = new int[12][4];
		boolean[] chuza = new boolean[10];
		boolean[] media = new boolean[10];
		int[] resultado = new int[10];
		
		public int leer(StringTokenizer st)
		{
			String lectura = st.nextToken();
			if(lectura.charAt(0) == '-')
				return -11;
			else
				return Integer.parseInt(lectura);
		}
		
		public Juego(String p, String s, String t)
		{
			StringTokenizer primera = new StringTokenizer(p);
			StringTokenizer segunda = new StringTokenizer(s);
			StringTokenizer tercera = new StringTokenizer(t);
			for(int i = 0; i < 10; i++)
			{
				juego[i][1] = -11;
				juego[i][2] = -11;
				int lectura = leer(primera);
				juego[i][0] = lectura;
				if(lectura < 0 || lectura == 10)
				{
					if(lectura == 10)
						chuza[i] = true;
					juego[i][3] = 1;
					continue;
				}
				int lecturaUno = leer(segunda);
				juego[i][1] = lecturaUno;
				if(lecturaUno < 0 || lectura + lecturaUno == 10)
				{
					if(lecturaUno >= 0 && lectura + lecturaUno == 10)
						media[i] = true;
					juego[i][3] = 2;
					continue;
				}
				juego[i][2] = leer(tercera);
				juego[i][3] = 3;
			}
			if(media[9] || chuza[9])
				juego[10][0] = leer(primera);
			if(juego[10][0] >= 0 && chuza[9])
				juego[11][0] = leer(primera);
			juego[10][3] = juego[11][3] = 1;
			
		}
		
		public void calcularResultado()
		{
			int anterior = 0;
			for(int i = 0; i < 10; i++)
			{
				int acum = 0;
				for(int j = 0; j < juego[i][3]; j++)
					acum += juego[i][j] > 0 ? juego[i][j] : 0;
				if(chuza[i])
				{
					if(juego[i + 1][3] == 1)
					{
						if(juego[i + 1][0] >= 0)
						{
							acum += juego[i + 1][0];
							acum += juego[i + 2][0] > 0 ? juego[i + 2][0] : 0;
						}
					}
					else
					{
						if(juego[i + 1][0] >= 0)
						{
							acum += juego[i + 1][0];
							acum += juego[i + 1][1] > 0 ? juego[i + 1][1] : 0;
						}
					}
				}
				else if(media[i])
				{
					acum += juego[i + 1][0] > 0 ? juego[i + 1][0] : 0;
				}
				acum += anterior;
				resultado[i] = acum;
				anterior = acum;
			}
		}
	}
	
	static class Jugador
	{
		String nombre;
		String nombre10;
		int mejorLinea = -1;
		int puntuacion = 0;
		
		public Jugador(String n)
		{
			nombre = n;
			StringBuilder sb = new StringBuilder(10);
			sb.append(nombre);
			while(sb.length() != 10)
				sb.append(' ');
			nombre10 = sb.toString();
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int numeroJugadores = Integer.parseInt(br.readLine());
			if(numeroJugadores == 0)
				return;
			Jugador[] jugadores = new Jugador[numeroJugadores];
			StringTokenizer nombres = new StringTokenizer(br.readLine());
			for(int i = 0; i < numeroJugadores; i++)
				jugadores[i] = new Jugador(nombres.nextToken());
			for(int i = 0; i < 3; i++)
			{
				for(Jugador j : jugadores)
				{
					Juego nuevo = new Juego(br.readLine(), br.readLine(), br.readLine());
					nuevo.calcularResultado();
					System.out.print(j.nombre10);
					for(int r : nuevo.resultado)
						System.out.print(r >= 100 ? (" " + r) : (r >= 10 ? ("  " + r) : ("   " + r)));
					System.out.println();
					j.mejorLinea = Math.max(j.mejorLinea, nuevo.resultado[9]);
					j.puntuacion += nuevo.resultado[9];
				}
			}
			int mejorLinea = -1;
			int mejorResultado = -1;
			Jugador mLinea = null;
			Jugador mResultado = null;
			for(Jugador j : jugadores)
			{
				if(j.mejorLinea > mejorLinea)
				{
					mejorLinea = j.mejorLinea;
					mLinea = j;
				}
				if(j.puntuacion > mejorResultado)
				{
					mejorResultado = j.puntuacion;
					mResultado = j;
				}
			}
			System.out.println(mResultado.nombre + " has the high series score of " + mResultado.puntuacion + ".");
			System.out.println(mLinea.nombre + " has the high game score of " + mLinea.mejorLinea + ".");
			br.readLine();
			System.out.println();
		}
	}

}
