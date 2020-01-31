/*
 * Katia Izvoztchikova
 * ICS4UE
 * Mr.Benum
 * Goal of program is to display a home screen, with buttons, a background, sounds, and
 * an image of luigi. This is to allow the player to navigate between pages of our game. 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*; 

public class HomePage extends JFrame 
{
   private JLabel marioTitle; // JLabel with just text
   private JLabel luigi; // JLabel with image
   private JLabel background; // JLabel to display the background image on.
   static final int FRAME_WIDTH = 1000;
   static final int FRAME_HEIGHT = 700;
   static Font buttonFont = new Font("Bernard MT Condensed", Font.PLAIN, 20);
   static Color lgreen = new Color(22,138,63);
   static Color dgreen = new Color(11,66,30);
   static boolean sound = true;
   static Clip clip;

   // LabelFrame constructor adds JLabels to JFrame
   public HomePage()
   {
      super("Mario Poker" );
      setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	  setLocation(480, 100); 
      background = new JLabel (new ImageIcon("goldbackground.jpg"));
      add(background);
      background.setLayout(null); 
     
      
      marioTitle = new JLabel( "MARIO POKER" );
      marioTitle.setBounds(190, 130, 900, 110);
      // BOUNDS WORRK LIKE THIS  = x, y, width of label, height of label  
      marioTitle.setForeground(lgreen);
      // Changes color of text
      Font titleFont = new Font("Bernard MT Condensed", Font.PLAIN, 110);
      marioTitle.setFont(titleFont);
      // Changed font and size of text
      background.add( marioTitle );

      
      Icon luigipic = new ImageIcon(new ImageIcon("luigiimage.png").getImage().getScaledInstance(175, 210, Image.SCALE_DEFAULT));
      luigi = new JLabel(luigipic);
      luigi.setBounds(40, 265, 600, 220);
      background.add(luigi); 
      
      JButton btnGame = new JButton();
      btnGame.setText("PLAY");
      background.add(btnGame); 
      btnGame.setFont(buttonFont);
      // Changing font to preassigned font
      btnGame.setForeground(dgreen);
      btnGame.setBounds(520, 280, 200, 50);
      // Setting location of Button
      btnGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				  Poker pgame = new Poker();
			      pgame.pack(); 
			      pgame.setVisible( true ); // display frame
				
			}
      });
      // Will perform ____  when button is clicked
      
      
      JButton btnInst = new JButton();
      btnInst.setText("Instructions");
      background.add(btnInst); 
      btnInst.setFont(buttonFont);
      // Changing font to preassigned font
      btnInst.setForeground(dgreen);
      btnInst.setBounds(520, 350, 200, 50);
      // Setting location of Button
      btnInst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				  InstructionsPage instFrame = new InstructionsPage(); 
			      instFrame.pack(); 
			      instFrame.setVisible( true ); // display frame
				
			}
      });
      // Will perform ____  when button is clicked
      
      
      JButton btnHiScr = new JButton();
      btnHiScr.setText("High Scores");
      background.add(btnHiScr); 
      btnHiScr.setFont(buttonFont);
      // Changing font to preassigned font
      btnHiScr.setForeground(dgreen);
      btnHiScr.setBounds(520, 420, 200, 50);
      // Setting location of Button
      btnHiScr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// put what it will do when clicked
				
			}
      });
      // Will perform ____  when button is clicked
      
      
      
      // Making sound happen :)
      
      try // Tries to execute main code
		{
			AudioInputStream music = AudioSystem.getAudioInputStream(new File("01 - Super Mario Bros.wav").getAbsoluteFile()); // Gets audio clip 
			clip = AudioSystem.getClip(); // Gets audio clip
			clip.open(music); // Opens music clip											
		}
		catch (Exception e) // If there is an exception								
		{
		}
      clip.start(); // Starts the music
		clip.loop(Clip.LOOP_CONTINUOUSLY);
      // Music plays on loop throughout running of program
      
      
      // Making sound button with images and music attached
      final ImageIcon soundON = new ImageIcon ("SoundGoodOn.PNG");
      final ImageIcon soundOff = new ImageIcon ("SoundGoodOFF.PNG");
      final JButton btnSound = new JButton(soundON); 
      // Setting the button to have an image 
      background.add(btnSound);
      btnSound.setBounds(870, 550, 60, 53);
      // Location of Button
      btnSound.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if (sound){
					clip.stop(); // Stops the music
					btnSound.setIcon(soundOff);
					sound = false;
				} else {
					btnSound.setIcon(soundON);
					clip.start(); // Starts the music
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					sound = true;
				}
				// If button is clicked will alternate between
				// sound being turned on and off based on 
				// boolean variable, sound. 
			}
      });
    
      
   } // closes constructor 
   
   public static void main(String[] args) {
	   	  HomePage labelFrame = new HomePage(); 
	      labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      labelFrame.pack(); 
	      labelFrame.setVisible( true ); // display frame
   
   }
   
   
   
} // end class LabelFrame








