package ir.sharif.ap2020.tetris.graphics.game;

import ir.sharif.ap2020.tetris.configs.ConfigFile;
import ir.sharif.ap2020.tetris.graphics.components.SubPanel;

import javax.swing.*;

public class OptionsPanel extends SubPanel {
    private JButton startButton, undoButton, dropButton;

    public OptionsPanel(ConfigFile configs, Actions actions) {
        super(configs, actions);
    }

    @Override
    protected void initPanel(ConfigFile configs) {
        initButtons(configs);
    }

    private void initButtons(ConfigFile configs) {
        startButton = new JButton(configs.getProperty("startText"));
        startButton.setBounds(configs.readRectangle("startButton"));
        startButton.addActionListener(actions.startButtonAction);
        add(startButton);

        undoButton = new JButton(configs.getProperty("undoText"));
        undoButton.setBounds(configs.readRectangle("undoButton"));
        undoButton.addActionListener(actions.undoButtonAction);
        add(undoButton);

        dropButton = new JButton(configs.getProperty("dropText"));
        dropButton.setBounds(configs.readRectangle("dropButton"));
        dropButton.addActionListener(actions.dropButtonAction);
        add(dropButton);
    }
}
