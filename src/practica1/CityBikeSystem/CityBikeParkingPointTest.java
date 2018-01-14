package practica1.CityBikeSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runners.JUnit4;

/**
 * Clase de pruebas para la clase {@link CityBikeParkingPoint} implementada en
 * {@link JUnit4}.
 * 
 * @author albguti
 * @version 0.3
 */
public class CityBikeParkingPointTest {
	public static final double ERROR_ADMISIBLE = 0.00001;
	double[] posicionETSI = { 41.6616001, -4.7072018 };

	@Test
	public void testCityBikeParkingPoint() {
		int numAnclajesACrear = 222;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		ArrayList<Boolean> expected = new ArrayList<Boolean>();
		for (int i = 0; i < numAnclajesACrear; i++) {
			expected.add(false);
		}

		assertNotNull(parkingPoint.getIdParkingPoint());
		assertNotNull(posicionETSI);
		assertNotNull(parkingPoint.getPosicion());
		assertEquals(parkingPoint.getPosicion(), posicionETSI);
		assertEquals(parkingPoint.getNumAnclajes(), numAnclajesACrear, ERROR_ADMISIBLE);
		assertEquals(parkingPoint.getAnclajes(), expected);
	}

	@Test(expected = java.lang.AssertionError.class)
	public void testInicializarNumAnclajesNegativo() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(-5, posicionETSI);
		assertNotNull(posicionETSI);
	}

	@Test(expected = java.lang.AssertionError.class)
	public void testInicializarNumAnclajesCero() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(0, posicionETSI);
		assertNotNull(posicionETSI);
	}

	@Test(expected = java.lang.AssertionError.class)
	public void testInicializarPosicionNull() {
		@SuppressWarnings("unused")
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, null);
	}

	@Test
	public final void testGetIdParkingPoint() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertNotNull(parkingPoint.getIdParkingPoint());
		// //TODO Quitar estos prints
		// System.out.println("getIdParkingPoint:
		// "+parkingPoint.getIdParkingPoint().toString());
		// System.out.println("getEstadoAnclaje(0):
		// "+parkingPoint.getEstadoAnclaje(0));
		// System.out.println("getNumAnclajes: "+parkingPoint.getNumAnclajes());
		// System.out.println("getNumAnclajesOcupados:
		// "+parkingPoint.getNumAnclajesOcupados());
		// System.out.println("getAnclajes:
		// "+parkingPoint.getAnclajes().toString());
		// System.out.println("getPosicion: ["+parkingPoint.getPosicion()[0]+",
		// "+parkingPoint.getPosicion()[1]+"]");
	}

	@Test
	public final void testGetNumAnclajes() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertEquals(22, parkingPoint.getNumAnclajes(), ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetNumAnclajesOcupados() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertEquals(0, parkingPoint.getNumAnclajesOcupados(), ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetPosicion() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertEquals(posicionETSI, parkingPoint.getPosicion());
		assertEquals(posicionETSI[0], parkingPoint.getPosicion()[0], ERROR_ADMISIBLE);
		assertEquals(posicionETSI[1], parkingPoint.getPosicion()[1], ERROR_ADMISIBLE);
	}

	@Test
	public final void testGetEstadoAnclaje() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		for (int i = 0; i < parkingPoint.getNumAnclajes(); i++) {
			assertEquals(false, parkingPoint.getEstadoAnclaje(i));
		}
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testGetEstadoAnclajeIndiceNegativo() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		parkingPoint.getEstadoAnclaje(-1);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testGetEstadoAnclajeIndiceSuperiorLimite() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		parkingPoint.getEstadoAnclaje(22);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testGetEstadoAnclajeIndiceSuperior() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		parkingPoint.getEstadoAnclaje(23);
	}

	@Test
	public final void testSetEstadoAnclaje() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		for (int i = 0; i < parkingPoint.getNumAnclajes(); i++) {
			assertEquals(false, parkingPoint.getEstadoAnclaje(i));
		}
		parkingPoint.setEstadoAnclaje(0, true);
		assertEquals(true, parkingPoint.getEstadoAnclaje(0));
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testSetEstadoAnclajeIndiceNegativo() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		parkingPoint.setEstadoAnclaje(-1, true);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testSetEstadoAnclajeIndiceSuperiorLimite() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		parkingPoint.setEstadoAnclaje(22, false);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testSetEstadoAnclajeIndiceSuperior() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		parkingPoint.setEstadoAnclaje(23, true);
	}

	@Test
	public final void testGetAnclajes() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertNotNull(parkingPoint.getAnclajes());
		assertEquals(22, parkingPoint.getAnclajes().size(), ERROR_ADMISIBLE);
	}

	@Test
	public final void testPrestarBici() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testdevolverBici() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDistanciaACoordenada() {
		double[] coordenadaDistancia = posicionETSI;
		double[] coordenadaDistancia2 = { 42.6616001, -4.8072018 };
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertEquals(0, parkingPoint.distanciaACoordenada(coordenadaDistancia), ERROR_ADMISIBLE);
		assertNotNull(coordenadaDistancia);
		assertEquals(2, coordenadaDistancia.length, ERROR_ADMISIBLE);
		assertNotEquals(0, parkingPoint.distanciaACoordenada(coordenadaDistancia2), ERROR_ADMISIBLE);
		assertNotNull(coordenadaDistancia2);
		assertEquals(2, coordenadaDistancia2.length, ERROR_ADMISIBLE);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testDistanciaACoordenadaNula() {
		double[] coordenadaDistancia = null;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		@SuppressWarnings("unused")
		double distancia = parkingPoint.distanciaACoordenada(coordenadaDistancia);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testDistanciaACoordenadaErronea() {
		double[] coordenadaErronea = { 42.6616001, -4.8072018, 4.8072018 };
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		@SuppressWarnings("unused")
		double distancia = parkingPoint.distanciaACoordenada(coordenadaErronea);
	}

	@Test
	public final void testDistanciaAAparcamiento() {
		double[] coordenadaParking2 = { 42.6616001, -4.8072018 };
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(22, posicionETSI);
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(22, posicionETSI);
		assertEquals(0, parkingPoint1.distanciaAAparcamiento(parkingPoint2), ERROR_ADMISIBLE);
		assertNotNull(parkingPoint2);
		CityBikeParkingPoint parkingPoint3 = new CityBikeParkingPoint(22, coordenadaParking2);
		assertNotEquals(0, parkingPoint1.distanciaAAparcamiento(parkingPoint3), ERROR_ADMISIBLE);
		assertNotNull(parkingPoint3);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testDistanciaAAparcamientoNulo() {
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(22, posicionETSI);
		CityBikeParkingPoint parkingPoint2 = null;
		parkingPoint1.distanciaAAparcamiento(parkingPoint2);
	}

	@Test
	public final void testCalcularDistancia() {
		double[] coordenada1 = posicionETSI;
		double[] coordenada2 = coordenada1;
		double[] coordenada3 = { 42.6616001, -4.8072018 };
		assertEquals(0, CityBikeParkingPoint.calcularDistancia(coordenada1, coordenada2), ERROR_ADMISIBLE);
		assertNotEquals(0, CityBikeParkingPoint.calcularDistancia(coordenada1, coordenada3), ERROR_ADMISIBLE);
		assertNotNull(coordenada1);
		assertEquals(2, coordenada1.length, ERROR_ADMISIBLE);
		assertNotNull(coordenada2);
		assertEquals(2, coordenada2.length, ERROR_ADMISIBLE);
		assertNotNull(coordenada3);
		assertEquals(2, coordenada3.length, ERROR_ADMISIBLE);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testCalcularDistanciaNull() {
		double[] coordenada1 = posicionETSI;
		double[] coordenada2 = null;
		CityBikeParkingPoint.calcularDistancia(coordenada1, coordenada2);
	}

	@Test(expected = java.lang.AssertionError.class)
	public final void testCalcularDistanciaCoordenadaErronea() {
		double[] coordenada1 = posicionETSI;
		double[] coordenadaErronea = { 42.6616001, -4.8072018, 4.8072018 };
		CityBikeParkingPoint.calcularDistancia(coordenada1, coordenadaErronea);
	}

	@Test
	public final void testToString() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(22, posicionETSI);
		assertNotNull(parkingPoint.toString());
	}

}