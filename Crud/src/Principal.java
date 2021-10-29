import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta clase se encargara de crear el programa entero
 * @author riki_
 *
 */
public class Principal extends JFrame {
	private JPanel contentPane;
	Modificar mod = new Modificar(this, true);
	ConexionSQL cc = new ConexionSQL(mod, true);
	Connection con = cc.conexion();
	Añadir add = new Añadir(this, true);
	public JTable table = new JTable();
	JButton btnNewButtonAñadir;

	/**
	 * Launch the application
	 * Lanzando la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Aplicacion de Jorge Merino");
		mostrarDatos();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 436, 345);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Conexion");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mod.setLocationRelativeTo(null);
				mod.setVisible(true);
				// que suscede AQUI
				mod.okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// mod.dispose();
						System.out.println("hola");
					}
				});

			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// VER corregir
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSelecionada = table.rowAtPoint(e.getPoint());
			}
		});

		btnNewButtonAñadir = new JButton("A\u00F1adir");
		btnNewButtonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.setLocationRelativeTo(null);
				add.setVisible(true);

			}
		});

		JButton btnNewButtonEliminar = new JButton("Eliminar");
		btnNewButtonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarSelecionado();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(207, Short.MAX_VALUE)
								.addComponent(btnNewButtonAñadir).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewButtonEliminar).addGap(23)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButtonAñadir).addComponent(btnNewButtonEliminar))
						.addContainerGap(15, Short.MAX_VALUE)));

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		mod.okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!mod.textFieldConector.getText().equals("") && !mod.textFieldUsuario.getText().equals("")
						&& !mod.textFieldContraseña.getText().equals("") && !mod.textFieldNombre.getText().equals("")) {
					if (mod.textFieldConector.getText() != "") {
						cc.setConnector(mod.textFieldConector.getText());
					}
					if (mod.textFieldUsuario.getText() != "") {
						cc.setUsuario(mod.textFieldUsuario.getText());
					}
					if (mod.textFieldContraseña.getText() != "") {
						cc.setContraseña(mod.textFieldContraseña.getText());
					}
					if (mod.textFieldNombre.getText() != "") {
						cc.setNombreBase(mod.textFieldNombre.getText());
					}
					/*
					 * if(mod.textFieldConector.getText()=="") {
					 * cc.setUrl(cc.getConnector()+mod.textFieldNombre.getText()); }
					 */
					if (mod.textFieldConector.getText() != "") {
						cc.setUrl(cc.getConnector() + mod.textFieldNombre.getText());
					}
					con = cc.conexion();

					System.out.println(cc.toString());
					mostrarDatos();
				} else {
					JOptionPane.showMessageDialog(mod, "Introduzca los datos de la conexion");
				}

			}
		});
		add.okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarDatos();
				mostrarDatos();
				limpiarAñadir();
			}
		});
	}

	/**
	 * metodo insetarDatos insetara los registros en la base
	 */
	public void insertarDatos() {
		try {
			String SQL = "insert into Personas (Nombre,Apellidos,Edad) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, add.textFieldNombre.getText());
			pst.setString(2, add.textFieldApellidos.getText());
			pst.setInt(3, Integer.parseInt(add.textFieldEdad.getText()));
			pst.execute();
			JOptionPane.showMessageDialog(add, "Registrado exitosamente");

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(add, "Error " + e.getMessage());
		}

	}

	/**
	 * metodo mostrarDatos mostrara los datos en la tabla
	 */
	public void mostrarDatos() {
		String[] titulos = { "ID", "Nombre", "Apellidos", "Edad" };
		String[] registros = new String[5];
		DefaultTableModel modelo = new DefaultTableModel(null, titulos);
		String SQL = "select * from Personas";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				registros[0] = rs.getString("ID");
				registros[1] = rs.getString("Nombre");
				registros[2] = rs.getString("Apellidos");
				registros[3] = rs.getString("Edad");
				modelo.addRow(registros);
			}
			table.setModel(modelo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}

	/**
	 * 
	 */
	public void limpiarAñadir() {
		add.textFieldNombre.setText("");
		add.textFieldApellidos.setText("");
		add.textFieldEdad.setText("");

	}

	/**
	 * metodo eleminarSelecionado eliminara el elemento seleccionado
	 */
	public void eliminarSelecionado() {
		int filaSelecionada = table.getSelectedRow();
		try {
			String SQL = "delete from Personas where id=" + table.getValueAt(filaSelecionada, 0);
			Statement st = con.createStatement();
			int n = st.executeUpdate(SQL);
			if (n >= 0) {
				JOptionPane.showMessageDialog(null, "Se ha eliminado la persona");
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error al eliminar : " + e.getMessage());
		}
		mostrarDatos();
	}

}
