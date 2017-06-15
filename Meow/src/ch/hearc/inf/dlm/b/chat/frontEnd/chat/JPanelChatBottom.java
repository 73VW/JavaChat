
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.inf.dlm.b.chat.reseau.Application;
import ch.hearc.inf.dlm.b.chat.reseau.message.StringCrypter;

public class JPanelChatBottom extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChatBottom(JPanelChat jPanelChat)
		{
		updatedByUser = false;
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
		jTextFieldMessage.setText("Enter your message here");
		jTextFieldMessage.setForeground(new Color(150, 150, 150));

		ImageIcon imageIcon = new ImageIcon("img/right-arrow.png");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonSend = new JButton(imageIcon);

		ImageIcon rollOverIcon = new ImageIcon("img/right-arrow_hover.png");
		rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonSend.setRolloverIcon(rollOverIcon);

		jButtonSend.setContentAreaFilled(false);
		jButtonSend.setBorder(BorderFactory.createEmptyBorder());

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jTextFieldMessage, BorderLayout.CENTER);
		add(jButtonSend, BorderLayout.EAST);
		}

	private void control()
		{
		jTextFieldMessage.addKeyListener(new KeyAdapter()
			{

			@Override
			public void keyPressed(KeyEvent e)
				{
				updatedByUser = true;
				if (e.getKeyCode() == 10)
					{
					sendMessage();
					updatedByUser = false;
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

		jTextFieldMessage.addFocusListener(new FocusListener()
			{

			@Override
			public void focusGained(FocusEvent e)
				{
				if (!updatedByUser)
					{
					jTextFieldMessage.setText("");
					jTextFieldMessage.setForeground(new Color(255, 255, 255));
					}
				}

			@Override
			public void focusLost(FocusEvent e)
				{

				if (jTextFieldMessage.getText().length() == 0)
					{
					jTextFieldMessage.setText("Enter your message here");
					jTextFieldMessage.setForeground(new Color(150, 150, 150));
					updatedByUser = false;
					}
				}
			});
		}

	private void sendMessage()
		{
		String msg = Application.getInstance().getPseudo() + " : " + jTextFieldMessage.getText();
		jPanelChat.addLine(msg, true);

		try
			{
			Application.getInstance().getRemote().setText(new StringCrypter(msg));
			}
		catch (RemoteException e)
			{
			e.printStackTrace();
			}

		jTextFieldMessage.setText("");
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

	private boolean updatedByUser;
	}
