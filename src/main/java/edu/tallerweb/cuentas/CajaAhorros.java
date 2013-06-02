package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracción de dinero se cobre un costo adicional
 * por extracción de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	  private Integer numeroDeExtraccion;

	public CajaAhorros(){
		super();
		this.numeroDeExtraccion = 0;
	}
	
	/**
	 * No hay reglas adicionales para el depósito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if(monto > 0.00){
			this.saldo += monto;	
		}
		else{
			throw new CuentaBancariaException("Sr cliente debe depositar un saldo mayor a 0 en su caja de ahorros.");
		}
		//throw new RuntimeException("No implementado aún");
	}

	/**
	 * Se cobran $6 adicionales por cada extracción luego de
	 * la quinta.
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if(monto > 0.00){
			if(this.saldo >= monto && numeroDeExtraccion < 5){
				this.saldo -= monto;
				numeroDeExtraccion++;
			}
			else{
				if(this.saldo >= (monto + 6.00) && numeroDeExtraccion >= 5){
					this.saldo -= (monto + 6.00);
					numeroDeExtraccion++;
				}
				else{
					if(this.saldo < monto || this.saldo <= monto + 6.00){
						throw new CuentaBancariaException("Sr Cliente no dispone de saldo para realizar la extracci�n que desea en su caja de ahorros.");
					}
				}
			}
		}
	    else{
			throw new CuentaBancariaException("Sr cliente el monto a extraer de su caja de ahorros debe ser mayor a 0 .");
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
