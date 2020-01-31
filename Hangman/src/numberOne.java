/*
 * Name: Dina Bernstein
 * Due Date: June 16th 2017
 * Class: ICS
 * Purpose: A hangman game where the user picks a category then tries to guess the letters in a word of that category.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

/* https://codereview.stackexchange.com/questions/95426/very-simple-hangman-game 
 * http://java-articles.info/articles/?p=349*/

public class numberOne
{
	public static void main(String[] args) 
	{
		final JFrame window = new JFrame("Hangman"); //Creates the window, sets the size and default close operation
		window.setSize(640, 480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel screen = new JPanel(); //JPanel that holds everything
		final JPanel jpanelOne = new JPanel(); //starting screen
		final JPanel jpanelTwo = new JPanel(); // game screen
		final JPanel gameOverScreen = new JPanel(); //game over screen
		final JPanel youWonScreen = new JPanel(); //winning screen
		//adds each jpanel to screen
		screen.add(jpanelOne);
		screen.add(jpanelTwo);
		screen.add(gameOverScreen);
		screen.add(youWonScreen);
		
		//Array of possible topics
		String topics[] = { "Animals", "Food", "Countries", "Hard Words", "All"};
		//Each array holds every possible word from each category
		final String animals[] = {"Alligator","Alpaca","Anaconda","Anteater","Antelope", "Armadillo","Aardvark","Baboon","Beaver","Bison","Beluga","Beetle","Bobcat","Buffalo","Butterfly","Blowfish","Bullfrog","Bumblebee","Badger","Barracuda", "Camel", "Cardinal","Caribou","Catfish","Caterpillar","Chameleon","Centipede","Chicken","Chihuahua","Chinchilla","Cockroach","Cuttlefish","Cheetah","Clownfish","Chimpanzee","Chipmunk","Cobra","Cougar","Coyote","Crocodile","Dingo","Dalmation","Duck","Donkey","Dolphin","Dragonfly","Eagle","Elephant","Flamingo","Ferret","Frog","Gazelle","Giraffe","Gopher","Gorilla","Gecko","Gerbil","Goat","Goose","Groundhog","Hawk","Hedgehog","Hamster","Hare","Hippopotamus","Horse","Human","Hummingbird","Hyena","Insect","Iguana","Impala","Jackal","Jaguar","Jellyfish","Kangaroo","Koala","Lemur","Leopard","Lizard","Llama","Lynx","Ladybug","Lion","Lobster","Labrador","Macaw","Mayfly","Mongoose","Mole","Millipede","Meerkat","Monkey","Moose","Mouse","Newt","Nightingale","Orca","Otter","Octopus","Ostich","Oyster","Orangutan","Parrot","Panther","Piranha","Panda","Peacock","Penguin","Pigeon","Platypus","Porcupine","Possum","Python","Quail","Rabbit","Raccoon","Raven","Rattlesnake","Reindeer","Rhinoceros","Robin","Salmon","Seal","Sheep","Skunk","Sloth","Snake","Snail","Shrimp","Sparrow","Spider","Squirrel","Shark","Scorpion","Stork","Swan","Tiger","Tarantula","Tortoise","Turkey","Turtle","Vulture","Wallaby","Warthog","Whale","Wildebeast","Woodpecker","Zebra"};
		final String food[] = {"Spinach", "Blueberry", "Spaghetti", "Cheeseburger", "Cucumber", "Sandwich", "Hummus", "Cabbage", "Eggplant", "Radish", "Lollipop", "Chocolate", "Vanilla", "Strawberry", "Raspberry", "Blackberry", "Kiwi","Potato","Lasagna","Steak","Chicken","Popsicle","Baguette","Cheesecake","Macaroni","Dumplings","Mushrooms","Peaches","Noodles","Burrito","Mango","Lemon","Meringue","Salad","Curry","Watermelon","Honeydew","Croissant","Honey","Pancake","Waffle","Omelette","Caramel","Salmon","Cherry","Cookie", "Brownie","Tomato","Pineapple","Custard","Bologna","Sriracha","Cheese","Nutella","Hazelut","Popcorn","Dragonfruit","Timbits","Quiche","Starfruit","Sushi","Quesadilla","Cantaloupe","Avocado","Guacamole","Salsa", "Beef","Wasabi","Pumpkin","Asparagus","Cauliflower","Sausage","Pickle","Orange","Donut","Cereal","Shrimp","Mayonnaise","Cashew","Almond","Zucchini","Caviar", "Perogi","Octopus","Scallops","Quinoa","Turnip","Squash","Parsnip","Parsley","Pepper","Poutine","Bacon","Bread","Cupcake","Falafel","Hummus","Gnocchi","Ginger","Jambalaya","Meatball","Pepperoni","Toast","Yogurt", "Walnut","Relish","Tortilla","Turkey","Pasta","Oatmeal","Granola","Ketchup","Chili","Syrup","Fajitas","Butter","Sorbet","Gelato","Lobster","Peanuts","Pistashio","Pastrami","Pretzel","Oyster","Salami","Candy","Cranberry","Casserole","Bruschetta","Mozzerella","Cheddar","Brie","Jello","Crepe","Bubblegum","Jawbreaker","Nougat","Pudding","Toffee","Churros","Scones","Danish","Bagels","Tempura"};
		final String countries[] = {"Afghanistan", "Andorra", "Argentina", "Austria", "Albania", "Angola", "Armenia", "Azerbaijan", "Algeria", "Australia", "Bahamas", "Barbados", "Belize", "Bolivia", "Brazil", "Bahrain", "Belarus", "Brunei", "Bangladesh", "Belgium", "Bhutan", "Botswana", "Bulgaria", "Burundi", "Cambodia", "Cameroon", "China", "Cyprus", "Canada", "Colombia", "Croatia", "Denmark", "Dominica", "Djibouti", "Ecuador", "Ethiopia", "Eritrea", "Finland", "France", "Germany", "Grenada", "Guatamela", "Guyana", "Geurgia", "Greece", "Guinea", "Honduras", "Hungary", "Iceland", "Israel", "Indonesia", "Ireland", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kyrgystan", "Kenya", "Kuwait", "Kiribati", "Liechtenstein", "Latvia", "Liberia", "Lithuania","Lebanon", "Luxembourg", "Macedonia", "Malaysia", "Mauritius", "Moldova", "Montenegro", "Myanmar", "Madagascar", "Maldives", "Mexico", "Monaco", "Morocco", "Mauritania", "Micronesia", "Mongolia", "Mozambique", "Netherlands", "Nigeria", "Nepal", "Nicaragua", "Norway", "Pakistan", "Panama", "Portugal", "Philippines", "Paraguay", "Poland", "Qatar", "Romania", "Russia", "Rwanda", "Senegal", "serbia", "Seychelles", "Singapore", "Slovakia", "Slovenia", "Somalia", "Spain", "Sudan", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Thailand", "Turkmenistan", "Tajikistan", "Tunisia", "Tanzania", "Turkey", "Tongo", "Uganda", "Ukraine", "Uruguay", "Uzbekistan", "Venezuala", "Vietnm", "Yemen", "Zambia", "Zimbabwe" };
		final String hardWords[] = {"Abruptly", "Absurd", "Abyss", "Affix", "Askew", "Avenue", "Awkward", "Azure", "Bagpipes", "Bandwagon", "Banjo", "Beekeeper", "Bikini", "Blitz", "Blizzard", "Boggle", "Bookworm", "Boxcar", "Buffoon", "Buzzing", "Buzzwords", "Cobweb", "Cockiness", "Croquet", "Crypt", "Cycle", "Disavow", "Dizzying", "Duplex", "Dwarves", "Embezzle", "Equip", "Espionage", "Exodus", "Faking", "Fixable", "Fjord", "Flopping", "Fluffiness", "Frazzled", "Fuschia", "Funny", "Galaxy", "Galvanize", "Gazebo", "Gizmo", "Glowworm", "Gnarly", "Gossip", "Grogginess", "Haiku", "Haphazard", "Hyphen", "Icebox", "Injury", "Ivory", "Jackpot", "Jaundice", "Jawbreaker", "Jaywalk", "Jazziest", "Jelly", "Jigsaw", "Jiujitsu", "Jockey", "Jogging", "Joking", "Jovial", "Joyful", "Juicy", "Jukebox", "Jumbo", "Kayak", "Kazoo", "Keyhole", "Khaki", "Kilobyte", "Kiosk", "Knapsack", "Larynx", "Lengths", "Lucky", "Luxury", "Matrix", "Microwave", "Mnemonic", "Mystify", "Nightclub", "Nowadays", "Numbskull", "Oxidize", "Oxygen", "Pajama", "Peekaboo", "Phlegm", "Pixel", "Pizazz", "Pneumonia", "Polka", "Psyche", "Puppy", "Puzzling", "Quartz", "Queue", "Quips", "Quizzes", "Quorum", "Rhubarb", "Rhythm", "Rickshaw", "Schnapps", "Scratch", "Snazzy", "Sphinx", "Spritz", "Squawk", "Strengths", "Stronghold", "Subway", "Swivel", "Syndrome", "Thumbscrew", "Topaz", "Transcript", "Transgression", "Transplant", "Twelfth", "Unknown", "Unworthy", "Unzip", "Uptown", "Vaporize", "Vixen", "Vodka", "Voodoo", "Vortex", "Walkway", "Waltz", "Wheezy", "Whiskey", "Whizzing", "Whomever", "Wimpy", "Witchcraft", "Wizard", "Woozy", "Wristwatch", "Zylophone", "Youthful", "Yummy", "Zigzag", "Zipper", "Zodiac", "Zombie" }; 
		
		//creates Jlabel for each hangman picture and resizes them to half the size 
		final int imageWidth = 432;
		final int imageHeight = 486;
		JLabel hangmanComplete = new JLabel();
		hangmanComplete.setIcon(new ImageIcon(new ImageIcon("res/Hangman 12.png").getImage().getScaledInstance(imageWidth*3/4, imageHeight*3/4, Image.SCALE_DEFAULT)));

		//Creates the different font settings
		Font titleFont = new Font("Serif", Font.BOLD, 50);
		Font regular = new Font("Serif", Font.BOLD, 18);
		Font blankTextFont = new Font("Monospaced", Font.BOLD, 15);
		Font endScreenFont = new Font ("Serif", Font.BOLD, 50);
		
		//Creates components of starting screen and sets a font for each
		JLabel title = new JLabel("Hangman", SwingConstants.CENTER); //Title of the game
		title.setFont(titleFont);
		JLabel topicLabel = new JLabel("Pick a topic", SwingConstants.CENTER); //Label that tells user to pick a topic
		topicLabel.setFont(regular);
		final JComboBox<Object> topicBox = new JComboBox<Object>(topics); //Combobox
		topicBox.setFont(regular);
		JButton topicButton = new JButton("Let's Play!"); //Button that begins the game
		topicButton.setFont(regular);
		
		//Creates components of the game screen
		final JTextField enterALetter = new JTextField(10); //Textfield to enter letters
		final JLabel blankTextLabel = new JLabel("", SwingConstants.CENTER); //Label that will have the _ _ for people to guess
		blankTextLabel.setFont(blankTextFont);
		final JLabel lettersGuessed = new JLabel("Letters Already Guessed: "); //Label that tells user letters already guessed
		final JLabel enterLetterLabel = new JLabel("Guess A Letter"); //Label that tells user to enter a letter
		final JLabel topicTitle = new JLabel("If you're reading this, something with my program messed up."); // tells user the category they have
		final JLabel hangmanDrawing = new JLabel();
		
		//Creates components of winning and losing screen
		final JLabel youLost = new JLabel("Game Over!"); //Label shown if you lose
		youLost.setFont(endScreenFont);
		final JLabel youWon = new JLabel("Congrats! You won!"); //Label shown if you win
		youWon.setFont(endScreenFont);
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		screen.setLayout(layout);
		jpanelOne.setLayout(layout);
		jpanelOne.setBackground(new Color(137,239,243));
		jpanelTwo.setLayout(layout);
		jpanelTwo.setBackground(new Color(137,239,243));
		gameOverScreen.setLayout(layout);
		gameOverScreen.setBackground(new Color (244, 66, 66));
		youWonScreen.setLayout(layout);
		youWonScreen.setBackground(new Color(95, 244, 66));
		
		constraints.insets = new Insets(10,30,10,10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0.6;
		constraints.weighty = 0.5;
		constraints.ipadx = 100;
		constraints.ipady = 40;
		jpanelOne.add(title, constraints);

		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.1;
		constraints.ipady = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		jpanelOne.add(topicLabel, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.weightx = 0.3;
		constraints.ipadx = 40;
		jpanelOne.add(topicBox, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.weighty = 0.4;
		constraints.ipadx = 50;
		constraints.ipady = 20;
		jpanelOne.add(topicButton, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.gridheight = 4;
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.weightx = 0.4;
		constraints.anchor = GridBagConstraints.CENTER;
		jpanelOne.add(hangmanComplete, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 0.5;
		constraints.weighty = 0.5;
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		jpanelTwo.add(topicTitle, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 6;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		jpanelTwo.add(blankTextLabel, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.weightx = 0.2;
		constraints.anchor = GridBagConstraints.EAST;
		jpanelTwo.add(enterLetterLabel, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.weightx = 0.4;
		constraints.ipadx = 50;
		jpanelTwo.add(enterALetter, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 4;
		jpanelTwo.add(lettersGuessed, constraints);
		
		constraints.insets = new Insets(0,0,0,0);
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 3;
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.weightx = 0.4;
		constraints.anchor = GridBagConstraints.EAST;
		jpanelTwo.add(hangmanDrawing, constraints);
		hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 1a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
		
		window.add(jpanelOne);

		final String randomWord[] = {" "};
		final String word[] = {" "};
		final StringBuilder blankText = new StringBuilder("                                       ");
		topicButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				topicTitle.setText(topicBox.getSelectedItem().toString());
				jpanelOne.setVisible(false);
				window.add(jpanelTwo);
				jpanelTwo.setVisible(true);
				if (topicBox.getSelectedItem() == "Animals")
				{
					word[0] = animals[(int)(Math.random()*animals.length)];
					randomWord[0] = word[0].toUpperCase();
				}
				if (topicBox.getSelectedItem() == "Food")
				{
					word[0] = food[(int)(Math.random()*food.length)];
					randomWord[0] = word[0].toUpperCase();
				}
				if (topicBox.getSelectedItem() == "Countries")
				{
					word[0] = countries[(int)(Math.random()*countries.length)];
					randomWord[0] = word[0].toUpperCase();
				}
				if (topicBox.getSelectedItem() == "Hard Words")
				{
					word[0] = hardWords[(int)(Math.random()*hardWords.length)];
					randomWord[0] = word[0].toUpperCase();
				}
				if (topicBox.getSelectedItem() == "All")
				{
					int randomCategory = (int)(Math.random()*3);
					if (randomCategory == 0)
					{
						word[0] = animals[(int)(Math.random()*animals.length)];
						randomWord[0] = word[0].toUpperCase();
					}
					else if (randomCategory == 1)
					{
						word[0] = food[(int)(Math.random()*food.length)];
						randomWord[0] = word[0].toUpperCase();
					}
					else if (randomCategory == 2)
					{
						word[0] = countries[(int)(Math.random()*countries.length)];
						randomWord[0] = word[0].toUpperCase();
					}
					else if (randomCategory == 4)
					{
						word[0] = hardWords[(int)(Math.random()*hardWords.length)];
						randomWord[0] = word[0].toUpperCase();
					}
				}
				for (int i = 0; i < randomWord[0].length()*2; i +=2)
				{
					blankText.setCharAt(i, '_');
					blankText.setCharAt(i+1, ' ');
				}
				blankTextLabel.setText(blankText.toString());
			}			
		});

		gameOverScreen.add(youLost);
		youWonScreen.add(youWon);
		final String[] guessedLetters = {""};
		final int[] wrongGuesses = {0};
		final boolean[] wrong = {true};	
		enterALetter.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				boolean correctGuess = false;
				boolean newLetter = true;
				for (int k = 0; k < guessedLetters[0].length(); k++)
				{
					if (guessedLetters[0].charAt(k) == enterALetter.getText().toUpperCase().charAt(0))
					{
						newLetter = false;
					}
				}
				if (newLetter)
				{
					guessedLetters[0] += enterALetter.getText().toUpperCase().charAt(0);
				}
				for (int j = 0; j < randomWord[0].length(); j++)
				{
					if (enterALetter.getText().toUpperCase().charAt(0) == randomWord[0].charAt(j))
					{
						blankText.setCharAt(j*2, enterALetter.getText().toUpperCase().charAt(0));
						correctGuess = true;
					}
				}
				if (newLetter == true && correctGuess == false)
				{
					wrongGuesses[0]++;
				}
				boolean noLettersLeft = false;
				for (int k = 0; k < blankText.length(); k++)
				{
					if (blankText.charAt(k) == '_')
					{
						noLettersLeft = true;
					}
				}
				if (wrongGuesses[0] == 1)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 2a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 2)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 3a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 3)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 4a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 4)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 5a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 5)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 6a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 6)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 7a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 7)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 8a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 8)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 9a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] == 9)
				{
					hangmanDrawing.setIcon((new ImageIcon(new ImageIcon("res/Hangman 10a.png").getImage().getScaledInstance(imageWidth/2, imageHeight/2, Image.SCALE_DEFAULT))));
				}
				else if (wrongGuesses[0] >= 10)
				{
					youLost.setText("Game Over! The word was " + word[0] + ".");
					window.add(gameOverScreen);
					jpanelTwo.setVisible(false);
					gameOverScreen.setVisible(true);
				}
				if (enterALetter.getText().toUpperCase().compareTo(randomWord[0]) == 0 || noLettersLeft == false)
				{
					window.add(youWonScreen);
					jpanelTwo.setVisible(false);
					youWonScreen.setVisible(true);
					wrong[0] = false;
				}
				blankTextLabel.setText(blankText.toString());
				lettersGuessed.setText("Letters Already Guessed: " + guessedLetters[0]);
			}
		});
		window.setVisible(true);
	}
}