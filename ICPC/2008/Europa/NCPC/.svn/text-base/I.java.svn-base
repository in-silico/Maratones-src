import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;



public class I {

	
	static class PriorityQueue
	{
		 private int currentSize;
		 private PriorityQueueItem[] array;

		 public PriorityQueue(int capacidad)  
		 {
			 array = new PriorityQueueItem[capacidad + 1];
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
	
	static class PriorityQueueItem
	{
		int num;
		int dist;
		private int position;
		LinkedList <Integer> indices = new LinkedList <Integer> ();
		
		public PriorityQueueItem(int a)
		{
			num = a;
		}
		public void setPosition(int i) {
			position = i;
		}

		public int position() {
			return position;
		}

		public int compareTo(PriorityQueueItem pqItem) {
			if(indices.isEmpty() && pqItem.indices.isEmpty())
				return 0;
			if(indices.isEmpty())
				return -1;
			if(pqItem.indices.isEmpty())
				return 1;
			return -new Integer(indices.peek()).compareTo(pqItem.indices.peek());
		}
	}	
	
	static boolean[] esta = new boolean[100000];
	static PriorityQueueItem[] entradas = new PriorityQueueItem[100000];
	static int[] enOrden = new int[100000];
	static int tamCache;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < entradas.length; i++)
		{
			entradas[i] = new PriorityQueueItem(i);
		}
		while(true)
		{
			tamCache = 0;
			String linea = br.readLine();
			if(linea == null)
				return;
			String[] pedazos = linea.split(" ");
			int c = Integer.parseInt(pedazos[0]);
			int n = Integer.parseInt(pedazos[1]);
			int a = Integer.parseInt(pedazos[2]);
			PriorityQueue actual = new PriorityQueue(c);
			for(int i = 0; i < n; i++)
			{
				entradas[i].indices.clear();
				esta[i] = false;
			}
			for(int i = 0; i < a; i++)
			{
				int ac = Integer.parseInt(br.readLine());
				enOrden[i] = ac;
				entradas[ac].indices.add(i);
			}
			int cuenta = 0;
			for(int i = 0; i < a; i++)
			{
				int ac = enOrden[i];
				if(!esta[ac])
				{
					if(tamCache < c)
					{
						tamCache++;
						if(!entradas[ac].indices.isEmpty())
							entradas[ac].indices.remove();
						actual.insert(entradas[ac]);
						cuenta++;
						esta[ac] = true;
					}
					else
					{
						PriorityQueueItem deSalida = actual.deleteMin();
						esta[deSalida.num] = false;
						esta[ac] = true;
						if(!entradas[ac].indices.isEmpty())
							entradas[ac].indices.remove();
						actual.insert(entradas[ac]);
						cuenta++;
					}
				}
				else
				{
					entradas[ac].indices.remove();
					actual.decreaseKey(entradas[ac]);
				}
			}
			System.out.println(cuenta);
		}
	}

}
