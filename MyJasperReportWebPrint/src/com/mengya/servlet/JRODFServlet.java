package com.mengya.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.util.FileBufferedOutputStream;
import net.sf.jasperreports.engine.util.JRLoader;

import com.mengya.JRDataSource.PersonDataSource;

public class JRODFServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = this.getServletConfig().getServletContext();
		File jasperFile = new File(context.getRealPath("/jasper/preson.jasper"));
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "武汉XX科技有限公司");
		JasperPrint jasperPrint = null;
		try {
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(jasperFile);
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					new PersonDataSource());
		} catch (JRException e) {
			e.printStackTrace();
		}
		if(null != jasperPrint){
			FileBufferedOutputStream fbos = new FileBufferedOutputStream();
			JROdsExporter exporter = new JROdsExporter();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fbos);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			try {
				exporter.exportReport();
				fbos.close();
				if (fbos.size() > 0) {
					response.setContentType("application/vnd.oasis.opendocument.text");
					response.setHeader("Content-Disposition", "inline; filename=\"persons.odf\"");
					response.setContentLength(fbos.size());
					ServletOutputStream ouputStream = response.getOutputStream();
					try {
						fbos.writeData(ouputStream);
						fbos.dispose();
						ouputStream.flush();
					} finally {
						if (null != ouputStream) {
							ouputStream.close();
						}
					}
				}
			} catch (JRException e1) {
				e1.printStackTrace();
			}finally{
				if(null !=fbos){
					fbos.close();
					fbos.dispose();
				}
			}
		}
	}

}
