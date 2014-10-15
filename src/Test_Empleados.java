import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Test_Empleados {
	private static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
	private static ArrayList<Empleado> array=null;
	public static void main(String[] args) {
		
		byte op=0;
		do{
			try{
			System.out.println("1. Contratar Empleado ");
			System.out.println("2. Despedir Empleado ");
			System.out.println("3. Comenzar mes ");
			System.out.println("4. Añade horas fuera de horario a programador ");
			System.out.println("5. Añade aplicacion entregada a jefe de proyecto");
			System.out.println("6. Muesta sueldo de todos los empleados ");
			System.out.println("7. Salir ");
			
			System.out.print("Opcion => ");
			op=Byte.parseByte(stdin.readLine());
		
			}catch(Exception e){
				System.out.print("Error");
			}	
		switch(op){
		case 1://contrata empleado
			boolean entra=false; 
			byte tipo=0;
			String dni="";
			float suelo_base=0;
			do{
			System.out.println("1. Programador");
			System.out.println("2. Jefe Proyecto");
			System.out.println("3. Administrativo");
			try{
				System.out.print("Que tipo de Trabajador es => ");
				tipo=Byte.parseByte(stdin.readLine());
			}catch(Exception e){
				System.out.println("Valores del 1 al 3");
			}
			}while(tipo<1 && tipo>3);
			try{
			System.out.print("DNI del empleado => ");
			dni=stdin.readLine();
			System.out.print("Sueldo base del empleado => ");
			suelo_base=Float.parseFloat(stdin.readLine());
			}catch(Exception e){
				System.out.println("");
			}
			
			if(array==null){
				array=new ArrayList<Empleado>();
			}else{
				
				for(int i=0; i<array.size(); i++){
					if(array.get(i).getDni().equalsIgnoreCase(dni)){
						System.out.println("Ya existe otro empleado con este DNI no se ha añadido a la BBDD");
						entra=true;
					}
				}
			}
				if(entra==false){
					switch(tipo){
					case 1:
						array.add(new Programador(dni,suelo_base));
						System.out.println("Exito empleado añadido");
						break;
					case 2:
						array.add(new Jefe(dni,suelo_base));
						System.out.println("Exito empleado añadido");
						break;
					case 3:
						array.add(new Administrativo(dni,suelo_base));
						System.out.println("Exito empleado añadido");
						break;
					}				
				}
			break;
		case 2:// despide empleado
			dni="";
		    entra=false;
			if(array!=null){
				try{
					System.out.print("Introduce el DNI del empleado a despedir => ");
					dni=stdin.readLine();
				}catch(Exception e){
					System.out.println("Valor fuera de rango");
				}
			for(int i=0; i<array.size(); i++){
				
				if(array.get(i).getDni().equalsIgnoreCase(dni)){
					array.remove(i);
					System.out.println("Empleado borrado con exito");
					entra=true;
				}
			}
			if(entra==false){
				System.out.println("No existe ningun empleado con este dni");
			}
			}else{
				System.out.println("No hay empleados en la BBDD");
			}
			
			break;
		case 3://comienza el mes
			if(array!=null){
			for(int i=0; i<array.size(); i++){
				
				if(array.get(i) instanceof Programador ){
					Programador a=(Programador) array.get(i);
					a.setHorasTE(0);
				}else if(array.get(i) instanceof Jefe){
					Jefe a=(Jefe)array.get(i);
					a.setAplicaciones_entregadas(0);
				}
			}
			}else{
				System.out.println("No hay empleados en la BBDD");
			}
			break;
		case 4://añadir horas extras a programadores
			double horasTE=0;
			entra=false;
			dni="";
			if(array!=null){
				try{			
					System.out.print("Introduce el DNI del Programador => ");
					dni=stdin.readLine();
					System.out.print("Horas extras => ");
					horasTE=Double.parseDouble(stdin.readLine());		
				}catch(Exception e){
					System.out.println("Valores fuera de rango");
				}			
			for(int i=0; i<array.size(); i++){
				if(array.get(i) instanceof Programador){
					if(array.get(i).getDni().equalsIgnoreCase(dni)){
						Programador a=(Programador) array.get(i);
						a.setHorasTE(horasTE);
						entra=true;	
						System.out.println("Exito al añadir las horas extras al programador");
					}
				}
			}
			if(entra==false){
				System.out.println("Este dni no esta en la lista de los empleados porgramadoes");
			}
			}else{
				System.out.println("No hay empleados en la BBDD");
			}	
			break;
		case 5: //añadir aplicaciones entregadas al jefe de proyectos
			dni="";
			entra=false;
			if(array!=null){
				try{
					System.out.print("Introduce el DNI del Jefe de Proyecto => ");
					dni=stdin.readLine();		
				}catch(Exception e){
					System.out.println("Valores fuera de rango");
				}
				for(int i=0; i<array.size(); i++){
					if(array.get(i) instanceof Jefe){
						if(array.get(i).getDni().equalsIgnoreCase(dni)){
							Jefe a=(Jefe)array.get(i);
							a.setAplicaciones_entregadas(a.getAplicaciones_entregadas()+1);
							System.out.println("Se ha añadido correctamente un aplicacion");
							entra=true;
						}
					}
				}
				if(entra==false){
					System.out.println("No hay ningun Jefe de Proyecto con este dni");
				}		
			}else{
				System.out.println("No hay empleados en la BBDD");
			}	
			break;
		case 6://ver sueldos empleados
			
			if(array!=null){
				System.out.println("TIPO\t\tDNI\tSUELDO");
				for(int i=0; i<array.size(); i++){
					if(array.get(i) instanceof Programador){
						System.out.println("PROGRAMADOR\t"+array.get(i).getDni()+"\t"+array.get(i).get_sueldoMes()+"€");			
					}else if(array.get(i) instanceof Jefe){
						System.out.println("JEFE PROY.\t"+array.get(i).getDni()+"\t"+array.get(i).get_sueldoMes()+"€");
					}else{
						System.out.println("ADMINISTRA.\t"+array.get(i).getDni()+"\t"+array.get(i).get_sueldoMes()+"€");
					}
				}
				
			}else{
				System.out.println("No hay empleados en la BBDD");
			}		
			break;
		case 7:
			System.out.println("Bye");
			break;
			default:
				System.out.println(" Valores numericos del 1 al 7");
				break;	
		}
		}while(op!=7);
	}
}
