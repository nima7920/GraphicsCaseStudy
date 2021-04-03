package ir.sharif.ap2020.tetris.graphics.components;

import java.awt.*;

public class GCell {
    private Color color;
    private Dimension size;
    private Point location;

    public void paint(Graphics2D g2d) {
        g2d.setPaint(color);
        g2d.fillRect(location.x, location.y, size.width, size.height);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
