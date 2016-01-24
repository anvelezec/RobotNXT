package objetos.futbol.UI.opciones.main.administrarUsuarios;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import objetos.futbol.UI.opciones.main.AdministrarUsuarios;
import objetos.futbol.UI.opciones.main.AdministrarUsuariosFrame;

public class EliminarUsuarioPanel extends JPanel {
	private EliminarUsuario eliminarUsuario = new EliminarUsuario();
	private JCheckBox isAdmin;
	private JButton eliminar = new JButton("eliminar Usuario");
	public EliminarUsuarioPanel() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(new FlowLayout());
		isAdmin = new JCheckBox("Es administrador?");
		add(isAdmin);
		add(eliminar);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarUnUsuario();
			}
		});
	}

	public EliminarUsuarioPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public EliminarUsuarioPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public EliminarUsuarioPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void eliminarUnUsuario(){
		if(isAdmin.isSelected()){
			AdministrarUsuarios.removeUsuarioAdministrador(
					AdministrarUsuarios.getUsuarioAdministrador().get(AdministrarUsuarios.getAdministrarUsuariosFrame().getListarUsuarios().getUsuariosAdministradores().getSelectedIndex())
					);
			JOptionPane.showMessageDialog(null, "Administrador eliminado");
		}
		else{
			AdministrarUsuarios.removeUsuarioGeneral(
					AdministrarUsuarios.getUsuarioGeneral().get(AdministrarUsuarios.getAdministrarUsuariosFrame().getListarUsuarios().getUsuariosGenerales().getSelectedIndex())
					);
			JOptionPane.showMessageDialog(null, "Usuario General Eliminado");
		}
	}

}
