import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashSet;

public class trains
{
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
          private int position;

          public int position()
          {
              return position;
          }

          public void setPosition(int newPosition)
          {
              position = newPosition;
          }
          
          public abstract int compareTo(Object a);
     }
     
     
	static long empresaA[][] = new long[100][100];
	static long empresaB[][] = new long[100][100];
	
	static class Nodo extends PriorityQueueItem
	{
		int numero;
		boolean visitado = false;
		long costo = Long.MAX_VALUE;
		HashSet <Nodo> adjacentes = new HashSet <Nodo> (100);
		
		public Nodo(int n)
		{
			numero = n;
		}
		
		long costo(Nodo otro, long a)
		{
			if(empresaA[numero][otro.numero] >= 0)
				if(empresaB[numero][otro.numero] >= 0)
					return a * empresaA[numero][otro.numero] + (10000L - a) * empresaB[numero][otro.numero];
				else
					return empresaA[numero][otro.numero] * 10000;
			else if(empresaB[numero][otro.numero] >= 0)
				return empresaB[numero][otro.numero] * 10000;
			throw(new RuntimeException());
		}
		
		@Override
		public boolean equals(Object obj)
		{
			return numero == ((Nodo) obj).numero;
		}
		
		@Override
		public int hashCode() 
		{
			return numero;
		}

		@Override
		public int compareTo(Object o) 
		{
			return Long.valueOf(costo).compareTo(((Nodo) o).costo);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int n, ma, mb, k;
			String[] p1 = br.readLine().split(" ");
			n = Integer.parseInt(p1[0]);
			ma = Integer.parseInt(p1[1]);
			mb = Integer.parseInt(p1[2]);
			k = Integer.parseInt(p1[3]);
			if(n == -1 && ma == -1 && mb == -1 && k == -1)
				return;
			Nodo[] nodos = new Nodo[n];
			for(int i = 0; i < n; i++)
			{
				nodos[i] = new Nodo(i);
			}
			for(int i = 0; i < 100; i++)
			{
				for(int j = 0; j < 100; j++)
				{
					empresaA[i][j] = -1;
					empresaB[i][j] = -1;
				}
			}
			for(int i = 0; i < ma; i++)
			{
				String[] p = br.readLine().split(" ");
				int a = Integer.parseInt(p[0]);
				int b = Integer.parseInt(p[1]);
				int c = Integer.parseInt(p[2]);
				empresaA[a][b] = c;
				empresaA[b][a] = c;
				nodos[a].adjacentes.add(nodos[b]);
				nodos[b].adjacentes.add(nodos[a]);
			}
			for(int j = 0; j < mb; j++)
			{
				String[] p = br.readLine().split(" ");
				int a = Integer.parseInt(p[0]);
				int b = Integer.parseInt(p[1]);
				int c = Integer.parseInt(p[2]);
				empresaB[a][b] = c;
				empresaB[b][a] = c;
				nodos[a].adjacentes.add(nodos[b]);
				nodos[b].adjacentes.add(nodos[a]);
			}
			for(int i = 0; i < k; i++)
			{
				long a = new BigDecimal(br.readLine()).multiply(new BigDecimal("10000")).longValueExact();
				for(int j = 0; j < n; j++)
				{
					nodos[j].costo = Long.MAX_VALUE;
					nodos[j].visitado = false;
				}
				nodos[0].costo = 0;
				PriorityQueue prioridad = new PriorityQueue (100);
				for(int j = 0; j < n; j++)
					prioridad.insert(nodos[j]);
				while(true)
				{
					Nodo actual = (Nodo) prioridad.deleteMin();
					actual.visitado = true;
					if(actual.numero == n - 1)
					{
						System.out.println(actual.costo / 10000L);
						break;
					}
					for(Nodo otro : actual.adjacentes)
					{
						if(otro.visitado)
							continue;
						long nuevoCosto = actual.costo + actual.costo(otro, a);
						if(nuevoCosto < otro.costo)
						{
							otro.costo = nuevoCosto;
							prioridad.decreaseKey(otro);
						}
					}
				}
			}
		}
	}

}
