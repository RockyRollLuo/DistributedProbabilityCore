package database.Service;

import database.entity.IntEdge;
import database.mapper.IntEdgeMapper;
import database.tool.DBTools;
import org.apache.ibatis.session.SqlSession;

public class IntEdgeService {

    public void insertEdge() {
        SqlSession session = DBTools.getSession();
        IntEdgeMapper mapper = session.getMapper(IntEdgeMapper.class);

        IntEdge edge=new IntEdge(1,0,1,1);

        try {
            mapper.insertEdge(edge);
            System.out.println("insert edge");
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }


    }
}
