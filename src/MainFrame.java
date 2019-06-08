import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/** Una classe che costruisce il frame principale
 * @author Carmelo Sottile
 */
public class MainFrame extends JFrame {
	
	/** Costruisce il frame principale
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(createFileMenu());
		setLayout(new BorderLayout());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
 
	/** Crea il menu file nella barra dei menu
	 * @return il menu file
	 * @throws IOException
	 */
	public JMenu createFileMenu() throws IOException {
		JMenu menu = new JMenu("File");
		menu.add(createFileNewGame());
		menu.add(createFileLoadGame());
		menu.add(createFileSaveGame());
		return menu;
	}
 
	/** Crea il menuItem "New game"
	 * @return il menuItem "New game"
	 */
	public JMenuItem createFileNewGame() {
		JMenuItem newgame = new JMenuItem("New Game");
		/** Una classe Listener per il MenuItem "New game"
		 * @author Carmelo Sottile
		 */
		class MenuItemListener implements ActionListener {
			/** Inizia un nuovo gioco
			 * @param event l'evento che chiama il metodo
			 */
			public void actionPerformed(ActionEvent event) {
				myScenery = new Scenery();
				panel = new JPanel();
				panel = myScenery.getPanel();
				add(panel, BorderLayout.CENTER);
				panel2 = new JPanel();
				JButton myButton = myScenery.getButton1();
				JButton myButton2 = myScenery.getButton2();
				JButton myButton3 = myScenery.getButton3();
				panel2.add(myButton);
				panel2.add(myButton2);
				panel2.add(myButton3);
				add(panel2, BorderLayout.SOUTH);
				validate();
				repaint();
			}
		}
		ActionListener listener = new MenuItemListener();
		newgame.addActionListener(listener);
		return newgame;
	}
 
	/** Crea il menuItem "Load game"
	 * @return il menuItem "Load game"
	 * @throws IOException
	 */
	public JMenuItem createFileLoadGame() throws IOException {
		JMenuItem loadgame = new JMenuItem("Load Game");
		/** Una classe Listener per il menuItem "Load game"
		 * @author Carmelo Sottile
		 */
		class MenuItemListener implements ActionListener {
			/** Carica una partita salvata in precedenza
			 * @param event l'evento che chiama il metodo
			 */
			public void actionPerformed(ActionEvent event) {
				try {
					FileInputStream input = new FileInputStream(file);
					ObjectInputStream in = new ObjectInputStream(input);
					myScenery = (Scenery) in.readObject();
					loadFrame(myScenery);
					in.close();
					input.close();
					} catch (IOException e) {
						showError2();
				 	} catch (ClassNotFoundException e) {
				 		showError2();
				 	}
			}
		}
			ActionListener listener = new MenuItemListener();
			loadgame.addActionListener(listener);
			return loadgame;
	}
	
	/** Crea il menuItem "Save game"
	 * @return il menuItem "Save game"
	 */
	public JMenuItem createFileSaveGame() {
		JMenuItem savegame = new JMenuItem("Save Game");
		/** Una classe Listener per il menuItem "Save game"
		 * @author Carmelo Sottile
		 */
		class MenuItemListener implements ActionListener {
			/** Salva una partita in corso
			 * @param event l'evento che chiama il metodo
			 */
			public void actionPerformed(ActionEvent event) {
				if(file.exists()) {
					file.delete();
				}	
				try {
					FileOutputStream output = new FileOutputStream(file);
					ObjectOutputStream out = new ObjectOutputStream(output);
					out.writeObject(myScenery);
					out.close();
					showMessage();
				} catch (IOException e) {
					showError1();
				}
			}
		}
		ActionListener listener = new MenuItemListener();
		savegame.addActionListener(listener);
		return savegame;
	}
	
	/** Carica il nuovo scenario dopo il caricamento dal file
	 * @param scenery lo scenario letto dal file
	 */
	public void loadFrame(Scenery scenery) {
		myScenery = scenery;
		JPanel panel = myScenery.getPanel();
		add(panel, BorderLayout.CENTER);
		JButton myButton = myScenery.getButton1();
		JButton myButton2 = myScenery.getButton2();
		JButton myButton3 = myScenery.getButton3();
		JPanel panel2 = new JPanel();
		panel2.add(myButton);
		panel2.add(myButton2);
		panel2.add(myButton3);
		add(panel2, BorderLayout.SOUTH);
		validate();
		repaint();
	}
	
	/** Setta il pannello di gioco dopo un mossa
	 * @param newPanel il nuovo pannello da visualizzare
	 */
	public void setFrame(JPanel newPanel) {
		remove(panel);
		panel = newPanel;
		add(panel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	/** Sceglie a caso il giocatore che deve muovere
	 */
	public void choosePlayer() {
		Random choser = new Random();
		int n = choser.nextInt(2);
		if(n == 0) {
			JOptionPane.showMessageDialog(this, "Tocca al combattente");
		}
		else {
			JOptionPane.showMessageDialog(this, "Tocca al lavoratore");
		}
	}
	
	/** Mostra un messaggio di informazione
	 */
	public void showMessage() {
		JOptionPane.showMessageDialog(this, "Salvataggio eseguito correttamente");
	}
	
	/** Mostra un messaggio di informazione
	 */
	public void showMessage2() {
		JOptionPane.showMessageDialog(this, "Colpo critico!");
	}
	
	/** Mostra un messaggio di errore
	 */
	public void showError1() {
		JOptionPane.showMessageDialog(this, "Errore nel salvataggio");
	}
	
	/** Mostra un messaggio di errore
	 */
	public void showError2() {
		JOptionPane.showMessageDialog(this, "Errore nel caricamento");
	}
	
	/** Mostra un messaggio di errore
	 */
	public void showError3() {
		JOptionPane.showMessageDialog(this, "Energia insufficiente");
	}
	
	/** Mostra un messaggio di errore
	 */
	public void showError4() {
		JOptionPane.showMessageDialog(this, "Non puoi proseguire in questa posizione");
	}
 
	/** Una classe che costruisce lo scenario logico e grafico del gioco
	 * @author Carmelo Sottile
	 */
	class Scenery implements Serializable {
		
		/** Costruisce lo scenario logico e grafico
		 */
		public Scenery() {
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridLayout(10, 10));
			fillArrayLogics();
			fillArrayGraphics();
			fighter1 = new Fighter(0, 0);
			ArrayList<Battery> batterySet = new ArrayList<Battery>(5);
			ArrayList<Tool> toolSet = new ArrayList<Tool>(5);
			worker1 = new Worker(1, 1, toolSet, batterySet);
			obstacle1 = new Obstacle(2, 3);
			bankSupply = new BankSupply(3, 2);
			logics[0][0] = fighter1;
			logics[1][1] = worker1;
			logics[2][3] = obstacle1;
			logics[3][2] = bankSupply;
			BattleFieldFighterPanel fighterPanel1 = new BattleFieldFighterPanel();
			BattleFieldWorkerPanel workerPanel1 = new BattleFieldWorkerPanel();
			BattleFieldObstaclePanel obstaclePanel1 = new BattleFieldObstaclePanel();
			BattleFieldBankSupplyPanel bankSupplyPanel = new BattleFieldBankSupplyPanel();
			graphics[0][0] = fighterPanel1;
			graphics[1][1] = workerPanel1;
			graphics[2][3] = obstaclePanel1;
			graphics[3][2] = bankSupplyPanel;
			mainPanel.add(fighterPanel1);
			modifyMainPanel();
			myButton = createButton();
			myButton2 = createButton2();
			myButton3 = createButton3();
		}
  
		/** Riempie l'array logico a null
		 */
		public void fillArrayLogics() {
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					logics[i][j] = null;
				}
			}
		}
		
		/** Riempie l'array di pannelli grafici vuoti
		 */
		public void fillArrayGraphics() {
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					graphics[i][j] = new BattleFieldEmptyPanel();
				}
			}
		}
		
		/** Ritorna il pannello di gioco
		 * @return il pannello di gioco
		 */
		public JPanel getPanel() {
			return mainPanel;
		}
		
		/** Ritorna il pulsante del combattente
		 * @return il pulsante del combattente
		 */
		public JButton getButton1() {
			return myButton;
		}
		
		/** Ritorna il pulsante del lavoratore
		 * @return il pulsante del lavoratore
		 */
		public JButton getButton2() {
			return myButton2;
		}
		
		/** Ritorna il pulsante dei turni
		 * @return il pulsante dei turni
		 */
		public JButton getButton3() {
			return myButton3;
		}
		
		/** Crea il pulsante del combattente
		 * @return il pulsante del combattente
		 */
		public JButton createButton() {
			myButton = new JButton("Fighter's actions");
			/** Una classe Listener per il pulsante del combattente
			 * @author Carmelo Sottile
			 */
			class MainButtonListener implements ActionListener {
				/** Mostra un frame con le mosse che può eseguire un combattente
				 * @param event l'evento che chiama il metodo
				 */
				public void actionPerformed(ActionEvent event) {
					/** Una classe che crea il frame con le mosse del combattente
					 * @author Carmelo Sottile
					 */
					class LittleFrameFighter extends JFrame {
						/** Costruisce il frame con le mosse del combattente
						 */
						public LittleFrameFighter() {
							setSize(FRAME_WIDTH, FRAME_HEIGHT);
							setLayout(new GridLayout(3, 2));
							JButton button1 = createButton1(); 
							JButton button2 = createButton2(); 
							JButton button3 = createButton3(); 
							JButton button4 = createButton4();
							JButton button5 = createButton5();
							add(button1);
							add(button2);
							add(button3);
							add(button4);
							add(button5);
						}
						
						/** Costruisce il pulsante per muovere il combattente verso su
						 * @return il pulsante
						 */
						public JButton createButton1() {
							JButton button1 = new JButton("ON");
							/** Una classe Listener per il pulsante "ON"
							 * @author Carmelo Sottile
							 */
							class FirstButtonListener implements ActionListener {
								/** Muove il combattente in su
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = fighter1.GetMovement();
									int x = p.x-1;
									int y = p.y;
									if(x < 0) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = fighter1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldFighterPanel();
										try {
											fighter1.MoveUp();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener firstListener = new FirstButtonListener();
							button1.addActionListener(firstListener);
							return button1;
						}
      
						/** Costruisce il pulsante per muovere il combattente verso giù
						 * @return il pulsante
						 */
						public JButton createButton2() {
							JButton button2 = new JButton("UNDER");
							/** Una classe Listener per il pulsante "UNDER"
							 * @author Carmelo Sottile
							 */
							class SecondButtonListener implements ActionListener {
								/** Muove il combattente in giù
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = fighter1.GetMovement();
									int x = p.x+1;
									int y = p.y;
									if(x > 9) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = fighter1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldFighterPanel();
										try {
											fighter1.MoveDown();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener secondListener = new SecondButtonListener();
							button2.addActionListener(secondListener);
							return button2;
						}
						
						/** Costruisce il pulsante per muovere il combattente verso sinistra
						 * @return il pulsante
						 */
						public JButton createButton3() {
							JButton button3 = new JButton("LEFT");
							/** Una classe Listener per il pulsante "LEFT"
							 * @author Carmelo Sottile
							 */
							class ThirdButtonListener implements ActionListener {
								/** Muove il combattente a sinistra
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = fighter1.GetMovement();
									int x = p.x;
									int y = p.y-1;
									if(y > 0) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = fighter1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldFighterPanel();
										try {
											fighter1.MoveLeft();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener thirdListener = new ThirdButtonListener();
							button3.addActionListener(thirdListener);
							return button3;
						}
						
						/** Costruisce il pulsante per muovere il combattente verso destra
						 * @return il pulsante
						 */
						public JButton createButton4() {
							JButton button4 = new JButton("RIGHT");
							/** Una classe Listener per il pulsante "RIGHT"
							 * @author Carmelo Sottile
							 */
							class FourthButtonListener implements ActionListener {
								/** Muove il combattente a destra
								 * @param l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = fighter1.GetMovement();
									int x = p.x;
									int y = p.y+1;
									if(y > 9) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = fighter1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldFighterPanel();
										try {
											fighter1.MoveRight();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener fourthListener = new FourthButtonListener();
							button4.addActionListener(fourthListener);
							return button4;
						}
						
						/** Costruisce il pulsante per far attacare il combattente
						 * @return il pulsante
						 */
						public JButton createButton5() {
							JButton button5 = new JButton("ATTACK");
							/** Una classe Listener per il pulsante "ATTACK"
							 * @author Carmelo Sottile
							 */
							class FifthButtonListener implements ActionListener {
								/** Permette al combattente di attaccare
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									
								}
							}
							ActionListener fifthListener = new FifthButtonListener();
							button5.addActionListener(fifthListener);
							return button5;
						}
						
						private static final int FRAME_WIDTH = 400;
						private static final int FRAME_HEIGHT = 300;
					}
					LittleFrameFighter littleFrameF = new LittleFrameFighter();
					littleFrameF.setTitle("Robot actions");
					littleFrameF.setResizable(false);
					littleFrameF.setLocationRelativeTo(null);
					littleFrameF.setVisible(true);
				}
			}
			ActionListener listener = new MainButtonListener();
			myButton.addActionListener(listener);
			return myButton;
		}
		
		/** Crea il pulsante del lavoratore
		 * @return il pulsante del lavoratore
		 */
		public JButton createButton2() {
			myButton2 = new JButton("Worker's actions");
			/** Una classe Listener per il pulsante del lavorarore
			 * @author Carmelo Sottile
			 */
			class MainButton2Listener implements ActionListener {
				/** Mostra un frame con le mosse che può eseguire un lavoratore
				 * @param event l'evento che chiama il metodo
				 */
				public void actionPerformed(ActionEvent event) {
					/** Una classe che crea il frame con le mosse del lavoratore
					 * @author Carmelo Sottile
					 */
					class LittleFrameWorker extends JFrame {
						/** Costruisce il frame con le mosse del lavoratore
						 */
						public LittleFrameWorker() {
							setSize(FRAME_WIDTH, FRAME_HEIGHT);
							setLayout(new GridLayout(3, 2));
							JButton button1 = createButton1(); 
							JButton button2 = createButton2(); 
							JButton button3 = createButton3(); 
							JButton button4 = createButton4();
							JButton button5 = createButton5();
							JButton button6 = createButton6();
							JButton button7 = createButton7();
							add(button1);
							add(button2);
							add(button3);
							add(button4);
							add(button5);
							add(button6);
							add(button7);
						}
						
						/** Costruisce il pulsante per muovere il lavoratore verso su
						 * @return il pulsante
						 */
						public JButton createButton1() {
							JButton button1 = new JButton("ON");
							/** Una classe Listener per il pulsante "ON"
							 * @author Carmelo Sottile
							 */
							class FirstButtonListener implements ActionListener {
								/** Muove il lavoratore in su
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = worker1.GetMovement();
									int x = p.x-1;
									int y = p.y;
									if(x < 0) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = worker1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldWorkerPanel();
										try {
											worker1.MoveUp();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener firstListener = new FirstButtonListener();
							button1.addActionListener(firstListener);
							return button1;
						}
						
						/** Costruisce il pulsante per muovere il lavoratore verso giù
						 * @return il pulsante
						 */
						public JButton createButton2() {
							JButton button2 = new JButton("UNDER");
							/** Una classe Listener per il pulsante "UNDER"
							 * @author Carmelo Sottile
							 */
							class SecondButtonListener implements ActionListener {
								/** Muove il lavoratore in giù
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = worker1.GetMovement();
									int x = p.x+1;
									int y = p.y;
									if(x > 9) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = worker1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldWorkerPanel();
										try {
											worker1.MoveDown();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener secondListener = new SecondButtonListener();
							button2.addActionListener(secondListener);
							return button2;
						}
						
						/** Costruisce il pulsante per muovere il lavoratore verso sinistra
						 * @return il pulsante
						 */
						public JButton createButton3() {
							JButton button3 = new JButton("LEFT");
							/** Una classe Listener per il pulsante "LEFT"
							 * @author Carmelo Sottile
							 */
							class ThirdButtonListener implements ActionListener {
								/** Muove il lavoratore a sinistra
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = worker1.GetMovement();
									int x = p.x;
									int y = p.y-1;
									if(y < 0) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = worker1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldWorkerPanel();
										try {
											worker1.MoveLeft();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
									
								}
							}
							ActionListener thirdListener = new ThirdButtonListener();
							button3.addActionListener(thirdListener);
							return button3;
						}
						
						/** Costruisce il pulsante per muovere il lavoratore verso destra
						 * @return il pulsante
						 */
						public JButton createButton4() {
							JButton button4 = new JButton("RIGHT");
							/** Una classe Listener per il pulsante "RIGHT"
							 * @author Carmelo Sottile
							 */
							class FourthButtonListener implements ActionListener {
								/** Muove il lavoratore a destra
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									Point p = worker1.GetMovement();
									int x = p.x;
									int y = p.y+1;
									if(y > 9) {
										showError4();
									} 
									else {
										logics[p.x][p.y] = null;
										logics[x][y] = worker1;
										graphics[p.x][p.y] = new BattleFieldEmptyPanel();
										graphics[x][y] = new BattleFieldWorkerPanel();
										try {
											worker1.MoveRight();
										} catch (InsufficientEnergyException e) {
											showError3();
										}
										modifyMainPanel();
										setFrame(mainPanel);
										setVisible(false);
									}
								}
							}
							ActionListener fourthListener = new FourthButtonListener();
							button4.addActionListener(fourthListener);
							return button4;
						}
						
						/** Costruisce il pulsante per spostare un ostacolo
						 * @return il pulsante
						 */
						public JButton createButton5() {
							JButton button5 = new JButton("SHIFT");
							/** Una classe Listener per il pulsante "SHIFT"
							 * @author Carmelo Sottile
							 */
							class FifthButtonListener implements ActionListener {
								/** Sposta un ostacolo
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									
								}
							}
							ActionListener fifthListener = new FifthButtonListener();
							button5.addActionListener(fifthListener);
							return button5;
						}
						
						/** Costruisce il pulsante per riparare un altro robot
						 * @return il pulsante
						 */
						public JButton createButton6() {
							JButton button6 = new JButton("REPAIR");
							/** Una classe Listener per il pulsante "REPAIR"
							 * @author Carmelo Sottile
							 */
							class SixthButtonListener implements ActionListener {
								/** Ripara un robot
								 * @param l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									
								}
							}
							ActionListener sixthListener = new SixthButtonListener();
							button6.addActionListener(sixthListener);
							return button6;
						}
						
						/** Costruisce il pulsante per aggiungere una batteria ad un robot
						 * @return il pulsante
						 */
						public JButton createButton7() {
							JButton button7 = new JButton("ADD BATTERY");
							/** Una classe Listener per il pulsante "ADD BATTERY"
							 * @author Carmelo Sottile
							 */
							class SeventhButtonListener implements ActionListener {
								/** Aggiunge una batteria
								 * @param event l'evento che chiama il metodo
								 */
								public void actionPerformed(ActionEvent event) {
									
								}
							}
							ActionListener seventhListener = new SeventhButtonListener();
							button7.addActionListener(seventhListener);
							return button7;
						}
						
						private static final int FRAME_WIDTH = 400;
						private static final int FRAME_HEIGHT = 300;
					}
					LittleFrameWorker littleFrameW = new LittleFrameWorker();
					littleFrameW.setTitle("Robot actions");
					littleFrameW.setResizable(false);
					littleFrameW.setLocationRelativeTo(null);
					littleFrameW.setVisible(true);
				}
			}
			ActionListener listener = new MainButton2Listener();
			myButton2.addActionListener(listener);
			return myButton2;
		}
		
		/** Crea il pulsante del prossimo turno
		 * @return il pulsante del prossimo turno
		 */
		public JButton createButton3() {
			JButton myButton3 = new JButton("Next turn");
			/** Una classe Listener per il pulsante "Next turn"
			 * @author Carmelo Sottile
			 */
			class MainButton3Listener implements ActionListener {
				/** Sceglie un giocatore
				 * @param event l'evento che chiama il metodo
				 */
				public void actionPerformed(ActionEvent event) {
					choosePlayer();
				}
			}
			ActionListener listener = new MainButton3Listener();
			myButton3.addActionListener(listener);
			return myButton3;
		}
  
		/** Modifica il pannello dopo l'azione di un robot
		 */
		public void modifyMainPanel() {
			mainPanel = new JPanel();
			mainPanel.setLayout(new GridLayout(10,10));
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					mainPanel.add(graphics[i][j]);
				}
			}
		}
		
		private BankSupply bankSupply;
		private Obstacle obstacle1;
	    private Worker worker1;
		private Fighter fighter1;
		private JButton myButton, myButton2, myButton3;;
		private JPanel mainPanel;
		private JPanel[][] graphics = new JPanel[10][10];
		private Object[][] logics = new Object[10][10];
	 }
	
	private File file= new File("C:\\Users\\Carmelo Sottile\\Desktop\\Eclipse - Java\\ROBOT_WAR\\scenery.bin");
	private JPanel panel, panel2;
	private Scenery myScenery;
	private static final int FRAME_WIDTH = 620;
	private static final int FRAME_HEIGHT = 700;
}