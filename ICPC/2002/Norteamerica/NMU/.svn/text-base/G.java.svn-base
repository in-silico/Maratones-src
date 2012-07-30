import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;


public class G 
{
	
	static BigInteger calcular(LinkedList <Integer> numeros)
	{
		Collections.sort(numeros);
		int total = 0;
		for(int i : numeros)
			total += i;
		int actual = total;
		BigInteger acumulado = BigInteger.ONE;
		while(numeros.size() > 1)
		{
			int numero = numeros.poll();
			acumulado = acumulado.multiply(fact(actual).divide(fact(actual - numero).multiply(fact(numero))));
			actual -= numero;
		}
		return acumulado;
	}

	static TreeMap <Integer, BigInteger> dp = new TreeMap <Integer, BigInteger> ();
	
	static BigInteger fact(int total) 
	{
		if(total == 1)
			return BigInteger.ONE;
		if(!dp.containsKey(total))
			dp.put(total, new BigInteger("" + total).multiply(fact(total - 1)));
		return dp.get(total);
	}

	static BigInteger intentar(String entrada)
	{
		int[] acumulado = new int[26];
		for(char c : entrada.toCharArray())
		{
			if(c >= 'A' && c <= 'Z')
				c = (char) (c - 'A' + 'a');
			if(c >= 'a' && c <= 'z')
				acumulado[c - 'a']++;
		}
		int cambios = 0;
		for(int i = 0; i < 26; i++)
		{
			if(acumulado[i] != 0)
			{
				if((acumulado[i] % 2) == 1)
				{
					acumulado[i]--;
					cambios++;
					if(cambios != 1)
						return BigInteger.ZERO;
				}
			}
		}
		LinkedList <Integer> numeros = new LinkedList <Integer> ();
		for(int i = 0; i < 26; i++)
		{
			if(acumulado[i] != 0)
			{
				numeros.add(acumulado[i] / 2);
			}
		}
		return calcular(numeros);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String entrada = br.readLine();
			if(entrada == null)
				return;
			System.out.println(intentar(entrada));
		}
	}
}
