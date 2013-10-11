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
    //viewPort.setExtents(-2, -1, 1, 1);
    
    //double zoom = 1e-10;
    
    //viewPort.setExtents(0.001643721971153 - zoom, -0.822467633298876 - zoom, 0.001643721971153 + zoom, -0.822467633298876 + zoom);
    
    double xzoom = 43;
    double yzoom = 13;
    double x = -.765;
    double y = .125;
    
    viewPort.setExtents(x-(1.5/xzoom),y-(1/yzoom),x+(1.5/xzoom),y+(1/yzoom)); // Seahorse Valley Close-Up

    //viewPort.setExtents(-.74364990 - (0.00073801/2), .13188204 - (0.00073801/3), -.74364990 + (0.00073801/2), .13188204 + (0.00073801/3));
    
    new FractalComputer(viewPort, new MandelbrotEvaluator(maxIterations, 100),
        new PNGPlotter(6000, 4000, maxIterations, new HSColorer(), "seahorses-2.png")).compute();
  }

}
