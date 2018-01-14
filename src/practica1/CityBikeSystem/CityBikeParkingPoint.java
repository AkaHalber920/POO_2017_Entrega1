package practica1.CityBikeSystem;

import java.util.ArrayList;
import java.util.UUID;

import fabricante.externo.tarjetas.TarjetaMonedero;

/**
 * Representa un punto de aparcamiento del sistema de alquiler de bicis de la
 * ciudad. Permite conocer:
 * <ul>
 * <li>La cantidad de anclajes que tiene el punto de aparcamiento.</li>
 * <li>La cantidad de anclajes ocupados (en los que hay una bici aparcada)</li>
 * <li>La posici�n GPS en la que se encuentra el punto de aparcamiento.</li>
 * <li>El identificador del punto de aparcamiento.</li>
 * <li>Dado un m�dulo de anclaje en ese aparcamiento saber si est� vac�o u
 * ocupado.</li>
 * <li>Prestar una bici de un m�dulo de anclaje.</li>
 * <li>Devolver una bici a un m�dulo de anclaje.</li>
 * <li>Conocer la distancia del punto de aparcamiento a una coordenada GPS dada
 * o a otro punto de aparcamiento de bicis dado.</li>
 * </ul>
 * 
 * <p>
 * Cuando se crea un punto de aparcamiento, se crea con una cantidad de m�dulos
 * de anclaje inicial.
 * </p>
 * 
 * <p>
 * En esta versi�n no se permite a�adir m�dulos de anclaje una vez creado el
 * punto de aparcamiento.
 * </p>
 * 
 * @author albguti
 * @version 1.2
 */
public class CityBikeParkingPoint {

	// Atributos de la clase
	/**
	 * Identificador �nico del del punto de aparcamiento.
	 */
	private String idParkingPoint;

	/**
	 * Cantidad de m�dulos de anclaje inicial para el punto de aparcamiento.
	 */
	private int numAnclajes;

	/**
	 * <p>
	 * <code>ArrayList</code> que representa el estado de los anclajes del punto
	 * de aparcamiento.
	 * </p>
	 * <p>
	 * <ul>
	 * <li><code>true</code> = OCUPADO</li>
	 * <li><code>false</code> = LIBRE</li>
	 * </ul>
	 * </p>
	 */
	private ArrayList<Boolean> anclajes;

	/**
	 * La posici�n (latitud y longitud) GPS del punto de aparcamiento.
	 */
	private double[] posicion = new double[2];

	/**
	 * <p>
	 * Constructor de la clase. Inicializa un nuevo punto de aparcamiento, se le
	 * auto-asigna un IDentificador �nico, y se crea a partir de:
	 * </p>
	 * 
	 * @param numAnclajes
	 *            El n�mero de anclajes de aparcamiento que tiene inicialmente.
	 *            Inicialmente todos estar�n LIBRES.
	 * @param posicion
	 *            Un <code>Array</code> con la latitud y la longitud (de tipo
	 *            <code>Double</code>) de su localizaci�n.
	 * 
	 * @assert.pre El n�mero de anclajes inicial debe ser al menos 1.
	 * 
	 * @assert.pre La posici�n del <code>punto de aparcamiento</code> debe ser
	 *             distinta de <code>Null</code>.
	 * 
	 */
	public CityBikeParkingPoint(int numAnclajes, double[] posicion) {
		assert (numAnclajes > 0);
		assert (posicion != null);
		this.idParkingPoint = UUID.randomUUID().toString();
		this.numAnclajes = numAnclajes;
		this.anclajes = new ArrayList<Boolean>();
		for (int i = 0; i < numAnclajes; i++) {
			anclajes.add(false); // Incialmente un punto de anclaje estar� libre
		}
		this.posicion = posicion;
	}

	/**
	 * Devuelve el idenmtificador �nico del punto de aparcamiento.
	 * 
	 * @return Un <code>String</code> con el idenmtificador �nico que tiene el
	 *         punto de aparcamiento.
	 */
	public String getIdParkingPoint() {
		return idParkingPoint;
	}

	/**
	 * Devuelve la cantidad de anclajes que tiene el punto de aparcamiento.
	 * 
	 * @return Un <code>entero</code> con la cantidad de anclajes que tiene el
	 *         punto de aparcamiento.
	 */
	public int getNumAnclajes() {
		return numAnclajes;
	}

	/**
	 * Devuelve la cantidad de anclajes ocupados que tiene el punto de
	 * aparcamiento.
	 * 
	 * @return Un <code>entero</code> con la cantidad de anclajes ocupados que
	 *         tiene el punto de aparcamiento.
	 */
	public int getNumAnclajesOcupados() {
		int cont = 0;
		for (int i = 0; i < anclajes.size(); i++) {
			if (anclajes.get(i) == true) { // si est� ocupado
				cont++;
			}
		}
		return cont;
	}

	/**
	 * Devuelve la posici�n GPS en la que se encuentra el punto de aparcamiento.
	 * 
	 * @return Un <code>Array</code> con la latitud y la longitud en la que se
	 *         encuentra el punto de aparcamiento.
	 */
	public double[] getPosicion() {
		return posicion;
	}

	/**
	 * Devuelve el estado de un m�dulo de anclaje del punto de aparcamiento dada
	 * su posici�n.
	 * 
	 * @assert.pre El i que representa la posici�n del anclaje debe ser un
	 *             entero no negativo y menor que el n�mero de anlcajes que
	 *             tiene el punto de aparcamiento.
	 * 
	 * @param i
	 *            Es la posicion que tiene, en el m�dulo de anclaje, el anclaje
	 *            que se quiere saber su estado de libre/ocupado.
	 * 
	 * @return
	 *         <ul>
	 *         <li><code>false</code> si el anclaje est� libre.</li>
	 *         <li><code>true</code> si est� ocupado.</li>
	 *         </ul>
	 */
	public boolean getEstadoAnclaje(int i) {
		assert (i >= 0 && i < getNumAnclajes());
		return anclajes.get(i);
	}

	/**
	 * Establece el estado de un m�dulo de anclaje dada su posici�n.
	 * 
	 * @param i
	 *            Es la posicion que tiene, en el m�dulo de anclaje, el anclaje
	 *            que se quiere cambiar su estado de libre/ocupado.
	 * @param estado
	 *            Es el estado al que se quiere establecer el m�dulo de anclaje
	 *            dado.
	 * 
	 * @assert.pre El i que representa la posici�n del anclaje debe ser un
	 *             entero no negativo y menor que el n�mero de anlcajes que
	 *             tiene el punto de aparcamiento.
	 * 
	 */
	public void setEstadoAnclaje(int i, Boolean estado) {
		assert (i >= 0 && i < getNumAnclajes());
		anclajes.set(i, estado);
	}

	// TODO revisar esto:
	/**
	 * Devuelve el estado de todos los anclajes.
	 * 
	 * @return Un <code>ArrayList</code> con los estados de todos los puntos de
	 *         anclaje del punto de aparcamiento.
	 */
	public ArrayList<Boolean> getAnclajes() {
		return anclajes;
	}

	/**
	 * Para permitir prestar una bici.
	 * 
	 * @param tarjeta
	 *            La tarjeta del usuario que quiere usar la bici
	 * 
	 * @param credencial
	 *            Se debe aportal la credencial correcta, de la tarjeta del
	 *            usuario, para restar saldo de la fianza y permitir el
	 *            pr�stamo.
	 * 
	 * @assert.pre Debe haber alg�n anclaje ocupado (es decir, alguna bici
	 *             disponible) en el punto de aparcamiento para poder prestar.
	 * 
	 * @assert.pre La tarjeta debe existir, no puede ser <code>Null</code>.
	 * 
	 * @assert.pre La credencial la comprueba la propia clase TarjetaMonedero,
	 *             pero tambi�n impedimos que sea <code>Null</code> o una
	 *             <code>cadena vac�a</code>.
	 * 
	 * @assert.pre La tarjeta debe tener almenos el mismo saldo disponible que
	 *             lo que cuesta la fianza del sistema
	 */
	public void prestarBici(TarjetaMonedero tarjeta, String credencial) {
		assert (getNumAnclajesOcupados() > 0);
		assert (tarjeta != null);
		assert (credencial != null && credencial != "");
		assert (tarjeta.getSaldoActual() >= CityBikeSystem.getFianza());
		for (int i = 0; i < anclajes.size(); i++) {
			if (anclajes.get(i) == true) {
				setEstadoAnclaje(i, false);
				tarjeta.descontarDelSaldo(credencial, CityBikeSystem.getFianza());
				i = anclajes.size();
			}
		}
	}

	/**
	 * Para permitir la devoluci�n de una bici al m�dulo de anclaje
	 * 
	 * @param tarjeta
	 *            La tarjeta del usuario que quiere devolver la bici
	 * 
	 * @param credencial
	 *            Se debe aportal la credencial correcta, de la tarjeta del
	 *            usuario, para restar saldo de la fianza y permitir el
	 *            pr�stamo.
	 * 
	 * @assert.pre Debe haber anclajes vac�os en el
	 *             <code>punto de parking</code> para poder devolver la bici
	 * 
	 * @assert.pre La tarjeta debe existir, no puede ser <code>Null</code>.
	 * 
	 * @assert.pre La credencial la comprueba la propia clase TarjetaMonedero,
	 *             pero tambi�n impedimos que sea <code>Null</code> o una
	 *             <code>cadena vac�a</code>.
	 * 
	 * @assert.post Aseguramos que, si acaba bien la devoluci�n, en el sistema
	 *              habr� al menos un anclaje ocupado por una bici.
	 */
	public void devolverBici(TarjetaMonedero tarjeta, String credencial) {
		assert (getNumAnclajesOcupados() < getNumAnclajes());
		assert (tarjeta != null);
		assert (credencial != null && credencial != "");
		for (int i = 0; i < anclajes.size(); i++) {
			if (anclajes.get(i) == false) {
				setEstadoAnclaje(i, true);
				tarjeta.recargaSaldo(credencial, CityBikeSystem.getFianza());
				i = anclajes.size();
			}
		}
		assert (getNumAnclajesOcupados() > 0);
	}

	/**
	 * Devuelve la distancia del punto de aparcamiento a una coordenada GPS
	 * dada.
	 * 
	 * @assert.pre La coordenada que se pasa como argumento debe ser distinta de
	 *             <code>Null</code>.
	 * 
	 * @assert.pre Se le debe pasar como argumento un array con 2 valores de
	 *             tipo <code>Double</code>.
	 * 
	 * @param coordenada
	 *            es la coordenada sobre la que se quiere saber la distancia al
	 *            punto de aparcamiento.
	 * 
	 * @return un <code>Double</code> con la distancia que hay del punto de
	 *         aparcamiento a la coordenada GPS dada.
	 */
	public double distanciaACoordenada(double[] coordenada) { // no olvidar
																// assert para
																// coordenada.length==2
		assert (coordenada != null);
		assert (coordenada.length == 2);
		return calcularDistancia(posicion, coordenada); // this.posicion ??
	}

	/**
	 * Devuelve la distancia del punto de aparcamiento a una coordenada GPS
	 * dada.
	 * 
	 * @assert.pre El punto de aparcamiento dado debe ser distinto de
	 *             <code>NULL</code>.
	 * 
	 * @param parkingPoint
	 *            Es el otro punto de aparcamiento sobre el que se quiere saber
	 *            la distancia que hay al punto de aparcamiento.
	 * 
	 * @return Un <code>Double</code> con la distancia del punto de aparcamiento
	 *         al otro punto de aparcamiento dado de bicis dado.
	 */
	public double distanciaAAparcamiento(CityBikeParkingPoint parkingPoint) {
		assert (parkingPoint != null);
		return calcularDistancia(posicion, parkingPoint.getPosicion());
	}

	/**
	 * Calcula la distancia que hay entre dos coordenadas que se pasan como
	 * par�metro.
	 * 
	 * @assert.pre La primera coordenada que se pasa como argumento debe ser
	 *             distinta de <code>Null</code>.
	 * 
	 * @assert.pre La segunda coordenada que se pasa como argumento debe ser
	 *             distinta de <code>Null</code>.
	 * 
	 * @assert.pre Se le debe pasar como primer argumento un array con 2 valores
	 *             de tipo <code>Double</code>.
	 * 
	 * @assert.pre Se le debe pasar como segundo argumento un array con 2
	 *             valores de tipo <code>Double</code>.
	 * 
	 * @param coordenada1
	 *            Es un <code>Array</code> de dos elementos de tipo
	 *            <code>Double</code> que tiene la latitud y la longitud de la
	 *            primera coordenada.
	 * 
	 * @param coordenada2
	 *            Es un <code>Array</code> de dos elementos de tipo
	 *            <code>Double</code> que tiene la latitud y la longitud de la
	 *            segunda coordenada.
	 * 
	 * @return La distancia del punto de aparcamiento a la coordenada GPS dada.
	 */
	public static double calcularDistancia(double[] coordenada1, double[] coordenada2) {
		assert (coordenada1 != null);
		assert (coordenada2 != null);
		assert (coordenada1.length == 2);
		assert (coordenada2.length == 2);
		double R = 6371.0088; // el radio de la tierra que son 6371 kil�metros
		double dlon = coordenada2[1] - coordenada1[1];
		double dlat = coordenada2[0] - coordenada1[0];
		double a = ((Math.pow((Math.sin(dlat / 2)), 2))
				+ (Math.cos(coordenada1[0])) * (Math.cos(coordenada2[0])) * (Math.pow((Math.sin(dlon / 2)), 2)));
		double c1 = 2 * (Math.asin(Math.min(1, Math.sqrt(a))));
		double c2 = 2 * (Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
		double c = (c1 + c2) / 2; // Minimizamos el posible error haciendo la
									// media de ambas opciones del c�lculo de c
		return R * c;
	}

	/**
	 * Hace la transformaci�n de una coordenada dada en <code>GD</code> (Grados
	 * Decimales) a formato <code>GMS</code> (Grados Minutos y Segundos).
	 * 
	 * @param GD
	 *            Es la coordenada en grados decimales que se quiere convertir a
	 *            <code>GMS</code>.
	 * 
	 * @return Un <code>String</code> con la coordenada en formato
	 *         <code>GMS</code> Grados Minutos y Segundos.
	 */
	public static String convertirGDaGMS(double GD) {
		Double dGD = GD;
		int grados = dGD.intValue();
		Double minutosDouble = (GD - Math.floor(GD) * 60);
		int minutos = minutosDouble.intValue();
		Double segundosDouble = (minutosDouble - Math.floor(minutosDouble) * 60);
		int segundos = segundosDouble.intValue();
		return "[" + String.valueOf(grados) + "� " + String.valueOf(minutos) + "' " + String.valueOf(segundos) + "'']";
	}

	/**
	 * Se obtiene un <code>String</code> con toda la informaci�n, en formato
	 * legible, acerca del punto de aparcamiento.
	 * 
	 * @return Un <code>String</code> con toda la informaci�n, en formato
	 *         legible, acerca del punto de aparcamiento dado.
	 */
	@Override
	public String toString() {
		String info = "Punto de aparcamiento " + this.getIdParkingPoint() + " con " + this.getNumAnclajes()
				+ " m�dulos de anclaje para bicicletas\n" + "Posici�n GD: [" + this.getPosicion()[0] + ", "
				+ this.getPosicion()[1] + "]\n" + "Posici�n GMS: " + convertirGDaGMS(this.getPosicion()[0]) + ", "
				+ convertirGDaGMS(this.getPosicion()[1]) + "\n" + "N�mero de m�dulos de anclaje libres: "
				+ (this.getNumAnclajes() - this.getNumAnclajesOcupados()) + "\n"
				+ "N�mero de m�dulos de anclaje ocupados: " + this.getNumAnclajesOcupados();
		return info;
	}

}
