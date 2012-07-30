import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class E
{
	static boolean[] noPrimos = new boolean[1000001];
	
	static void criba()
	{
		for(int i = 2; i <= 1000000; i++)
		{
			if(!noPrimos[i])
			{
				for(int j = i + i; j < 1000001; j += i)
				{
					noPrimos[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		criba();
		ArrayList <Integer> primosEspeciales = new ArrayList <Integer> (200000);
		ArrayList <Integer> primos = new ArrayList <Integer> (200000);
		primosEspeciales.add(2);
		for(int i = 2; i <= 1000000; i++)
		{
			if(!noPrimos[i] && ((i - 1) % 4 == 0))
				primosEspeciales.add(i);
			if(!noPrimos[i])
				primos.add(i);
		}
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			if(l == -1 && u == -1)
				return;
			u += 1;
			int indiceL = Collections.binarySearch(primosEspeciales, l);
			if(indiceL < 0)
			{
				indiceL += 1;
				indiceL = -indiceL;
			}
			int indiceU = Collections.binarySearch(primosEspeciales, u);
			if(indiceU < 0)
			{
				indiceU += 1;
				indiceU = -indiceU;
			}
			int totalE = indiceU - indiceL;
			indiceL = Collections.binarySearch(primos, l);
			if(indiceL < 0)
			{
				indiceL += 1;
				indiceL = -indiceL;
			}
			indiceU = Collections.binarySearch(primos, u);
			if(indiceU < 0)
			{
				indiceU += 1;
				indiceU = -indiceU;
			}
			System.out.println(l + " " + (u - 1) + " " + (indiceU - indiceL) + " " + totalE);
		}
	}
}
