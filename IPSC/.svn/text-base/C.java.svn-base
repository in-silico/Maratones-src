import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class C
{
	static ArrayList <Integer> numeros = new ArrayList <Integer> (1000000);
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		for(int i = 0; i < t; i++)
		{
			br.readLine();
			int n = Integer.valueOf(br.readLine());
			for(int j = 0; j < n; j++)
			{
				numeros.add(Integer.valueOf(br.readLine().split(" ")[1]));
			}
			Collections.sort(numeros);
			long cuenta = 0;
			int indice = 1;
			for(int actual : numeros)
			{
				cuenta +=  Math.abs(actual - indice++);
			}
			System.out.println(cuenta);
			numeros.clear();
		}
	}

}
