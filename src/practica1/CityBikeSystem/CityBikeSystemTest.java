package practica1.CityBikeSystem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Clase de pruebas para la clase {@link CityBikeSystem} implementada en
 * <code>JUnit4</code>.
 * 
 * @author albguti
 * @version 0.2
 */
public class CityBikeSystemTest {
	public static final double ERROR_ADMISIBLE = 0.00001;
	double fianzaEstandar = 2.5;
	double[] posicionETSI = { 41.6616001, -4.7072018 };

	@Test
	public void testCityBikeSystem() {
		double fianzaNueva = 3.5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CBS.setFianza(fianzaNueva);
		assertNotNull(CityBikeSystem.getFianza());
		assertNotEquals(fianzaEstandar, CityBikeSystem.getFianza(), ERROR_ADMISIBLE);
		assertEquals(fianzaNueva, CityBikeSystem.getFianza(), ERROR_ADMISIBLE);
	}

	@Test
	public void testGetFianza() {
		@SuppressWarnings("unused")
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		assertNotNull(CityBikeSystem.getFianza());
		assertEquals(fianzaEstandar, CityBikeSystem.getFianza(), ERROR_ADMISIBLE);
	}

	@Test
	public void testSetFianza() {
		double fianzaNueva = 3.5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CBS.setFianza(fianzaNueva);
		assertNotNull(CityBikeSystem.getFianza());
		assertNotEquals(fianzaEstandar, CityBikeSystem.getFianza(), ERROR_ADMISIBLE);
		assertEquals(fianzaNueva, CityBikeSystem.getFianza(), ERROR_ADMISIBLE);
	}

	@Test
	public void testAnadirPuntoParking() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint);
		assertEquals(1, CBS.getPuntosParking().size());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		assertNotEquals(1, CBS.getPuntosParking().size());
		assertEquals(2, CBS.getPuntosParking().size());
	}
	// TODO no olvidar el añadir uno que ya está añadido

	@Test
	public void testEliminarPuntoParkingCityBikeParkingPoint() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint);
		assertEquals(1, CBS.getPuntosParking().size());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		assertEquals(2, CBS.getPuntosParking().size());
		CBS.eliminarPuntoParking(parkingPoint2);
		assertEquals(1, CBS.getPuntosParking().size());
	}
	// TODO no olvidar el eliminar uno que no está añadido

	@Test
	public void testEliminarPuntoParkingString() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint);
		assertEquals(1, CBS.getPuntosParking().size());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		assertEquals(2, CBS.getPuntosParking().size());
		CBS.eliminarPuntoParking(parkingPoint.getIdParkingPoint());
		assertEquals(1, CBS.getPuntosParking().size());
	}
	// TODO no olvidar el eliminar uno que no está añadido

	@Test
	public void testGetPuntosParking() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint1);
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		CityBikeParkingPoint parkingPoint3 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint3);
		CityBikeParkingPoint parkingPoint4 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint4);
		CityBikeParkingPoint parkingPoint5 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint5);
		int expected = 5;
		assertEquals(expected, CBS.getPuntosParking().size());
	}

	@Test
	public void testGetPuntosParkingBicisDisponible() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint1);
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		parkingPoint2.setEstadoAnclaje(0, true);
		assertEquals(1, CBS.getPuntosParkingBicisDisponible().size());
	}

	@Test
	public void testGetPuntosParkingBicisDisponibleToString() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint1);
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		parkingPoint2.setEstadoAnclaje(0, true);
		assertNotNull(CBS.getPuntosParkingBicisDisponibleToString());
	}

	@Test
	public void testGetPuntosParkingDevolver() {
		int numAnclajesACrear = 5;
		CityBikeSystem CBS = new CityBikeSystem(fianzaEstandar);
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint1);
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(numAnclajesACrear, posicionETSI);
		CBS.anadirPuntoParking(parkingPoint2);
		assertEquals(2, CBS.getPuntosParkingDevolver().size());
		for (int i = 0; i < parkingPoint2.getNumAnclajes(); i++) {
			parkingPoint2.setEstadoAnclaje(i, true);
		}
		assertEquals(1, CBS.getPuntosParkingDevolver().size());
	}

	@Test
	public void testGetPuntosParkingDevolverToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPuntosParkingCercanosGD() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPuntosParkingCercanosGMS() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertirGMSaGD() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
