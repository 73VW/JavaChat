
package ch.hearc.inf.dlm.b.chat.reseau.message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;

import ch.hearc.inf.dlm.b.chat.reseau.Application;

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

	public String getMessage()
		{
		return secret;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private SealedObject crypter()
		{
		System.out.println("Test crypter");
		try
			{
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, Application.getInstance().getRemotePublickey());

			return new SealedObject(secret, cipher);

			}
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | IOException e1)
			{
			e1.printStackTrace();
			return null;
			}
		}

	private String decrypter(SealedObject messageCrypted)
		{
		System.out.println("Test decrypter");
		try
			{
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, Application.getInstance().getPrivateKey());
			return (String)messageCrypted.getObject(cipher);
			}
		catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException | IOException e)
			{
			e.printStackTrace();
			return null;
			}
		}

	/*------------------------------*\
	|*		Serialisation			*|
	\*------------------------------*/

	private void writeObject(ObjectOutputStream out) throws IOException
		{
		out.writeObject(crypter());
		}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
		{
		secret = decrypter((SealedObject)in.readObject());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private String secret;
	}
