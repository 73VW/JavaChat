
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;

public class JFrameChat extends JFrame
	{
	// TODO set border->border factory
	// create title border
	// Jpanel decorator
	// image dans boutons
	// image dans jframe
	// logo applicatif
	// plein écran sans barre de titre
	// jpanel option video (noir/blanc, mirroir)
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameChat()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addLine(String msg, Boolean provenance)
		{
		jPanelChat.addLine(msg, provenance);
		}

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
		JPanelVideo jPanelVideo = new JPanelVideo();
		jPanelChat = new JPanelChat();
		// Layout : Specification
			{
			BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
			setLayout(boxLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelVideo);
		add(jPanelChat);
		jPanelVideo.setVisible(false);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setTitle("Java Chat");
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelChat jPanelChat;

	}
