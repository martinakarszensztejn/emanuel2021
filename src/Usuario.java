
public class Usuario {
	public String username;
	String password;
	public boolean preferencial;
	public int internalid;
	boolean admin;

	public Usuario(String _username, String _password, boolean _preferencial, int _internalid, boolean _admin) {
		username = _username;
		password = _password;
		preferencial = _preferencial;
		internalid = _internalid;
		admin = _admin;
	}
}
