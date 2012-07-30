import java.io.IOException;
import java.io.InputStreamReader;


public class A 
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
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			double d = sc.nextDouble();
			double raiz = Math.sqrt(1 + 8 * d) - 1;
			raiz /= 2;
			System.out.println((long) Math.floor(raiz));
		}
	}

}
