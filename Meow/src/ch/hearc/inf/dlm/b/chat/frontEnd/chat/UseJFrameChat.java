
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UseJFrameChat
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		try
			{
			UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
			}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		JFrameChat jFrame = new JFrameChat();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
