package edu.tallerweb.cuentas;

/**
 * La más compleja de las cuentas, ésta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no sólo se considera
 * el que se posee, sino el límite adicional que el banco
 * estará brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrará
 * un 5% como comisión sobre todo el monto en descubierto
 * consumido en la operación.
 *
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubrió, más el 5% adicional sobre el descubierto otorgado.
 */
public class CuentaCorriente extends AbstractCuenta {
	private Double descubiertoTotal;
	private Double deuda;
	
	public CuentaCorriente(){
		super();
		this.deuda = 0.00;
	}

	/**
	 * Toda cuenta corriente se inicia con un límite total
	 * para el descubierto.
	 * @param descubiertoTotal
	 */
	public CuentaCorriente(final Double descubiertoTotal) {
		this.descubiertoTotal = descubiertoTotal;
		//throw new RuntimeException("No implementado aún");
	}
	
	/**
	 * Todo depósito deberá cubrir primero el descubierto,
	 * si lo hubiera, y luego contar para el saldo de la
	 * cuenta.
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if(monto > 0.00){ 
			if(this.deuda == 0.00){
				this.saldo += monto;
				}
			else{
				if(this.deuda >= monto){
					this.deuda -= monto;
					}
				else{
					if(this.deuda < monto){
					this.saldo = monto - this.deuda;
					this.deuda = 0.00;
					}
					}
				
				}
		}
		else{
			throw new CuentaBancariaException("Sr Cliente: Debe depositar un monto mayor a 0.");
			}
		//throw new RuntimeException("No implementado aún");
	}

	/**
	 * Se cobrará el 5% de comisión sobre el monto girado
	 * en descubierto.
	 * Por supuesto, no puede extraerse más que el total
	 * de la cuenta, más el descubierto (comisión incluída)
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		 if(this.saldo >= monto){
			   this.saldo -= monto;
			 }
			 else
			 {
			  if(this.saldo < monto){
				  if((this.saldo + (this.descubiertoTotal - this.deuda))>= monto){					  
					  this.deuda = this.deuda + ((this.saldo - monto) * 1.05 );
					  this.saldo = 0.00;
					  }
				  else{
					  throw new CuentaBancariaException("Sr. Cliente no posee la cantidad suficiente de saldo para realizar la extracci�n");
					  }
			  }
				  
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
	
	/**
	 * Permite saber el saldo en descubierto
	 * @return el descubierto de la cuenta
	 */
	public Double getDescubierto() {
		return this.descubiertoTotal;
		//throw new RuntimeException("No implementado aún");
	}

}
