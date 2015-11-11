/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Riccardo Cardin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
package it.math.unipd.pcd.threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public class BlockingUI {

    private static void buildUi() {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Very bad program");
        frame.add(new BadComponent());
        frame.add(makeButton(), BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static JPanel makeButton() {
        JButton button = new JButton("Start");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                buildUi();
            }
        });
    }
}

class BadComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("I'm a very bad program -_-", 75, 100);
    }
}