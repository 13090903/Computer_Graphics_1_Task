package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawPanel extends JPanel {
    private static Color SKY_COLOR = new Color(16, 13, 54, 255);
    private static final Color GROUND_COLOR = new Color(0, 87, 12);
    private static final Color TREE_COLOR = new Color(0, 49, 3);
    private static final Color WALLS_COLOR = new Color(114, 133, 47);
    private static final Color ROOF_COLOR = new Color(30, 30, 14);
    private static final Color WINDOW_COLOR = new Color(44, 44, 1);
    private static Color LIGHT_COLOR = new Color(255, 255, 0);


    private static final Random rnd = new Random();

    private Star[] stars = new Star[15 + rnd.nextInt(25)];
    private Moon moon;
    private Tree[] trees = new Tree[9];
    private House house;
    private Sun sun;
    private Balloon balloon;
    private Timer t;


    public DrawPanel() {
        super(true);

        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(130 + rnd.nextInt(700), 30 + rnd.nextInt(230), 1 + rnd.nextInt(2), new Color(255 - rnd.nextInt(40), 255 - rnd.nextInt(40), 255, 255));
        }
        sun = new Sun(-800, 80, 30, 30, 12, new Color(255, 128, 0, 255));
        moon = new Moon(80, 80, 30 + rnd.nextInt(20), new Color(255, 255, 255, 255));
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree(500 + i * 30, 450 - 50 + rnd.nextInt(100), TREE_COLOR);
        }
        house = new House(50, 360, 100, WALLS_COLOR, ROOF_COLOR, WINDOW_COLOR, LIGHT_COLOR);
        balloon = new Balloon(325, 285, 100, Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED);
        t = new Timer(20, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moon.setX(moon.getX() + 1);
                sun.setX(sun.getX() + 1);
                if (sun.getX() < 270 && sun.getX() > -80) {
                    if (sun.getX() < 200) {
                        balloon.setY(balloon.getY() - 1);
                    } else {
                        if (sun.getX() % 2 == 0) {
                            balloon.setY(balloon.getY() - 1);
                        }
                    }
                }
                if (balloon.getY() == 285) {
                    balloon.setC6(new Color(balloon.getC6().getRed(), balloon.getC6().getGreen(), balloon.getC6().getBlue(), 0));
                    balloon.setC5(new Color(balloon.getC5().getRed(), balloon.getC5().getGreen(), balloon.getC5().getBlue(), 0));
                }
                if (balloon.getY() == 284) {
                    balloon.setC6(new Color(balloon.getC6().getRed(), balloon.getC6().getGreen(), balloon.getC6().getBlue(), 255));
                    balloon.setC5(new Color(balloon.getC5().getRed(), balloon.getC5().getGreen(), balloon.getC5().getBlue(), 255));
                }
                if (sun.getX() > 350 || sun.getX() < - 80) {
                    if (balloon.getY() < 285) {
                        balloon.setY(balloon.getY() + 1);
                    }
                }
                if (moon.getC().getAlpha() > 0 && moon.getX() >= 560) {
                    moon.setC(new Color(moon.getC().getRed(), moon.getC().getGreen(), moon.getC().getBlue(), moon.getC().getAlpha() - 1));
                }
                if (SKY_COLOR.getAlpha() > 0 && moon.getX() >= 560) {
                    SKY_COLOR = new Color(SKY_COLOR.getRed(), SKY_COLOR.getGreen(), SKY_COLOR.getBlue(), SKY_COLOR.getAlpha() - 1);
                }
                for (int i = 0; i < stars.length; i++) {
                    stars[i].setX(stars[i].getX() + 1);
                    if (stars[i].getC().getAlpha() > 0 && moon.getX() >= 560) {
                        stars[i].setC(new Color(stars[i].getC().getRed(), stars[i].getC().getGreen(), stars[i].getC().getBlue(), stars[i].getC().getAlpha() - 1));
                    }
                    if (stars[i].getX() > getWidth() + stars[i].getSize()) {
                        stars[i].setX(-stars[i].getSize());
                        stars[i].setY(stars[i].getY() + 80 - rnd.nextInt(160));
                    }
                    if (stars[i].getY() > 350) {
                        stars[i].setY(50 + rnd.nextInt(200));
                    }
                }
                if (moon.getX() == 720) {
                    sun.setX(-80);
                    house.setLightColor(Color.LIGHT_GRAY);
                }
                if (sun.getX() == 700) {
                    moon.setX(-100);
                    house.setLightColor(Color.YELLOW);
                }
                if (sun.getX() > 550 && moon.getC().getAlpha() < 255) {
                    moon.setC(new Color(moon.getC().getRed(), moon.getC().getGreen(), moon.getC().getBlue(), moon.getC().getAlpha() + 1));
                    SKY_COLOR = new Color(SKY_COLOR.getRed(), SKY_COLOR.getGreen(), SKY_COLOR.getBlue(), SKY_COLOR.getAlpha() + 1);
                    for (int i = 0; i < stars.length; i++) {
                        stars[i].setC(new Color(stars[i].getC().getRed(), stars[i].getC().getGreen(), stars[i].getC().getBlue(), stars[i].getC().getAlpha() + 1));
                    }
                }
                repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t.isRunning()) {
                    t.stop();
                } else {
                    t.start();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        sun.draw(g2d);
        g2d.setColor(SKY_COLOR);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(GROUND_COLOR);
        g2d.fillOval(0, 370, 800, 400);
        g2d.fillOval(-50, 430, 200, 267);
        g2d.fillOval(800 - 200, 400, 267, 200);
//        g.setColor(new Color(0, 114, 7, 255));
//        g2d.setStroke(new BasicStroke(2));
//        for (int j = 0; j < (int) (getHeight() - getHeight() / 1.25 - 20); j+=20) {
//            for (int i = 0; i < getWidth(); i++) {
//                int[] x = {i, 2 + i, 4 + i};
//                int[] y = {getHeight() - j, getHeight() - 10 - j, getHeight() - j};
//                g.drawPolygon(x, y, 3);
//            }
//        }
//        for (int j = (int) (getHeight() - getHeight() / 1.25 - 20); j < (int) (getHeight() - getHeight() / 1.45 - 40); j+=20) {
//            for (int i = getWidth() / 4; i < getWidth(); i++) {
//                int[] x = {i, 2 + i, 4 + i};
//                int[] y = {getHeight() - j, getHeight() - 10 - j, getHeight() - j};
//                g.drawPolygon(x, y, 3);
//            }
//        }

        for (int i = 0; i < stars.length; i++) {
            stars[i].draw(g2d);
        }
        moon.draw(g2d);

        for (int i = 0; i < trees.length; i++) {
            trees[i].draw(g2d);
        }

        house.draw(g2d);
        balloon.draw(g2d);
    }
}
