package cl.practica2.app.entities;

//En elgun momento lo daremos el super poder de ser persistido
// clase pojo, plana, anemica
public class Alumno {
	
	private String nombre;
	private Integer edad;
	private String fechaNacimiento;
	private String ocupacion;
	private String descripcion;
	
	//	
	public Alumno(String nombre, Integer edad, String fechaNacimiento, String ocupacion, String descripcion) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.ocupacion = ocupacion;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", ocupacion="
				+ ocupacion + "]";
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
