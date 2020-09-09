//exc on 745-48

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResort extends JFrame implements ItemListener
{
	 //data field vars and consts for this class
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;
	int totalPrice = BASE_PRICE;

	//create 3 JCheckBox obj
	JCheckBox weekendBox = new JCheckBox("weekend premimum $" + WEEKEND_PREMIUM, false);
	JCheckBox breakfastBox = new JCheckBox("breakfast $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("golf $" + GOLF_PREMIUM, false);

	//create  4 JLabel obj
	JLabel restortLabel = new JLabel("resort price calculator");
	JLabel optionExplainLabel = new JLabel("base price for a room is $" + BASE_PRICE);
	JLabel optionExplainLabel2 = new JLabel("check the options you want to add");
	JLabel priceLabel = new JLabel("the price for your stay is");

	// create 1 JTextField obj
	JTextField priceField = new JTextField(4);

	//const method for this class
	public JResort()
	{
		super("resort price estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//add the various GUI comps to the frame
		add(restortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(priceField);

		//set priceField value when gui loads
		priceField.setText("$" + totalPrice);


		//add event listeners for JCheckBox obj
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);	

	}

	//event handling method for this gui
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();

		//decide which comp triggered this event 
		//adj the totalPrice accordingly 
		if(source == weekendBox)
		{
			//if box is checked add prem
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}

		else if(source == breakfastBox)
		{
			//if box is checked add prem
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}

		//saying source is == to golfBox
		else
		{
			//if box is checked add prem
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
		}

		priceField.setText("$" + totalPrice);	
	}


	public static void main(String[] args)
	{
		//build an obj from the JResort class
		JResort aFrame = new JResort();
		aFrame.setSize(300, 200);
		aFrame.setVisible(true);
	} 
}