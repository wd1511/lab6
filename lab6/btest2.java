package lab1;

import static org.junit.Assert.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

public class btest2 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() {
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
    	
    	String s1,s2;
    	s1="well";
    	s2="night";
    	System.out.println(g.queryBridgeWords(s1,s2));
	}

}
