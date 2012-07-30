package GoogleCode;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;

/**
 *
 * @author sebas
 */
public class centerMass 
{

    static int[][] matriz;
    static double []cm;
    static int n;

    static double dist(double t) 
    {
        double d=0.0;
        for (int i=0; i<3; i++)
        {
            d += (cm[i]*t + cm[i+3])*(cm[i]*t + cm[i+3]);
        }
        return Math.sqrt(d);
    }

    static double tiempo() 
    {
        cm = new double[6]; //ax - 0, ay - 1, ..., bx->3, by->4
        for (int i=0; i<n; i++) 
        {
            for (int j=0; j<3; j++) 
            {
                cm[3+j] += matriz[i][j];
                cm[j] += matriz[i][3+j];
            }
        }
        for (int j=0; j<3; j++) 
        {
            cm[j] /= (double)n;
            cm[3+j] /= (double)n;
        }
        double t=0, den=0;
        for (int i=0; i<3; i++)
        {
            t -= cm[i]*cm[i+3];
            den += cm[i]*cm[i];
        }
        if (den == 0) 
        	return 0;
        t /= den;
        if (t<0) 
        	return 0;
        return t;
    }

    public static void main(String args[]) throws FileNotFoundException {
        File fIn = new File("center.in");
        Scanner in = new Scanner(fIn);
        int t = in.nextInt();
        for (int c=1; c<=t; c++) 
        {
            n = in.nextInt();
            matriz = new int[n][6];
            for (int i=0; i<n; i++)
                for (int j=0; j<6; j++)
                    matriz[i][j] = in.nextInt();
            double time = tiempo();
            double dis = dist(time);
            System.out.println("Case #" + c + ": " + dis + " " + time);
        }        
    }

}
