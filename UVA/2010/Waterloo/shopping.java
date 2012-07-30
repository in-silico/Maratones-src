import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class shopping
{
	static int[][] tsp;
	static int shopNumber;
	static int[][] distances;
	
	static int tsp(int history, int actual)
	{
		if(tsp[history][actual] != 0)
			return tsp[history][actual];
		int min = Integer.MAX_VALUE;
		int nHistory = history ^ (1 << actual); 
		for(int i = 0; i < shopNumber - 1; i++)
		{
			if((nHistory & (1 << i)) > 0)
				min = Math.min(min, tsp(nHistory, i) + distances[i + 1][actual + 1]);
		}
		if(min == Integer.MAX_VALUE)
			min = distances[0][actual + 1];
		tsp[history][actual] = min;
		return tsp[history][actual];
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nc = Integer.parseInt(br.readLine());
		for(int i = 0; i < nc; i++)
		{
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			Intersection[] intersections = new Intersection[n];
			for(int j = 0; j < n; j++)
			{
				intersections[j] = new Intersection();
			}
			for(int j = 0; j < m; j++)
			{
				String[] xyd = br.readLine().split(" ");
				int x = Integer.parseInt(xyd[0]);
				int y = Integer.parseInt(xyd[1]);
				int d = Integer.parseInt(xyd[2]);
				intersections[x].neighbors.add(new Intersection.Node(intersections[y], d));
				intersections[y].neighbors.add(new Intersection.Node(intersections[x], d));
			}
			shopNumber = Integer.parseInt(br.readLine()) + 1;
			int[] shopNumbers = new int[shopNumber];
			for(int j = 1; j < shopNumber; j++)
			{
				shopNumbers[j] = Integer.parseInt(br.readLine());
				intersections[shopNumbers[j]].number = j;
			}
			shopNumbers[0] = 0;
			intersections[0].number = 0;
			distances = new int[shopNumber][shopNumber];
			for(int j = 0; j < shopNumber; j++)
			{
				BinaryHeap heap = new BinaryHeap(n);
				for(int k = 0; k < n; k++)
				{
					if(k == shopNumbers[j])
						intersections[k].distance = 0;
					else
						intersections[k].distance = Integer.MAX_VALUE;
					intersections[k].visited = false;
					heap.insert(intersections[k]);
				}
				while(!heap.isEmpty())
				{
					Intersection q = (Intersection) heap.deleteMin();
					q.visited = true;
					if(q.number != -1 && q.number != j)
					{
						distances[j][q.number] = q.distance;
						distances[q.number][j] = q.distance;
					}
					for(Intersection.Node v : q.neighbors)
					{
						if(!v.i.visited)
						{
							int alt = q.distance + v.cost;
							if(alt < v.i.distance)
							{
								v.i.distance = alt;
								heap.decreaseKey(v.i);
							}
						}
					}
				}
			}
			tsp = new int[1 << (shopNumber - 1)][shopNumber - 1];
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < shopNumber - 1; j++)
			{
				min = Math.min(min, tsp((1 << (shopNumber - 1)) - 1, j) + distances[0][j + 1]);
			}
			System.out.println(min);
		}
	}
	
	static class Intersection extends BinaryHeapItem
	{
		LinkedList <Node> neighbors = new LinkedList <Node> ();
		int distance = Integer.MAX_VALUE;
		int number = -1;
		boolean visited = false;
		
		static class Node
		{
			Intersection i;
			int cost;
			
			public Node(Intersection i, int cost) 
			{
				this.i = i;
				this.cost = cost;
			}
		}

		public int compareTo(BinaryHeapItem o) 
		{
			Intersection otro = (Intersection) o;
			return new Integer(distance).compareTo(otro.distance);
		}
	}
	
	static class BinaryHeap
	{
	    private int currentSize;      // Number of elements in heap
	    private BinaryHeapItem[] array; // The heap array
	    
	    /**
	     * Construct the binary heap.
	     */
	    public BinaryHeap(int capacidad) 
	    {
	        currentSize = 0;
	        array = new BinaryHeapItem[capacidad + 1];
	    }
	    
	    /**
	     * Insert into the priority queue.
	     * Duplicates are allowed.
	     * @param x the item to insert.
	     * @return null, signifying that decreaseKey cannot be used.
	     */
	    public int insert(BinaryHeapItem x) 
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
	    
	    public void decreaseKey(BinaryHeapItem newVal) 
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
	    
	    /**
	     * Find the smallest item in the priority queue.
	     * @return the smallest item.
	     * @throws UnderflowException if empty.
	     */
	    public BinaryHeapItem findMin() 
	    {
	    	return array[1];
	    }
	    
	    /**
	     * Remove the smallest item from the priority queue.
	     * @return the smallest item.
	     * @throws UnderflowException if empty.
	     */
	    public BinaryHeapItem deleteMin() 
	    {
	        BinaryHeapItem minItem = findMin();
	        array[1] = array[currentSize--];
	        array[1].setPosition(1);
	        percolateDown(1);
	        return minItem;
	    }

	    /**
	     * Test if the priority queue is logically empty.
	     * @return true if empty, false otherwise.
	     */
	    public boolean isEmpty() {
	        return currentSize == 0;
	    }
	    
	    /**
	     * Returns size.
	     * @return current size.
	     */
	    public int size() {
	        return currentSize;
	    }
	    
	    /**
	     * Make the priority queue logically empty.
	     */
	    public void makeEmpty() {
	        currentSize = 0;
	    }

	    /**
	     * Internal method to percolate down in the heap.
	     * @param hole the index at which the percolate begins.
	     */
		private void percolateDown(int hole) {
	        int child;
	        BinaryHeapItem tmp = array[hole];
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
	    
	    /**
	     * Internal method to extend array.
	     */
	    private void doubleArray() 
	    {
	        BinaryHeapItem[] newArray;
	        newArray = new BinaryHeapItem[array.length * 2];
	        for( int i = 0; i < array.length; i++ )
	            newArray[i] = array[i];
	        array = newArray;
	    }
	}
    
    static abstract class BinaryHeapItem implements Comparable <BinaryHeapItem>
    {
    	int position;
    	
    	public int position()
    	{
    		return position;
    	}
    	
    	public void setPosition(int newPosition)
    	{
    		position = newPosition;
    	}
    }
}
