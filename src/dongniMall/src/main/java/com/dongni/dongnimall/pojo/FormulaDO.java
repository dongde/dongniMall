package com.dongni.dongnimall.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormulaDO implements Serializable {

    private String id;
    private String formulaName;
    private Float formulaPrice;
    private String formulaDescription;
    private String factoryAddress;
    private String updateTime;
    private String bigPicture;
    private String baseStoreId;
    private String practical_operation_noAppointment;
    private String learn_again_noAppointment;
    private String assist_noAppointment;
    private String formulaFile;
    private List<FormulaRawMaterialDO> formulaRawMaterialDOList;
}
