package graphics.game;

import configs.ConfigFile;

import javax.swing.*;

public class GameFrame extends JFrame implements Updatable {

    private final ConfigFile configFile;
    private final GamePanel gamePanel;

    public GameFrame(ConfigFile configFile, GamePanel gamePanel) {
        this.configFile = configFile;
        this.gamePanel = gamePanel;
    }

    public void initFrame() {
        setTitle(configFile.getProperty("frame_title"));
        setLayout(null);
        setResizable(false);
        setSize(gamePanel.getSize());
        setContentPane(gamePanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void update() {
        gamePanel.update();
    }

    @Override
    public void render() {
        revalidate();
        repaint();
    }
}
