package ir.sharif.ap2020.tetris.graphics.components;

import ir.sharif.ap2020.tetris.configs.ConfigFile;

import java.awt.*;

public class Converter {
    private final ConfigFile configFile;
    private GCell[][] cells;
    private Point top;
    private int m, n, align;
    private Dimension cellSize;

    public Converter(ConfigFile configFile) {
        this.configFile = configFile;
        setParameters();
    }

    private void setParameters() {
        top = configFile.readPoint("top");
        m = configFile.readInt("m");
        n = configFile.readInt("n");
        cellSize = configFile.readDimension("cellSize");
        align = configFile.readInt("align");
        cells = new GCell[m][n];
    }

    public void convertBoard(boolean[][] board, int[] pieceXs, int[] pieceYs, String pieceName) {
        if (board != null) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Point point = new Point(top.x + i * (cellSize.width + align), top.y + j * (cellSize.height + align));
                    if (board[i][j]) {
                    cells[i][j] = new GCell(configFile.readColor("usedColor"),cellSize,point);
                    } else {
                        cells[i][j] = new GCell(configFile.readColor("defaultColor"),cellSize,point);
                    }
                }

            }
            convertPiece(pieceXs, pieceYs, pieceName);
        }
    }

    private void convertPiece(int[] pieceXs, int[] pieceYs, String pieceName) {
        if (pieceXs == null || pieceYs == null || pieceName == null) return;
        Color color = configFile.readColor(pieceName);
        for (int i = 0; i < pieceXs.length; i++) {
            cells[pieceXs[i]][pieceYs[i]].setColor(color);
        }
    }

    public GCell[][] getCells() {
        return cells;
    }
}
