package com.bernerbits.fractal.mandel;

import com.bernerbits.fractal.FractalComputer;
import com.bernerbits.fractal.ViewPort;
import com.bernerbits.fractal.colorer.HSColorer;
import com.bernerbits.fractal.plotter.png.PNGPlotter;

public class Mandelbrot
{

  public static void main(String[] args)
  {
    
    int maxIterations = 1024;
    ViewPort viewPort = new ViewPort();
    viewPort.setExtents(-2, -1, 1, 1);
    // viewPort.setExtents(-.795,.080,-.735,.170); // Seahorse Valley Close-Up

    new FractalComputer(viewPort, new MandelbrotEvaluator(maxIterations, 100),
        new PNGPlotter(149, 101, maxIterations, new HSColorer(), "mandelbrot-full-1.png")).compute();
  }

}
