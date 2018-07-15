package chuanghu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    public Frame() {
        this.setSize(400, 700);
        GridLayout gridLayout = new GridLayout(5, 2);
        this.setLayout(gridLayout);
        JLabel denglu1 = new JLabel("用户名");
        JTextField field1 = new JTextField(35);
        JLabel denglu2 = new JLabel("密码");
        JTextField field2 = new JTextField(35);
        JLabel denglu3 = new JLabel("电话号码");
        JTextField field3 = new JTextField(35);
        JLabel denglu4 = new JLabel("验证码");
        JTextField field4 = new JTextField(35);


        JButton button = new JButton("查询");
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "" + field1.getText() + "," + field2.getText() + "," + field3.getText() + "," + field4.getText());
                    }
                }
        );


        this.add(denglu1);
        this.add(field1);
        this.add(denglu2);
        this.add(field2);
        this.add(denglu3);
        this.add(field3);
        this.add(denglu4);
        this.add(field4);

        this.add(button);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new Frame();


    }
}
