package com.gabriel.draw.controller;

import com.gabriel.draw.command.SetColorCommand;
import com.gabriel.draw.view.DrawingStatusBar;
import com.gabriel.drawfx.command.CommandService;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.drawfx.ActionCommand;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;
import com.gabriel.draw.command.SetShapeModeCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionController implements ActionListener {
    AppService appService;
    DrawingStatusBar statusBar;

    public ActionController(AppService appService, DrawingStatusBar statusBar) {
        this.appService = appService;
        this.statusBar = statusBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd) {
            case ActionCommand.UNDO:
                appService.undo();
                updateStatusBar();
                break;
            case ActionCommand.REDO:
                appService.redo();
                updateStatusBar();
                break;
            case ActionCommand.COLOR:
                Color chosenColor = JColorChooser.showDialog(null, "Choose a color", appService.getColor());
                if (chosenColor != null) {
                    CommandService.ExecuteCommand(new SetColorCommand(appService, chosenColor));
//                    statusBar.setCurrentColor(chosenColor);
                }
                break;
            case ActionCommand.LINE:
                CommandService.ExecuteCommand(new SetShapeModeCommand(appService, ShapeMode.Line));
                updateStatusBar();
                break;
            case ActionCommand.RECT:
                CommandService.ExecuteCommand(new SetShapeModeCommand(appService, ShapeMode.Rectangle));
                updateStatusBar();
                break;
            case ActionCommand.ELLIPSE:
                CommandService.ExecuteCommand(new SetShapeModeCommand(appService, ShapeMode.Ellipse));
                updateStatusBar();
                break;
        }
    }
    private void updateStatusBar(){
        statusBar.setCurrentShapeMode(appService.getShapeMode());
    }
}
