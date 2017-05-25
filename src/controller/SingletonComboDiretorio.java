package controller;

import javax.swing.JComboBox;

public class SingletonComboDiretorio {

	private static JComboBox comboBoxDiretorio;

	private SingletonComboDiretorio() {

	}

	public static synchronized JComboBox getInstance() {
		if (comboBoxDiretorio == null) {
			comboBoxDiretorio = new JComboBox();
		}
		return comboBoxDiretorio;
	}
}