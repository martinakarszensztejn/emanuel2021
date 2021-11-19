import java.util.ArrayList;

public class Helpers {
	public static Usuario addAdmin() {
		Usuario admin = new Usuario("root", "root1sb0c01ns", false, 0, true);
		return admin;
	}
	public static Usuario addAdminPreferencial() {
		Usuario adminPref = new Usuario("root", "root1sb0c01ns", true, 1, true);
		return adminPref;
	}
	public static ArrayList<Cuenta> addCuenta(ArrayList<Cuenta> cuentas, Usuario usuario, Integer limite) {
		if(limite==null) {
			limite = 0;
		}
		Cuenta newCuentaBTC = new Cuenta(true, 0, usuario, false, limite);
		cuentas.add(newCuentaBTC);
		Cuenta newCuentaUSD = new Cuenta(false, 10, usuario, false, limite);
		cuentas.add(newCuentaUSD);
		return cuentas;
	}
	public static boolean validateAdmin(String user, String pass) {
		if (user.equals("root") && pass.equals("root1sb0c01ns")) {
			return true;
		} else {
			return false;
		}
	}

}
