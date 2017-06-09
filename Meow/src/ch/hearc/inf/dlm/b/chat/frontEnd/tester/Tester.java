
package ch.hearc.inf.dlm.b.chat.frontEnd.tester;

import ch.hearc.inf.dlm.b.chat.frontEnd.chat.JFrameChat;

public class Tester
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
		JFrameChat jFrameChat = new JFrameChat();
		Thread thread = new Thread(new Runnable()
			{

			int i = 0;
			Boolean state = false;

			@Override
			public void run()
				{
				while(true)
					{
					jFrameChat.addLine("Message " + i++, state);
					try
						{
						Thread.sleep(800);
						}
					catch (InterruptedException e)
						{
						e.printStackTrace();
						}
					state = !state;
					}
				}
			});

		thread.start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
