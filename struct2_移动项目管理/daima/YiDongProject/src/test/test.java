package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.yidong.Dao.OperatorDao;

public class test {
	public static void main(String[] args) {
		try {
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			
			SqlSession session = factory.openSession();
			
			OperatorDao od = session.getMapper(OperatorDao.class);
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
