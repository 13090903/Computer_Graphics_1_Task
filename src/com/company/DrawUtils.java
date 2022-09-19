package com.company;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawUtils {
    public static void drawStar(Graphics2D g, int x, int y, int size, Color c) {
        int[] xCoordsBase = {0, 1, 3, 1, 2, 0, -2, -1, -3, -1};
        int[] yCoordsBase = {3, 1, 1, 0, -2, -1, -2, 0, 1, 1};
        int[] xCoords = new int[xCoordsBase.length];
        int[] yCoords = new int[yCoordsBase.length];
        for (int i = 0; i < xCoords.length; i++) {
            xCoords[i] = x + xCoordsBase[i] * size;
            yCoords[i] = y - yCoordsBase[i] * size;
        }


        g.setColor(c);

        g.fillPolygon(xCoords, yCoords, 10);


    }

    public static void drawMoon(Graphics2D g, int x, int y, int r, Color c) {
        g.setColor(c);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

    public static void drawTree(Graphics2D g, int x, int y, Color c) {
        g.setColor(new Color(128, 64, 48));
        g.fillRect(x, y, 5, 40);

        g.setColor(c);

        int[] xCoords = {x - 11, x + 16, x + 2};
        int[] yCoords = {y + 30, y + 30, y - 30};

        g.setColor(c);

        g.fillPolygon(xCoords, yCoords, 3);
    }

    public static void drawHouse(Graphics2D g, int x, int y, int size, Color wallsColor, Color roofColor, Color windowColor, Color lightColor) {
        g.setColor(wallsColor);
        g.fillRect(x, y, size, size);

        g.setColor(roofColor);
        int[] xCoords = {x - 10, x + size + 10, x + size / 2};
        int[] yCoords = {y, y, (int) (y - size / 2.7)};
        g.fillPolygon(xCoords, yCoords, 3);

        g.setColor(lightColor);
        g.fillRect(x + size / 3, y + size / 3, size / 3, size / 3);

        g.setColor(windowColor);
        g.setStroke(new BasicStroke(3));
        g.drawRect(x + size / 3, y + size / 3, size / 3, size / 3);
        g.drawLine(x + size / 3, y + size / 3 + size / 6, x + size * 2 / 3, y + size / 3 + size / 6);
        g.drawLine(x + size / 3 + size / 6, y + size / 3, x + size / 3 + size / 6, y + size * 2 / 3);

    }

    public static void drawSun(Graphics2D g, int x, int y, int r, int l, int n, Color c) {
        g.setColor(c);
        g.fillOval(x - r, y - r, 2*r, 2*r);

        g.setStroke(new BasicStroke(4));

        double da = 2* Math.PI / n;

        for (int i = 0; i < n; i++) {
            double a = i*da;
            double x1 = r*Math.cos(a) + x;
            double y1 = r*Math.sin(a) + y;
            double x2 = (r+l)*Math.cos(a) + x;
            double y2 = (r+l)*Math.sin(a) + y;

            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
    }

    public static void drawBalloon(Graphics2D g, int x, int y, int r, Color c1, Color c2, Color c3, Color c4, Color c5, Color c6) {
        GeneralPath path1 = new GeneralPath();
        path1.moveTo(x - Math.sqrt(3)*r/2, y - r /2f);
        path1.curveTo(x - Math.sqrt(3)*r/2, y - r/2f, x, y - r*2/3f, x + Math.sqrt(3)*r/2, y - r/2f);
        path1.curveTo(x + Math.sqrt(3)*r/2, y - r/2f, x, y - r/2f - Math.sqrt(3)*r/2, x - Math.sqrt(3)*r/2, y - r/2f);
        g.setColor(c1);
        g.fill(path1);
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(0, 0, 0, 166));
        g.draw(path1);

        GeneralPath path2 = new GeneralPath();
        path2.moveTo(x - Math.sqrt(3)*r/2, y - r/2f);
        path2.curveTo(x - Math.sqrt(3)*r/2, y - r/2f, x, y - r*2/3f, x + Math.sqrt(3)*r/2, y - r/2f);
        path2.curveTo(x + Math.sqrt(3)*r/2, y - r/2f, x + r,  y - r/2f + r - r*Math.sqrt(3)/2, x + r, y);
        path2.lineTo(x - r, y);
        path2.curveTo(x - r, y, x - r,  y - r/2f + r - r*Math.sqrt(3)/2, x - Math.sqrt(3)*r/2, y - r/2f);
        g.setColor(c2);
        g.fill(path2);
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(0, 0, 0, 166));
        g.draw(path2);

        GeneralPath path3 = new GeneralPath();
        path3.moveTo(x - r, y);
        path3.curveTo(x -r, y, x, y - r/3f, x + r, y);
        path3.curveTo(x + r, y, x + r,  y + r/2f - r + r*Math.sqrt(3)/2, x + Math.sqrt(3)*r/2, y + r/2f);
        path3.lineTo(x - Math.sqrt(3)*r/2, y + r/2f);
        path3.curveTo(x - Math.sqrt(3)*r/2, y + r/2f, x - r,  y + r/2f - r + r*Math.sqrt(3)/2, x - r, y);
        g.setColor(c3);
        g.fill(path3);
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(0, 0, 0, 166));
        g.draw(path3);

        GeneralPath path4 = new GeneralPath();
        path4.moveTo(x - Math.sqrt(3)*r/2, y + r /2f);
        path4.curveTo(x - Math.sqrt(3)*r/2, y + r /2f, x, y - r/3f + r/2f, x + Math.sqrt(3)*r/2, y + r/2f);
        path4.lineTo(x + r/3f, y + 7*r/6f);
        path4.lineTo(x - r/3f, y + 7*r/6f);
        path4.lineTo(x - Math.sqrt(3)*r/2, y + r/2f);
        g.setColor(c4);
        g.fill(path4);
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(0, 0, 0, 166));
        g.draw(path4);

        g.drawLine((int) (x - Math.sqrt(3)*r/2), (int) (y + r /2f), (int) (x - r/3f), y + 18*r/10);
        g.drawLine((int) (x + Math.sqrt(3)*r/2), (int) (y + r /2f), (int) (x + r/3f), y + 18*r/10);

        GeneralPath path5 = new GeneralPath();
        path5.moveTo(x, y - r*Math.sqrt(3)/2);
        path5.curveTo(x, y - r*Math.sqrt(3)/2, x - r/2f, y - r/2f, (int) (x - r/4f), y + 18*r/10f);
        g.draw(path5);

        GeneralPath path6 = new GeneralPath();
        path6.moveTo(x, y - r*Math.sqrt(3)/2);
        path6.curveTo(x, y - r*Math.sqrt(3)/2, x + r/2f, y - r/2f, (int) (x + r/4f), y + 18*r/10f);
        g.draw(path6);

        GeneralPath path7 = new GeneralPath();
        path7.moveTo(x, y - r*Math.sqrt(3)/2);
        path7.curveTo(x, y - r*Math.sqrt(3)/2, x + 4*r/3f, y - 2*r/3f, (int) (x + r/3f), y + 18*r/10f);
        g.draw(path7);
        path7.moveTo(x, y - r*Math.sqrt(3)/2);
        path7.curveTo(x, y - r*Math.sqrt(3)/2, x - 4*r/3f, y - 2*r/3f, (int) (x - r/3f), y + 18*r/10f);
        g.draw(path7);

        GeneralPath path8 = new GeneralPath();
        path8.moveTo((int) (x - r/3f), y + 18*r/10f);
        path8.lineTo((int) (x + r/3f), y + 18*r/10f);
        path8.lineTo((int) (x + r/3f), y + 23*r/10f);
        path8.lineTo((int) (x - r/3f), y + 23*r/10f);
        path8.lineTo((int) (x - r/3f), y + 18*r/10f);
        g.setColor(new Color(171, 145, 1));
        g.fill(path8);

        g.setColor(new Color(0, 0, 0, 166));
        g.drawLine((int) (x - r/3f), (int) (y + 37*r/20f), (int) (x + r/3f), (int) (y + 37*r/20f));
        g.drawLine((int) (x - r/3f), (int) (y + 45*r/20f), (int) (x + r/3f), (int) (y + 45*r/20f));
        g.drawLine((int) (x - r/3f + r/6f), (int) (y + 37*r/20f), (int) (x - r/3f + r/6f), (int) (y + 44*r/20f));
        g.drawLine((int) (x - r/3f + 2*r/6f), (int) (y + 37*r/20f), (int) (x - r/3f + 2*r/6f), (int) (y + 44*r/20f));
        g.drawLine((int) (x - r/3f + 3*r/6f), (int) (y + 37*r/20f), (int) (x - r/3f + 3*r/6f), (int) (y + 44*r/20f));
        for (int i = 39; i <= 43; i+=2) {
            g.drawLine((int) (x - r/3f + r/6f - r/8f), (int) (y + i*r/20f), (int) (x + r/3f - r/6f + r/8f), (int) (y + i*r/20f));
        }

        GeneralPath path10 = new GeneralPath();
        path10.moveTo((int) (x - r/4f + r/5f - r/20f), (int) (y + 18*r/10f));
        path10.lineTo((int) (x - r/4f + r/5f), (int) (y + 17*r/10f));
        path10.lineTo((int) (x + r/4f - r/5f), (int) (y + 17*r/10f));
        path10.lineTo((int) (x + r/4f - r/5f + r/20f), (int) (y + 18*r/10f));
        path10.lineTo((int)(x - r/4f + r/5f - r/20f), (int) (y + 18*r/10f));
        g.draw(path10);
        g.setColor(Color.darkGray);
        g.fill(path10);

        GeneralPath fire = new GeneralPath();
        fire.moveTo(x, (int) (y + 17*r/10f));
        fire.curveTo(x, (int) (y + 17*r/10f), x - r/4f, y + 16*r/10f, x, y + 8*r/6f);
        fire.curveTo( x, y + 8*r/6f, x, y + 15*r/10f, x + r/15f, y + 3*r/2f);
        fire.curveTo( x + r/15f, y + 3*r/2f, x + r/5f, y + 13*r/10f, x + r/8f, y + 19*r/12f);
        fire.curveTo( x + r/8f, y + 19*r/12f, x + r/10f, y + 17*r/10f, x, (int) (y + 17*r/10f));
        g.setColor(c6);
        g.setStroke(new BasicStroke(4));
        g.draw(fire);
        g.setColor(c5);
        g.fill(fire);

    }


}
