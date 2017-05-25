package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.SingletonComboDiretorio;

public class JanelaNovoDiretorio extends JFrame {

	private JPanel janelaDiretorio;
	private JPanel janelaJavaEasyDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaNovoDiretorio frame = new JanelaNovoDiretorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaNovoDiretorio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(458, 280, 450, 200);
		janelaDiretorio = new JPanel();
		janelaDiretorio.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janelaDiretorio);
		janelaDiretorio.setLayout(null);

		JLabel lblDiretorio = new JLabel("Diretório:");
		lblDiretorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiretorio.setBounds(59, 55, 68, 14);
		janelaDiretorio.add(lblDiretorio);

		JTextField campoNovoDiretorio = new JTextField();
		campoNovoDiretorio.setBounds(144, 53, 264, 20);
		janelaDiretorio.add(campoNovoDiretorio);
		campoNovoDiretorio.setColumns(10);

		JButton btnAddDiretorio = new JButton("Adicionar diretório");
		btnAddDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String novoDiretorio = campoNovoDiretorio.getText();

				JComboBox comboBoxDiretorio = SingletonComboDiretorio.getInstance();
				DefaultComboBoxModel model = (DefaultComboBoxModel) comboBoxDiretorio.getModel();

				if (novoDiretorio.isEmpty())
					throw new RuntimeException();
				else if (model.getIndexOf(novoDiretorio) != -1) {
					JOptionPane.showMessageDialog(null, "Diretório ja existe, adicione outro!");
					new JanelaNovoDiretorio().setVisible(true);
				} else {
					comboBoxDiretorio.addItem(novoDiretorio);
					JOptionPane.showMessageDialog(null, "Diretório adicionado à lista:\n " + novoDiretorio, "Mensagem",
							1);
				}
				dispose();
			}
		});
		btnAddDiretorio.setBounds(143, 83, 264, 25);
		janelaDiretorio.add(btnAddDiretorio);

		JButton btnVoltarTelaInicial = new JButton("Voltar");
		btnVoltarTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});
		btnVoltarTelaInicial.setBounds(215, 123, 126, 23);
		janelaDiretorio.add(btnVoltarTelaInicial);
	}
}