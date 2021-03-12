package com.mathboy11.imagedetails;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String arg1 = args[0];
        File file = new File(arg1);
        BufferedImage bimg = ImageIO.read(new File(arg1));
        int width = bimg.getWidth();
        int height = bimg.getHeight();
        JFrame frame = new JFrame("Image Details");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label1 = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(arg1).getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
        label1.setIcon(imageIcon);
        JLabel title = new JLabel("Image Name: " + file.getName());
        JLabel label2 = new JLabel("Image Path: " + file.getAbsolutePath());
        JLabel label3 = new JLabel("Image Type: " + getFileExtension(file));
        JLabel label4 = new JLabel("Image Width:" + width + "px");
        JLabel label5 = new JLabel("Image Height:" + height + "px");
        panel.add(label1);
        panel.add(title);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        frame.add(panel);
        frame.setSize(510, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
