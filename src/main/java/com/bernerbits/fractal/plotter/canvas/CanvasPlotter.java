/*  Project:      5
 *  File:         ConsoleFractalPlotter.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal.plotter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.bernerbits.fractal.colorer.IColorer;
import com.bernerbits.fractal.plotter.AbstractPlotter;

public class CanvasPlotter extends AbstractPlotter
{

  private IColorer colorer;
  
  public CanvasPlotter(int width, int height, int maxIterations, IColorer colorer)
  {
    super(width, height, maxIterations);
    this.colorer = colorer;
  }

  @Override
  protected void render(final int[] set, final int width, final int height)
  {
    colorer.precompute(set, width, height, IN_SET);
    
    JFrame frame = new JFrame("Canvas Plotter");
    frame.setSize(width+20,height+100);
    
    final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for(int i = 0; i < set.length; i++)
    {
      int x = i % width;
      int y = i / width;
      
      image.setRGB(x, y, colorer.color(set[i]).getRGB());        
    }
    frame.getContentPane().add(new Canvas() {
      @Override
      public void paint(Graphics g)
      {
        Graphics2D graphics = (Graphics2D)g;
        graphics.drawImage(image,0,0,width,height,null);
      }
    });
    
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }
  
}
