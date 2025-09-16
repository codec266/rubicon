package com.gabriel.draw.command;

import com.gabriel.drawfx.command.Command;
import com.gabriel.drawfx.service.AppService;

import java.awt.*;

public class SetColorCommand implements Command {
    private final AppService appService;
    private final Color newColor;
    private Color previousColor;

    public SetColorCommand(AppService appService, Color newColor) {
        this.appService = appService;
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        previousColor = appService.getColor();
        appService.setColor(newColor);
    }

    @Override
    public void undo() {
        appService.setColor(previousColor);
    }

    @Override
    public void redo() {
        execute();
    }
}
