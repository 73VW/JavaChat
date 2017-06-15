
package ch.hearc.inf.dlm.b.chat.frontEnd.connection;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.inf.dlm.b.chat.frontEnd.chat.JFrameChat;
import ch.hearc.inf.dlm.b.chat.reseau.Application;

import com.bilat.tools.reseau.rmi.NetworkTools;

public class JPanelConnexion extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelConnexion(JFrame frame)
		{
		parent = frame;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		String localhostIp = "";

		try
			{
			localhostIp = NetworkTools.localhost("").get(0).toString();
			}
		catch (SocketException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		localhostIp = localhostIp.substring(1);

		// JComponent : Instanciation
		jLabelDistIp = new JLabel("Adresse IP distante");
		jLabelPseudo = new JLabel("Nom d'utilisateur");
		jLabelCurrIp = new JLabel("Votre adresse IP : ");
		jTextFieldDistIp = new JTextField();
		jTextFieldPseudo = new JTextField();
		jLabelIp = new JLabel(localhostIp);

		ImageIcon imageIcon = new ImageIcon("img/connect.png");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonConnexion = new JButton(imageIcon);

		ImageIcon rollOverIcon = new ImageIcon("img/connect_hover.png"); // Icon for roll over (hovering effect)
		rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonConnexion.setRolloverIcon(rollOverIcon); // Set the icon attaching with the roll-over event

		jButtonConnexion.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		jButtonConnexion.setContentAreaFilled(false);
		jButtonConnexion.setBorder(BorderFactory.createEmptyBorder());
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3, 2, 30, 10));

		// JComponent : add
		jPanel.add(jLabelDistIp);
		jPanel.add(jTextFieldDistIp);
		jPanel.add(jLabelPseudo);
		jPanel.add(jTextFieldPseudo);
		jPanel.add(jLabelCurrIp);
		jPanel.add(jLabelIp);
		add(jPanel, BorderLayout.CENTER);
		add(jButtonConnexion, BorderLayout.SOUTH);
		}

	private void control()
		{
		jButtonConnexion.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// TODO Conect
				System.out.println("Lancement de l'application");

				if (checkInput())
					{
					new Thread(new Runnable()
						{

						@Override
						public void run()
							{
							connection();
							}

						}).start();
					}
				}

			private boolean checkInput()
				{
				if (IPV4_PATTERN.matcher(jTextFieldDistIp.getText()).matches())
					{
					if (!jTextFieldPseudo.getText().isEmpty())
						{
						return true;
						}
					else
						{
						JOptionPane.showMessageDialog(null, "Please enter a pseudo.", "Error", JOptionPane.ERROR_MESSAGE);
						return false;
						}
					}
				else
					{
					JOptionPane.showMessageDialog(null, "IP adresse is not valid.", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
					}
				}

			private void connection()
				{
				jButtonConnexion.setEnabled(false);

				Application.init(jTextFieldDistIp.getText(), jTextFieldPseudo.getText());
				JFrameChat jFrameChat = new JFrameChat();
				application = Application.getInstance();
				application.setJFrameChat(jFrameChat);
				application.setJPanelVideo(jFrameChat.getVideoPanel());
				Thread thread = new Thread(application);
				thread.start();

				parent.setVisible(false);
				parent.dispose();
				}
			});

		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JFrame parent;
	private JLabel jLabelDistIp;
	private JLabel jLabelPseudo;
	private JLabel jLabelCurrIp;
	private JTextField jTextFieldDistIp;
	private JTextField jTextFieldPseudo;
	private JLabel jLabelIp;
	private JButton jButtonConnexion;
	private Application application;

	private static final Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

	}
/*
icon by http://www.freepik.com
*/
