package de.gwdg.metadataqa.marc.definition.tags.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Former Publication Frequency
 * http://www.loc.gov/marc/bibliographic/bd321.html
 */
public class Tag321 extends DataFieldDefinition {
	private static Tag321 uniqueInstance;

	private Tag321() {
		initialize();
		postCreation();
	}

	public static Tag321 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag321();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "321";
		label = "Former Publication Frequency";
		bibframeTag = "Frequency";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd321.html";

		ind1 = new Indicator();
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "Former publication frequency", "NR",
			"b", "Dates of former publication frequency", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("a").setBibframeTag("rdfs:label").setMqTag("rdf:value");
		getSubfield("b").setBibframeTag("date");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");
	}
}
