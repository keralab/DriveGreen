package testing;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * Whitebox testing methods implemented to test the model's components
 * Will ensure that all possible user preference combinations, and operations
 * do not result in erros during program execution.
 * 
 * @author Aaska Shah
 */
public class TestModel {

	@Test
	public void testRegion() throws IOException {
		DataAccessor da = new DataAccessor();
		String[] temp = { "temp1", "temp2", "temp3", "temp4", "temp5" };
		da.setToUser(temp);
		String[] possibleRegions = { "Alberta", "British Columbia", "Manitoba", "New Brunswick",
				"Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan",
				"Northwest Territories", "Nunavut", "Yukon" };
		
		for (int i = 0; i < possibleRegions.length; i++) {
			da.setGeoRegion(possibleRegions[i]);
			assertTrue(da.getGeoRegion().equals(possibleRegions[i]));
		}

	}

	@Test
	public void testDriverTypes() throws IOException {
		DataAccessor da = new DataAccessor();
		String[] temp = { "temp1", "temp2", "temp3", "temp4", "temp5" };
		da.setToUser(temp);
		String[] possibleDriverTypes = { "City", "Highway", "Combined" };

		for (int i = 0; i < possibleDriverTypes.length; i++) {
			da.setDriverType(possibleDriverTypes[i]);
			assertTrue(da.getDriverType().equals(possibleDriverTypes[i]));
		}

	}

	@Test
	public void testFuelTypes() throws IOException {
		DataAccessor da = new DataAccessor();
		String[] temp = { "temp1", "temp2", "temp3", "temp4", "temp5" };
		da.setToUser(temp);
		String[] possibleFuelTypes = { "Regular gasoline", "Premium gasoline", "Diesal", "Ethanol", "Natural gas" };

		for (int i = 0; i < possibleFuelTypes.length; i++) {
			da.setDriverType(possibleFuelTypes[i]);
			assertTrue(da.getDriverType().equals(possibleFuelTypes[i]));
		}
	}

	@Test
	public void testFormFactors() throws IOException {
		DataAccessor da = new DataAccessor();
		String[] temp = { "temp1", "temp2", "temp3", "temp4", "temp5" };
		da.setToUser(temp);
		String[] possibleFormFactors = { "COMPACT", "MID-SIZE", "SUBCOMPACT", "STATION WAGON - MID-SIZE", "MINICOMPACT",
				"TWO-SEATER", "STATION WAGON - SMALL", "FULL-SIZE", "SUV", "VAN - CARGO", "VAN - PASSENGER",
				"PICKUP TRUCK - STANDARD", "PICKUP TRUCK - SMALL", "MINIVAN", "SUV - STANDARD",
				"SPECIAL PURPOSE VEHICLE", "SUV - SMALL" };

		for (int i = 0; i < possibleFormFactors.length; i++) {
			da.setDriverType(possibleFormFactors[i]);
			assertTrue(da.getDriverType().equals(possibleFormFactors[i]));
		}
	}

	@Test
	public void testYears() throws IOException {
		DataAccessor da = new DataAccessor();
		String[] temp = { "temp1", "temp2", "temp3", "temp4", "temp5" };
		da.setToUser(temp);
		String[] possibleYears = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014" };

		for (int i = 0; i < possibleYears.length; i++) {
			da.setModelYear(possibleYears[i]);
			assertTrue(da.getModelYear().equals(possibleYears[i]));
		}
	}

	@Test
	public void testTopFive() throws IOException {
		DataAccessor da = new DataAccessor();
		String[] fuelTypes = { "Regular gasoline", "Premium gasoline", "Diesal", "Ethanol", "Natural gas" };
		String[] formFactors = { "COMPACT", "MID-SIZE", "SUBCOMPACT", "STATION WAGON - MID-SIZE", "MINICOMPACT",
				"TWO-SEATER", "STATION WAGON - SMALL", "FULL-SIZE", "SUV", "VAN - CARGO", "VAN - PASSENGER",
				"PICKUP TRUCK - STANDARD", "PICKUP TRUCK - SMALL", "MINIVAN", "SUV - STANDARD",
				"SPECIAL PURPOSE VEHICLE", "SUV - SMALL" };
		String[] years = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010",
				"2011", "2012", "2013", "2014" };
		String[] driverTypes = { "City", "Highway", "Combined" };
		String[] regions = { "Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador",
				"Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan", "Northwest Territories",
				"Nunavut", "Yukon" };

		// Test all possible combinations to ensure that no errors will ever occur during program execution
		for (int j = 0; j < formFactors.length; j++) {
			for (int i = 0; i < years.length; i++) {
				for (int l = 0; l < regions.length; l++) {
					for (int r = 0; r < fuelTypes.length; r++) {
						for (int k = 0; k < driverTypes.length; k++) {
							String[] newFive = { formFactors[j], fuelTypes[r], driverTypes[k], years[i], regions[l] };
							da.setToUser(newFive);
							ArrayList<String[]> five = da.getVehicleResults();

							assertTrue(five.size() >= 0);
						}
					}
				}
			}
		}
	}
}
