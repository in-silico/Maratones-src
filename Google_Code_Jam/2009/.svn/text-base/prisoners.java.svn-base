package GoogleCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;


public class prisoners 
{

	
	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("a.in"));
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			int p = sc.nextInt();
			int q = sc.nextInt();

			int[] aSoltar = new int[q];
			for(int j = 0; j < q; j++)
			{
				aSoltar[j] = sc.nextInt();
			}
			PermutationGenerator s = new PermutationGenerator(q, aSoltar);
			int minima = Integer.MAX_VALUE;
			while(s.hasMore())
			{
				int[] actual = s.getNext();
				boolean[] prision = new boolean[p];
				minima = Math.min(minima, comprobar(actual, prision));
			}
			System.out.println("Case #" + (i + 1) + ": " + minima);
		}
	}

	private static int comprobar(int[] actual, boolean[] prision) 
	{
		for(int i = 0; i < prision.length; i++)
		{
			prision[i] = true;
		}
		int acumulado = 0;
		for(int x : actual)
		{
			x = x - 1;
			prision[x] = false;
			int actual1 = x - 1;
			while(actual1 != -1 && prision[actual1])
			{
				acumulado++;
				actual1--;
			}
			actual1 = x + 1;
			while(actual1 != prision.length && prision[actual1])
			{
				acumulado++;
				actual1++;
			}
		}
		return acumulado;
	}
}
	class PermutationGenerator {

		  private int[] a;
		  private BigInteger numLeft;
		  private BigInteger total;

		  //-----------------------------------------------------------
		  // Constructor. WARNING: Don't make n too large.
		  // Recall that the number of permutations is n!
		  // which can be very large, even when n is as small as 20 --
		  // 20! = 2,432,902,008,176,640,000 and
		  // 21! is too big to fit into a Java long, which is
		  // why we use BigInteger instead.
		  //----------------------------------------------------------

		  public PermutationGenerator (int n, int[] a) {
		    if (n < 1) {
		      throw new IllegalArgumentException ("Min 1");
		    }
		    this.a = a;
		    total = getFactorial (n);
		    numLeft = new BigInteger (total.toString ());
		  }

		  //------
		  // Reset
		  //------

		  public void reset () {
		    for (int i = 0; i < a.length; i++) {
		      a[i] = i;
		    }
		    numLeft = new BigInteger (total.toString ());
		  }

		  //------------------------------------------------
		  // Return number of permutations not yet generated
		  //------------------------------------------------

		  public BigInteger getNumLeft () {
		    return numLeft;
		  }

		  //------------------------------------
		  // Return total number of permutations
		  //------------------------------------

		  public BigInteger getTotal () {
		    return total;
		  }

		  //-----------------------------
		  // Are there more permutations?
		  //-----------------------------

		  public boolean hasMore () {
		    return numLeft.compareTo (BigInteger.ZERO) == 1;
		  }

		  //------------------
		  // Compute factorial
		  //------------------

		  private BigInteger getFactorial (int n) {
		    BigInteger fact = BigInteger.ONE;
		    for (int i = n; i > 1; i--) {
		      fact = fact.multiply (new BigInteger (Integer.toString (i)));
		    }
		    return fact;
		  }

		  //--------------------------------------------------------
		  // Generate next permutation (algorithm from Rosen p. 284)
		  //--------------------------------------------------------

		  public int[] getNext () {

		    if (numLeft.equals (total)) {
		      numLeft = numLeft.subtract (BigInteger.ONE);
		      return a;
		    }

		    int temp;

		    // Find largest index j with a[j] < a[j+1]

		    int j = a.length - 2;
		    while (a[j] > a[j+1]) {
		      j--;
		    }

		    // Find index k such that a[k] is smallest integer
		    // greater than a[j] to the right of a[j]

		    int k = a.length - 1;
		    while (a[j] > a[k]) {
		      k--;
		    }

		    // Interchange a[j] and a[k]

		    temp = a[k];
		    a[k] = a[j];
		    a[j] = temp;

		    // Put tail end of permutation after jth position in increasing order

		    int r = a.length - 1;
		    int s = j + 1;

		    while (r > s) {
		      temp = a[s];
		      a[s] = a[r];
		      a[r] = temp;
		      r--;
		      s++;
		    }

		    numLeft = numLeft.subtract (BigInteger.ONE);
		    return a;

		  }


}
