package sensorval;

import java.util.List;

public class SensorValidator 
{
    public static boolean checkIfDifferenceExceedsThreshold(double value, double nextValue, double maxDelta) {
        if(nextValue - value > maxDelta) {
            return false;
        }
        return true;
    }
    public static boolean validateSOCreadings(List<Double> values) {
        return values != null ? validateDifferenceBetweenValues(values) : false;
    }
    
    public static boolean validateCurrentreadings(List<Double> values) {
    	return values != null ? validateDifferenceBetweenValues(values) : false;
    }
    
    private static boolean validateDifferenceBetweenValues(List<Double> values) {
    	int lastButOneIndex = values.size() - 1;
    	for(int i = 0; i < lastButOneIndex; i++) {
    		if(!checkIfDifferenceExceedsThreshold(values.get(i), values.get(i + 1), 0.05)) {
    			return false;
    		}
    	}
    	return true;
    }
}
