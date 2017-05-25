package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SingletonComboDiretorio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import java.awt.List;
import java.awt.Button;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JProgressBar;

public class JanelaJavaEasyDirectory extends JFrame {

	private JPanel janelaJavaEasyDirectory;
	private JTextField campoNomeDoArquivo;
	public JComboBox campoDiretorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaJavaEasyDirectory frame = new JanelaJavaEasyDirectory();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //--------- COLOCA EM TELA CHEIA
					//frame.setLocationRelativeTo(null); //TELA CENTRALIZADA
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaJavaEasyDirectory() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuSistema = new JMenu("Sistema");
		menuSistema.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(menuSistema);

		JMenuItem mntmDiretorio = new JMenuItem("Novo diretório");
		mntmDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaNovoDiretorio().setVisible(true);
				
			}
		});
		mntmDiretorio.setIcon(new ImageIcon(JanelaJavaEasyDirectory.class
				.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		menuSistema.add(mntmDiretorio);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		menuSistema.add(separator_1);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setIcon(new ImageIcon(JanelaJavaEasyDirectory.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JanelaSobre().setVisible(true);
			}
		});
		menuSistema.add(mntmSobre);
		
		JSeparator separator = new JSeparator();
		menuSistema.add(separator);
		mntmSair.setIcon(new ImageIcon(
				JanelaJavaEasyDirectory.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		menuSistema.add(mntmSair);
		janelaJavaEasyDirectory = new JPanel();
		janelaJavaEasyDirectory.setToolTipText("");
		janelaJavaEasyDirectory.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janelaJavaEasyDirectory);
		janelaJavaEasyDirectory.setLayout(null);

		JLabel lblJavaEasyDirectory = new JLabel("Java Easy Directory");
		lblJavaEasyDirectory.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblJavaEasyDirectory.setBounds(100, 27, 235, 22);
		janelaJavaEasyDirectory.add(lblJavaEasyDirectory);
		
		JLabel lblDiretrio = new JLabel("Diret\u00F3rio:");
		lblDiretrio.setToolTipText("Selecione um diret\u00F3rio.");
		lblDiretrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiretrio.setBounds(59, 90, 68, 14);
		janelaJavaEasyDirectory.add(lblDiretrio);
		
		JComboBox campoDiretorio = SingletonComboDiretorio.getInstance();
		campoDiretorio.setModel(new DefaultComboBoxModel(new String[] { "Sem diretório" }));
		campoDiretorio.setBounds(144, 90, 264, 20);
		janelaJavaEasyDirectory.add(campoDiretorio);

		JLabel lblNomeDoArquivo = new JLabel("Nome da pasta:");
		lblNomeDoArquivo.setToolTipText("Insira o nome da pasta que deseja criar.");
		lblNomeDoArquivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoArquivo.setBounds(15, 120, 112, 14);
		janelaJavaEasyDirectory.add(lblNomeDoArquivo);

		JTextField campoNomeDoArquivo = new JTextField();
		campoNomeDoArquivo.setBounds(144, 120, 264, 20);
		janelaJavaEasyDirectory.add(campoNomeDoArquivo);
		campoNomeDoArquivo.setColumns(10);

		JButton btnCriarDiretrio = new JButton("Criar diret\u00F3rio");
		btnCriarDiretrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nomeDirDesejado = (String) campoDiretorio.getSelectedItem();

				String nomePasta = campoNomeDoArquivo.getText();

				File novaPasta = new File(nomeDirDesejado, nomePasta);
				novaPasta.mkdir();

				if (nomePasta.isEmpty())
					throw new IllegalArgumentException();
				else
					JOptionPane.showMessageDialog(null, "Diretório criado em:\n" + nomeDirDesejado + "\\" + nomePasta, "Mensagem", 1);

			}
		});
		btnCriarDiretrio.setBounds(150, 200, 126, 23);
		janelaJavaEasyDirectory.add(btnCriarDiretrio);
	}
}
