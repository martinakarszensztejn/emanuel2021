import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_Registro extends JPanel {
	private JTextField textField_register_username;
	private JTextField textField_register_pass;
	private JTextField textField_limite;
	private JTextField textField_cotizacion;
	private JTextField textField_comision;

	/**
	 * Create the panel.
	 */
	public UI_Registro() {
		setLayout(null);
		
		textField_register_username = new JTextField();
		textField_register_username.setBounds(160, 154, 86, 20);
		add(textField_register_username);
		textField_register_username.setColumns(10);
		
		textField_register_pass = new JTextField();
		textField_register_pass.setColumns(10);
		textField_register_pass.setBounds(160, 197, 86, 20);
		add(textField_register_pass);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(63, 157, 46, 14);
		add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(63, 200, 46, 14);
		add(lblPassword);
		
		JCheckBox chckbxEsPreferencial = new JCheckBox("Es preferencial?");
		chckbxEsPreferencial.setBounds(149, 251, 140, 23);
		add(chckbxEsPreferencial);
		
		JLabel lblCrearUsuarios = new JLabel("CREAR USUARIOS");
		lblCrearUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCrearUsuarios.setBounds(39, 60, 207, 114);
		add(lblCrearUsuarios);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCrear.setBounds(63, 296, 115, 54);
		add(btnCrear);
		
		JLabel label = new JLabel("Usuarios creados");
		label.setBounds(52, 499, 124, 14);
		add(label);
		
		JLabel label_1 = new JLabel("ADMIN CONFIGURATIONS");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label_1.setBounds(232, 21, 431, 54);
		add(label_1);
		
		JLabel label_2 = new JLabel("Ganancia");
		label_2.setBounds(52, 536, 124, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Establecer l\u00EDmite");
		label_3.setBounds(52, 585, 124, 14);
		add(label_3);
		
		textField_limite = new JTextField();
		textField_limite.setColumns(10);
		textField_limite.setBounds(255, 582, 86, 20);
		add(textField_limite);
		
		JButton button = new JButton("Limitar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(371, 581, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Establecer");
		button_1.setBounds(371, 626, 89, 23);
		add(button_1);
		
		textField_cotizacion = new JTextField();
		textField_cotizacion.setColumns(10);
		textField_cotizacion.setBounds(255, 627, 86, 20);
		add(textField_cotizacion);
		
		JLabel label_4 = new JLabel("Establecer cotizaci\u00F3n 1 BTC a USD");
		label_4.setBounds(52, 630, 193, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Establecer porcentaje de comisi\u00F3n");
		label_5.setBounds(52, 682, 193, 14);
		add(label_5);
		
		textField_comision = new JTextField();
		textField_comision.setColumns(10);
		textField_comision.setBounds(255, 679, 86, 20);
		add(textField_comision);
		
		JButton button_2 = new JButton("Establecer");
		button_2.setBounds(371, 678, 89, 23);
		add(button_2);
		
	

	}
}
