package view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	JDesktopPane windowCad = new JDesktopPane();
	
	JMenuBar barraMenu = new JMenuBar();
	
	JMenu menuUsuarios = new JMenu ("Usuários");
	JMenu menuTarefas = new JMenu ("Tarefas");
	JMenu menuMetodologias = new JMenu ("Metodologias");
	JMenu menuInfluencias = new JMenu ("Influencias");
	
	JMenuItem cadUsuario;
	JMenuItem cadTarefa;
	JMenuItem cadMetodologia;
	JMenuItem cadInfluencia;
	
	
	
	public Principal () {
		
		super ("Scratch out - Gerenciador de tarefas");
		
		windowCad = new JDesktopPane(){

		
		public void paintComponent(Graphics g){

			try {
				super.paintComponents(g);
				Image img = ImageIO.read(new java.net.URL(

						this.getClass().getResource("imagens/DESKTOP.jpg"), "DESKTOP.jpg"));
				
				if (img != null) {

					g.drawImage(img, 0, 0, 1200, 800, this);
				}
			}
				catch(Exception e){

				e.printStackTrace();
			}
		}
	};
		
		this.setJMenuBar(barraMenu);
		
		barraMenu.add(menuUsuarios);
		barraMenu.add(menuTarefas);
		barraMenu.add(menuMetodologias);
		barraMenu.add(menuInfluencias);
		
		menuUsuarios.add(cadUsuario = new JMenuItem ("Cadastrar"));
		cadUsuario.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				TelaUsuarios app = new TelaUsuarios();
			}
		});
		
		menuTarefas.setIcon(new ImageIcon(this.getClass().getResource("imagens/AGENDA2.png")));
		cadTarefa.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				TelaTarefas app = new TelaTarefas();
			}
		});
		
		menuMetodologias.add(cadMetodologia = new JMenuItem ("Adicionar metodologia"));
		cadMetodologia.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				TelaMetodologias app = new TelaMetodologias();
			}
		});
		
		menuInfluencias.add(cadInfluencia = new JMenuItem ("Adicionar influências"));
		cadInfluencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInfluencias app = new TelaInfluencias();
			}
		});
		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(true);
	}
}
