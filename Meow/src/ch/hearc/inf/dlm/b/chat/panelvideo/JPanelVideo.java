
package ch.hearc.inf.dlm.b.chat.panelvideo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class JPanelVideo extends JPanel implements JPanelVideo_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelVideo()
		{
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
		image=new BufferedImage(300, 200, BufferedImage.TYPE_3BYTE_BGR);
		ThreadVideo threadVideo=new ThreadVideo(this);
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
		g2d.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), null);
		}

	@Override
	public void setImagePanel(BufferedImage image)
		{
		this.image = image;
		repaint();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private BufferedImage image;


	}
