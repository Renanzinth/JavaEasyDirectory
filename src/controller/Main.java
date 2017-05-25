package controller;

import javax.swing.UIManager;

import view.JanelaJavaEasyDirectory;

public class Main {

	public static void main(String[] args) {

		// Muda o Look and Feel da Aplicação
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JanelaJavaEasyDirectory jjed = new JanelaJavaEasyDirectory();
		jjed.setVisible(true);
		jjed.setLocationRelativeTo(null);
	}

}
