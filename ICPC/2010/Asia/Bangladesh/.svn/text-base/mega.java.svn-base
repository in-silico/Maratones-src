import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class mega {

	/*************************************************************************
	 *  Compilation:  javac Perm.java
	 *  Execution:    java Permutations N k
	 *  
	 *  Enumerates all permutations of size k chosen from N elements.
	 *
	 *  % java Permutations 4 2 | sort
	 *  ab
	 *  ac
	 *  ad
	 *  ba 
	 *  bc
	 *  bd
	 *  ca
	 *  cb
	 *  cd
	 *  da
	 *  db 
	 *  dc 
	 *
	 *  Limitations
	 *  -----------
	 *    *  Assumes N <= 52
	 *
	 *************************************************************************/

	static class Perm {

	    static void choose(char[] a, int R) { enumerate(a, a.length, R); }

	    static void enumerate(char[] a, int n, int r) {
	        if (r == 0) {
	            for (int i = n; i < a.length; i++)
	                System.out.print(a[i]);
	            System.out.println();
	            return;
	        }
	        for (int i = 0; i < n; i++) {
	            swap(a, i, n-1);
	            enumerate(a, n-1, r-1);
	            swap(a, i, n-1);
	         }
	    }  

	    // helper function that swaps a[i] and a[j]
	    static void swap(char[] a, int i, int j) {
	        char temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }


	    // sample client
	    static void main1(String[] args) {
	        int N = Integer.parseInt(args[0]);
	        int k = Integer.parseInt(args[1]);
	        String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	        char[] a = new char[N];
	        for (int i = 0; i < N; i++)
	            a[i] = elements.charAt(i);
	        choose(a, k);
	    }

	}
	
	static class PermutationGenerator 
	{
		private int[] a;
		private long numLeft;
		private long total;

		//-----------------------------------------------------------
		// Constructor. WARNING: Don't make n too large.
		// Recall that the number of permutations is n!
		// which can be very large, even when n is as small as 20 --
		// 20! = 2,432,902,008,176,640,000 and
		// 21! is too big to fit into a Java long, which is
		// why we use BigInteger instead.
		//----------------------------------------------------------

		public PermutationGenerator (int n) {
			if (n < 1) 
			{
				throw new IllegalArgumentException ("Min 1");
			}
			a = new int[n];
			total = getFactorial(n);
			reset ();
		}

		//------
		// Reset
		//------

		public void reset () {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			numLeft = total;
		}

		//------------------------------------------------
		// Return number of permutations not yet generated
		//------------------------------------------------

		public long getNumLeft () {
			return numLeft;
		}

		//------------------------------------
		// Return total number of permutations
		//------------------------------------

		public long getTotal () {
			return total;
		}

		//-----------------------------
		// Are there more permutations?
		//-----------------------------

		public boolean hasMore () {
			return numLeft == 0;
		}

		static long[] factorial = new long[21];

		static
		{
			factorial[0] = 1;
		}

		long getFactorial (int n) {
			if(factorial[n] == 0)
			{
				factorial[n] = n * getFactorial(n - 1);
			}
			return factorial[n];
		}

		//--------------------------------------------------------
		// Generate next permutation (algorithm from Rosen p. 284)
		//--------------------------------------------------------

		public int[] getNext () {

			if (numLeft == total) {
				numLeft--;
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

			numLeft--;
			return a;
		}
	}
		
	static class CombinationGenerator 
	{
		private int[] a;
		private int n;
		private int r;
		private long numLeft;
		private long total;

		//------------
		// Constructor
		//------------

		public CombinationGenerator (int n, int r) {
			if (r > n) {
				throw new IllegalArgumentException ();
			}
			if (n < 1) {
				throw new IllegalArgumentException ();
			}
			this.n = n;
			this.r = r;
			a = new int[r];
			BigInteger nFact = getFactorial(n);
			BigInteger rFact = getFactorial(r);
			BigInteger nminusrFact = getFactorial(n - r);
			total = nFact.divide(rFact.multiply(nminusrFact)).longValue();
			reset();
		}

		//------
		// Reset
		//------

		public void reset () {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			numLeft = total;
		}

		//------------------------------------------------
		// Return number of combinations not yet generated
		//------------------------------------------------

		public long getNumLeft () {
			return numLeft;
		}

		//-----------------------------
		// Are there more combinations?
		//-----------------------------

		public boolean hasMore () {
			return numLeft != 0;
		}

		//------------------------------------
		// Return total number of combinations
		//------------------------------------

		public long getTotal () {
			return total;
		}

		static BigInteger[] factorial = new BigInteger[20];
		
		static
		{
			factorial[0] = BigInteger.ONE;
		}
		
		BigInteger getFactorial (int n) {
			if(factorial[n] == null)
			{
				factorial[n] = new BigInteger("" + n).multiply(getFactorial(n - 1));
			}
			return factorial[n];
		}

		//--------------------------------------------------------
		// Generate next combination (algorithm from Rosen p. 286)
		//--------------------------------------------------------

		public int[] getNext () {

			if (numLeft == total) {
				numLeft--;
				return a;
			}

			int i = r - 1;
			while (a[i] == n - r + i) {
				i--;
			}
			a[i] = a[i] + 1;
			for (int j = i + 1; j < r; j++) {
				a[j] = a[i] + j - i;
			}

			numLeft--;
			return a;

		}
	}
		
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int nRobots = Integer.parseInt(br.readLine());
			int [][] matrizArmas = new int[nRobots + 1][nRobots];
			for(int j = 0; j < nRobots + 1; j++)
			{
				String esta = br.readLine();
				for(int k = 0; k < nRobots; k++)
				{
					matrizArmas[j][k] = esta.charAt(k) - '0';
				}
			}
			long [] solucion = new long[1 << nRobots];
			solucion[0] = 1;
			for(int j = 0; j < nRobots; j++)
			{
				CombinationGenerator generador = new CombinationGenerator(nRobots, j);
				while(generador.hasMore())
				{
					int [] comb = generador.getNext();
					int actual = 0;
					for(int k : comb)
						actual += (1 << k);
					for(int k = 0; k < nRobots; k++)
					{
						if((actual & (1 << k)) == 0)
						{
							int siguiente = actual + (1 << k);
							if(matrizArmas[0][k] == 1)
								solucion[siguiente] += solucion[actual];
							else
							{
								for(int l = 0; l < nRobots; l++)
								{
									if(((actual >> l) & 1) == 1)
									{
										if(matrizArmas[l + 1][k] == 1)
										{
											solucion[siguiente] += solucion[actual];
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println("Case " + (i + 1) + ": " + solucion[(1 << nRobots) - 1]);
		}
	}
}
