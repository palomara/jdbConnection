package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.JdbUtil;
import controller.TarefasJdbcDAO;
import controller.UsuariosJdbcDAO;

import model.Usuarios;

/**
 * Hello world!
 *
 */
public class App extends JFrame {

	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("NOME:");

	JTextField txtEmail = new JTextField();
	JLabel email = new JLabel("E-MAIL:");

	JTextField txtSexo = new JTextField();
	JLabel sexo = new JLabel("SEXO: ");

	/*JRadioButton[] rdbsexo = new JRadioButton[2]; // botão para opçoes
	ButtonGroup grupo = new ButtonGroup();
	{ // group impede marcar mais de uma opçao no mesmo objeto

		rdbsexo[0] = new JRadioButton("Feminino");
		rdbsexo[1] = new JRadioButton("Masculino");
	} // fechar chave nos groups

	//MaskFormatter formatEmail = null;*/

	JButton btnSalvar = new JButton("Salvar");

	public App() {

		super("Cadastro Usuários");

		Container paine = this.getContentPane();

		paine.add(nome);
		paine.add(txtNome);
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(90, 15, 225, 30);

		paine.add(email);
		paine.add(txtEmail);
		email.setBounds(10, 50, 70, 30);
		txtEmail.setBounds(90, 50, 225, 30);
		
		paine.add(sexo);
		paine.add(txtSexo);
		sexo.setBounds(10, 85, 70, 30);
		txtSexo.setBounds(90, 85, 225, 30);

/*		paine.add(sexo);
		sexo.setBounds(10, 85, 70, 30);
		grupo.add(rdbsexo[0]); // grupo para o sexo
		grupo.add(rdbsexo[1]);
		paine.add(rdbsexo[0]); // opção para o sexo
		rdbsexo[0].setBounds(90, 85, 225, 30);
		paine.add(rdbsexo[1]);
		rdbsexo[1].setBounds(90, 105, 225, 30);*/

		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuarios usuarios = new Usuarios();
					usuarios.setNome(txtNome.getText());
					usuarios.setEmail(txtEmail.getText());
					usuarios.setSexo(txtSexo.getText());

					Connection connection = JdbUtil.getConnection();
					UsuariosJdbcDAO usuariosJdbcDao = new UsuariosJdbcDAO(connection);
					TarefasJdbcDAO tarefasJdbcDao = new TarefasJdbcDAO (connection);

					usuariosJdbcDao.salvar(usuarios);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});

		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		App app = new App();
	}
}
