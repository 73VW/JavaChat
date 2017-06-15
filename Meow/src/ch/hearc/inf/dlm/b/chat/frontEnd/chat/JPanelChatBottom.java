
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.inf.dlm.b.chat.reseau.Application;
import ch.hearc.inf.dlm.b.chat.reseau.message.StringCrypter;
import ch.hearc.inf.dlm.b.chat.reseau.spec.Application_I;

public class JPanelChatBottom extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChatBottom(JPanelChat jPanelChat)
		{
		application=Application.getInstance().getRemote();
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
			GridLayout gridLayout = new GridLayout(0, 2, 10, 0);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		JPanel jPanelButtons = new JPanel();
		jPanelButtons.setLayout(new GridLayout(0, 2, 10, 0));
		jPanelButtons.add(jButtonSend);
		jPanelButtons.add(jbuttonVideo);

		// JComponent : add
		add(jTextFieldMessage);
		add(jPanelButtons);
		}

	private void control()
		{
		jTextFieldMessage.addKeyListener(new KeyAdapter()
			{

			@Override
			public void keyPressed(KeyEvent e)
				{
				if (e.getKeyCode() == 10)
					{
					sendMessage();
					}
				}
			});
		jButtonSend.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mousePressed(MouseEvent e)
				{
				sendMessage();
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

	private void sendMessage()
		{
		jPanelChat.addLine(jTextFieldMessage.getText(), true);
		jTextFieldMessage.setText("");

		try
			{
			Application.getInstance().getRemote().setText(new StringCrypter(jTextFieldMessage.getText()));
			}
		catch (RemoteException e)
			{
			e.printStackTrace();
			}
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
	private Application_I application;


	}
