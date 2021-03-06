package de.gwdg.metadataqa.marc.definition.tags.tags01x;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;

/**
 * Report Number
 * http://www.loc.gov/marc/bibliographic/bd088.html
 */
public class Tag088 extends DataFieldDefinition {

	private static Tag088 uniqueInstance;

	private Tag088() {
		initialize();
		postCreation();
	}

	public static Tag088 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag088();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "088";
		label = "Report Number";
		bibframeTag = "ReportNumber";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd088.html";

		ind1 = new Indicator();
		ind2 = new Indicator();

		setSubfieldsWithCardinality(
			"a", "Report number", "NR",
			"z", "Canceled/invalid report number", "R",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("a").setBibframeTag("rdf:value");
		getSubfield("z").setMqTag("canceled");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");
	}
}
