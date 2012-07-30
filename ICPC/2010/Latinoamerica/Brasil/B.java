import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class B
{
	
	static LinkedList <Character> instrucciones = new LinkedList <Character> ();
	static char[][] arena;
	static final int N = 0, E = 1, S = 2, W = 3;
	
	public static int simular(int i, int j)
	{
		int cuenta = 0; 
		int direccion = 0;
		switch(arena[i][j])
		{
			case 'N' : direccion = N; break;
			case 'S' : direccion = S; break;
			case 'L' : direccion = E; break;
			case 'O' : direccion = W; break;
		}
		arena[i][j] = '.';
		while(instrucciones.size() != 0)
		{
			char insAct = instrucciones.pollFirst();
			if(insAct == 'D')
			{
				switch(direccion)
				{
					case N : direccion = E; break;
					case E : direccion = S; break;
					case S : direccion = W; break;
					case W : direccion = N; break;
				}
			}
			else if(insAct == 'E')
			{
				switch(direccion)
				{
					case N : direccion = W; break;
					case E : direccion = N; break;
					case S : direccion = E; break;
					case W : direccion = S; break;
				}
			}
			else
			{
				int isiguiente = i;
				int jsiguiente = j;
				switch(direccion)
				{
					case N : isiguiente--; break;
					case E : jsiguiente++; break;
					case S : isiguiente++; break;
					case W : jsiguiente--; break;
				}
				try
				{
					char nuevo = arena[isiguiente][jsiguiente];
					if(nuevo == '*')
					{
						cuenta++;
						i = isiguiente;
						j = jsiguiente;
						arena[i][j] = '.';
					}
					else if(nuevo == '.')
					{
						i = isiguiente;
						j = jsiguiente;
					}
				}
				catch(Exception e)
				{
				}
			}
		}
		return cuenta;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			instrucciones.clear();
			String[] lineaUno = br.readLine().split(" ");
			int n = Integer.parseInt(lineaUno[0]);
			int m = Integer.parseInt(lineaUno[1]);
			int s = Integer.parseInt(lineaUno[2]);
			if(n == 0 && m == 0 && s == 0)
				return;
			arena = new char[n][];
			for(int i = 0; i < n; i++)
			{
				arena[i] = br.readLine().toCharArray();
			}
			int ii = 0;
			int jj = 0;
			boolean termino = false;
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					char actual = arena[i][j];
					if(actual == 'N' || actual == 'S' || actual == 'L' || actual == 'O')
					{
						ii = i;
						jj = j;
						termino = true;
						break;
					}
				}
				if(termino)
					break;
			}
			for(char c : br.readLine().toCharArray())
				instrucciones.add(c);
			System.out.println(simular(ii, jj));
		}
	}

}
