
package ch.hearc.inf.dlm.b.chat.frontEnd.connection;

import java.awt.FlowLayout;

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
		// JComponent : Instanciation
		jLabelDistIp = new JLabel("Adresse IP distante");
		jLabelPseudo = new JLabel("Nom d'utilisateur");
		jLabelCurrIp = new JLabel("Votre adresse IP : ");
		jTextFieldDistIp = new JTextField();
		jTextFieldPseudo = new JTextField();
		jButtonConnexion = new JButton("Connexion");
		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jLabelDistIp);
		add(jTextFieldDistIp);
		add(jLabelPseudo);
		add(jTextFieldPseudo);
		add(jLabelCurrIp);
		add(jButtonConnexion);
		}

	private void control()
		{
		// rien
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
	private JButton jButtonConnexion;

	}
