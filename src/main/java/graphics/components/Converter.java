package graphics.components;

import configs.ConfigFile;

import java.awt.*;

public class Converter {

    private ConfigFile configFile;
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
                    cells[i][j] = new GCell();
                    cells[i][j].setLocation(new Point(top.x + i * (cellSize.width + align), top.y + j * (cellSize.height + align)));
                    cells[i][j].setSize(cellSize);
                    if (board[i][j]) {
                        cells[i][j].setColor(configFile.readColor("usedColor"));
                    } else {
                        cells[i][j].setColor(configFile.readColor("defaultColor"));
                    }
                }

            }
            convertPiece(pieceXs, pieceYs, pieceName);
        }
    }

    private void convertPiece(int[] pieceXs, int[] pieceYs, String pieceName) {
        Color color = configFile.readColor(pieceName);
        for (int i = 0; i < pieceXs.length; i++) {
            cells[pieceXs[i]][pieceYs[i]].setColor(color);
        }
    }

    public GCell[][] getCells() {
        return cells;
    }
}
