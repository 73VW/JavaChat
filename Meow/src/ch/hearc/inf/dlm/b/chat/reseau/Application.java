
package ch.hearc.inf.dlm.b.chat.reseau;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import ch.hearc.inf.dlm.b.chat.frontEnd.chat.JFrameChat;
import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;
import ch.hearc.inf.dlm.b.chat.reseau.image.ImageSerializable;
import ch.hearc.inf.dlm.b.chat.reseau.message.StringCrypter;
import ch.hearc.inf.dlm.b.chat.reseau.spec.Application_I;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class Application implements Application_I ,Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Application()
		{
		this.remoteInstance = null;

		generateKeysSecurity();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void savePublicKey(PublicKey publicKey) throws RemoteException
		{
		this.remotePubliceKey = publicKey;
		}

	@Override
	public void setText(StringCrypter stringCrypter) throws RemoteException
		{
		addLine(stringCrypter.toString());
		}

	@Override
	public void setImage(ImageSerializable imageSerializable) throws RemoteException
		{
		addImage(imageSerializable);
		}

	@Override
	public void run()
		{
		System.out.println("[Application]:run");

		try
			{
			serverSide();
			clientSide();
			}
		catch (MalformedURLException e)
			{
			e.printStackTrace();
			}

		}

	public void setJPanelVideo(JPanelVideo jPanelVideo)
		{
		this.jPanelVideo = jPanelVideo;
		}

	public void setJFrameChat(JFrameChat jFrameChat)
		{
		this.jFrameChat = jFrameChat;
		}

	public void addLine(String message) throws RemoteException
		{
		this.jFrameChat.addLine(message, false);
		}

	public void addImage(ImageSerializable imageSerializable) throws RemoteException
		{
		this.jPanelVideo.setExternalImage(imageSerializable.getImage());
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public PublicKey getRemotePublickey()
		{
		return this.remotePubliceKey;
		}

	public PrivateKey getPrivateKey()
		{
		return this.privateKey;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static void init(String serverName, String pseudo)
		{
		SERVER_NAME = serverName;
		PSEUDO = pseudo;
		}

	public static synchronized Application getInstance()
		{
		getInstance();

		if (INSTANCE == null)
			{
			INSTANCE = new Application();
			}
		return INSTANCE;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Server			*|
	\*------------------------------*/

	private void serverSide() throws MalformedURLException
		{

		try
			{
			RmiURL rmiURL = new RmiURL("007", 1099);
			RmiTools.shareObject(this, rmiURL);
			RmiTools.afficherAllShareObject(1099);
			}
		catch (RemoteException e)
			{
			System.err.println("[Application]:serverSide:share failed");
			e.printStackTrace();
			}
		}

	/*------------------------------*\
	|*			  Client			*|
	\*------------------------------*/

	private void clientSide() throws MalformedURLException
		{
		Application_I application = connect();
		IS_CONNECTED_TO_REMOTE_INSTANCE = true;
		this.remoteInstance = application;
		}

	private Application_I connect() throws MalformedURLException
		{
		try
			{
			long delayMs = 1000L;
			int nbTentativeMax = 100;
			RmiURL rmiURL = new RmiURL("007", InetAddress.getByName(SERVER_NAME), 1099);
			return (Application_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayMs, nbTentativeMax);
			}
		catch (UnknownHostException e)
			{
			System.err.println("[Application]: fail to reach host: " + e);
			e.printStackTrace();
			return null;
			}
		catch (RemoteException e)
			{
			System.err.println("[Application]: " + e);
			e.printStackTrace();
			}
		return null;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void generateKeysSecurity()
		{
		KeyPairGenerator keyGen = null;
		try
			{
			keyGen = KeyPairGenerator.getInstance("RSA");
			}
		catch (NoSuchAlgorithmException e)
			{
			e.printStackTrace();
			}
		keyGen.initialize(1024);

		KeyPair pair = keyGen.generateKeyPair();

		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Application_I remoteInstance;
	private JFrameChat jFrameChat;
	private JPanelVideo jPanelVideo;

	private PrivateKey privateKey;
	private PublicKey publicKey;

	private PublicKey remotePubliceKey;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static boolean IS_CONNECTED_TO_REMOTE_INSTANCE = false;
	private static Application INSTANCE = null;
	private static String PSEUDO = null;
	private static String SERVER_NAME = null;

	}
