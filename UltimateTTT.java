/**Ultimate Tic Tac Toe
 * James and Jordan
 * December 12, 2016
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import javax.sound.sampled.*;



public class UltimateTTT extends JFrame implements ActionListener{
  
  //Declare Key variables and GUI components
  JFrame gameFrame = new JFrame();
  JPanel background = new JPanel();
  JPanel gameScreen = new JPanel();
  JPanel instructionScreen = new JPanel();
  JPanel userName = new JPanel();
  JPanel leaderboard = new JPanel();
  BufferedImage backImage;
  BufferedImage backImageInstruction;
  BufferedImage instructionPic;
  BufferedImage playGamePic;
  BufferedImage leaderBoardPic;
  BufferedImage mainMenuPic;
  BufferedImage instrBoardPic;
  BufferedImage tttBoard;
  BufferedImage continueButtonPic;
  BufferedImage menuButtonUserNamePic;
  BufferedImage menuButtonGamePic;
  BufferedImage backUserNamePic;
  BufferedImage woodBack;
  BufferedImage backImageLeaderboard;
  BufferedImage menuButtonLeaderboardPic;
  static BufferedImage tttX;
  static BufferedImage tttO;
  JButton instructionButton;
  JButton playGameButton;
  JButton leaderBoardButton;
  JButton menuButton;
  JButton continueButton;
  JButton menuButtonUserName;
  JButton menuButtonGameScreen;
  JButton menuButtonLeaderboard;
  JLabel instructions;
  JLabel player1NameLabel = new JLabel ("Player 1 Name: ");
  JLabel player2NameLabel = new JLabel ("Player 2 Name: ");
  JLabel noNameMessage;
  JLabel invalidName;
  static JLabel tieMessage;
  static JLabel player1Win;
  static JLabel player2Win;
  static JLabel player1Turn;
  static JLabel player2Turn;
  static JLabel [] leaders = new JLabel [10];
  static JTextField player1NameField = new JTextField (20);
  static JTextField player2NameField = new JTextField (20);
  static JLabel how2win;
  static JButton [] miniBoard0 = new JButton [9];
  static int [] contentMiniBoard0 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard1 = new JButton [9];
  static int [] contentMiniBoard1 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard2 = new JButton [9];
  static int [] contentMiniBoard2 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard3 = new JButton [9];
  static int [] contentMiniBoard3 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard4 = new JButton [9];
  static int [] contentMiniBoard4 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard5 = new JButton [9];
  static int [] contentMiniBoard5 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard6 = new JButton [9];
  static int [] contentMiniBoard6 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard7 = new JButton [9];
  static int [] contentMiniBoard7 = {0,0,0,0,0,0,0,0,0};
  static JButton [] miniBoard8 = new JButton [9];
  static int [] contentMiniBoard8 = {0,0,0,0,0,0,0,0,0};
  static int [] contentMainBoard = {0,0,0,0,0,0,0,0,0};
  static Clip musicClip;
  static boolean allHighlighted;
  static int turnNum = 1;
  static int xTurnNum = 1;
  static int oTurnNum = 1;
  static int [] miniWinningSpots;
  static int [] playerLeaderboard = new int [9];
  static boolean exit = false;
  static UltimateTTT game;
  static String player1Name;
  static String player2Name;

  
  //Declare constructor for JFrame
  public UltimateTTT() {
    setTitle("Ultimate Tic Tac Toe");
    setSize (1268, 720);
    setResizable (false);
    
    //*****MENU SCREEN*****
    
    
    //Create Menu Screen Panel 
    background.setLayout(null);
    gameScreen.setLayout(null);
    instructionScreen.setLayout(null);
    userName.setLayout(null);
    leaderboard.setLayout(null);
    
    //Import images from file
    try {
      backImage = ImageIO.read(new File("BackImage.jpg"));
      backImageInstruction = ImageIO.read(new File("BackImage.jpg"));
      instructionPic = ImageIO.read(new File("Instructions.png"));
      playGamePic = ImageIO.read(new File("PlayGame.png"));
      leaderBoardPic = ImageIO.read(new File("LeaderBoard.png"));
      mainMenuPic = ImageIO.read(new File("MainMenu.png"));
      instrBoardPic = ImageIO.read(new File("instrBoard.jpg"));
      tttBoard = ImageIO.read(new File("uttt.jpg"));
      tttX = ImageIO.read(new File("TTT_X.png"));
      tttO = ImageIO.read(new File("TTT_O.png"));
      continueButtonPic = ImageIO.read(new File("continueButton.jpg"));
      backUserNamePic = ImageIO.read(new File ("BackImage.jpg"));
      menuButtonUserNamePic = ImageIO.read(new File("Button-Menu.jpg"));
      menuButtonGamePic = ImageIO.read(new File("Button-Menu.jpg"));
      woodBack = ImageIO.read(new File("Wood Background.jpg"));
      menuButtonLeaderboardPic = ImageIO.read(new File("Button-Menu.jpg"));
      backImageLeaderboard = ImageIO.read(new File("bulletinBoard.png"));
    }
    catch (IOException ex) {
      System.out.println ("Picture File(s) Not Found");
    }
    
    //Create JButtons for menu screen
    instructionButton = new JButton (new ImageIcon(instructionPic));
    playGameButton = new JButton (new ImageIcon(playGamePic));
    leaderBoardButton = new JButton (new ImageIcon(leaderBoardPic));

    
    //Set background picture as JLabel
    JLabel picLabel = new JLabel(new ImageIcon(backImage));
    JLabel picLabelInstr = new JLabel (new ImageIcon(backImageInstruction));
    
    //Set visibilities to true
    picLabel.setVisible(true);
    instructionButton.setVisible(true);
    playGameButton.setVisible(true);
    leaderBoardButton.setVisible(true);
    
    //Set bounds of the buttons
    instructionButton.setBounds (950, 520, 300, 60);
    playGameButton.setBounds (950, 440, 300, 60);
    leaderBoardButton.setBounds (950, 600, 300, 60);
    
    //Set bounds of background pic
    picLabel.setBounds(0, 0, 1268, 720);
    picLabelInstr.setBounds(0, 0, 1268, 720);
    
    //Set bounds of background panel
    background.setBounds(0, 0, 1268, 720);
    
    //Add action listeners
    playGameButton.addActionListener(this);
    instructionButton.addActionListener(this);
    leaderBoardButton.addActionListener(this);

    
    //Add components to background panel
    background.add(instructionButton);
    background.add(playGameButton);
    background.add(leaderBoardButton);
    
    background.add(picLabel);
    
    background.setVisible(true);
    
    
    //*****GAMESCREEN*****
    JLabel gameBoard = new JLabel(new ImageIcon(tttBoard));
    JLabel wood = new JLabel(new ImageIcon(woodBack));
    gameBoard.setVisible(true);
    wood.setVisible(true);
    
    gameScreen.setBounds (0, 0, 1268, 720);
    gameBoard.setBounds(0, 0, 1268, 720);
    wood.setBounds(0, 0, 1268, 720);
    
    //Create and set the buttons inside the mini boards on the top left
    //Declare the starting y coordinate
    int yCoordTopL = 110;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
      //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordTopL = 157;
      else if (i == 6)
        yCoordTopL = 204;
      
      //Set the index in the array to a new JButton
      miniBoard0[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
        //Set the bounds of the button
        miniBoard0[i].setBounds(385, yCoordTopL, 40, 40); 
        //Add action listeners to the buttons
        miniBoard0[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard0[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard0[i].setBounds(430, yCoordTopL, 40,40);
         //Add action listeners to the buttons
        miniBoard0[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard0[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard0[i].setBounds(475, yCoordTopL, 40, 40);
         //Add action listeners to the buttons
        miniBoard0[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard0[i]);
      }
    }
    
    //Create and set the buttons inside the mini boards on the top middle
    //Declare the starting y coordinate
    int yCoordTopM = 110;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordTopM = 157;
      else if (i == 6)
        yCoordTopM = 204;
      
      //Set the index in the array to a new JButton
      miniBoard1[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard1[i].setBounds(565, yCoordTopM, 40, 40); 
         //Add action listeners to the buttons
        miniBoard1[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard1[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard1[i].setBounds(610, yCoordTopM, 40,40);
         //Add action listeners to the buttons
        miniBoard1[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard1[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard1[i].setBounds(660, yCoordTopM, 40, 40);
         //Add action listeners to the buttons
        miniBoard1[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard1[i]);
      }
    }
    
    //Create and set the buttons for the top right mini board
    //Declare the starting y coordinate
    int yCoordTopR = 110;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordTopR = 157;
      else if (i == 6)
        yCoordTopR = 204;
      
      //Set the index in the array to a new JButton
      miniBoard2[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard2[i].setBounds(750, yCoordTopR, 40, 40); 
         //Add action listeners to the buttons
        miniBoard2[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard2[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard2[i].setBounds(795, yCoordTopR, 40,40);
         //Add action listeners to the buttons
        miniBoard2[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard2[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard2[i].setBounds(840, yCoordTopR, 40, 40);
         //Add action listeners to the buttons
        miniBoard2[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard2[i]);
      }
    }
    
    //Create and set the buttons for the middle left mini square
    //Declare the starting y coordinate
    int yCoordMidL = 293;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordMidL = 340;
      else if (i == 6)
        yCoordMidL = 385;
      
      //Set the index in the array to a new JButton
      miniBoard3[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard3[i].setBounds(385, yCoordMidL, 40, 40); 
         //Add action listeners to the buttons
        miniBoard3[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard3[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard3[i].setBounds(430, yCoordMidL, 40,40);
         //Add action listeners to the buttons
        miniBoard3[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard3[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard3[i].setBounds(475, yCoordMidL, 40, 40);
         //Add action listeners to the buttons
        miniBoard3[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard3[i]);
      }
    }
    
    //Create and set the buttons for the middle middle mini square
    //Declare the starting y coordinate
    int yCoordMidM = 293;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordMidM = 340;
      else if (i == 6)
        yCoordMidM = 385;
      
      //Set the index in the array to a new JButton
      miniBoard4[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard4[i].setBounds(565, yCoordMidM, 40, 40); 
         //Add action listeners to the buttons
        miniBoard4[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard4[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard4[i].setBounds(610, yCoordMidM, 40,40);
         //Add action listeners to the buttons
        miniBoard4[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard4[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard4[i].setBounds(660, yCoordMidM, 40, 40);
         //Add action listeners to the buttons
        miniBoard4[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard4[i]);
      }
    }
    
    //Create and set the buttons for the middle right mini square
    //Declare the starting y coordinate
    int yCoordMidR = 293;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordMidR = 340;
      else if (i == 6)
        yCoordMidR = 385;
      
      //Set the index in the array to a new JButton
      miniBoard5[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard5[i].setBounds(750, yCoordMidR, 40, 40); 
         //Add action listeners to the buttons
        miniBoard5[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard5[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard5[i].setBounds(795, yCoordMidR, 40,40);
         //Add action listeners to the buttons
        miniBoard5[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard5[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard5[i].setBounds(840, yCoordMidR, 40, 40);
         //Add action listeners to the buttons
        miniBoard5[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard5[i]);
      }
    }
    
    //Create and set the buttons for the bottom left mini square
    //Declare the starting y coordinate
    int yCoordBotL = 476;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordBotL = 523;
      else if (i == 6)
        yCoordBotL = 570;
      
      //Set the index in the array to a new JButton
      miniBoard6[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard6[i].setBounds(385, yCoordBotL, 40, 40); 
         //Add action listeners to the buttons
        miniBoard6[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard6[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard6[i].setBounds(430, yCoordBotL, 40,40);
         //Add action listeners to the buttons
        miniBoard6[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard6[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard6[i].setBounds(475, yCoordBotL, 40, 40);
         //Add action listeners to the buttons
        miniBoard6[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard6[i]);
      }
    }
    
    //Create and set the buttons for the bottom middle mini square
    //Declare the starting y coordinate
    int yCoordBotM = 476;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordBotM = 523;
      else if (i == 6)
        yCoordBotM = 570;
      
      //Set the index in the array to a new JButton
      miniBoard7[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard7[i].setBounds(565, yCoordBotM, 40, 40); 
         //Add action listeners to the buttons
        miniBoard7[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard7[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard7[i].setBounds(610, yCoordBotM, 40,40);
         //Add action listeners to the buttons
        miniBoard7[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard7[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard7[i].setBounds(660, yCoordBotM, 40, 40);
         //Add action listeners to the buttons
        miniBoard7[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard7[i]);
      }
    }
    
    //Create and set the buttons for the bottom right mini square
    //Declare the starting y coordinate
    int yCoordBotR = 476;
    //For loop to search the array 
    for (int i = 0; i <= 8; i++)
    { 
       //Depending on the array index change the y coordinate value
      if (i == 3)
        yCoordBotR = 523;
      else if (i == 6)
        yCoordBotR = 570;
      
      //Set the index in the array to a new JButton
      miniBoard8[i] = new JButton ("");
      
      //Depending on the index set the bounds of the button
      if (i == 0 || i == 3 || i == 6)
      {
         //Set the bounds of the button
        miniBoard8[i].setBounds(750, yCoordBotR, 40, 40); 
         //Add action listeners to the buttons
        miniBoard8[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard8[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 1 || i == 4 || i == 7)
      {
         //Set the bounds of the button
        miniBoard8[i].setBounds(795, yCoordBotR, 40,40);
         //Add action listeners to the buttons
        miniBoard8[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard8[i]);
      }
      //Depending on the index set the bounds of the button
      else if (i == 2 || i == 5 || i == 8)
      {
         //Set the bounds of the button
        miniBoard8[i].setBounds(840, yCoordBotR, 40, 40);
         //Add action listeners to the buttons
        miniBoard8[i].addActionListener(this);
        //Add the button to the gameScreen panel
        gameScreen.add(miniBoard8[i]);
      }
    }
    
    //Menu Button
    menuButtonGameScreen = new JButton (new ImageIcon (menuButtonGamePic));
    menuButtonGameScreen.setVisible(true);
    menuButtonGameScreen.setBounds(1075, 600, 173, 65);
    menuButtonGameScreen.addActionListener(this);
    
    gameScreen.add(menuButtonGameScreen);
    
    //Tie Message
    tieMessage = new JLabel("The Game has Ended in a Tie!");
    tieMessage.setForeground (Color.WHITE);
    tieMessage.setFont(new Font("Arial", Font.BOLD, 20));
    tieMessage.setBounds(950, 300, 400, 100);
    tieMessage.setVisible(false);
    
    //Player 1 win
    player1Win = new JLabel("");
    player1Win.setForeground(Color.BLUE);
    player1Win.setFont(new Font("Arial", Font.BOLD, 20));
    player1Win.setBounds(915, 300, 400, 100);
    player1Win.setVisible(false);
    
    //Player 2 win
    player2Win = new JLabel("");
    player2Win.setForeground(Color.BLACK);
    player2Win.setFont(new Font("Arial", Font.BOLD, 20));
    player2Win.setBounds(915, 300, 400, 100);
    player2Win.setVisible(false);
    
    //Player 1 turn
    player1Turn = new JLabel("");
    player1Turn.setForeground(Color.BLUE);
    player1Turn.setFont(new Font("Arial", Font.BOLD, 20));
    player1Turn.setBounds(230, 200, 400, 100);
    player1Turn.setVisible(true);
    
    //Player 2 turn
    player2Turn = new JLabel("");
    player2Turn.setForeground(Color.BLACK);
    player2Turn.setFont(new Font("Arial", Font.BOLD, 20));
    player2Turn.setBounds(230, 400, 400, 100);
    player2Turn.setVisible(false);
    
    //Add components to the game screen
    gameScreen.add(tieMessage);
    gameScreen.add(player1Win);
    gameScreen.add(player2Win);
    gameScreen.add(player1Turn);
    gameScreen.add(player2Turn);
    
    //When the game begins set each button to highlight
    highlightAll();
    
    //Add the gameplay board to the gameplay screen
    gameScreen.add(gameBoard);
    
    //Add the background to the gameplay screen
    gameScreen.add(wood);
    
    //Set visibility to false to make sure the screen only appears when the user presses the play game button
    gameScreen.setVisible(false);
    
    //*****INSTRUCTION SCREEN*****
    
    //Create Buttons
    menuButton = new JButton (new ImageIcon(mainMenuPic));
    
    //Create JLabel for instructions
    instructions = new JLabel ("<html>Player 1 is X <br> Player 2 is O <br> <br> Player 1 starts the game by placing and X in any one of the 81 squares.<br><br>Player 2 then follows by placing an O on any of the 9 squares on the mini board that mirrors the selection of Player 1.<br><br>The game continues alternating between Player 1 and Player 2 following the same pattern<html>", JLabel.RIGHT);
    instructions.setForeground (Color.blue);
    instructions.setFont(new Font("Arial", Font.BOLD, 20));
    
    //Create JLabel for how to win
    how2win = new JLabel ("<html>How to win:<br>Win a mini board by getting three in a row for the large 3x3 board. Get 3 in<br>a row on the big board to win the<br>game!<html>");
    how2win.setForeground(Color.blue);
    how2win.setBackground(Color.white);
    how2win.setFont(new Font("Arial", Font.BOLD, 20));
    
    //Create JLabel to display example board
    JLabel instrBoardLabel = new JLabel(new ImageIcon(instrBoardPic));
    
    //Set bounds of components
    menuButton.setBounds(960, 600, 300, 60);
    instructions.setBounds (800, 20, 400, 320);
    how2win.setBounds (610, 400, 400, 400);
    instrBoardLabel.setBounds(920, 340, 200, 200);
    
    //Add action listener
    menuButton.addActionListener(this);
    
    //Set bounds of instruction screen panel
    instructionScreen.setBounds(0, 0, 1268, 720);
    
    //Add components to instruction screen panel
    instructionScreen.add(menuButton);
    instructionScreen.add(instructions);
    instructionScreen.add(how2win);
    instructionScreen.add(instrBoardLabel);
    instructionScreen.add(picLabelInstr);
    
    
    //Set visibilty to false
    instructionScreen.setVisible(false);
    
    //****USER NAME SCREEN****
    //Set the background of the user name screen to a JLabel
    JLabel backgroundUserName = new JLabel (new ImageIcon (backUserNamePic));
    
    //Set the continue and the menu button to an image 
    continueButton = new JButton (new ImageIcon(continueButtonPic));
    menuButtonUserName = new JButton (new ImageIcon (menuButtonUserNamePic));
    
    //If the user doesn't enter a name before playing then this message will appear
    noNameMessage = new JLabel ("Please enter a valid name in each field");
    
    //If the user's inputted names contain no letters, are over 10 characters, or contain the word empyu
    //This message will appear
    invalidName = new JLabel ("<html>Names must contain 1 letter<br>Be less than 10 characters<br>Not contain the word &#34EMPTY&#34<html>");
    
    //Set visibility of components to true
    continueButton.setVisible(true);
    backgroundUserName.setVisible(true);
    player1NameLabel.setVisible(true);
    player1NameField.setVisible(true);
    player2NameLabel.setVisible(true);
    player2NameField.setVisible(true);
    menuButtonUserName.setVisible(true);
    
    //Set the bounds for components
    continueButton.setBounds(930, 475, 173, 65);
    backgroundUserName.setBounds(0,0,1268,720);
    userName.setBounds(0, 0, 1268, 720);
    menuButtonUserName.setBounds(930,550,173,65);
    player1NameLabel.setBounds(800,150,400,100);
    player1NameField.setBounds(940,175,150,50);
    player2NameLabel.setBounds(800,250,400,100);
    player2NameField.setBounds(940,275,150,50);
    noNameMessage.setBounds(820, 400, 400, 100);
    invalidName.setBounds(885, 300, 400, 200);
    
    
    //Set the font colour and size of the no name message as well as messages for where the user inputs their name
    player1NameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    player1NameLabel.setForeground(Color.BLUE);
    
    player2NameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
    player2NameLabel.setForeground(Color.BLUE);
    
    player1NameField.setFont(new Font("Arial", Font.PLAIN, 20));
    
    player2NameField.setFont(new Font("Arial", Font.PLAIN, 20));
    
    
    noNameMessage.setForeground (Color.darkGray);
    noNameMessage.setFont(new Font("Arial", Font.BOLD, 20));
    noNameMessage.setVisible(false);
    
    invalidName.setForeground (Color.darkGray);
    invalidName.setFont(new Font ("Arial", Font.BOLD, 20));
    invalidName.setVisible(false);
    
    //Add action listener
    continueButton.addActionListener(this);
    menuButtonUserName.addActionListener(this);
    
    //Add componenst to the panel 
    userName.add(player1NameLabel);
    userName.add(player2NameLabel);
    userName.add(player1NameField);
    userName.add(player2NameField);
    userName.add(continueButton);
    userName.add(menuButtonUserName);
    userName.add(noNameMessage);
    userName.add(invalidName);
    
    //Add the background
    userName.add(backgroundUserName);
    
    //Set the visibility to false so it only appears when the user hits the play game button on the menu
    userName.setVisible(false);
    
    //***************LEADERBOARD***************
    //Set the leaderboard background and the title for the screen to JLabel
    JLabel picLabelLeaderboard = new JLabel (new ImageIcon (backImageLeaderboard));
    JLabel title = new JLabel ("ULTIMATE TIC TAC TOE LEADERBOARD");
    
    //Set the menu button on the screen to menu button image
    menuButtonLeaderboard = new JButton (new ImageIcon (menuButtonLeaderboardPic));
    
    //Set the components to visible when the user views the screen
    menuButtonLeaderboard.setVisible(true);
    picLabelLeaderboard.setVisible(true);
    title.setVisible(true);
    
    //Set the bounds of the components that appear on the screen
    picLabelLeaderboard.setBounds(0,0,1268,700);
    menuButtonLeaderboard.setBounds(930,550,175,65);
    title.setBounds(250, 80, 800, 100);
    
    //Set the colour and size of the title of the leaderboard screen
    title.setForeground (Color.RED);
    title.setFont(new Font("Arial", Font.BOLD, 40));
    
    //Loop to output peoples ranking on the leaderboard 
    for (int z = 0; z <= 9; z++)
    {
      //Set the string to an empty variable
      leaders[z] = new JLabel ("");
      
      //Set the visiblty of the leaderboard to true
      leaders[z].setVisible(true);
      
      //Set bounds for where the leaderboard placements will appear
      leaders[z].setBounds (600, 140 + 40*z, 300, 100);
      
      //Set the colour of the fonts
      leaders[z].setForeground(Color.RED);
      
      //Set the font type and size
      leaders[z].setFont(new Font("Arial", Font.PLAIN, 20));
      
      //Add the leaderboard placements to the screen
      leaderboard.add(leaders[z]);
    }//end of for loop
    
    //Initially create the leaderboard by reading from a txt file
    try {
    updateLeaderboard (0);
    } catch (IOException e) {
      System.out.println("Leaderboard Error");
    }
    
    //Add action listener to the menu button on the leaderboard
    menuButtonLeaderboard.addActionListener(this);
    
    //Add components to the leaderboard
    leaderboard.add(menuButtonLeaderboard);
    leaderboard.add(title);
    leaderboard.add(picLabelLeaderboard);
    
    //Set screen visibility to false
    leaderboard.setVisible(false);

    
    //Play music for main menu
    try{
    playMusic("MenuMusic.wav");
    }catch(IOException ex){
    }catch(LineUnavailableException ee){ 
    }catch(UnsupportedAudioFileException eee){ 
    }
    
    
    //Add components to JFrame
    add(userName);
    add(instructionScreen);
    add(gameScreen);
    add(background);
    add(leaderboard);
    setVisible (true);
    

  }//end of constructor
    
  //Action Listener
  public void actionPerformed(ActionEvent event) {
   JButton buttonPressed;
   
   //If a button in the game is pressed then continue to determine what the game does
   if (event.getSource() instanceof JButton) {
     buttonPressed = (JButton) (event.getSource());
     
     
     //Loop to check what button was pressed during gameplay
     //Initiate code to be executed when a gameplay button is pressed and send appropriate perameters to method
     for (int j = 0; j <= 8; j++)
     {
       if (buttonPressed.equals(miniBoard0 [j])) {
         miniBoardClickProc (contentMiniBoard0, j, miniBoard0, 0);
       }
       else if (buttonPressed.equals(miniBoard1 [j])) {
         miniBoardClickProc (contentMiniBoard1, j, miniBoard1, 1);
       }
       else if (buttonPressed.equals(miniBoard2 [j])) {
         miniBoardClickProc (contentMiniBoard2, j, miniBoard2, 2);
       }
       else if (buttonPressed.equals(miniBoard3 [j])) {
         miniBoardClickProc (contentMiniBoard3, j, miniBoard3, 3);
       }
       else if (buttonPressed.equals(miniBoard4 [j])) {
         miniBoardClickProc (contentMiniBoard4, j, miniBoard4, 4);
       }
       else if (buttonPressed.equals(miniBoard5 [j])) {
         miniBoardClickProc (contentMiniBoard5, j, miniBoard5, 5);
       }
       else if (buttonPressed.equals(miniBoard6 [j])) {
         miniBoardClickProc (contentMiniBoard6, j, miniBoard6, 6);
       }
       else if (buttonPressed.equals(miniBoard7 [j])) {
         miniBoardClickProc (contentMiniBoard7, j, miniBoard7, 7);
       }
       else if (buttonPressed.equals(miniBoard8 [j])) {
         miniBoardClickProc (contentMiniBoard8, j, miniBoard8, 8);
       }
       
       
       
     }//end of for loop
     
     //If the user presses the play game button on the menu screen then set the menu to false and noNameMessage
     //and make userName screen visible
     if (buttonPressed.equals(playGameButton)) {
       background.setVisible(false);
       noNameMessage.setVisible(false);
       invalidName.setVisible(false);
       userName.setVisible(true);
     }
     
     //If the user presses continue button on the userName screen then check if the user has input a name
     else if (buttonPressed.equals(continueButton)) {
       if (player1NameField.getText().isEmpty() || player2NameField.getText().isEmpty() ) {
         
         //If the user didn't add a name then keep the userName screen to true
         noNameMessage.setVisible(true);
         invalidName.setVisible(false);
       }//end of if
       
       
       //Else if the user input a name then add the name to varibales and output a message after each move
       else {
         
         player1Name = player1NameField.getText();
         player2Name = player2NameField.getText();
         
         if (!Character.isLetterOrDigit(player1Name.charAt(0)) || !Character.isLetterOrDigit(player2Name.charAt(0)) ||
             player1Name.length() > 10 || player2Name.length() > 10 || player1Name.toUpperCase().contains("EMPTY") || player2Name.toUpperCase().contains("EMPTY")) {
           invalidName.setVisible(true);
           noNameMessage.setVisible(false);
         }//end of if
         
         else {
           player1NameField.setText("");
           player2NameField.setText("");
           
           player1Turn.setText("<html>" + player1Name + ", <br> it's your turn!<html>");
           player2Turn.setText("<html>" + player2Name + ", <br> it's your turn!<html>");
           
           //Set the userName screen to false and game screen to true
           userName.setVisible(false);
           gameScreen.setVisible(true);
           
           //Stop Main Menu Music
           try {
             stopMusic();
           } catch (IOException ex){}
           catch (LineUnavailableException ee) {}
           catch (UnsupportedAudioFileException eee) {}
           
           //Play Game Music
           try{
             playMusic("GameMusic.wav");
           }catch(IOException ex){
           }catch(LineUnavailableException ee){ 
           }catch(UnsupportedAudioFileException eee){ 
           }
         }
       }
     }//end of if user pressed continue to game button
     
     //If the button pressed is instructionButton then make menu screen visiblity to false and instruction screen 
     //visiblity to true
     else if (buttonPressed.equals(instructionButton)) {
       background.setVisible(false);
       instructionScreen.setVisible(true);
     }
     
     //If the user presses the leaderboard button then set menu screen visiblity to false, read in from the txt file
     //and set the leaderboard visiblity to true
     else if (buttonPressed.equals(leaderBoardButton)) {
       background.setVisible(false);
       try {
       updateLeaderboard(0);
       } catch (IOException e) {
         System.out.println ("Leaderboard Error");
       }
       leaderboard.setVisible(true);
     }
     
     //If the user presses the menu button on the leaderboard then make the leaderboard screen visiblity false and menu
     //screen visiblilty to true
     else if (buttonPressed.equals(menuButtonLeaderboard)){
       leaderboard.setVisible(false);
       background.setVisible(true); 
     }
     
     //If the button pressed is the menu button on the instruction screen then make instruction screen visibilty to 
     //false and menu screen visibilty to true
     else if (buttonPressed.equals(menuButton)) {
      instructionScreen.setVisible(false);
      background.setVisible(true);
     }
     
     //If the menu button on the user name screen is pressed then make the user name screen visibilty to false and
     //menu screen visibilty to true
     else if (buttonPressed.equals(menuButtonUserName)) {
       player1NameField.setText("");
       player2NameField.setText("");
       userName.setVisible(false);
       background.setVisible(true);
     }
     
     //If the menu button on the gameplay screen is pressed make the gameplay screen visiblity to false 
     //make menu screen visibilty to true and reset the gameplay screen so if the user wants to play they get a new 
     //game
     else if (buttonPressed.equals(menuButtonGameScreen)) {
       gameScreen.setVisible(false);
       background.setVisible(true);
       gameOver(false);
       resetGame();
       
       //Stop Game Music
       try {
       stopMusic();
       } catch (IOException ex){}
       catch (LineUnavailableException ee) {}
       catch (UnsupportedAudioFileException eee) {}
       
       //Play Main Menu Music
       try{
       playMusic("MenuMusic.wav");
       }catch(IOException ex){
       }catch(LineUnavailableException ee){ 
       }catch(UnsupportedAudioFileException eee){ 
       }
     }
   }//end of if
   
  }//end of action listener
  
  //Method to play music
  public static void playMusic (String fileName) throws IOException, LineUnavailableException, UnsupportedAudioFileException
  {
    try {
     File mainMenu = new File(fileName);
     AudioInputStream inputStream = AudioSystem.getAudioInputStream(mainMenu);
     musicClip = AudioSystem.getClip();
     musicClip.open(inputStream);
     musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    catch (Exception musicEx){
     System.out.println("Audio File Error"); 
    }
    //musicClip.stop()
  }
  
  //Method to stop music
  public static void stopMusic() throws IOException, LineUnavailableException, UnsupportedAudioFileException
  {
    musicClip.stop();
    musicClip.close();
  }
  
  
    
  //**METHOD**  
  public static JButton [] nextBoard (int boardIndex)
  {
    if (boardIndex == 0)
      return miniBoard0;
    else if (boardIndex == 1)
      return miniBoard1;
    else if (boardIndex == 2)
      return miniBoard2;
    else if (boardIndex == 3)
      return miniBoard3;
    else if (boardIndex == 4)
      return miniBoard4;
    else if (boardIndex == 5)
      return miniBoard5;
    else if (boardIndex == 6)
      return miniBoard6;
    else if (boardIndex == 7)
      return miniBoard7;
    else if (boardIndex == 8)
      return miniBoard8;
    else
      return (null);
  }//end of nextBoard
  
  //**METHOD** ----- MAY NOT NEED THIS METHOD
  public static int [] nextContent (int contentIndex)
  {
    if (contentIndex == 0)
      return contentMiniBoard0;
    else if (contentIndex == 1)
      return contentMiniBoard1;
    else if (contentIndex == 2)
      return contentMiniBoard2;
    else if (contentIndex == 3)
      return contentMiniBoard3;
    else if (contentIndex == 4)
      return contentMiniBoard4;
    else if (contentIndex == 5)
      return contentMiniBoard5;
    else if (contentIndex == 6)
      return contentMiniBoard6;
    else if (contentIndex == 7)
      return contentMiniBoard7;
    else if (contentIndex == 8)
      return contentMiniBoard8;
    else if (contentIndex == 9)
      return contentMainBoard;
    else
      return (null);
  }//end of nextContent

  
  //**METHOD** 
  public static void highlightBox (JButton [] miniBoard, int nextBoardIndex, int [] currentContent, int currentBoardIndex)
  {
    //DESCRIPTION:
    //Determines based on the users last move,
    //Which mini board is to be played on by current player
    //And set that panel's background green
    
    //Method will be called after every turn to highlight the appropriate miniBoard for the next turn
    
    //Set background of panel*Y* to the default background colour
    if (contentMainBoard[currentBoardIndex] == 0 || contentMainBoard[currentBoardIndex] == 3) {
      for (int k = 0; k <= 8; k++)
      {
        miniBoard [k].setBackground(null); 
        miniBoard [k].setEnabled(false);
      }//end of for loop
    }//end of if

      //Set background of all panels to green
    JButton [] nextMiniBoard = nextBoard(nextBoardIndex);
    
    if (contentMainBoard [nextBoardIndex] > 0)
      highlightAll();
    
    
    
    //Else
      //Set background of panelx to green when user's last click was miniBoard*Y* [x]
        // x represents the index of the array for the mini board and the panel number of the ultimate board
        // *Y* represents the mini board that was last played on
        //For example: if player 2's selection was miniBoard4 [5], highlight panel5 green
    else {
      if (allHighlighted)
        nullAll();
      for (int k = 0; k<= 8; k++) {
       nextMiniBoard [k].setBackground(Color.YELLOW);
       nextMiniBoard [k].setEnabled(true);
      }//end of for loop
    }//end of else
  }//end of highlightBox
  
  //**METHOD**
  public static void highlightAll()
  {
   JButton [] nextHighlightedBoard;
   for (int i = 0; i <= 8; i++)
   {
     if (contentMainBoard [i] == 0)
     {
       nextHighlightedBoard = nextBoard(i);
       for (int j = 0; j <= 8; j++)
       {
         nextHighlightedBoard [j].setBackground(Color.YELLOW);
         nextHighlightedBoard [j].setEnabled(true);
       }//end of for loop
     }//end of if
   }//end of for loop
   allHighlighted = true;
  }//end of highlightAll
  
  //**METHOD
  public static void nullAll()
  {
    JButton [] nextNulledBoard;
    for (int i = 0; i <= 8; i++)
    {
      if (contentMainBoard [i] == 0)
      {
        nextNulledBoard = nextBoard(i);
        for (int j = 0; j <= 8; j++) 
        {
          nextNulledBoard [j].setBackground(null);
          nextNulledBoard [j].setEnabled(false);
        }//end of for loop
      }//end of if
    }//end of for loop
    allHighlighted = false;
  }//end of nullAll
  
  
  //**METHOD**
  public static void advanceTurn()
  {
    //DESCRIPTION:
    //Advances the turn to determine which player goes next
    
    //Method will be called after every turn to determine which player is going next
    
    //If previous turn was 1 
    if (turnNum == 1){
      //Set turn number to 2
      turnNum = 2;
      //Add to the x players turn
      xTurnNum++;
      //The turn message for player 1 is set to false
      player1Turn.setVisible(false);
      //Turn message for player 2 is set to true
      player2Turn.setVisible(true);
    }
    else {
      //Set current turn to 1
      turnNum = 1;
      //Add 1 to o players turn number
      oTurnNum++;
      //Set the player 2 turn message to false
      player2Turn.setVisible(false);
      //Set player 1 turn message to true
      player1Turn.setVisible(true);
    }
  }//end of advanceTurn
  
  //**METHOD**
  public static void placePicture(JButton [] currentBoard, int index)
  {
    //If player 1 is taking their turn then set the board they click on to the x image icon
    if (turnNum == 1) 
     currentBoard[index].setIcon(new ImageIcon(tttX)); 
    else if (turnNum == 2)
      currentBoard[index].setIcon(new ImageIcon(tttO));
  }//end of placePicture
  
  //**METHOD**
  public static void updateMiniContent (int [] currentBoard, int index)
  {
    if (turnNum == 1)
      currentBoard [index] = 1;
    else if (turnNum == 2)
      currentBoard [index] = 2;
  }//end of updateMiniContent
  
  //**METHOD**
  public static void removeListener (JButton [] currentMiniBoard, int buttonIndex)
  {
    for (ActionListener button : currentMiniBoard[buttonIndex].getActionListeners())
      currentMiniBoard[buttonIndex].removeActionListener(button); 
  }
  
  //**METHOD**
  public static void addListener (JButton [] currentMiniBoard, int buttonIndex)
  {
     currentMiniBoard[buttonIndex].addActionListener(game);
  }
  
  //**METHOD**
  public static void miniBoardClickProc (int [] content, int index, JButton [] currentBoard, int mainBoardIndex)
  {
    boolean gameWon = false;
    
    placePicture (currentBoard, index);//currentButton
    removeListener (currentBoard, index);
    updateMiniContent (content, index);//content, index
    
    gameWon = checkWinner(content, mainBoardIndex);
    
    if (gameWon) {
      highlightMini(currentBoard, miniWinningSpots);
      gameWon = checkWinner(contentMainBoard, 9);
    }
    
    else {
      checkFill(content, mainBoardIndex);
      checkAllFill();
    }
   
    if (!gameWon) {
      advanceTurn();
      highlightBox (currentBoard, index, content, mainBoardIndex);//currentBoard
      
    }
    else if (gameWon) {
      gameOver(true);
    }
  }//end of miniBoardClickProc
  
  //**METHOD**
  public static int findContentIndex (int [] currentMiniBoard)
  {
   if (currentMiniBoard.equals(contentMiniBoard0))
     return 0;
   else if (currentMiniBoard.equals(contentMiniBoard1))
     return 1;
   else if (currentMiniBoard.equals(contentMiniBoard2))
     return 2;
   else if (currentMiniBoard.equals(contentMiniBoard3))
     return 3;
   else if (currentMiniBoard.equals(contentMiniBoard4))
     return 4;
   else if (currentMiniBoard.equals(contentMiniBoard5))
     return 5;
   else if (currentMiniBoard.equals(contentMiniBoard6))
     return 6;
   else if (currentMiniBoard.equals(contentMiniBoard7))
     return 7;
   else if (currentMiniBoard.equals(contentMiniBoard8))
     return 8;
   else
     return (100);
  }
  
  //**METHOD** 
  public static boolean checkWinner (int [] miniBoardContent, int mainBoardIndex)
  {
    //DESCRIPTION:
    //Checks to see if a board of 3x3 tic tac toe has been won by a player
    //Method is able to check mini boards and ultimate board (the ultimateBoard will still be referred to a miniBoard
      //locally in this method)
    //*Y* represents which miniBoard is being checked, determined by the parameter
    
    //Method will be called after every turn to see if the previous turn resulted in a miniBoard or the ultimate board
    //Being won
    
    //int mainBoardIndex = findContentIndex(miniBoardContent)
    boolean boardWon = false;
    
    //Check all possibilities of a winning board
    if (miniBoardContent [0] == miniBoardContent [1] && miniBoardContent [0] == miniBoardContent [2] && miniBoardContent [0] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {0, 1, 2};
    }
    else if (miniBoardContent [0] == miniBoardContent [3] && miniBoardContent [0] == miniBoardContent [6] && miniBoardContent [0] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {0, 3, 6};
    }
    else if (miniBoardContent [0] == miniBoardContent [4] && miniBoardContent [0] == miniBoardContent [8] && miniBoardContent [0] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {0, 4, 8};
    }
    else if (miniBoardContent [3] == miniBoardContent [4] && miniBoardContent [3] == miniBoardContent [5] && miniBoardContent [3] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {3, 4, 5};
    }
    else if (miniBoardContent [6] == miniBoardContent [7] && miniBoardContent [6] == miniBoardContent [8] && miniBoardContent [6] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {6, 7, 8};
    }
    else if (miniBoardContent [1] == miniBoardContent [4] && miniBoardContent [1] == miniBoardContent [7] && miniBoardContent [1] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {1, 4, 7};
    }
    else if (miniBoardContent [2] == miniBoardContent [5] && miniBoardContent [2] == miniBoardContent [8] && miniBoardContent [2] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {2, 5, 8};
    }
    else if (miniBoardContent [2] == miniBoardContent [4] && miniBoardContent [2] == miniBoardContent [6] && miniBoardContent [2] > 0) {
      boardWon = true;
      miniWinningSpots = new int [] {2, 4, 6};
    }
    
    if (mainBoardIndex != 9) {
      if (boardWon && turnNum == 1)
        contentMainBoard[mainBoardIndex] = 1;
      else if (boardWon && turnNum ==2)
        contentMainBoard[mainBoardIndex] = 2;
    }
    
    if (boardWon)
      return true;
    else
      return false;
  }
  
  //**METHOD**
  public static void highlightMini (JButton [] winningMini, int [] winningSpots)
  {
   for (int l = 0; l <= 8; l++)
   {
     winningMini[l].setBackground(null);
     winningMini[l].setEnabled(false);
   }//end of for
   
   for (int h = 0; h <= 2; h++)
   {
     winningMini[winningSpots[h]].setEnabled(true);
   }//end of for loop
  }
  
  //**METHOD**
  public static void checkFill(int [] contentMiniBoard, int mainBoardIndex)
  {
    boolean boardFilled = true;
    
    for (int i = 0; i <= 8; i++) {
      if (contentMiniBoard[i] == 0)
        boardFilled = false;
    }//end of for loop
    
    if (boardFilled) {
      contentMainBoard[mainBoardIndex] = 3;
    }
      
  }
  
  //**METHOD**
  public static void checkAllFill()
  {
   boolean mainBoardFull = true;
   
   for (int y = 0; y <= 8; y++)
   {
     if (contentMainBoard[y] == 0)
       mainBoardFull = false;
   }
   
   if (mainBoardFull)
     gameOver(true);
   
  }
  
  //**METHOD**
  public static void gameOver(boolean gameEnded)
  {
   nullAll();
   JButton [] nextHighlightedBoard;
   for (int i = 0; i <= 8; i++)
   {
       nextHighlightedBoard = nextBoard(i);
       for (int j = 0; j <= 8; j++)
       {
         removeListener(nextHighlightedBoard, j);
       }//end of for loop
   }//end of for loop
   determineWinner(gameEnded);
  }
  
  //**METHOD**
  public static void determineWinner(boolean gameEnded)
  {
    int [] winningBoards = {10};
    
    if (contentMainBoard [0] == contentMainBoard [1] && contentMainBoard [0] == contentMainBoard [2] && contentMainBoard [0] == turnNum)
      winningBoards = new int [] {0, 1, 2};
    else if (contentMainBoard [0] == contentMainBoard [3] && contentMainBoard [0] == contentMainBoard [6] && contentMainBoard [0] == turnNum)
      winningBoards = new int [] {0, 3, 6};
    else if (contentMainBoard [0] == contentMainBoard [4] && contentMainBoard [0] == contentMainBoard [8] && contentMainBoard [0] == turnNum)
      winningBoards = new int [] {0, 4, 8};
    else if (contentMainBoard [3] == contentMainBoard [4] && contentMainBoard [3] == contentMainBoard [5] && contentMainBoard [3] == turnNum)
      winningBoards = new int [] {3, 4, 5};
    else if (contentMainBoard [6] == contentMainBoard [7] && contentMainBoard [6] == contentMainBoard [8] && contentMainBoard [6] == turnNum)
      winningBoards = new int [] {6, 7, 8};
    else if (contentMainBoard [1] == contentMainBoard [4] && contentMainBoard [1] == contentMainBoard [7] && contentMainBoard [1] == turnNum)
      winningBoards = new int [] {1, 4, 7};
    else if (contentMainBoard [2] == contentMainBoard [5] && contentMainBoard [2] == contentMainBoard [8] && contentMainBoard [2] == turnNum)
      winningBoards = new int [] {2, 5, 8};
    else if (contentMainBoard [2] == contentMainBoard [4] && contentMainBoard [2] == contentMainBoard [6] && contentMainBoard [2] == turnNum)
      winningBoards = new int [] {2, 4, 6};
    
    highlightWinner(winningBoards, gameEnded);
  }
  
  //**METHOD**
  public static void highlightWinner(int [] winningBoards, boolean gameEnded)
  {
    if (winningBoards [0] == 10) {
      player1Turn.setVisible(false);
      player2Turn.setVisible(false);
      tieMessage.setVisible(true);
      return;
    }
    
    JButton [] currentLosingBoard;
    boolean winner = false;
    
    for (int i = 0; i <= 8; i++)
    {
      currentLosingBoard = nextBoard(i);
      for (int j = 0; j <= 2; j++)
      {
        if (i == winningBoards [j])
          winner = true;
      }//end of for loop
      
      if (!winner) 
      {
        for (int k = 0; k <= 8; k++) {
          currentLosingBoard[k].setEnabled(false); 
        }//end of for
      }//end of if
      winner = false;
    }//end of for loop
    
    player1Win.setText("<html>" + player1Name + "<br>wins!<br>Your score is:<br>  " + xTurnNum + " turns!<html>");
    player2Win.setText("<html>" + player2Name + "<br>wins!<br>Your score is:<br>  " + oTurnNum + " turns!<html>");
    
    if (gameEnded) {
      if (turnNum == 1) {
        player1Turn.setVisible(false);
        player1Win.setVisible(true);
        try {
          updateLeaderboard(1);
        } catch (IOException e) {
          System.out.println ("Leaderboard Error");
        }
      }
      else if (turnNum == 2) {
        player2Turn.setVisible(false);
        player2Win.setVisible(true);
        try {
          updateLeaderboard(2);
        } catch (IOException e) {
          System.out.println("Leaderboard Error");
        }
      }
    }
  }//end of highlightWinner
  
  //**METHOD**
  public static void updateLeaderboard (int winningPlayer) throws IOException {
    
    String [] leaderStats = new String [10];
    
    //if (winningPlayer == 0) {
      File currentLeaders = new File ("Leaderboard.txt");
      
      Scanner inputLeaders = new Scanner (currentLeaders);
      leaderStats[0] = inputLeaders.nextLine();
      for (int y = 0; y <= 9; y++) {
        leaderStats[y] = inputLeaders.nextLine();
        if (winningPlayer == 0)
          leaders[y].setText(leaderStats[y]);
      }//end of for loop
      inputLeaders.close();
    
    //else {
      
    if (winningPlayer == 0)
     return;
      
      int winningScore;
      int [] previousScores = new int [10];
      boolean replaced = false;
      String winningName;
      
      for (int i = 0; i <= 9; i++) {
        if (leaderStats[i].indexOf("E") >= 0) {
          if (leaderStats[i].substring(leaderStats[i].indexOf("E")).equals("EMPTY")) {
            previousScores[i] = -1;
          }//end of if
          else
            previousScores[i] = Integer.parseInt (leaderStats[i].substring (leaderStats[i].lastIndexOf(" ") + 1));//2 space needs to change
        }//end of if
        else  {
          previousScores[i] = Integer.parseInt (leaderStats[i].substring (leaderStats[i].lastIndexOf(" ") + 1));//2 space needs to change
        }//end of else
      }//end of for loop
      
      if (winningPlayer == 1) {
        winningScore = xTurnNum;
        winningName = player1Name.toUpperCase();
      }
      else {
        winningScore = oTurnNum;
        winningName = player2Name.toUpperCase();
      }
      
      winningName += ":";
      
      if (winningName.length() < 10) {
        for (int p = winningName.length()+1; p <= 9; p++)
          winningName += " ";
      }
      
      try{
        PrintWriter writer = new PrintWriter("Leaderboard.txt");
        writer.println("ULTIMATE TIC TAC TOE LEADERBOARD");
      
        for (int x = 0; x <= 9; x++)
        {
          //If the winning score from the most recent game has not been added to the leaderboard yet
          if (!replaced) {
            
            //If the spot on the leaderboard currently stores a score
            if (previousScores[x] >= 0) {
                
                //If the score from the most recent game beats the score on the leaderboard
                if (winningScore < previousScores[x]) {
                  //Replace the scores
                  replaced = true;
                  if (x == 9)
                    writer.println((x+1) + ".  " + winningName + winningScore);
                  else
                    writer.println((x+1) + ".   " + winningName + winningScore);
                  
                  for (int r = x; r <= 8; r++)
                  {
                    if (previousScores[r] >= 0)
                      leaderStats[r] = (r+2) + leaderStats[r].substring(leaderStats[r].indexOf("."));
                    else {
                      if (r == 9)
                        leaderStats[r] = ((r+2) + ".  " + "EMPTY");
                      else
                        leaderStats[r] = ((r+2) + ".   " + "EMPTY");
                    }//end of else
                    writer.println(leaderStats[r]);
                  }//end of for looop
                }//end of if
              
              else {
                  writer.println(leaderStats[x]);
              }//end of else
              
              }//end of if
            
            else {
              replaced = true;
              if (x==9)
                writer.println((x+1) + ".  " + winningName + winningScore);
              else
                writer.println((x+1) + ".   " + winningName + winningScore);
              
              for (int w = x; w <= 8; w++)
              {
                if (w == 9)
                  writer.println((w+2) + ".  " + "EMPTY");
                else
                  writer.println((w+2) + ".   " + "EMPTY");
              }//end of for
            }//end of else
            
          }//end of if
        }//end of for loop
      
      writer.close();
      }//end of try 
      catch (IOException e) {
        System.out.println("Leaderboard File not found");
      }
  }//end of updateLeaderboard
      
  
  //**METHOD**
  public static void resetGame() {
    xTurnNum = 1;
    oTurnNum = 1;
    turnNum = 1;
    
    nullAll();
    
    int [] resetContentBoard;
    
    for (int i = 0; i <= 9; i++)
    {
     resetContentBoard = nextContent(i);
     
     for (int h = 0; h <= 8; h++) {
       resetContentBoard[h] = 0;
     }
    }
    
    JButton [] resetMiniBoard;
    
    for (int j = 0; j <= 8; j++)
    {
     resetMiniBoard = nextBoard(j);
     
     for (int k = 0; k <= 8; k++)
     {
       removeListener (resetMiniBoard, k);
       resetMiniBoard[k].setIcon(null);
       addListener(resetMiniBoard, k);
     }//end of for loop
    }//end of for loop
    
    tieMessage.setVisible(false);
    player1Win.setVisible(false);
    player2Win.setVisible(false);
    player1Turn.setVisible(true);
    player2Turn.setVisible(false);
    
    highlightAll();
    
  }//end of resetGame
  
  //Menu Screen (Creates the menu screen that allows the user to select what they would like to do)
  //This will created on one large panel that will have it's visibility set to true when user needs to see it
  {
    //Set JPanels to the JFrame of the menu screen
    
    //Create GUI components like buttons for the user to press to decide where they will place their X or O
    //Also a button for the user to use for exiting 
    
    //Constructor to set up GUI
    
    //Create a window that has a title called "Ultimate Tic Tac Toe"
    
    //Set the size of the window for the gameplay screen
    
    //Create the layouts for each panel of the JFrame

    //Set a layout for each panel of the JFrame
    
    //Create action listeners for each button to see what the user presses and act on it
  
    //Add components to the panel like the buttons
  
    //Add panels to the frame
    
    //Call an image to set as the background
    //Output the image
    //Catch any exceptions

    //Set the frame to visible
  
  
    //If the user selects the play game button 
      //Send them to the play game screen
  
    //If the user selects the instruction button
      //Send them to the instruction screen
  
    //If the user selects the leaderboard button 
      //Send them to the leaderboard screen
  
  }//End Menu Screen


  //Gameplay Screen (The screen where the user will play the game. Outputs the board the number of moves
  //the X and O for the moves users have made)
  {
    //Set JPanels to the JFrame of the gameplay screen
    
    //Create GUI components like buttons for the user to press to decide where they will place their X or O
    //Also a button for the user to use for exiting and a text field for name input
    
    //Constructor to set up GUI
    
    //Create a window that has a title called "Ultimate Tic Tac Toe"
    
    //Set the size of the window for the gameplay screen
    
    //Create the layouts for each panel of the JFrame

    //Set a layout for each panel of the JFrame
    
    //Create action listeners for each button to see what the user presses and act on it
  
    //Add components to the panel like the buttons
    
    //Add panels to the frame
    
    //Call an image of the board to output
    //Output the image
    //Catch any exceptions

    //Set the frame to visible
  
    //Output a screen to get the players to input their names
    //If the user selects start game then begin the game
  
    //Start game loop
  
      //Call advanceTurn to determine who's turn it is
      //Alert users who's turn it is
  
      //Highlight the miniBoard or miniBoards that can be played on for this turn
      //Do this by calling highlightBox
  
      //Get user's button click using action listeners
        //Only the highlighted miniBoard's buttons will be enabled
        //As well, only empty buttons in the miniBoard will be enabled (spaces that are not X or O)
  
      //Set the button clicked to X or O depending on the current turn
  
      //Check if the miniBoard has been won by calling checkWinner
  
      //If the user has won miniBoard
        //Highlight the miniBoard either red for player 1 or blue for player 2
    
        //Check if the user has also won the ultimateBoard by calling checkWinner
  
        //If the user has won the ultimateBoard (the game is over)
          //Highlight the three squares that they won with their colour
          //Output a game over message for the user 
          //Send the total move that each player made to a text file that can be read from the leaderboard
          //Display main menu
  
      //If the ultimate game has not been won
        //Output the players name and their number of moves
        //Highlight the name of the user who is taking their turn
  
      //If the user selects exit
        //Output a game over message
        //Return them to the menu screen
    
  
    //End game loop
      //Exit when the game is over of the user selects the exit button
  
  }//end Gameplay Screen


  //Instruction screen(If the user selects the instruction screen button then send them to the instruction
  //screen where they can read the rules
  {
  
    //Set JPanels to the JFrame of the instruction screen
    
    //Create GUI components like buttons for exit
    
    //Constructor to set up GUI
    
    //Create a window that has a title called "Ultimate Tic Tac Toe"
    
    //Set the size of the window for the gameplay screen
    
    //Create the layouts for each panel of the JFrame

    //Set a layout for each panel of the JFrame
    
    //Create action listeners for each button to see what the user presses and act on it
  
    //Add components to the panel like the buttons
  
    //Add panels to the frame
  
    //Call an image to set as the background
    //Output the image
    //Catch any exceptions

    //Set the frame to visible
  
    //Output the instructions for the user to read in the main panel in the center 
  
    //If the user selects exit 
      //Return to the menu screen
  
  }//end instruction screen


  //Leaderboard screen (If the user selects the leaderboard button then send them to the leaderboard screen 
  //and read from a text file to output the highest score for each user
  {
    //Set JPanels to the JFrame of the instruction screen
    
    //Create GUI components like buttons for exit
    
    //Constructor to set up GUI
    
    //Create a window that has a title called "Ultimate Tic Tac Toe"
    
    //Set the size of the window for the gameplay screen
    
    //Create the layouts for each panel of the JFrame

    //Set a layout for each panel of the JFrame
    
    //Create action listeners for each button to see what the user presses and act on it
  
    //Add components to the panel like the buttons
  
    //Add panels to the frame
  
    //Call an image to set as the background
    //Output the image
    //Catch any exceptions

    //Set the frame to visible
  
    //Read from the text file and output the high scores from previous games
    //Close text file
  
  }//end leaderboard screen

  //Main 
  public static void main (String [] args) { 
    //Create a JFrame
    UltimateTTT frame = new UltimateTTT();
    game = frame;
    //Close the frame if the user press the x button on the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  }//End main
}
  
