
public final class Jefe extends Empleado{

	
	private int aplicaciones_entregadas=0;
	
	public Jefe(String dni, float sueldo_base) {
		super(dni, sueldo_base);
		
	}

	
	public float get_sueldoMes() {
		
		return (float)(this.getSueldo_base()+((0.05*this.getSueldo_base())*this.aplicaciones_entregadas));
	}


	protected int getAplicaciones_entregadas() {
		return aplicaciones_entregadas;
	}


	protected void setAplicaciones_entregadas(int aplicaciones_entregadas) {
		this.aplicaciones_entregadas = aplicaciones_entregadas;
	}
	
	
	
	

}
