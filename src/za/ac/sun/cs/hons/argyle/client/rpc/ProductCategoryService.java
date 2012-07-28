package za.ac.sun.cs.hons.argyle.client.rpc;

import java.util.HashMap;

import za.ac.sun.cs.hons.argyle.client.serialization.entities.product.ProductCategory;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("productCategory")
public interface ProductCategoryService extends RemoteService {


	void addProductCategory(ProductCategory type);

	HashMap<String, ProductCategory> getProductCategories();

}
