package bd.gov.plandiv.pdts.utils;

//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.coderbd.dto.ExcelSheetTitleDto;
//import com.coderbd.dto.QuestionDetailsDto;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;
//
//
//public class ExcelHelper {
//    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    static String[] HEADERs = {"Question number","Topic", "Question text", "Option A", "Option B", "Option C", "Option D", "Answer A", "Answer B", "Answer C", "Answer D", "Rationale", "Syllabus reference"};
//    static String SHEET = "A set of questions";
//
//    public static boolean hasExcelFormat(MultipartFile file) {
//
//        if (!TYPE.equals(file.getContentType())) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public static List<QuestionDetailsDto> excelToQuestionDetailsDto(InputStream is) throws IOException {
//        List<QuestionDetailsDto> questionDetailsDtos = new ArrayList<QuestionDetailsDto>();
//        XSSFWorkbook workbook = new XSSFWorkbook(is);
//        XSSFSheet worksheet = workbook.getSheetAt(0);
//
//        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
//            QuestionDetailsDto questionDetailsDto = new QuestionDetailsDto();
//
//            XSSFRow row = worksheet.getRow(i);
//            Cell cell = row.getCell(i, XSSFRow.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//            questionDetailsDto.setQuestionNumber((long) row.getCell(0).getNumericCellValue());
//            questionDetailsDto.setTopic(row.getCell(1).getStringCellValue());
//            questionDetailsDto.setQuestionText(row.getCell(2).getStringCellValue());
//            questionDetailsDto.setOptionA(row.getCell(3).getStringCellValue());
//            questionDetailsDto.setOptionB(row.getCell(4).getStringCellValue());
//            questionDetailsDto.setOptionC(row.getCell(5).getStringCellValue());
//            questionDetailsDto.setOptionD(row.getCell(6).getStringCellValue());
//            questionDetailsDto.setAnswerA(String.valueOf(row.getCell(7).getNumericCellValue()));
//            questionDetailsDto.setAnswerB(String.valueOf(row.getCell(8).getNumericCellValue()));
//            questionDetailsDto.setAnswerC(String.valueOf(row.getCell(9).getNumericCellValue()));
//            questionDetailsDto.setAnswerD(String.valueOf(row.getCell(10).getNumericCellValue()));
//            questionDetailsDto.setRationale(row.getCell(11).getStringCellValue());
//            //   tempStudent.setSyllabusReference((row.getCell(11).getStringCellValue().isBlank() || row.getCell(11).getStringCellValue().isEmpty()) ? "" : row.getCell(11).getStringCellValue());
//            questionDetailsDtos.add(questionDetailsDto);
//        }
//
//        return questionDetailsDtos;
//    }
//
//    public static ExcelSheetTitleDto getExcelSheetTitles(InputStream is) throws IOException {
//
//        XSSFWorkbook workbook = new XSSFWorkbook(is);
//        XSSFSheet worksheet = workbook.getSheetAt(0);
//        ExcelSheetTitleDto dto = new ExcelSheetTitleDto();
//        XSSFRow row = worksheet.getRow(0);
//        dto.setQuestionNumber(row.getCell(0).getStringCellValue());
//        dto.setTopic(row.getCell(1).getStringCellValue());
//        dto.setQuestionText(row.getCell(2).getStringCellValue());
//        dto.setOptionA(row.getCell(3).getStringCellValue());
//        dto.setOptionB(row.getCell(4).getStringCellValue());
//        dto.setOptionC(row.getCell(5).getStringCellValue());
//        dto.setOptionD(row.getCell(6).getStringCellValue());
//        dto.setAnswerA(String.valueOf(row.getCell(7).getNumericCellValue()));
//        dto.setAnswerB(String.valueOf(row.getCell(8).getNumericCellValue()));
//        dto.setAnswerC(String.valueOf(row.getCell(9).getNumericCellValue()));
//        dto.setAnswerD(String.valueOf(row.getCell(10).getNumericCellValue()));
//        dto.setRationale(row.getCell(11).getStringCellValue());
//        dto.setSyllabusReference(row.getCell(12).getStringCellValue());
//        return dto;
//    }
//}