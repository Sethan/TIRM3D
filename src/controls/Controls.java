/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import model.Block;
import model.Cube;




/**
 *
 * @author lars
 */
public class Controls implements Initializable {
    
    
    
    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) 
    {
        group.setOnMousePressed(evt -> {
                PickResult res = evt.getPickResult();
                if (res.getIntersectedNode() instanceof Cube){
                    if(((Cube)res.getIntersectedNode()).getValue()==0)
                    {
                        ((Cube)res.getIntersectedNode()).setValue(value);
                        if(value==1)
                        {
                            value++;
                        }
                        else
                        {
                            value--;
                        }
                        test.paint();
                    }
                }
        });
        group.getChildren().add(light);
        test = new Block(group);
        AdjustGroup(group, 225,150,200);
    }
    @FXML private Group group=new Group();
    @FXML private Slider speedSlider;
    Block test; 
    double mouseX=0;
    double mouseY=0;
    boolean erect;
    int value=1;
    AmbientLight light = new AmbientLight(Color.rgb(245,245,245));
    
    
    //user events
    public void speedIncreased(MouseEvent event)
    {
        double delay = speedSlider.getValue()/10-5;
        group.getTransforms().add(new Rotate(delay, Rotate.Y_AXIS));
    }

    public void stopButton(ActionEvent event)
    {   
        test.expand(erect,group);
        erect=!erect;
    }
    public static void AdjustGroup(Group g, double x, double y, double z)
    {
        g.getTransforms().clear();
        double posX = x;
        double posY = y;
        double posZ = z;
        Translate trans = new Translate(posX,posY, posZ);
       
        Rotate rotateX = new Rotate(45,  Rotate.X_AXIS);
        Rotate rotateY = new Rotate(135, Rotate.Y_AXIS);
        Rotate rotateZ = new Rotate(-90, Rotate.Z_AXIS);
        
        g.getTransforms().addAll(trans,rotateX, rotateY, rotateZ); 
    }
}

