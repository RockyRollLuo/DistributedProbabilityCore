/**
 * User: RockyRoll
 * Date: 2019-01-02
 */

package database.base;


public class IntEdge {


    private int headNo;
    private int tailNo;
    private int weight;

    public IntEdge() {
    }

    public IntEdge(int headNo, int tailNo, int weight) {
        this.headNo = headNo;
        this.tailNo = tailNo;
        this.weight = weight;
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
