package UVA;
/****************************************/
/* based on Ford-Fulkerson Method	*/
/* Copyright (C) 1997, 1998 K. Ikeda	*/
/****************************************/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class angry
{
	int	n,m;
	int	snode,tnode;	/* start node, terminate node */
	int	step;
	boolean termino = false;
	Node	v[] = new Node[98];
	Edge	e[] = new Edge[2048];

	void input_graph(Scanner sc) throws IOException 
	{
		int edges = 0;
		n = sc.nextInt();
		m = sc.nextInt();
		if(n == m && n == 0)
		{
			termino = true;
			return;
		}
		v = new Node[98];
		e = new Edge[2048];
		v[0] = new Node();
		v[0].name = 0;
		for (int i = 1; i < n - 1; i++) 
		{
			Node node = new Node();
			node.name = sc.nextInt() - 1;
			int peso = sc.nextInt();
			Node node2 = new Node();
			node2.name = node.name + (n - 2);
			Edge edge = new Edge();
			edge.rndd_plus = node.name;
			edge.rndd_minus = node2.name;
			edge.capacity = peso;
			edge.flow = 0;
			e[edges] = edge;
			edges++;
			v[node.name] = node;
			v[node2.name] = node2;
		}
		v[(((n - 2) * 2) + 1)] = new Node();
		v[(((n - 2) * 2) + 1)].name = (((n - 2) * 2) + 1);
		if(m == 0)
		{
			return;
		}
		for (int i = 0; i < m; i++) 
		{
			Edge edge = new Edge();
			int ent = sc.nextInt() - 1;
			int sal = sc.nextInt() - 1;
			edge.rndd_plus = ent == 0 ? ent : (ent + (n - 2));
			edge.rndd_minus = sal == n - 1 ? (((n - 2) * 2) + 1) : sal;
			edge.capacity = sc.nextInt();
			edge.flow = 0;
			if(sal != (n - 1) && ent != 0)
			{
				Edge edge2 = new Edge();
				edge2.rndd_plus = (sal + (n - 2));
				edge2.rndd_minus = ent;
				edge2.flow = 0;
				edge2.capacity = edge.capacity;
				e[edges] = edge2;
				edges++;
			}
			e[edges] = edge;
			edges++;
		}
		e = Arrays.copyOf(e, edges);
		m = edges;
		Arrays.sort(e, new Comparador());
		step = 1;
	}

	void rdb() 
	{
		int	i,k;
		for (i=0; i<n; i++)
			v[i].delta_plus = v[i].delta_minus = -1;
		for (i=0; i<m; i++)
			e[i].delta_plus = e[i].delta_minus = -1;
		for (i=0; i<m; i++) 
		{
			k = e[i].rndd_plus;
			if (v[k].delta_plus == -1)
				v[k].delta_plus = i;
			else 
			{
				k = v[k].delta_plus;
				while(e[k].delta_plus >= 0)
					k = e[k].delta_plus;
				e[k].delta_plus = i;
			}
			k = e[i].rndd_minus;
			if (v[k].delta_minus == -1)
				v[k].delta_minus = i;
			else 
			{
				k = v[k].delta_minus;
				while(e[k].delta_minus >= 0)
					k = e[k].delta_minus;
				e[k].delta_minus = i;
			}
		}
	}

	void stpath()
	{	
		int	u[] = new int[98], ni, no;
		int	i,j,d;
		for (i=0; i<n; i++) 
		{
			v[i].prev = v[i].dist = -1;
			v[i].l = 0;
		}
		for (i=0; i<m; i++)
			e[i].st = -1;
		ni = no = 0;
		d = 0;
		u[ni] = snode;
		v[snode].dist = 0;
		j = v[snode].delta_plus;
		i = 0;
		while (j>=0) 
		{
			if (i<e[j].capacity)
				i = e[j].capacity;
			j = e[j].delta_plus;
		}
		v[snode].l = i;
		for (; no<=ni; no++) 
		{
			d = v[u[no]].dist;
			for (j=v[u[no]].delta_plus; j>=0; j=e[j].delta_plus)
			{
				if (e[j].capacity-e[j].flow == 0)
					continue;
				i = e[j].rndd_minus;
				if (v[i].dist<0)
				{
					v[i].dist = d+1;
					v[i].prev = u[no];
					v[i].p_edge = j;
					v[i].l = Math.min(v[u[no]].l,
						e[j].capacity-e[j].flow);
					e[j].st++;
					u[++ni] = i;
				}
			}
			for (j=v[u[no]].delta_minus; j>=0; j=e[j].delta_minus) 
			{
				if (e[j].flow == 0)
					continue;
				i = e[j].rndd_plus;
				if (v[i].dist<0)
				{
					v[i].dist = d+1;
					v[i].prev = u[no];
					v[i].p_edge = j;
					v[i].l = Math.min(v[u[no]].l,e[j].flow);
					e[j].st++;
					u[++ni] = i;
				}
			}
		}
	}

	void step0() 
	{
		for (int i=0; i<m; i++)
			e[i].flow = 0;
		stpath();
	}

	void step1() 
	{		
		int	i;
		if (v[tnode].dist<0)
			return;
		for (i = tnode; v[i].prev>=0; i=v[i].prev )
			e[v[i].p_edge].st++;
	}

	void step2() 
	{
		int	i,j,a,f;
		f = v[tnode].l;
		for (i = tnode; (j=v[i].prev)>=0; i = j) 
		{
			a = v[i].p_edge;
			if (e[a].rndd_minus==i)
				e[a].flow += f;
			else if (e[a].rndd_plus==i)
				e[a].flow -= f;
		}
		stpath();
	}

	public void init() 
	{
		try 
		{

//			InputStream is = new FileInputStream("angry.in");
			InputStream is = System.in;
			Scanner sc = new Scanner(is);
			for(;;)
			{
				input_graph(sc);
				if(termino)
				{
					return;
				}
				if(m == 0)
				{
					System.out.println("0");
					continue;
				}
				snode = 0;
				tnode = (((n - 2) * 2) + 1);
				n = tnode + 1;
				rdb();
				step0();
				pasos();
			}
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	public void pasos()
	{
		for(;;)
		{
			if (step == 1) 
			{
				step1();
				if (v[tnode].dist < 0)
					termino();
				else
					step = 2;
			}
			else if(step == -1)
			{
				return;
			}
			else
			{
				step2();
				step = 1;
			}
		}
	}

	private void termino() 
	{
		int acumulado = 0;
		for(int i = 0; i < e.length; i++)
		{
			if(e[i] != null)
			{
				if(e[i].rndd_plus == snode)
				{
					acumulado += e[i].flow;
				}
			}
		}
		step = -1;
		System.out.println(acumulado + "");
	}
	
	public static void main(String [] args)
	{
		angry ag = new angry();
		ag.init();
	}
	

	class Comparador implements Comparator <Edge> 
	{
		public int compare(Edge arg0, Edge arg1) 
		{
			if(arg0.rndd_plus > arg1.rndd_plus)
			{
				return 1;
			}
			else if(arg0.rndd_plus < arg1.rndd_plus)
			{
				return -1;
			}
			else
			{
				if(arg0.rndd_minus > arg1.rndd_minus)
				{
					return 1;
				}
				else if(arg0.rndd_minus < arg1.rndd_minus)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		}

	}

	class Node 
	{
		int	delta_plus;	/* edge starts from this node */
		int	delta_minus;	/* edge terminates at this node */
		int	dist;		/* distance from the start node */
		int	prev;		/* previous node of the shortest path */
		int	p_edge;
		int	l;
		int	w;
		int	h;
		int	name;
	}

	class Edge 
	{
		int	rndd_plus;	/* initial vertex of this edge */
		int	rndd_minus;	/* terminal vertex of this edge */
		int	delta_plus;	/* edge starts from rndd_plus */
		int	delta_minus;	/* edge terminates at rndd_minus */
		int	capacity;	/* capacity */
		int	flow;		/* flow */
		int	st;
	}
}

