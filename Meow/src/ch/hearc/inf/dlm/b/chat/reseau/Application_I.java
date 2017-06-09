
package ch.hearc.inf.dlm.b.chat.reseau;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Application_I extends Remote
	{

	public void setText(StringCrypter stringCrypter) throws RemoteException;

	public void setImage(ImageSerializable imageSerializable) throws RemoteException;

	public void addLine(String string) throws RemoteException;

	public void addImage(ImageSerializable imageSerializable) throws RemoteException;

	}
