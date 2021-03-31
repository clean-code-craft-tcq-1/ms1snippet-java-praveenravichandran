package sensorval;

import java.util.List;

public class SensorValidator {
	public static boolean checkIfDifferenceNotExceedsThreshold(double value, double nextValue, double maxDelta) {
		if (nextValue - value > maxDelta) {
			return false;
		}
		return true;
	}

	public static boolean validateSOCreadings(List<Double> values) {
		return checkIfValuesAreValidAndValidateDifference(values);
	}

	public static boolean validateCurrentreadings(List<Double> values) {
		return checkIfValuesAreValidAndValidateDifference(values);
	}

	private static boolean checkIfValuesAreValidAndValidateDifference(List<Double> values) {
		boolean isValidAndDifferenceWithinLimit = true;
		if (values == null || values.isEmpty()) {
			isValidAndDifferenceWithinLimit = false;
		} else {
			try {
				isValidAndDifferenceWithinLimit = validateDifferenceBetweenValues(values);
			} catch (NullPointerException ne) {
				isValidAndDifferenceWithinLimit = false;
			}
		}
		return isValidAndDifferenceWithinLimit;
	}

	private static boolean validateDifferenceBetweenValues(List<Double> values) {
		boolean isDifferenceWithinLimit = true;
		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!checkIfDifferenceNotExceedsThreshold(values.get(i), values.get(i + 1), 0.05)) {
				isDifferenceWithinLimit = false;
			}
		}
		return isDifferenceWithinLimit;
	}
}
