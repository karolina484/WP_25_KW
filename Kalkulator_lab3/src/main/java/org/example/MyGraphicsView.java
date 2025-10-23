package org.example;

import javax.swing.*;
import java.awt.*;

public class MyGraphicsView extends JPanel implements IView {

    private String text = "0";

    @Override
    public void setText(String data) {
        this.text = data == null ? "0" : data;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Font font = new Font("Monospaced", Font.BOLD, 30);
        g.setFont(font);

        String formatted = Formatter.formatForDisplay(text);

        FontMetrics fm = g.getFontMetrics();

        int totalW = fm.stringWidth(formatted);
        int x = getWidth() - totalW - 10;
        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

        if ("BŁĄD".equals(formatted)) {
            g.setColor(Color.RED);
            g.drawString(formatted, x, y);
            return;
        }

        int dotIdx = formatted.indexOf('.');
        String beforeDot = formatted.substring(0, dotIdx);
        String dot = formatted.substring(dotIdx, dotIdx + 1);
        String afterDot = formatted.substring(dotIdx + 1);

        int curX = x;

        g.setColor(Color.MAGENTA);
        g.drawString(beforeDot, curX, y);
        curX += fm.stringWidth(beforeDot);

        g.setColor(Color.BLACK);
        g.drawString(dot, curX, y);
        curX += fm.stringWidth(dot);

        g.setColor(Color.CYAN);
        g.drawString(afterDot, curX, y);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 50);
    }

}