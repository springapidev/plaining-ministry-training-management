package bd.gov.plandiv.pdts.utils;

import java.io.IOException;
import org.junit.jupiter.api.*;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtilSymflowerTest {
	@Test
	public void saveFile1() throws IOException {
		String uploadDir = null; // TODO This is a fallback value due to incomplete analysis.
		String fileName = null; // TODO This is a fallback value due to incomplete analysis.
		MultipartFile multipartFile = null; // TODO This is a fallback value due to incomplete analysis.
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	}
}
