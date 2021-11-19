import java.util.Date;

public class Transaccion {
	public int internalid;
	int monto;
	Date fecha;
	Usuario usuario;

	public Transaccion(int a, int b, Date c, Usuario d) {
		internalid = a;
		monto = b;
		fecha = c;
		usuario = d;
	}
}
