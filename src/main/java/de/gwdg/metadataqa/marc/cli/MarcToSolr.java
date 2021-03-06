package de.gwdg.metadataqa.marc.cli;

import de.gwdg.metadataqa.api.model.JsonPathCache;
import de.gwdg.metadataqa.api.model.XmlFieldInstance;
import de.gwdg.metadataqa.api.schema.MarcJsonSchema;
import de.gwdg.metadataqa.marc.MarcFactory;
import de.gwdg.metadataqa.marc.MarcFieldExtractor;
import de.gwdg.metadataqa.marc.MarcRecord;
import de.gwdg.metadataqa.marc.datastore.MarcSolrClient;
import de.gwdg.metadataqa.marc.utils.ReadMarc;
import org.apache.solr.client.solrj.SolrServerException;
import org.marc4j.MarcReader;
import org.marc4j.marc.Record;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * usage:
 * java -cp target/metadata-qa-marc-0.1-SNAPSHOT-jar-with-dependencies.jar de.gwdg.metadataqa.marc.cli.SolrKeyGenerator http://localhost:8983/solr/tardit 0001.0000000.formatted.json
 * @author Péter Király <peter.kiraly at gwdg.de>
 */
public class MarcToSolr {

	private static final Logger logger = Logger.getLogger(MarcToSolr.class.getCanonicalName());

	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("Please provide a Solr URL and file name!");
			System.exit(0);
		}
		long start = System.currentTimeMillis();

		String url = args[0];

		String relativeFileName = args[1];
		Path path = Paths.get(relativeFileName);
		String fileName = path.getFileName().toString();

		boolean doCommits = true;
		if (args.length > 2) {
			if (args[2].equals("doCommit=true"))
				doCommits = true;
			else if (args[2].equals("doCommit=false"))
				doCommits = false;
		}

		logger.info(String.format("Solr URL: %s, file: %s (do commits: %s)", url, fileName, doCommits));

		MarcSolrClient client = new MarcSolrClient(url);
		JsonPathCache<? extends XmlFieldInstance> cache;
		List<String> records;
		try {
			MarcReader reader = ReadMarc.getReader(path.toString());
			int i = 0;
			while (reader.hasNext()) {
				i++;
				Record marc4jRecord = reader.next();
				MarcRecord marcRecord = MarcFactory.createFromMarc4j(marc4jRecord);
				client.indexMap(marcRecord.getId(), marcRecord.getKeyValuePairs());

				if (i % 1000 == 0) {
					if (doCommits)
						client.commit();
					logger.info(String.format("%s/%d) %s", fileName, i, marcRecord.getId()));
				}
			}
			if (doCommits)
				client.commit();
			// logger.info("optimize");
			// client.optimize();
			logger.info(String.format("End of cycle. Indexed %d records.", i));
		} catch(SolrServerException ex){
			logger.severe(ex.toString());
			System.exit(0);
		} catch(Exception ex){
			logger.severe(ex.toString());
			ex.printStackTrace();
			System.exit(0);
		}
		long end = System.currentTimeMillis();

		long duration = (end - start) / 1000;
		logger.info(String.format("Bye! It took: %s", LocalTime.MIN.plusSeconds(duration).toString()));

		System.exit(0);
	}
}