
package com.getwell.services.dao;

import com.getwell.services.model.Medicine;
import java.util.HashMap;
import java.util.Map;

public enum MedicineDao {
    instance;
    private Map<String,Medicine> medicineMapProvider=new HashMap();
    private MedicineDao()
    {
        Medicine medicine=new Medicine("M1001","Creaon 10000","Abbot",305.2);
        medicineMapProvider.put("M1001",medicine);     
        medicine=new Medicine("M1002","Creaon 25000","Abbot",800);
        medicineMapProvider.put("M1002",medicine);
    }
    public Map<String,Medicine> getModel()
    {
        return medicineMapProvider;
    }
}
