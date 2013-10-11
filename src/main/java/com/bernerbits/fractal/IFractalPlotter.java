/*  Project:      5
 *  File:         IMandelbrotPlotter.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal;

import java.awt.Dimension;

public interface IFractalPlotter
{
  Dimension getSize();
  
  void plot(int x, int y, int iterations);
  
  void finished();

  void start();
}
