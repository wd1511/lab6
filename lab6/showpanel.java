package lab1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static java.lang.StrictMath.cos;

public class showpanel extends JFrame{
  /** .
    * 
  */
  public showpanel(graph padd){
    final spanel s = new spanel(padd);
    this.add(s);
    this.setSize(1000,800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}

class spanel extends JPanel{
  public spanel(graph p){
    final Button button0 = new Button("0.exit");
    final Button button1 = new Button("1.show the graph");
    final Button button2 = new Button("2.query the bridge");
    final Button button3 = new Button("3.new text by bridges");
    final Button button4 = new Button("4.shortest route");
    final Button button5 = new Button("5.randomly walk");
    this.add(button0);
    this.add(button1);
    this.add(button2);
    this.add(button3);
    this.add(button4);
    this.add(button5);
    //dpic d=new dpic();
    //this.add(d);
    //d.setVisible(false);
    button0.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        final dpic dadd = new dpic();
        dadd.showDirectedGraph(p);
        //String choose1=JOptionPane.showInputDialog("�Ƿ�رգ�");
        //  if(choose1.equals("��")){
        //  d.close();
        //} 
      }
    });
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent eadd) {
        final String ssadd = JOptionPane.showInputDialog("input two words\n");
        final String []stmp = ssadd.split(" ");
        final String bridge = p.queryBridgeWords(stmp[0],stmp[1]);
        if (bridge == null) {
          //System.out.println("û���ŽӴʣ�");
          JOptionPane.showMessageDialog(null, "û���ŽӴʣ�");
        } else if (bridge.equals(" ")) {
          JOptionPane.showMessageDialog(null,"û��word1����word2");
          } else {
            //System.out.println(bridge);
            JOptionPane.showMessageDialog(null, "�ŽӴ�Ϊ��\n" + bridge);
            }
      }
    });
    button3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final String inputtext = JOptionPane.showInputDialog("�����ı���\n");
        final String rst = p.generateNewText(inputtext);
        JOptionPane.showMessageDialog(null,rst);
      }
    });
    button4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final dpath dadd = new dpath();
        dadd.showDirectedGraph(p);
      }
    });
    button5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final drandom dadd = new drandom();
        dadd.showDirectedGraph(p); 
      }
    });
  }
}