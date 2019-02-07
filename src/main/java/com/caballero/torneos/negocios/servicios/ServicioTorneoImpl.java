package com.caballero.torneos.negocios.servicios;

import com.caballero.torneos.negocios.interfaces.ServicioTorneo;
import com.caballero.torneos.persistencia.entidades.Torneo;
import com.caballero.torneos.persistencia.interfaces.TorneoDAO;

public class ServicioTorneoImpl implements ServicioTorneo {
	private TorneoDAO torneoDAO;
	
	public ServicioTorneoImpl(TorneoDAO torneoDAO) {
		this.torneoDAO = torneoDAO;
	}

	@Override
	public Torneo traerUltimo() {
		return torneoDAO.selectUltimo();
	}

}