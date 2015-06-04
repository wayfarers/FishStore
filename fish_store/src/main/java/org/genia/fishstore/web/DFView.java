package org.genia.fishstore.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.genia.fishstore.entities.FishBatch;
import org.primefaces.context.RequestContext;
 
@ManagedBean(name = "dfView")
@SessionScoped
public class DFView {
	
	@Inject
	ShoppingCartBean cart;
         
    public void addToCart(FishBatch fishbatch) {
    	cart.setFishBatchSelected(fishbatch);
        RequestContext.getCurrentInstance().openDialog("addToCart");
    }
     
//    public void onCarChosen(SelectEvent event) {
//        Car car = (Car) event.getObject();
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car.getId());
//         
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
}
