/*  Project:      5
 *  File:         Complex.java
 *  Created:      Oct 10, 2013
 *  Last Changed: $Date$
 *  Author:       Derek Berner - bernerbits@gmail.com
 *
 *  
 */
package com.bernerbits.fractal;

public class Complex
{
  private final double real;
  private final double imaginary;
  
  public Complex(double real, double imaginary)
  {
    this.real = real;
    this.imaginary = imaginary;
  }

  private static Complex zero = new Complex(0,0) {
    public double abs2() { return 0; }
    public Complex squared() { return this; }
    public Complex plus(Complex c) { return c; }
    public Complex times(Complex c) { return this; }
    public Complex conjugate() { return this; }
  };
  
  public double real() { return real; }
  public double imaginary() { return imaginary; }
  
  public static Complex zero()
  {
    return zero;
  }
  
  public Complex plus(Complex c)
  {
    return new Complex(real+c.real, imaginary+c.imaginary);
  }
  
  public Complex times(Complex c)
  {
    return new Complex(real * c.real - imaginary * c.imaginary, real * c.imaginary + imaginary * c.real);
  }
  
  public Complex squared()
  {
    return this.times(this);
  }
  
  public double abs2()
  {
    return real * real + imaginary * imaginary;
  }
  
  public Complex conjugate()
  {
    return new Complex(real, -imaginary);
  }
  
  @Override
  public String toString()
  {
    return real + "+" + imaginary + "i";
  }

}
