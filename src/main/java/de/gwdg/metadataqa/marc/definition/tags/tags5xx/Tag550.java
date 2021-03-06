package de.gwdg.metadataqa.marc.definition.tags.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Issuing Body Note
 * http://www.loc.gov/marc/bibliographic/bd550.html
 */
public class Tag550 extends DataFieldDefinition {

	private static Tag550 uniqueInstance;

	private Tag550() {
		initialize();
		postCreation();
	}

	public static Tag550 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag550();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "550";
		label = "Issuing Body Note";
		mqTag = "IssuingBody";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd550.html";

		ind1 = new Indicator()
			.setHistoricalCodes(
				"0", "Repetitious",
				"1", "Not repetitious"
			);
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "Issuing body note", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("a").setBibframeTag("rdfs:label").setMqTag("rdf:value");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");

		setHistoricalSubfields(
			"z", "Source of note information (SE) [OBSOLETE, 1990]"
		);
	}
}
