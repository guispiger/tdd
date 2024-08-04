package decorator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class CSVReaderTest {

	@TempDir
	static File tempDirPath;

	File csvFile = null;
	CSVReader csvReader = null;

	@BeforeAll
	static void shouldExistsTemporaryDirectory() {
		assertTrue(tempDirPath.isDirectory(), "Should be a directory");
	}

	@BeforeEach
	void instantiateNewCSVFile() {
		csvFile = assertDoesNotThrow(() -> new File(tempDirPath, "csvTest.csv"));
	}

	@BeforeEach
	void instantiateNewCSVReader() {
		writeFile("\n");
		csvReader = assertDoesNotThrow(() -> new CSVReader(new FileReader(csvFile)));
	}

	@AfterEach
	void closeCsvReaderAndDeleteFile() {
		assertDoesNotThrow(() -> csvReader.close());
		assertDoesNotThrow(() -> csvFile.delete());
	}

	public void writeFile(String string) {
		assertDoesNotThrow(() -> {
			FileWriter fw = new FileWriter(csvFile);
			fw.write(string);
			fw.close();
		});
	}

	@Test
	void testReadLine() {
		String data = "Ameixa|Banana|Maça|Laranja Lima|Pera|Uva";
		Separator separator = Separator.PIPE;

		writeFile(data);
		csvReader.setSeparator(separator);

		String[] actual = assertDoesNotThrow(() -> csvReader.readLine());
		String[] expected = data.split(new String("\\" + separator.asString()));
		assertArrayEquals(expected, actual);
	}

	@Test
	void testReadAllLines() {
		String data = "Ameixa|Banana|Maça|Laranja Lima|Pera|Uva\n"
				+ "Pêssego|Maracuja|Fruta do Conde|Graviola|Acerola|Limão Rosa\n";
		Separator separator = Separator.PIPE;
		
		ArrayList<String[]> expected = new ArrayList<String[]>();
		String[] lines = data.split("\n");
		for (String line : lines) {
			String[] lineSplit = line.split(new String("\\" + separator.asString()));
			expected.add(lineSplit);
		}		
		
		writeFile(data);
		csvReader.setSeparator(separator);
		
		ArrayList<String[]> actual = assertDoesNotThrow(() -> (ArrayList<String[]>) csvReader.readAllLines());
		for (int i = 0; i < expected.size();) {
			assertArrayEquals(expected.get(i), actual.get(i));
		  i++;
		}
	}

}
