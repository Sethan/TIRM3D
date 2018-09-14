/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.shape.Box;

/**
 *
 * @author ZuraH
 */
public class Cube extends Box {
    int value;
    public Cube()
    {
        super(50,50,50);
        this.value=0;
    }
    public void setValue(int v)
    {
        this.value=v;
    }
    public int getValue()
    {
        return this.value;
    }
}
