package de.gwdg.metadataqa.marc.definition;

import de.gwdg.metadataqa.marc.Utils;
import de.gwdg.metadataqa.marc.definition.controlsubfields.tag006.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Control006Subfields {

	private static final Map<Control008Type, List<ControlSubfield>> subfields = new HashMap<>();

	static {
		subfields.put(
			Control008Type.ALL_MATERIALS,
			Arrays.asList(
				Tag006all00.getInstance()
			)
		);

		subfields.put(
			Control008Type.BOOKS,
			Arrays.asList(
				Tag006book01.getInstance(),
				Tag006book05.getInstance(),
				Tag006book06.getInstance(),
				Tag006book07.getInstance(),
				Tag006book11.getInstance(),
				Tag006book12.getInstance(),
				Tag006book13.getInstance(),
				Tag006book14.getInstance(),
				// new ControlSubfield("undefined", 15, 16),
				Tag006book16.getInstance(),
				Tag006book17.getInstance()
			)
		);

		subfields.put(
			Control008Type.COMPUTER_FILES,
			Arrays.asList(
				// new ControlSubfield("undefined", 1, 5),
				Tag006computer05.getInstance(),
				Tag006computer06.getInstance(),
				// new ControlSubfield("undefined", 7, 9),
				Tag006computer09.getInstance(),
				// new ControlSubfield("undefined", 10, 11),
				Tag006computer11.getInstance()
				// new ControlSubfield("undefined", 12, 18)
			)
		);

		subfields.put(
			Control008Type.MAPS,
			Arrays.asList(
				Tag006map01.getInstance(),
				Tag006map05.getInstance(),
				// new ControlSubfield("undefined", 7, 8),
				Tag006map08.getInstance(),
				// new ControlSubfield("undefined", 9, 11),
				Tag006map11.getInstance(),
				Tag006map12.getInstance(),
				// new ControlSubfield("undefined", 13, 14),
				Tag006map14.getInstance(),
				// new ControlSubfield("undefined", 15, 16)
				Tag006map16.getInstance()
			)
		);

		subfields.put(
			Control008Type.MUSIC,
			Arrays.asList(
				Tag006music01.getInstance(),
				Tag006music03.getInstance(),
				Tag006music04.getInstance(),
				Tag006music05.getInstance(),
				Tag006music06.getInstance(),
				Tag006music07.getInstance(),
				Tag006music13.getInstance(),
				// new ControlSubfield("Undefined", 15, 16),
				Tag006music16.getInstance()
				// new ControlSubfield("Undefined", 17, 18)
			)
		);

		subfields.put(
			Control008Type.CONTINUING_RESOURCES,
			Arrays.asList(
				Tag006continuing01.getInstance(),
				Tag006continuing02.getInstance(),
				// new ControlSubfield("Undefined", 3, 4),
				Tag006continuing04.getInstance(),
				Tag006continuing05.getInstance(),
				Tag006continuing06.getInstance(),
				Tag006continuing07.getInstance(),
				Tag006continuing08.getInstance(),
				Tag006continuing11.getInstance(),
				Tag006continuing12.getInstance(),
				// new ControlSubfield("Undefined", 13, 16),
				Tag006continuing16.getInstance(),
				Tag006continuing17.getInstance()
			)
		);

		subfields.put(
			Control008Type.VISUAL_MATERIALS,
			Arrays.asList(
				Tag006visual01.getInstance(),
				// new ControlSubfield("Undefined", 4, 5),
				Tag006visual05.getInstance(),
				// new ControlSubfield("Undefined", 6, 11),
				Tag006visual11.getInstance(),
				Tag006visual12.getInstance(),
				// new ControlSubfield("Undefined", 13, 16),
				Tag006visual16.getInstance(),
				Tag006visual17.getInstance()
			)
		);

		subfields.put(
			Control008Type.MIXED_MATERIALS,
			Arrays.asList(
				// new ControlSubfield("Undefined", 1, 6),
				Tag006mixed06.getInstance()
				// new ControlSubfield("Undefined", 7, 18),
			)
		);
	}

	public static Map<Control008Type, List<ControlSubfield>> getSubfields() {
		return subfields;
	}

	public static List<ControlSubfield> get(Control008Type category) {
		return subfields.get(category);
	}
}
