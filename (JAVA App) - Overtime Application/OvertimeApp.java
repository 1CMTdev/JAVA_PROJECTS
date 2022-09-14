import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.Border;

public class OvertimeApp extends JFrame implements ActionListener
{

   //Bordeline Declaration 	 
   Border bord1 = BorderFactory.createTitledBorder("Employee Info");
   Border bord2 = BorderFactory.createTitledBorder("Max OT Hours");
   Border bord3 = BorderFactory.createTitledBorder("Employee Salary");
   
   
   			//DECLARE UNIVERSAL VARIABLE
   			public static double regPay,otPay,salary,regHours;
   			public static String empName;
   			public static double otHours=0,maxOT=0;
   			
   
   //JButtons
   JButton calc= new JButton("Compute");
   JButton clear = new JButton("Clear");
   JButton close = new JButton("Close");
   
   
   Font font = new Font("Verdana", Font.PLAIN,12);

   ButtonGroup BG = new ButtonGroup();
   
   //Employee
   JPanel panel1 = new JPanel();
   //OT
   JPanel panel2 = new JPanel();
   //Salary
   JPanel panel3 = new JPanel();
    
    
   // Employee Labels
   JLabel ENlabel = new JLabel("        Employee Name: ");
   JLabel NHRlabel = new JLabel("No. of Working Hours: ");
   JLabel RRlabel = new JLabel("         Regular Rate:     ");
   
   // Employee Salary Labels
   JLabel ENSlabel = new JLabel("Employee Name:");
   JLabel RHlabel = new JLabel("Regular Hours:");
   JLabel OTHlabel = new JLabel("Overtime Hours:");
   
   JLabel RPlabel = new JLabel("Regular Pay:");
   JLabel OPlabel = new JLabel("Overtime Pay:");
   JLabel Slabel = new JLabel("Salary:");
    
   //Employee Fields
   JTextField EN = new JTextField(10);
   JTextField NHR = new JTextField(10);
   JTextField RR = new JTextField(10);
   
   
   //Employee Salary Fields 
   
   JTextField ENS = new JTextField(15);
   JTextField RH = new JTextField(15);
   JTextField OTH = new JTextField(15);
   
   JTextField RP = new JTextField(15);
   JTextField OP = new JTextField(15);
   JTextField S = new JTextField(15);
   
   
  //JRadioButton & JButton
  
   JRadioButton fourty = new JRadioButton("40");
   JRadioButton fifty = new JRadioButton("50");
   	
   		
   	private void PrivateGUI() 
   	{
   		//for background IMAGE
   	   setLayout(new BorderLayout());
       setContentPane(new JLabel(new ImageIcon("mainbg.jpg")));
   	   setLayout(new FlowLayout());
   	   
   		Container F = getContentPane();
		
		setTitle("OVERTIME");
		F.setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(625,400);
		
		
		//Employee panel===================================================================================
		F.add(panel1);
		panel1.setBounds(10,10,290,110);
		
		//setFont
		
		//Employee Fonts
		ENlabel.setFont(font);
		NHRlabel.setFont(font);
		RRlabel.setFont(font); 
		
		
		//Labels & Fields || NOTE: these are in order
		
		panel1.add(ENlabel);
		panel1.add(EN);
		panel1.add(NHRlabel);
		panel1.add(NHR);
		panel1.add(RRlabel);
		panel1.add(RR);
		
		//Aligns employee label for each textfield 
		ENlabel.setLabelFor(EN);
		NHRlabel.setLabelFor(NHR);
		RRlabel.setLabelFor(RR);
		
		//add border for employee
		panel1.setBorder(bord1);
		
		
		//Max OT HOURS panel================================================================================
		
		F.add(panel2);
		panel2.setBounds(310,10,290,75);
		
		//add border for OT
		panel2.setBorder(bord2);
		
		//add radiobtn & group
		panel2.add(fourty);
		panel2.add(fifty);
		BG.add(fourty);
		BG.add(fifty);
		
		//Button
		F.add(calc);
		F.add(clear);
		F.add(close);
		
		calc.setBounds(312,90,90,25);
		clear.setBounds(407,90,90,25);
		close.setBounds(502,90,95,25);
		
		
		//Employee Salary panel =================================================================================
		
		//Labels //Not inside a panel para ma adjust ng madalian sa bounds
		
		F.add(ENSlabel);
		F.add(RHlabel);
		F.add(OTHlabel);
		F.add(RPlabel);
		F.add(OPlabel);
		F.add(Slabel);
		//field
		F.add(ENS);
		F.add(RH);
		F.add(OTH);
		F.add(RP);
		F.add(OP);
		F.add(S);
		
		
		//add border for salary
		panel3.setBorder(bord3); 
		F.add(panel3);
		panel3.setBounds(10,190,590,150);
		
		//not editable fields
		ENS.setEditable(false);
		RH.setEditable(false);
		OTH.setEditable(false);
		RP.setEditable(false);
		OP.setEditable(false);
		S.setEditable(false);
		
		//Bounds
		ENSlabel.setBounds(40,220,100,20);
		RHlabel.setBounds(40,250,100,20);
		OTHlabel.setBounds(40,280,100,20);
		RPlabel.setBounds(340,220,100,20);
		OPlabel.setBounds(340,250,100,20);
		Slabel.setBounds(340,280,100,20);
		
		ENS.setBounds(150,220,100,20);
		RH.setBounds(150,250,100,20);
		OTH.setBounds(150,280,100,20);
		RP.setBounds(420,220,100,20);
		OP.setBounds(420,250,100,20);
		S.setBounds(420,280,100,20);
		
		//Listener
		calc.addActionListener(this);
		clear.addActionListener(this);
		close.addActionListener(this);
   		
   	}
   	
  
   	
   	
   		//OVERTIME CLASS WITH 3 DATA MEMBERS
   		public static void Overtime(String empNNName,double noHours,double regRate)
   	  	{	empName=empNNName;
   	  		if(maxOT==0){
   	  		regHours=noHours;
   	  		}
   	  		else 
   	  		{regHours=maxOT;
   	  		otHours=noHours-maxOT;}
   	  		regPay=regHours*regRate;
   	  		otPay=(1.50*regRate)*otHours;
   	  		salary = regPay + otPay;		

   	  	} 
   	
   	/****************************************************/
   	public OvertimeApp() 
   	{
   	    PrivateGUI();
   	 
   	}/****************************************************/
   	
   	public void actionPerformed(ActionEvent e) 
   	{
   		if (e.getSource() == calc)
   		{
   			if (fourty.isSelected())
   			maxOT=40;
    				
   			if (fifty.isSelected())
   			maxOT=50;
   			
   		
   			empName = String.valueOf(EN.getText());

   			
   			ENS.setText(String.valueOf(empName));
   			 
   			 //****************
   			 double workHours,regRate;
   			 workHours = Double.parseDouble(NHR.getText());
   	    	 regRate = Double.parseDouble(RR.getText());
   	    	if(maxOT>=workHours)
   			{
   			maxOT=0;
   			}
   				
   	    	Overtime(empName,workHours,regRate);
   	    	 
   		
   			RH.setText(String.valueOf(regHours));
   			OTH.setText(String.valueOf(otHours));
   	    	RP.setText(String.valueOf(regPay));
   	    	OP.setText(String.valueOf(otPay));
   	    	S.setText(String.valueOf(salary));
   	    	
   	    	calc.setEnabled(false);
   		}
   			
   		if  (e.getSource() == clear)
   		{
   				otHours=0;
   				maxOT=0;
   			EN.setText("");
   			NHR.setText("");
   			RR.setText("");
   			ENS.setText("");
   			RH.setText("");
   			OTH.setText("");
   	    	RP.setText("");
   	    	OP.setText("");
   	    	S.setText("");
			BG.clearSelection();
   			calc.setEnabled(true);
   		}
   			
   		if (e.getSource() == close)
   			System.exit(0);
   		
   	}	
   

   	public static void main (String [] args) 
   	{
   		OvertimeApp OT = new OvertimeApp();
   		OT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	}
   	
 }