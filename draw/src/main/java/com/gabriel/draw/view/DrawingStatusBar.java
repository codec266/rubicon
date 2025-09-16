package com.gabriel.draw.view;

import com.gabriel.drawfx.ShapeMode;

import javax.swing.*;
import java.awt.*;

public class DrawingStatusBar extends JPanel {
    private final JLabel currentShapeMode;
    private final JLabel currentCoordinates;
//    private final JLabel currentColor;

    public DrawingStatusBar() {
        super(new BorderLayout());
        setBorder(BorderFactory.createEtchedBorder());

        // mouse coordinates
        currentCoordinates = new JLabel(" ");
        add(currentCoordinates, BorderLayout.WEST);


        // shape mode
        currentShapeMode = new JLabel("Shape Mode: ");
        add(currentShapeMode, BorderLayout.EAST);

        // color mode
//        currentColor = new JLabel("");
//        currentColor.setOpaque(true);
//        currentColor.setPreferredSize(new Dimension(24, 24));
//        currentColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//        add(currentColor, BorderLayout.EAST);

    }

    public void setCurrentShapeMode(ShapeMode shapeMode) {
        currentShapeMode.setText("Shape Mode: " + shapeMode.name());
    }

    public void setCurrentCoordinates(Point p) {
        if (p != null) { currentCoordinates.setText(p.x + ", " + p.y + "px");}
    }

//    public void setCurrentColor(Color color) {
//        currentColor.setBackground(color);
//    }
}
