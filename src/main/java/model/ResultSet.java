/**
 * User: RockyRoll
 * Date: 2018-12-31
 *
 * each round has a recorded
 */

package model;

import java.util.ArrayList;

public class ResultSet {

    private int roundNo;    //
    private long roundTime;
    private int changedNum;  //the vertex number of whose core number have changed during this round
    private int noChangedNum;
    private ArrayList<Integer> estCoreList;

    /**
     * constructor with all parameter
     *
     * @param roundNo
     * @param roundTime
     * @param changedNum
     * @param noChangedNum
     * @param estCoreList
     */
    public ResultSet(int roundNo, long roundTime, int changedNum, int noChangedNum, ArrayList<Integer> estCoreList) {
        this.roundNo = roundNo;
        this.roundTime = roundTime;
        this.changedNum = changedNum;
        this.noChangedNum = noChangedNum;
        this.estCoreList = estCoreList;
    }

    /**
     * constructor with no parameter
     */
    public ResultSet() {
    }

    /**
     * getter and setter
     */
    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    public long getRoundTime() {
        return roundTime;
    }

    public void setRoundTime(long roundTime) {
        this.roundTime = roundTime;
    }

    public int getChangedNum() {
        return changedNum;
    }

    public void setChangedNum(int changedNum) {
        this.changedNum = changedNum;
    }

    public int getNoChangedNum() {
        return noChangedNum;
    }

    public void setNoChangedNum(int noChangedNum) {
        this.noChangedNum = noChangedNum;
    }

    public ArrayList<Integer> getEstCoreList() {
        return estCoreList;
    }

    public void setEstCoreList(ArrayList<Integer> estCoreList) {
        this.estCoreList = estCoreList;
    }
}

