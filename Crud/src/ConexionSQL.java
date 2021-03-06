import 
java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.print.attribute.standard.DialogOwner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * Creacion de la clase conexion para la conexion y manejo de la base
 * 
 * @author riki_
 *
 */
public class ConexionSQL extends JDialog {
	/**
	 * Constructor con parametros
	 * @param owner dice que dialog es el padre
	 * @param modal dice si es modal o no
	 * */
	public ConexionSQL(Dialog owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creacion e instancia de Connection
	 * */
	Connection conectar = null;
	/**
	 * Variable connector
	 * */
	String connector = "jdbc:mysql://remotemysql.com:3306/";
	/**
	 * Variable  nombreBase 
	 * */
	String nombreBase = "dqFIFbruZS";
	/**
	 * Variable usuario
	 * */
	String usuario = "dqFIFbruZS";
	/**
	 * Variable contraseņa
	 * */
	String contraseņa = "ztQ3SWrU0M";
//     String connector = "jdbc:mysql://remotemysql.com:3306/";
//    String nombreBase = "BSdJ73qiSx";
//    String usuario = "BSdJ73qiSx";
//    String contraseņa = "uZurNpjYfw";
	/**
	 * Variable url
	 * */
	String url = connector + nombreBase;

	/**
	 * Metodo conexion
	 * @return devulve la conexion
	 * */
	public Connection conexion() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			conectar = DriverManager.getConnection(url, usuario, contraseņa);
			JOptionPane.showMessageDialog(this, "Conexion exitosa!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("aqui1");
			JOptionPane.showMessageDialog(this, "Error conexion " + e.getMessage());
		}
		return conectar;
	}

	/**
	 * Estemetodo devulve la conexion
	 * 
	 * @return devulve la conexion
	 */
	public Connection getConectar() {
		return conectar;
	}

	/**
	 * Este metodo define la coneccion
	 * 
	 * @param conectar se pasara la connecion
	 */
	public void setConectar(Connection conectar) {
		this.conectar = conectar;
	}

	/**
	 * Obtiene conector
	 * 
	 * @return devuelve connector
	 */
	public String getConnector() {
		return connector;
	}

	/**
	 * Define conector
	 * 
	 * @param connector define conector
	 */
	public void setConnector(String connector) {
		this.connector = connector;
	}

	/**
	 * Obtien nombre
	 * 
	 * @return devuelve nombreBase
	 */
	public String getNombreBase() {
		return nombreBase;
	}

	/**
	 * Define nombreBase
	 * 
	 * @param nombreBase define nombreBase
	 */
	public void setNombreBase(String nombreBase) {
		this.nombreBase = nombreBase;
	}

	/**
	 * Obtiene usuario
	 * 
	 * @return devuelve usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "ConexionSQL [conectar=" + conectar + ", connector=" + connector + ", nombreBase=" + nombreBase
				+ ", usuario=" + usuario + ", contraseņa=" + contraseņa + ", url=" + url + ", toString()="
				+ super.toString() + "]";
	}

	/**
	 * Define usuario
	 * 
	 * @param usuario define usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene contraseņa
	 * 
	 * @return devuelve la contraseņa
	 */
	public String getContraseņa() {
		return contraseņa;
	}

	/**
	 * Obtiene constraseņa
	 * 
	 * @param contraseņa define la contraseņa
	 */
	public void setContraseņa(String contraseņa) {
		this.contraseņa = contraseņa;
	}

	/**
	 * Obtiene url
	 * 
	 * @return devuelve la url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Define url
	 * 
	 * @param url se pasa la url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param args argumentos para el main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
