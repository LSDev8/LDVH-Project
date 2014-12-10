package ihm.graphique;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Interface extends JFrame {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = -6924501868170206693L;
	private JPanel contentPane;
	private Component course;
	private String [] sections={"Section 1","Section 2","Section 3","Section 4","...","Section n"};
	private String [] stuffs = { "Stuff 1", "Stuff 2", "Stuff 3", "...", "Stuff n"};
	private String [] enchs =  { "Enchainement 1", "Enchainement 2", "Enchainement 3", "...", "Enchainement n"};
	
	private JButton btnExit;

	private JComboBox<String> listeSection; 
	private JComboBox<String> listeStuff;
	private JComboBox<String> listeEnch;

	private JSlider veloZoom;
	private JPanel panel_1;
	
	private JButton livreButton;
	private JButton chargerButton;
	private JButton saveButton;
	private JButton deleteButton;
	
	private JButton graphButton;
	private JButton analyButton;
	private JButton htmlButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setPreferredSize(new Dimension(1300, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("LDVH Editor");
		course=new Container();
		course.setPreferredSize(new Dimension(1024, 768));
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new JPanel();
		menu.setPreferredSize(new Dimension(250, 800));
		menu.setSize(new Dimension(150, 800));
		menu.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		contentPane.add(menu,BorderLayout.WEST);
		menu.setLayout(null);
		
		btnExit = new JButton("Quit");
		btnExit.setBounds(40, 700, 150, 30);
		menu.add(btnExit);
		
		livreButton = new JButton("Créer");
		livreButton.setBounds(10, 30, 110, 30);
		menu.add(livreButton);
		
		chargerButton = new JButton("Charger");
		chargerButton.setBounds(130, 30, 110, 30);
		menu.add(chargerButton);
		
		saveButton = new JButton("");
		saveButton.setIcon(new ImageIcon(this.getClass().getResource("/ihm/images/save.gif")));
		saveButton.setBounds(55, 80, 50, 40);
		menu.add(saveButton);
		
		deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon(this.getClass().getResource("/ihm/images/cross.jpg")));
		deleteButton.setBounds(125, 80, 50, 40);
		menu.add(deleteButton);
		
		graphButton = new JButton("Générer Graphe");
		graphButton.setBounds(30, 400, 180, 30);
		menu.add(graphButton);
		
		analyButton = new JButton("Analyser Graphe");
		analyButton.setBounds(30, 450, 180, 30);
		menu.add(analyButton);
		
		htmlButton = new JButton("Générer HTML");
		htmlButton.setBounds(30, 500, 180, 30);
		menu.add(htmlButton);
		
		
		
		JLabel lblSection = new JLabel("Liste Section:");
		lblSection.setBounds(34, 190, 150, 16);
		menu.add(lblSection);
		
		listeSection = new JComboBox<String>(sections);
		listeSection.setBounds(24, 210, 217, 27);
		menu.add(listeSection);
		
		JLabel lblEnch = new JLabel("Liste Enchainement:");
		lblEnch.setBounds(34, 250, 150, 16);
		menu.add(lblEnch);
		
		listeEnch = new JComboBox<String>(enchs);
		listeEnch.setBounds(24, 270, 217, 27);
		menu.add(listeEnch);
		
		JLabel lblStuff = new JLabel("Liste Objet:");
		lblStuff.setBounds(34, 310, 150, 16);
		menu.add(lblStuff);
		
		listeStuff = new JComboBox<String>(stuffs);
		listeStuff.setBounds(24, 330, 217, 27);
		menu.add(listeStuff);
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(131, 237, 83, 66);
		menu.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
	
	
		
		JLabel lblZoom = new JLabel("Zoom:");
		lblZoom.setBounds(28, 600, 173, 16);
		menu.add(lblZoom);
		
		veloZoom = new JSlider(1,20,10);
		veloZoom.setPaintTicks(true);
		veloZoom.setPaintLabels(true);
		veloZoom.setBounds(28, 620, 190, 55);
		menu.add(veloZoom);
		
	

		
	}
	
	public void setCourse(Component course) {
		this.getContentPane().remove(this.course);
		this.course = course;
		course.setPreferredSize(new Dimension(1024, 768));
		getContentPane().add(course,BorderLayout.EAST);

		repaint();
		validate();

	}
	

	
	/**
	 * @return the panel_1
	 */
	public JPanel getPanel_1() {
		return panel_1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public Component getCourse() {
		return course;
	}

	public String[] getSections() {
		return sections;
	}

	public String[] getStuffs() {
		return stuffs;
	}

	public String[] getEnchs() {
		return enchs;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JComboBox<String> getListeSection() {
		return listeSection;
	}

	public JComboBox<String> getListeStuff() {
		return listeStuff;
	}

	public JComboBox<String> getListeEnch() {
		return listeEnch;
	}

	public JSlider getVeloZoom() {
		return veloZoom;
	}

	public JButton getLivreButton() {
		return livreButton;
	}

	public JButton getChargerButton() {
		return chargerButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getGraphButton() {
		return graphButton;
	}

	public JButton getAnalyButton() {
		return analyButton;
	}

	public JButton getHtmlButton() {
		return htmlButton;
	}
	
	

	
	

	
}
