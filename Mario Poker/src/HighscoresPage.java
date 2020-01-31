import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HighscoresPage extends JFrame {
	//size of the frame of the whole game
	final int FRAME_WIDTH = 1000;
	final int FRAME_HEIGHT = 700;


	//Holds the length of the high score list
	final int HIGH_SCORE_LIST_LENGTH = 6;

	//These arrays will hold a list of the names with high scores, and the actual high scores, respectively
	String[] namesList = new String[HIGH_SCORE_LIST_LENGTH];
	int[] scoresList = new int[HIGH_SCORE_LIST_LENGTH];

	//These arrays will hold the JLabels that display the text of the names with high scores and the actual high scores
	private JLabel[] nameLabels = new JLabel[HIGH_SCORE_LIST_LENGTH];
	private JLabel[] scoreLabels = new JLabel[HIGH_SCORE_LIST_LENGTH];


	final private JLabel leaderboardTitle; // JLabel with just text
	private JLabel background; // JLabel to display the background image on.

	static Font titleFont = new Font("Bernard MT Condensed", Font.PLAIN, 110);
	private final Font textFont = new Font("Bernard MT Condensed", Font.PLAIN, 45);
	static Font buttonFont = new Font("Bernard MT Condensed", Font.PLAIN, 20);

	String highscores = "highscores.txt";

	public HighscoresPage()
	{
		super("Mario Poker" );
		setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setLocation(480, 100); 
		background = new JLabel (new ImageIcon("goldbackground.jpg"));
		add(background);
		background.setLayout(null); 
		background = new JLabel (new ImageIcon("goldbackground.jpg"));
		add(background);
		background.setLayout(null); 
		//Convert the text file of high scores into a names and score array with corresponding valus
		fileToArray();
		//Arranges the scores and name arrays in order, and writes these new scores to the textfile
		arrangeScores();
		writeHighScoresToFile();	
		//Updates the labels with the text of the name and score
		updateLabels();

		//Creates a button that can send the user back to the homescreen
		final JButton backButton = new JButton("BACK");
		backButton.setForeground(new Color(22,138,63));
		backButton.setFont(buttonFont);
		//adds function to the back button. It will take you back to the home screen when you press on it
		backButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});


		//Creates a JLabel which will say leaderboard		
		leaderboardTitle = new JLabel("Leaderboard");
		leaderboardTitle.setForeground(new Color(22,138,63));
		leaderboardTitle.setFont(titleFont);
		leaderboardTitle.setBounds(230, 65, 800, 100);
		background.add(leaderboardTitle);

		//Goes through every label in the score and name array
		int y = 165;
		for (int i = 0; i < HIGH_SCORE_LIST_LENGTH; i++)
		{
			
			//Adds name labels to the panel
			nameLabels[i].setForeground(new Color(22,138,63));
			nameLabels[i].setFont(textFont);
			nameLabels[i].setBounds(305, y, 800, 100);
			background.add(nameLabels[i]);
			//Adds the score labels to the panel
			scoreLabels[i].setForeground(new Color(22,138,63));
			scoreLabels[i].setFont(textFont);
			scoreLabels[i].setBounds(600, y, 800, 100);
			background.add(scoreLabels[i]);
			y+=60;
		}
		backButton.setBounds(460, 580, 100, 30);
		background.add(backButton);
		/*
		//Sets gridBagConstraints for elements on the screen, then adds the title
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(1,1,1,1);
		c.gridwidth = 2;

		//Creates a JLabel which will say leaderboard		
		leaderboardTitle = new JLabel("LEADERBOARD");
		leaderboardTitle.setForeground(new Color(22,138,63));
		leaderboardTitle.setFont(titleFont);
		background.add(leaderboardTitle, c);
		//Updates gridbag constraints for the names and scores
		c.gridy++;
		c.gridwidth = 1;
		c.insets = new Insets(1,70,1,1);
		//Goes through every label in the score and name array
		for (int i = 0; i < HIGH_SCORE_LIST_LENGTH; i++)
		{
			//Adds name labels to the panel
			c.gridx = 0;
			nameLabels[i].setForeground(new Color(22,138,63));
			nameLabels[i].setFont(textFont);
			background.add(nameLabels[i], c);
			//Adds the score labels to the panel
			c.gridx = 1;
			scoreLabels[i].setForeground(new Color(22,138,63));
			scoreLabels[i].setFont(textFont);
			background.add(scoreLabels[i], c);
			c.gridy++;
		}
		//Changes grid bag contraints again, then adds the backbutton
		c.gridx = 0;
		c.gridwidth = 2;
		c.insets = new Insets(1,1,1,1);
		background.add(backButton, c);


		setVisible(true);
		//setBackground(BACKGROUND_COLOUR);
		 */
	}
	public void fileToArray()
	{
		String line = null;
		try 
		{
			//Creates specific objects for file reading
			FileReader fileReader = new FileReader(highscores);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int counter = 0;
			//Uses the modulus function to place half of the line values into the name array, and half into the scores array
			while((line = bufferedReader.readLine()) != null && counter < 12) 
			{
				if (counter%2==0)
				{
					namesList[counter/2] = line;
				}
				else
				{
					//Double.parseInt converts the string in the text file into a double, or floating point number
					scoresList[counter/2] = Integer.parseInt(line);
				}
				counter++;
			}   
			bufferedReader.close();         
		}
		//Catches any exceptions or possible mistakes with filereading
		catch(FileNotFoundException ex) 
		{
			ex.printStackTrace();              
		}
		catch(IOException ex)
		{
			ex.printStackTrace();                  
		}
	}
	/**
	 *Writes the score and the name to the highscore file
	 *pre: there is a file to write on
	 *post: name and score recorded on file
	 */
	public void writeHighScoresToFile()
	{
		try 
		{
			//Creates file writing objects
			FileWriter fileWriter = new FileWriter(highscores);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			//Goes through each point in the array and adds each one as a new line into the text file
			for (int i = 0; i < scoresList.length && i < namesList.length; i++)
			{
				bufferedWriter.write(namesList[i]);
				bufferedWriter.newLine();
				bufferedWriter.write(String.valueOf(scoresList[i]));
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
		}
		//Catches any problems that occur during file writing
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	/**
	 *arranges scores so that highest is at the top, and lowest is at the bottom
	 *pre: there are scores
	 *post: names are all sorted
	 */
	public void arrangeScores()
	{		
		//Goes through each position in the array
		for (int i = 0; i <HIGH_SCORE_LIST_LENGTH; i++)
		{
			//Starts searching from the value right after the position number, and replaces it with the position number if it is larger. 
			for (int j = i+1; j < HIGH_SCORE_LIST_LENGTH; j++)
			{
				if (scoresList[j]>scoresList[i])
				{
					//A temp stores the value of the earlier position, then the second position replaces the early position, and the temp (or value of early position) replaces the second position
					int tempScore = scoresList[i];
					String tempName = namesList[i];
					scoresList[i] = scoresList[j];
					namesList[i] = namesList[j];
					scoresList[j] = tempScore;
					namesList[j] = tempName;
				}
			}
		}
	}
	/**
	 * add new highscores to arrays
	 * pre: the list must be in order, with the lowest value at the end
	 * post: name and score stored to arrays if the list is not full
	 */
	public void addHighScore(String name, int score)
	{
		//Temporarily sets the listFull variable to true
		boolean listFull = true;
		for (int i = 0; i < HIGH_SCORE_LIST_LENGTH; i++)
		{
			//If a score isn’t added (scores are originally 0), it means the list is not full, so the variable is set to false. The score and name is also added in the section
			if (scoresList[i]==0)
			{
				scoresList[i] = score;
				namesList[i] = name;
				listFull = false;
				break;
			}
		}
		//If the list is full, the new score is only added if it is higher than at least the lowest (or last) value
		if (listFull)
		{
			if (score > scoresList[HIGH_SCORE_LIST_LENGTH-1])
			{
				scoresList[scoresList.length-1] = score;
				namesList[scoresList.length-1] = name;
			}
		}
	}
	/**
	 *Updates the leaderboard labels to display updated organised scores
	 *pre: has to be a name with a new high score
	 *post: labels are updated
	 */
	public void updateLabels()
	{
		//Goes through each label in both label arrays and sets their values to be the same as the values in the main arrays. (So the name label 1, would have the first name in the name array)
		for (int i = 0; i < HIGH_SCORE_LIST_LENGTH; i++)
		{
			//generates labels
			nameLabels[i] = new JLabel(namesList[i]);
			scoreLabels[i] = new JLabel(String.valueOf(scoresList[i]));
		}
	}


}



