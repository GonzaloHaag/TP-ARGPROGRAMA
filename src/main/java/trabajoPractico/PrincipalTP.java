package trabajoPractico;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PrincipalTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Lectura del archivo de resultados
		/*
		 * Creo una coleccion para ir guardando los partidos
		 */
		Collection<Partido> partidos = new ArrayList<Partido>();
		
		Path archivoResultados = Paths.get("src/test/resources/resultados_test1.csv");
		
		List<String> lineasResultados = null;
		
		try {
			lineasResultados = Files.readAllLines(archivoResultados);
		}
		catch(IOException e) {
			System.out.println("No se pudo leer el archivo de resultados");
			System.out.println("Error: " + e);
			
			System.exit(1);
		}
		
		boolean primeraLinea = true;
		
		for(String lineaResultado : lineasResultados) {
			if(primeraLinea) {
				/*
				 * Estoy buscando saltearme la primera 
				 * linea de mi archivo, porque no 
				 * la necesito, entonces si es la primera linea
				 * la coloco en false y no hago nada
				 */
				primeraLinea = false;
			}
			else {
				/*
				 * Si ya no es la primera linea:
				 */
				String[] campos = lineaResultado.split(","); //Que me haga un array de string cada vez que encuentraa ,
				
				Equipo equipo1 = new Equipo(campos[0]); //Arroja Argentina
				Equipo equipo2 = new Equipo(campos[3]); //Arroja arabia saudita
				
				Partido partido = new Partido(equipo1,equipo2);
				
				
				partido.setGolesEquipo1(Integer.parseInt(campos[1])); //En esa posicion estan los goles del equipo 1
				partido.setGolesEquipo2(Integer.parseInt(campos[2])); //En esa posicion estan los goles del equipo 2
				
				partidos.add(partido); //Para agregarlo a la coleccion
			}
		}
		
		//Lectura archivo pronostico
		int puntos = 0; //total puntos de la persona
		
		Path archivoPronostico = Paths.get("src/test/resources/pronostico_test1.csv");
		List<String> lineasPronostico = null;
		
		try {
			lineasPronostico = Files.readAllLines(archivoPronostico);
			
		}
		catch (IOException e) {
			System.out.println("No se pudo leer la linea del archivo pronosticos");
			System.out.println("Error: " + e);
			System.exit(1);
		}
		
		primeraLinea = true;
		for(String lineaPronostico : lineasPronostico) 
			if(primeraLinea) {
				primeraLinea = false;
			}
			else {
				String[] campos = lineaPronostico.split(",");
				Equipo equipo1 = new Equipo(campos[0]); //Posicion donde se encuentra equipo1
				Equipo equipo2 = new Equipo(campos[4]); //Posicion donde se encuentra equipo2
				Partido partido = null;
				
				for(Partido partidoCol : partidos) {
					if (partidoCol.getEquipo1().getNombre(
							).equals(equipo1.getNombre())
							&& partidoCol.getEquipo2().getNombre(
									).equals(equipo2.getNombre())) {
						
						partido = partidoCol;
						
					}
				}
				Equipo equipo = null;
				EnumResultados resultado = null;
				
				if("X".equals(campos[1])) {
					/*
					 * Si hay una X en esa posicion
					 * quiere decir que gana equipo1
					 */
					equipo = equipo1;
					resultado = EnumResultados.GANADOR;
				}
				if("X".equals(campos[2])) {
					equipo = equipo1;
					resultado = EnumResultados.EMPATE;
				}
				if("X".equals(campos[3])) {
					equipo = equipo1;
					resultado = EnumResultados.PERDEDOR;
				}
				
				Pronostico pronostico = new Pronostico(partido,equipo,resultado);
				
				//Ahora sumo los puntos que corresponden a cada persona
				puntos += pronostico.puntos();
			}
		
		//Aca muestro los puntos de cada persona
		System.out.println("Los puntos obtenidos por el usuario fueron: ");
		System.out.println(puntos);

	}
	
	
	

}


