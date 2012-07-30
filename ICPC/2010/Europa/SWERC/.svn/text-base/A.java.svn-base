import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class A
{
	static double w;
	
	public static boolean resolver(double[] numeros, int limite)
	{
		Arrays.sort(numeros);
		double anterior = 0;
		boolean paila = false;
		for(double d : numeros)
		{
			if(d - w > anterior)
			{
				paila = true;
				break;
			}
			anterior = d + w;
		}
		if(numeros[numeros.length - 1] + w < limite)
			paila = true;
		return !paila;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int x = Integer.parseInt(pedazos[0]);
			int y = Integer.parseInt(pedazos[1]);
			w = Double.parseDouble(pedazos[2]) / 2;
			if(x == 0 && y == 0)
				return;
			double[] primero = new double[x];
			int i = 0;
			for(String s : br.readLine().split(" "))
				primero[i++] = Double.parseDouble(s);
			boolean posible = resolver(primero, 75);
			double[] segundo = new double[y];
			i = 0;
			for(String s : br.readLine().split(" "))
				segundo[i++] = Double.parseDouble(s);
			posible = posible && resolver(segundo, 100);
			if(posible)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
