
package ch.hearc.inf.dlm.b.chat;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.hearc.inf.dlm.b.chat.frontEnd.connection.JFrameConnexion;
/**
 *
 * Run chat
 *
 */
public class UseApplication
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
		new JFrameConnexion();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/


	}

