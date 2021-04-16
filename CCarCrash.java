package assignmentCSY1020A2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*------------------------------------------------------------------------
 * 
 * Program  :  Assignment 2: Car Race Application 
 * Filename :  CCarCrash.java 
 * @author  : ©Poorvaja SathaSivam (19401412) 
 * @course  : BSC Computing Year 1 
 * Module   :  CSY1020 Problem Solving and Programming 
 * Tutor       :  Mr.Gary Hill 
 * @version : 2.0 Incorporates Artificial Intelligence! 
 * 
 -------------------------------------------------------------------------*/
public class CCarCrash extends JFrame implements ActionListener,ChangeListener
{

	private static final long serialVersionUID = 1L;
	//It is used during deserialization to verify that the sender ( the person who serializes) and receiver 
	//(the person who deserializes) of a serialized object have loaded classes for that object 
	//that are compatible with respect to serialization.
	//WINDOW
	private Container window ;
	
    //MENU BAR
	private JMenuBar jMenuBar ;
	private JMenu scenarioMenu,editMenu,controlMenu,helpMenu ;
	private JMenuItem exitItem,aboutItem, option1Item, option2Item, option3Item, runItem, actItem, resetItem;
	
	//JPANELS
	private JPanel jPCenter, jPSide, jPBottom;
	private JPanel jPTopOptionsConstructor,jPControlOptions,jPBlankSpotSide, jPOptionButtons, jPCompassFeature,jPDigitalTimer ;
	private JPanel jPBlankSpotBottomL, jPBlankSpotBottomC,jPBottomButtons,jPSlider ;
   
    //JLABELS 
	private JLabel jLOption, jLSquare, jLDirection,jLSlider,jLTimer,jLlabel1, jLlabel2  ;
    
    //JTEXTFIELDS 
	private JTextField jTOption, jTSquare, jTDirection,jTHour, jTMins, jTSeconds ;
    
    //JTOGGLEBUTTONS
	private JToggleButton nullButton1,nullButton2,nullButton3,nullButton4,nullButton5;

  	//JBUTTONS
	private JButton jBUp,jBDown,jBLeft,jBRight;
	private JButton jBOption1,jBOption2,jBOption3,jBExit;
	private JButton jBCompass;
	private JButton jBAct,jBRun,jBReset;
	private JButton jBGrid[] = new JButton[208];
 
  	//IMAGE ICONS 
  	private ImageIcon imgAct = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("step.png"))) ;
  	private ImageIcon imgRun = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("run.png"))) ;
  	private ImageIcon imgPause= new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("pause.png"))) ;
  	private ImageIcon imgReset= new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("reset.png"))) ; 	
  	private ImageIcon imgCarN = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("car-n.png"))) ;
  	private ImageIcon imgCarE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("car-e.png"))) ;
  	private ImageIcon imgCarS = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("car-s.png"))) ;
  	private ImageIcon imgCarW = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("car-w.png"))) ;
  	private ImageIcon imgSpace = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("space.png"))) ;
  	private ImageIcon imgWallH = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("wall-horiz.png"))) ;
  	private ImageIcon imgWallNE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("wall-NE.png"))) ;
  	private ImageIcon imgWallNW = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("wall-NW.png"))) ;
  	private ImageIcon imgWallSE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("wall-SE.png"))) ;
  	private ImageIcon imgWallSW = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("wall-SW.png"))) ;
  	private ImageIcon imgWallV = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("wall-vert.png"))) ;
  	private ImageIcon imgCompassN = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("north.jpg"))) ;
  	private ImageIcon imgCompassS = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("south.jpg"))) ;
  	private ImageIcon imgCompassE = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("east.jpg"))) ;
  	private ImageIcon imgCompassW = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("west.jpg"))) ;
  	private ImageIcon imgPerson = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("person.png"))) ;
  	private ImageIcon imgSandS = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("sandstone.jpg"))) ;
  	
  	//ImageIcon imgGreenfoot = new ImageIcon(Toolkit.getDefaultToolkit().getImage(CCarCrash.class.getResource("greenfoot.png");
  	
  	//JSLIDER 
  	private JSlider jSFramesPerSecond;	
  	
    //FRAMES PER SECOND
  	private static int nMinSec = 0;
  	private static int nMaxSec = 1500;
  	private static int nInitSec = 1000;
  	
  	//TIMER 
  	boolean started = false ; 
  	private int ticks = 0 ;
  	private Timer timer ;

  	
   //DECALRING VARIABLES 
  	private int nSquare ;
  	private int nOption = 4 ;

    //TIMER DEFENDANT VARIABLES
  	private Timer timerOption1 = new Timer(nInitSec, this);
  	private Timer timerOption2 = new Timer(nInitSec, this);
  	private Timer timerOption3 = new Timer(nInitSec, this);
  	private Timer timerPerson = new Timer(nInitSec, this);
  	
  	private int nStep = 0;   //for incrementing the car 
  	private int nPerson = 0; //for incrementing the person
  	
  	private int carCurrentPosition = 17 ; // current position of the car in option 1 and 2 
  	private int bCurrentPosition = 30;    // current position of the car for option 3
  	private int pCurrentPosition = 126;   // current position of the person 
  	 
  	//POSITIONS OF THE WALL
  	private int wallNW = 0;
  	private int wallNE = 15;
  	private int wallSE= 192;
  	private int wallSW = 207;
  	private int wallNW1 = 34;
  	private int wallNE1 = 45;
  	private int wallSW1 = 162;
  	private int wallSE1 = 173;

  	 

	//---------------------MAIN METHOD------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		CCarCrash frame = new CCarCrash();      
		frame.setSize(810,650);                                         //sets the size of window 
		frame.createGUI();                                              //calls the GUI method
		frame.setLocationRelativeTo(null);                              //the window is placed on the centre of the screen
     	frame.setResizable(false);                                      //the window is not re-sizable hence the boolean value is false 
		frame.setTitle("CCarCrash - Car Race Application");             //sets the title of the window
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage(CCarCrash.class.getResource("greenfoot.jpg"))); //sets Java dock and title image
		frame.setVisible(true);
		
		//System.setProperty("apple.laf.useScreenMenuBar","true");      //this allows the title to appear on the menu bar of the system in apple
	}
	
	//----------------------CREATEGUI() METHOD----------------------------------------------------------------------------------
	public void createGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		window = getContentPane();
		window.setLayout(new BorderLayout());                           //A border layout lays out a container, arranging and resizing its components to fit.
		setTitle("CCarCrash - Car Race Application");
		window.setFocusable(true);                                      //Sets the focusable state of this Component to the specified value.
		
		menuBar() ;                                                     //Calling menu bar function
				
		Centre();                                                       //This function contains the centre panel 
		Side();                                                         //This function contains the side panel
		Bottom();                                                       //This function contains the bottom panel
		
		//creating a timer function 
		timer = new Timer(1000,new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int seconds = ticks%60;
				int minutes = (ticks / 60) % 60;
				int hours = ticks / 3600;
				
				//Displaying counter
				jTHour.setText(hours + "");
				jTMins.setText(minutes + "");
				jTSeconds.setText(seconds + "");

				//Counting.
				ticks++;
			} 
			
		});
	}

			
	//-----------------------CREATING A MENU BAR---------------------------------------------------------------------------------
	public void menuBar()
	{
		jMenuBar = new JMenuBar();
		
		setJMenuBar(jMenuBar);                                             
		
		//SCENARIO 
		scenarioMenu = new JMenu("Scenario");                             //creates the menu 
		exitItem = new JMenuItem("Exit");                                 //creates the menu item
		scenarioMenu.add(exitItem);                                       //adds the menu item
		exitItem.addActionListener(this);                                 //addActionListener method takes the current class object as a parameter.
		
		jMenuBar.add(scenarioMenu);
		
		//EDIT 
		editMenu = new JMenu("Edit");
		option1Item = new JMenuItem("Option 1");
		option2Item = new JMenuItem("Option 2");
		option3Item = new JMenuItem("Option 3");
		editMenu.add(option1Item);
		editMenu.add(option2Item);
		editMenu.add(option3Item);
		option1Item.addActionListener(this);                               //addActionListener method takes the current class object as a parameter.
		option2Item.addActionListener(this);
		option3Item.addActionListener(this);

		jMenuBar.add(editMenu);
		
		//CONTROLS 
		controlMenu = new JMenu("Controls");
		actItem = new JMenuItem("Act");
		runItem = new JMenuItem("Run");
		resetItem = new JMenuItem("Reset");
		controlMenu.add(actItem);
		controlMenu.add(runItem);
		controlMenu.add(resetItem);
		actItem.addActionListener(this);
		runItem.addActionListener(this);
		resetItem.addActionListener(this);
		jMenuBar.add(controlMenu);
		
		//HELP 
		helpMenu = new JMenu("Help");
		aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		aboutItem.addActionListener(this);
		
		jMenuBar.add(helpMenu);
	}
	

	public void Centre()
	
	{
 
		jPCenter = new JPanel() ;                                                            // creates the panel for the game 
		jPCenter.setPreferredSize(new Dimension(620,545));                                   // sets the dimension for the game 
		jPCenter.setLayout(new GridLayout(13,16));                                           // class is a layout manager that lays out a container's components in a rectangular grid. The container is divided into equal-sized rectangles, and one component is placed in each rectangle
		jPCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));                
		window.add(jPCenter,BorderLayout.WEST);                                              //using a border layout to fix the panel in the west i.e, (left) 


		for(int i = 0; i<208 ; i++)                                                          // creating a for loop for the buttons since 13 x 16 = 208 
		{
			jBGrid[i] = new JButton();
			jPCenter.add(jBGrid[i]);
			jBGrid[i].setMargin(new Insets(0,0,0,0));                                         //Creates and initialises a new Insets object with the specified top, left, bottom, and right insets.
			jBGrid[i].setIcon(imgSpace);
//			jBGrid[i].setText(""+i);
			jBGrid[i].setFocusable(false);
		    jBGrid[i].setBorder(null);
			
			
		}
		//------------OUTER WALL------------------
		// placing the images for the outer wall
		int wallNW = 0;
		jBGrid[wallNW].setIcon(imgWallNW);
		int wallNE = 15 ;
		jBGrid[wallNE].setIcon(imgWallNE);
		int wallSW = 192 ;
		jBGrid[wallSW].setIcon(imgWallSW);
		int wallSE = 207;
		jBGrid[wallSE].setIcon(imgWallSE);
		
		
		for(int wallH =1 ; wallH <=14; wallH ++)
		{
			jBGrid[wallH].setIcon(imgWallH);
		}
		for(int wallV=16; wallV<191 ;wallV+=16)
		{
			jBGrid[wallV].setIcon(imgWallV);
		}
		
		for(int wallV = 31 ; wallV <207; wallV+=16)
		{
			jBGrid[wallV].setIcon(imgWallV);
		}	
		for(int wallH = 193 ; wallH<=206 ;wallH++)
		{
			jBGrid[wallH].setIcon(imgWallH);
		}
		//--------------------INNER WALL--------------------
		//placing the images for the inner wall 
		int wallNW1 = 34 ;
		jBGrid[wallNW1].setIcon(imgWallNW);
		int wallNE1 = 45 ;
		jBGrid[wallNE1].setIcon(imgWallNE);
		int wallSW1 = 162 ;
		jBGrid[wallSW1].setIcon(imgWallSW);
		int wallSE1 = 173;
		jBGrid[wallSE1].setIcon(imgWallSE);
		

		
		for(int inz =35 ; inz<=44; inz++)
		{
			jBGrid[inz].setIcon(imgWallH);
		}
		for(int ina = 50; ina<157; ina+=16)
		{
			jBGrid[ina].setIcon(imgWallV);
		}		
		for(int ind = 61; ind<173;ind+=16)
		{
			jBGrid[ind].setIcon(imgWallV);
		}		
		for(int ine = 163; ine<=172;ine++)
		{
			jBGrid[ine].setIcon(imgWallH);
		}	
		
		//adding the car's current position
	  int carPosition = 17 ; 
	  jBGrid[carPosition].setIcon(imgCarE);

	}
	//-----------------------------SIDE PANEL-------------------------------------------------------------------------------------
	public void Side()
	{
		//SIDE PANEL SETTINGS 
		jPSide = new JPanel();
		jPSide.setPreferredSize(new Dimension(190,545)) ;
		window.add(jPSide,BorderLayout.EAST);
		jPSide.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	
		//TOP OPTIONS PANEL SETTINGS 
		jPTopOptionsConstructor = new JPanel();
		jPTopOptionsConstructor.setPreferredSize(new Dimension(180,80));
		jPTopOptionsConstructor.setLayout(new GridLayout(3,2) );
		
		//DECLARE LABELS 
		jLOption = new JLabel("Option:");
		jLSquare = new JLabel("Square:");
		jLDirection = new JLabel("Direction:");
		
		//DECLARE TEXT FIELDS 
		jTOption = new JTextField("Default");
		jTOption.setEditable(false);	
		jTOption.setHorizontalAlignment(JTextField.CENTER);
		jTOption.setBackground(Color.WHITE);
				
		jTSquare = new JTextField();
		jTSquare.setEditable(false);
		jTSquare.setHorizontalAlignment(JTextField.CENTER);
		jTSquare.setBackground(Color.WHITE);
		int nSquare = 0;
		jTSquare.setText(""+nSquare);
				
		jTDirection = new JTextField();
		jTDirection.setEditable(false);
		jTDirection.setHorizontalAlignment(JTextField.CENTER);
		jTDirection.setBackground(Color.WHITE);
		String sDirection = null;
		jTDirection.setText(""+sDirection);
		
		//CONTROL PANEL SETTINGS 
		jPControlOptions = new JPanel();
		jPControlOptions.setPreferredSize(new Dimension(180,120));
		jPControlOptions.setLayout(new GridLayout(3,3));
		
		//DISABLE BUTTON AND SET PRESS STATE 
		nullButton1 = new JToggleButton();
		nullButton1.setEnabled(false);
		nullButton1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				
		nullButton2 = new JToggleButton();
	    nullButton2.setEnabled(false);
		nullButton2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				
		nullButton3 = new JToggleButton();
		nullButton3.setEnabled(false);
		nullButton3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				
		nullButton4 = new JToggleButton();
		nullButton4.setEnabled(false);
		nullButton4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				
		nullButton5 = new JToggleButton();
		nullButton5.setEnabled(false);
		nullButton5.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				
		// CONTROL BUTTONS
		jBUp = new JButton("^");
		jBUp.addActionListener(this);
							
		jBDown = new JButton("v");
		jBDown.addActionListener(this);
							
		jBLeft = new JButton("<");
		jBLeft.addActionListener(this);
				
		jBRight = new JButton(">");
		jBRight.addActionListener(this);
		
		//BLANK SPOT PANEL SETTINGS 
		jPBlankSpotSide = new JPanel();
		jPBlankSpotSide.setPreferredSize(new Dimension(180,50));
		jPBlankSpotSide.setLayout(new GridLayout(3,3));
	
		//DIGITAL TIMER PANEL SETTINGS 
		jPDigitalTimer = new JPanel();
		jPDigitalTimer.setPreferredSize(new Dimension(180,70));
		jPDigitalTimer.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//DIGITAL TIMER LABELS 
		jLTimer = new JLabel("           DIGITAL TIMER           ");
		jLTimer.setLayout( new FlowLayout(FlowLayout.CENTER));
		jLTimer.setHorizontalAlignment(JLabel.CENTER);
				
		jLlabel1 = new  JLabel(":");
		jLlabel1.setSize(10,10);
		jLlabel2 = new JLabel(":");
		jLlabel2.setSize(10,10);

		// ADDING THE HOURS TEXT BOX
		jTHour = new JTextField(" 00  ");
		jTHour.setLocation(20, 30);
		jTHour.setSize(5,5);
		jTHour.setBackground(Color.BLACK);
		jTHour.setForeground(Color.WHITE);
		jTHour.setBorder( BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY) );
		jTHour.setLayout(new FlowLayout(FlowLayout.CENTER));
		jTHour.setHorizontalAlignment(JTextField.CENTER);
			
		
		// ADDING THE MINUTES TEXT BOX
		jTMins = new JTextField("00  ");
		jTMins.setLocation(80, 30);
		jTMins.setSize(5, 5);
		jTMins.setBackground(Color.BLACK);
		jTMins.setForeground(Color.WHITE);
		jTMins.setBorder( BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY) );
		jTMins.setHorizontalAlignment(JTextField.CENTER);
			
		//ADDING THE SECONDS TEXT BOX
		jTSeconds = new JTextField("00  ");
		jTSeconds.setLocation(140, 30);
		jTSeconds.setSize(5, 5);
		jTSeconds.setBackground(Color.BLACK);
		jTSeconds.setForeground(Color.WHITE);
		jTSeconds.setBorder( BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY) );
		jTSeconds.setHorizontalAlignment(JTextField.CENTER);
		
		//OPTIONS PANEL SETTINGS 
		jPOptionButtons = new JPanel();
		jPOptionButtons.setPreferredSize(new Dimension(180,70));
		jPOptionButtons.setLayout(new GridLayout(2,2));
		
		//OPTION BUTTONS
		jBOption1 = new JButton("Option 1");
		jBOption1.addActionListener(this);
				
		jBOption2 = new JButton("Option 2");
		jBOption2.addActionListener(this);
				
		jBOption3 = new JButton("Option 3");
		jBOption3.addActionListener(this);
				
		jBExit = new JButton("Exit");
		jBExit.addActionListener(this);		
			 
		
		//COMPASS PANEL SETTINGS 
		jPCompassFeature = new JPanel();
		jPCompassFeature.setPreferredSize(new Dimension(150,100));
		jPCompassFeature.setLayout( new FlowLayout(FlowLayout.CENTER));
	
		//COMPASS BUTTON
		jBCompass = new JButton();
		jBCompass.setPreferredSize(new Dimension(100,100));
		jBCompass.setIcon(imgCompassW);
	
		//ADDING ALL THE ELEMENTS TO ITS PANELS
		jPTopOptionsConstructor.add(jLOption);
		jPTopOptionsConstructor.add(jTOption);
		jPTopOptionsConstructor.add(jLSquare);	
		jPTopOptionsConstructor.add(jTSquare);
		jPTopOptionsConstructor.add(jLDirection);
		jPTopOptionsConstructor.add(jTDirection);
		
		jPControlOptions.add(nullButton1);
		jPControlOptions.add(jBUp);
		jPControlOptions.add(nullButton2);
		jPControlOptions.add(jBLeft);
		jPControlOptions.add(nullButton3);
		jPControlOptions.add(jBRight);
		jPControlOptions.add(nullButton4);
		jPControlOptions.add(jBDown);
		jPControlOptions.add(nullButton5);
		
		jPOptionButtons.add(jBOption1);
		jPOptionButtons.add(jBOption2);
		jPOptionButtons.add(jBOption3);
		jPOptionButtons.add(jBExit);	
		
		jPDigitalTimer.add(jLTimer);
		
		jPDigitalTimer.add(jTHour);
		jPDigitalTimer.add(jLlabel1);
		jPDigitalTimer.add(jTMins);
		jPDigitalTimer.add(jLlabel2);
		jPDigitalTimer.add(jTSeconds);
		
		
		jPCompassFeature.add(jBCompass);
		
		
		//ADD ELEMENTS 
		jPSide.add(jPTopOptionsConstructor);
		jPSide.add(jPControlOptions);
		jPSide.add(jPDigitalTimer);
		jPSide.add(jPBlankSpotSide);
		
		jPSide.add(jPOptionButtons);
		
		jPSide.add(jPCompassFeature);
		
		
		
	}	
		
	//-----------------------------Bottom panel------------------------------------------------------------------------------------
	
			public void Bottom()
			{
				//bottom panel settings
				jPBottom = new JPanel();
				jPBottom.setPreferredSize(new Dimension(805,50));
				window.add(jPBottom,BorderLayout.SOUTH);
				jPBottom.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				
				
				//blank spot left constructor panel settings
				jPBlankSpotBottomL = new JPanel();
				jPBlankSpotBottomL.setPreferredSize(new Dimension(90,30));
				jPBlankSpotBottomL.setLayout( new FlowLayout(FlowLayout.LEFT));
				
				//blank spot centre constructor panel settings
				jPBlankSpotBottomC = new JPanel();
				jPBlankSpotBottomC.setPreferredSize(new Dimension(180,30));
				jPBlankSpotBottomC.setLayout( new FlowLayout(FlowLayout.LEFT));
				
				//bottom buttons panel settings
				jPBottomButtons = new JPanel();
				jPBottomButtons.setPreferredSize(new Dimension(220,30));
				jPBottomButtons.setLayout( new GridLayout(1,3, 5, 4));
				
				//slider panel settings
				jPSlider = new JPanel();
				jPSlider.setPreferredSize(new Dimension(280,35));
				//jPSlider.setLayout( new FlowLayout(FlowLayout.LEFT));
				
				//Act, Run and Reset buttons
				jBAct = new JButton("Act",imgAct);
				jBAct.addActionListener(this);
				
				jBRun = new JButton("Run",imgRun);
				jBRun.addActionListener(this);
				
				jBReset = new JButton("Reset",imgReset);
				jBReset.addActionListener(this);
				
				//Slider label declaration and properties
				jLSlider = new JLabel("Speed:");
				
				//Slider properties
				jSFramesPerSecond = new JSlider(JSlider.HORIZONTAL, nMinSec, nMaxSec, nInitSec);
				jSFramesPerSecond.addChangeListener(this);
				
				jSFramesPerSecond.setMajorTickSpacing(370);
				jSFramesPerSecond.setPaintTicks(true);
				jSFramesPerSecond.setPaintLabels(false);
				
				//Add Act, Run and Reset buttons
				jPBottomButtons.add(jBAct);
				jPBottomButtons.add(jBRun);
				jPBottomButtons.add(jBReset);
				
				//Add slider and label
				jPSlider.add(jLSlider);
				jPSlider.add(jSFramesPerSecond);
				
				//add elements bottom panel
				jPBottom.add(jPBlankSpotBottomL);
				jPBottom.add(jPBottomButtons);
				jPBottom.add(jPBlankSpotBottomC);
				jPBottom.add(jPSlider,BorderLayout.SOUTH);
				
			}
	          
	//--------------------------------------------------------------------------------
	//ACT METHOD 
	public void buttonAct()
	{
		System.out.println("Act button is pressed");
		driveCar(nOption);
		if(nOption ==1)
		{
			//do nothing 
			
		}
		else if (nOption == 2)
		{
		movePerson(nOption);
		timerPerson.start();
		}
		else if (nOption == 3)
		{
			movePerson(nOption);
			timerPerson.start();
			timerOption3.start();
		}
	}
	//RUN METHOD
	public void buttonRun()
	{
		if(jBRun.getText() == "Run")
		{	
		System.out.println("Run button is pressed");
		
		   if(nOption == 1)
		   {
			timerOption1.start();
			timer.start();
		   }
		   else if(nOption == 2)
		   {
			timerOption2.start();
			timer.start();
		   }
		   else if(nOption == 3)
		   {
			timerOption3.start();
			timer.start();
		   }
		   
		jBRun.setText("Pause");
		jBRun.setIcon(imgPause);
		}
		else 
		{
			System.out.println("Pause button is pressed");
							
			if(nOption == 1)
			{
				timerOption1.stop();
				timer.stop();
			}
			else if(nOption == 2)
			{
				timerOption2.stop();
				timer.stop();
			}
			else if(nOption == 3)
			{
				timerOption3.stop();
				timer.stop();
			}
			
			jBRun.setText("Run");
			jBRun.setIcon(imgRun);
			
		}
		
	}
	
	//RESET BUTTON 
	public void buttonReset()
	{
		System.out.println("Reset button is pressed");
		CCarCrash.this.dispose();
		CCarCrash frame = new CCarCrash();
		frame.setSize(810,650);
		frame.createGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("CCarCrash- Car Race Application");
		
		if (nOption == 1)
		{
			jBCompass.setIcon(imgCompassE);
			timerOption1.stop();
		}
		else if (nOption == 2)
		{
			jBCompass.setIcon(imgCompassS);
			timerOption2.stop();
		}
		else if(nOption == 3)
		{
			jBCompass.setIcon(imgCompassW);
			timerOption3.stop();
		}
	}
	//---------------------------OPTION METHODS FOR SETTINGS --------------------------------------------------
	public void option1()
	{
		jTOption.setText("1");
		nOption = 1; 
		
		//RESET RUN TASK 
		nStep = 0 ;
		timerOption1.stop();
		timerOption2.stop();
		timerOption3.stop();
		timer.stop();
		
		
		//RESET COMPASS AND DIRECTION FIELD 
		jTDirection.setText("E");
		jBCompass.setIcon(imgCompassE);
		
		//RESET THE SQUARE NUMBER
		nSquare = carCurrentPosition;
		jTSquare.setText(""+nSquare);
		
		//SETTING GREY COLOURED SQUARE AT BOTTOM LEFT HAND CORNER 
		int sandPosition = 177 ;
		jBGrid[sandPosition].setIcon(imgSandS);
		
	}
	public void option2()
	{
		jTOption.setText("2");
		nOption = 2; 
		
		//RESET RUN TASK 
		nStep = 0 ;
		timerOption1.stop();
		timerOption2.stop();
		timerOption3.stop();
		timer.stop();
				
		//RESET COMPASS AND DIRECTION FIELD
		jTDirection.setText("S");
		jBCompass.setIcon(imgCompassS);
		
		//RESET THE SQUARE NUMBER
		nSquare = carCurrentPosition;
		jTSquare.setText(""+nSquare);		
		
		jBGrid[pCurrentPosition].setIcon(imgPerson);
		int sandP = 177;
		jBGrid[sandP].setIcon(imgSpace);
		
	}
	public void option3()
	{
		jTOption.setText("3");
		nOption = 3;
		
		//RESET COMPASS AND DIRECTION FIELD
		jTDirection.setText("N");
		jBCompass.setIcon(imgCompassN);
		
		//RESET RUN TASK 
		nStep = 0 ;
		timerOption1.stop();
		timerOption2.stop();
		timerOption3.stop();
		timer.stop();
		
		//RESET THE SQUARE NUMBER
		nSquare = bCurrentPosition;
		jTSquare.setText(""+nSquare);
		
		jBGrid[carCurrentPosition].setIcon(imgSpace);
		jBGrid[bCurrentPosition].setIcon(imgCarS);
		
		
		jBGrid[pCurrentPosition].setIcon(imgPerson);
				
		int sandP = 177;
		jBGrid[sandP].setIcon(imgSpace);
		
		int sandP1 = 18 ;
		jBGrid[sandP1].setIcon(imgSpace);
		
    }
				

	public void exitMethod()
	{
		jTOption.setText("Default");
		System.out.println("Exit button pressed");
		
		//reset Run task
		nStep = 0;
		timerOption1.stop();
		timerOption2.stop();
		timerOption3.stop();
		timer.stop();

		
		//ASKS THE USER FOR CONFIRMATION OF CLOSING THE APPLICATION
		int p = JOptionPane.showConfirmDialog(null,  "Are you sure you want to exit the game?","Yes",JOptionPane.YES_OPTION);
		if(p==0)
		{
		   System.exit(0);
		}
		
	}
	
	//----------------------------METHODS FOR MOVING THE CAR--------------------------------------
	public void moveRight()
	{
		System.out.println("The car moves right");
		jTDirection.setText("E");
		
		jBGrid[carCurrentPosition+1].setIcon(imgCarE);
		jBGrid[carCurrentPosition].setIcon(imgSpace);
		carCurrentPosition = carCurrentPosition +1 ;
		nSquare = carCurrentPosition;
		
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassE);	
     	collision();
	
	}
	
	public void moveLeft()
	{
		System.out.println("The car moves left");
		jTDirection.setText("W");
		
		jBGrid[carCurrentPosition-1].setIcon(imgCarW);
		jBGrid[carCurrentPosition].setIcon(imgSpace);
		carCurrentPosition = carCurrentPosition -1 ;
		nSquare = carCurrentPosition;
		
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassW);	
        collision();
	}
	
	public void moveDown()
	{
		System.out.println("The car moves down");
		jTDirection.setText("S");
		
		jBGrid[carCurrentPosition+16].setIcon(imgCarS);
		jBGrid[carCurrentPosition].setIcon(imgSpace);
		carCurrentPosition = carCurrentPosition +16 ;
		nSquare = carCurrentPosition;
		
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassS);	
        collision();
	}
	
	public void moveUp()
	{
		System.out.println("The car moves up");
		jTDirection.setText("N");
		jBGrid[carCurrentPosition-16].setIcon(imgCarN);
		jBGrid[carCurrentPosition].setIcon(imgSpace);
		carCurrentPosition = carCurrentPosition -16 ;
		nSquare = carCurrentPosition;
		
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassN);	
        collision();
	}
	

   //-----------------------------CHANGE LISTENERS--------------------------------------------------------------------------------

	public void stateChanged(ChangeEvent e) 
	{
        int nTimeDelay = jSFramesPerSecond.getValue();
		
		timerOption1.setDelay(nMaxSec - nTimeDelay);
		timerOption2.setDelay(nMaxSec - nTimeDelay);
		timerOption3.setDelay(nMaxSec - nTimeDelay);
		timerPerson.setDelay(nMaxSec - nTimeDelay);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{	
			
		Object source = e.getSource();
		
		if(source == jBUp)
		{
//			timer.start();
			moveUp();
		}
		if(source == jBDown)
		{
//			timer.start();
			moveDown();
		}
		if(source == jBLeft)
		{
//			timer.start();
			moveLeft();
		}
		if(source == jBRight)
		{
//			timer.start();
			moveRight();
		}
			
		//---------------------------------OPTIONS-------------------------------
		if(source == jBOption1 || source == option1Item)
		{
			option1();	
		}
		
		else if(source == jBOption2 || source == option2Item)
		{
			option2();
		}
		
		else if(source == jBOption3 || source == option3Item)
		{
			option3();
        }
		
		else if(source == jBExit || source == exitItem)
		{
			exitMethod();
			
        }

		//------------------------------CONTROLS FOR THE GAME---------------------
		if(source == jBAct || source == actItem)
		{
			buttonAct();
        }

		if(source == timerOption1 || source == timerOption2 || source == timerOption3 )
		{
			driveCar(nOption);
		}
		
		if (source == timerPerson)
		{
			movePerson(nOption);
		}
		
		if(source == jBRun || source == runItem)
		{
			buttonRun();
		}
					
		if(source == jBReset || source == resetItem)
		{
			buttonReset();
		}
		//------------------menu bar items listeners------------------------------------				
		
		if(source ==aboutItem)
		{
			System.out.println("About button is pressed");
			
			String sAbout = "Program:\t\t\t CCarCrash - Car Race Application \n" +
			                "Filename:\t\t\t CCarCrash.java \n" +
					        "Author:\t\t\t\t\t Poorvaja SathaSivam (Student ID: 19401412) \n" +
			                "Course:\t\t\t\t\t BSC Computing Year 1 \n" +
					        "Module:\t\t\t\t Problem solving and Programming CSY1020 \n" +
			                "Tutot:\t\t\t\t\t\t\t Mr Gary Hill \n" ;
			
			JOptionPane.showMessageDialog(null, sAbout,"About",JOptionPane.INFORMATION_MESSAGE);
			               
			         
		}
	}
	
	//----------------------------------------------------------------------------------------
	//MOVEMENTS FOR THE PERSON
	public void movePerson(int option)
	{
		//start timer for the person 
//		timerPerson.start();
		
		//condition for moving up
		switch (option)
		{ 
		
		case 1: 
		{
			jBGrid[pCurrentPosition].setIcon(imgSpace);
		}
		break ;
		case 2:
		{
			
		
			nPerson +=1 ; //for incrementing
			
			if(jBGrid[carCurrentPosition]==jBGrid[pCurrentPosition])
			{
				jBGrid[carCurrentPosition].setIcon(imgPerson);
				timer.stop();
				timerPerson.stop();
				JOptionPane.showInternalMessageDialog(null, "You have hit the person");
			}

		if(nPerson < 7)
		{
			jBGrid[pCurrentPosition-16].setIcon(imgPerson);
			jBGrid[pCurrentPosition].setIcon(imgSpace);
			pCurrentPosition = pCurrentPosition -16;
			
		}
		else if(nPerson >=6 && nPerson <9)
		{
			jBGrid[pCurrentPosition-1].setIcon(imgPerson);
			jBGrid[pCurrentPosition].setIcon(imgSpace);
			pCurrentPosition = pCurrentPosition -1;
		}
		else if (nPerson>=8 && nPerson <14)
		{
			int wall = 44;
			jBGrid[pCurrentPosition+16].setIcon(imgPerson);
			jBGrid[pCurrentPosition].setIcon(imgSpace);
			jBGrid[wall].setIcon(imgWallH);
			pCurrentPosition = pCurrentPosition +16 ;
			
		}
		else if (nPerson>=13 && nPerson <22)
		{
			jBGrid[pCurrentPosition-1].setIcon(imgPerson);
			jBGrid[pCurrentPosition].setIcon(imgSpace);
			pCurrentPosition = pCurrentPosition -1;
			
		}
		
		
		
		}
		break ;
		
		
		case 3:
		{
			if(jBGrid[carCurrentPosition]==jBGrid[pCurrentPosition])
			{
				jBGrid[carCurrentPosition].setIcon(imgPerson);
				timer.stop();
				timerPerson.stop();
				timerOption3.stop();
				JOptionPane.showInternalMessageDialog(null, "You have hit the person");
			}	
				nPerson +=1 ; //for incrementing

			if(nPerson < 5)
			{
				jBGrid[pCurrentPosition+16].setIcon(imgPerson);
				jBGrid[pCurrentPosition].setIcon(imgSpace);
				pCurrentPosition = pCurrentPosition +16;
				

				
			}
			else if(nPerson >=4 && nPerson <18)
			{
				jBGrid[pCurrentPosition-1].setIcon(imgPerson);
				jBGrid[pCurrentPosition].setIcon(imgSpace);
				pCurrentPosition = pCurrentPosition -1;
			}
			else if (nPerson>=17 && nPerson <24)
			{
				jBGrid[pCurrentPosition-16].setIcon(imgPerson);
				jBGrid[pCurrentPosition].setIcon(imgSpace);
				pCurrentPosition = pCurrentPosition -16 ;
			}
			else if (nPerson>=23 && nPerson <30)
			{
				int wall = 82;
				jBGrid[pCurrentPosition+1].setIcon(imgPerson);
				jBGrid[pCurrentPosition].setIcon(imgSpace);
				
				pCurrentPosition = pCurrentPosition +1;	
				jBGrid[wall].setIcon(imgWallV);
			}
			
            		
		}
		break ;
		
		}
		
		}
	//DRIVE CAR METHOD WILL SOLVE THE MOVEMENT OF THE CAR 		
	public void driveCar(int option)
	{
		switch(option)
		{
		   case 1 : 
		   {
			   nStep +=1 ;  //for incrementing 
			   
			   if( nStep <14)
			   {
				   moveRight();
				   
			   }
			   else if(nStep >= 14 && nStep <=23)
			   {
				   moveDown();
			   }
			   
			  else if(nStep>=23  && nStep<=36)
			   {
				  
				 moveLeft();
				 
				 if(nStep == 36)
				 {
				 timerOption1.stop();
				 timer.stop();
				 nStep = 0;
				 }
			   }
			   
			  else if(nStep >=36 && nStep <=46)
			   {
				  moveUp();

			   }
			   else if(nStep == 46)
			   {
				   timerOption1.stop();
				   nStep = 0;
				   JOptionPane.showMessageDialog(null, "You finished one lap ");
			   }

				   
				   
			}
		   break ;
		   
		   case 2:
			   
		   {
			   movePerson(nOption);
			   
			   
			   nStep +=1; 
			   
			  if(nStep >= 1 && nStep<=10 )
			  {
				  moveDown();
			  }
			  if(nStep >=10 && nStep<=22)
			  {
				  moveRight();
			  }
			  if(nStep >=22 && nStep<=31)
			  {
				  moveUp();
				  
			  }
			  if(nStep>=31 && nStep <=43)
			  {
				  moveLeft();
				  
			  }
			  if(nStep ==42)
			  {
				  timerOption2.stop();
				  nStep=0;
				  timer.stop();
				  JOptionPane.showMessageDialog(null, "Congratulations, you finished one lap!");
			  }
			  

				   
		   }
		   break ;
		   case 3:
		   {
			   nStep +=1 ; 
			   movePerson(nOption);
			   if(nStep<11)
			   {
				   movedown();
				   
			   }
			   else if (nStep >= 10 && nStep <24)
			   {
				   moveleft();

				   
			   }
			   else if (nStep >=23 && nStep < 34)
			   {
				   	moveup();
			   }
			   else if (nStep >=33 && nStep < 46)
			   {
				   	moveright();
			   }
			   if (nStep ==45)
			   {
				   timer.stop();
				   nStep = 0;
				   timerOption3.stop();
				   System.out.println("The lap is complete");
				   JOptionPane.showMessageDialog(null, "Congratulations, you finished one lap!"); 
				   nSquare = bCurrentPosition;
					
				   jTSquare.setText(""+nSquare);
			   }   
			   
		   }

			   
		 }
		
   }
	//METHODS FOR OPTION 3
	public void movedown()
	{
		jBGrid[bCurrentPosition+16].setIcon(imgCarS);
		jBGrid[bCurrentPosition].setIcon(imgSpace);
		bCurrentPosition = bCurrentPosition + 16 ;
		nSquare = bCurrentPosition;
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassS);	
		
	}
	
	public void moveleft()
	{
		jBGrid[bCurrentPosition-1].setIcon(imgCarW);
		jBGrid[bCurrentPosition].setIcon(imgSpace);
		bCurrentPosition = bCurrentPosition -1 ;
		nSquare = bCurrentPosition;
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassW);	
		
	}
	public void moveup()
	{
		jBGrid[bCurrentPosition-16].setIcon(imgCarN);
		jBGrid[bCurrentPosition].setIcon(imgSpace);
		bCurrentPosition = bCurrentPosition -16 ; 
		nSquare = bCurrentPosition;
		jTSquare.setText(""+nSquare);
		jBCompass.setIcon(imgCompassN);
	}
	public void moveright()
	{
		jBGrid[bCurrentPosition+1].setIcon(imgCarE);
		   jBGrid[bCurrentPosition].setIcon(imgSpace);
		   bCurrentPosition = bCurrentPosition +1 ;  
		   nSquare = bCurrentPosition;
		   jTSquare.setText(""+nSquare);
		   jBCompass.setIcon(imgCompassE);
		
	}
	
	
		  	
	public void collision()
	{
		
		
//---------------------------COLLISION DETECTION OF THE OUTER WALLS-------------------------------
		// EACH IF METHOD DETETCTS THE COLLLISION BETWEEN THE WALL AND THE CAR. 

		if(jBGrid[carCurrentPosition]== jBGrid[wallNW])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallNW);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		if(jBGrid[carCurrentPosition]== jBGrid[wallNE])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallNE);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		if(jBGrid[carCurrentPosition]== jBGrid[wallSW])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallSW);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		
		if(jBGrid[carCurrentPosition]== jBGrid[wallSE])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallSE);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
				
		
		for(int wallH =1 ; wallH <=14; wallH ++)
		{
			jBGrid[wallH].setIcon(imgWallH);
			if(jBGrid[carCurrentPosition]== jBGrid[wallH])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallH);
			   JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
			}
			
		}
		
		for(int wallV=16; wallV<191;wallV+=16)
		{
			jBGrid[wallV].setIcon(imgWallV);
			if(jBGrid[carCurrentPosition]== jBGrid[wallV])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallV);
				JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
				
			}
		}
		
		for(int wallV = 31 ; wallV <207; wallV+=16)
		{
			jBGrid[wallV].setIcon(imgWallV);
			if(jBGrid[carCurrentPosition]== jBGrid[wallV])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallV);
				JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
				
			}
		}
		
		
		for(int wallH = 193 ; wallH<=206 ;wallH++)
		{
			jBGrid[wallH].setIcon(imgWallH);
			if(jBGrid[carCurrentPosition]== jBGrid[wallH])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallH);
			   JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
			}

		}
		
//---------------------------COLLISION DETECTION FOR THE INNER WALLS-----------------------
		
		// EACH IF METHOD DETETCTS THE COLLLISION BETWEEN THE WALL AND THE CAR 
		if(jBGrid[carCurrentPosition]== jBGrid[wallNW1])    
		{
			jBGrid[carCurrentPosition].setIcon(imgWallNW);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		if(jBGrid[carCurrentPosition]== jBGrid[wallNE1])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallNE);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		if(jBGrid[carCurrentPosition]== jBGrid[wallSW1])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallSW);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		
		if(jBGrid[carCurrentPosition]== jBGrid[wallSE1])
		{
			jBGrid[carCurrentPosition].setIcon(imgWallSE);
			JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
		}
		
		for(int wallH1 =35 ; wallH1<=44; wallH1++)
		{
			jBGrid[wallH1].setIcon(imgWallH);
			if(jBGrid[carCurrentPosition]==jBGrid[wallH1])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallH);
				   JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
			}
		}
		
		for(int wallV1 = 50; wallV1<157; wallV1+=16)
		{
			jBGrid[wallV1].setIcon(imgWallV);
			if(jBGrid[carCurrentPosition]==jBGrid[wallV1])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallV);
				   JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
			}
			
		}	
		
		for(int wallV1 = 61; wallV1<173;wallV1+=16)
		{
			jBGrid[wallV1].setIcon(imgWallV);
			if(jBGrid[carCurrentPosition]==jBGrid[wallV1])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallV);
				   JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
			}
			
		}	
		
		for(int wallH1 = 163; wallH1 <=172;wallH1++)
		{
			jBGrid[wallH1].setIcon(imgWallH);
			if(jBGrid[carCurrentPosition]==jBGrid[wallH1])
			{
				jBGrid[carCurrentPosition].setIcon(imgWallH);
				   JOptionPane.showInternalMessageDialog(null, "You have hit the wall");
			}
			
		}
    }
}

	
//------------------------------------------------------------------------------------------------------------------------	
	
