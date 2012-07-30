import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

	
public class texas 
{
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
	
	static class Carta implements Comparable <Carta>
	{
		char [] carta;
	    int valor;
	    int pinta;
	    
		Carta(char numero, char suit)
		{
			carta = new char[2];
			carta[0] = numero;
			carta[1] = suit;
		    switch(numero)
		    {
		            case 'T': valor = 10; break;
		            case 'J': valor = 11; break;
		            case 'Q': valor = 12; break;
		            case 'K': valor = 13; break;
		            case 'A': valor = 14; break;
		            default: valor = numero - '0'; break;
		    }
		    switch(suit)
		    {
		            case 'H': pinta = 1; break;
		            case 'D': pinta = 2; break;
		            case 'S': pinta = 3; break;
		            default: pinta = 4; break;
		    }
	    }
	    
	    @Override
	    public int compareTo(Carta otra) 
	    {
	            if(valor < otra.valor)
	                    return 1;
	            else if(valor > otra.valor)
	                    return -1;
	            else
	                    return 0;
	    }       
	    
	    @Override
	    public String toString()
	    {
	    	return new String(carta);
	    }
	}
    
	static class Mano
	{
		Carta [] mano;
		long valor;
		int tipo;
		Mano padre = null;
		
		void calcularValor()
	    {
			Carta [] mano = this.mano.clone();
			Arrays.sort(mano);
			ArrayList <Integer> repetidas = new ArrayList <Integer> ();
			tipo = 0;
			for(int i = 0; i < 5; i++)
				repetidas.add(1);
			for(int i = 0; i < 5; i++)
			{
				for(int j = 0; j < 5; j++)
				{
					if(j != i)
					{
						if (mano[i].compareTo(mano[j]) == 0)
						{
							repetidas.set(i, repetidas.get(i) + 1);
						}
					}
				}
			}
			ArrayList <Integer> manoN = new ArrayList <Integer> ();
			if(repetidas.contains(4))
			{
				tipo = 7;
				for(int i = 0; i < 4; i++)
					manoN.add(mano[repetidas.indexOf(4)].valor);
				manoN.add(mano[repetidas.indexOf(1)].valor);
			}
			else if(repetidas.contains(3) && repetidas.contains(2))
			{
				tipo = 6;
				for(int i = 0; i < 3; i++)
					manoN.add(mano[repetidas.indexOf(3)].valor);
				for(int i = 0; i < 2; i++)
					manoN.add(mano[repetidas.indexOf(2)].valor);
			}
			else if(repetidas.contains(3))
			{
				tipo = 3;
				for(int i = 0; i < 3; i++)
					manoN.add(mano[repetidas.indexOf(3)].valor);
				manoN.add(mano[repetidas.indexOf(1)].valor);
				manoN.add(mano[repetidas.lastIndexOf(1)].valor);
			}
			else if(repetidas.contains(2))
			{
				if(repetidas.indexOf(2) + 1 != repetidas.lastIndexOf(2))
				{
					tipo = 2;
					for(int i = 0; i < 2; i++)
						manoN.add(mano[repetidas.indexOf(2)].valor);
					for(int i = 0; i < 2; i++)
						manoN.add(mano[repetidas.lastIndexOf(2)].valor);
					manoN.add(mano[repetidas.indexOf(1)].valor);
				}
				else
				{
					tipo = 1;
					for(int i = 0; i < 2; i++)
						manoN.add(mano[repetidas.indexOf(2)].valor);
					for(int i = 0; i < 5; i++)
					{
						if(repetidas.get(i) == 1)
						{
							manoN.add(mano[i].valor);
						}
					}
				}
			}
			else
			{
				for(Carta c : mano)
				{
					manoN.add(c.valor);
				}
				boolean color = true;
				int pinta = mano[0].pinta;
				for(Carta c : mano)
				{
					if(c.pinta != pinta)
						color = false;
				}
				boolean escalera = true;
				int valor = mano[1].valor;
				for(Carta c : Arrays.copyOfRange(mano, 1, mano.length))
				{
					if(c.valor != valor)
						escalera = false;
					else
						valor--;
				}
				if(escalera == true)
				{
					if(mano[0].valor - 1 != mano[1].valor)
					{
						if(mano[0].valor == 14 && mano[1].valor == 5)
						{
							manoN.set(0, 5);
							manoN.set(1, 4);
							manoN.set(2, 3);
							manoN.set(3, 2);
							manoN.set(4, 1);
						}
						else
						{
							escalera = false;
						}
					}
				}
				if(escalera && color)
					tipo = 8;
				else if(color)
					tipo = 5;
				else if(escalera)
					tipo = 4;
			}
			long valorMano = tipo * 10000000000L;
			valorMano += manoN.get(0) * 100000000;
			valorMano += manoN.get(1) * 1000000;
			valorMano += manoN.get(2) * 10000;
			valorMano += manoN.get(3) * 100;
			valorMano += manoN.get(4);
			valor = valorMano;
	    }
		
	    @Override
	    public String toString()
	    {
	    	String esta = "";
	    	for(int i = 0; i < mano.length; i++)
	    	{
	    		esta += " " + mano[i];
	    	}
	    	return esta.substring(1);
	    }
	}
	
	public static void main(String [] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		CombinationGenerator generador = new CombinationGenerator(7, 5);
		generador.reset();
		int [][] combinaciones = new int [21][5];
		int zz = 0;
		while(generador.hasMore())
		{
			combinaciones[zz++] = generador.getNext().clone();
		}
		for(int i = 0; i < n; i++)
		{
			br.readLine();
			Carta [][] tablero = new Carta[7][7];
			for(int j = 0; j < 7; j++)
			{
				char [] fila = br.readLine().toCharArray();
				int actual = 0;
				for(int k = 0; k < 7; k++)
				{
					tablero[j][k] = new Carta(fila[actual], fila[actual + 1]);
					actual += 3;
				}
			}
			Mano [] manosPosibles = new Mano[16];
			for(int j = 0; j < 7; j++)
			{
				manosPosibles[j] = new Mano();
				manosPosibles[j].mano = new Carta[7];
				for(int k = 0; k < 7; k++)
				{
					manosPosibles[j].mano[k] = tablero[j][k];
				}
			}
			for(int j = 0; j < 7; j++)
			{
				manosPosibles[j + 7] = new Mano();
				manosPosibles[j + 7].mano = new Carta[7];
				for(int k = 0; k < 7; k++)
				{
					manosPosibles[j + 7].mano[k] = tablero[k][j];
				}
			}
			manosPosibles[14] = new Mano();
			manosPosibles[14].mano = new Carta[7];
			for(int j = 0; j < 7; j++)
			{
				manosPosibles[14].mano[j] = tablero[j][j];
			}
			manosPosibles[15] = new Mano();
			manosPosibles[15].mano = new Carta[7];
			for(int j = 0; j < 7; j++)
			{
				manosPosibles[15].mano[j] = tablero[6 - j][j];
			}
			long mejorValor = 0;
			Mano mejorMano = null;
			for(Mano m : manosPosibles)
			{
				for(int [] combinacion : combinaciones)
				{
					Carta [] nueva = new Carta[5];
					for(int j = 0; j < 5; j++)
					{
						nueva[j] = m.mano[combinacion[j]];
					}
					Mano actual = new Mano();
					actual.mano = nueva;
					actual.calcularValor();
					if(actual.valor > mejorValor)
					{
						mejorValor = actual.valor;
						actual.padre = m;
						mejorMano = actual;
					}
				}
			}
			String valor = "";
			switch(mejorMano.tipo)
			{
	            case 0 : valor = "High Cards"; break;
	            case 1 : valor = "One Pair"; break;
	            case 2 : valor = "Two Pair"; break;
	            case 3 : valor = "Three of a Kind"; break;
	            case 4 : valor = "Straight"; break;
	            case 5 : valor = "Flush"; break;
	            case 6 : valor = "Full House"; break;
	            case 7 : valor = "Four of a Kind"; break;
	            case 8 : valor = "Straight Flush"; break;
			}
			System.out.println(mejorMano.padre + "  " + mejorMano + "  " + valor);
		}
	}
}
