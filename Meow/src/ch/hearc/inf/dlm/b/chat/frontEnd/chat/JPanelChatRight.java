
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;

public class JPanelChatRight extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChatRight(JPanelVideo jPanelVideo, JFrame jFrame)
		{
		this.mother = jFrame;
		this.jPanelVideo = jPanelVideo;
		stateColor = stateMirror = false;
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
		jButtonColor = new JButton();
		changeButtonColorIcon();
		ImageIcon rollOverIcon = new ImageIcon("img/bnw_hover.png");
		rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonColor.setRolloverIcon(rollOverIcon);

		jButtonColor.setContentAreaFilled(false);
		jButtonColor.setBorder(BorderFactory.createEmptyBorder());

		// JComponent : Instanciation
		jButtonMirror = new JButton();
		changeButtonMirrorIcon();
		rollOverIcon = new ImageIcon("img/mirror-horizontally_hover.png");
		rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonMirror.setRolloverIcon(rollOverIcon);

		jButtonMirror.setContentAreaFilled(false);
		jButtonMirror.setBorder(BorderFactory.createEmptyBorder());

		ImageIcon imageIcon = new ImageIcon("img/fullscreen.png");
		imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonFullScreen = new JButton(imageIcon);

		rollOverIcon = new ImageIcon("img/fullscreen_hover.png");
		rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		jButtonFullScreen.setRolloverIcon(rollOverIcon);

		jButtonFullScreen.setContentAreaFilled(false);
		jButtonFullScreen.setBorder(BorderFactory.createEmptyBorder());

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(3, 1, 10, 10);
			setLayout(gridLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jButtonColor);
		add(jButtonMirror);
		add(jButtonFullScreen);

		}

	private void control()
		{

		jButtonColor.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				stateColor = !stateColor;
				changeButtonColorIcon();
				jPanelVideo.toggleBlackAndWhite();
				}
			});

		jButtonMirror.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				stateMirror = !stateMirror;
				changeButtonMirrorIcon();
				jPanelVideo.toggleMirror();
				}
			});

		jButtonFullScreen.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				stateFullScreen = !stateFullScreen;
				fullScreen();
				}
			});
		}

	private void fullScreen()
		{
		if (stateFullScreen)
			{
			mother.setExtendedState(mother.getExtendedState() | Frame.MAXIMIZED_BOTH);
			mother.setUndecorated(true);
			mother.setSize(mother.getToolkit().getScreenSize());
			mother.setLocationRelativeTo(null);
			mother.validate();
			mother.setVisible(true);
			}
		else
			{
			mother.setExtendedState(Frame.NORMAL);
			mother.setUndecorated(false);
			mother.setVisible(true);
			}
		}

	private void appearance()
		{
		// rien
		}

	private void changeButtonColorIcon()
		{
		ImageIcon imageIcon;
		if (stateColor)
			{
			imageIcon = new ImageIcon("img/colors.png");
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			}
		else
			{
			imageIcon = new ImageIcon("img/bnw.png");
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			}
		jButtonColor.setIcon(imageIcon);
		}

	private void changeButtonMirrorIcon()
		{
		ImageIcon imageIcon;
		if (stateMirror)
			{
			imageIcon = new ImageIcon("img/mirror-horizontally_toggle.png");
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			}
		else
			{
			imageIcon = new ImageIcon("img/mirror-horizontally.png");
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			}
		jButtonMirror.setIcon(imageIcon);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JFrame mother;

	private JPanelVideo jPanelVideo;

	private JButton jButtonColor;
	private JButton jButtonMirror;
	private JButton jButtonFullScreen;

	private boolean stateColor;
	private boolean stateMirror;
	private boolean stateFullScreen;

	}
