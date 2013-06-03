package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracción de dinero se cobre un costo adicional
 * por extracción de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	private Integer numeroDeExtraccion;
	private static final Integer MAX = 5;
	private static final Double IMPUESTO = 6.00;
	public CajaAhorros() {
		super();
		this.numeroDeExtraccion = 0;
	}
	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if (monto > CERO) {
			this.saldo += monto;
		} else {
			throw new CuentaBancariaException("Debe depositar un saldo mayor a 0.");
		}
		//throw new RuntimeException("No implementado aún");
	}
	/**
	 * Se cobran $6 adicionales por cada extracción luego de
	 * la quinta.
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if (monto > CERO) {
			if (this.saldo >= monto && numeroDeExtraccion < MAX) {
				this.saldo -= monto;
				numeroDeExtraccion++;
			} else {
				if (this.saldo >= (monto + IMPUESTO) && numeroDeExtraccion >= MAX) {
					this.saldo -= (monto + IMPUESTO);
					numeroDeExtraccion++;
				} else {
					if (this.saldo < monto || this.saldo <= monto + IMPUESTO) {
						throw new CuentaBancariaException("No posee saldo para extraer.");
					}
				}
			}
		} else {
	    	throw new CuentaBancariaException("El monto a extraer debe ser mayor a 0 .");
		}
		//throw new RuntimeException("No implementado aún");
	}
	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.saldo;
		//throw new RuntimeException("No implementado aún");
	}
}
