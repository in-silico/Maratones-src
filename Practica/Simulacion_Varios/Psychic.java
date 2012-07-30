import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


public class Psychic
{
	
	static class CombinationGenerator 
	{
		private int[] a;
		private int n;
		private int r;
		private long numLeft;
		private long total;
		
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

		public void reset () {
			for (int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			numLeft = total;
		}
		
		public long getNumLeft () {
			return numLeft;
		}

		public boolean hasMore () {
			return numLeft != 0;
		}

		public long getTotal () {
			return total;
		}

		static BigInteger[] factorial = new BigInteger[30];
		
		BigInteger getFactorial (int n) 
		{
			if(n == 0)
				return BigInteger.ONE;
			if(factorial[n] == null)
			{
				factorial[n] = new BigInteger("" + n).multiply(getFactorial(n - 1));
			}
			return factorial[n];
		}

		public int[] getNext () 
		{
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
		int tam = 0;
		
		void agregarCarta(Carta c)
		{
			if(mano == null)
				mano = new Carta[5];
			mano[tam++] = c;
		}
		
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
		
		public String darTipo()
		{
			String valor = null;
			switch(tipo)
			{
	            case 0 : valor = "highest-card"; break;
	            case 1 : valor = "one-pair"; break;
	            case 2 : valor = "two-pairs"; break;
	            case 3 : valor = "three-of-a-kind"; break;
	            case 4 : valor = "straight"; break;
	            case 5 : valor = "flush"; break;
	            case 6 : valor = "full-house"; break;
	            case 7 : valor = "four-of-a-kind"; break;
	            case 8 : valor = "straight-flush"; break;
			}
			return valor;
		}
	    @Override
	    public String toString()
	    {
	    	StringBuilder esta = new StringBuilder();
	    	for(int i = 0; i < mano.length; i++)
	    	{
	    		esta.append(" ");
	    		esta.append(mano[i]);
	    	}
	    	return esta.substring(1);
	    }
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea = br.readLine()) != null)
		{
			String[] cartas = linea.split(" ");
			Carta[] manoInicial = new Carta[5];
			Carta[] recambio = new Carta[5];
			for(int i = 0; i < 5; i++)
				manoInicial[i] = new Carta(cartas[i].charAt(0), cartas[i].charAt(1));
			for(int i = 0; i < 5; i++)
				recambio[i] = new Carta(cartas[i + 5].charAt(0), cartas[i + 5].charAt(1));
			Mano mejorMano = null;
			for(int i = 1; i <= 4; i++)
			{
				CombinationGenerator cg = new CombinationGenerator(5, i);
				while(cg.hasMore())
				{
					int[] actual = cg.getNext();
					Mano generada = new Mano();
					for(int j : actual)
					{
						generada.agregarCarta(manoInicial[j]);
					}
					int j = 0;
					while(generada.tam != 5)
					{
						generada.agregarCarta(recambio[j++]);
					}
					generada.calcularValor();
					if(mejorMano == null)
						mejorMano = generada;
					else if(generada.tipo > mejorMano.tipo)
							mejorMano = generada;
				}
			}
			Mano inicial = new Mano();
			Mano todas = new Mano();
			inicial.mano = manoInicial;
			todas.mano = recambio;
			inicial.calcularValor();
			todas.calcularValor();
			if(inicial.tipo > mejorMano.tipo)
				mejorMano = inicial;
			if(todas.tipo > mejorMano.tipo)
				mejorMano = todas;
			System.out.println("Hand: " + inicial.toString() + " Deck: " + todas.toString() + " Best hand: " + mejorMano.darTipo());
		}
	}

}
