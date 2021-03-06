package de.gwdg.metadataqa.marc.definition.tags.tags5xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Numbering Peculiarities Note
 * http://www.loc.gov/marc/bibliographic/bd515.html
 */
public class Tag515 extends DataFieldDefinition {

	private static Tag515 uniqueInstance;

	private Tag515() {
		initialize();
		postCreation();
	}

	public static Tag515 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag515();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "515";
		label = "Numbering Peculiarities Note";
		mqTag = "NumberingPeculiarities";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd515.html";

		ind1 = new Indicator();
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "Numbering peculiarities note", "NR",
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
