import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class A 
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			LinkedList <Integer> grados = new LinkedList <Integer> (); 
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean ceros = true;
			for(int i = 0; i < 6; i++)
			{
				Integer posible = Integer.valueOf(st.nextToken());
				ceros = ceros && posible.intValue() == 0;
				grados.add(posible);
			}
			if(ceros)
				return;
			Collections.sort(grados);
			grados.pollFirst();
			grados.pollLast();
			int acumulado = 0;
			for(int i : grados)
			{
				acumulado += i;
			}
			double resultado = acumulado / 4.0;
			if(resultado == (int) (resultado))
				System.out.println((int) (resultado));
			else
				System.out.println(resultado);
		}
	}

}
