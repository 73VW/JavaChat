
package ch.hearc.inf.dlm.b.chat.reseau;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UseApplication {

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args) {
		main();
	}

	public static void main() {
		try {
			String serverName = InetAddress.getLocalHost().getHostName();
			System.out.println(InetAddress.getByName("INF15-GANDERL")); // à
																		// stocker
																		// dans
																		// les
																		// settings

			// Application.init(serverName);
			// Application.getInstance().run();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

}
