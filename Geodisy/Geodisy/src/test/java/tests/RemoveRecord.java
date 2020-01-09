package tests;

import BaseFiles.FileWriter;
import Dataverse.ExistingHarvests;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;

import static BaseFiles.GeodisyStrings.EXISTING_BBOXES;
import static BaseFiles.GeodisyStrings.EXISTING_RECORDS;


public class RemoveRecord {
    String record2Remove = "10.5072/FK2/VWSCHA";
    @Test
    public void removeRecord() {
        FileWriter fW = new FileWriter();
        fW.verifyFileExistence(EXISTING_BBOXES);
        fW.verifyFileExistence(EXISTING_RECORDS);
        ExistingHarvests existingHarvests = ExistingHarvests.getExistingHarvests();
        existingHarvests.deleteRecord(record2Remove);
        existingHarvests.saveExistingSearchs(existingHarvests.getRecordVersions(),EXISTING_RECORDS, "ExistingRecords");
        existingHarvests.saveExistingSearchs(existingHarvests.getbBoxes(),EXISTING_BBOXES, "ExistingBBoxes");
        String folderized = record2Remove.replace(".","/");
        File file = new File("datasetFiles/" + folderized);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        file = new File("XMLFiles/" + folderized);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}