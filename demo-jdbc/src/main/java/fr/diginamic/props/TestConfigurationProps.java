package fr.diginamic.props;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class TestConfigurationProps {

	public static void main(String[] args) {
		ResourceBundle config = ResourceBundle.getBundle("database");
		System.out.println(config.getString("database.user"));
		
		Enumeration<String> keys = config.getKeys();
		while(keys.hasMoreElements()) {
			System.out.println(keys.nextElement());
		}
	}

}
