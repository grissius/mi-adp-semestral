package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.object.GameObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Canvas extends JPanel { 
    GraphicsDrawer drawer = new GraphicsDrawer();
    Model model;

    public Canvas(Model model, int x, int y, int width, int height) {
        this.model = model;
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }
    
    public void thisIsHowYouForceGuiToRepaint() {
        repaint(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // objects
        for (GameObject o: model.getObjects()) {
            drawer.drawGameObject(g, o);
        }
        // text
        int textx = 15;
        int texty = 10;
        for (String s: model.createHudText().split("\n")) {
            g.drawString(s, textx, texty += g.getFontMetrics().getHeight());
        }
    }
    
}
