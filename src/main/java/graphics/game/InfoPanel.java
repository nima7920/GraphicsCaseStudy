package graphics.game;

import admin.LogicAdmin;
import configs.ConfigFile;
import graphics.components.SubPanel;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends SubPanel {


    private JLabel scoreLabel;
    private int score;

    public InfoPanel(ConfigFile configs, Actions actions) {
        super(configs, actions);
    }

    @Override
    protected void initPanel() {
        initLabel();
    }

    private void initLabel() {
        scoreLabel = new JLabel(configs.getProperty("scoreText") + score);
        scoreLabel.setBounds(configs.readRectangle("scoreLabel"));
        scoreLabel.setForeground(configs.readColor("scoreColor"));
        scoreLabel.setFont(configs.readFont("scoreFont"));
        add(scoreLabel);
    }

    void updateInfo() {
        score = LogicAdmin.getInstance().getScore();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scoreLabel.setText(configs.getProperty("scoreText") + score);
    }
}
