package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JacksonParserTest {

    @Test
    public void testJacksonParser() throws IOException {
/*        byte[] jsonData = Files.readAllBytes(Paths.get("H:\\My Documents\\tests\\tests\\Dataverse Shapefile Dataset test JSON.txt"));
        String json = "{\"status\":\"OK\",\"data\":{\"id\":900,\"identifier\":\"FK2/OVQBMK\",\"persistentUrl\":\"https://doi.org/10.5072/FK2/OVQBMK\",\"protocol\":\"doi\",\"authority\":\"10.5072\",\"publisher\":\"Demo Dataverse\",\"publicationDate\":\"2015-07-13\",\"storageIdentifier\":\"file://10.5072/FK2/OVQBMK\",\"latestVersion\":{\"id\":302,\"storageIdentifier\":\"file://10.5072/FK2/OVQBMK\",\"versionNumber\":1,\"versionMinorNumber\":0,\"versionState\":\"RELEASED\",\"productionDate\":\"Production Date\",\"lastUpdateTime\":\"2015-07-13T11:02:21Z\",\"releaseTime\":\"2015-07-13T11:02:21Z\",\"createTime\":\"2015-07-13T10:59:33Z\",\"license\":\"CC0\",\"termsOfUse\":\"CC0 Waiver\",\"metadataBlocks\":{\"citation\":{\"displayName\":\"Citation Metadata\",\"fields\":[{\"typeName\":\"title\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Shapefile Dataset\"},{\"typeName\":\"author\",\"multiple\":true,\"typeClass\":\"compound\",\"value\":[{\"authorName\":{\"typeName\":\"authorName\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Quigley, Elizabeth\"},\"authorAffiliation\":{\"typeName\":\"authorAffiliation\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Harvard University\"}}]},{\"typeName\":\"datasetContact\",\"multiple\":true,\"typeClass\":\"compound\",\"value\":[{\"datasetContactName\":{\"typeName\":\"datasetContactName\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Quigley, Elizabeth\"},\"datasetContactAffiliation\":{\"typeName\":\"datasetContactAffiliation\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Harvard University\"},\"datasetContactEmail\":{\"typeName\":\"datasetContactEmail\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"equigley@iq.harvard.edu\"}}]},{\"typeName\":\"dsDescription\",\"multiple\":true,\"typeClass\":\"compound\",\"value\":[{\"dsDescriptionValue\":{\"typeName\":\"dsDescriptionValue\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Dataset for shapefile\"}}]},{\"typeName\":\"subject\",\"multiple\":true,\"typeClass\":\"controlledVocabulary\",\"value\":[\"Earth and Environmental Sciences\"]},{\"typeName\":\"depositor\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"Quigley, Elizabeth\"},{\"typeName\":\"dateOfDeposit\",\"multiple\":false,\"typeClass\":\"primitive\",\"value\":\"2015-07-13\"}]}},\"files\":[{\"label\":\"shapefiletest.zip\",\"restricted\":false,\"version\":1,\"datasetVersionId\":302,\"dataFile\":{\"id\":901,\"persistentId\":\"\",\"pidURL\":\"\",\"filename\":\"shapefiletest.zip\",\"contentType\":\"application/zipped-shapefile\",\"filesize\":141004,\"storageIdentifier\":\"14e87ee7213-e642881106e3\",\"rootDataFileId\":-1,\"md5\":\"d1086c3d83d0f3e1d5af91a692493317\",\"checksum\":{\"type\":\"MD5\",\"value\":\"d1086c3d83d0f3e1d5af91a692493317\"}}}]}}}";

        ObjectMapper objectMapper = new ObjectMapper();
        DataverseJSON dataverseJSON = objectMapper.readValue(json, DataverseJSON.class);*/

        String jsonData = "{\n" +
                "  \"id\": 123,\n" +
                "  \"name\": \"Pankaj\",\n" +
                "  \"permanent\": true,\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Albany Dr\",\n" +
                "    \"city\": \"San Jose\",\n" +
                "    \"zipcode\": 95129\n" +
                "  },\n" +
                "  \"phoneNumbers\": [\n" +
                "    123456,\n" +
                "    987654\n" +
                "  ],\n" +
                "  \"role\": \"Manager\",\n" +
                "  \"cities\": [\n" +
                "    \"Los Angeles\",\n" +
                "    \"New York\"\n" +
                "  ],\n" +
                "  \"properties\": {\n" +
                "    \"age\": \"29 years\",\n" +
                "    \"salary\": \"1000 USD\"\n" +
                "  }\n" +
                "}";

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        Employee emp = objectMapper.readValue(jsonData,Employee.class);
        System.out.println("Wait!");

    }

}
