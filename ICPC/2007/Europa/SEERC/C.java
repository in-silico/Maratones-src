import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class C
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean inicio = false;
		while(true)
		{
			String base = br.readLine();
			if(base == null)
				return;
			while(base != null && base.trim().length() == 0)
				base = br.readLine();
			if(base == null)
				return;
			base = base.trim();
			if(!inicio)
			{
				inicio = true;
			}
			else
			{
				System.out.println();
			}
			while(true)
			{
				String s = br.readLine();
				if(s == null)
					return;
				s = s.trim();
				String ss = s;
				if(s.length() == 0)
					break;
				int maximo = Integer.MIN_VALUE;
				for(char c : s.toCharArray())
					maximo = Math.max(maximo, base.indexOf(c));
				BigInteger suma = BigInteger.ZERO;
				for(int indice = maximo; indice < base.length(); indice++)
				{
					int indiceReal = indice + 1;
					StringBuilder sb = new StringBuilder(ss);
					sb.reverse();
					s = sb.toString();
					BigInteger baseS = BigInteger.valueOf(indiceReal);
					BigInteger potencia = BigInteger.ONE;
					for(char c : s.toCharArray())
					{
						suma = suma.add(BigInteger.valueOf(base.indexOf(c)).multiply(potencia));
						potencia = potencia.multiply(baseS);
					}
				}
				System.out.println(suma);
			}
		}
	}

}
