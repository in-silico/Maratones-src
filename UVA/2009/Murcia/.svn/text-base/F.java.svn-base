import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class F 
{

	static class Scanner {
		InputStreamReader i;
		char b[];
		int p = -1, d, h, t;
		
		public Scanner() throws IOException {
			b = new char[2500000];
			i = new InputStreamReader(System.in);
			i.read(b);
		}
		
		public void leer(char c) throws IOException {
			try {
				while(b[++p] <= c);
				d = p;
				h = d - 1;
				while(b[++h] > c);
				p = h--;
			}
			catch(Exception e) {
				organizar();
				leer(c);
			}
		}
		
		void organizar() throws IOException {
			int hd = 0;
			if(p != b.length) {
				hd = h - d;
				System.arraycopy(b, d, b, 0, hd);
				d = 0;
			}
			p = -1;
			int l = i.read(b, hd, b.length - hd);
			if(hd + l < b.length)
				b[hd + (l == -1 ? 0 : l)] = '\0';
		}
		
		public String next() throws IOException {
			leer(' ');
			return new String(b, d, h - d + 1);
		}
		
		public boolean noTieneMas()
		{
			return (p != -1 && p != b.length && b[p] == '\0') || (p != -1 && p < b.length - 1 && b[p + 1] == '\0');
		}
		
		public String nextLine() throws IOException {
			if(p != -1 && b[p] != '\n') {
				p--;
				leer('\n');
			}
			leer('\n');
			return new String(b, d, h - d + 1);
		}
		
		public int nextInt() throws IOException {
			return (int) nextLong();
		}
		
		public long nextLong() throws IOException {
			leer(' ');
			long r = 0;
			boolean n = b[d] == '-';
			if(n)
				d++;
			r -= b[d++] - '0';
			while (d <= h && (r *= 10) <= 0) 
				r -= b[d++] - '0';
			return n ? r : -r;
		}
		
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
	
	static class Palabra implements Comparable <Palabra>
	{
		String p;
		double spam = 0, ham = 0;
		
		public Palabra(String lectura) 
		{
			p = lectura;
		}

		public double calcularPP()
		{
			double spamHam = spam + ham;
			if(spamHam == 0)
				return 0.4;
			double p = spam / spamHam;
			if(p < 0.01)
				return 0.01;
			if(p > 0.99)
				return 0.99;
			return p;
		}

		@Override
		public int compareTo(Palabra o) 
		{
			return p.compareTo(o.p);
		}
	}
	
	static TreeMap <String, Palabra> palabras = new TreeMap <String, Palabra> ();
	static ArrayList <Palabra> actual = new ArrayList <Palabra> ();
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			actual.clear();
			if(sc.noTieneMas())
				return;
			String primera = null;
			try
			{
				primera = sc.next();
				if(primera == null || primera.length() == 0 || !primera.equals("MESSAGE"))
					return;
			}
			catch(Exception e)
			{
				return;
			}
			String segunda = sc.next();
			boolean spam = segunda.equals("SPAM");
			boolean classify = segunda.equals("CLASSIFY");
			while(true)
			{
				String lectura = sc.next();
				if(lectura.equals("=="))
					break;
				actual.add(darPalabra(lectura, spam, classify));
			}
			if(classify)
			{
				double sp = 1;
				double sp1 = 1;
				for(Palabra p : actual)
				{
					double a = p.calcularPP();
					sp *= a;
					sp1 *= (1 - a);
				}
				double divisor = sp + sp1;
				double valor = sp / divisor;
				if(valor > 0.4 && valor < 0.6)
					System.out.println("Unsure");
				else if(valor >= 0.6)
					System.out.println("Spam");	
				else
					System.out.println("Ham");	
			}
		}
	}
	
	private static Palabra darPalabra(String lectura, boolean s, boolean c) 
	{
		lectura = lectura.toLowerCase();
		Palabra posible = palabras.get(lectura);
		if(posible != null)
		{
			if(!c)
			{
				if(s)
					posible.spam += 1;
				else
					posible.ham += 1;
			}
			return posible;
		}
		Palabra nueva = new Palabra(lectura);
		if(!c)
		{
			if(s)
				nueva.spam += 1;
			else
				nueva.ham += 1;
		}
		palabras.put(lectura, nueva);
		return nueva;
	}

}
