import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

/**
 * Esta clase creara un Jdialog para la modificacion de la conexion de la base
 * @author riki_
 *
 */
public class Modificar extends JDialog {

	/**
	 * Creacion de Jpanel contentPanel
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Creacion de JTextField textFieldNombre
	 */
	
	public JTextField textFieldNombre = new JTextField();
	/**
	 * Creacion de Botton okButton
	 * */
	JButton okButton = new JButton("OK");
	/**
	 * Creacion de JTextField textFieldUsuario
	 * */
	public JTextField textFieldUsuario;
	/**
	 * Creacion de JTextField textFieldContraseña
	 * */
	public JTextField textFieldContraseña;
	/**
	 * Creacion de JTextField textFieldConector
	 * */
	public JTextField textFieldConector;
	/**
	 * Creacion Jpanel buttonPane
	 * */
	JPanel buttonPane;
	/**
	 * Create the dialog.
	 */
	/**Constructor con parametros
	 * @param owner cual es el padre
	 * @param modal si es o no modal
	 */
	public Modificar(Frame owner, boolean modal)
	{
		super(owner, modal);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		setTitle("Modificaci\u00F3n de la base de datos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setBounds(10, 18, 91, 20);
		contentPanel.add(lblNewLabelNombre);

		textFieldNombre.setText("");
		textFieldNombre.setBounds(162, 18, 203, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		{
			JLabel lblNewLabelUsuario = new JLabel("Usuario");
			lblNewLabelUsuario.setBounds(10, 49, 91, 20);
			contentPanel.add(lblNewLabelUsuario);
		}
		{
			JLabel lblNewLabelContraseña = new JLabel("Contrase\u00F1a");
			lblNewLabelContraseña.setBounds(10, 80, 91, 20);
			contentPanel.add(lblNewLabelContraseña);
		}
		{
			JLabel lblNewLabelConnector = new JLabel("Conector");
			lblNewLabelConnector.setBounds(10, 111, 91, 20);
			contentPanel.add(lblNewLabelConnector);
		}
		{
			textFieldUsuario = new JTextField();
			textFieldUsuario.setBounds(162, 49, 203, 20);
			contentPanel.add(textFieldUsuario);
			textFieldUsuario.setColumns(10);
		}
		{
			textFieldContraseña = new JTextField();
			textFieldContraseña.setBounds(162, 80, 203, 20);
			contentPanel.add(textFieldContraseña);
			textFieldContraseña.setColumns(10);
		}
		{
			textFieldConector = new JTextField();
			textFieldConector.setBounds(162, 111, 203, 20);
			contentPanel.add(textFieldConector);
			textFieldConector.setColumns(10);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
							
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
