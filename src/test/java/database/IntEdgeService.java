package database;

import database.entity.IntEdge;
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
            int result=mapper.insertEdge(edge);
            if (result > 0) {
                System.out.println("Successful insert edge ");
                session.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        DBTools.closeSession(session);

    }


}
