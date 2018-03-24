
package com.getwell.services.crud;

import com.getwell.services.dao.MedicineDao;
import com.getwell.services.model.Medicine;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

public class AdditionalMedicineServices {
     @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String additionalpath;

    public AdditionalMedicineServices() {
    }

    public AdditionalMedicineServices(UriInfo uriInfo, Request request, String additionalpath) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.additionalpath = additionalpath;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
    public Medicine getMedicineDetails() {
        Medicine medicine=MedicineDao.instance.getModel()
                .get(additionalpath);
        if (medicine==null)
         throw new RuntimeException("GET:Medicine with the term "
                 +additionalpath+" Id not Found");
        return medicine;         
        }
//     @GET
//     @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
//     public Medicine getMedicineDetailsByManufacturer() {
//        Medicine medicine=MedicineDao.instance.getModel()
//                .get(additionalpath);
//        if (medicine==null)
//         throw new RuntimeException("GET:Medicine with the term "
//                 +additionalpath+" Id not Found");
//        return medicine;         
//        }
//    
     @DELETE
     public void deleteMedicine() {
        Medicine medicine=MedicineDao.instance.getModel()
                .remove(additionalpath);
        if(medicine==null)
            throw new RuntimeException("DELETE:Medicine"
                    + " with "+additionalpath+" Id not found");
        }
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putMedicine(JAXBElement<Medicine> 
                medicine){
        Medicine d=medicine.getValue();
        return putAndGetResponse(d);
    }

    private Response putAndGetResponse(Medicine medicine)
    {
        Response res;
        if(MedicineDao.instance.getModel().
                containsKey(medicine.getMedicineId())) {
            res=Response.noContent().build();
        }
        else {
            res=Response.created(uriInfo.getAbsolutePath())
                    .build();
        }
        MedicineDao.instance.getModel().put(medicine
                .getMedicineId(),medicine);
        return res;
    }
}
