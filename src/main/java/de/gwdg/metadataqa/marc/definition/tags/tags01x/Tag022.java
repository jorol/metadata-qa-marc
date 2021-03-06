package de.gwdg.metadataqa.marc.definition.tags.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * International Standard Serial Number
 * http://www.loc.gov/marc/bibliographic/bd022.html
 */
public class Tag022 extends DataFieldDefinition {

	private static Tag022 uniqueInstance;

	private Tag022() {
		initialize();
		postCreation();
	}

	public static Tag022 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag022();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "022";
		label = "International Standard Serial Number";
		bibframeTag = "Issn";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd022.html";

		ind1 = new Indicator("Level of international interest")
			.setCodes(
				" ", "No level specified",
				"0", "Continuing resource of international interest",
				"1", "Continuing resource not of international interest"
			)
			.setMqTag("levelOfInternationalInterest");
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "International Standard Serial Number", "NR",
			"l", "ISSN-L", "NR",
			"m", "Canceled ISSN-L", "R",
			"y", "Incorrect ISSN", "R",
			"z", "Canceled ISSN", "R",
			"2", "Source", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);
		// TODO check against ISSN National Centres code list http://www.issn.org/
		// getSubfield("2").setCodeList();

		getSubfield("a").setBibframeTag("rdf:value");
		getSubfield("l").setBibframeTag("issnL");
		getSubfield("m").setMqTag("canceledIssnL");
		getSubfield("y").setMqTag("incorrect");
		getSubfield("z").setMqTag("canceled");
		getSubfield("2").setMqTag("source");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");

		setHistoricalSubfields(
			"b", "Form of issue [OBSOLETE] [CAN/MARC only]",
			"c", "Price [OBSOLETE] [CAN/MARC only]"
		);
	}
}
