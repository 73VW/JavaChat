
package ch.hearc.inf.dlm.b.chat.frontEnd.connection;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelConnexion extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelConnexion()
		{
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
		String localhostIp="";
		try
			{
			localhostIp = InetAddress.getLocalHost().getHostAddress();
			}
		catch (UnknownHostException e)
			{
			e.printStackTrace();
			}

		// JComponent : Instanciation
		jLabelDistIp = new JLabel("Adresse IP distante");
		jLabelPseudo = new JLabel("Nom d'utilisateur");
		jLabelCurrIp = new JLabel("Votre adresse IP : ");
		jTextFieldDistIp = new JTextField();
		jTextFieldPseudo = new JTextField();
		jTextFieldIP = new JTextField(localhostIp);
		jButtonConnexion = new JButton("Connexion");
		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(4, 2, 30, 10);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jLabelDistIp);
		add(jTextFieldDistIp);
		add(jLabelPseudo);
		add(jTextFieldPseudo);
		add(jLabelCurrIp);
		add(jTextFieldIP);
		add(jButtonConnexion);
		}

	private void control()
		{
		jButtonConnexion.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mousePressed(MouseEvent e)
				{
				// TODO Auto-generated method stub
				System.out.println(jTextFieldDistIp.getText());
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
	private JLabel jLabelDistIp;
	private JLabel jLabelPseudo;
	private JLabel jLabelCurrIp;
	private JTextField jTextFieldDistIp;
	private JTextField jTextFieldPseudo;
	private JTextField jTextFieldIP;
	private JButton jButtonConnexion;

	}
