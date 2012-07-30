import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class document
{
	static class PriorityQueue
	{
		 private int currentSize;
		 private PriorityQueueItem[] array = new PriorityQueueItem[100001];

		 public PriorityQueue(int capacidad)  
		 {
			 currentSize = 0;
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
		 int dist;
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
	
	static class Entrada extends PriorityQueueItem
	{
		int n;
		
		public Entrada(int nn)
		{
			n = nn;
			dist = -1;
		}
	}
	static int b, a;
	static Entrada[] entradas = new Entrada[200000];
	
	public static void solucionar(int[] A, int o, int cuenta)
	{
		a = 0;
		b = cuenta;
		PriorityQueue pq = new PriorityQueue(200000);
		for(int i = 0; i < o; i++)
		{
			entradas[i] = new Entrada(i);
			pq.insert(entradas[i]);
		}
		for(int i = 0; i < cuenta; i++)
		{
			entradas[A[i]].dist = i;
			pq.percolateDown(entradas[A[i]].position());
			Entrada m = (Entrada) pq.deleteMin();
			if(m.dist != -1)
			{
				if((i - m.dist) < (b - a))
				{
					b = i;
					a = m.dist;
				}
			}
			pq.insert(m);
		}
		System.out.println((a + 1) + " " + (b + 1));
	}
	
	static HashMap <String, Integer> palabras = new HashMap <String, Integer> (200000);
	static int[] numeros = new int[200000];
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().replace(" ", ""));
		int cuenta = 1;
		for(int ii = 0; ii < t; ii++)
		{
			palabras.clear();
			int cuentaPalabras = 0;
			int palabraActual = 0;
			while(true)
			{
				int pos = 0;
				String lectura = br.readLine();
				if(lectura == null)
					return;
				if(lectura.contains("END"))
				{
					System.out.print("Document " + cuenta++ + ": ");
					break;
				}
				char[] entrada = lectura.toCharArray();
				while(pos < entrada.length)
				{
					while(pos < entrada.length && (entrada[pos] < 'a' || entrada[pos] > 'z'))
						pos++;
					int inicio = pos;
					while(pos < entrada.length && entrada[pos] >= 'a' && entrada[pos] <= 'z')
						pos++;
					int fin = pos;
					if(inicio >= entrada.length || (fin - inicio) <= 0 || (fin - inicio) > entrada.length)
						continue;
					if(cuentaPalabras > 100001)
						continue;
					String nuevo;
					try
					{
						nuevo = new String(entrada, inicio, fin - inicio);
					}
					catch(Exception e)
					{
						continue;
					}
					if(nuevo.equals(""))
						continue;
					Integer posicion = palabras.get(nuevo);
					if(posicion != null)
					{
						numeros[cuentaPalabras++] = posicion;
					}
					else
					{
						numeros[cuentaPalabras++] = palabraActual;
						palabras.put(nuevo, palabraActual);
						palabraActual++;
					}
				}
			}
			solucionar(numeros, palabraActual, cuentaPalabras);
		}
		
	}
}
