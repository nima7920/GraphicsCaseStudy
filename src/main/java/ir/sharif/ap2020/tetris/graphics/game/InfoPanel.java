package ir.sharif.ap2020.tetris.graphics.game;

import ir.sharif.ap2020.tetris.admin.GraphicsAdmin;
import ir.sharif.ap2020.tetris.configs.ConfigFile;
import ir.sharif.ap2020.tetris.graphics.components.SubPanel;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends SubPanel {
    private JLabel scoreLabel;
    private int score;
    private String scoreText;
    private final GraphicsAdmin graphicsAdmin;

    public InfoPanel(ConfigFile configs, Actions actions, GraphicsAdmin graphicsAdmin) {
        super(configs, actions);
        this.graphicsAdmin = graphicsAdmin;
    }

    @Override
    protected void initPanel(ConfigFile configs) {
        initLabel(configs);
        this.scoreText = configs.getProperty("scoreText");
    }

    private void initLabel(ConfigFile configs) {
        scoreLabel = new JLabel(configs.getProperty("scoreText") + score);
        scoreLabel.setBounds(configs.readRectangle("scoreLabel"));
        scoreLabel.setForeground(configs.readColor("scoreColor"));
        scoreLabel.setFont(configs.readFont("scoreFont"));
        add(scoreLabel);
    }

    void updateInfo() {
        score = graphicsAdmin.getLogic().getGameState().getScore();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scoreLabel.setText(scoreText + score);
    }
}
