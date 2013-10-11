/*  Project:      5
 *  File:         IFractalEvaluator.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - derek.c.berner@vanderbilt.edu
 *
 *  This code is copyright (c) 2013 Vanderbilt University Medical Center
 */
package com.bernerbits.fractal;

public interface IFractalEvaluator
{
  int calculateIterations(Complex c);
  int maxIterations();
}
