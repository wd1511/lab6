package lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import java.io.*;
public class wtest0 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShowDirectedGraph() {
    	String file_name=JOptionPane.showInputDialog("input the file location:");
	
    	String s="";
    	int i=0;
    	
    	try
        {
          FileInputStream f=new FileInputStream(file_name);
          int b=f.read();
          int flag=0;
          for(i=0;b!=-1;i++)
          {
        	char tmp=(char)b;
            if((tmp>='a' && tmp<='z')|| (tmp>='A' && tmp<='Z')){s=s+tmp;flag=0;}
            else if((tmp==' ' || tmp=='\r' || tmp=='\n' || tmp==',' || tmp=='.' || tmp=='?' || tmp=='!' || tmp=='\'' || tmp=='\"' || tmp==';' || tmp==':') &&(flag==0)){s=s+" ";flag=1;}
            else s=s;
            b=f.read();
          }
          f.close();
        }
        catch(IOException e)
        { 
          System.err.println("错误为"+e);
          e.printStackTrace();
        }
    	
    	s=s.toLowerCase();
    	System.out.println(s);
    	String []a=s.split(" ");
        graph g=new graph();
     for(int j=0;j<a.length;j++)g.add_node(a[j]);
     for(int j=0;j<a.length-1;j++)g.add_edge(a[j],a[j+1]);
     
    	dpath p=new dpath();
    	p.showDirectedGraph(g);
    }
}
