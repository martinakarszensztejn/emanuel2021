import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_Admin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public UI_Admin() {
		setLayout(null);
		
		JLabel lblAdminConfigurations = new JLabel("ADMIN CONFIGURATIONS");
		lblAdminConfigurations.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblAdminConfigurations.setBounds(265, 23, 431, 54);
		add(lblAdminConfigurations);
		
		JLabel lblUsuariosCreados = new JLabel("Usuarios creados");
		lblUsuariosCreados.setBounds(82, 176, 124, 14);
		add(lblUsuariosCreados);
		
		JLabel lblGanancia = new JLabel("Ganancia");
		lblGanancia.setBounds(82, 213, 124, 14);
		add(lblGanancia);
		
		JLabel lblEstablecerLmite = new JLabel("Establecer l\u00EDmite");
		lblEstablecerLmite.setBounds(82, 262, 124, 14);
		add(lblEstablecerLmite);
		
		textField = new JTextField();
		textField.setBounds(285, 259, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnLimitar = new JButton("Limitar");
		btnLimitar.setBounds(401, 258, 89, 23);
		add(btnLimitar);
		
		JButton btnCotizacion = new JButton("Establecer");
		btnCotizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCotizacion.setBounds(401, 303, 89, 23);
		add(btnCotizacion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(285, 304, 86, 20);
		add(textField_1);
		
		JLabel lblEstablecerCotizacin = new JLabel("Establecer cotizaci\u00F3n 1 BTC a USD");
		lblEstablecerCotizacin.setBounds(82, 307, 193, 14);
		add(lblEstablecerCotizacin);
		
		JLabel lblEstablecerPorcentajeDe = new JLabel("Establecer porcentaje de comisi\u00F3n");
		lblEstablecerPorcentajeDe.setBounds(82, 359, 193, 14);
		add(lblEstablecerPorcentajeDe);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(285, 356, 86, 20);
		add(textField_2);
		
		JButton btnComision = new JButton("Establecer");
		btnComision.setBounds(401, 355, 89, 23);
		add(btnComision);

	}

}
