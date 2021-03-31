package sensorval;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SensorValidatorTest {
	@Test
	public void reportsErrorWhenSOCjumps() {
		Double[] readings = { 0.0, 0.01, 0.5, 0.51 };
		List<Double> socs = Arrays.asList(readings);
		assertFalse(SensorValidator.validateSOCreadings(socs));
	}

	@Test
	public void reportsErrorWhenCurrentjumps() {
		Double[] readings = { 0.03, 0.03, 0.03, 0.33 };
		List<Double> currents = Arrays.asList(readings);
		assertFalse(SensorValidator.validateCurrentreadings(currents));
	}

	@Test
	public void reportsErrorWhenCurrentNull() {
		List<Double> currents = null;
		assertFalse(SensorValidator.validateCurrentreadings(currents));
	}

	@Test
	public void reportsErrorWhenSOCNull() {
		List<Double> socs = null;
		assertFalse(SensorValidator.validateSOCreadings(socs));
	}
	@Test
	public void reportsErrorWhenSOCIsEmpty() {
		List<Double> socs = new ArrayList<>();
		assertFalse(SensorValidator.validateSOCreadings(socs));
	}
	@Test
	public void reportsErrorWhenCurrentIsEmpty() {
		List<Double> currents = new ArrayList<>();
		assertFalse(SensorValidator.validateCurrentreadings(currents));
	}
	@Test
	public void reportsErrorWhenSOCReadingIsNull() {
		Double[] readings = { 0.0, 0.01, null };
		List<Double> socs = Arrays.asList(readings);
		assertFalse(SensorValidator.validateSOCreadings(socs));
	}

	@Test
	public void reportsErrorWhenCurrentReadingIsNull() {
		Double[] readings = { 0.03, 0.03, 0.03, null };
		List<Double> currents = Arrays.asList(readings);
		assertFalse(SensorValidator.validateCurrentreadings(currents));
	}
}
