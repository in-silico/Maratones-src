import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class B {
	
	 static class Scanner       
	 {                
		 BufferedReader br;
		 StringTokenizer st;                
		 public Scanner()        
		 {                    
			 br = new BufferedReader(new InputStreamReader(System.in));        
			 }                          
		 public String next()  
		 {                            
			 while(st == null || !st.hasMoreTokens())        
			 {                                 
				 try { st = new StringTokenizer(br.readLine()); }      
				 catch(Exception e) { throw new RuntimeException(); }   
			 }                   
			 return st.nextToken();     
			 }                        
		 
		 public int nextInt()   
		 {                         
			 return Integer.parseInt(next());         
			 }                            
		 public double nextDouble()              
		 {                         
			 return Double.parseDouble(next());    
			 }                             
		 public String nextLine()              
		 {               
			 st = null;              
			 try { return br.readLine(); }   
			 catch(Exception e) { throw new RuntimeException(); }     
			 }        
	 }  
	 
	static LinkedList <Integer> lista = new LinkedList <Integer> ();
	 
	static class Mat
	{
		ArrayList <Mat> internas = new ArrayList <Mat> ();
		int n;
		
		public Mat(int nn)
		{
			this.n = nn;
			if(this.n > 0)
				throw(new RuntimeException());
			this.n = -this.n;
		}
		
		public static Mat leerMat()
		{
			Mat nueva = new Mat(lista.poll());
			while(lista.peek().intValue() != nueva.n)
				nueva.internas.add(leerMat());
			lista.poll();
			int cuenta = 0;
			for(Mat mat : nueva.internas)
				cuenta += mat.n;
			if(cuenta >= nueva.n)
				throw(new RuntimeException());
			return nueva;
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s = br.readLine();
			if(s == null)
				return;
			String[] pedazos = s.split("\\s+");
			lista.clear();
			for(int i = 0; i < pedazos.length; i++)
			{
				lista.add(Integer.parseInt(pedazos[i]));
			}
			boolean error = false;
			while(!lista.isEmpty())
			{
				try
				{
					Mat.leerMat();
				}
				catch(Exception e)
				{
					error = true;
				}
			}
			if(error)
				System.out.println(":-( Try again.");
			else
				System.out.println(":-) Matrioshka!");
		}
	}
}
