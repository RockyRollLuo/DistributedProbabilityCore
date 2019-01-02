package database;

import database.base.IntEdge;
import database.mapper.IntEdgeMapper;
import database.tool.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class IntEdgeService {

    @Test
    public void insertEdge() {
        SqlSession session = DBTools.getSession();
        IntEdgeMapper mapper = session.getMapper(IntEdgeMapper.class);

        IntEdge edge=new IntEdge(1,0,1,1);

        try {
            mapper.insertEdge(edge);
            System.out.println("insert edge fa ");
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }


    }
}
