import java.awt.Dialog;
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
 * @author riki_
 *
 */
public class ConexionSQL extends JDialog{
	public ConexionSQL(Dialog owner, boolean modal) {
		super(owner, modal);
		// TODO Auto-generated constructor stub
	}

	Connection conectar = null;
	/* String connector = "jdbc:mysql://remotemysql.com:3306/";
    String nombreBase = "dqFIFbruZS";
    String usuario = "dqFIFbruZS";
    String contrase�a = "ztQ3SWrU0M";*/
     String connector = "jdbc:mysql://remotemysql.com:3306/";
    String nombreBase = "BSdJ73qiSx";
    String usuario = "BSdJ73qiSx";
    String contrase�a = "uZurNpjYfw";
    String url = connector + nombreBase;
	public Connection conexion() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			conectar= DriverManager.getConnection(url, usuario, contrase�a);
			JOptionPane.showMessageDialog(this, "Conexion exitosa!");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"Error conexion "+ e.getMessage());
		}
		return conectar;
	}

	/**
	 * Estemetodo devulve la conexion
	 * @return devulve la conexion
	 */
	public Connection getConectar() {
		return conectar;
	}

	/**
	 * Este metodo define la coneccion
	 * @param conectar se pasara la connecion
	 */
	public void setConectar(Connection conectar) {
		this.conectar = conectar;
	}

	/**
	 * Obtiene conector
	 * @return devuelve connector
	 */
	public String getConnector() {
		return connector;
	}

	/**
	 * Define conector
	 * @param connector  define conector
	 */
	public void setConnector(String connector) {
		this.connector = connector;
	}

	/**
	 * Obtien nombre
	 * @return devuelve nombreBase
	 */
	public String getNombreBase() {
		return nombreBase;
	}

	/**
	 * Define nombreBase
	 * @param nombreBase define nombreBase
	 */
	public void setNombreBase(String nombreBase) {
		this.nombreBase = nombreBase;
	}

	/**
	 * Obtiene usuario
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
				+ ", usuario=" + usuario + ", contrase�a=" + contrase�a + ", url=" + url + ", toString()="
				+ super.toString() + "]";
	}

	/**Define usuario
	 * @param usuario define usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene contrase�a
	 * @return devuelve la contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}

	/**
	 * Obtiene constrase�a
	 * @param contrase�a define la contrase�a
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	/**
	 * Obtiene url
	 * @return devuelve la url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 *Define url
	 * @param url se pasa la url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}



}
