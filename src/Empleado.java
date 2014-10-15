
public abstract class Empleado {
	
	
	private String dni;
	private float sueldo_base;
	
	
	
	public Empleado(String dni, float sueldo_base){
		this.dni=dni;
		this.sueldo_base=sueldo_base;
	}
	
	public abstract float get_sueldoMes();

	protected String getDni() {
		return dni;
	}


	protected float getSueldo_base() {
		return sueldo_base;
	}

	protected void setSueldo_base(float sueldo_base) {
		this.sueldo_base = sueldo_base;
	}
	
	

}
