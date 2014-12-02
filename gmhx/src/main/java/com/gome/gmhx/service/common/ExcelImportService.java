package com.gome.gmhx.service.common;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelImportService {
	
	public void importHxProductDetail(Workbook Workbook);

	public void importBarCodeRules(Workbook workbook);
	
	public void importHxFitting(Workbook workbook);

	public void importHxFittingModel(Workbook workbook);

	public void importHxMaintenance(Workbook workbook);

	public void importHxCodeBar(Workbook workbook);

	/** 导入当前库存 */
	public void importStocks(Workbook workbook);

	public void importHxFree(Workbook workbook);

	public void importHxSetupeFree(Workbook workbook);

	public void importHxFeeMoveMachine(Workbook workbook);

	public void importHxBarCode(Workbook workbook);

	public void importBrand(Workbook workbook);

	public void importHxGoodbill(Workbook workbook);

	public void importHxFittingLocation(Workbook workbook);

	public void importHxPostage(Workbook workbook);

}
