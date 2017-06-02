
package ch.hearc.inf.dlm.b.chat.panelvideo;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

public class WebcamTest {

	/**
	 * Récupération de la webcam
	 */
	public static Webcam createWebcam() {
		Webcam webcam = Webcam.getDefault();
		Dimension resolutionVoulue = new Dimension(1920, 1080);
		Dimension[] tabResolutionAlternative = new Dimension[] { resolutionVoulue, WebcamResolution.HD720.getSize(),
				WebcamResolution.VGA.getSize() };
		// Completer au besoin le tableau
		// Si la résolution voulue n’est supportée par la caméra,
		// l’API essaie de trouver le meilleur compromis entre les
		// résolutions supportées par la webcam et les résolutions
		// alternatives.
		webcam.setCustomViewSizes(tabResolutionAlternative);
		webcam.setViewSize(resolutionVoulue);
		webcam.open();
		// webcam.close();
		return webcam;
	}

	/**
	 * Capturer une image
	 */
	public static BufferedImage useWebcam(Webcam webcam) {
		BufferedImage image = webcam.getImage();
		return image;
	}

	/**
	 * Afficher video avec un WebcamPanel
	 */
	public static WebcamPanel createWebcamPanel(Webcam webcam) {
		WebcamPanel webcamPanel = new WebcamPanel(webcam);
		webcamPanel.setFPSDisplayed(true); // Afficher les FPS
		webcamPanel.setImageSizeDisplayed(true); // Afficher la résolution
		webcamPanel.setMirrored(true); // Effet miroir de l’image
		return webcamPanel;
	}

}
