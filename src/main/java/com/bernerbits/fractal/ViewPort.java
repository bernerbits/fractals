/*  Project:      5
 *  File:         ViewPort.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal;

import java.awt.Dimension;

public class ViewPort
{
  double minX, minY, maxX, maxY;
  double viewWidth, viewHeight;
  
  public void plotResult(IFractalPlotter plotter, Complex c, int iterations) {
    Dimension plotSize = plotter.getSize();
    int x = (int)Math.round(((c.real() - minX) / (maxX - minX)) * (plotSize.width - 1)) ;
    int y = (plotSize.height - 1) - (int)Math.round(((c.imaginary() - minY) / (maxY - minY)) * (plotSize.height - 1));
    
    plotter.plot(x, y, iterations);
  }
  
  public void setExtents(double minX, double minY, double maxX, double maxY) {
    this.minX = minX;
    this.minY = minY;
    this.maxX = maxX;
    this.maxY = maxY;
    
    viewWidth = maxX - minX;
    viewHeight = maxY - minY;
  }

  public double getMinX()
  {
    return minX;
  }

  public double getMinY()
  {
    return minY;
  }

  public double getMaxX()
  {
    return maxX;
  }

  public double getMaxY()
  {
    return maxY;
  }
  
}
