package UVA;

import java.text.DecimalFormat;
import java.util.*;

public class speedy {

	static int n,m,e;
	static int p,b;
	static int [][]costs = new int[105][105];
	static int []exits = new int[105];
	
	static int []ladron = new int[105];
	static int []cop = new int[105];
	static int[]copdad = new int[105];
	static int[]laddad = new int[105];
	
	static DecimalFormat df = new DecimalFormat("0.0000000000");
	static void init() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				costs[i][j] = Integer.MAX_VALUE;
			}
			ladron[i] = Integer.MAX_VALUE;
			cop[i] = Integer.MAX_VALUE;
			copdad[i] = -1;
			laddad[i] = -1;
		}
	}
	
	static void dtra(int[] res, int[] dad, int forb) {
		boolean[] visited = new boolean[105];
		for (int i=0; i<n; i++) {
			int menor=-1, mv=Integer.MAX_VALUE;
			for (int j=0; j<n; j++) {
				if (res[j] < mv && !(visited[j]) && j!=forb) {
					mv = res[j];
					menor = j;
				}				
			}
			if (menor == -1) break;
			visited[menor]=true;
			for (int j=0; j<n; j++) {
				int cost = costs[menor][j]; 
				int ncost = cost + res[menor];
				if (cost < Integer.MAX_VALUE) {
					if (ncost < res[j]) {
						res[j] = ncost;
						dad[j] = menor;
					}
				}
			}
		}
	}
	
	static void res() {
		double vel = Double.MAX_VALUE;
		for (int i=0; i<e; i++) {
			int s = exits[i];
			int dl = ladron[s]; 
			if (dl < Integer.MAX_VALUE) {
				double v = ((double)dl/cop[s])*160;
				while (laddad[s] == copdad[s]) {
					s = laddad[s];
					dl = ladron[s];
					double nv = ((double)dl/cop[s])*160;
					v = Math.max(v, nv);
				}
				if (v<vel) vel=v;
			}
		}
		if (vel == Double.MAX_VALUE) System.out.println("IMPOSSIBLE");
		else System.out.println(df.format(vel));
	}
	
	public static void main(String []args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int caso=0; caso<N; caso++) {
			n = in.nextInt(); //Num of nodes
			m = in.nextInt(); //Num of roads
			e = in.nextInt(); //Num of exits
			init();
			int a,b,l;
			for (int i=0; i<m; i++) {
				a = in.nextInt()-1; //Org
				b = in.nextInt()-1; //Dest
				l = in.nextInt(); //Lenght
				costs[a][b] = l;
				costs[b][a] = l;
			}
			for (int i=0; i<e; i++) {
				exits[i] = in.nextInt()-1;
			}
			b = in.nextInt()-1; //bank
			p = in.nextInt()-1; //police
			ladron[b]=0;
			cop[p]=0;
			dtra(ladron, laddad,p);
			dtra(cop,copdad,-2);
			res();
		}
	}
}
