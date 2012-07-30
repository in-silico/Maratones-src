import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class g 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] pedazos = br.readLine().split(" ");
			int numero = Integer.parseInt(pedazos[0]);
			if(numero == 0)
				return;
			int[]  numeros = new int[numero];
			for(int i = 0; i < numero; i++)
			{
				numeros[i] = Integer.parseInt(pedazos[i + 1]);
			}
			int maximo = Integer.MIN_VALUE;
			for(int i = 0; i < numero; i++)
			{
				int restantes = numero - i - 1;
				maximo = Math.max(restantes - (numeros[i] - 1), maximo);
			}
			System.out.println(maximo);
		}
	}

}
