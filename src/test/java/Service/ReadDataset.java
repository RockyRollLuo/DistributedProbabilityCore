package Service;

import database.Service.ReadDatasetService;

public class ReadDataset {

    public static void main(String[] args) {

        ReadDatasetService readDatasetService = new ReadDatasetService();

        String datasetName="origdata/p2p-Gnutella31.txt";


        readDatasetService.readDataset(datasetName);






    }

}
