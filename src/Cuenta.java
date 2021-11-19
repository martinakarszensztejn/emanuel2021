
public class Cuenta {

	public boolean isBitcoin;
	public int saldo;
	public Usuario usuario;
	public boolean disabled;
	public int limite;

	public Cuenta(boolean _isBitcoin, int _saldo, Usuario _usuario, boolean _disabled, Integer _limite) {
		saldo = _saldo;
		usuario = _usuario;
		disabled = _disabled;
		limite = _limite;
		isBitcoin = _isBitcoin;
	}

}
