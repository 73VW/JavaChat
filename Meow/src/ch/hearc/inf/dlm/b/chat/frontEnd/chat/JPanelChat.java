
package ch.hearc.inf.dlm.b.chat.frontEnd.chat;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JPanelChat extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChat()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	/**
	 *
	 * @param msg
	 * @param provenance true for local false for ext
	 */
	public void addLine(String msg, Boolean provenance)
		{
		SimpleAttributeSet side;
		styledDocument = jTextPaneDisplay.getStyledDocument();
		if (provenance)
			{
			side = right;
			}

		else
			{
			side = left;
			}
		try
			{
			String formattedMsg = "\n" + msg;
			styledDocument.insertString(styledDocument.getLength(), formattedMsg, null);
			styledDocument.setParagraphAttributes(styledDocument.getLength()+1, 1, side, false);
			}
		catch (Exception e)
			{
			System.out.println("An exception occured while adding line : " + e);
			}

		jScrollBar = jScrollPane.getVerticalScrollBar();
		jScrollBar.setValue(jScrollBar.getMaximum());
		}

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
		jTextPaneDisplay = new JTextPane();
		jScrollPane = new JScrollPane(jTextPaneDisplay);
		jPanelChatBottom = new JPanelChatBottom(this);
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jScrollPane, BorderLayout.CENTER);
		add(jPanelChatBottom, BorderLayout.SOUTH);
		}

	private void control()
		{
		jTextPaneDisplay.setEditable(false);
		jTextPaneDisplay.setContentType("text/html");
		}

	private void appearance()
		{
		left = new SimpleAttributeSet();
		StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
		StyleConstants.setForeground(left, Color.WHITE);

		right = new SimpleAttributeSet();
		StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
		StyleConstants.setForeground(right, Color.WHITE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTextPane jTextPaneDisplay;
	private JScrollPane jScrollPane;
	private JPanelChatBottom jPanelChatBottom;

	private JScrollBar jScrollBar;
	private StyledDocument styledDocument;
	private SimpleAttributeSet left;
	private SimpleAttributeSet right;
	}
