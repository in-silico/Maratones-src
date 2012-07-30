import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Flatworld 
{
	
	static final int N = 0;
	static final int E = 1;
	static final int S = 2;
	static final int W = 3;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] pedazos = br.readLine().split(" ");
		int tamX = Integer.parseInt(pedazos[0]);
		int tamY = Integer.parseInt(pedazos[1]);
		String linea;
		boolean[][] mundo = new boolean[tamX + 1][tamY + 1];
		while((linea = br.readLine()) != null)
		{
			pedazos = linea.split(" ");
			int x = Integer.parseInt(pedazos[0]);
			int y = Integer.parseInt(pedazos[1]);
			String orientacionS = pedazos[2];
			int orientacion = 0;
			if(orientacionS.equals("N"))
				orientacion = N;
			else if(orientacionS.equals("E"))
				orientacion = E;
			else if(orientacionS.equals("S"))
				orientacion = S;
			else if(orientacionS.equals("W"))
				orientacion = W;
			char[] instrucciones = br.readLine().toCharArray();
			boolean seSalio = false;
			for(char c : instrucciones)
			{
				if(c == 'L')
				{
					switch(orientacion)
					{
						case N : orientacion = W; break;
						case E : orientacion = N; break;
						case S : orientacion = E; break;
						case W : orientacion = S; break;
					}
				}
				else if(c == 'R')
				{
					switch(orientacion)
					{
						case N : orientacion = E; break;
						case E : orientacion = S; break;
						case S : orientacion = W; break;
						case W : orientacion = N; break;
					}
				}
				else
				{
					int xSiguiente = x;
					int ySiguiente = y;
					switch(orientacion)
					{
						case N : ySiguiente++; break;
						case E : xSiguiente++; break;
						case S : ySiguiente--; break;
						case W : xSiguiente--; break;
					}
					try
					{
						mundo[xSiguiente][ySiguiente] = mundo[xSiguiente][ySiguiente];
						x = xSiguiente;
						y = ySiguiente;
					}
					catch(Exception e)
					{
						if(!mundo[x][y])
						{
							System.out.println(x + " " + y + " " + ori(orientacion) + " LOST");
							seSalio = true;
							mundo[x][y] = true;
						}
					}
				}
			}
			if(!seSalio)
			{
				System.out.println(x + " " + y + " " + ori(orientacion));
			}
		}
	}
	private static String ori(int orientacion) 
	{
		switch(orientacion)
		{
			case N : return "N";
			case E : return "E";
			case S : return "S";
			case W : return "W";
		}
		return "";
	}

}
