
package ch.hearc.inf.dlm.b.chat.reseau.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

public class ImageSerializable implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ImageSerializable(BufferedImage image)
		{
		this.image = image;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setImage(BufferedImage image)
		{
		this.image = image;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public BufferedImage getImage()
		{
		return this.image;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	/**
	* Customisation sérialisation
	 * @throws IOException
	*/
	private void writeObject(ObjectOutputStream oss) throws IOException
		{
		ImageIO.write(this.image, "jpeg", oss);
		}

	/**
	* Customisation désérialisation
	 * @throws IOException
	*/
	private void readObject(ObjectInputStream ois) throws IOException
		{
		this.image = ImageIO.read(ois);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// transient -> l'attribut ne sera pas sérialisé
	// Rappel: BufferedImage n'est pas sérialisable
	private transient BufferedImage image;

	}
