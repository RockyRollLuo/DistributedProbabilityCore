package database.mapper;

import database.entity.IntEdge;

import java.util.ArrayList;

public interface IntEdgeMapper {

    /**
     * insert an edge
     * @param edge
     * @return
     * @throws Exception
     */
    public int insertEdge(IntEdge edge) throws Exception;


    /**
     * get and vertex's neighbors vertex
     * @param headNo
     * @return
     * @throws Exception
     */
    public ArrayList<Integer> getAjacentVertics(int headNo) throws Exception;


}
