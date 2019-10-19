package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyChat extends JFrame {
    public MyChat(){

        setTitle("Окно чата");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(450, 100, 300, 400);



        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setPreferredSize(new Dimension(400,300));
        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        container.add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField text = new JTextField(25);
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(text.getText().equals("")){
                    JOptionPane.showMessageDialog(panel,"Введите сообщение");
                }else {

                    area.append(text.getText() + "\n");
                    text.setText("");}
            }
        });
        JButton button = new JButton("ОТПРАВИТЬ");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(text.getText().equals("")){
                   JOptionPane.showMessageDialog(panel,"Введите сообщение");
               }else {

                area.append(text.getText() + "\n");
                text.setText("");}
            }
        });
        panel.add(text);
        panel.add(button);
        container.add(panel, BorderLayout.SOUTH);
        pack();
        setVisible(true);

        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mClear = new JMenuItem("Clear");
        mClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(null);
            }
        });
        JMenuItem mExit = new JMenuItem("Exit");
        mExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mFile.add(mClear);
        mFile.add(mExit);
    }

    public static void main(String[] args) {
        new MyChat();
    }
}
