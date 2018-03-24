
package com.getwell.services.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="medicine")
@XmlType(propOrder={"medicineId", "medicineName","medicineManufacturer","medicinePrice"})
public class Medicine {
    private String medicineId;
    private String medicineName;
    private String medicineManufacturer;
    private double medicinePrice;

    public Medicine() {
    }

    public Medicine(String medicineId, String medicineName, String medicineManufacturer, double medicinePrice) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineManufacturer = medicineManufacturer;
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
       
}
