package org.welyss.mysqlparser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MySQLParserUtils {
	public static Integer[] initArrayForInt(String filename) throws IOException {
		List<Integer> result = new ArrayList<Integer>();
		try (InputStream is = MySQLParserUtils.class.getClassLoader().getResourceAsStream(filename)) {
			int buf;
			StringBuilder sbuff = new StringBuilder();
			while((buf = is.read()) != -1) {
				if (buf == 44) {
					result.add(Integer.parseInt((sbuff.toString())));
					sbuff.setLength(0);
				} else if (buf != 10 && buf != 13){
					sbuff.append((char)buf);
				}
			}
			if (sbuff.length() > 0) {
				result.add(Integer.parseInt((sbuff.toString())));
			}
		}
		return result.toArray(new Integer[result.size()]);
	}

	public static Short[] initArrayForShort(String filename) throws IOException {
		List<Short> result = new ArrayList<Short>();
		try (InputStream is = MySQLParserUtils.class.getClassLoader().getResourceAsStream(filename)) {
			int buf;
			StringBuilder sbuff = new StringBuilder();
			while((buf = is.read()) != -1) {
				if (buf == 44) {
					result.add(Short.parseShort((sbuff.toString())));
					sbuff.setLength(0);
				} else if (buf != 10 && buf != 13){
					sbuff.append((char)buf);
				}
			}
			if (sbuff.length() > 0) {
				result.add(Short.parseShort((sbuff.toString())));
			}
		}
		return result.toArray(new Short[result.size()]);
	}

	public static Byte[] initArrayForByte(String filename) throws IOException {
		List<Byte> result = new ArrayList<Byte>();
		try (InputStream is = MySQLParserUtils.class.getClassLoader().getResourceAsStream(filename)) {
			int buf;
			StringBuilder sbuff = new StringBuilder();
			while((buf = is.read()) != -1) {
				if (buf == 44) {
					result.add(Byte.parseByte((sbuff.toString())));
					sbuff.setLength(0);
				} else if (buf != 10 && buf != 13){
					sbuff.append((char)buf);
				}
			}
			if (sbuff.length() > 0) {
				result.add(Byte.parseByte((sbuff.toString())));
			}
		}
		return result.toArray(new Byte[result.size()]);
	}

	/**
	 * Split string to array of string by \t, pay attention to that the value must not include \t.
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String[] initArrayForString(String filename) throws IOException {
		List<String> result = new ArrayList<String>();
		try (InputStream is = MySQLParserUtils.class.getClassLoader().getResourceAsStream(filename)) {
			int buf;
			StringBuilder sbuff = new StringBuilder();
			while((buf = is.read()) != -1) {
				// split by \t, value must not include \t
				if (buf == 9) {
					result.add(formatValue(sbuff));
					sbuff.setLength(0);
				} else if (buf != 10 && buf != 13){
					sbuff.append((char)buf);
				}
			}
			if (sbuff.length() > 0) {
				result.add(formatValue(sbuff));
			}
		}
		return result.toArray(new String[result.size()]);
	}

	private static String formatValue(StringBuilder sbuff) {
		String val = sbuff.toString();
		return val.equals("null") ? null : val;
	}
}
