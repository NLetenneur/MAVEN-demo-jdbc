package fr.diginamic.props;

import java.util.ResourceBundle;

public class TestConfigurationProps {

	public static void main(String[] args) {
		ResourceBundle config = ResourceBundle.getBundle("database");
		String driverName = config.getString("database.driver");
		System.out.println(driverName);

	}

}
