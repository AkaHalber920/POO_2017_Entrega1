package practica1.CityBikeSystem;

import java.util.ArrayList;

/**
 * Representa el sistema que controla el uso de los puntos de aparcamiento de
 * bicis de una ciudad. Permite:
 * <ul>
 * <li>Añadir un <code>punto de aparcamiento</code> de bicis.</li>
 * <li>Eliminar un <code>punto de aparcamiento</code> de bicis.</li>
 * <li>Modificar la cantidad establecida para la fianza.</li>
 * <li>Obtener todos los <code>puntos de aparcamientos</code> de bicis que hay
 * en la ciudad.</li>
 * <li>Obtener todos los <code>puntos de aparcamiento</code> con bicis
 * disponibles (que tengan anclajes ocupados).</li>
 * <li>Obtener todos los <code>puntos de aparcamiento</code> en los que haya
 * sitio para devolver (anclar) una bici (es decir que tengan anclajes vacíos).
 * </li>
 * <li>Obtener los <code>puntos de aparcamiento</code> de bicis cercanos a una
 * coordenada <code>GPS</code> dada dentro de un <code>radio</code> en
 * <code>metros</code> dado.</li>
 * </ul>
 * 
 * @author albguti
 * @version 1.1
 */
public class CityBikeSystem {

	// Atributos
	/**
	 * Un <code>ArrayList</code> que mantiene la existencia de puntos de
	 * aparcamiento de bicis.
	 */
	private ArrayList<CityBikeParkingPoint> puntosParking;

	/**
	 * Es la fianza que se cobra en el sistema a la hora de reservar bicicletas
	 * y que se devuelve a la hora de devolver bicicletas. La cantidad de fianza
	 * se establece al crear el sistema de préstamos en la ciudad, pero es
	 * revisable y cada cierto tiempo el ayuntamiento podrá modificar el valor
	 * de esta fianza.
	 */
	private static double fianza;

	/**
	 * <p>
	 * Constructor de la clase. Inicializa un sistema nuevo con su
	 * <code>ArrayList</code> de puntos de aparcamiento
	 * 
	 * @assert.pre La fianza que utiliza el sistema debe ser un
	 *             <code>Double</code> no negativo.
	 * 
	 * @assert.post None.
	 * 
	 * @param fianza
	 *            La cantidad de fianza, que se cobra en el sistema a la hora de
	 *            reservar bicicletas y que se devuelve a la hora de devolver
	 *            bicicletas, se establece al crear el sistema de préstamos.
	 */
	public CityBikeSystem(double fianza) {
		assert (fianza >= 0);
		this.puntosParking = new ArrayList<CityBikeParkingPoint>();
		CityBikeSystem.fianza = fianza;
	}

	/**
	 * Devuelve la cantidad de la fianza establecida en el sistema de alquiler
	 * de bicicletas.
	 * 
	 * @return Un <code>Double</code> con la cantidad de la fianza establecida
	 *         en el sistema de alquiler de bicicletas.
	 */
	public static double getFianza() {
		return fianza;
	}

	/**
	 * Para establece una nueva cantidad de la fianza en el sistema de alquiler
	 * de bicicletas ya que esta es revisable y cada cierto tiempo el
	 * ayuntamiento puede modificar su valor.
	 * 
	 * @assert.pre Esta cantidad para establecer la nueva fianza debe ser un
	 *             <code>Double</code> no negativo.
	 * 
	 * @assert.post None.
	 * 
	 * @param fianzaNueva
	 *            Es la nueva cantidad de la fianza a establecer en el sistema
	 *            de alquiler de bicicletas.
	 */
	public void setFianza(double fianzaNueva) {
		assert (fianzaNueva >= 0);
		CityBikeSystem.fianza = fianzaNueva;
	}

	/**
	 * Método para añadir un punto de aparcamiento al sistema, es decir,
	 * añadirlo al <code>ArrayList</code> <code>puntosParking</code> que tiene
	 * los puntos de aparcamiento que existen en el sistema.
	 * 
	 * @assert.pre El <code>CityBikeParkingPoint</code> (punto de aparcamiento)
	 *             a añadir no puede ser <code>Null</code>.
	 * 
	 * @assert.pre El <code>CityBikeParkingPoint</code> (punto de aparcamiento)
	 *             a añadir no debe estar ya en el sistema.
	 * 
	 * @assert.post None.
	 * 
	 * @param P
	 *            El nuevo <code>CityBikeParkingPoint</code> (punto de
	 *            aparcamiento) a añadir al sistema.
	 */
	public void anadirPuntoParking(CityBikeParkingPoint P) {
		assert (P != null);
		assert (!puntosParking.contains(P));
		puntosParking.add(P);
	}

	/**
	 * Metodo para eliminar un punto de aparcamiento del sistema, es decir,
	 * quitarlo del <code>ArrayList</code> <code>puntosParking</code> que tiene
	 * los puntos de aparcamiento que contiene el sistema. Se le da un punto de
	 * aparcamiento
	 * 
	 * @assert.pre El <code>CityBikeParkingPoint</code> (punto de aparcamiento)
	 *             a eliminar no puede ser <code>Null</code>.
	 * 
	 * @assert.pre El <code>CityBikeParkingPoint</code> (punto de aparcamiento)
	 *             a eliminar debe estar ya en el sistema.
	 * 
	 * @assert.post None.
	 * 
	 * @param P
	 *            El <code>CityBikeParkingPoint</code> (punto de aparcamiento)a
	 *            eliminar del sistema.
	 */
	public void eliminarPuntoParking(CityBikeParkingPoint P) {
		assert (P != null);
		assert (puntosParking.contains(P));
		puntosParking.remove(P);
	}

	/**
	 * Metodo (sobrecargado) para eliminar un punto de aparcamiento del sistema,
	 * es decir, quitarlo del <code>ArrayList</code> <code>puntosParking</code>
	 * que tiene los puntos de aparcamiento que contiene el sistema. Se le pasa
	 * un ID único del aparcamiento que se desea eliminar.
	 * 
	 * @assert.pre El <code>String</code> con el <code>ID</code> único del
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento) a
	 *             eliminar no puede ser <code>Null</code> ni una cadena vacía.
	 * 
	 * @assert.post Se debe encontrar un <code>CityBikeParkingPoint</code> con
	 *              el identificador dado.
	 * 
	 * @param idP
	 *            Es un <code>String</code> con el identificador único
	 *            <code>idParkingPoint</code> del punto de aparcamiento a
	 *            eliminar del sistema
	 */
	public void eliminarPuntoParking(String idP) {
		assert (idP != "" && idP != null);
		@SuppressWarnings("unused")
		Boolean bandera;
		for (int i = 0; i < puntosParking.size(); i++) { // Recorro el
															// ArrayList
			if (puntosParking.get(i).getIdParkingPoint().equals(idP)) { // busco
																		// en el
																		// ArrayList
																		// el
																		// elemento
																		// que
																		// tenga
																		// su
																		// atributo
																		// 'idParkingPoint'
																		// igual
																		// al
																		// 'idP'
																		// dado.
				bandera = true;
				puntosParking.remove(i);
			} else {
				bandera = false;
			}
		}
		// assert (bandera = true);
	}

	/**
	 * Para poder obtener todos los puntos de aparcamientos de bicis que hay en
	 * la ciudad.
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento).
	 * 
	 * @assert.post None.
	 * 
	 * @return El {@link ArrayList} con todos los elementos
	 *         {@link CityBikeParkingPoint} que hay en el sistema de alquiler de
	 *         bicicletas de la ciudad.
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosParking() {
		assert (puntosParking.size() > 0);
		return (puntosParking);
	}

	/**
	 * Para poder obtener todos los <code>CityBikeParkingPoint</code> (puntos de
	 * aparcamiento) con bicis disponibles (que tengan anclajes ocupados).
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento).
	 * 
	 * @assert.post Se devuelve el <code>ArrayList</code> con los puntos de
	 *              aparcamiento con bicis disponibles si este tiene al menos
	 *              uno.
	 * 
	 * @return Un {@link ArrayList} con todos los puntos de aparcamiento
	 *         {@link CityBikeParkingPoint} con bicis disponibles.
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosParkingBicisDisponible() {
		ArrayList<CityBikeParkingPoint> puntosParkingBicisDisponible = new ArrayList<CityBikeParkingPoint>();
		assert (puntosParking.size() > 0);
		for (int i = 0; i < puntosParking.size(); i++) { // Recorremos uno a uno
															// todos los puntos
															// de aparcamiento
			if (puntosParking.get(i).getNumAnclajesOcupados() > 0) { // Si el
																		// punto
																		// de
																		// aparcamiento
																		// tiene
																		// al
																		// menos
																		// 1
																		// punto
																		// de
																		// anclaje
																		// ocupado
																		// (es
																		// decir,
																		// tiene
																		// bicicleta)

				puntosParkingBicisDisponible.add(puntosParking.get(i)); // Lo
																		// añadimos
																		// al
																		// nuevo
																		// ArrayList
																		// de
																		// puntos
																		// de
																		// aparcamiento
																		// con
																		// biciceltas
																		// disponibles
			}
		}
		assert (puntosParkingBicisDisponible.size() > 0);
		return puntosParkingBicisDisponible;
	}

	/**
	 * Para poder obtener, en formato legible, todos los puntos de aparcamiento
	 * con bicis disponibles (que tengan anclajes ocupados).
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento).
	 *
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento)con
	 *             bicis disponibles.
	 * 
	 * @assert.post Se devuelve el <code>String</code> con los puntos de
	 *              aparcamiento con anclajes disponibles si este tiene al menos
	 *              uno.
	 * 
	 * @return Un {@link String} con la información de todos los puntos de
	 *         aparcamiento {@link CityBikeParkingPoint} con bicis disponibles.
	 */
	public String getPuntosParkingBicisDisponibleToString() {
		assert (puntosParking.size() > 0);
		assert (getPuntosParkingBicisDisponible().size() > 0);
		String infoPuntosParkingBicisDisponible = null;
		ArrayList<CityBikeParkingPoint> puntosParkingBicisDisponibleString = getPuntosParkingBicisDisponible();
		for (int i = 0; i < puntosParkingBicisDisponibleString.size(); i++) { // Recorremos
																				// uno
																				// a
																				// uno
																				// todos
																				// los
																				// puntos
																				// de
																				// aparcamiento
																				// con
																				// bicicletas
																				// disponibles
			infoPuntosParkingBicisDisponible = infoPuntosParkingBicisDisponible + puntosParking.get(i).toString()
					+ "\n\n";
		}
		assert (infoPuntosParkingBicisDisponible != null);
		return infoPuntosParkingBicisDisponible;
	}

	/**
	 * Para poder obtener todos los puntos de aparcamiento con anclajes
	 * disponibles (que se pueda devolver la bicicleta)
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento).
	 * 
	 * @assert.post Se devuelve el <code>ArrayList</code> con los puntos de
	 *              aparcamiento con anclajes disponibles si este tiene al menos
	 *              uno.
	 * 
	 * @return Un {@link ArrayList} con todos los puntos de aparcamiento
	 *         {@link CityBikeParkingPoint} con anclajes disponibles para poder
	 *         devolver bicicletas.
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosParkingDevolver() {
		assert (puntosParking.size() > 0);
		ArrayList<CityBikeParkingPoint> puntosParkingDevolver = new ArrayList<CityBikeParkingPoint>();
		for (int i = 0; i < puntosParking.size(); i++) { // Recorremos uno a uno
															// todos los puntos
															// de aparcamiento
			if (puntosParking.get(i).getNumAnclajesOcupados() < puntosParking.get(i).getNumAnclajes()) { // Si
																											// el
																											// punto
																											// de
																											// aparcamiento
																											// tiene
																											// menos
																											// anclajes
																											// ocupados
																											// que
																											// anclajes
																											// en
																											// total
																											// (es
																											// decir,
																											// tiene
																											// anclajes
																											// disponibles
																											// para
																											// devovler
																											// la
																											// bicicleta)

				puntosParkingDevolver.add(puntosParking.get(i)); // Lo
																	// añadimos
																	// al
																	// nuevo
																	// ArrayList
																	// de
																	// puntos
																	// de
																	// aparcamiento
																	// con
																	// puntos
																	// de
																	// anclaje
																	// disponibles

			}
		}
		assert (puntosParkingDevolver.size() > 0);
		return puntosParkingDevolver;
	}

	/**
	 * Para poder obtener en, formato legible, todos los puntos de aparcamiento
	 * con anclajes disponibles (que se pueda devolver la bicicleta).
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento).
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code> (punto de aparcamiento) con
	 *             anclajes disponibles.
	 * 
	 * @assert.post Se devuelve el <code>String</code> con los puntos de
	 *              aparcamiento con bicis disponibles si este tiene al menos
	 *              uno.
	 * 
	 * @return Un {@link String} con la información de todos los puntos de
	 *         aparcamiento {@link CityBikeParkingPoint} con anclajes
	 *         disponibles.
	 */
	public String getPuntosParkingDevolverToString() {
		assert (puntosParking.size() > 0);
		assert (getPuntosParkingDevolver().size() > 0);
		String infopuntosParkingDevolver = null;
		ArrayList<CityBikeParkingPoint> puntosParkingDevolverString = getPuntosParkingDevolver();
		for (int i = 0; i < puntosParkingDevolverString.size(); i++) { // Recorremos
																		// uno
																		// a
																		// uno
																		// todos
																		// los
																		// puntos
																		// de
																		// aparcamiento
																		// con
																		// anclajes
																		// disponibles
			infopuntosParkingDevolver = infopuntosParkingDevolver + puntosParking.get(i).toString() + "\n\n";
		}
		assert (infopuntosParkingDevolver != null);
		return infopuntosParkingDevolver;
	}

	/**
	 * Para poder obtener todos los puntos de aparcamiento de bicis cercanos a
	 * una coordenada GPS dada en GD dentro de un radio en metros también dado.
	 * 
	 * @assert.pre La coordenada que se pasa como argumento debe ser distinta de
	 *             <code>Null</code>.
	 * 
	 * @assert.pre Se le debe pasar como argumento un array con 2 valores de
	 *             tipo <code>Double</code>.
	 * 
	 * @assert.pre El radio que se pasa como argumento debe ser mayor que 0.
	 * 
	 * @assert.post Solo se devuelve si hay al menos un punto de aparcamiento
	 *              cercano que cumpla la orden.
	 * 
	 * @param coordenada
	 *            <code>Array</code> de 2 elementos de tipo <code>double</code>
	 *            que tienen la longitud y latiud en GD de la coordenada sobre
	 *            la que buscar puntos de aparcamiento
	 *            {@link CityBikeParkingPoint} cercanos.
	 * 
	 * @param radio
	 *            {@link Integer} que representa el radio en metros máximo sobre
	 *            el que buscar puntos de aparcamiento
	 *            {@link CityBikeParkingPoint} cercanos.
	 * 
	 * @return Un {@link ArrayList} con todos los puntos de aparcamiento
	 *         {@link CityBikeParkingPoint} de bicis cercanos a una coordenada
	 *         GPS dada dentro de un radio en metros dado.
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosParkingCercanosGD(double[] coordenada, int radio) { // No
																										// olvidar
																										// assert
																										// para
																										// que
																										// el
																										// array
																										// sea
																										// de
																										// tamaño
																										// 2
		assert (coordenada != null);
		assert (coordenada.length == 2);
		assert (radio > 0);
		ArrayList<CityBikeParkingPoint> puntosParkingCercanos = new ArrayList<CityBikeParkingPoint>();
		for (int i = 0; i < puntosParking.size(); i++) { // Recorremos uno a uno
															// todos los puntos
															// de aparcamiento
			double distancia = CityBikeParkingPoint.calcularDistancia(puntosParking.get(i).getPosicion(), coordenada);
			if (distancia <= radio) { // Si la distancia entre la posición de
										// ese punto de aparcamiento y la
										// coordenada dada es menor o igual que
										// el radio dado (dicho punto de
										// aparcamiento está dentro del radio de
										// la posición GPS dada)
				puntosParkingCercanos.add(puntosParking.get(i)); // Lo
																	// añadimos
																	// al
																	// nuevo
																	// ArrayList
																	// de
																	// puntos
																	// de
																	// aparcamiento
																	// cercanos
			}
		}
		assert (puntosParkingCercanos.size() > 0);
		return puntosParkingCercanos;
	}

	/**
	 * Para poder obtener todos los puntos de aparcamiento de bicis cercanos a
	 * una coordenada GPS dada en GMS dentro de un radio en metros dado.
	 * 
	 * @assert.pre La coordenada que se pasa como argumento debe ser distinta de
	 *             <code>Null</code>.
	 * 
	 * @assert.pre El radio que se pasa como argumento debe ser mayor que 0.
	 * 
	 * @assert.post Solo se devuelve si hay al menos un punto de aparcamiento
	 *              cercano que cumpla la orden.
	 * 
	 * @param coordenada
	 *            <code>Array</code> de 2 elementos de tipo <code>double</code>
	 *            que tienen la longitud y latiud en GMS de la coordenada sobre
	 *            la que buscar puntos de aparcamiento
	 *            {@link CityBikeParkingPoint} cercanos
	 * @param radio
	 *            {@link Integer} que representa el radio en metros máximo sobre
	 *            el que buscar puntos de aparcamiento
	 *            {@link CityBikeParkingPoint} cercanos
	 * @return un {@link ArrayList} con todos los puntos de aparcamiento
	 *         {@link CityBikeParkingPoint} de bicis cercanos a una coordenada
	 *         GPS dada dentro de un radio en metros dado
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosParkingCercanosGMS(String[] coordenada, int radio) { // No
																											// olvidar
																											// assert
																											// para
																											// que
																											// el
																											// array
																											// sea
																											// de
																											// tamaño
																											// 2
		assert (coordenada != null);
		assert (radio > 0);
		ArrayList<CityBikeParkingPoint> puntosParkingCercanos = new ArrayList<CityBikeParkingPoint>();
		double[] coordenadaGD = new double[2];
		coordenadaGD[0] = convertirGMSaGD(coordenada[0]);
		coordenadaGD[1] = convertirGMSaGD(coordenada[1]);
		for (int i = 0; i < puntosParking.size(); i++) { // Recorremos uno a uno
															// todos los puntos
															// de aparcamiento
			double distancia = CityBikeParkingPoint.calcularDistancia(puntosParking.get(i).getPosicion(), coordenadaGD);
			if (distancia <= radio) { // Si la distancia entre la posición de
										// ese punto de aparcamiento y la
										// coordenada dada es menor o igual que
										// el radio dado (dicho punto de
										// aparcamiento está dentro del radio de
										// la posición GPS dada)
				puntosParkingCercanos.add(puntosParking.get(i)); // Lo añadimos
																	// al nuevo
																	// ArrayList
																	// de puntos
																	// de
																	// aparcamiento
																	// cercanos
			}
		}
		assert (puntosParkingCercanos != null);
		return puntosParkingCercanos;
	}

	/**
	 * Función para hacer la transformación de una coordenada GMS (esctita como
	 * " XºY'Z'' ") a GD (Grados Decimales).
	 * 
	 * @assert.pre La coordenada en formato GMS que se quiere convertir no debe
	 *             ser <code>Null</code>.
	 * 
	 * @assert.pre La coordenada en formato GMS que se quiere convertir debe
	 *             contener el caracter 'º'.
	 * 
	 * @assert.pre La coordenada en formato GMS que se quiere convertir debe
	 *             contener el caracter '''.
	 * 
	 * @assert.pre La coordenada en formato GMS que se quiere convertir debe
	 *             contener el caracter ''''.
	 * 
	 * @assert.post None.
	 * 
	 * @param GMS
	 *            Es la coordenada en formato GMS que se quiere convertir a GD.
	 * 
	 * @return La coordenada en formato GD.
	 */
	public double convertirGMSaGD(String GMS) {
		assert (GMS != null);
		assert (GMS.contains(String.valueOf("º")));
		assert (GMS.contains(String.valueOf("'")));
		assert (GMS.contains(String.valueOf("''")));
		String[] gradosString = GMS.split("º");
		int grados = Integer.parseInt(gradosString[0]);
		String[] minutosString = gradosString[1].split("'");
		int minutos = Integer.parseInt(minutosString[0]);
		String[] segundosString = minutosString[1].split("''");
		int segundos = Integer.parseInt(segundosString[0]);
		return Math.signum(grados) * (Math.abs(grados) + (minutos / 60.0) + (segundos / 3600.0));
	}

	/**
	 * Se obtiene un <code>String</code> con toda la información, en formato
	 * legible, acerca del punto de los puntos de aparcamientos de bicis que hay
	 * en la ciudad.
	 * 
	 * @assert.pre El sistema debe tener almenos un
	 *             <code>CityBikeParkingPoint</code>.
	 * 
	 * @return Un <code>String</code> con la información del {@link ArrayList},
	 *         de todos los elementos {@link CityBikeParkingPoint} que hay en el
	 *         sistema de alquiler de bicicletas.
	 */
	@Override
	public String toString() {
		assert (puntosParking.size() > 0);
		String infoPuntos = null;
		for (int i = 0; i < puntosParking.size(); i++) {
			infoPuntos = infoPuntos + puntosParking.get(i).toString() + "\n\n";
		}
		return (infoPuntos);
	}

}