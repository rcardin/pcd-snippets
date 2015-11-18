/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 Riccardo Cardin
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * <p/>
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
package it.math.unipd.pcd.exercises;

/**
 * Implement an immutable class Point that describes a point in the plane. Provide
 * a constructor to set it to a specific point, a no-arg constructor to set it to
 * the origin,  and methods getX, getY, translate, and scale. The translate method
 * moves the point by a given amount in x- and y-direction. The scale method scales
 * both coordinates by a given factor. Implements these methods so that they return
 * new points with the results. Add javadoc comments to the Point class.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public final class Point {

    private final double x;
    private final double y;

    public Point (double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point () {
        this (0,0);
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public Point translate (double x, double y){
        return new Point (this.x + x, this.y + y);
    }

    public Point scale (double fact){
        return new Point (this.x * fact, this.y * fact);
    }
}
