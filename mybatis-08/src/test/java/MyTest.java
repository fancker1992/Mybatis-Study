import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class MyTest {
    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void getBlog() {
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql    getMapper方式
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "熊大的故事");
//        map.put("author", "熊大");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {

            logger.info(blog);
        }

        //关闭sqlSession
        sqlSession.close();
    }

}
