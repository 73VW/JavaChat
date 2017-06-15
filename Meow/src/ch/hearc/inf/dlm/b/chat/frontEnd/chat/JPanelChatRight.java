
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;

public class JPanelChatRight extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChatRight(JPanelVideo jPanelVideo, JFrameChat jFrame)
		{
		this.mother = jFrame;
		this.jPanelVideo = jPanelVideo;
		stateColor = stateMirror = false;
		oldLoc = new Point(0,0);
		oldSize = new Dimension(0, 0);
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
			GridLayout gridLayout = new GridLayout(3, 1);
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
			ImageIcon imageIcon = new ImageIcon("img/minimize.png");
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			jButtonFullScreen.setIcon(imageIcon);

			ImageIcon rollOverIcon = new ImageIcon("img/minimize_hover.png");
			rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			jButtonFullScreen.setRolloverIcon(rollOverIcon);

			oldSize = mother.getSize();
			oldLoc = mother.getLocation();
			mother.setLocationRelativeTo(null);
			mother.dispose();
			mother.switchDecoration();
			mother.pack();
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(mother);
			}
		else
			{
			ImageIcon imageIcon = new ImageIcon("img/fullscreen.png");
			imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			jButtonFullScreen.setIcon(imageIcon);

			ImageIcon rollOverIcon = new ImageIcon("img/fullscreen_hover.png");
			rollOverIcon = new ImageIcon(rollOverIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			jButtonFullScreen.setRolloverIcon(rollOverIcon);

			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
			mother.dispose();
			mother.switchDecoration();
			System.out.println(oldSize.toString());
			mother.pack();
			mother.setSize(oldSize);
			mother.setLocation(oldLoc);
			System.out.println(mother.getSize());
			}
		mother.setVisible(true);
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
	private JFrameChat mother;

	private JPanelVideo jPanelVideo;

	private JButton jButtonColor;
	private JButton jButtonMirror;
	private JButton jButtonFullScreen;

	private boolean stateColor;
	private boolean stateMirror;
	private boolean stateFullScreen;

	private Point oldLoc;
	private Dimension oldSize;

	}
