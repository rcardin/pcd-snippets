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
package it.math.unipd.pcd.collections;

import java.util.*;

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public class CollectionsExamples {

    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("Riccardo");
        coll.add("Cardin");
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            // You have always to call next before calling the remove method.
            // it.next();
            it.remove();
        }

        Set<Pippo> set = new TreeSet<Pippo>(new Comparator<Pippo>() {
            @Override
            public int compare(Pippo o1, Pippo o2) {
                return new Integer(o1.getI()).compareTo(o2.getI());
            }
        });
    }
}

class Pippo {
    int i;

    public Pippo(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}


