/**
 * User: RockyRoll
 * Date: 2018-12-29
 * Deterministic Graph Node
 */

package model;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class DeterminVertex {
    private static Logger LOGGER = Logger.getLogger(DeterminVertex.class);

    private int vertexId;
    private int estCore;

    private boolean changed;
    private ArrayList<Integer> neighbors;
    private ArrayList<Integer> neighborsEstCore;

    /**
     * Constructor with vertexId
     * @param vertexId
     */
    public DeterminVertex(int vertexId) {
        this.vertexId = vertexId;
        this.estCore = Integer.MAX_VALUE;
        this.changed = true;
    }

    /**
     * Constructor with vertexId and estCore
     * @param vertexId
     * @param estCore
     */
    public DeterminVertex(int vertexId, int estCore) {
        this.vertexId = vertexId;
        this.estCore = estCore;
        this.changed = true;
    }

    public int getNodeId() {
        return vertexId;
    }

    public void setNodeId(int vertexId) {
        this.vertexId = vertexId;
    }

    public int getEstCore() {
        return estCore;
    }

    public void setEstCore(int estCore) {
        this.estCore = estCore;
    }

    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public DeterminVertex(ArrayList<Integer> neighborsEstCore) {
        this.neighborsEstCore = neighborsEstCore;
    }
}
