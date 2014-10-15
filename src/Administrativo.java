
public final class Administrativo extends Empleado {

	
	
	public Administrativo(String dni, float sueldo_base) {
		super(dni, sueldo_base);
	}

	
	public float get_sueldoMes() {
		
		return this.getSueldo_base();
	}

}
