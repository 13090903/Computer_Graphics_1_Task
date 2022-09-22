package com.company;

import java.awt.*;

public class Sign {
    private int x, y, len, wid;
    private String text;
    private Font font;
    private Color c;

    public Sign(int x, int y, int len, int wid, String text, Font font, Color c) {
        this.x = x;
        this.y = y;
        this.len = len;
        this.wid = wid;
        this.text = text;
        this.font = font;
        this.c = c;

    }

    public void draw(Graphics2D g2d) {
        DrawUtils.drawSign(g2d, x, y, len, wid, text, font, c);
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
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

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}

