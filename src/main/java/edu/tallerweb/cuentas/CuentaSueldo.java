package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta más simple, ya que se rige por la premisa
 * de que en tanto y en cuanto se tenga tanto o más dinero en
 * cuenta del que se quiere extraer, la operación se debe efectuar
 * correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {
	
	public CuentaSueldo(){
		super();
	}

	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if (monto > 0.00){
			this.saldo += monto;	
		}
		else{
			throw new CuentaBancariaException("Sr cliente debe depositar un saldo mayor a 0 en su cuenta sueldo.");
		}
		//throw new RuntimeException("No implementado aún");
	}

	/**
	 * No hay reglas adicionales para la extracción
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if (monto > 0.00){		
		if (this.saldo >= monto){
			this.saldo -= monto;
		}
		else{
			throw new CuentaBancariaException("Sr Cliente no dispone de saldo para realizar la extracci�n que desea en su cuenta corriente.");
		}
		//throw new RuntimeException("No implementado aún");
	    }
		else{
			throw new CuentaBancariaException("Sr cliente el monto a extraer de su cuenta sueldo debe ser mayor a 0.");
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
