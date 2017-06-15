
package ch.hearc.inf.dlm.b.chat.panelvideo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import javax.swing.JPanel;

public class JPanelVideo extends JPanel implements JPanelVideo_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVideo()
		{
		blackAndWhite = false;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		imageLocal = new BufferedImage(300, 200, BufferedImage.TYPE_3BYTE_BGR);
		imageExterne = new BufferedImage(300, 200, BufferedImage.TYPE_3BYTE_BGR);
		ThreadVideo threadVideo = new ThreadVideo(this);
		new Thread(threadVideo).start();

		// Layout : Specification
			{
			//			BorderLayout borderLayout = new BorderLayout();
			//			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		//add(new JButton(),BorderLayout.CENTER);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform transform = g2d.getTransform();
		dessiner(g2d);
		g2d.setTransform(transform);
		}

	private void dessiner(Graphics2D g2d)
		{
		if(blackAndWhite)
			{
			imageExterne=setBlackAndWhite(imageExterne);
			imageLocal=setBlackAndWhite(imageLocal);

			}
		g2d.scale(-1,1);
		g2d.translate(-this.getWidth(), 0);
		g2d.drawImage(imageLocal, 0, 0, this.getWidth() / 2, this.getHeight(), null);
		g2d.drawImage(imageExterne, this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight(), this);
		}

	private BufferedImage setBlackAndWhite(BufferedImage bufferedImage)
		{
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
	    ColorConvertOp op = new ColorConvertOp(cs, null);

	    return op.filter(bufferedImage, null);
		}



	@Override
	public void setLocalImage(BufferedImage image)
		{
		this.imageLocal = image;
		repaint();
		}

	@Override
	public void setExternalImage(BufferedImage image)
		{
		this.imageExterne = image;
		repaint();

		}

	@Override
	public void toggleBlackAndWhite()
		{
		blackAndWhite=!blackAndWhite;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private BufferedImage imageLocal;
	private BufferedImage imageExterne;
	private boolean blackAndWhite;

	}
