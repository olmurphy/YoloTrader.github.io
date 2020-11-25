package edu.baylor.ecs.csi3471.main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ListDialog {

    public static void main(String[] args) {
        JList listbox;

        String  listData[] = { "Item 1","Item 2","Item 3","Item 4" };
        listbox = new JList( listData );

        listbox.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if ( SwingUtilities.isRightMouseButton(e) ) {
                    listbox.setSelectedIndex(listbox.locationToIndex(e.getPoint()));
                    System.out.println("index is: " + listbox.getSelectedIndex());


                    JPopupMenu menu = new JPopupMenu();
                    JMenuItem itemRemove = new JMenuItem("Remove");
                    itemRemove.addActionListener(e1 -> {
                        // System.out.println("Remove the element in position " + listbox.getSelectedValue());

                    });
                    menu.add(itemRemove);
                    menu.show(listbox, e.getPoint().x, e.getPoint().y);
                }
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(listbox);
        frame.pack();
        frame.setVisible(true);
    }
}