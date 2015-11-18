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

import java.util.LinkedList;

/**
 * Implement a class Queue, an unbounded queue of strings. Provide method add, adding
 * at the tail, and remove, removing at the head of the queue. Store elements ad a
 * linked list of nodes.
 * Provides an iterator – an object that yields the elements of the queue in turn – for
 * the queue of the preceding class. Iterator should provide methods next and hasNext.
 * Finally, provide a method iterator() of the Queue class that yields an iterator for
 * a queue.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public class Queue {

    private LinkedList<String> list;

    public Queue() {
        list = new LinkedList<String>();
    }

    public void add(String s){
        list.add(s);
    }

    public String remove(){
        return list.remove();
    }

    public Iterator getIterator(){
        return new Iterator();
    }

    class Iterator {
        private int index;

        public Iterator(){
            index = 0;
        }

        public boolean hasNext(){
            if(index >= list.size())
                return false;
            else
                return true;
        }

        public String next(){
            return list.get(index++);
        }
    }

}
