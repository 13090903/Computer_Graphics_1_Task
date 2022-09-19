package com.company;

import java.awt.*;

public class Tree {
    private int x, y;
    private Color c;

    public Tree(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public void draw(Graphics2D g2d) {
        DrawUtils.drawTree(g2d, x, y, c);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }
}
