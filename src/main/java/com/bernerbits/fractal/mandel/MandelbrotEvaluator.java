/*  Project:      5
 *  File:         MandelbrotEvaluator.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal.mandel;

import com.bernerbits.fractal.Complex;
import com.bernerbits.fractal.IFractalEvaluator;

public class MandelbrotEvaluator implements IFractalEvaluator
{
  private final int maxIterations;
  private final double escapeThresholdSquared;
  
  public MandelbrotEvaluator(int maxIterations, double escapeThreshold)
  {
    this.maxIterations = maxIterations;
    escapeThresholdSquared = escapeThreshold * escapeThreshold;
  }
  
  @Override
  public int calculateIterations(final Complex c)
  {
    int iterations = 0;
    Complex z = Complex.zero();
    while(++iterations < maxIterations && z.abs2() < escapeThresholdSquared)
    {
      z = z.squared().plus(c); // ♫ And so on.
    }
    return iterations;
  }
  
  @Override
  public int maxIterations()
  {
    return maxIterations;
  }
}
