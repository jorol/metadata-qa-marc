package de.gwdg.metadataqa.marc.definition.tags.tags20x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Uniform Title
 * http://www.loc.gov/marc/bibliographic/bd240.html
 */
public class Tag240 extends DataFieldDefinition {
	private static Tag240 uniqueInstance;

	private Tag240() {
		initialize();
		postCreation();
	}

	public static Tag240 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag240();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "240";
		label = "Uniform Title";
		mqTag = "UniformTitle";
		cardinality = Cardinality.Nonrepeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd240.html";

		ind1 = new Indicator("Uniform title printed or displayed")
			.setCodes(
				"0", "Not printed or displayed",
				"1", "Printed or displayed"
			)
			.setHistoricalCodes(
				"2", "Not printed on card, title added entry (MU) [OBSOLETE, 1993]",
				"3", "Printed on card, title added entry (MU) [OBSOLETE, 1993]"
			)
			.setMqTag("printedOrDisplayed");;
		ind2 = new Indicator("Nonfiling characters")
			.setCodes(
				"0-9", "Number of nonfiling characters"
			)
			.setMqTag("nonfilingCharacters");
		ind2.getCode("0-9").setRange(true);

		setSubfieldsWithCardinality(
			"a", "Uniform title", "NR",
			"d", "Date of treaty signing", "R",
			"f", "Date of a work", "NR",
			"g", "Miscellaneous information", "R",
			"h", "Medium", "NR",
			"k", "Form subheading", "R",
			"l", "Language of a work", "NR",
			"m", "Medium of performance for music", "R",
			"n", "Number of part/section of a work", "R",
			"o", "Arranged statement for music", "NR",
			"p", "Name of part/section of a work", "R",
			"r", "Key for music", "NR",
			"s", "Version", "NR",
			"0", "Authority record control number or standard number", "R",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);
		getSubfield("a").setBibframeTag("mainTitle");
		getSubfield("d").setMqTag("dateOfTreaty");
		getSubfield("f").setMqTag("dateOfAWork");
		getSubfield("g").setMqTag("miscellaneous");
		getSubfield("h").setMqTag("medium");
		getSubfield("k").setMqTag("formSubheading");
		getSubfield("l").setMqTag("languageOfAWork");
		getSubfield("m").setMqTag("mediumOfPerformance");
		getSubfield("n").setBibframeTag("partNumber");
		getSubfield("o").setMqTag("arrangedStatement");
		getSubfield("p").setMqTag("nameOfPart");
		getSubfield("r").setMqTag("keyForMusic");
		getSubfield("s").setBibframeTag("version");
		getSubfield("0").setMqTag("authorityRecordControlNumber");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");
	}
}
