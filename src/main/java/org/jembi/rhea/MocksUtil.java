package org.jembi.rhea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jembi.rhea.mocks.FacilityRegistryMockService;

public class MocksUtil {
	
	public static String getFileAsString(String relPath) throws IOException {
		InputStream in = FacilityRegistryMockService.class.getResourceAsStream(relPath);
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		return sb.toString();
	}
	
}
