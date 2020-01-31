// Demonstrating the display of images on top of a background image.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout; // specifies how components are arranged
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

public class TestingImages extends JFrame 
{
   private JLabel marioTitle; // JLabel with just text
   private JLabel luigi; // JLabel constructed with text and icon
   private JLabel label3; // JLabel with added text and icon
   private JLabel background; // JLabel to display the background image on.
   static final int FRAME_WIDTH = 1000;
   static final int FRAME_HEIGHT = 700;

   // LabelFrame constructor adds JLabels to JFrame
   public TestingImages()
   {
      super("Mario Poker" );
      setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	  setLocation(480, 100);
      setLayout( new FlowLayout() ); 
      background = new JLabel (new ImageIcon("goldbackground.jpg"));
      add(background);
      background.setLayout(new FlowLayout()); 
     
      
      
      marioTitle = new JLabel( "MARIO POKER" );
      marioTitle.setBounds(30, 350, 600, 100);
      marioTitle.setForeground(new Color(22,138,63));
      // Changes color of text
      Font titleFont = new Font("Bauhaus 93", Font.PLAIN, 130);
      marioTitle.setFont(titleFont);
      // Changed font and size of text
      background.add( marioTitle );

      Icon luigipic = new ImageIcon(new ImageIcon("luigiimage.png").getImage().getScaledInstance(160, 250, Image.SCALE_DEFAULT));
      luigi = new JLabel(luigipic);
      luigi.setBounds(30, 350, 600, 100);
      background.add(luigi); 
      
   }
   
   public static void main(String[] args) {
	   	TestingImages labelFrame = new TestingImages(); // create LabelFrame
	      labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      labelFrame.pack(); // pack the window to the exact size of all the images without cutting anything off.
	      labelFrame.setVisible( true ); // display frame
   
   }
   
   
   
} // end class LabelFrame


