package za.ac.sun.cs.hons.minke.server.dao;

import java.util.List;

import za.ac.sun.cs.hons.minke.client.serialization.entities.location.CityLocation;
import za.ac.sun.cs.hons.minke.client.serialization.entities.store.Branch;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class CityLocationDAO extends ObjectifyDAO<CityLocation> {
	static {

		ObjectifyService.register(CityLocation.class);

	}

	public CityLocationDAO() {
		super(CityLocation.class);
	}

	@Override
	public void delete(CityLocation cl) {
		List<Branch> branches = DAOService.branchDAO.listByProperties(
				new String[] { "locationID" }, new Object[] { cl.getID() });
		if (branches != null) {
			for (Branch b : branches) {
				DAOService.branchDAO.delete(b);
			}
		}
		super.delete(cl);
	}

	@Override
	public Key<CityLocation> add(CityLocation cl) {
		if (cl != null && get(cl.getID()) != null) {
			List<Branch> branches = DAOService.branchDAO.listByProperties(
					new String[] { "locationID" }, new Object[] { cl.getID() });
			if (branches != null) {
				for (Branch b : branches) {
					b.setLocation(cl);
					DAOService.branchDAO.add(b);
				}
			}
		}
		return super.add(cl);
	}

}
