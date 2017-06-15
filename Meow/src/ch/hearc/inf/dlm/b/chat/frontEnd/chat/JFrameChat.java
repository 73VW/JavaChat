
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;
import ch.hearc.inf.dlm.b.chat.tools.JPanelDecorator;

public class JFrameChat extends JFrame
	{
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
		jPanelVideoChat.addLine(msg, provenance);
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
		jPanelVideoChat = new JPanelVideoChat(this);
		JPanelDecorator jPanelDecorator = new JPanelDecorator(jPanelVideoChat, 20);
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}
		add(jPanelDecorator, BorderLayout.CENTER);
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
		ImageIcon imgIcon = new ImageIcon("img/logo.png");
		Image img = imgIcon.getImage();
		setIconImage(img);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(false);
		setVisible(true); // last!
		}

	public void switchDecoration(){
		setUndecorated(!isUndecorated());
	}

	public JPanelVideo getVideoPanel()
		{
		return jPanelVideoChat.getVideoPanel();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelVideoChat jPanelVideoChat;

	}
