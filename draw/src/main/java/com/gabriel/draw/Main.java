package com.gabriel.draw;

import com.gabriel.draw.controller.ActionController;
import com.gabriel.draw.view.*;
import com.gabriel.draw.service.DeawingCommandAppService;
import com.gabriel.draw.service.DrawingAppService;
import com.gabriel.draw.controller.DrawingController;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AppService drawingAppService = new DrawingAppService();
        AppService appService = new DeawingCommandAppService(drawingAppService);
        DrawingStatusBar statusBar = new DrawingStatusBar();
        DrawingFrame drawingFrame = new DrawingFrame(appService);
        ActionListener actionListener = new ActionController(appService, statusBar);
        DrawingMenuBar drawingMenuBar = new DrawingMenuBar(actionListener);
        DrawingToolBar drawingToolBar = new DrawingToolBar(actionListener);
        DrawingView drawingView = new DrawingView(appService);
        DrawingController drawingController = new DrawingController(appService, drawingView, statusBar);

        drawingView.addMouseMotionListener(drawingController);
        drawingView.addMouseListener(drawingController);

        drawingMenuBar.setVisible(true);
        drawingFrame.setJMenuBar(drawingMenuBar);

        // drawing tool bar
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(drawingToolBar, BorderLayout.NORTH);
        contentPanel.add(drawingView, BorderLayout.CENTER);
        drawingToolBar.setFloatable(false); // locks panel in place

        // drawing status bar
        contentPanel.add(statusBar, BorderLayout.SOUTH);

        drawingFrame.setContentPane(contentPanel);

        drawingFrame.setVisible(true);
        drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingFrame.setSize(500,500);
    }
}