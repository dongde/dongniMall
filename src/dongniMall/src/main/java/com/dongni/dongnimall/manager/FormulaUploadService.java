package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.FormulaUploadDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
public interface FormulaUploadService {
    /**
     * 添加配方上传的信息
     * @param formulaUploadDO
     */
    void addFormulaUpload(FormulaUploadDO formulaUploadDO);

    /**
     * 查询配方上传信息
     * @param page
     * @param pageSize
     * @param user_phone
     * @param formula_upload_name
     * @return
     */
    PageData queryFormulaUploadList(Integer page,Integer pageSize,String user_phone,String formula_upload_name);

    /**
     * 修改配方上传信息状态
     * @param formulaUploadDO
     */
    void modifyFormulaUpload(FormulaUploadDO formulaUploadDO);

    /**
     * 删除用户上传配方记录
     * @param formula_upload_id
     */
    void removeFormulaUpload(String formula_upload_id);
}
