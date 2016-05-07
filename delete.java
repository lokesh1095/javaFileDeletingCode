/*

Name:  Lokesh Sharma (C|EH)

Twitter:   @lokesh1095
Github:	    lokesh1095
facebook:   https://web.facebook.com/theshadowclan2015
LinkedIn:   https://in.linkedin.com/in/lokesh-sharma-28322878

about code: This code takes a path from user and deletes all files inside that path.
	    suppose you gave path "D:/xyz"  then it will delete all file in "D:/xyz" 
	    plus it will go through all the paths inside "D:/xyz" 
            i.e. it will go through all the folders inside that path. 
            No matter how many folders are there and no matter how many folders are inside those folders. 
            This program will go through all of them and delete all the files it find permanently. 
            So be careful!!

*/



import java.io.*;
import java.awt.*;
import java.awt.event.*;
class delete extends Frame implements ActionListener
{
	int i99=0;
	String s9[];
	File fiiii;
	TextField t;
	Button b1;
	TextArea ta;

	delete()
	{

		setSize(700,700);
		setTitle("File Deleter By : Lokesh"+"\t"+"Follow: @lokesh1095");
		setLayout(null);
		t=new TextField(100);
		t.setBounds(50,50,600,50);
		b1=new Button("delete");
		b1.setBounds(280,130,60,40);
		b1.addActionListener(this);
		ta=new TextArea();
		ta.setBounds(50,190,600,500);
		add(t);
		add(b1);
		add(ta);
		setVisible(true);
	}
	public static void main(String...s)
	{
		new delete();

	}
	File dir(File fi)
	{
		try{

		File s1[]=fi.listFiles();
		for(int i=0;i<s1.length;i++)
		{
			boolean b=false;
			if(s1[i].isFile())
			{
				b=s1[i].delete();
			}
			if(b)
			{
				ta.append("\n file "+s1[i].getName()+" at path"+s1[i].getPath()+" deleted");
				Thread.sleep(1000);
			}
		}
		String s2[]=fi.list();
		if(s2.length==0)
		{
			if(fi.equals(fiiii))
			{
				return(fi);
			}
			else
			{
				s9[i99]=fi.getPath();
				i99++;
				String s88=fi.getParent();
				System.out.println(s88);
				dir(new File(s88));
			}
		}
		else
		{
			for(int i=0;i<s2.length;i++)
			{
				boolean bb2=false;
				String s44=fi.getPath();
				s44=s44+"\\"+s2[i];
				File fii=new File(s44);
				for(int iii=0;iii<i99;iii++)
				{
					if((s44.compareTo(s9[iii]))==0)
					{
						bb2=true;
					}
				}
				if(bb2)
				{
					continue;
				}
				ta.append("\n Currently at " +fii.getPath()+" on File or Directory "+fii.getName());
				Thread.sleep(1000);
				dir(fii);
			}
		}
  	  }
  	  catch(Exception e)
  	  {
	  }
	  return(fiiii);
	}
	public void actionPerformed(ActionEvent a)
	{
		Object o=a.getSource();
		if(o==b1)
		{
		  try{
			String ss=t.getText();
			File f=new File(ss);
			fiiii=f;
			ta.append("\n Currently on File or Directory "+f.getName());
			Thread.sleep(1000);
			if(f.exists()==true)
			{
				if(f.isDirectory())
				{
					File ft=dir(f);
				}
				if(f.isFile())
				{
					boolean b=f.delete();
					if(b)
						ta.append("\n file "+f.getName()+" at path"+f.getPath()+" deleted");
						Thread.sleep(1000);
				}


			}
			else
			{
				ta.append("\n No file or directory exists on this path");
			}
		  }
		  catch(Exception e){}
		}
	}
}
