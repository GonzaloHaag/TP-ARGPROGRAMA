package trabajoPractico;

public class Equipo {
	
	//declaracion de metodos
	
	private String nombre;
	private String descripcion;
	
	public Equipo(String nombre) { //Debe recibir el nombre del equipo si o si
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
