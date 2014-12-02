<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
    import="java.io.*,
            net.sf.jasperreports.engine.*,
            net.sf.jasperreports.engine.util.*,
            java.util.*,java.sql.*,
            net.sf.jasperreports.engine.export.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    File reportFile = new File(application
            .getRealPath("jasper/groupReport.jasper"));
    JasperReport jasperReport = (JasperReport) JRLoader
            .loadObject(reportFile.getPath());
    Map parameters = new HashMap();
    parameters.put("para1", "AAA");
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ireport", "root", "root");
    JasperPrint jasperPrint = JasperFillManager.fillReport(
            jasperReport, parameters, conn);
    JRHtmlExporter exporter = new JRHtmlExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
    
    exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
    exporter.exportReport();
    out.flush();    
    conn.close();
%>
</body>
</html>