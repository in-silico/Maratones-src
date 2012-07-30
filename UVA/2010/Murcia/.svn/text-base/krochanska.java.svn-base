import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class krochanska 
{
    private static int leerEntero() throws IOException 
    {
            char actual;
            while((actual = (char) is.read()) < '0' || actual > '9');
            int digitos = 1;
            numero[0] = actual;
            while((actual = (char) is.read()) >= '0' && actual <= '9')
            {
                    numero[digitos++] = actual;
            }
            return Integer.parseInt(new String(numero, 0, digitos));
    }

    static InputStreamReader is;
    static char [] numero = new char[10];

	
	public static void main(String [] args) throws IOException
	{
		is = new InputStreamReader(System.in);

		int n = leerEntero();
		for(int i = 0; i < n; i++)
		{
			int nEst = leerEntero();
			int nLin = leerEntero();
			ArrayList <ArrayList <Integer> > lineas = new ArrayList <ArrayList <Integer> > (); 
			ArrayList <Integer> esta = new ArrayList <Integer> ();
			int [] numeroVeces = new int[nEst + 1];
			for(int j = 0; j < nLin;)
			{
				int actual = leerEntero();
				if(actual == 0)
				{
					j++;
					lineas.add(esta);
					esta = new ArrayList <Integer> ();
				}
				else
				{
					esta.add(actual);
					numeroVeces[actual]++;
				}
			}
			ArrayList <Integer> importantes = new ArrayList <Integer> ();
			int [][] correspondencia = new int[nEst + 1][2];
			for(int j = 1; j < nEst + 1; j++)
			{
				if(numeroVeces[j] > 1)
				{
					correspondencia[j][0] = 1;
					correspondencia[j][1] = importantes.size();
					importantes.add(j);
				}
			}
			int [][] matAdyacencia = new int[importantes.size()][importantes.size()];
			for(int j = 0; j < importantes.size(); j++)
			{
				for(int k = 0; k < importantes.size(); k++)
				{
					matAdyacencia[j][k] = Integer.MAX_VALUE;
				}
			}
			ArrayList <ArrayList <Integer> > vecinos = new ArrayList <ArrayList <Integer> > ();
			for(int j = 0; j < importantes.size(); j++)
			{
				vecinos.add(new ArrayList <Integer> ());
			}
			for(int j = 0; j < nLin; j++)
			{
				ArrayList <Integer> lineaActual = lineas.get(j);
				int anterior = 0;
				int conteo = 0;
				for(int a : lineaActual)
				{
					conteo++;
					if(correspondencia[a][0] == 1)
					{
						if(anterior == 0)
						{
							anterior = a;
							conteo = 0;
						}
						else
						{
							matAdyacencia[correspondencia[anterior][1]][correspondencia[a][1]] = Math.min(matAdyacencia[correspondencia[anterior][1]][correspondencia[a][1]], conteo);
							matAdyacencia[correspondencia[a][1]][correspondencia[anterior][1]] = Math.min(matAdyacencia[correspondencia[a][1]][correspondencia[anterior][1]], conteo);
							if(!vecinos.get(correspondencia[anterior][1]).contains(correspondencia[a][1]))
							{
								vecinos.get(correspondencia[anterior][1]).add(correspondencia[a][1]);
								vecinos.get(correspondencia[a][1]).add(correspondencia[anterior][1]);
							}
							anterior = a;
							conteo = 0;
						}
					}
				}
			}
			int [] mejores = new int[importantes.size()];
			int [][] mejoresDistancias = new int[importantes.size()][importantes.size()];
			for(int j = 0; j < importantes.size(); j++)
			{
				int[] distancia = new int[importantes.size()];
				int[] anterior = new int[importantes.size()];
				for(int k = 0; k < j; k++)
				{
					distancia[k] = mejoresDistancias[j][k];	
					anterior[k] = Integer.MAX_VALUE;
				}
				for(int k = j; k < importantes.size(); k++)
				{
					distancia[k] = Integer.MAX_VALUE;	
					anterior[k] = Integer.MAX_VALUE;
				}
				distancia[j] = 0;
				FibonacciHeap q = new FibonacciHeap();
				Nodo[] nodos = new Nodo[importantes.size()];
				for(int k = 0; k < importantes.size(); k++)
				{
					Nodo z = new Nodo(distancia[k], k);
					q.insert(z);
					nodos[k] = z;
				}
				boolean[] removido = new boolean[importantes.size()];
				while(!q.isEmpty())
				{
					Nodo mejor = (Nodo) q.removeMin();
					removido[mejor.numero] = true;
					if(mejor.key == Integer.MAX_VALUE)
						break;
					for(int a : vecinos.get(mejor.numero))
					{
						if(!removido[a])
						{
							int alt = distancia[mejor.numero] + matAdyacencia[a][mejor.numero];
							if(alt < distancia[a])
							{
								distancia[a] = alt;
								anterior[a] = mejor.numero;
								q.decreaseKey(nodos[a], alt);
							}
						}
					}
				}
				int z = 0;
				for(int a : distancia)
				{
					mejores[j] += a;
					mejoresDistancias[j][z] = a;
					mejoresDistancias[z++][j] = a;
				}
			}
			int mejor = 0;
			int mejorDistancia = Integer.MAX_VALUE;
			for(int j = 0; j < mejores.length; j++)
			{
				if(mejores[j] < mejorDistancia)
				{
					mejor = j;
					mejorDistancia = mejores[j];
				}
			}
			System.out.println("Krochanska is in: " + importantes.get(mejor));
		}
	}
	
    public static class Nodo extends FibonacciHeap.Node
    {
            int numero;
            public Nodo(int key, int n) 
            {
                    super(key);
                    numero = n;
            }
    }

    
	public static class FibonacciHeap {
        /** Points to the minimum node in the heap. */
        private Node min;
       
        /** Number of nodes in the heap. If the type is ever widened,
         * (e.g. changed to long) then recalcuate the maximum degree
         * value used in the consolidate() method. */
        private int n;

        /**
         * Removes all elements from this heap.
         *
         * <p><em>Running time: O(1)</em></p>
         */
        public void clear() {
            min = null;
            n = 0;
        }

        /**
         * Consolidates the trees in the heap by joining trees of equal
         * degree until there are no more trees of equal degree in the
         * root list.
         *
         * <p><em>Running time: O(log n) amortized</em></p>
         */
        private void consolidate() {
            // The magic 45 comes from log base phi of Integer.MAX_VALUE,
            // which is the most elements we will ever hold, and log base
            // phi represents the largest degree of any root list node.
            Node[] A = new Node[45];

            // For each root list node look for others of the same degree.
            Node start = min;
            Node w = min;
            do {
                Node x = w;
                // Because x might be moved, save its sibling now.
                Node nextW = w.right;
                int d = x.degree;
                while (A[d] != null) {
                    // Make one of the nodes a child of the other.
                    Node y = A[d];
                    if (x.key > y.key) {
                        Node temp = y;
                        y = x;
                        x = temp;
                    }
                    if (y == start) {
                        // Because removeMin() arbitrarily assigned the min
                        // reference, we have to ensure we do not miss the
                        // end of the root node list.
                        start = start.right;
                    }
                    if (y == nextW) {
                        // If we wrapped around we need to check for this case.
                        nextW = nextW.right;
                    }
                    // Node y disappears from root list.
                    y.link(x);
                    // We've handled this degree, go to next one.
                    A[d] = null;
                    d++;
                }
                // Save this node for later when we might encounter another
                // of the same degree.
                A[d] = x;
                // Move forward through list.
                w = nextW;
            } while (w != start);


            // The node considered to be min may have been changed above.
            min = start;
            // Find the minimum key again.
            for (Node a : A) {
                if (a != null && a.key < min.key) {
                    min = a;
                }
            }
        }

        /**
         * Decreases the key value for a heap node, given the new value
         * to take on. The structure of the heap may be changed, but will
         * not be consolidated.
         *
         * <p><em>Running time: O(1) amortized</em></p>
         *
         * @param  x  node to decrease the key of
         * @param  k  new key value for node x
         * @exception  IllegalArgumentException
         *             if k is larger than x.key value.
         */
        public void decreaseKey(Node x, int k) {
            decreaseKey(x, k, false);
        }

        /**
         * Decrease the key value of a node, or simply bubble it up to the
         * top of the heap in preparation for a delete operation.
         *
         * @param  x       node to decrease the key of.
         * @param  k       new key value for node x.
         * @param  delete  true if deleting node (in which case, k is ignored).
         */
        private void decreaseKey(Node x, int k, boolean delete) {
            if (!delete && k > x.key) {
                throw new IllegalArgumentException("cannot increase key value");
            }
            x.key = k;
            Node y = x.parent;
            if (y != null && (delete || k < y.key)) {
                y.cut(x, min);
                y.cascadingCut(min);
            }
            if (delete || k < min.key) {
                min = x;
            }
        }

        /**
         * Deletes a node from the heap given the reference to the node.
         * The trees in the heap will be consolidated, if necessary.
         *
         * <p><em>Running time: O(log n) amortized</em></p>
         *
         * @param  x  node to remove from heap.
         */
        public void delete(Node x) {
            // make x as small as possible
            decreaseKey(x, 0, true);
            // remove the smallest, which decreases n also
            removeMin();
        }

        /**
         * Tests if the Fibonacci heap is empty or not. Returns true if
         * the heap is empty, false otherwise.
         *
         * <p><em>Running time: O(1)</em></p>
         *
         * @return  true if the heap is empty, false otherwise.
         */
        public boolean isEmpty() {
            return min == null;
        }

        /**
         * Inserts a new data element into the heap. No heap consolidation
         * is performed at this time, the new node is simply inserted into
         * the root list of this heap.
         *
         * <p><em>Running time: O(1)</em></p>
         *
         * @param  x    data object to insert into heap.
         * @param  key  key value associated with data object.
         * @return newly created heap node.
         */
        public void insert(Node node) {
            // concatenate node into min list
            if (min != null) {
                node.right = min;
                node.left = min.left;
                min.left = node;
                node.left.right = node;
                if (node.key < min.key) {
                    min = node;
                }
            } else {
                min = node;
            }
            n++;
        }

        /**
         * Returns the smallest element in the heap. This smallest element
         * is the one with the minimum key value.
         *
         * <p><em>Running time: O(1)</em></p>
         *
         * @return  heap node with the smallest key, or null if empty.
         */
        public Node min() {
            return min;
        }

        /**
         * Removes the smallest element from the heap. This will cause
         * the trees in the heap to be consolidated, if necessary.
         *
         * <p><em>Running time: O(log n) amortized</em></p>
         *
         * @return  data object with the smallest key.
         */
        public Node removeMin() {
            Node z = min;
            if (z == null) {
                return null;
            }
            if (z.child != null) {
                z.child.parent = null;
                // for each child of z do...
                for (Node x = z.child.right; x != z.child; x = x.right) {
                    // set parent[x] to null
                    x.parent = null;
                }
                // merge the children into root list
                Node minleft = min.left;
                Node zchildleft = z.child.left;
                min.left = zchildleft;
                zchildleft.right = min;
                z.child.left = minleft;
                minleft.right = z.child;
            }
            // remove z from root list of heap
            z.left.right = z.right;
            z.right.left = z.left;
            if (z == z.right) {
                min = null;
            } else {
                min = z.right;
                consolidate();
            }
            // decrement size of heap
            n--;
            return z;
        }

        /**
         * Returns the size of the heap which is measured in the
         * number of elements contained in the heap.
         *
         * <p><em>Running time: O(1)</em></p>
         *
         * @return  number of elements in the heap.
         */
        public int size() {
            return n;
        }

        /**
         * Joins two Fibonacci heaps into a new one. No heap consolidation is
         * performed at this time. The two root lists are simply joined together.
         *
         * <p><em>Running time: O(1)</em></p>
         *
         * @param  H1  first heap
         * @param  H2  second heap
         * @return  new heap containing H1 and H2
         */
        public FibonacciHeap union(FibonacciHeap H1, FibonacciHeap H2) {
            FibonacciHeap H = new FibonacciHeap();
            if (H1 != null && H2 != null) {
                H.min = H1.min;
                if (H.min != null) {
                    if (H2.min != null) {
                        H.min.right.left = H2.min.left;
                        H2.min.left.right = H.min.right;
                        H.min.right = H2.min;
                        H2.min.left = H.min;
                        if (H2.min.key < H1.min.key) {
                            H.min = H2.min;
                        }
                    }
                } else {
                    H.min = H2.min;
                }
                H.n = H1.n + H2.n;
            }
            return H;
        }


        /**
         * Implements a node of the Fibonacci heap. It holds the information
         * necessary for maintaining the structure of the heap. It acts as
         * an opaque handle for the data element, and serves as the key to
         * retrieving the data from the heap.
         *
         * @author  Nathan Fiedler
         */
        public static class Node {
            /** Key value for this node. */
            int key;
            /** Parent node. */
            private Node parent;
            /** First child node. */
            private Node child;
            /** Right sibling node. */
            private Node right;
            /** Left sibling node. */
            private Node left;
            /** Number of children of this node. */
            private int degree;
            /** True if this node has had a child removed since this node was
             * added to its parent. */
            private boolean mark;

            /**
             * Two-arg constructor which sets the data and key fields to the
             * passed arguments. It also initializes the right and left pointers,
             * making this a circular doubly-linked list.
             *
             * @param  data  data object to associate with this node
             * @param  key   key value for this data object
             */
            public Node(int key) {
                this.key = key;
                right = this;
                left = this;
            }

            /**
             * Performs a cascading cut operation. Cuts this from its parent
             * and then does the same for its parent, and so on up the tree.
             *
             * <p><em>Running time: O(log n)</em></p>
             *
             * @param  min  the minimum heap node, to which nodes will be added.
             */
            public void cascadingCut(Node min) {
                Node z = parent;
                // if there's a parent...
                if (z != null) {
                    if (mark) {
                        // it's marked, cut it from parent
                        z.cut(this, min);
                        // cut its parent as well
                        z.cascadingCut(min);
                    } else {
                        // if y is unmarked, set it marked
                        mark = true;
                    }
                }
            }

            /**
             * The reverse of the link operation: removes x from the child
             * list of this node.
             *
             * <p><em>Running time: O(1)</em></p>
             *
             * @param  x    child to be removed from this node's child list
             * @param  min  the minimum heap node, to which x is added.
             */
            public void cut(Node x, Node min) {
                // remove x from childlist and decrement degree
                x.left.right = x.right;
                x.right.left = x.left;
                degree--;
                // reset child if necessary
                if (degree == 0) {
                    child = null;
                } else if (child == x) {
                    child = x.right;
                }
                // add x to root list of heap
                x.right = min;
                x.left = min.left;
                min.left = x;
                x.left.right = x;
                // set parent[x] to nil
                x.parent = null;
                // set mark[x] to false
                x.mark = false;
            }

            /**
             * Make this node a child of the given parent node. All linkages
             * are updated, the degree of the parent is incremented, and
             * mark is set to false.
             *
             * @param  parent  the new parent node.
             */
            public void link(Node parent) {
                // Note: putting this code here in Node makes it 7x faster
                // because it doesn't have to use generated accessor methods,
                // which add a lot of time when called millions of times.
                // remove this from its circular list
                left.right = right;
                right.left = left;
                // make this a child of x
                this.parent = parent;
                if (parent.child == null) {
                    parent.child = this;
                    right = this;
                    left = this;
                } else {
                    left = parent.child;
                    right = parent.child.right;
                    parent.child.right = this;
                    right.left = this;
                }
                // increase degree[x]
                parent.degree++;
                // set mark false
                mark = false;
            }
        }
    }


}
