/*  Project:      5
 *  File:         ConsoleFractalPlotter.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - derek.c.berner@vanderbilt.edu
 *
 *  This code is copyright (c) 2013 Vanderbilt University Medical Center
 */
package com.bernerbits.fractal.plotter;

import java.awt.Dimension;

import com.bernerbits.fractal.IFractalPlotter;

public abstract class AbstractPlotter implements IFractalPlotter
{

  private int width;
  private int height;
  private int maxIterations;
  
  private int minPlotIterations;
  private int maxPlotIterations;
  
  protected static final int IN_SET = -1;
  
  private int[] set;
 
  
  public AbstractPlotter(int width, int height, int maxIterations)
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
    if(iterations == maxIterations)
    {
      set[y*width+x] = IN_SET;
    }
    else 
    {
      set[y*width+x] = iterations;  
      if(iterations < minPlotIterations) minPlotIterations = iterations;
      if(iterations > maxPlotIterations) maxPlotIterations = iterations;
    }
  }

  @Override
  public void start()
  {
    set = new int[width*height];
    minPlotIterations = Integer.MAX_VALUE;
    maxPlotIterations = Integer.MIN_VALUE;
  }
  
  @Override
  public void finished()
  {
    render(set, width, height);
  }
  
  protected abstract void render(int[] set, int width, int height);

}
