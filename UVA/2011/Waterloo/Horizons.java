import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	
	
	public static class vector{
		double [] data;
		public vector()
		{
			this.data=new double[3];
		}
		
		public double dot_product(vector a)
		{
			double ret=0.0;
			for (int i=0; i<3; i++)
				ret+=this.data[i]*a.data[i];
			return ret;
		}
		
		public double norm()
		{			
			double sum=0;
			for (int i=0; i<3; i++)
				sum += data[i]*data[i];
			return Math.sqrt(sum);
		}
		
		public vector subs(vector o)
		{
			vector ret=new vector();
			for(int i=0;i<3;i++)
			{
				ret.data[i]=this.data[i]-o.data[i];
			}
			return ret;
		}
		
		public vector add(vector o)
		{
			vector ret=new vector();
			for(int i=0;i<3;i++)
			{
				ret.data[i]=this.data[i]+o.data[i];
			}
			return ret;
		}
		
		public vector mult_by_num(double o)
		{
			vector ret=new vector();
			for(int i=0;i<3;i++)
			{
				ret.data[i]=this.data[i]*o;
			}
			return ret;
		}
		
		public double angle(vector o)
		{
			double den = this.norm();
			den *= o.norm();
			double tmp = this.dot_product(o);
			tmp /= den;
			return Math.acos( tmp );		
		}
		
	}
	
	public static vector to_car(double radio, double p,double t)
	{
		p=p*Math.PI/180.0;
		t=t*Math.PI/180.0;
		vector ret=new vector();
		
		ret.data[0]=Math.cos(p)*Math.cos(t)*radio;
		ret.data[1]=Math.cos(p)*Math.sin(t)*radio;
		ret.data[2]=Math.sin(p)*radio;
		
		return ret; 
	}
	
	
	public static double distance_from_origin_to_segment(vector p1,vector p2)
	{
		vector origen=new vector();
		for(int i=0;i<3;i++)
			{
				origen.data[i]=0.0;
			}
		double u=(-1*p1.data[0])*(p2.data[0]-p1.data[0]);
		u+=(-1*p1.data[1])*(p2.data[1]-p1.data[1]);
		u+=(-1*p1.data[2])*(p2.data[2]-p1.data[2]);
		u  /= p2.subs(p1).norm()*p2.subs(p1).norm();
		//System.out.println(u);
		if (u>=(0-1e-6) && u<=(1+1e-6))
		{
			vector temp=new vector();
			temp=p2.subs(p1).mult_by_num(u).add(p1);
			return origen.subs(temp).norm();
		}
		
		return Double.MAX_VALUE;
		
	}
	
	
	
	public static class Objeto implements Comparable<Objeto>{
		double height;
		double phi;
		double the;
		String name;
		public Objeto(double h, double p, double t, String name)
		{
			this.height=h;
			this.phi=p;
			this.the=t;
			this.name=name;
		}
		
		
		public int compareTo(Objeto arg0) {
			return this.name.compareTo(arg0.name);
		}
		
	}
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		LinkedList<Objeto> array=new LinkedList<Objeto>();
		double diametro=Double.valueOf(rd.readLine());
		tk=new StringTokenizer(rd.readLine());
		double height_Y=Double.valueOf(tk.nextToken());
		double phi_Y=Double.valueOf(tk.nextToken());
		double the_Y=Double.valueOf(tk.nextToken());
		vector tortuga=to_car((diametro/2.0)+height_Y,phi_Y,the_Y);
		String cadena=rd.readLine();
		Objeto temp;
		double t_h,t_p,t_t;
		String cadena_temporal;
		while(cadena!=null)
		{
			tk=new StringTokenizer(cadena);
			t_h=Double.valueOf(tk.nextToken());
			t_p=Double.valueOf(tk.nextToken());
			t_t=Double.valueOf(tk.nextToken());
			cadena_temporal=tk.nextToken();
			while(tk.hasMoreTokens())
			{
				cadena_temporal=cadena_temporal+" "+tk.nextToken();
			}
			temp=new Objeto(t_h,t_p,t_t,cadena_temporal);
			array.add(temp);
			//
			cadena=rd.readLine();
		}
		
		
		Collections.sort(array);
		vector tmp;
		//vector a,b;
		//vector origen=new vector();
		for(Objeto actual: array)
		{
			tmp=to_car(actual.height+(diametro/2.0),actual.phi,actual.the);
			//a=tmp.subs(tortuga);
			//b=origen.subs(tortuga);
			//double alfa=a.angle(b);
			//double H=b.norm();
			//double d=Math.sin(alfa)*H;
			double d=distance_from_origin_to_segment(tortuga,tmp);
			//System.out.println(d);
			double rad = diametro/2.0;
			if ((d-rad)>1e-6)// && !(Math.abs(d - rad)<1E-12))
			{
				System.out.println(actual.name);
			}
		}
		
		
		
		
		
		
		
	}

}
