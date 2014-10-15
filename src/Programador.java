
public final class Programador extends Empleado {

	private double extras=0.025;// 0.25% mas por hora
	private double horasTE;  //horas extras
	
	
	public Programador(String dni, float sueldo_base ){
		super(dni, sueldo_base);
	
	}

	public float get_sueldoMes() {
		
		System.out.println("Sueldo base => "+this.getSueldo_base());
		System.out.println("Extras (0.25)=> "+extras);
		System.out.println("Horas extras => "+this.horasTE);	
		return (float)((this.getSueldo_base())+(extras*this.getSueldo_base()*this.horasTE));
	}


	protected double getHorasTE() {
		return horasTE;
	}


	protected void setHorasTE(double horasTE) {
		this.horasTE = horasTE;
	}
	
	

}
