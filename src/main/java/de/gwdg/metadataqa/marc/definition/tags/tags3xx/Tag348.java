package de.gwdg.metadataqa.marc.definition.tags.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Format of Notated Music
 * http://www.loc.gov/marc/bibliographic/bd348.html
 */
public class Tag348 extends DataFieldDefinition {
	private static Tag348 uniqueInstance;

	private Tag348() {
		initialize();
		postCreation();
	}

	public static Tag348 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag348();
		return uniqueInstance;
	}

	private void initialize() {
		tag = "348";
		label = "Format of Notated Music";
		bibframeTag = "MusicFormat";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd348.html";

		ind1 = new Indicator();
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "Format of notated music term", "R",
			"b", "Format of notated music code", "R",
			"0", "Authority record control number or standard number", "R",
			"2", "Source", "NR",
			"3", "Materials specified", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("a").setBibframeTag("rdfs:label").setMqTag("rdf:value");
		getSubfield("b").setBibframeTag("code");
		getSubfield("0").setMqTag("authorityRecordControlNumber");
		getSubfield("2").setBibframeTag("source");
		getSubfield("3").setMqTag("materialsSpecified");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");
	}
}
