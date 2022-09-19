package com.company;

import java.awt.*;

public class Balloon {
    private int x, y, r;
    Color c1, c2, c3, c4, c5, c6;

    public Balloon(int x, int y, int r, Color c1, Color c2, Color c3, Color c4, Color c5, Color c6) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
    }

    public void draw(Graphics2D g2d) {
        DrawUtils.drawBalloon(g2d, x, y, r, c1, c2, c3, c4, c5, c6);
    }

    public Color getC6() {
        return c6;
    }

    public void setC6(Color c6) {
        this.c6 = c6;
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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public Color getC2() {
        return c2;
    }

    public void setC2(Color c2) {
        this.c2 = c2;
    }

    public Color getC3() {
        return c3;
    }

    public void setC3(Color c3) {
        this.c3 = c3;
    }

    public Color getC4() {
        return c4;
    }

    public void setC4(Color c4) {
        this.c4 = c4;
    }

    public Color getC5() {
        return c5;
    }

    public void setC5(Color c5) {
        this.c5 = c5;
    }
}
