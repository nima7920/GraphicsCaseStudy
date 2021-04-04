package ir.sharif.ap2020.tetris.graphics.components;

import java.awt.*;

public class GCell {
    private final Dimension size;
    private final Point location;
    private Color color;

    public GCell(Color color, Dimension size, Point location) {
        this.color = color;
        this.size = size;
        this.location = location;
    }

    public void paint(Graphics2D g2d) {
        g2d.setPaint(color);
        g2d.fillRect(location.x, location.y, size.width, size.height);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
