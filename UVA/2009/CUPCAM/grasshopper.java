import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;

public class grasshopper
{
	static class Scanner
	{
		static InputStreamReader isr;
		char buffer[];
		int pos = -1, desde, hasta, tam;
		
		public Scanner()
		{
			buffer = new char[250000];
			try 
			{
				isr = new InputStreamReader(System.in);
				isr.read(buffer);
			} 
			catch (IOException e) 
			{
				throw(new RuntimeException());
			}
		}
		
		public void leer()
		{
			try
			{
				while(buffer[++pos] <= ' ');
				desde = pos;
				hasta = desde - 1;
				while(buffer[++hasta] > ' ');
				pos = hasta;
				hasta--;
			}
			catch(Exception e)
			{
				if(pos == buffer.length)
					try
					{
						pos = -1;
						int leidos = isr.read(buffer);
						if(leidos < buffer.length)
							buffer[leidos] = '\0';
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
				else
					try
					{
						int hastaDesde = hasta - desde;
						System.arraycopy(buffer, desde, buffer, 0, hastaDesde);
						int leidos = isr.read(buffer, hastaDesde, buffer.length - hastaDesde);
						if(hastaDesde + leidos < buffer.length)
							buffer[hastaDesde + (leidos == -1 ? 0 : leidos)] = '\0';
						pos = -1;
						desde = 0;
						leer();
					}
					catch(Exception e1)
					{
						throw(new RuntimeException());
					}
			}
		}
		
		public String next()
		{
			leer();
			return new String(buffer, desde, hasta - desde + 1);
		}
		
		public int nextInt()
		{
			leer();
			int resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public long nextLong()
		{
			leer();
			long resultado = 0;
			boolean negativo = buffer[desde] == '-';
			if(negativo)
				desde++;
			resultado -= buffer[desde++] - '0';
			while (desde <= hasta && (resultado *= 10) <= 0) 
				resultado -= buffer[desde++] - '0';
			return negativo ? resultado : -resultado;
		}
		
		public double nextDouble()
		{
			return Double.parseDouble(next());
		}
		
		public BigInteger nextBigInteger()
		{
			return new BigInteger(next());
		}
		
		public BigDecimal nextBigDecimal()
		{
			return new BigDecimal(next());
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
	
	static class Trampolin extends PriorityQueueItem
	{
		int salto, r, c;
		Trampolin anterior;
		LinkedList <Trampolin> vecinos = new LinkedList <Trampolin> ();
		
		
		public Trampolin(int s, int r1, int c1)
		{
			salto = s;
			r = r1;
			c = c1;
		}
	}
	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner();
		while(true)
		{
			int r, c;
			r = sc.nextInt();
			c = sc.nextInt();
			Trampolin[][] t = new Trampolin[r][c];
			if(r == 0 || c == 0)
				return;
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
				{
					t[i][j] = new Trampolin(sc.nextInt(), i, j);
				}
			t[0][0].dist = 0;
			PriorityQueue q = new PriorityQueue(r * c);
			for(int i = 0; i < r; i++)
				for(int j = 0; j < c; j++)
				{
					Trampolin actual = t[i][j];
					if(i + actual.salto < r)
						t[i + actual.salto][j].vecinos.add(actual);
					if(i - actual.salto > -1)
						t[i - actual.salto][j].vecinos.add(actual);
					if(j + actual.salto < c)
						t[i][j + actual.salto].vecinos.add(actual);
					if(j - actual.salto > -1)
						t[i][j - actual.salto].vecinos.add(actual);
					q.insert(actual);
				}
			while(!q.isEmpty())
			{
				Trampolin u = (Trampolin) q.deleteMin();
				if(u.dist == Integer.MAX_VALUE)
					break;
				int alt = u.dist + 1;
				for(Trampolin v : u.vecinos)
				{
					if(alt < v.dist)
					{
						v.dist = alt;
						v.anterior = u;
						q.decreaseKey(v);
					}
					if(alt == v.dist)
					{
						if(v.anterior.r > u.r)
							v.anterior = u;
						else if(v.anterior.r == u.r)
							if(v.anterior.c > u.c)
								v.anterior = u;
					}
				}
			}
			for(int i = 0; i < r; i++)
			{
				for(int j = 0; j < c; j++)
				{
					if(i == 0 && j == 0)
						System.out.print("*");
					else
					{
						Trampolin actual = t[i][j];
						if(actual.dist == Integer.MAX_VALUE)
							System.out.print("X");
						else if(actual.anterior.r < actual.r)
							System.out.print("N");
						else if(actual.anterior.r > actual.r)
							System.out.print("S");
						else if(actual.anterior.c < actual.c)
							System.out.print("W");
						else if(actual.anterior.c > actual.c)
							System.out.print("E");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}