import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_Login extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	public String[] loginData;

	/**
	 * Create the panel.
	 */
	public UI_Login() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(133, 174, 63, 33);
		add(lblNewLabel);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(133, 250, 63, 33);
		add(lblPassword);

		usernameField = new JTextField();
		usernameField.setBounds(195, 180, 171, 33);
		add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(195, 253, 171, 30);
		add(passwordField);

		JButton btnEnviar = new JButton("ENVIAR");
		String _loginData[] = new String[2];
		btnEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String usernameInput = usernameField.getText();
				String passwordInput = passwordField.getText();
				_loginData[0]=usernameInput;
				_loginData[1]=passwordInput;
				loginData=_loginData;
				
			}
		});
		btnEnviar.setBounds(253, 350, 214, 94);
		add(btnEnviar);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(339, 50, 72, 82);
		add(lblLogin);

	}


}
