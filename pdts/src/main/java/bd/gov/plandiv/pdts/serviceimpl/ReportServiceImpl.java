package bd.gov.plandiv.pdts.serviceimpl;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.service.EmployeeService;
import bd.gov.plandiv.pdts.service.ReportService;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final EmployeeService employeeService;
    @Override
    public boolean exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\DELL\\Desktop\\Report";
        List<Employee> employees = employeeService.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Planning Ministry");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
            return true;
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
            return true;
        }

        return false;
    }
}
