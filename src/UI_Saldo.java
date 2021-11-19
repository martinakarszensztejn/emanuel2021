import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UI_Saldo extends JPanel {
	private JTextField textField_cargarbtc;
	private JTextField textField_cargarusd;

	/**
	 * Create the panel.
	 */
	public UI_Saldo() {
		setLayout(null);
		
		JLabel lblSaldos = new JLabel("SALDOS");
		lblSaldos.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblSaldos.setBounds(484, 23, 272, 72);
		add(lblSaldos);
		
		JLabel lblUstedTiene = new JLabel("USTED TIENE EN CUENTA USD");
		lblUstedTiene.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUstedTiene.setBounds(10, 163, 205, 30);
		add(lblUstedTiene);
		
		JLabel lblNewLabel = new JLabel("placeholder");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(279, 163, 117, 30);
		add(lblNewLabel);
		
		textField_cargarbtc = new JTextField();
		textField_cargarbtc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		textField_cargarbtc.setBounds(142, 506, 86, 20);
		add(textField_cargarbtc);
		textField_cargarbtc.setColumns(10);
		
		JLabel lblCargar = new JLabel("CARGAR:");
		lblCargar.setBounds(41, 509, 46, 14);
		add(lblCargar);
		
		JButton btnCargarbtc = new JButton("Cargar 0.01BTC");
		btnCargarbtc.setBounds(93, 461, 135, 23);
		add(btnCargarbtc);
		
		JButton btnCargarbtc_1 = new JButton("Cargar 0.001BTC");
		btnCargarbtc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCargarbtc_1.setBounds(183, 427, 135, 23);
		add(btnCargarbtc_1);
		
		JButton btnCargarbtc_2 = new JButton("Cargar 0.0001BTC");
		btnCargarbtc_2.setBounds(23, 427, 135, 23);
		add(btnCargarbtc_2);
		
		JLabel lblEquivaleAPlaceholder = new JLabel("Equivale a placeholder d\u00F3lares");
		lblEquivaleAPlaceholder.setBounds(341, 417, 171, 60);
		add(lblEquivaleAPlaceholder);
		
		JButton btnComprarBitcoins = new JButton("COMPRAR BITCOINS $$");
		btnComprarBitcoins.setBounds(52, 569, 243, 60);
		add(btnComprarBitcoins);
		
		JLabel lblUstedTieneEn = new JLabel("USTED TIENE EN CUENTA BITCOIN:");
		lblUstedTieneEn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUstedTieneEn.setBounds(10, 215, 233, 30);
		add(lblUstedTieneEn);
		
		JLabel lblPlaceholder = new JLabel("placeholder");
		lblPlaceholder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaceholder.setBounds(279, 215, 233, 30);
		add(lblPlaceholder);
		
	
		
		textField_cargarusd = new JTextField();
		textField_cargarusd.setBounds(866, 503, 86, 20);
		add(textField_cargarusd);
		textField_cargarusd.setColumns(10);
		
		JLabel lblCargar_1 = new JLabel("CARGAR:");
		lblCargar_1.setBounds(761, 486, 63, 60);
		add(lblCargar_1);
		
		JLabel lblUltimoMovimiento = new JLabel("ULTIMO MOVIMIENTO:");
		lblUltimoMovimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUltimoMovimiento.setBounds(674, 163, 205, 30);
		add(lblUltimoMovimiento);

	}

}
