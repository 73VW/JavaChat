
package ch.hearc.inf.dlm.b.chat.frontEnd.connection;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JLabel;
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
		localhostIp=localhostIp.substring(1);

		// JComponent : Instanciation
		jLabelDistIp = new JLabel("Adresse IP distante");
		jLabelPseudo = new JLabel("Nom d'utilisateur");
		jLabelCurrIp = new JLabel("Votre adresse IP : ");
		jTextFieldDistIp = new JTextField();
		jTextFieldPseudo = new JTextField();
		jLabelIp = new JLabel(localhostIp);
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
		add(jLabelIp);
		add(jButtonConnexion);
		}

	private void control()
		{
		jButtonConnexion.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println(jTextFieldDistIp.getText());
				startApplication();

				}
			});

		}

	private void appearance()
		{
		// rien
		}

	private void startApplication()
		{
		Application.init(jTextFieldDistIp.getText(), jTextFieldPseudo.getText());
		JFrameChat jFrameChat=new JFrameChat();
		application=Application.getInstance();
		application.setJFrameChat(jFrameChat);
		application.setJPanelVideo(jFrameChat.getVideoPanel());
		Thread thread=new Thread(application);
		thread.start();

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
	private JLabel jLabelIp;
	private JButton jButtonConnexion;
	private Application application;

	}
