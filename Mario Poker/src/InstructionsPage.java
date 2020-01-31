/*
 * Katia Izvoztchikova
 * ICS4UE
 * Mr.Benum
 * Goal of program is to display an instructions screen. To explain to user how to play. 
 * Also has to have a back button to exit screen.  
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

public class InstructionsPage extends JFrame 
{
   private JLabel marioTitle; // JLabel with just text
   private JLabel luigi; // JLabel with image
   private JLabel background; // JLabel to display the background image on.
   static final int FRAME_WIDTH = 1000;
   static final int FRAME_HEIGHT = 700;
   static Font buttonFont = new Font("Bernard MT Condensed", Font.PLAIN, 20);
   static Color lgreen = new Color(22,138,63);
   static Color dgreen = new Color(11,66,30);

   // LabelFrame constructor adds JLabels to JFrame
   public InstructionsPage()
   {
      super("Instructions" );
      setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	  setLocation(480, 100);
      background = new JLabel (new ImageIcon("goldbackground.jpg"));
      add(background);
      background.setLayout(null); 
     
      
      marioTitle = new JLabel( "How to Play Mario Poker" );
      marioTitle.setBounds(260, 45, FRAME_WIDTH, 70);
      // BOUNDS WORRK LIKE THIS  = x, y, width of label, height of label  
      marioTitle.setForeground(lgreen);
      // Changes color of text
      Font titleFont = new Font("Bernard MT Condensed", Font.PLAIN, 50);
      marioTitle.setFont(titleFont);
      // Changed font and size of text
      background.add( marioTitle );
      
      JLabel text = new JLabel ("<html><font size=+2 face='Andalus' color='#FFFFFF'><p> Your goal is to build "
      		+ "a stack tower as tall as you can by placing blocks "
      		+ "on top of each other. To stop each block, press space. If you do not stack the block exactly "
      		+ "on top of the previous block, you will lose one of your blocks. The game will continue until "
      		+ "you have no blocks left. If you get to the top of the game screen without losing all of your "
      		+ "blocks, you win! <br><br><p> Hint: Watch out! The speed of the blocks will increase the higher you get! "
      		+ "<br><br><p>Have fun!!! </f></p></html>");
      // Making a JLabel for instructions text, formatted using HTML
      text.setBounds(50, 130, 880, 430);
      text.setOpaque(true);
      // Making opaque so that JLabel visible, looks like a rectangle
      text.setBackground(lgreen);
      background.add(text);
      
      // Makes a back button 
      JButton back = new JButton();
      back.setText("Back");
      background.add(back); 
      back.setFont(buttonFont);
      back.setBounds(830, 580, 100, 30);
      // Location of Button
      back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				// Closes the Instructions JFrame when button clicked
			}
      });
      
   }
   
}
    
      


