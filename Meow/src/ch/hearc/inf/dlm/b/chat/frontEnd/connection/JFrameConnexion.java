
package ch.hearc.inf.dlm.b.chat.frontEnd.connection;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import ch.hearc.inf.dlm.b.chat.tools.JPanelDecorator;

public class JFrameConnexion extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameConnexion()
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
		jPanelConnexion = new JPanelConnexion();
		jPanelDecorator = new JPanelDecorator(jPanelConnexion, 20);
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelDecorator, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(460, 200);
		setLocationRelativeTo(null); // frame centrer
		setResizable(false);
		setTitle("Java Chat - Connexion!");
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelConnexion jPanelConnexion;
	private JPanelDecorator jPanelDecorator;

	}
