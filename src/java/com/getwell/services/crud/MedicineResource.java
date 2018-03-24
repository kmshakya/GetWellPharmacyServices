package com.getwell.services.crud;

import com.getwell.services.dao.MedicineDao;
import com.getwell.services.model.Medicine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("medicines")
public class MedicineResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;    
  
    @GET
    @Produces({MediaType.TEXT_XML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Medicine> getMedicineDetails() {
        List<Medicine> medicines=new ArrayList();
        medicines.addAll(MedicineDao.instance.getModel().values());
        return medicines;    
    }
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addNewMedicine(@FormParam("medicineId") String medicineId, 
        @FormParam("medicineName") String medicineName, 
        @FormParam("medicineManufacturer") String medicineManufacturer,
        @FormParam("medicinePrice") double medicinePrice) 
            throws IOException {
        Medicine medicineDetail=new Medicine(medicineId,medicineName,medicineManufacturer,medicinePrice);
        MedicineDao.instance.getModel().put(medicineId,medicineDetail);
        return "<html><body>Medicine Added Successfully</body></html>";
    }
    
    @Path("{additionalpath}")
    public AdditionalMedicineServices getMedicine(@PathParam("additionalpath")
            String additionalpath) {            
        return new AdditionalMedicineServices(uriInfo,request,additionalpath);
    
    }
}
