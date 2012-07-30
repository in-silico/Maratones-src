import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class D 
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		System.setOut(new PrintStream("salida.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arreglo = new int[1001];
		arreglo[1] = 1;
		int cambio = 2;
		for(int i = 2; i < 1001; i++)
		{
			arreglo[i] = arreglo[i - 1] + cambio;
			cambio += 2;
		}
		while(true)
		{
			int n = Integer.parseInt(br.readLine().trim());
			if(n == 0)
				return;
			System.out.println(n + " => " + arreglo[n]);
		}
	}

}
