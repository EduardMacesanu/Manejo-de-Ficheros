package Practicas;

public class Empleado {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private String telefono;
	private double salario;
	private String sexo;
	private String dni;
	
	
	public Empleado(String dni, String nombre, String apellido1, int edad, String apellido2, String telefono, double salario, String sexo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.telefono = telefono;
		this.salario = salario;
		this.sexo = sexo;
	}
		public Empleado(String dni2, String nombre2, String apellido12, String apellido22, int edad2, String sexo2,
			String telefono2, double salario2) {
		// TODO Auto-generated constructor stub
	}
		public String getDni() {
			return dni;
		}
		
		
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		
		public String getSexo() {
			return sexo;
		}
		
		
		public void setDni(String dni) {
			this.dni = dni;
		}
		
		
		public String getNombre() {
			return nombre;
		}
		
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		
		public String getApellido1() {
			return apellido1;
		}
		
		public String getApellido2() {
			return apellido2;
		}
		
		
		public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
		}
		
		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}
		
		
		public int getEdad() {
			return edad;
		}
		
		
		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		
		public String getTelefono() {
			return telefono;
		}
		
		
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		
		
		public double getSalario() {
			return salario;
		}
		
		
		public void setSalario(double salario) {
			this.salario = salario;
		}  
		
		@Override
	    public String toString() {
	        return "Empleado{" +
	                "dni='" + dni + '\'' +
	                ", nombre='" + nombre + '\'' +
	                ", apellido1='" + apellido1 + '\'' +
	                ", apellido2='" + apellido2 + '\'' +
	                ", edad=" + edad +
	                ", telefono='" + telefono + '\'' +
	                ", salario=" + salario +
	                ", sexo='" + sexo + '\'' +
	                '}';
	    }
	}

