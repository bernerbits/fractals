/*  Project:      5
 *  File:         ConsoleFractalPlotter.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal.plotter.png;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bernerbits.fractal.colorer.IColorer;
import com.bernerbits.fractal.plotter.AbstractPlotter;

public class PNGPlotter extends AbstractPlotter
{

  private IColorer colorer;
  private String fileName;
  
  public PNGPlotter(int width, int height, int maxIterations, IColorer colorer, String fileName)
  {
    super(width, height, maxIterations);
    this.colorer = colorer;
    this.fileName = fileName;
  }

  @Override
  protected void render(final int[] set, final int width, final int height)
  {
    colorer.precompute(set, width, height, IN_SET);
    
    final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for(int i = 0; i < set.length; i++)
    {
      int x = i % width;
      int y = i / width;
      
      image.setRGB(x, y, colorer.color(set[i]).getRGB());        
    }
    
    File outputFile = new File(new File(new File(System.getProperty("user.home")),"Documents"),fileName);
    try
    {
      System.out.println(outputFile.getCanonicalPath());
      outputFile.createNewFile();
      ImageIO.write(image, "png", outputFile);
      System.out.println("Wrote " + outputFile.getCanonicalPath());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
}
