package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;

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
	
	JLabel lblID = new JLabel ("Usuário:");
	JLabel lblTitulo = new JLabel ("Tarefa:");
	
	JTextField txbID = new JTextField();
	JTextField txbTitulo = new JTextField();
	
	JButton btnPesquisar = new JButton ("Pesquisar");
	
	
	
	
	
	public Principal () {
		
		super ("Scratch out - Gerenciador de tarefas");
		
		 Container paine = this.getContentPane();
		
		windowCad = new JDesktopPane(){

		
		public void paintComponent(Graphics g){

			try {
				super.paintComponents(g);
				Image img = ImageIO.read(new java.net.URL(

						this.getClass().getResource("imagens/kelly.jpg"), "kelly.jpg"));
				
				if (img != null) {

					g.drawImage(img, 0, 0, 600, 396, this);
				}
			}
				catch(Exception e){

				e.printStackTrace();
			}
		}
	};
	
	windowCad.setBackground(Color.WHITE);
		
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
		
		menuTarefas.add(cadTarefa = new JMenuItem ("Adicionar tarefa"));
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
		
		paine.add(lblID);
		paine.add(txbID);
		lblID.setBounds(10, 20, 80, 80);
		txbID.setBounds(70, 50, 85, 20);
		
		paine.add(lblTitulo);
		paine.add(txbTitulo);
		lblTitulo.setBounds(10, 40, 80, 80);
		txbTitulo.setBounds(70, 70, 100, 20);
		
		paine.add(btnPesquisar);
		btnPesquisar.setBounds(30, 110, 120, 40);
		
		
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDAO = new UsuariosJdbcDAO(connection);
					
					/*if(selectUsuarios()==true && selectTarefas()==true ) {
						String sql = "select * from tarefaParticipantes";
						System.out.print(sql);
						PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
						prepareStatement.executeUpdate();
						prepareStatement.close();
					}*/
				}
				
				catch(Exception v){
				     v.printStackTrace();     
				     }
			}
			
		
		});
		
		
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLayout(null);
		this.setResizable(true);
	}
}
