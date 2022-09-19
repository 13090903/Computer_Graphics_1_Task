package com.company;

import java.awt.*;

public class House {
    private int x, y, size;
    Color wallsColor, roofColor, windowColor, lightColor;

    public House(int x, int y, int size, Color wallsColor, Color roofColor, Color windowColor, Color lightColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.wallsColor = wallsColor;
        this.roofColor = roofColor;
        this.windowColor = windowColor;
        this.lightColor = lightColor;
    }

    public void draw(Graphics2D g2d) {
        DrawUtils.drawHouse(g2d, x, y, size, wallsColor, roofColor, windowColor, lightColor);
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getWallsColor() {
        return wallsColor;
    }

    public void setWallsColor(Color wallsColor) {
        this.wallsColor = wallsColor;
    }

    public Color getRoofColor() {
        return roofColor;
    }

    public void setRoofColor(Color roofColor) {
        this.roofColor = roofColor;
    }

    public Color getWindowColor() {
        return windowColor;
    }

    public void setWindowColor(Color windowColor) {
        this.windowColor = windowColor;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public void setLightColor(Color lightColor) {
        this.lightColor = lightColor;
    }
}
