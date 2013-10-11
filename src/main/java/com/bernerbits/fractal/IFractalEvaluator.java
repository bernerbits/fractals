/*  Project:      5
 *  File:         IFractalEvaluator.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal;

public interface IFractalEvaluator
{
  int calculateIterations(Complex c);
  int maxIterations();
}
