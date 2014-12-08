package com.mybatis;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Generator().generate();
	}
	
	public void generate(){
		try{
			System.out.println("===================开始生成！======================");
			List<String> warnings = new ArrayList<String>();  
	        String confFilePath = this.getClass().getResource("generatorConfig.xml").getFile();  
	        File configFile = new File(confFilePath);  
	        Configuration config = new ConfigurationParser(warnings).parseConfiguration(configFile);  
	        DefaultShellCallback callback = new DefaultShellCallback(true);  
	        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
	        myBatisGenerator.generate(null);  
	    	System.out.println("===================生成成功！======================");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
