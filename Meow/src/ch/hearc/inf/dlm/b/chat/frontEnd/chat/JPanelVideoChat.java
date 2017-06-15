
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;
import ch.hearc.inf.dlm.b.chat.tools.JPanelDecorator;

public class JPanelVideoChat extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVideoChat(JFrame jFrame)
		{
		this.mother = jFrame;
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
		jPanelVideo = new JPanelVideo();
		jPanelChat = new JPanelChat();
		jPanelChatRight = new JPanelChatRight(jPanelVideo, mother);
		JPanelDecorator jPanelDecorator = new JPanelDecorator(jPanelChatRight, 20);
		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(2, 1);
			setLayout(gridLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jPanelVideo, BorderLayout.CENTER);
		jPanel.add(jPanelDecorator, BorderLayout.EAST);

		// JComponent : add
		add(jPanel);
		add(jPanelChat);
		jPanelVideo.setVisible(true);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	public JPanelVideo getVideoPanel()
		{
		return jPanelVideo;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelChat jPanelChat;
	private JPanelVideo jPanelVideo;
	private JPanelChatRight jPanelChatRight;

	private JFrame mother;

	}
