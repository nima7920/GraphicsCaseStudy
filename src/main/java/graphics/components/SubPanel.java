package graphics.components;

import configs.ConfigFile;
import graphics.game.Actions;

import javax.swing.*;
import java.awt.*;

public abstract class SubPanel extends JPanel {


    protected Actions actions;

    public SubPanel(ConfigFile configs, Actions actions) {
        this.actions = actions;
        setBounds(configs.readRectangle(""));
        setBackground(configs.readColor("background"));
        setLayout(null);
        initPanel(configs);
    }

    protected abstract void initPanel(ConfigFile configs);

    protected Graphics2D addRenderingHint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        return g2d;
    }
}
