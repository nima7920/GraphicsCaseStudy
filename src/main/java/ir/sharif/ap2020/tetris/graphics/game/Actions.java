package ir.sharif.ap2020.tetris.graphics.game;

import ir.sharif.ap2020.tetris.admin.GraphicsAdmin;
import ir.sharif.ap2020.tetris.configs.ConfigFile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Actions {
    private final GraphicsAdmin graphicsAdmin;
    private int leftKey, rightKey,undoKey,dropKey, rotateKey;
    private String startText, pauseText;

    public Actions(ConfigFile configs, GraphicsAdmin graphicsAdmin) {
        this.graphicsAdmin = graphicsAdmin;
        setParameters(configs);
    }

    private void setParameters(ConfigFile configs) {
        leftKey = configs.readInt("leftKey");
        rightKey = configs.readInt("rightKey");
        undoKey=configs.readInt("undoKey");
        dropKey=configs.readInt("dropKey");
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
            graphicsAdmin.startPause();
        }
    }, undoButtonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            graphicsAdmin.undo();
        }
    }, dropButtonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            graphicsAdmin.drop();
        }
    };

    KeyListener boardKey = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == leftKey)
                graphicsAdmin.moveLeft();
            if (e.getKeyCode() == rightKey)
                graphicsAdmin.moveRight();
            if (e.getKeyCode() == rotateKey)
                graphicsAdmin.rotate();
            if(e.getKeyCode()==undoKey)
                graphicsAdmin.undo();
            if (e.getKeyCode()==dropKey)
                graphicsAdmin.drop();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
}
