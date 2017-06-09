
package ch.hearc.inf.dlm.b.chat.reseau;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import org.junit.Assert;

import ch.hearc.inf.dlm.b.chat.frontEnd.chat.JFrameChat;
import ch.hearc.inf.dlm.b.chat.panelvideo.JPanelVideo;

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
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setJPanelVideo(JPanelVideo jPanelVideo)
		{
		this.jPanelVideo = jPanelVideo;
		}

	public void setJFrameChat(JFrameChat jFrameChat)
		{
		this.jFrameChat = jFrameChat;
		}

	@Override
	public void setText(StringCrypter stringCrypter) throws RemoteException
		{
		String string = new String("salut");
		this.remoteInstance.addLine(string);
		}

	@Override
	public void addLine(String message) throws RemoteException
		{
		this.jFrameChat.addLine(message, false);
		}

	@Override
	public void setImage(ImageSerializable imageSerializable) throws RemoteException
		{
		this.remoteInstance.addImage(imageSerializable);
		}

	@Override
	public void addImage(ImageSerializable imageSerializable) throws RemoteException
		{
		this.jPanelVideo.setExternalImage(imageSerializable.getImage());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized void init(ApplicationSettings applicationSettings)
		{
		Assert.assertTrue(applicationSettings != null);
		}

	public static synchronized Application getInstance()
		{
		Assert.assertTrue(applicationSettings != null);

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
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Application_I remoteInstance;
	private JFrameChat jFrameChat;
	private JPanelVideo jPanelVideo;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static ApplicationSettings applicationSettings;
	public static boolean IS_CONNECTED_TO_REMOTE_INSTANCE = false;
	private static Application INSTANCE = null;
	private static String PSEUDO = null;
	private static String SERVER_NAME = null;

	}
