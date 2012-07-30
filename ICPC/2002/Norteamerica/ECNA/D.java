import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class D 
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			if(pedazos[0].equals("0"))
				return;
			int n = Integer.valueOf(pedazos[0]);
			int k = Integer.valueOf(pedazos[1]);
			boolean[] direccion = new boolean[n + 1];
			for(int i = 1; i <= n; i++)
			{
				direccion[i] = pedazos[i + 1].equals("R");
			}
			boolean[] visitados = new boolean[n + 1];
			int anterior = 1;
			int actual = k;
			int i = 1;
			while(true)
			{
				visitados[actual] = true;
				boolean termino = true;
				for(int j = 1; j <= n; j++)
					if(!visitados[j])
					{
						termino = false;
						break;
					}
				if(termino)
					break;
				int nuevo;
				int distancia = Math.min(n - anterior + actual, Math.min(Math.abs(actual - anterior), Math.abs(n - actual + anterior)));
				if(direccion[actual])
				{
					nuevo = distancia > n / 2 ? anterior - 1 : anterior + 1;
				}
				else
				{
					nuevo = distancia > n / 2  ? anterior + 1 : anterior - 1;
				}
				if(nuevo == 0)
					nuevo = n;
				if(nuevo == n + 1)
					nuevo = 1;
				if(nuevo == actual)
				{
					if(direccion[actual])
						nuevo = actual + 1;
					else
						nuevo = actual - 1;
				}
				if(nuevo == 0)
					nuevo = n;
				if(nuevo == n + 1)
					nuevo = 1;
				direccion[actual] = !direccion[actual];
				anterior = actual;
				actual = nuevo;
				i++;
			}
			System.out.println("Classmate " + actual + " got the ball last after " + i + " tosses.");
		}
	}

}
