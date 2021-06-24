package xyz.asitanokibou.openfeign;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.asitanokibou.demo.models.vo.QueryDTO;
import xyz.asitanokibou.openfeign.client.UserClient;
import xyz.asitanokibou.openfeign.util.MockUtil;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DxUserClientTests {

    @Autowired
    private UserClient userClient;

    @Before
    public void setUp() {
        String bearToken = "bearer 5025_504e0666fb9a4ae1b1f2a132ea408ea9";
        MockUtil.mockBearTokenAttributeInRequestContext(bearToken);
    }

    @Test
    public void testUserClient(){
//        MockUtil.mockBearTokenAttributeInRequestContext("1234");
//        mockDeptResult(xxx);
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setBatchNo(null);
        queryDTO.setChangeStartTime(LocalDate.now());
        userClient.requestTest(queryDTO);
    }

    @After
    public void destroy() {
    }


}
