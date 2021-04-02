package graphics.game;

import admin.LogicAdmin;
import configs.ConfigFile;
import graphics.components.Converter;
import graphics.components.GCell;
import graphics.components.SubPanel;

import java.awt.*;

public class BoardPanel extends SubPanel {

    private GCell[][] cells;
    private Converter converter;

    public BoardPanel(ConfigFile configs,Actions actions ,Converter converter) {
        super(configs,actions);
        this.converter = converter;
    }

    @Override
    protected void initPanel() {
        addKeyListener(actions.boardKey);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = addRenderingHint(g);
        if (cells != null) {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[0].length; j++) {
                    if (cells[i][j] != null)
                        cells[i][j].paint(g2d);
                }
            }

        }
        requestFocus();
    }

    void updateBoard() {
        LogicAdmin.getInstance().passBoard(converter);
        cells = converter.getCells();
    }


}
