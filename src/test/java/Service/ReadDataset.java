package Service;

import database.Service.ReadDatasetService;

public class ReadDataset {

    public static void main(String[] args) {

        ReadDatasetService readDatasetService = new ReadDatasetService();

        String datasetName=
//                "origdata/p2p-Gnutella08.txt";
                "origdata/com-dblp.ungraph.txt";


        readDatasetService.readDataset(datasetName);



    }

}
