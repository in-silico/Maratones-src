import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D {
	
	
	static double epsilon=1e-7;
	
	static double f(double a)
	{
		//return 1-(a*a);
		//f(x)=tan(sin(x))-sin(tan(x))+cos(x)5-0.5 
		double ret=Math.tan(Math.sin(a));
		ret=ret - Math.sin(Math.tan(a));
		ret+=Math.pow(Math.cos(a),5);
		ret-=0.5;
		return ret;
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		while(true)
		{
			String cad=rd.readLine();
			if (cad==null)
				break;
			tk=new StringTokenizer(cad);
			double A=Double.valueOf(tk.nextToken());
			double B=Double.valueOf(tk.nextToken());
			int nb=Integer.valueOf(tk.nextToken());
			double delta=(B-A)/nb;
			int observable=0;
			for(int i=1;i<=nb;i++)
			{
				double a=A+((i-1)*delta);
				double b=A+(i*delta);
				double f_a=f(a);
				double f_b=f(b);
				if (Math.abs(f_a)<epsilon || Math.abs(f_b)<epsilon)
				{
					observable++;
					//System.out.println("entro");
					continue;
				}
				if (f_a*f_b<0)
					observable++;			
			}
			System.out.print(observable+"\r\n");
		}
		
	}

}
