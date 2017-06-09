
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelChatBottom extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChatBottom(JPanelChat jPanelChat)
		{
		this.jPanelChat = jPanelChat;
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
		jTextFieldMessage = new JTextField();
		jButtonSend = new JButton("Envoyer");
		jbuttonVideo = new JButton("Video");

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(1, 3, 20, 20);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jTextFieldMessage);
		add(jButtonSend);
		add(jbuttonVideo);
		}

	private void control()
		{
		jButtonSend.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mousePressed(MouseEvent e)
				{
				// TODO Auto-generated method stub
				jPanelChat.addLine(jTextFieldMessage.getText(), false);
				jTextFieldMessage.setText("");
				jTextFieldMessage.requestFocus();
				}
			});
		jbuttonVideo.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mousePressed(MouseEvent e)
				{
				// TODO Auto-generated method stub
				System.out.println("Open Video");
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
	//input
	private JPanelChat jPanelChat;

	// Tools
	private JTextField jTextFieldMessage;
	private JButton jButtonSend;
	private JButton jbuttonVideo;

	}
