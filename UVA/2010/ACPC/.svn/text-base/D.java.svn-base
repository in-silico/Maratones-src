import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class D {
static class Scanner
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st;
public String next()
{
while(st == null || !st.hasMoreTokens())
{
try
{
st = new StringTokenizer(br.readLine());
}
catch(Exception e)
{
throw new RuntimeException(e.getMessage());
}
}
return st.nextToken();
}
public long nextLong()
{
return Long.parseLong(next());
}
public int nextInt()
{
return Integer.parseInt(next());
}
}
static double epsilon=1e-8;
static class pair
{
double x;
double y;
public pair(double a,double b)
{
this.x=a;
this.y=b;
}
public void set(double a,double b)
{
this.x=a;
this.y=b;
}
/*
public double angle()
{
double ret=Math.atan2(y, x);
if (ret>0-epsilon)
return ret;
return (2*Math.PI)-ret;
}*/
public double cross(pair a)
{
return this.x*a.y-a.x*this.y;
}
public double dot(pair a)
{
return this.x*a.x+this.y*a.y;
}
public pair subs(pair  a)
{
pair ret=new pair(this.x-a.x,this.y-a.y);
return ret;
}
public double norm()
{
return Math.sqrt(this.dot(this));
}
public double angle_with(pair a)
{
return Math.acos(this.dot(a)/(a.norm()*this.norm()));
//Math.a
}



public boolean equals(pair a)
{
if (Math.abs(this.x-a.x)<epsilon && Math.abs(this.y-a.y)<epsilon)
return true;
return false;
}
}
static pair[] array=new pair[10005];
public static void main(String args[])
{
for(int i=0;i<10005;i++)
array[i]=new pair(0,0);
Scanner sc=new Scanner();
int x_pole;
int y_pole;
int x,y;
while(true)
{
int T=sc.nextInt();
if (T==0) break;
x_pole=sc.nextInt();
y_pole=sc.nextInt();
for(int i=0;i<T;i++)
{
x=sc.nextInt();
y=sc.nextInt();
array[i].set(x-x_pole, y-y_pole);
}
if (array[0].equals(new pair(0,0)))
{
System.out.println("Ouch!");
continue;
}
if (T==1)
{
System.out.println("0");
continue;
}
double angle=0;
double tmp;
boolean flag=false;
for(int i=0;i<T;i++)
{

double pcross=array[(i+1)%T].subs(array[i]).cross(array[i]);

if (Math.abs(pcross)<epsilon)
{
    if (Line2D.ptSegDist(array[i].x, array[i].y,array[(i+1)%T].x , array[(i+1)%T].y, 0, 0)<epsilon)
    {
    flag=true;
    break;
    }
    continue;
}


tmp=array[i].angle_with(array[(i+1)%T]);
if (pcross<0)
angle+=tmp;
else
angle-=tmp;
/*
angle+=array[(i+1)%T].angle()-array[i].angle();
if (Line2D.ptSegDist(array[i].x, array[i].y,array[(i+1)%T].x , array[(i+1)%T].y, 0, 0)<epsilon)
{
flag=true;
break;
} */
}
if (flag)
System.out.println("Ouch!");
else
{
if (Math.abs(angle)<epsilon)
System.out.println("0");
else if (angle>0)
{
double q=angle/(Math.PI*2);
System.out.println("+" + Math.round(q));
}
else
{
double q=-1*angle/(Math.PI*2);
System.out.println("-" + Math.round(q));
}
}
}
}

}

