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
package it.math.unipd.pcd.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public class CardLayoutExample extends JFrame {
    // Static dimensions
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final String CARD1_DESC = "Card 1";
    private static final String CARD2_DESC = "Card 2";

    // Cards deck
    private JPanel cards;

    public CardLayoutExample(String title) {
        super(title);

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        addComponentsToPane(getContentPane());
    }

    private void addComponentsToPane(Container pane) {
        // Create a combo box to change between cards
        JPanel comboPane = createCombo();
        // Create cards deck
        cards = new JPanel(new CardLayout());
        cards.add(createCard1(), "Card 1");
        cards.add(createCard2(), "Card 2");
        // Add panes to content pane
        pane.add(comboPane, BorderLayout.NORTH);
        pane.add(cards, BorderLayout.CENTER);
    }

    private JPanel createCombo() {
        JPanel comboPane = new JPanel();
        // Create combo box
        String comboValues[] = {CARD1_DESC, CARD2_DESC};
        JComboBox comboBox = new JComboBox(comboValues);
        comboBox.setEditable(false);

        // Add combo a listener
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Get the layout
                CardLayout layuot = (CardLayout) cards.getLayout();
                layuot.show(cards, (String) e.getItem());
            }
        });

        comboPane.add(comboBox);
        return comboPane;
    }

    private JPanel createCard1() {
        JPanel panel = new JPanel();
        panel.add(new JButton("Btn of card 1"));
        return panel;
    }
    private JPanel createCard2() {
        JPanel panel = new JPanel();
        panel.add(new JButton("Btn of card 2"));
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CardLayoutExample frame = new CardLayoutExample("Card layout example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
