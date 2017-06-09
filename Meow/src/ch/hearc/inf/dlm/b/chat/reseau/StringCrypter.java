
package ch.hearc.inf.dlm.b.chat.reseau;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringCrypter implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public StringCrypter(String secret)
		{
		this.secret = secret;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return secret;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static String crypter(String string)
		{
		return "x" + string; // todo dégainer les algorithmes du cours de sécurité
		}

	private static String decrypter(String string)
		{
		return string.substring(1);//todo fonction inverse du cryptage
		}

	/*------------------------------*\
	|*		Serialisation			*|
	\*------------------------------*/

	private void writeObject(ObjectOutputStream out) throws IOException
		{
		out.writeObject(crypter(secret));
		}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
		{
		secret = decrypter((String)in.readObject());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private String secret;
	}
