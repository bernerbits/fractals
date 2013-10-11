/*  Project:      5
 *  File:         GrayscaleColorer.java
 *  Created:      Oct 11, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal.colorer;

import java.awt.Color;

public interface IColorer
{
  public void precompute(int[] iterations, int width, int height, int reservedValue);
  public Color color(int iterations);
}
