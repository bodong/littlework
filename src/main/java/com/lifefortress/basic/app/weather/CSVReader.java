package com.lifefortress.basic.app.weather;

import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	private static final char DEF_SEPARATOR = ',';
	private static final char QUOTE = '"';

	private CSVReader() {
		//prevent the instance creation
	}

	public static List<String> parseLine(String cvsLine) {
		return parseLine(cvsLine, DEF_SEPARATOR, QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separator) {
		return parseLine(cvsLine, separator, QUOTE);
	}

	public static List<String> parseLine(String cvsLine, char separator, char quote) {
		List<String> result = new ArrayList<>();

		if (cvsLine == null || cvsLine.isEmpty()) {
			return result;
		}

		if (quote == ' ') {
			quote = QUOTE;
		}

		if (separator == ' ') {
			separator = DEF_SEPARATOR;
		}

		StringBuffer data = new StringBuffer();

		boolean inQuote = false;
		boolean startCollectChar = false;
		boolean containDoubleQuote = false;

		char[] chars = cvsLine.toCharArray();
		for (char ch : chars) {
			if (inQuote) {
				startCollectChar = true;
				if (ch == quote) {
					inQuote = false;
					containDoubleQuote = false;
				} else {

					if (ch == '\"') {
						if (!containDoubleQuote) {
							data.append(ch);
							containDoubleQuote = true;
						}
					} else {
						data.append(ch);
					}

				}
			} else {
				if (ch == quote) {

					inQuote = true;

					if (chars[0] != '"' && quote == '\"') {
						data.append('"');
					}

					if (startCollectChar) {
						data.append('"');
					}

				} else if (ch == separator) {

					result.add(data.toString());

					data = new StringBuffer();
					startCollectChar = false;

				} else if (ch == '\r') {
					continue;
				} else if (ch == '\n') {
					break;
				} else {
					data.append(ch);
				}
			}
		}
		result.add(data.toString());
		return result;
	}
}