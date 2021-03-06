package de.gwdg.metadataqa.marc.definition.tags.tags3xx;

import de.gwdg.metadataqa.marc.definition.Cardinality;
import de.gwdg.metadataqa.marc.definition.DataFieldDefinition;
import de.gwdg.metadataqa.marc.definition.Indicator;
import de.gwdg.metadataqa.marc.definition.general.codelist.LanguageCodeAndTermSourceCodes;

/**
 * Associated Language
 * http://www.loc.gov/marc/bibliographic/bd377.html
 */
public class Tag377 extends DataFieldDefinition {
	private static Tag377 uniqueInstance;

	private Tag377() {
		initialize();
		postCreation();
	}

	public static Tag377 getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Tag377();
		return uniqueInstance;
	}

	private void initialize() {

		tag = "377";
		label = "Associated Language";
		mqTag = "AssociatedLanguage";
		cardinality = Cardinality.Repeatable;
		descriptionUrl = "https://www.loc.gov/marc/bibliographic/bd377.html";

		ind1 = new Indicator();
		ind2 = new Indicator("Source of code")
			.setCodes(
				" ", "MARC language code",
				"7", "Source specified in $2"
			)
			.setMqTag("sourceOfCode");

		setSubfieldsWithCardinality(
			"a", "Language code", "R",
			"l", "Language term", "R",
			"0", "Authority record control number or standard number", "R",
			"2", "Source", "NR",
			"6", "Linkage", "NR",
			"8", "Field link and sequence number", "R"
		);

		getSubfield("2").setCodeList(LanguageCodeAndTermSourceCodes.getInstance());

		getSubfield("a").setMqTag("languageCode");
		getSubfield("l").setMqTag("languageTerm");
		getSubfield("0").setMqTag("authorityRecordControlNumber");
		getSubfield("2").setMqTag("source");
		getSubfield("6").setBibframeTag("linkage");
		getSubfield("8").setMqTag("fieldLink");
	}
}
