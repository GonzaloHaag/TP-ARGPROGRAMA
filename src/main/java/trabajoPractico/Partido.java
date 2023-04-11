package trabajoPractico;

public class Partido {
	
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	public Partido(Equipo equipo1,Equipo equipo2) {
		/*
		 * Aca necesito los dos equipos
		 */
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}
	
	public Partido(Equipo equipo1,Equipo equipo2,int golesEquipo1,int golesEquipo2) {
		/*
		 * Necesito los dos equipos y la cantidad de goles
		 */
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.golesEquipo1 = golesEquipo1;
		this.golesEquipo2 = golesEquipo2;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}
	
	public EnumResultados resultado(Equipo equipo) {
		if(golesEquipo1 == golesEquipo2) {
			return EnumResultados.EMPATE;
		}
		if(equipo.getNombre().equals(equipo1.getNombre())) {
			if(golesEquipo1>golesEquipo2) {
				return EnumResultados.GANADOR;	
			}	else {
				return EnumResultados.PERDEDOR;
			}			
		} else {
			// Si equipo no es equipo 1, entonces equipo sera equipo2
			if(golesEquipo2>golesEquipo1) {
				return EnumResultados.GANADOR;	
			}	else {
				return EnumResultados.PERDEDOR;
			}
			}	
	}

}
