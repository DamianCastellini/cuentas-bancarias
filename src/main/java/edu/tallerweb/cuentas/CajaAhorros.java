package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracci贸n de dinero se cobre un costo adicional
 * por extracci贸n de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	  private Integer numeroDeExtraccion;

	public CajaAhorros(){
		super();
		this.numeroDeExtraccion = 0;
	}
	
	/**
	 * No hay reglas adicionales para el dep贸sito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if(monto > 0.00){
			this.saldo += monto;	
		}
		else{
			throw new CuentaBancariaException("Sr cliente debe depositar un saldo mayor a 0 en su caja de ahorros.");
		}
		//throw new RuntimeException("No implementado a煤n");
	}

	/**
	 * Se cobran $6 adicionales por cada extracci贸n luego de
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
						throw new CuentaBancariaException("Sr Cliente no dispone de saldo para realizar la extracci髇 que desea en su caja de ahorros.");
					}
				}
			}
		}
	    else{
			throw new CuentaBancariaException("Sr cliente el monto a extraer de su caja de ahorros debe ser mayor a 0 .");
		}
	
		
		
		//throw new RuntimeException("No implementado a煤n");
	}

	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.saldo;
		//throw new RuntimeException("No implementado a煤n");
	}

}
