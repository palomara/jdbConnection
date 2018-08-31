package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaUsuarios extends JFrame {
	
	JLabel lblIdUsuario = new JLabel("ID:");
	JTextField txtIdUsuario = new JTextField();
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("Nome:");

	JTextField txtEmail = new JTextField();
	JLabel email = new JLabel("E-mail:");

	JTextField txtSexo = new JTextField();
	JLabel sexo = new JLabel("Sexo: ");
	

	/*JCheckBox cbFeminino = new JCheckBox("Feminino");
	JCheckBox cbMasculino = new JCheckBox ("Masculino");*/

	
	/*JRadioButton[] rdbsexo = new JRadioButton[2]; // botão para opçoes
	ButtonGroup grupo = new ButtonGroup();
	{ // group impede marcar mais de uma opçao no mesmo objeto

		rdbsexo[0] = new JRadioButton("Feminino");
		rdbsexo[1] = new JRadioButton("Masculino");
	} // fechar chave nos groups

	//MaskFormatter formatEmail = null;*/

	JButton btnSalvar = new JButton("Salvar");

	public TelaUsuarios() {

		super("Cadastro");

		Container paine = this.getContentPane();

		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(email);
		paine.add(txtEmail);
		email.setBounds(10,50,70,30);
		txtEmail.setBounds(90, 50, 225, 30);

		paine.add(sexo);
		paine.add(txtSexo);
		sexo.setBounds(10,85,70,30);
		txtSexo.setBounds(90, 85, 225, 30);

		/*paine.add(lblIDTarefa);
		paine.add(txtIDTarefa);	
		lblIDTarefa.setBounds(10, 120, 70, 30);
		txtIDTarefa.setBounds(90, 120, 225, 30);	*/

		

/*		paine.add(sexo);
		sexo.setBounds(10, 85, 70, 30);
		grupo.add(rdbsexo[0]); // grupo para o sexo
		grupo.add(rdbsexo[1]);
		paine.add(rdbsexo[0]); // opção para o sexo
		rdbsexo[0].setBounds(90, 85, 225, 30);
		paine.add(rdbsexo[1]);
		rdbsexo[1].setBounds(90, 105, 225, 30);*/

		paine.add(btnSalvar);
		btnSalvar.setBounds(95, 180, 130, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios usuarios = new Usuarios();
					usuarios.setNome(txtNome.getText());
					usuarios.setEmail(txtEmail.getText());
					usuarios.setSexo(txtSexo.getText());
					//usuarios.setidTarefa(Integer.parseInt(txtIDTarefa.getText()));

					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
				

					usuariosJdbcDao.salvar(usuarios);
					JOptionPane.showMessageDialog(new JFrame(), "Cadastro efetuado");
					
					/*for (int i=0; i < getContentPane().getComponentCount(); i++) {
						Component c = getContentPane().getComponent(i);
						
						if(c instanceof JTextField) {
							JTextField jtfield = (JTextField) c;
							jtfield.setText("");
						}	*/
					}

				 catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Cadastro não efetuado");
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
