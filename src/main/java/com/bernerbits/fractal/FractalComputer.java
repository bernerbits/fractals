/*  Project:      5
 *  File:         FractalComputer.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - derek.c.berner@vanderbilt.edu
 *
 *  This code is copyright (c) 2013 Vanderbilt University Medical Center
 */
package com.bernerbits.fractal;

import java.awt.Dimension;

public class FractalComputer
{
  private ViewPort viewPort;
  private IFractalEvaluator fractalEvaluator;
  private IFractalPlotter fractalPlotter;
  
  public FractalComputer(ViewPort viewPort, IFractalEvaluator fractalEvaluator,
      IFractalPlotter fractalPlotter)
  {
    this.viewPort = viewPort;
    this.fractalEvaluator = fractalEvaluator;
    this.fractalPlotter = fractalPlotter;
  }
  
  public void compute()
  {
    Dimension viewSize = fractalPlotter.getSize();
    double xStep = (viewPort.getMaxX() - viewPort.getMinX()) / (viewSize.width - 1);
    double yStep = (viewPort.getMaxY() - viewPort.getMinY()) / (viewSize.height - 1);
    
    fractalPlotter.start();
    
    for(double y = viewPort.getMaxY(); y > viewPort.getMinY() - 1e-10; y -= yStep)
    {
      for(double x = viewPort.getMinX(); x < viewPort.getMaxX() + 1e-10; x += xStep) 
      {
        Complex c = new Complex(x, y);
        int iterations = fractalEvaluator.calculateIterations(c);
        viewPort.plotResult(fractalPlotter, c, iterations);
      }
    }
    
    fractalPlotter.finished();
  }
}
