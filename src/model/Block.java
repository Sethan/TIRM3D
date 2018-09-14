/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controls.Controls;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.transform.Rotate;

/**
 *
 * @author ZuraH
 */
public class Block {
    public int sizeIndex=50;
    Cube[][][] cube3D = new Cube[3][3][3];
    int[][][] memory = new int[3][3][3];
    public Block(Group g)
    {
        for(int x=0; x<3;x++)
        {
            for(int y=0; y<3;y++)
            {
                for(int z=0; z<3;z++)
                {
                    cube3D[x][y][z] = new Cube();
                    PhongMaterial color = new PhongMaterial();
                    color.setDiffuseMap(new Image("/model/empty.png"));
                    cube3D[x][y][z].setMaterial( color);
                    cube3D[x][y][z].setTranslateX(x*sizeIndex+5*x);
                    cube3D[x][y][z].setTranslateY(y*sizeIndex+5*y);
                    cube3D[x][y][z].setTranslateZ(z*sizeIndex+5*z);
                    g.getChildren().add(cube3D[x][y][z]);
                    memory[x][y][z]=0;           
                }
            }
        }
    }
    public int[][][] getMemory()
    {
        return memory;
    }
    public void setMemory(int[][][] i)
    {
        memory=i;
    }
    public void updateBlock()
    {
        for(int x=0; x<3;x++)
        {
            for(int y=0; y<3;y++)
            {
                for(int z=0; z<3;z++)
                {
                    cube3D[x][y][z].setValue(memory[x][y][z]);
                }
            }
        }
        paint();
    }
    public void expand(boolean d, Group g)
    {
        int i;
        if(d)
        {
            i=-100;
            Controls.AdjustGroup(g,225,150,200);
        }
        else
        {
            i=100;
        }
        for(int z=0; z<3;z++)
        {
            for(int x=0; x<3;x++)
            {
                cube3D[x][2][z].setTranslateY(cube3D[x][2][z].getTranslateY()+i);
                cube3D[x][0][z].setTranslateY(cube3D[x][0][z].getTranslateY()-i);
                Controls.AdjustGroup(g,250,75,200);
            }
        }
        
    }
    public void paint()
    {
        PhongMaterial circle = new PhongMaterial();
        circle.setDiffuseMap(new Image("/model/circle.png"));
        PhongMaterial cross = new PhongMaterial();
        cross.setDiffuseMap(new Image("/model/cross.png"));
        for(int x=0; x<3;x++)
        {
            for(int y=0; y<3;y++)
            {
                for(int z=0; z<3;z++)
                {
                    if(cube3D[x][y][z].value==1)
                    {
                        cube3D[x][y][z].setMaterial(circle);
                        memory[x][y][z]=1;
                    }
                    else if(cube3D[x][y][z].value==2)
                    {
                        cube3D[x][y][z].setMaterial(cross);
                        memory[x][y][z]=2;
                    }
                }
            }
        }
        System.out.println(rules.winCheck(memory));
    }

}
