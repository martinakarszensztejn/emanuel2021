import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class UI_Movimientos extends JPanel {

	/**
	 * Create the panel.
	 */
	public UI_Movimientos() {
		setLayout(null);
		
		JLabel lblMovimientos = new JLabel("MOVIMIENTOS");
		lblMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMovimientos.setBounds(369, 37, 278, 41);
		add(lblMovimientos);

	}

}
