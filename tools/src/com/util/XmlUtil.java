package com.util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
public class XmlUtil {
	
	public static String resouceBasePath = "";
	
	private Map<String,Map<String,String>> templateCache = new HashMap<String,Map<String,String>>();
	
	private static XmlUtil xmlUtil = new XmlUtil();
	
	private VelocityEngine veEngine = new VelocityEngine();
	
	private void init(){
		Properties p = new Properties();
		p.put("input.encoding", "UTF-8");
		p.put("output.encoding", "UTF-8");
		p.put("resource.loader", "srl");
		p.put("srl.resource.loader.class", TemplateLoader.class.getName());
		try {
			veEngine.init(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private XmlUtil(){
		this.init();
	};
	
	public static XmlUtil getInstance(){
		return xmlUtil;
	}
	     	
	public String genXmlByTemplate(String templateNamePath,Map<String,String> context) throws ResourceNotFoundException, ParseErrorException, Exception{
		Template template = veEngine.getTemplate(templateNamePath);
		VelocityContext velocityContext = new VelocityContext();
		Iterator<String> it =  context.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			velocityContext.put(key, context.get(key));
		}
		StringWriter sw = new StringWriter();
		template.merge(velocityContext, sw);
		return sw.toString();
	}
	
	public Map<String, List<Map<String, String>>> xmlToMap(String templateName,String xmlFile) {
		Document doc = this.getDocument(new ByteArrayInputStream(xmlFile.getBytes()));
		return this.xmlToMap(templateName, doc);
		
	}

	public Map<String, List<Map<String, String>>> xmlToMap(String templateName,Document doc) {
		List<Map<String, String>> parseData = this.parseXML(doc);
		Map<String, String> templateMap = this.loadAndParseTemplate(templateName);
		List<Map<String, List<Map<String, String>>>> conversionMap = this.conversionProcess(parseData, templateMap);
		return conversionMap.get(0);
	}
	
	private Map<String, String> loadAndParseTemplate(String templateName){
		Map<String, String> templateMap = this.templateCache.get(templateName);
		if(templateMap==null){
			InputStream fileStream = this.loadTemplate(templateName);
			templateMap = this.parseTemplate(fileStream);
			this.templateCache.put(templateName, templateMap);
		}
		return templateMap;
	}
	
	private InputStream loadTemplate(String templateName) {
		return this.getClass().getResourceAsStream(XmlUtil.resouceBasePath+templateName);
	}
	
	private Map<String, String> parseTemplate(InputStream fileStream) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Document doc = this.getDocument(fileStream);
		Element root = doc.getRootElement();
		this.parseTemplateElement(root, null, list);
		return list.get(0);
	}
	
	private List<Map<String, List<Map<String, String>>>> conversionProcess(
			List<Map<String, String>> data, Map<String, String> template) {
		List<Map<String, List<Map<String, String>>>> retList = new ArrayList<Map<String, List<Map<String, String>>>>();
		for (int i = 0; data != null && i < data.size(); i++) {
			Map<String, List<Map<String, String>>> map = new HashMap<String, List<Map<String, String>>>();

			Map<String, String> rowData = data.get(i);
			for (Map.Entry<String, String> entry : template.entrySet()) {
				List<Map<String, String>> list;
				String value = entry.getValue(); 
				String[] props = value.split("\\.");
				if (props.length == 2) {
					if (map.containsKey(props[0])) {
						list = map.get(props[0]);
					} else {
						list = new ArrayList<Map<String, String>>();
					}

					if (rowData.containsKey(entry.getKey())) {
						String valueStr = rowData.get(entry.getKey());
						String[] valueArray = valueStr.split("~~~");
						for (int j = 0; valueArray != null
								&& j < valueArray.length; j++) {
							Map<String, String> objMap;
							if (j < list.size()) {
								objMap = list.get(j);
							} else {
								objMap = new HashMap<String, String>();
								list.add(objMap);
							}
							objMap.put(props[1], valueArray[j]);
						}
					}
					map.put(props[0], list);
				}
			}
			retList.add(map);
		}
		return retList;
	}

	private List<Map<String, String>> parseXML(Document doc) {
		List<Map<String, String>> retList = new ArrayList<Map<String, String>>();

		try {
			Element root = doc.getRootElement();
			this.parseElement(root, null, retList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retList;
	}
	
	private void parseElement(Element element, String parentElementName,List<Map<String, String>> mapList) {
		this.parseElement(element, parentElementName, mapList,0);
	}


	private void parseTemplateElement(Element element,String parentElementName, List<Map<String, String>> mapList) {
		this.parseTemplateElement(element, parentElementName, mapList,0);
	}

	private void parseTemplateElement(Element element,String parentElementName, List<Map<String, String>> mapList,int curListIndex) {
		int curIndex = curListIndex;
		Map<String, String> map = new HashMap<String, String>();

		if (!element.getAttributes().isEmpty()) {
			if (mapList == null || mapList.isEmpty()) {
				map = new HashMap<String, String>();
				mapList.add(map);
			} else {
				map = mapList.get(curIndex);
			}
			this.parseTemplateAttribute(element, parentElementName, map);
		}

		List list = element.getChildren();
		if (list != null && !list.isEmpty()) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				String paramName = element.getName();
				if (parentElementName != null && !"".equals(parentElementName)) {
					paramName = parentElementName + "~~~" + element.getName();
				}
				parseTemplateElement(ele, paramName, mapList,curIndex);
			}
		} else {
			String key = "";
			if (parentElementName == null || "".equals(parentElementName))
				key = element.getName();
			else
				key = parentElementName + "~~~" + element.getName();

			String value = element.getValue();
			if (value.indexOf("$") >= 0) {
				value = value.substring(value.indexOf("$") + 1);
			} else {
				return;
			}

			if (mapList == null || mapList.isEmpty()) {
				map = new HashMap<String, String>();
				mapList.add(map);
			} else {
				map = mapList.get(curIndex);
			}

			String newValue;
			if (map.containsKey(key)) {
				newValue = map.get(key) + "~~~" + value;
			} else {
				newValue = value;
			}
			map.put(key, newValue);
		}


	}

	private void parseElement(Element element, String parentElementName,
			List<Map<String, String>> mapList,int curListIndex) {
		int curIndex = curListIndex;
		Map<String, String> map = new HashMap<String, String>();

		if (!element.getAttributes().isEmpty()) {
			if (mapList == null || mapList.isEmpty()) {
				map = new HashMap<String, String>();
				mapList.add(map);
			} else {
				map = mapList.get(curIndex);
			}
			this.parseAttribute(element, parentElementName, map);
		}

		List list = element.getChildren();
		if (list != null && !list.isEmpty()) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				String paramName = element.getName();
				if (parentElementName != null && !"".equals(parentElementName)) {
					paramName = parentElementName + "~~~" + element.getName();
				}
				parseElement(ele, paramName, mapList,curIndex);
			}
		} else {
			String key = "";
			if (parentElementName == null || "".equals(parentElementName))
				key = element.getName();
			else
				key = parentElementName + "~~~" + element.getName();

			if (mapList == null || mapList.isEmpty()) {
				map = new HashMap<String, String>();
				mapList.add(map);
			} else {
				map = mapList.get(curIndex);
			}

			String value = element.getValue();
			String newValue;
			if (map.containsKey(key)) {
				newValue = map.get(key) + "~~~" + value;
			} else {
				newValue = value;
			}
			map.put(key, newValue);
		}
	}

	private void parseTemplateAttribute(Element element,
			String parentElementName, Map<String, String> map) {
		List list = element.getAttributes();
		if (list != null && !list.isEmpty()) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attr = (Attribute) iter.next();
				String key = "";
				if (parentElementName == null || "".equals(parentElementName))
					key = attr.getName();
				else
					key = parentElementName + "~~~" + element.getName() + "~~~"+ attr.getName();
				String value = attr.getValue();
				if (value.indexOf("$") >= 0) {
					value = value.substring(value.indexOf("$") + 1);
				} else {
					continue;
				}
				String newValue;
				if (map.containsKey(key)) {
					newValue = map.get(key) + "~~~" + value;
				} else {
					newValue = value;
				}
				map.put(key, newValue);
			}
		}
	}

	private void parseAttribute(Element element, String parentElementName,
			Map<String, String> map) {
		List list = element.getAttributes();
		if (list != null && !list.isEmpty()) {
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attr = (Attribute) iter.next();
				String key = "";
				if (parentElementName == null || "".equals(parentElementName))
					key = attr.getName();
				else
					key = parentElementName + "~~~" + element.getName() + "~~~"
							+ attr.getName();
				String value = attr.getValue();
				String newValue;
				if (map.containsKey(key)) {
					newValue = map.get(key) + "~~~" + value;
				} else {
					newValue = value;
				}
				map.put(key, newValue);
			}
		}
	}

	public Document getDocument(InputStream in){
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			doc = builder.build(in);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public Document getDocument(String xmlFile){
		return this.getDocument(new ByteArrayInputStream(xmlFile.getBytes()));
	}
	
	public List<Document> divisionDomByxPath(String xPath,Document srcDom){
		List<Document> targetDoms = new ArrayList<Document>();
		try{
			Element root = srcDom.getRootElement();
			XPath xpath = XPath.newInstance(xPath);
			List<Element> list = xpath.selectNodes(root);
			for(Element e:list){
				Document targetDom = new Document();
				Element eClone = (Element)e.clone();
				this.setDeclaredFieldValue(eClone, "parent", null);//清除父节点
				targetDom.setRootElement(eClone);
				targetDoms.add(targetDom);
			}
		}catch (Exception e) {
			 e.printStackTrace();
		}
		return targetDoms;
	}
	
    private void setDeclaredFieldValue(Object object, String filedName,Object value) {
    	Field field = null;
        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass()) {
            try {
            	field = superClass.getDeclaredField(filedName);
            	if(field != null){
            		break;
            	}
            } catch (NoSuchFieldException e) {
            }
        }
        if(field!=null){
        	try {
        		field.setAccessible(true);
				field.set(object, value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
        }
    }

}
