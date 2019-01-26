/*
FEEDBACK:

Read from the file correctly: 20/20%
Implement class hierarchy correctly: 15/20%
Populate appropriate data structures with shape data: 15/15%
Show list of shapes correctly: 15/15%
Show specific shape properties correctly: 13/15%
Well-structured, well-commented code: 13/15%


Comments:
  interfaceShape shouldn't have a constructor. Make each shape define that.
  interfaceShape shouldn't define shape-specific functions (getRadius, getArea, ...).
  remove TODO comments (circle.java)
  Triangle: calculate Perimeter before area.
*/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JList;
import javax.swing.JTextArea;

public class ShapesUI{
	
	private JFrame frame;
	private DefaultListModel listModel;
	private DefaultListModel listM;
	private JList<interfaceShape> list;
	String curdir = System.getProperty("user.dir");	
	File cd = new File(curdir);
	File[] files = cd.listFiles();
	final String end = ",";
	public List<interfaceShape> shapes = new ArrayList<>(); 
	private JTextArea txtrPlaceHolder;
	private JLabel label;
	
	//All of the variables 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapesUI window = new ShapesUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShapesUI() {
		listModel = new DefaultListModel(); //stuff to initalize the jlist on the left side of the frame
		listM = new DefaultListModel();
		readfile(); //function that opens the csv file and puts the data into the jlist
		initialize();
	}
	
	//this function reads the csv file and puts the information into the jlist
	public void readfile()
	{
		for(File f: files) {
			if(f.getName().endsWith(".csv")) {
				try(FileInputStream is = new FileInputStream(f)){
					InputStreamReader ir = new InputStreamReader(is);
					BufferedReader rdr = new BufferedReader(ir);
					String line = rdr.readLine();
					while(line!= null) 
					{
						String[] parts = line.split(",");
						if(parts[0].contains("circle"))
						{
							//if the line contains the word circle pass the information on that line into a function that creates a circle object
							makenewCircle(parts);
						}
						else if(parts[0].contains("square"))
						{
							//if the line contains the word square pass the information on that line into a function that creates a square object
							makenewSquare(parts);
						}
						else if(parts[0].contains("rectangle"))
						{
							//if the line contains the word rectangle pass the information on that line into a function that creates a rectangle object
							makenewRectangle(parts);
						}
						else if(parts[0].contains("triangle"))
						{
							//if the line contains the word triangle pass the information on that line into a function that creates a triangle object
							makenewTriangle(parts);
						}
					for(String p: parts) 
					{
						//this is more for debugging purposes, it outputs the information on each line to the console 
							System.out.printf("%s\n", p);
					}
					line = rdr.readLine();
					}
				}
				catch (Exception ex) {System.out.printf("Failed for %s\n", f.getName());}
			}
		}
	}
	
	//functions that makes a new shape objects with information that has been given to it from the csv file
	public void makenewCircle(String[] s)
	{
		String name;
		String id;
		String color;
		String holder;
		int radius;
		String holder2;
		holder2 = s[0].substring(1, s[0].length()-1); //clips the  "" off of the start and the end of the name
		name = holder2;
		id = s[1]; //sets the second part of the line equal to the id
		holder = s[2].replaceAll(" ", ""); //removes the empty space before the number 
		radius = Integer.parseInt(holder);
		color = s[3];
		Circle c =new Circle(name, id, radius, color);
		shapes.add(c);
		listModel.addElement(c);	//adds the object to the Jlist
	}
	public void makenewSquare(String[] s)
	{
		String name;
		String id;
		String color;
		String holder;
		int side;
		String holder2;
		holder2 = s[0].substring(1, s[0].length()-1);
		name = holder2;
		id = s[1];
		holder = s[2].replaceAll(" ", "");
		side = Integer.parseInt(holder);
		color = s[3];
		Square c =new Square(name, id, side, color);
		shapes.add(c);
		listModel.addElement(c);	
	}
	public void makenewRectangle(String[] s)
	{
		String name;
		String id;
		String color;
		String holder;
		int base;
		int height;
		String holder2;
		
		holder2 = s[0].substring(1, s[0].length()-1);
		name = holder2;
		
		id = s[1];
		
		holder = s[2].replaceAll(" ", "");
		base = Integer.parseInt(holder);
	
		System.out.printf("%d", base);
		
		holder = s[3].replaceAll(" ", "");
		height = Integer.parseInt(holder);
		
		System.out.printf("%d", height);
		color = s[4];
		
		Rectangle c = new Rectangle(name, id, base, height, color);
		shapes.add(c);
		listModel.addElement(c);	
	}
	public void makenewTriangle(String[] s)
	{
		String name;
		String id;
		String color;
		String holder;
		int side1;
		int side2;
		int side3;
		String holder2;
		
		holder2 = s[0].substring(1, s[0].length()-1);
		name = holder2;
		
		id = s[1];
		
		holder = s[2].replaceAll(" ", "");
		side1 = Integer.parseInt(holder);
		
		holder = s[3].replaceAll(" ", "");
		side2 = Integer.parseInt(holder);
		
		holder = s[4].replaceAll(" ", "");
		side3 = Integer.parseInt(holder);
		
		color = s[5];
		
		Triangle c = new Triangle(name, id, side1, side2, side3, color);
		shapes.add(c);
		listModel.addElement(c);	
	}
		
	//functions that display the images of each shape
	public void showCircle()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resources/circle.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); //set the size of the image
		ImageIcon icon = new ImageIcon(img);
		label = new JLabel(icon);	
		frame.getContentPane().add(label);
		
		}
	public void showSquare()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resources/square.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		label = new JLabel(icon);		
		frame.getContentPane().add(label);
	
		}
	public void showrectangle()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resources/rectangle.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		label = new JLabel(icon);		
		frame.getContentPane().add(label);
	
		}
	public void showtriangle()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL imgURL = getClass().getResource("/resources/triangle.png");
		Image img = toolkit.getImage(imgURL);
		img = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		label = new JLabel(icon);
		frame.getContentPane().add(label);	
		
		}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//this is here because if it isn't here the program doesn't work
		showCircle();
		
		list = new JList(listModel);
		//a mouse listener for the Jlist so that if someone double clicks on a object it will go to check what kind of shape the user clicked on
		MouseListener mlist = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() ==2) {
				interfaceShape selected = list.getSelectedValue();
				System.out.printf("%s\n" ,selected.toString());
				//checks to see what shape the user picked
				if(selected.getKind().contains("circle"))
				{
					frame.remove(label); //removes the current shape from the screen
					showCircle(); //puts the correct shape on the screen
					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();
					txtrPlaceHolder.setText(selected.getDetailedString()); //outputs all of the information about the shape on the textfield on the right
				}
				else if(selected.getKind().contains("square"))
				{
					frame.remove(label);
					showSquare();
					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();
					txtrPlaceHolder.setText(selected.getDetailedString());
					
				}
				else if(selected.getKind().contains("rectangle"))
				{
					frame.remove(label);
					showrectangle();
					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();
					txtrPlaceHolder.setText(selected.getDetailedString());
				}
				else if(selected.getKind().contains("triangle"))
				{
					frame.remove(label);
					showtriangle();
					frame.getContentPane().revalidate();
					frame.getContentPane().repaint();
					txtrPlaceHolder.setText(selected.getDetailedString());
				}
			}
		}};
		list.addMouseListener(mlist);
		
		JScrollPane ScrollPane = new JScrollPane(list);//adding a scroll pane 
		frame.getContentPane().add(ScrollPane, BorderLayout.WEST);
		
		txtrPlaceHolder = new JTextArea();
		frame.getContentPane().add(txtrPlaceHolder, BorderLayout.EAST);
	}

}
