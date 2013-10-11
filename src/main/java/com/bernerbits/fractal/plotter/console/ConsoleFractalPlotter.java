/*  Project:      5
 *  File:         ConsoleFractalPlotter.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal.plotter.console;

import java.awt.Dimension;

import com.bernerbits.fractal.IFractalPlotter;

public class ConsoleFractalPlotter implements IFractalPlotter
{

  private int width;
  private int height;
  private int maxIterations;
  
  private boolean[] set;
  
  public ConsoleFractalPlotter(int width, int height, int maxIterations)
  {
    this.width = width;
    this.height = height;
    this.maxIterations = maxIterations;
  }

  public void setWidth(int width)
  {
    this.width = width;
  }

  public void setHeight(int height)
  {
    this.height = height;
  }

  public void setMaxIterations(int maxIterations)
  {
    this.maxIterations = maxIterations;
  }
  
  @Override
  public Dimension getSize()
  {
    return new Dimension(width, height);
  }

  @Override
  public void plot(int x, int y, int iterations)
  {
    set[y*width+x] = (iterations == maxIterations);
  }

  @Override
  public void start()
  {
    set = new boolean[width*height];
  }
  
  @Override
  public void finished()
  {
    for(int y = 0; y < height; y++)
    {
      for(int x = 0; x < width; x++)
      {
        System.out.print(set[y*width+x] ? "X" : " ");
      }
      System.out.println();
    }
  }

}
