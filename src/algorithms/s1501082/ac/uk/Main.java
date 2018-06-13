package algorithms.s1501082.ac.uk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Damon on 09/02/2017.
 */
// Hello Java my old friend
public class Main extends JPanel {
    public static void main(String args[]){
      Main main = new Main();

      main.createGui();
    }

    public void createGui(){

        // Sets up the gui
        Gui gui = new Gui();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setPreferredSize(new Dimension(400,400));
        gui.setSize(400,400);
        gui.pack();
        gui.setTitle("Title");
        gui.setVisible(true);
       // add(gui);
    }


}
