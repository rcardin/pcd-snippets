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
package it.math.unipd.pcd.threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public class FakeImmutable {

    private final List<Acc> list;
    public FakeImmutable(List<Acc> list) {
        this.list = list;
        Collections.copy(list, this.list);
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("");
        for (int i = 0; i < list.size(); i++)
            aux.append(list.get(i)).append(" ");
        return aux.toString();
    }

    public static void main(String[] args) {

        List<Acc> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Acc(i));
        }

        FakeImmutable fake = new FakeImmutable(list);
        System.out.println(fake.toString());
        System.out.println("----------------");
        list.add(new Acc(11));
        System.out.println(fake.toString());
    }
}

class Acc {
    private int a;

    public Acc(int i) {
        this.a = i;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }
}
