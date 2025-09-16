package com.gabriel.draw.view;

import com.gabriel.draw.controller.ActionController;
import com.gabriel.drawfx.ActionCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingToolBar extends JToolBar {
    private final JButton undoButton;
    private final JButton redoButton;
    private final JButton rectButton;
    private final JButton lineButton;
    private final JButton ellipseButton;
    private final JButton colorButton;

    public DrawingToolBar(ActionListener actionListener){


        // undo button
        undoButton = new JButton(new ImageIcon(getClass().getResource("/icons/undo.png")));
        undoButton.setActionCommand(ActionCommand.UNDO);
        undoButton.addActionListener(actionListener);
        add(undoButton);

        // redo button
        redoButton = new JButton(new ImageIcon(getClass().getResource("/icons/redo.png")));
        redoButton.setActionCommand(ActionCommand.REDO);
        redoButton.addActionListener(actionListener);
        add(redoButton);

        addSeparator();

        // rect button
        rectButton = new JButton(new ImageIcon(getClass().getResource("/icons/rectangle.png")));
        rectButton.setActionCommand(ActionCommand.RECT);
        rectButton.addActionListener(actionListener);
        add(rectButton);

        // line button
        lineButton = new JButton(new ImageIcon(getClass().getResource("/icons/line.png")));
        lineButton.setActionCommand(ActionCommand.LINE);
        lineButton.addActionListener(actionListener);
        add(lineButton);

        // ellipse button
        ellipseButton = new JButton(new ImageIcon(getClass().getResource("/icons/ellipse.png")));
        ellipseButton.setActionCommand(ActionCommand.ELLIPSE);
        ellipseButton.addActionListener(actionListener);
        add(ellipseButton);

        addSeparator();

        // color button
        colorButton = new JButton(new ImageIcon(getClass().getResource("/icons/colors.png")));
        colorButton.setActionCommand(ActionCommand.COLOR);
        colorButton.addActionListener(actionListener);
        add(colorButton);

        undoButton.setFocusPainted(false);
        redoButton.setFocusPainted(false);
        rectButton.setFocusPainted(false);
        lineButton.setFocusPainted(false);
        ellipseButton.setFocusPainted(false);
        colorButton.setFocusPainted(false);
    }

}
