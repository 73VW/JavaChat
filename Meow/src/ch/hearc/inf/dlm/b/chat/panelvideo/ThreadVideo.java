
package ch.hearc.inf.dlm.b.chat.panelvideo;

import java.awt.image.BufferedImage;

public class ThreadVideo implements Runnable
	{

	public ThreadVideo(JPanelVideo jPanelVideo)
		{
		this.myWebcam = new MyWebcam();
		this.jPanelVideo = jPanelVideo;
		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		while(true)
			{
				BufferedImage image = myWebcam.getImage();
				jPanelVideo.setLocalImage(image);
			}
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

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private MyWebcam myWebcam;
	private JPanelVideo jPanelVideo;

	}
