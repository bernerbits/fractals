/*  Project:      5
 *  File:         GrayscaleColorer.java
 *  Created:      Oct 11, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - derek.c.berner@vanderbilt.edu
 *
 *  This code is copyright (c) 2013 Vanderbilt University Medical Center
 */
package com.bernerbits.fractal.colorer;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

public class HSColorer implements IColorer
{

  private Map<Integer, Color> palette;
  private int reservedValue;
  
  @Override
  public void precompute(int[] iterations, int width, int height, int reservedValue)
  {
    this.reservedValue = reservedValue;
    palette = new HashMap<>();
    SortedMultiset<Integer> iterationsSet = TreeMultiset.create();
    for(int i : iterations) 
    {
      if(i != reservedValue)
      {
        iterationsSet.add(i);
      }
    }
    
    float hue = 0.2f;
    float hueStep = 0.01f;
    int size = iterationsSet.size();
    float saturation = 0;
    for(int i : iterationsSet.elementSet())
    {
      saturation += iterationsSet.count(i) / (float)(size);
      hue += hueStep;
      palette.put(i, Color.getHSBColor(hue, .5f + saturation * .5f, 1));
    }
  }

  @Override
  public Color color(int iterations)
  {
    if(iterations == reservedValue) 
    {
      return Color.BLACK;
    }
    else
    {
      return palette.get(iterations);
    }
  }

}
