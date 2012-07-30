import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class G 
{
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public Scanner()
		{
	    	System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next()
		{

			while(st == null || !st.hasMoreTokens())
			{
				try { st = new StringTokenizer(br.readLine()); }
				catch(Exception e) { throw new RuntimeException(); }
			}
			return st.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public String nextLine()
		{
			st = null;
			try { return br.readLine(); }
			catch(Exception e) { throw new RuntimeException(); }
		}
		
		public boolean endLine()
		{
			try 
			{
				String next = br.readLine();
				while(next != null && next.trim().isEmpty())
					next = br.readLine();
				if(next == null)
					return true;
				st = new StringTokenizer(next);
				return st.hasMoreTokens();
			}
			catch(Exception e) { throw new RuntimeException(); }
		}
	}
	static final int[][] diffs = new int[][] {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}};
	
	static TreeMap <Pos, Tile> todasTiles = new TreeMap <Pos, Tile> ();
	
	static class Pos implements Comparable <Pos>
	{
		int x;
		int y;
		
		public Pos(int xx, int yy)
		{
			x = xx;
			y = yy;
		}

		public Pos clonar() 
		{
			return new Pos(x, y);
		}
		
		@Override
		public int compareTo(Pos o)
		{
			if(x == o.x)
				return y - o.y;
			return x - o.x;
		}
	}
	
	static class Tile
	{
		int x;
		int y;
		char[] colors;
		boolean bloqueado = false;
		boolean forced = false;
		
		public Tile(int xx, int yy, char[] color)
		{
			x = xx;
			y = yy;
			colors = color;
			generarVecinas();
		}
		
		public Tile(int xx, int yy)
		{
			x = xx;
			y = yy;
		}
		
		public void generarVecinas()
		{
			for(int[] cambio : diffs)
			{
				int xx = x + cambio[0];
				int yy = y + cambio[1];
				temporal.x = xx;
				temporal.y = yy;
				if(!todasTiles.containsKey(temporal))
					todasTiles.put(temporal.clonar(), new Tile(xx, yy));
			}
		}
		
		public void bloquearForced()
		{
			forced = true;
			for(int[] cambio : diffs)
			{
				int xx = x + cambio[0];
				int yy = y + cambio[1];
				temporal.x = xx;
				temporal.y = yy;
				if(todasTiles.containsKey(temporal))
					if(todasTiles.get(temporal).colors == null)
						todasTiles.get(temporal).bloquearAnterior(cambio);
			}
		}
		
		public void bloquearAnterior(int[] cambio)
		{
			if(colors == null)
			{
				bloqueado = true;
				int xx = x + cambio[0];
				int yy = y + cambio[1];
				temporal.x = xx;
				temporal.y = yy;
				if(todasTiles.containsKey(temporal))
					todasTiles.get(temporal).bloquearAnterior(cambio);
			}
		}
		
		public int forced()
		{
			int cuenta = 0;
			for(int[] cambio : diffs)
			{
				int xx = x + cambio[0];
				int yy = y + cambio[1];
				temporal.x = xx;
				temporal.y = yy;
				if(todasTiles.containsKey(temporal))
					if(todasTiles.get(temporal).colors != null)
						cuenta++;
			}
			if(cuenta == 3)
			{
				char color = '0';
				int cuantos = 0;
				for(int[] cambio : diffs)
				{
					int xx = x + cambio[0];
					int yy = y + cambio[1];
					temporal.x = xx;
					temporal.y = yy;
					if(todasTiles.containsKey(temporal))
					{
						Tile vecina = todasTiles.get(temporal);
						if(vecina.colors != null)
						{
							char colorNuevo = vecina.darColor(cambio);
							if(colorNuevo == color)
								cuantos++;
							else
							{
								color = colorNuevo;
								cuantos = 1;
							}
						}
					}
				}
				if(cuantos == 3)
					return 1000000;
				else
					return 1;
			}
			else
				return 0;
		}

		public char darColor(int[] cambioA) 
		{
			if(cambioA == diffs[0])
				cambioA = diffs[3];
			else if(cambioA == diffs[1])
				cambioA = diffs[4];
			else if(cambioA == diffs[2])
				cambioA = diffs[5];
			else if(cambioA == diffs[3])
				cambioA = diffs[0];
			else if(cambioA == diffs[4])
				cambioA = diffs[1];
			else if(cambioA == diffs[5])
				cambioA = diffs[2];
			int indice = 0;
			for(int[] cambio : diffs)
			{
				if(cambioA == cambio)
					return colors[indice];
				indice++;
			}
			return '-';
		}
		
		public int numeroPosibilidades(String tile)
		{
			char[] col = tile.toCharArray();
			int cuenta = 0;
			for(int i = 0; i < 6; i++)
			{
				if(puedePonerse(col))
					cuenta++;
				rotar(col);
			}
			return cuenta;
		}

		private void rotar(char[] col) 
		{
			char ultima = col[5];
			for(int i = 5; i > 0; i--)
				col[i] = col[i - 1];
			col[0] = ultima;
		}

		public boolean puedePonerse(char[] col)
		{
			colors = col;
			int indice = 0;
			for(int[] cambio : diffs)
			{
				int xx = x + cambio[0];
				int yy = y + cambio[1];
				temporal.x = xx;
				temporal.y = yy;
				if(todasTiles.containsKey(temporal))
				{
					Tile vecina = todasTiles.get(temporal);
					if(vecina.colors != null)
					{
						char color = vecina.darColor(cambio);
						if(color != colors[indice])
						{
							colors = null;
							return false;
						}
					}
				}
				indice++;
			}
			boolean respuesta = contarForced() < 1000000;
			colors = null;
			return respuesta;
		}
	}
	
	static Pos temporal = new Pos(0, 0);

	static int contarForced() 
	{
		int cuenta = 0;
		for(Tile t : todasTiles.values())
		{
			if(t.colors == null)
				cuenta += t.forced();
		}
		return cuenta;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		int casos = sc.nextInt();
		String [] enMano = new String[5];
		ArrayList <Tile> forced = new ArrayList <Tile> ();
		ArrayList <Tile> free = new ArrayList <Tile> ();
		for(int caso = 0; caso < casos; caso++)
		{
			todasTiles.clear();
			int n = sc.nextInt();
			for(int i = 0; i < n; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				String cad = sc.next();
				temporal.x = x;
				temporal.y = y;
				todasTiles.put(temporal.clonar(), new Tile(x, y, cad.toCharArray()));
			}
			for(int i = 0; i < 5; i++)
				enMano[i] = sc.next();
			forced.clear();
			free.clear();
			for(Tile t : todasTiles.values())
			{
				if(t.colors == null)
				{
					if(t.forced() == 1)
					{
						forced.add(t);
						t.bloquearForced();
					}
				}
			}
			for(Tile t : todasTiles.values())
			{
				if(t.colors == null && !t.forced && !t.bloqueado)
					free.add(t);
			}
			int cuenta = 0;
			for(Tile t : forced)
				for(String s : enMano)
					cuenta += t.numeroPosibilidades(s);
			if(cuenta != 0)
				System.out.println(cuenta);
			else
			{
				for(Tile t : free)
					for(String s : enMano)
						cuenta += t.numeroPosibilidades(s);
				System.out.println(cuenta);
			}
		}
	}
}
