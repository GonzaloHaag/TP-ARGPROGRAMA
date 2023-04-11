package trabajoPractico;

public class Pronostico {
	
	private Partido partido;
	private Equipo equipo;
	private EnumResultados resultado;
	
	public Pronostico (Partido partido,Equipo equipo,EnumResultados resultado) {
		super();
		this.partido = partido;
		this.equipo = equipo;
		this.resultado = resultado;
	}
	
	public Partido getPartido() {
		return this.partido;
	}
	public Equipo getEquipo() {
		return this.equipo;
	}
	public EnumResultados getResultado() {
		return this.resultado;
	}
	
	public int puntos() {
		//this.resultado es la prediccion
		EnumResultados resultadoReal = this.partido.resultado(this.equipo);
		
		if(this.resultado.equals(resultadoReal)) {
			/*
			 * Si la prediccion coincide con el resultado real,
			 * suma un punto
			 */
			return 1;
		}
		else {
			/*
			 * Si no coincide suma 0
			 */
			return 0;
		}
	}

}
