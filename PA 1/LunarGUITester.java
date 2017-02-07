package century.edu.pa1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LunarGUITester extends JFrame implements ActionListener, Runnable 
{
	private JPanel main, moon;
	private JButton start;
	private Image moonImage = new ImageIcon("LunarLanding.jpg").getImage();
	private Image spaceShipImage = new ImageIcon("spaceship.jpg").getImage();
	
	private final static int MOON_WIDTH = 1080;
	private final static int MOON_HEIGHTH = 810;
	private final static int SPACESHIP_HEIGHT = 72;
	private final static int SPACESHIP_WIDTH = 72;
	private final static int LANDING_SURFACE = 222;
	public LunarGUITester(String title)
	{
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(MOON_WIDTH,MOON_HEIGHTH);
		initGuiComponents();
	}
	
	private void initGuiComponents()
	{
		main = new JPanel(new BorderLayout());
		moon = new JPanel();
		start = new JButton("Start");
		start.addActionListener(this);
		main.add(moon, BorderLayout.CENTER);
		main.add(start, BorderLayout.SOUTH);
		add(main);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		LunarGUITester test1 = new LunarGUITester("test1");
		test1.setVisible(true);
	}
}
