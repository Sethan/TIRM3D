/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ZuraH
 */
public class rules {
    public static int winCheck(int[][][] i)
    {
        for(int x=0; x<3;x++)
        {
            for(int y=0; y<3;y++)
            {
                for(int z=0; z<3;z++)
                {
                    if(i[x][y][z]!=0)
                    {
                        int current = i[x][y][z];
                        for(int s=-1; s<2;s++)
                        {
                            for(int t=-1; t<2;t++)
                            {
                                for(int u=-1; u<2;u++)
                                {
                                    if((s==0&&t==0&&u==0)||outOfBounds(x,s)||outOfBounds(y,t)||(outOfBounds(u,z)))
                                    { 
                                    }
                                    else
                                    {
                                        if(i[x+s][y+t][z+u]==current)
                                        {
                                            int vx=2*s;
                                            int vy=2*t;
                                            int vz=2*u;
                                            if(outOfBounds(x,vx)||outOfBounds(y,vy)||outOfBounds(z,vz))
                                            {
                                               // System.out.println(x+vx+" "+y+vy+""+z+vz); feilbehandling
                                            }
                                            else
                                            {
                                                if(i[x+vx][y+vy][z+vz]==current)
                                                {
                                                     return current;
                                                }  
                                            }
                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static boolean outOfBounds(int a, int b)
    {
        if(a+b>-1&&a+b<3)
        {
            return false;
        }
        return true;
    }
}
