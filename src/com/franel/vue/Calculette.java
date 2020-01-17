/**
 * 
 */
package com.franel.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.franel.controler.AbstractControler;
import com.franel.observer.Observer;

/**
 * @author franel
 *
 */
public class Calculette extends JFrame implements Observer{
	
	private JPanel container = new JPanel();
	
	String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
	
	JButton[] tab_button = new JButton[tab_string.length];
	
	private JTextField ecran = new JTextField();
	private Dimension dim = new Dimension(50, 40);
	private Dimension dim2 = new Dimension(50, 31);
	private Double chiffre1;
	private boolean clicOperateur = false;
	private boolean update = false;
	private String operateur = "";
	
	//l'instance de notre objet controller
	private AbstractControler controler;
	
	public Calculette(AbstractControler controler) {
		this.setSize(240, 280);
		this.setTitle("Calculatrice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComposant();
		this.controler = controler;
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	private void initComposant() {
		Font police = new Font("Arial", Font.BOLD, 20);
		ecran = new JTextField("");
		ecran.setFont(police);
		ecran.setHorizontalAlignment(JTextField.RIGHT);
		ecran.setPreferredSize(new Dimension(220, 30));
		
		JPanel operateur = new JPanel();
		operateur.setPreferredSize(new Dimension(55, 225));
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(165, 225));
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension(220, 30));
		
		OperateurListener opeListener = new OperateurListener();
		
		for(int i = 0; i < tab_string.length; i++) {
			tab_button[i] = new JButton(tab_string[i]);
			tab_button[i].setPreferredSize(dim);
			
			switch(i) {
			case 11 :
				tab_button[i].addActionListener(opeListener);
				chiffre.add(tab_button[i]);
				break;
			case 12 :
				tab_button[i].setForeground(Color.red);
				tab_button[i].addActionListener(new ResetListener());
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			case 13 :
			case 14 :
			case 15 :
			case 16 :
				tab_button[i].setForeground(Color.red);
				tab_button[i].addActionListener(opeListener);
				tab_button[i].setPreferredSize(dim2);
				operateur.add(tab_button[i]);
				break;
			default :
				chiffre.add(tab_button[i]);
				tab_button[i].addActionListener(new ChiffreListener());
				break;
			}
		}
		panEcran.add(ecran);
		//panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
		container.add(panEcran, BorderLayout.NORTH);
		container.add(chiffre, BorderLayout.CENTER);
		container.add(operateur, BorderLayout.EAST);
		
	}

	@Override
	//implementation du pattern observer
	public void update(String str) {
		// TODO Auto-generated method stub
		ecran.setText(str);
	}
	
	class ChiffreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//On affiche le chiffre en plus dans le label
			String str = ((JButton)arg0.getSource()).getText();
			if(!ecran.getText().equals("0"))
				str = ecran.getText() + str;
			
			controler.setNombre(((JButton)arg0.getSource()).getText());
		}
	}
	
	class OperateurListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controler.setOperateur(((JButton)e.getSource()).getText());
			
		}
	}
	
	class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			controler.reset();
		}
	}
}
