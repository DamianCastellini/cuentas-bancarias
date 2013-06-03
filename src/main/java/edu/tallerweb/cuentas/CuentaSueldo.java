package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta más simple, ya que se rige por la premisa
 * de que en tanto y en cuanto se tenga tanto o más dinero en
 * cuenta del que se quiere extraer, la operación se debe efectuar
 * correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {
	public CuentaSueldo() {
		super();
	}
	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if (monto > CERO) {
			this.saldo += monto;
		}
		else {
			throw new CuentaBancariaException("Debe depositar un saldo mayor a 0.");
			//throw new RuntimeException("No implementado aún");
		}
	}
	/**
	 * No hay reglas adicionales para la extracción
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if (monto > CERO) {
			if (this.saldo >= monto) {
				this.saldo -= monto;
				}
		else {
			throw new CuentaBancariaException("No dispone de saldo para realizar la extracci�n.");
		}
		//throw new RuntimeException("No implementado aún");
	    }
		else {
			throw new CuentaBancariaException("El monto a extraer debe ser mayor a 0.");
		}
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
