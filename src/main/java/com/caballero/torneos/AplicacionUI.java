package com.caballero.torneos;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import com.caballero.torneos.vista.PaginaPrincipal;
import com.caballero.torneos.vista.equipos.PaginaEquipoABM;
import com.caballero.torneos.vista.equipos.PaginaEquipoAM;
import com.caballero.torneos.vista.jugadores.PaginaJugadorABM;
import com.caballero.torneos.vista.jugadores.PaginaJugadorAM;
import com.caballero.torneos.vista.torneos.PaginaTorneoABM;
import com.caballero.torneos.vista.torneos.PaginaTorneoAM;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class AplicacionUI extends UI {
	private static final long serialVersionUID = 1L;
	private Navigator navegador;
	private Map<String, Object> sesion;
	//aas
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {	
		sesion = new HashMap<String, Object> ();
		sesion.put("equipo", null);
		
		navegador = new Navigator(this, this);
		navegador.addView(PaginaPrincipal.NOMBRE, new PaginaPrincipal());
		navegador.addView(PaginaEquipoABM.NOMBRE, new PaginaEquipoABM());
		navegador.addView(PaginaEquipoAM.NOMBRE, new PaginaEquipoAM());
		navegador.addView(PaginaJugadorABM.NOMBRE, new PaginaJugadorABM());
		navegador.addView(PaginaJugadorAM.NOMBRE, new PaginaJugadorAM());
		navegador.addView(PaginaTorneoABM.NOMBRE, new PaginaTorneoABM());
		navegador.addView(PaginaTorneoAM.NOMBRE, new PaginaTorneoAM());
		
		irPagina(PaginaPrincipal.NOMBRE);
    }

	public void irPagina(String pagina) {
		navegador.navigateTo(pagina);
	}
	
	public static AplicacionUI getInstancia() {
		return (AplicacionUI) UI.getCurrent();
	}

	public void setSesion(String clave, Object valor){
		sesion.put(clave, valor);
	}
	
	public Object getSesion(String clave){
		return sesion.get(clave);
	}

    @WebServlet(urlPatterns = "/*", name = "AplicacionUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = AplicacionUI.class, productionMode = false)
    public static class AplicacionUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
    }

}