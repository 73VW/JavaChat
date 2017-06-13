
package ch.hearc.inf.dlm.b.chat.reseau.spec;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.PrivateKey;

import ch.hearc.inf.dlm.b.chat.reseau.image.ImageSerializable;
import ch.hearc.inf.dlm.b.chat.reseau.message.StringCrypter;

public interface Application_I extends Remote
	{

	public void setText(StringCrypter stringCrypter) throws RemoteException;

	public void setImage(ImageSerializable imageSerializable) throws RemoteException;

	public abstract void savePrivateKey(PrivateKey privateKey) throws RemoteException;

	}
