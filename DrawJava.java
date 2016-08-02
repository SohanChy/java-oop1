import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;


class WindowSensor extends WindowAdapter{
	public void windowClosing(WindowEvent we){
	System.out.println("Window closing");
	System.exit(0);
	}
}

class MyFrame extends Frame
{	
	private String msg;
	private int potakaUrX = 200, potakaUrY = 200;
	
	public MyFrame(){
		super("Drawing in Java!!");
		
		Button b = new Button("Ok");
		
		msg = "Frame is created";
		add(b);
		b.addActionListener(new ButtonSensor(this));
		
		setSize(500,500);
		setLocation(300,200);
		
		setLayout(new FlowLayout());
		
			
	}
	
	public void setMessage(String s){
		msg = s;
	}
	
	public void paint(Graphics g){
		
		
		//Flag border
		g.setColor(Color.BLACK);
		g.drawRect(99,119,201,101);
		
		
		//Flag Green BG
		g.setColor(Color.GREEN);
		g.fillRect(100,120,200,100);
		
		
		/*
		//Polygon flag
		//Pole Upper Thing
		Polygon flag = new Polygon();
		int m = 100;
		int n = 120;
		
		flag.addPoint(m , n);
		flag.addPoint(m,  n + 100);
		flag.addPoint(m+potakaUrX,  n + 100);
		flag.addPoint(m + potakaUrY,  n);
		*/

		
		/*
		flag.addPoint(m , n);
		flag.addPoint(m+200,  n + 50);
		*/
		//g.setColor(Color.GREEN);
		//g.fillPolygon(flag);
		
		
		
		//Flag red Sun
		g.setColor(Color.RED);		
		g.fillOval(167,140,60,60);
		
		//Flag Pole
		g.setColor(Color.darkGray);
		g.fillRect(80,120,20,250);
		
		
		//Pole Upper Thing
		Polygon p = new Polygon();
		int x = 90;
		int y = 120;
		
		p.addPoint(x + 10, y);
		p.addPoint(x - 10,  y);
		p.addPoint(x,  y - 10);
		g.setColor(Color.darkGray);
		g.fillPolygon(p);

		//Text
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
		g.drawString("National Flag",170,367);
		
		
		//Text
		g.setFont(new Font("TrebuchetMS", Font.PLAIN, 14));
		g.setColor(Color.BLACK);
		g.drawString(msg,20,60);
	}
	
}

class ButtonSensor implements ActionListener{
	MyFrame fm;
	static int c=0;
	
	public ButtonSensor(MyFrame f){
		fm = f;
	}
	
	public void actionPerformed(ActionEvent ae){
		System.out.println("Clicked");
		c++;
		fm.setMessage("Button Pressed: "+c);
		
		
		fm.repaint();
		
		
		
		System.out.println(c);
	}
	
}



public class DrawJava
{
	public static void main(String arg[])
	{
		MyFrame mf = new MyFrame();
		mf.addWindowListener(new WindowSensor());

                mf.setVisible(true);
		
	}
}
