/**
 * User: RockyRoll
 * Date: 2019-01-02
 */

package database.entity;


public class IntEdge{
    private int id;
    private int datasetId;
    private int headNo;
    private int tailNo;
    private int weight;

    public IntEdge() {
    }

    public IntEdge(int datasetId, int headNo, int tailNo, int weight) {
        this.datasetId = datasetId;
        this.headNo = headNo;
        this.tailNo = tailNo;
        this.weight = weight;
    }

    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

    public int getHeadNo() {
        return headNo;
    }

    public void setHeadNo(int headNo) {
        this.headNo = headNo;
    }

    public int getTailNo() {
        return tailNo;
    }

    public void setTailNo(int tailNo) {
        this.tailNo = tailNo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
