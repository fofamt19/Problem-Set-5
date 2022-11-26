import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton bEasy;
    private JButton bMedium;
    private JButton bHard;

    public Menu(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        bEasy=new JButton("Easy");
        panel.add(Box.createHorizontalGlue());
        panel.add(bEasy);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        //bEasy.setBounds(50,100,95,30);
//        f.add(bEasy);
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);
           bEasy.addActionListener(e -> buttonAction(0));



        bMedium =new JButton("Medium");
        panel.add(bMedium);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
//        f.add(bMedium);
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);
//        bMedium.addActionListener(click);
        bMedium.addActionListener(e -> buttonAction(1));
        bHard =new JButton("Hard");
        panel.add(bHard);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
//        f.add(bHard);
//        f.setSize(400,400);
//        f.setLayout(null);
//        f.setVisible(true);
//        bHard.addActionListener(click);
        bHard.addActionListener(e -> buttonAction(2));
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
    public void buttonAction(int level){
        System.out.println("A button was pressed");
        MainClass.level = level;
        setVisible(false);
        dispose();
        Tennis game = new Tennis(level);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

