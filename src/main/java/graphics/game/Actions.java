package graphics.game;

import admin.GraphicsAdmin;
import configs.ConfigFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Actions {

    private ConfigFile configs;
    private int leftKey, rightKey, rotateKey;
    private String startText, pauseText;

    public Actions(ConfigFile configs) {
        this.configs = configs;
        setParameters();
    }

    private void setParameters() {
        leftKey = configs.readInt("leftKey");
        rightKey = configs.readInt("rightKey");
        rotateKey = configs.readInt("rotateKey");
        startText = configs.getProperty("startText");
        pauseText = configs.getProperty("pauseText");
    }


    ActionListener startButtonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JButton) e.getSource()).getText().equals(startText)) {
                ((JButton) e.getSource()).setText(pauseText);
            } else {
                ((JButton) e.getSource()).setText(startText);
            }
            GraphicsAdmin.getInstance().startPause();
        }
    }, undoButtonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GraphicsAdmin.getInstance().undo();
        }
    }, dropButtonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GraphicsAdmin.getInstance().drop();
        }
    };

    KeyListener boardKey = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == leftKey) {
                GraphicsAdmin.getInstance().moveLeft();
            }
            if (e.getKeyCode() == rightKey) {
                GraphicsAdmin.getInstance().moveRight();
            }
            if (e.getKeyCode() == rotateKey) {
                GraphicsAdmin.getInstance().rotate();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
}
