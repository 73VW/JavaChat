
package ch.hearc.inf.dlm.b.chat.panelvideo;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;

public class MyWebcam
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public MyWebcam()
		{
		webcam = WebcamTools.createWebcam();
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

	public BufferedImage getImage()
		{
		return webcam.getImage();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Webcam webcam;

	}
