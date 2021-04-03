package ir.sharif.ap2020.tetris.graphics.game;

import ir.sharif.ap2020.tetris.admin.GameStateAPI;
import ir.sharif.ap2020.tetris.admin.GraphicsAdmin;
import ir.sharif.ap2020.tetris.configs.ConfigFile;
import ir.sharif.ap2020.tetris.graphics.components.Converter;
import ir.sharif.ap2020.tetris.graphics.components.GCell;
import ir.sharif.ap2020.tetris.graphics.components.SubPanel;

import java.awt.*;

public class BoardPanel extends SubPanel {
    private GCell[][] cells;
    private final Converter converter;
    private final GraphicsAdmin graphicsAdmin;

    public BoardPanel(ConfigFile configs, Actions actions, Converter converter, GraphicsAdmin graphicsAdmin) {
        super(configs, actions);
        this.converter = converter;
        this.graphicsAdmin = graphicsAdmin;
    }

    @Override
    protected void initPanel(ConfigFile configs) {
        addKeyListener(actions.boardKey);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = addRenderingHint(g);
        if (cells != null) {
            for (GCell[] cells : this.cells) {
                for (GCell cell : cells) {
                    if (cell != null)
                        cell.paint(g2d);
                }
            }

        }
        requestFocus();
    }

    void updateBoard() {
        GameStateAPI gameState = graphicsAdmin.getLogic().getGameState();
        converter.convertBoard(gameState.getConvertedBoard(), gameState.getPieceXs()
                , gameState.getPieceYs(), gameState.getCurrentPieceName());
        cells = converter.getCells();
    }
}
