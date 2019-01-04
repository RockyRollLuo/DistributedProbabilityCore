package database.Service;

import database.entity.IntEdge;
import database.mapper.IntEdgeMapper;
import database.tool.DBTools;
import org.apache.ibatis.session.SqlSession;

public class IntEdgeService {

    public void insertEdge(IntEdge intEdge) {
        SqlSession session = DBTools.getSession();
        IntEdgeMapper mapper = session.getMapper(IntEdgeMapper.class);
        try {
            mapper.insertEdge(intEdge);
            System.out.println("inserting edge");
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        DBTools.closeSession(session);
    }
}
