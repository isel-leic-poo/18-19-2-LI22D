package edu.isel.adeetc.poo.view;

import isel.poo.console.View;

/**
 *
 */
public class MessageView extends View {

    private String message = "";

    public MessageView(int top, int left, int height, int width, int bkColor) {
        super(top, left, height, width, bkColor);
    }

    @Override
    public void paint() {
        print(0, 0, message);
    }

    public void setMessage(String message) {
        this.message = message;
        repaint();
    }
}
