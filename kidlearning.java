import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
class kidlearning extends JFrame implements ActionListener
{
	JButton bt1;
	JLabel bl1,bl2,bl3;
	JPanel bpl1;
	JTextField bta1;
	String s="H://aswe123",f;
	int flag=0;
	ImageIcon ic1;
	kidlearning()
	{
		initComponents();
		setSize(400,400);
		setTitle("welcome to kidlearning");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	void initComponents()
	{
		ic1=new ImageIcon("H://aswe123/asd.png");
		bt1=new JButton("spelling check");
		bl1=new JLabel("write something: ");
		bl2=new JLabel(ic1);
		bl3=new JLabel("please write correct spelling");
		bpl1=new JPanel(new FlowLayout());
		bta1=new JTextField(10);
		//bpl1.SetHorizontalAlingment();
		
		
		bpl1.add(bl1);
		bpl1.add(bta1);
		bpl1.add(bl3);
		setLayout(new BorderLayout());
		add(bpl1,BorderLayout.CENTER);
		add(bl2,BorderLayout.NORTH);
		add(bt1,BorderLayout.SOUTH);
		
		bt1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String b="";
		b=bta1.getText();
		flag=0;
		foundthefile(s,b);
		if(flag==1)
		{
			bl2.setIcon(new ImageIcon(f));
			bl3.setText("correct spelling");
		}
		else
		{
			bl3.setText("incorrect spelling");
		}
		s="H://aswe123";
	}
	void foundthefile(String s,String s1)
	{
		File directory=new File(s);
		File[] file=directory.listFiles();
		for(File l1:file)
		{
			if(flag==1)
			return;
			if(l1.isFile())
			{
				String s2=l1.getName();
				int pos=s2.lastIndexOf('.');
				s2=s2.substring(0,pos);
				if(s2.equals(s1))
				{
					flag=1;
					f=l1.getAbsolutePath();
					return;
				}
			}
			else if(l1.isDirectory())
			{
				foundthefile(l1.getAbsolutePath(),s1);
			}
		}
	}
	public static void main(String arg[])
	{
		kidlearning kd=new kidlearning();
	}
}