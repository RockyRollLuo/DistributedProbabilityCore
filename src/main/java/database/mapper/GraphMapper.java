package database.mapper;

import adjacentlist.ProbGraph;
import database.entity.IntEdge;
import database.entity.IntGraph;

import java.util.ArrayList;

public interface GraphMapper {

    /**
     * insert an edge
     * @param edge
     * @return
     * @throws Exception
     */
    public int insertGraph(IntEdge edge) throws Exception;


    /**
     *
     * @param datasetId
     * @return
     * @throws Exception
     */
    public IntGraph getIntGraph(int datasetId) throws Exception;


    /**
     *
     * @param datasetId
     * @return
     * @throws Exception
     */
    public ProbGraph getProbGraph(int datasetId) throws Exception;





}
