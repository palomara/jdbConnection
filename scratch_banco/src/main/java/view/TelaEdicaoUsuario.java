package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaEdicaoUsuario extends JFrame {
	
	JTextField txtID = new JTextField();
	JLabel lblID = new JLabel("ID: ");
	
	JTextField txtNome = new JTextField();
	JLabel lblNome = new JLabel("Nome: ");
	
	JLabel lblEmail = new JLabel("Email:");
	JTextField txtEmail = new JTextField();
	
	JTextField txtSexo = new JTextField();
	JLabel sexo = new JLabel("Sexo: ");
	
	
	JButton btnEditar = new JButton ("Editar");
	
	public TelaEdicaoUsuario() {
		
		super("Edição");

		Container paine = this.getContentPane();

		paine.add(lblNome);
		paine.add(txtNome);	
		lblNome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(lblEmail);
		paine.add(txtEmail);
		lblEmail.setBounds(10,50,70,30);
		txtEmail.setBounds(90, 50, 225, 30);

		paine.add(sexo);
		paine.add(txtSexo);
		sexo.setBounds(10,85,70,30);
		txtSexo.setBounds(90, 85, 225, 30);

		
		paine.add(btnEditar);
		btnEditar.setBounds(95, 180, 130, 30);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios c = new Usuarios();
					c.setNome(txtNome.getText());
					c.setEmail(txtEmail.getText());
					c.setSexo(txtSexo.getText());



					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
				

					usuariosJdbcDao.alterar(c);
					JOptionPane.showMessageDialog(new JFrame(), "Edição efetuada");
					
					for (int i=0; i < getContentPane().getComponentCount(); i++) {
						Component gc = getContentPane().getComponent(i);
						
						if(gc instanceof JTextField) {
							JTextField jtfield = (JTextField) gc;
							jtfield.setText("");
						}	
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Edição não efetuada");
				}

			}
		});

		
		this.setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(340, 250);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
}
