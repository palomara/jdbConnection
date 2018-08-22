package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;
import model.Usuarios;

public class TelaUsuarios extends JFrame {
	
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
		nome.setBounds(20, 20, 80, 30);
		txtNome.setBounds(60, 20, 250, 30);

		paine.add(email);
		paine.add(txtEmail);
		email.setBounds(20, 65, 80, 30);
		txtEmail.setBounds(60, 65, 250, 30);
		
		paine.add(sexo);
		paine.add(txtSexo);
		sexo.setBounds(20, 110, 80, 30);
		txtSexo.setBounds(60, 105, 250, 30);

/*		paine.add(sexo);
		sexo.setBounds(10, 85, 70, 30);
		grupo.add(rdbsexo[0]); // grupo para o sexo
		grupo.add(rdbsexo[1]);
		paine.add(rdbsexo[0]); // opção para o sexo
		rdbsexo[0].setBounds(90, 85, 225, 30);
		paine.add(rdbsexo[1]);
		rdbsexo[1].setBounds(90, 105, 225, 30);*/

		paine.add(btnSalvar);
		btnSalvar.setBounds(125, 190, 100, 65);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios usuarios = new Usuarios();
					usuarios.setNome(txtNome.getText());
					usuarios.setEmail(txtEmail.getText());
					usuarios.setSexo(txtSexo.getText());

					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
				

					usuariosJdbcDao.salvar(usuarios);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});

		this.setLayout(null);
		this.setVisible(true);
		this.setSize(350, 320);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		

	}
}
