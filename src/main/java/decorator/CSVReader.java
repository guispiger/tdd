package decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends Reader {
	private BufferedReader bufferedReader = null;
	private Separator separator = Separator.COMMA;

	public CSVReader(Reader reader) {
		super(reader);

		if (reader instanceof Reader) {
			this.bufferedReader = (BufferedReader) reader;
		} else {
			this.bufferedReader = new BufferedReader(reader);
		}
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return bufferedReader.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		bufferedReader.close();
	}

	public List<String[]> readAllLines() throws IOException {
		List<String[]> data = new ArrayList<>();
		String[] line = null;

		while((line = this.readLine()) != null) {
			data.add(line);
		}
		
		return data;
	}

	public String[] readLine() throws IOException {
		String line = null;
	
		line = this.bufferedReader.readLine();
			
		return line.split(separator.asString());
	}

	public Separator getSeparator() {
		return separator;
	}

	public void setSeparator(Separator separator) {
		this.separator = separator;
	}

}