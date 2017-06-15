
package ch.hearc.inf.dlm.b.chat.frontEnd.connection;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ch.hearc.inf.dlm.b.chat.tools.JPanelDecorator;

//all the icons come from here : http://www.flaticon.com

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
		jPanelConnexion = new JPanelConnexion(this);
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
		ImageIcon imgIcon = new ImageIcon("img/logo.png");
		Image img = imgIcon.getImage();
		setIconImage(img);
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelConnexion jPanelConnexion;
	private JPanelDecorator jPanelDecorator;

	}
