package com.gome.gmhx.service.common.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gome.common.util.BeanTool;
import com.gome.common.util.DateUtils;
import com.gome.common.util.SysUtils;
import com.gome.common.util.UUIDGenerator;
import com.gome.gmhx.dao.storeinfo.HxCurrentStockDao;
import com.gome.gmhx.entity.BarCode;
import com.gome.gmhx.entity.Brand;
import com.gome.gmhx.entity.HxBarCodeRules;
import com.gome.gmhx.entity.HxCodeBar;
import com.gome.gmhx.entity.HxCurrentStock;
import com.gome.gmhx.entity.HxFeeMoveMachine;
import com.gome.gmhx.entity.HxFitting;
import com.gome.gmhx.entity.HxFittingLocation;
import com.gome.gmhx.entity.HxFittingModel;
import com.gome.gmhx.entity.HxFree;
import com.gome.gmhx.entity.HxGoodbill;
import com.gome.gmhx.entity.HxMaintenance;
import com.gome.gmhx.entity.HxPostage;
import com.gome.gmhx.entity.HxProductDetail;
import com.gome.gmhx.entity.HxSetupeFree;
import com.gome.gmhx.jbpm.CurrentSysUser;
import com.gome.gmhx.service.common.ExcelImportService;
@Service("excelImportService")
public class ExcelImportServiceImpl implements ExcelImportService {
	@Resource
	SqlSessionTemplate sqlSessionTemplate;
	@Resource
	private HxCurrentStockDao hxCurrentStockDao;
	private String[] productDetailPropery = { "classifyCode", "productCode",
			"productName", "englishName", "model", "modelClassify",
			"productModel", "gomeCode", "isNew", "isPreferential",
			"installationFee", "spec", "price", "refrigeration", "comment" };
	private String[] barCodeRules = { "gomeCode", "category", "barCodeNumber",
			"insideMachine", "insideMachineContent", "insideMachineOne",
			"insideMachineContentOne", "insideMachineTwo",
			"insideMachineContentTwo", "outsideMachine",
			"outsideMachineContent", "outsideMachineOne",
			"outsideMachineContentOne", "outsideMachineTwo",
			"outsideMachineContentTwo", "note" };
	private String[] fittingPropery = { "fittingCode", "fittingName",
			"fittingType", "partsCode", "spec", "produceType", "gomeCode",
			"fittingLevel", "cost", "networkPrice", "branchPrice", "userPrice",
			"comment", "term", "isRetrieve", "isStop"};
	private String[] fittingModelPropery = { "fittingCode", "suitModel",
			"comment" };
	private String[] maintenancePropery = { "category", "parentCode",
			"faultCode", "faultName", "PNumber",
			"maintenanceCosts", "wetUnion", "note" };
	private String[] codeBarPropery = { "compareType", "innerCode1",
			"innerCode2", "outerCode", "innerModel1", "innerModel2",
			"outerModel", "wholeModel", "codeBegin", "comment"};
	private String[] freePropery = { "model", "expenseStandard", "managerFee",
			"monthlyBonus", "brand"};
	private String[] setupFreePrppery = { "model", "freeOrganization",
			"freeCost", "managerCost", "brand"};
	private String[] feeMoveMachinePropery = { "classifyCode", "wholefee",
			"innerfee", "outerfee", "operationType" };
	private String[] barCodePropery = { "barCode", "machineType" };
	private String[] brandPropery = { "gm_code", "brand", "note"};
	private String[] goodBillPrppery = { "gsxx01", "gsmc", "thdh", "khmc", "spbm",
			"xsje", "fph", "jzrq", "bmmc", "yyymc", "zpbj", "spflmc", "ppbmc",
			"shuliang" };
	private String[] currentStockProperty = { "orgId", "type", "fittingCode",
			"stock", "countWay", "isNew" };
	private String[] fittingLocationPropery = { "organizationName",
			"materialType", "fittingsCode", "location", "note" };
	private String[] postagePropery = { "posSendUnit", "posReceiptUnit",
			"posRecipient", "posAddress", "posPayUnit", "posNum", "posWay",
			"posDate", "posContent", "posUnit", "posWeight", "posMoney",
			"posHandlers", "posNote" };

	@Override
	public void importHxProductDetail(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxProductDetails= this.xSSFSheetToObjectList(st, new HxProductDetail(), productDetailPropery);
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxProductDetailDao.insertBatch", hxProductDetails);
	}
	
	@Override
	public void importBarCodeRules(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxBarCodeRules= this.xSSFSheetToObjectList(st, new HxBarCodeRules(), barCodeRules);
		for(Object o:hxBarCodeRules){
			HxBarCodeRules barCodeRule=(HxBarCodeRules) o;
			barCodeRule.setRulesId(UUIDGenerator.getUUID());
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxBarCodeRulesDao.insertBatch", hxBarCodeRules);
	}
	
	@Override
	public void importHxFitting(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxFittings = this.xSSFSheetToObjectList(st, new HxFitting(), fittingPropery);
		for(Object o:hxFittings){
			HxFitting fit=(HxFitting) o;
			// fitting_code值必须唯一，需跟库中数据效验唯一性
			fit.setUpdateTime(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxFittingDao.insertFittingDetailBatch", hxFittings);
	}
	
	@Override
	public void importHxFittingModel(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxFittingModels = this.xSSFSheetToObjectList(st, new HxFittingModel(), fittingModelPropery);
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxFittingDao.insertFittingModelBatch", hxFittingModels);
	}

	@Override
	public void importHxMaintenance(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxMaintenances = this.xSSFSheetToObjectList(st, new HxMaintenance(), maintenancePropery);
		for(Object o:hxMaintenances){
			HxMaintenance mainTenance=(HxMaintenance) o;
			mainTenance.setChose("1");
			mainTenance.setValidity("1");
			mainTenance.setWetEnable("1");
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxMaintenanceDao.insertMaintenanceBatch", hxMaintenances);
	}

	@Override
	public void importHxCodeBar(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> HxCodeBars = this.xSSFSheetToObjectList(st, new HxCodeBar(), codeBarPropery);
		for(Object o:HxCodeBars){
			HxCodeBar codeBar=(HxCodeBar) o;
			codeBar.setId(UUIDGenerator.getUUID());
			codeBar.setUpdateTime(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxCodeBarDao.insertCodeBarBatch", HxCodeBars);
	}

	@Override
	public void importHxFree(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> HxFrees = this.xSSFSheetToObjectList(st, new HxFree(), freePropery);
		for(Object o:HxFrees){
			HxFree free=(HxFree) o;
			free.setFreeId(UUIDGenerator.getUUID());
			free.setFounder(CurrentSysUser.getCurrentSysUser().getUserName());
			free.setCreateDate(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxFreeDao.insertFreeBatch", HxFrees);
	}

	@Override
	public void importHxSetupeFree(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxSetupeFrees= this.xSSFSheetToObjectList(st, new HxSetupeFree(), setupFreePrppery);
		for(Object o:hxSetupeFrees){
			HxSetupeFree setupFree=(HxSetupeFree) o;
			setupFree.setFreeCode(UUIDGenerator.getUUID());
			setupFree.setFounders(CurrentSysUser.getCurrentSysUser().getUserName());
			setupFree.setFounderDate(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxSetupeFreeDao.insertSetupeFreeBatch", hxSetupeFrees);
	}

	@Override
	public void importHxFeeMoveMachine(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxFeeMoveMachines= this.xSSFSheetToObjectList(st, new HxFeeMoveMachine(), feeMoveMachinePropery);
		for(Object o:hxFeeMoveMachines){
			HxFeeMoveMachine feeMoveMachine=(HxFeeMoveMachine) o;
			feeMoveMachine.setFeeID(UUIDGenerator.getUUID());
			feeMoveMachine.setCreateUsername(CurrentSysUser.getCurrentSysUser().getUserName());
			feeMoveMachine.setCreateDate(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxMoveChangeCheckoutDao.insertFeeMoveMachineBatch", hxFeeMoveMachines);
	}


	@Override
	public void importHxBarCode(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> barCodes= this.xSSFSheetToObjectList(st, new BarCode(), barCodePropery);
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxBarCodeDao.insertBarCodeBatch", barCodes);
	}
	

	@Override
	public void importBrand(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> brands = this.xSSFSheetToObjectList(st, new Brand(), brandPropery);
		for(Object o:brands){
			Brand brand=(Brand) o;
			brand.setCreater(CurrentSysUser.getCurrentSysUser().getUserName());
			brand.setRep_date(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.BrandDao.insertBrandBatch", brands);
	}
	
	@Override
	public void importHxGoodbill(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxGoodbills = this.xSSFSheetToObjectList(st, new HxGoodbill(), goodBillPrppery);
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxGoodbillDao.insertGoodbillBatch", hxGoodbills);
	}
	

	@Override
	public void importHxFittingLocation(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxFittingLocations = this.xSSFSheetToObjectList(st, new HxFittingLocation(), fittingLocationPropery);
		for(Object o:hxFittingLocations){
			HxFittingLocation fittingLocation=(HxFittingLocation) o;
			fittingLocation.setCreateDate(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxFittingLocationDao.insertFittingLocationBatch", hxFittingLocations);
	}
	
	@Override
	public void importHxPostage(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);		
		List<Object> hxPostages = this.xSSFSheetToObjectList(st, new HxPostage(), postagePropery);
		for(Object o: hxPostages){
			HxPostage pos=(HxPostage) o;
			pos.setPosCreateDate(DateUtils.toDate(SysUtils.getCurrentDateTime()));
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.basicdata.HxPostageDao.insertPostageBatch", hxPostages);
	}

	private List<Object> xSSFSheetToObjectList(Sheet sheet,Object src,String[] properies){
		List<Object> objList = new ArrayList<Object>();
		try{
			for(int i=1;i<=sheet.getLastRowNum();i++){
				Row row = sheet.getRow(i);
				Object cloneObj = src.getClass().newInstance();
				objList.add(cloneObj);
				for(int index=0;index<row.getLastCellNum();index++){
					Cell cell = row.getCell(index);
					String value = null;
					if(cell!=null){
						 switch (cell.getCellType()) {
			               case XSSFCell.CELL_TYPE_STRING:
			                   value = cell.getStringCellValue();
			                   break;
			               case XSSFCell.CELL_TYPE_NUMERIC:
			                      value = new DecimalFormat("0").format(cell.getNumericCellValue());
			                   break;
			               case XSSFCell.CELL_TYPE_FORMULA:
			                      value = cell.getNumericCellValue() + "";
			                   break;
			               case XSSFCell.CELL_TYPE_BLANK:
			                   break;
			               case XSSFCell.CELL_TYPE_ERROR:
			                   value = "";
			                   break;
			               case XSSFCell.CELL_TYPE_BOOLEAN:
			                   value = cell.getBooleanCellValue()+"";
			                   break;
			               default:
			                   value = null;
			               }
					}
					BeanTool.setAttributeByString(cloneObj,properies[index], value);
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return objList;
	}

	@Override
	public void importStocks(Workbook workbook) {
		Sheet st= workbook.getSheetAt(0);
		List<Object> hxCurrentStocks = this.xSSFSheetToObjectList(st, new HxCurrentStock(), currentStockProperty);
		//存在则更新，先删再加
		for (Object object : hxCurrentStocks) {
			hxCurrentStockDao.deleteStock((HxCurrentStock)object);
		}
		this.sqlSessionTemplate.insert("com.gome.gmhx.dao.storeinfo.HxCurrentStockDao.insertStocksBatch", hxCurrentStocks);
	}

}