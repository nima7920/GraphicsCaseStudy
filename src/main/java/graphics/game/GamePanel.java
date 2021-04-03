package graphics.game;

import admin.GraphicsAdmin;
import admin.LogicAdmin;
import configs.ConfigFile;
import configs.ConfigRepository;
import graphics.components.Converter;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final ConfigRepository configRepository;
    private final ConfigFile gameConfigs;
    private final GraphicsAdmin graphicsAdmin;
    private BoardPanel boardPanel;
    private InfoPanel infoPanel;
    private OptionsPanel optionsPanel;

    public GamePanel(ConfigRepository configRepository, GraphicsAdmin graphicsAdmin) {
        this.configRepository = configRepository;
        this.gameConfigs = configRepository.getConfig("GamePanel");
        this.graphicsAdmin = graphicsAdmin;
    }

    public void initialize() {
        this.setBounds(gameConfigs.readRectangle(""));
        this.setBackground(gameConfigs.readColor("background"));
        setLayout(null);
        initPanels();
    }

    private void initPanels() {
        Actions actions = new Actions(configRepository.getConfig("Actions"), graphicsAdmin);
        boardPanel = new BoardPanel(configRepository.getConfig("BoardPanel"), actions,
                new Converter(configRepository.getConfig("BoardConverter")));
        add(boardPanel);
        optionsPanel = new OptionsPanel(configRepository.getConfig("OptionsPanel"), actions);
        add(optionsPanel);
        infoPanel = new InfoPanel(configRepository.getConfig("InfoPanel"), actions);
        add(infoPanel);
    }

    public void update() {
        if (LogicAdmin.getInstance().isGameOver()) {
            gameOver();
        } else {
            boardPanel.updateBoard();
            infoPanel.updateInfo();
        }
    }

    private void gameOver() {
        JOptionPane.showMessageDialog(null, gameConfigs.getProperty("gameOverText") +
                LogicAdmin.getInstance().getScore());
        System.exit(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boardPanel.repaint();
        infoPanel.repaint();
        optionsPanel.repaint();
    }
}
