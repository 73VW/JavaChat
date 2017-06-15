
package ch.hearc.inf.dlm.b.chat.reseau.spec;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.PublicKey;

import ch.hearc.inf.dlm.b.chat.reseau.image.ImageSerializable;

public interface Application_I extends Remote
	{

	public void setText(String stringCrypter) throws RemoteException;

	public void setImage(ImageSerializable imageSerializable) throws RemoteException;

	public void savePublicKey(PublicKey publicKey) throws RemoteException;

	}
