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
import java.util.Map;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

public class GrayscaleColorer implements IColorer
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
    
    int size = iterationsSet.size();
    int index = 0;
    int lasti = Integer.MIN_VALUE;
    for(int i : iterationsSet)
    {
      index++;
      if(i != lasti) {
        float gray = index / (float)(size);
        palette.put(i, new Color(gray,gray,gray));
        lasti = i;
      }
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
