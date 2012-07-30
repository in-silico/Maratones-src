import java.math.BigInteger;
import java.util.Scanner;


public class A 
{
	private static BigInteger raiz(BigInteger a) 
	{
		BigInteger low = BigInteger.ZERO;
		BigInteger high = a;
		while(low.compareTo(high) < 0)
		{
			BigInteger mid = low.add(high).shiftRight(1);
			BigInteger resultado = mid.multiply(mid);
			if(resultado.compareTo(a) < 0)
				low = mid.add(BigInteger.ONE);
			else if(resultado.compareTo(a) == 0)
				return mid;
			else
				high = mid;
		}
		return low.subtract(BigInteger.ONE);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextBigInteger())
		{
			BigInteger n = sc.nextBigInteger();
			BigInteger k = sc.nextBigInteger();
			BigInteger raiz = (BigInteger.ONE.add(BigInteger.ONE).max(raiz(n.multiply(k).add(BigInteger.TEN.pow(10).shiftRight(2)))));
			raiz = BigInteger.ONE.add(BigInteger.ONE).max(raiz.subtract(BigInteger.TEN.pow(5).shiftRight(1)));
			for(int i = 0; i < 100000; i++)
				if(n.remainder(raiz).equals(BigInteger.ZERO))
				{
					System.out.println(n.divide(raiz).min(raiz) + " * " + n.divide(raiz).max(raiz));
					break;
				}
				else
					raiz = raiz.add(BigInteger.ONE);
		}
		
	}

}
