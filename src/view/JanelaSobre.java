package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class JanelaSobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaSobre frame = new JanelaSobre();
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
	public JanelaSobre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(458, 280, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesenvolvidoPorRenan = new JLabel("Desenvolvido por Renan Narciso", JLabel.CENTER);
		lblDesenvolvidoPorRenan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesenvolvidoPorRenan.setBounds(85, 11, 255, 14);
		contentPane.add(lblDesenvolvidoPorRenan);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(109, 57, 38, 14);
		contentPane.add(lblEmail);
		
		JLabel lblRenannarcisogmailcom = new JLabel("renan.narciso21@gmail.com");
		lblRenannarcisogmailcom.setSize(201, 14);
		lblRenannarcisogmailcom.setLocation(154, 57);
		lblRenannarcisogmailcom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblRenannarcisogmailcom);
		
		JLabel lblGithub = new JLabel("Github:");
		lblGithub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGithub.setBounds(117, 82, 47, 14);
		contentPane.add(lblGithub);
		
		JLabel lblGithubcomrenanzinth = new JLabel("github.com/Renanzinth");
		lblGithubcomrenanzinth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGithubcomrenanzinth.setBounds(171, 82, 169, 14);
		contentPane.add(lblGithubcomrenanzinth);
		
		JLabel lblV = new JLabel("v1.5 - 2017", SwingConstants.CENTER);
		lblV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblV.setBounds(171, 136, 81, 14);
		contentPane.add(lblV);
	}

}
