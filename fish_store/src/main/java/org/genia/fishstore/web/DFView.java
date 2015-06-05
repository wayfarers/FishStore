package org.genia.fishstore.web;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.genia.fishstore.entities.FishBatch;
import org.primefaces.context.RequestContext;
 
@Named(value = "dfView")
@ViewScoped
public class DFView implements Serializable {
	
//	@Inject
//	ShoppingCartBean cart;
         
    public void addToCart(FishBatch fishbatch) {
//    	cart.setFishBatchSelected(fishbatch);
        RequestContext.getCurrentInstance().openDialog("addToCart");
    }
     
//    public void onCarChosen(SelectEvent event) {
//        Car car = (Car) event.getObject();
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car.getId());
//         
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
}
