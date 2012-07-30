import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B {
	
	
	public static class pair{
		int x;
		int y;
		int len;
		pair parent;
		boolean primer_camino;
		char visitados;
		public pair(int x,int y,int len,pair parent)
		{
			this.x=x;
			this.y=y;
			this.len=len;
			this.parent=parent;
			this.primer_camino=false;
			this.visitados=0;
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(rd.readLine());
		int N=Integer.valueOf(tk.nextToken());
		int M=Integer.valueOf(tk.nextToken());
		tk=new StringTokenizer(rd.readLine());
		int A1x=Integer.valueOf(tk.nextToken());
		int A1y=Integer.valueOf(tk.nextToken());
		tk=new StringTokenizer(rd.readLine());
		int A2x=Integer.valueOf(tk.nextToken());
		int A2y=Integer.valueOf(tk.nextToken());
		tk=new StringTokenizer(rd.readLine());
		int B1x=Integer.valueOf(tk.nextToken());
		int B1y=Integer.valueOf(tk.nextToken());
		tk=new StringTokenizer(rd.readLine());
		int B2x=Integer.valueOf(tk.nextToken());
		int B2y=Integer.valueOf(tk.nextToken());
		

		
/*		if ((A1x==0 || A1y==0 || A1x==N  || A1y==M )&&(A2x==0 || A2y==0 || A2x==N  || A2y==M ))
		{
			int temp;
			temp=A1x;
			A1x=B1x;
			B1x=temp;
			//
			temp=A1y;
			A1y=B1y;
			B1y=temp;
			//
			temp=A2y;
			A2y=B2y;
			B2y=temp;
			//
			temp=A2x;
			A2x=B2x;
			B2x=temp;
		}
*/		
		pair[][] grid=new pair[N+1][M+1];
		for(int i=0;i<=N;i++)
		{
			for(int j=0;j<=M;j++)
			{
				grid[i][j]=new pair(i,j,0,null);
			}
		}
		
		
		
		pair p=grid[A1x][A1y];
				
		Queue<pair> q=new LinkedList<pair>();
		q.add(p);
		pair actual;
		int len_primer=0;
		pair temp;
		while(q.isEmpty()==false)
		{
			actual=q.poll();
			/*
			if (actual.visitados==1)
				continue;
				*/
			actual.visitados=1;
			if ((actual.x==B1x && actual.y==B1y)||(actual.x==B2x && actual.y==B2y))
			{
				continue;
			}
			if (actual.x==A2x && actual.y==A2y)
			{
				//len_primer=actual.len;
				len_primer=0;
				actual.primer_camino=true;
				temp=actual.parent;
				while(temp!=null)
				{
					len_primer++;
					/*
					System.out.print("ok  ");
					System.out.print(temp.x);
					System.out.print(" ");
					System.out.println(temp.y);
					*/
					temp.primer_camino=true;
					//len_primer++;
					temp=temp.parent;
				}
				break;
				
			}
			int X=actual.x;
			int Y=actual.y;
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					if (i==0 && j==0)
						continue;
					if (X+i<0 || X+i>N || Y+j<0 || Y+j>M)
						continue;
					if (i==0 || j==0)
					{
						//temp=new pair(X+i,Y+j,actual.len+1,actual);
						
						temp=grid[X+i][Y+j];
						if (temp.visitados==1)
							continue;
						temp.len=actual.len+1;
						temp.parent=actual;
						temp.visitados=1;
						q.add(temp);
					}
					
				}
			}
			
			
			
			
			
		}
		
		//2
		
		p=grid[B1x][B1y];
		p.parent=null;
		q.clear();
		q.add(p);
		boolean impossible=true;
		int len_segundo=0;
		while(q.isEmpty()==false)
		{
			actual=q.poll();
			actual.visitados=2;
			if ((actual.x==A1x && actual.y==A1y)||(actual.x==A2x && actual.y==A2y) || actual.primer_camino)
			{
				continue;
			}
			if (actual.x==B2x && actual.y==B2y)
			{
				//len_segundo=actual.len;
				temp=actual.parent;
				while(temp!=null)
				{
					len_segundo++;
					//System.out.print("ok  ");
					//System.out.print(temp.x);
					//System.out.print(" ");
					//System.out.println(temp.y);
					//temp.primer_camino=true;
					//len_primer++;
					temp=temp.parent;
				}
				impossible=false;
				break;
				
			}
			int X=actual.x;
			int Y=actual.y;
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					if (i==0 && j==0)
						continue;
					if (X+i<0 || X+i>N || Y+j<0 || Y+j>M)
						continue;
					if (i==0 || j==0)
					{
						//temp=new pair(X+i,Y+j,actual.len+1,actual);
						temp=grid[X+i][Y+j];
						if (temp.visitados==2)
							continue;
						temp.len=actual.len+1;
						temp.parent=actual;
						temp.visitados=2;
						q.add(temp);
					}
				}
			}
			
			
			
			
			
		}
		
		//System.out.println(len_primer);
		//System.out.println(len_segundo);
		int answer;
		if (impossible)
			answer = Integer.MAX_VALUE;
		else
			answer = len_primer+len_segundo;
		
		
		
		/////////////////////////////////////////////////
		
		int temporal;
			temporal=A1x;
			A1x=B1x;
			B1x=temporal;
			//
			temporal=A1y;
			A1y=B1y;
			B1y=temporal;
			//
			temporal=A2y;
			A2y=B2y;
			B2y=temporal;
			//
			temporal=A2x;
			A2x=B2x;
			B2x=temporal;
		
		
		
		grid=new pair[N+1][M+1];
		for(int i=0;i<=N;i++)
		{
			for(int j=0;j<=M;j++)
			{
				grid[i][j]=new pair(i,j,0,null);
			}
		}
		
		
		
		p=grid[A1x][A1y];
				
		q.clear();
		q.add(p);
		len_primer=0;
		
		while(q.isEmpty()==false)
		{
			actual=q.poll();
			/*
			if (actual.visitados==1)
				continue;
				*/
			actual.visitados=1;
			if ((actual.x==B1x && actual.y==B1y)||(actual.x==B2x && actual.y==B2y))
			{
				continue;
			}
			if (actual.x==A2x && actual.y==A2y)
			{
				//len_primer=actual.len;
				len_primer=0;
				actual.primer_camino=true;
				temp=actual.parent;
				while(temp!=null)
				{
					len_primer++;
					/*
					System.out.print("ok  ");
					System.out.print(temp.x);
					System.out.print(" ");
					System.out.println(temp.y);
					*/
					temp.primer_camino=true;
					//len_primer++;
					temp=temp.parent;
				}
				break;
				
			}
			int X=actual.x;
			int Y=actual.y;
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					if (i==0 && j==0)
						continue;
					if (X+i<0 || X+i>N || Y+j<0 || Y+j>M)
						continue;
					if (i==0 || j==0)
					{
						//temp=new pair(X+i,Y+j,actual.len+1,actual);
						
						temp=grid[X+i][Y+j];
						if (temp.visitados==1)
							continue;
						temp.len=actual.len+1;
						temp.parent=actual;
						temp.visitados=1;
						q.add(temp);
					}
					
				}
			}
			
			
			
			
			
		}
		
		//2
		
		p=grid[B1x][B1y];
		p.parent=null;
		q.clear();
		q.add(p);
		impossible=true;
		len_segundo=0;
		while(q.isEmpty()==false)
		{
			actual=q.poll();
			actual.visitados=2;
			if ((actual.x==A1x && actual.y==A1y)||(actual.x==A2x && actual.y==A2y) || actual.primer_camino)
			{
				continue;
			}
			if (actual.x==B2x && actual.y==B2y)
			{
				//len_segundo=actual.len;
				temp=actual.parent;
				while(temp!=null)
				{
					len_segundo++;
					//System.out.print("ok  ");
					//System.out.print(temp.x);
					//System.out.print(" ");
					//System.out.println(temp.y);
					//temp.primer_camino=true;
					//len_primer++;
					temp=temp.parent;
				}
				impossible=false;
				break;
				
			}
			int X=actual.x;
			int Y=actual.y;
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					if (i==0 && j==0)
						continue;
					if (X+i<0 || X+i>N || Y+j<0 || Y+j>M)
						continue;
					if (i==0 || j==0)
					{
						//temp=new pair(X+i,Y+j,actual.len+1,actual);
						temp=grid[X+i][Y+j];
						if (temp.visitados==2)
							continue;
						temp.len=actual.len+1;
						temp.parent=actual;
						temp.visitados=2;
						q.add(temp);
					}
				}
			}
			
		}
		
		int answer2;
		if (impossible)
			answer2 = Integer.MAX_VALUE;
		else
			answer2 = len_primer+len_segundo;

		
		int answer_final = Math.min(answer, answer2);
		if (answer_final == Integer.MAX_VALUE)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(answer_final);
		
		
		
	}

}
