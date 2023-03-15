package bd.gov.plandiv.pdts.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportService {
    boolean exportReport(String reportFormat) throws FileNotFoundException, JRException;
}
