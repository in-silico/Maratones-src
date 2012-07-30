import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class B 
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
	
	static class PriorityQueue
	{
		 private int currentSize;
		 private PriorityQueueItem[] array;

		 public PriorityQueue(int capacidad)  
		 {
			 currentSize = 0;
			 array = new PriorityQueueItem[capacidad + 1];
		 }

		 public int insert(PriorityQueueItem x)  
		 {
			 if(currentSize + 1 == array.length)
				 doubleArray();
			 int hole = ++currentSize;
			 array[0] = x;
			 array[0].setPosition(0);
			 for(; x.compareTo(array[hole / 2]) < 0; hole /= 2)
			 {
				 array[hole] = array[hole / 2];
				 array[hole].setPosition(hole);
			 }
			 array[hole] = x;
			 array[hole].setPosition(hole);
			 return hole;
		 }

		 public void decreaseKey(PriorityQueueItem newVal)  
		 {
			 int hole = newVal.position();
			 array[0] = newVal;
			 array[0].setPosition(0);
			 for(; newVal.compareTo(array[hole / 2]) < 0; hole /= 2)
			 {
				 array[hole] = array[hole / 2];
				 array[hole].setPosition(hole);
			 }
			 array[hole] = newVal;
			 array[hole].setPosition(hole);
		 }

		 public PriorityQueueItem deleteMin()  
		 {
			 PriorityQueueItem minItem = array[1];
			 array[1] = array[currentSize--];
			 array[1].setPosition(1);
			 percolateDown(1);
			 return minItem;
		 }

		 public boolean isEmpty()
	      {
			 return currentSize == 0;
		 }

		 private void percolateDown(int hole)
	      {
			 int child;
			 PriorityQueueItem tmp = array[hole];
			 for(; hole * 2 <= currentSize; hole = child)
			 {
				 child = hole * 2;
				 if(child != currentSize && array[child + 1].compareTo(array[child]) < 0)
					 child++;
				 if(array[child].compareTo(tmp) < 0)
				 {
					 array[hole] = array[child];  
					 array[hole].setPosition(hole);
				 }
				 else
					 break;
			 }
			 array[hole] = tmp;
			 array[hole].setPosition(hole);
		 }

		 private void doubleArray()  
		 {
			 PriorityQueueItem[] newArray;
			 newArray = new PriorityQueueItem[array.length * 2];
			 for( int i = 0; i < array.length; i++ )
				 newArray[i] = array[i];
			 array = newArray;
		 }
	}
	
	static abstract class PriorityQueueItem
	{
		 int dist = Integer.MAX_VALUE;
	      PriorityQueueItem previous;
		 private int position;

		 public int position()
		 {
			 return position;
		 }

		 public void setPosition(int newPosition)
		 {
			 position = newPosition;
		 }

		 public int compareTo(PriorityQueueItem o)
	      {
			 return new Integer(dist).compareTo(o.dist);
		 }
	}
	
	static class LenguajeE extends PriorityQueueItem
	{
		Lenguaje lenguaje;
		int primera;
		
		public LenguajeE(Lenguaje padre, int i)
		{
			lenguaje = padre;
			primera = i;
		}
	}
	
	static class Conexion implements Comparable <Conexion>
	{
		int palabra;
		int primera;
		Lenguaje lenguaje;
		
		public Conexion(Lenguaje b, String comun) 
		{
			palabra = comun.length();
			lenguaje = b;
			primera = comun.charAt(0) - 'a';
		}

		@Override
		public int compareTo(Conexion o) {
			return new Integer(palabra).compareTo(o.palabra);
		}
	}
	
	
	static HashMap <String, Lenguaje> lenguajes = new HashMap <String, Lenguaje> (4002);
	static Lenguaje inicial, ultimo;
	static PriorityQueue pq = new PriorityQueue(26 * 4005);
	
	static class Lenguaje
	{
		String nombre; 
		int numero; 
		ArrayList <Conexion> conexiones = new ArrayList <Conexion> ();
		LenguajeE [] posibles = new LenguajeE[26];
		
		public Lenguaje(String nombre2) 
		{
			nombre = nombre2;
			for(int i = 0; i < 26; i++)
			{
				posibles[i] = new LenguajeE(this, i);
				pq.insert(posibles[i]);
			}
		}

		public void agregarConexion(Lenguaje b, String comun) 
		{
			boolean encontro = false;
			for(Conexion c : conexiones)
			{
				if(c.lenguaje == b && c.primera == comun.charAt(0) - 'a')
				{
					c.palabra = Math.min(c.palabra, comun.length());
					encontro = true;
					break;
				}
			}
			if(!encontro)
				conexiones.add(new Conexion(b, comun));
		}
	}
	
	public static Lenguaje darLenguaje(String nombre)
	{
		Lenguaje l = lenguajes.get(nombre);
		if(l != null)
			return l;
		else
		{
			Lenguaje nuevo = new Lenguaje(nombre);
			lenguajes.put(nombre, nuevo);
			return nuevo;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		while(true)
		{
			lenguajes.clear();
			pq.currentSize = 0;
			int m = sc.nextInt();
			if(m == 0)
				return;
			inicial = darLenguaje(sc.next());
			ultimo = darLenguaje(sc.next());
			for(int i = 0; i < m; i++)
			{
				Lenguaje a = darLenguaje(sc.next());
				Lenguaje b = darLenguaje(sc.next());
				String comun = sc.next();
				a.agregarConexion(b, comun);
				b.agregarConexion(a, comun);
			}
			LenguajeE primero = new LenguajeE(inicial, -1);
			primero.dist = 0;
			pq.insert(primero);
			boolean termino = false;
			while(!pq.isEmpty())
			{
				LenguajeE actual = (LenguajeE) pq.deleteMin();
				if(actual.dist == Integer.MAX_VALUE)
					break;
				if(actual.lenguaje == ultimo)
				{
					termino = true;
					System.out.println(actual.dist);
					break;
				}
				for(Conexion c : actual.lenguaje.conexiones)
				{
					if(c.primera == actual.primera)
						continue;
					LenguajeE posible = c.lenguaje.posibles[c.primera];
					int nuevaDistancia = actual.dist + c.palabra;
					if(nuevaDistancia < posible.dist)
					{
						posible.dist = nuevaDistancia;
						pq.decreaseKey(posible);
					}
				}
			}
			if(!termino)
				System.out.println("impossivel");
		}
	}
}
