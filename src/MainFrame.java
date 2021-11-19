import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static JPanel contentPane;
	private static JFrame loginFrame;
	private static JTextField textField_limite;
	private static JTextField textField_cotizacion;
	private static JTextField textField_comision;
	private static JTextField usernameField;
	private static JPasswordField passwordField;
	private static JTextField textField_cargarbtc;
	private static JTextField textField_cargarusd;
	private static JTextField textField_register_username;
	private static JTextField textField_register_pass;
	private static JCheckBox chckbxEsPreferencial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					controlExecution(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

	private static void controlExecution(MainFrame frame) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Configuracion configuracion = new Configuracion(-1, -1);
		Usuario admin = Helpers.addAdmin();
		usuarios.add(admin);
		Usuario adminPreferencial = Helpers.addAdminPreferencial();
		usuarios.add(adminPreferencial);
		Integer limite = null;
		Cuenta cuentaAdmin = new Cuenta(false, 0, adminPreferencial, false, null);
		cuentas.add(cuentaAdmin);
		JPanel loginPanel = loginPanel();
		contentPane.add(loginPanel, 0);
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int userid = -1;
				String usernameEnter = usernameField.getText();
				char passwEnter[] = passwordField.getPassword();
				String passEnter = "";
				for (int i = 0; i < passwEnter.length; i++) {
					passEnter += passwEnter[i];
				}
				for (int i = 0; i < usuarios.size(); i++) {
					Usuario usuario = usuarios.get(i);
					if (usuario.password.equals(passEnter) && usuario.username.equals(usernameEnter)) {
						userid = usuario.internalid;
					}
				}
				if (userid == -1) {
					JOptionPane.showMessageDialog(null, "Contraseña equivocada, reintente.");
				} else {
					JOptionPane.showMessageDialog(null, "Bienvenido");

					if (usuarios.get(userid).admin) {

						loginPanel.setVisible(false);
						JPanel adminPanel = getAdminPanel();
						contentPane.add(adminPanel, 0);
						JButton btnCrear = new JButton("Crear");
						JButton buttonLimit = new JButton("Limitar");

						JButton btnSalir = new JButton("SALIR");
						btnSalir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								adminPanel.setVisible(false);
								loginPanel.setVisible(true);
							}
						});
						btnSalir.setBounds(39, 21, 89, 23);
						adminPanel.add(btnSalir);

						buttonLimit.setBounds(371, 581, 89, 23);
						adminPanel.add(buttonLimit);
						btnCrear.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String user_reg = textField_register_username.getText();
								String pass_reg = textField_register_pass.getText();
								boolean isPref_reg = chckbxEsPreferencial.isSelected();
								if (user_reg != null && pass_reg != null && pass_reg != "" && user_reg != "") {
									Usuario newUsuario = new Usuario(user_reg, pass_reg, isPref_reg, usuarios.size(),
											false);
									usuarios.add(newUsuario);
									Cuenta cuentaUsuarioBTC = new Cuenta(true, 0, newUsuario, false, null);
									Cuenta cuentaUsuarioUSD = new Cuenta(false, 10, newUsuario, false, null);
									cuentas.add(cuentaUsuarioUSD);
									cuentas.add(cuentaUsuarioBTC);

								} else {
									JOptionPane.showMessageDialog(null, "Usuario o contraseña vacios. Reintente");
								}
							}
						});
						btnCrear.setBounds(63, 296, 115, 54);
						adminPanel.add(btnCrear);
						int limiteSet = Integer.parseInt(textField_limite.getText());
						buttonLimit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								for (int i = 0; i < cuentas.size(); i++) {
									if (i != 0) {
										cuentas.get(i).limite = limiteSet;
									}
								}
							}
						});

						JButton btnCotizacion = new JButton("Establecer");
						int cotizacionSet = Integer.parseInt(textField_cotizacion.getText());
						btnCotizacion.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								configuracion.cotizacion = cotizacionSet;
							}
						});
						btnCotizacion.setBounds(401, 303, 89, 23);
						adminPanel.add(btnCotizacion);

						JButton btnComision = new JButton("Establecer");
						btnComision.setBounds(371, 678, 89, 23);
						int comision = Integer.parseInt(textField_comision.getText());
						btnComision.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								configuracion.comision = comision;
							}
						});
						adminPanel.add(btnComision);
						JLabel lblganancia = new JLabel("Ganancia");
						lblganancia.setBounds(52, 536, 124, 14);
						adminPanel.add(lblganancia);
						int saldoDelAdmin = cuentas.get(0).saldo;
						lblganancia.setText(lblganancia.getText() + " $" + saldoDelAdmin);

						JLabel label_usuarios_cre = new JLabel("Usuarios creados");
						label_usuarios_cre.setBounds(52, 499, 124, 14);
						adminPanel.add(label_usuarios_cre);
						lblganancia.setText(lblganancia.getText() + " " + (usuarios.size() - 2));

					} else {
						loginPanel.setVisible(false);
						JPanel usuarioPanel = saldoPanel();
						contentPane.add(usuarioPanel);
						usuarioPanel.setVisible(true);
						JLabel lblUltimoMovimiento = new JLabel("ULTIMO MOVIMIENTO:");
						lblUltimoMovimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
						lblUltimoMovimiento.setBounds(674, 163, 205, 30);
						usuarioPanel.add(lblUltimoMovimiento);

						JButton btnSalir = new JButton("SALIR");
						btnSalir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								usuarioPanel.setVisible(false);
								loginPanel.setVisible(true);
							}
						});
						btnSalir.setBounds(39, 21, 89, 23);
						usuarioPanel.add(btnSalir);
						for (int i = 0; i < cuentas.size(); i++) {
							Cuenta cuenta = cuentas.get(i);
							if (cuenta.usuario.equals(usuarios.get(userid))) {
								if (cuenta.isBitcoin) {
									JLabel lblSaldoBit = new JLabel("BTC " + String.valueOf(cuenta.saldo));
									lblSaldoBit.setFont(new Font("Tahoma", Font.PLAIN, 14));
									lblSaldoBit.setBounds(279, 215, 233, 30);
									usuarioPanel.add(lblSaldoBit);
								} else {
									JLabel lblSaldoDolares = new JLabel("$" + String.valueOf(cuenta.saldo));
									lblSaldoDolares.setFont(new Font("Tahoma", Font.PLAIN, 14));
									lblSaldoDolares.setBounds(279, 163, 117, 30);
									usuarioPanel.add(lblSaldoDolares);
								}
							}
						}

						JButton btnCargarbtc = new JButton("Cargar 0.01BTC");
						btnCargarbtc.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								textField_cargarbtc.setText("0.1");
							}
						});
						btnCargarbtc.setBounds(93, 461, 135, 23);
						usuarioPanel.add(btnCargarbtc);

						JButton btnCargarbtc_1 = new JButton("Cargar 0.001BTC");
						btnCargarbtc_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								textField_cargarbtc.setText("0.001");
							}
						});
						btnCargarbtc_1.setBounds(183, 427, 135, 23);
						usuarioPanel.add(btnCargarbtc_1);

						JButton btnCargarbtc_2 = new JButton("Cargar 0.0001BTC");
						btnCargarbtc_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								textField_cargarbtc.setText("0.0001");
							}
						});
						btnCargarbtc_2.setBounds(23, 427, 135, 23);
						usuarioPanel.add(btnCargarbtc_2);

						JLabel lblEquivaleAPlaceholder = new JLabel("Equivale a 0 dolares");
						lblEquivaleAPlaceholder.setBounds(341, 417, 171, 60);
						usuarioPanel.add(lblEquivaleAPlaceholder);
						textField_cargarbtc.addKeyListener(new KeyAdapter() {
							@Override
							public void keyTyped(KeyEvent arg0) {
								int cotizacion = configuracion.cotizacion;
								int plata = Integer.parseInt(textField_cargarbtc.getText());
								lblEquivaleAPlaceholder.setText("Equivale a " + plata * cotizacion + " dolares");
							}
						});
						ArrayList<Integer> loggedUser = new ArrayList<Integer>();
						loggedUser.add(userid);
						JButton btnCargarDolares = new JButton("CARGAR DOLARES");
						btnCargarDolares.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int retorno = cargarSaldoEnUSD(usuarios.get(loggedUser.get(0)),
										Integer.parseInt(textField_cargarusd.getText()));
								if (retorno == 2) {
									JOptionPane.showMessageDialog(null, "Fallo de conexión");
								} else if (retorno == 3) {
									JOptionPane.showMessageDialog(null, "No tiene saldo suficiente.");
								} else {
									Usuario usuarioActual = usuarios.get(loggedUser.get(0));
									for (int k = 0; k < cuentas.size(); k++) {
										Cuenta cuenta = cuentas.get(k);
										if (!cuenta.isBitcoin && cuenta.usuario.equals(usuarioActual)) {
											cuentas.get(k).saldo = cuentas.get(k).saldo
													+ Integer.parseInt(textField_cargarusd.getText());
										}
									}

								}

							}

							public int cargarSaldoEnUSD(Usuario elUsuario, float monto) {
								float numero = (float) (Math.random() * 20 + 1);
								if (numero <= 15 && monto < 20) {
									return 1;
								} else if (numero > 15 && numero < 17) {
									return 2;
								} else {
									return 3;
								}
							}

						});
						btnCargarDolares.setBounds(737, 572, 205, 57);
						usuarioPanel.add(btnCargarDolares);

					}
				}

			}

		});
		btnEnviar.setBounds(253, 350, 214, 94);
		loginPanel.add(btnEnviar);

	}

	private static JPanel loginPanel() {
		JPanel thisLoginPanel = new JPanel();
		thisLoginPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(133, 174, 63, 33);
		thisLoginPanel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(133, 250, 63, 33);
		thisLoginPanel.add(lblPassword);

		usernameField = new JTextField();
		usernameField.setBounds(195, 180, 171, 33);
		thisLoginPanel.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(195, 253, 171, 30);
		thisLoginPanel.add(passwordField);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLogin.setBounds(339, 50, 72, 82);
		thisLoginPanel.add(lblLogin);

		return thisLoginPanel;
	}

	private static JPanel movPanel() {
		JPanel movimientosPanel = new JPanel();
		movimientosPanel.setLayout(null);
		JLabel lblMovimientos = new JLabel("MOVIMIENTOS");
		lblMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMovimientos.setBounds(369, 37, 278, 41);
		movimientosPanel.add(lblMovimientos);
		return movimientosPanel;
	}

	private static JPanel saldoPanel() {
		JPanel saldosPanel = new JPanel();
		saldosPanel.setLayout(null);

		JLabel lblSaldos = new JLabel("SALDOS");
		lblSaldos.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblSaldos.setBounds(484, 23, 272, 72);
		saldosPanel.add(lblSaldos);

		JLabel lblUstedTiene = new JLabel("USTED TIENE EN CUENTA USD");
		lblUstedTiene.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUstedTiene.setBounds(10, 163, 205, 30);
		saldosPanel.add(lblUstedTiene);

		textField_cargarbtc = new JTextField();
		textField_cargarbtc.setBounds(142, 506, 86, 20);
		saldosPanel.add(textField_cargarbtc);
		textField_cargarbtc.setColumns(10);

		JLabel lblCargar = new JLabel("CARGAR:");
		lblCargar.setBounds(41, 509, 46, 14);
		saldosPanel.add(lblCargar);

		JButton btnComprarBitcoins = new JButton("COMPRAR BITCOINS $$");
		btnComprarBitcoins.setBounds(52, 569, 243, 60);
		saldosPanel.add(btnComprarBitcoins);

		JLabel lblUstedTieneEn = new JLabel("USTED TIENE EN CUENTA BITCOIN:");
		lblUstedTieneEn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUstedTieneEn.setBounds(10, 215, 233, 30);
		saldosPanel.add(lblUstedTieneEn);

		textField_cargarusd = new JTextField();
		textField_cargarusd.setBounds(866, 503, 86, 20);
		saldosPanel.add(textField_cargarusd);
		textField_cargarusd.setColumns(10);

		JLabel lblCargar_1 = new JLabel("CARGAR:");
		lblCargar_1.setBounds(761, 486, 63, 60);
		saldosPanel.add(lblCargar_1);
		return saldosPanel;
	}

	private static JPanel getAdminPanel() {
		JPanel registroPanel = new JPanel();

		registroPanel.setLayout(null);

		textField_register_username = new JTextField();
		textField_register_username.setBounds(160, 154, 86, 20);
		registroPanel.add(textField_register_username);
		textField_register_username.setColumns(10);

		textField_register_pass = new JTextField();
		textField_register_pass.setColumns(10);
		textField_register_pass.setBounds(160, 197, 86, 20);
		registroPanel.add(textField_register_pass);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(63, 157, 46, 14);
		registroPanel.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(63, 200, 46, 14);
		registroPanel.add(lblPassword);

		chckbxEsPreferencial = new JCheckBox("Es preferencial?");
		chckbxEsPreferencial.setBounds(149, 251, 140, 23);
		registroPanel.add(chckbxEsPreferencial);

		JLabel lblCrearUsuarios = new JLabel("CREAR USUARIOS");
		lblCrearUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCrearUsuarios.setBounds(39, 60, 207, 114);
		registroPanel.add(lblCrearUsuarios);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(63, 296, 115, 54);
		registroPanel.add(btnCrear);

		JLabel label_1 = new JLabel("ADMIN CONFIGURATIONS");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		label_1.setBounds(232, 21, 431, 54);
		registroPanel.add(label_1);

		JLabel label_3 = new JLabel("Establecer l\u00EDmite");
		label_3.setBounds(52, 585, 124, 14);
		registroPanel.add(label_3);

		textField_limite = new JTextField();
		textField_limite.setColumns(10);
		textField_limite.setBounds(255, 582, 86, 20);
		registroPanel.add(textField_limite);

		textField_cotizacion = new JTextField();
		textField_cotizacion.setColumns(10);
		textField_cotizacion.setBounds(255, 627, 86, 20);
		registroPanel.add(textField_cotizacion);

		JLabel label_4 = new JLabel("Establecer cotizaci\u00F3n 1 BTC a USD");
		label_4.setBounds(52, 630, 193, 14);
		registroPanel.add(label_4);

		JLabel label_5 = new JLabel("Establecer porcentaje de comisi\u00F3n");
		label_5.setBounds(52, 682, 193, 14);
		registroPanel.add(label_5);

		textField_comision = new JTextField();
		textField_comision.setColumns(10);
		textField_comision.setBounds(255, 679, 86, 20);
		registroPanel.add(textField_comision);

		return registroPanel;

	}
}
