import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class B_PQ {

	static class Entrada implements Comparable <Entrada> {
		Node nodo;
		int w;
		
		public Entrada(Node n, int ww) {
			nodo = n;
			w = ww;
		}

		@Override
		public int compareTo(Entrada o) {
			return w - o.w;
		}

	}
    static class Node implements Comparable<Node>{
        int i;
        int j;
        int w;
        boolean visitado;

        Node(int i,int j,int w){
            this.i=i;
            this.j=j;
            this.w=w;
        }
        @Override
        public int compareTo(Node k){
            if(w == k.w)
            {
                if(i == k.i)
                    return j - k.j;
                else
                    return i - k.i;
            }
            return w - k.w;
        }


    }



    static int[][] matrix = new int[1010][1010];
    static Node[][] nodos = new Node[1010][1010];


    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("B.in"));
    	System.setOut(new PrintStream(new BufferedOutputStream(System.out)));
        PriorityQueue<Entrada> PQ=new PriorityQueue<Entrada>(1000000);
        BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
        int C,R,Cf,Rf,Ct,Rt,W;
        int C1,C2,R1,R2;
        String cad=rd.readLine();
    	long tiempo = System.currentTimeMillis();
        StringTokenizer tk;
            for(int i=1;i<=1001;i++)
            {
                for(int j=1;j<=1001;j++)
                {
                    nodos[i][j] = new Node(i, j, 0);
                }
            }
        while(!cad.equals("0 0")){
            tk=new StringTokenizer(cad);
            C=Integer.valueOf(tk.nextToken());
            R=Integer.valueOf(tk.nextToken());
            for(int i=0;i<=R+1;i++){
                for(int j=0;j<=C+1;j++)
                {
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
            tk=new StringTokenizer(rd.readLine());
            Cf=Integer.valueOf(tk.nextToken());
            Rf=Integer.valueOf(tk.nextToken());
            Ct=Integer.valueOf(tk.nextToken());
            Rt=Integer.valueOf(tk.nextToken());
            W=Integer.valueOf(rd.readLine());
            for(int k=0;k<W;k++)
            {
                tk=new StringTokenizer(rd.readLine());
                C1=Integer.valueOf(tk.nextToken());
                R1=Integer.valueOf(tk.nextToken());
                C2=Integer.valueOf(tk.nextToken());
                R2=Integer.valueOf(tk.nextToken());
                for(int i=R1;i<=R2;i++)
                {
                    for(int j=C1;j<=C2;j++)
                    {
                        matrix[i][j]=-1;
                    }
                }
            }


            
            matrix[Rf][Cf]=0;
            PQ.clear();
            for(int i=1;i<=R;i++)
            {
                for(int j=1;j<=C;j++)
                {
                    if (matrix[i][j]!=-1)
                    {
                        nodos[i][j].w = Integer.MAX_VALUE;
                        nodos[i][j].visitado = false;
                    }
                }
            }
            nodos[Rf][Cf].w = 0;
            PQ.add(new Entrada(nodos[Rf][Cf], 0));
            boolean flag=false;
            while(!PQ.isEmpty())
            {
                Entrada uu=PQ.poll();
                Node u=uu.nodo;
                if(u.visitado)
                	continue;
                u.visitado = true;
                if ((u.i==Rt)&&(u.j==Ct))
                {
                    System.out.println(u.w);
                    flag=true;
                    break;
                }

                //generando vecinos
                int costo;
                int x,y;
                for(int i=-2;i<=2;i++)
                {
                    for(int j=-2;j<=2;j++)
                    {
                        if(i == 0 && j == 0)
                            continue;
                        x=u.i+i;
                        y=u.j+j;
                        if ((x>=1)&&(x<=R)&&(y>=1)&&(y<=C)&&(matrix[x][y]!=-1))
                        {
                            costo=calcular_costo(x,y,u.i,u.j);
                            int siguienteCosto = u.w + costo;
                            if(nodos[x][y].w > siguienteCosto)
                            {
                                nodos[x][y].w = siguienteCosto;
                                matrix[x][y] = siguienteCosto;
                                PQ.add(new Entrada(nodos[x][y],siguienteCosto));
                            }
                        }
                    }
                } 
            }

            if(!flag)
                System.out.println("impossible");



            //
            cad=rd.readLine();
        }
        System.out.println("Se demoro " + (System.currentTimeMillis() - tiempo) + " ms");
        System.out.flush();
    }


    public static int calcular_costo(int x,int y,int i,int j)
    {
       int diferencia_x = Math.abs(x - i);
       int diferencia_y = Math.abs(y - j);
       if(diferencia_x == 0)
       {
           switch(diferencia_y)
           {
               case 2: return 5;
               case 1: return 2;
               case 0: return -1;
               default: return -1;
           }
       }
       else if(diferencia_x == 1)
       {
           switch(diferencia_y)
           {
               case 2: return 6;
               case 1: return 3;
               case 0: return 2;
               default: return -1;
           }
       }
       else
       {
           switch(diferencia_y)
           {
               case 2: return 7;
               case 1: return 6;
               case 0: return 5;
               default: return -1;
           }
       }
    }

}
