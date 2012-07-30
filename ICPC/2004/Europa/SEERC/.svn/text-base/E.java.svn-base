import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public class E 
{
	
	public static BigDecimal buscar(BigDecimal n)
	{
		BigDecimal l = BigDecimal.ZERO;
		BigDecimal h = n;
		BigDecimal anterior = BigDecimal.ZERO;
		BigDecimal minimo = new BigDecimal("0.0000000000001");
		while(true)
		{
			BigDecimal mid = l.add(h).divide(new BigDecimal("2"), 100, BigDecimal.ROUND_DOWN);
			BigDecimal pos = mid.multiply(mid).multiply(mid).divide(BigDecimal.ONE, 100, BigDecimal.ROUND_DOWN);
			BigDecimal delta = (pos.subtract(anterior)).abs();
		    if(n.compareTo(pos) < 0)
				h = mid;
			else if(n.compareTo(pos) > 0)
			    l = mid;
			else
				return mid;
		    if(delta.compareTo(minimo) < 0)
		    	return mid;
		    anterior = pos;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextBigDecimal())
		{
			BigInteger entrada = sc.nextBigInteger();
			BigDecimal resBD = buscar(new BigDecimal(entrada)).divide(BigDecimal.ONE, 10, BigDecimal.ROUND_DOWN);
			String res = resBD.toPlainString();
			BigInteger posible = resBD.toBigInteger().add(BigInteger.ONE);
			if(posible.multiply(posible).multiply(posible).equals(entrada))
			{
				res = new BigDecimal(posible).divide(BigDecimal.ONE, 10, BigDecimal.ROUND_DOWN).toPlainString();
			}
			int mod = 0;
			for(char c : res.toCharArray())
			{
				if(c >= '0' && c <= '9')
				{
					mod += (c - '0');
					mod %= 10;
				}
			}
			System.out.println(mod + " " + res);
		}
	}

}
