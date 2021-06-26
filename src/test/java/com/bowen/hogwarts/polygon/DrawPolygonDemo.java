package com.bowen.hogwarts.polygon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.junit.Test;

public class DrawPolygonDemo extends JApplet {


  private JFrame mainMap;
  private Polygon poly;

  public DrawPolygonDemo() {

    initComponents();

  }

  private void initComponents() {

    mainMap = new JFrame();
    mainMap.setResizable(false);

    mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    int xPoly[] = {150, 250, 325, 375, 450, 275, 100};
    int yPoly[] = {150, 100, 125, 225, 250, 375, 300};

    poly = new Polygon(xPoly, yPoly, xPoly.length);
    JPanel p = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawPolygon(poly);
      }

      @Override
      public Dimension getPreferredSize() {
        return new Dimension(800, 600);
      }
    };
    mainMap.add(p);
    mainMap.pack();
    mainMap.setVisible(true);

  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new DrawPolygonDemo();
      }
    });
  }

}
