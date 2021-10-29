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

/**
 * Crea Jdialog para a;adir persona
 * @author riki_
 *
 */
public class Añadir extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textFieldNombre;
	public JTextField textFieldApellidos;
	public JTextField textFieldEdad;
	JButton okButton  = new JButton("OK");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Añadir dialog = new Añadir(null,false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Añadir(Frame owner, boolean modal) {
		super(owner, modal);
		setTitle("A\u00F1adir Persona");
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabelNombre = new JLabel("Nombre");
			lblNewLabelNombre.setBounds(10, 11, 109, 20);
			contentPanel.add(lblNewLabelNombre);
		}
		{
			JLabel lblNewLabelApellidos = new JLabel("Apellidos");
			lblNewLabelApellidos.setBounds(10, 46, 109, 20);
			contentPanel.add(lblNewLabelApellidos);
		}
		{
			JLabel lblNewLabelEdad = new JLabel("Edad");
			lblNewLabelEdad.setBounds(10, 84, 109, 20);
			contentPanel.add(lblNewLabelEdad);
		}
		{
			textFieldNombre = new JTextField();
			textFieldNombre.setBounds(129, 8, 180, 20);
			contentPanel.add(textFieldNombre);
			textFieldNombre.setColumns(10);
		}
		{
			textFieldApellidos = new JTextField();
			textFieldApellidos.setBounds(129, 43, 180, 20);
			contentPanel.add(textFieldApellidos);
			textFieldApellidos.setColumns(10);
		}
		{
			textFieldEdad = new JTextField();
			textFieldEdad.setBounds(129, 81, 180, 20);
			contentPanel.add(textFieldEdad);
			textFieldEdad.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
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
