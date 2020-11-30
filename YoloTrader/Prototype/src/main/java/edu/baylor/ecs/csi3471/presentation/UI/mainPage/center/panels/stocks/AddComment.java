package edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.panels.stocks;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.center.CenterPanelController;

import javax.swing.*;
import java.awt.*;

public class AddComment {

    private static final JTextField subjectField = new JTextField();
    private static final JTextArea contentTextArea = new JTextArea();

    public static void InitializeUI() {
        JDialog commentDialog = new JDialog();
        commentDialog.setTitle("Add Comment");
        commentDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        commentDialog.setPreferredSize(new Dimension(600, 400));

        commentDialog.getContentPane().setLayout(new BorderLayout());

        commentDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // make dialog open in separate window
        commentDialog.setLocationRelativeTo(null);      // centers the frame in the middle of the screen
                                                        // regardless of the dual monitor setup

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(CenterPanelController.centerPanelColor);
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(new JLabel(CenterPanelController.leftLabelSide + "Subject" + CenterPanelController.rightLabelSide),
                BorderLayout.WEST);
        headerPanel.add(subjectField, BorderLayout.CENTER);

        // Body Panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(CenterPanelController.centerPanelColor);
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.add(new JLabel(CenterPanelController.leftLabelSide + "Message:" + CenterPanelController.rightLabelSide),
                BorderLayout.NORTH);
        bodyPanel.add(contentTextArea, BorderLayout.CENTER);

        // footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(CenterPanelController.centerPanelColor);
        footerPanel.setLayout(new GridLayout(1, 2));
        footerPanel.add(getSaveCommentButton());
        footerPanel.add(getDeleteCommentButton());

        // adding panels to dialog
        commentDialog.getContentPane().add(headerPanel, BorderLayout.NORTH);
        commentDialog.getContentPane().add(bodyPanel, BorderLayout.CENTER);
        commentDialog.getContentPane().add(footerPanel, BorderLayout.SOUTH);

        commentDialog.pack();                          // optimal if application is running on different computers
        commentDialog.setVisible(true);                // let the user see the frame once it is fully setup
    }

    public static JButton getSaveCommentButton() {
        JButton saveCommentButton = new JButton(CenterPanelController.leftButtonSide + "Save" + CenterPanelController.rightButtonSide);
        saveCommentButton.setBackground(CenterPanelController.centerPanelColor);
        saveCommentButton.setBorder(CenterPanelController.emptyButtonBorder);

        // adding action
        saveCommentButton.addActionListener(CenterPanelController.getSaveCommentButtonAction());

        // adding UI effects
        saveCommentButton.addMouseListener(CenterPanelController.getGeneralButtonAction(saveCommentButton));

        return saveCommentButton;
    }

    public static JButton getDeleteCommentButton() {
        JButton deleteComment = new JButton(CenterPanelController.leftButtonSide + "Delete" + CenterPanelController.rightButtonSide);
        deleteComment.setBackground(CenterPanelController.centerPanelColor);
        deleteComment.setBorder(CenterPanelController.emptyButtonBorder);

        // adding action
        deleteComment.addActionListener(CenterPanelController.getDeleteCommentButtonAction());

        // adding UI effects
        deleteComment.addMouseListener(CenterPanelController.getGeneralButtonAction(deleteComment));

        return deleteComment;
    }
}