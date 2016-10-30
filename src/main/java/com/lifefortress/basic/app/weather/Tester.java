package com.lifefortress.basic.app.weather;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.maps.GeoApiContext;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;

public class Tester {
//	@Test
	public void testRead() {
		String line = "10,\"\"AU,Australia";
		List<String> result = CSVReader.parseLine(line, ',', '"');

		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 3);
		Assert.assertEquals(result.get(0), "10");
		Assert.assertEquals(result.get(1), "\"AU");
		Assert.assertEquals(result.get(2), "Australia");

	}

//	@Test
	public void testWrite() throws IOException {
		String physicalFile = "test.csv";

		FileWriter writer = new FileWriter(physicalFile);
		CVSWriter.writeLine(writer, Arrays.asList("a", "b", "c", "d"));

		// custom separator + quote
		CVSWriter.writeLine(writer, Arrays.asList("aaa", "bb,b", "cc,c"), ',', '"');

		// custom separator + quote
		CVSWriter.writeLine(writer, Arrays.asList("aaa", "bbb", "cc,c"), '|', '\'');

		// double-quotes
		CVSWriter.writeLine(writer, Arrays.asList("aaa", "bbb", "cc\"c"));
		
		writer.flush();
		writer.close();

	}
	
	@Test
	public void location() {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAbmtUt6BZuvKRDK8dB7pPIELqTeclXCrQ");
		TimeZone tz = TimeZoneApi.getTimeZone(context, new LatLng(3.139003, 101.686855)).awaitIgnoreError();
		
		System.out.println(tz.getID());
		
		DateTimeZone dtz = DateTimeZone.forID(tz.getID());
		DateTime dt = new DateTime(dtz);
		System.out.println(dt);
	}

}
