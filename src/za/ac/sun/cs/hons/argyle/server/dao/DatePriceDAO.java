package za.ac.sun.cs.hons.argyle.server.dao;

import java.util.Map;

import za.ac.sun.cs.hons.argyle.client.serialization.entities.product.BranchProduct;
import za.ac.sun.cs.hons.argyle.client.serialization.entities.product.DatePrice;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.ObjectifyService;

public class DatePriceDAO extends ObjectifyDAO<DatePrice> {
    static {

	ObjectifyService.register(DatePrice.class);

    }

    public Key<DatePrice> add(DatePrice entity)

    {
	Key<DatePrice> key = ofy().put(entity);
	checkDate(entity);
	return key;
    }

    public Map<Key<DatePrice>, DatePrice> add(DatePrice... entities)

    {
	Map<Key<DatePrice>, DatePrice> keys = ofy().put(entities);
	for (DatePrice entity : entities) {
	    checkDate(entity);
	}
	return keys;
    }

    private void checkDate(DatePrice dp) {
	BranchProduct bp;
	try {
	    bp = ofy().get(BranchProduct.class, dp.getBranchProductID());
	} catch (NotFoundException nfe) {
	    return;
	}
	try {
	    DatePrice found = bp.getDatePrice();
	    if (found == null || dp.getDate().before(found.getDate())) {
		bp.setDatePrice(dp);
		ofy().put(bp);
	    }
	} catch (NotFoundException nfe) {
	    bp.setDatePrice(dp);
	    ofy().put(bp);
	}
    }

    public DatePriceDAO() {
	super(DatePrice.class);
    }

}
