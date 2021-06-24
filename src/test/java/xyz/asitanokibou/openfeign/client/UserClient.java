package xyz.asitanokibou.openfeign.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.asitanokibou.demo.models.core.ServiceResult;
import xyz.asitanokibou.demo.models.vo.*;
import xyz.asitanokibou.openfeign.FeignClient;
import xyz.asitanokibou.openfeign.SpringQueryMap;
import xyz.asitanokibou.openfeign.callback.UserClientFallbackFactory;
import xyz.asitanokibou.openfeign.config.UserClientFeignConfiguration;

import java.util.List;
import java.util.Map;

@FeignClient(name = "dxUserClient",
        contextId = "dx-user-service",
        url = "${app.openfeign.client.gateway.dev}",
        configuration = UserClientFeignConfiguration.class,
        fallbackFactory = UserClientFallbackFactory.class
)
public interface UserClient {

    @GetMapping("/dx-user/system/dept/deptTree/{deptId}")
    ResponseEntity<ServiceResult<DeptTreeInfoResDTO>> getUserDeptTree(@PathVariable("deptId") Long deptId);

    /**
     * 根据部门id获取部门树
     *
     * @param deptId 部门id
     */
    @GetMapping("/dx-user/system/dept/deptTree/{deptId}")
    ServiceResult<DeptTreeInfoResDTO> getDeptTree(@PathVariable("deptId") Long deptId);

    /**
     * 根据参数获取部门列表
     *
     * @param paramMap form表单参数
     */
    @GetMapping("/dx-user/system/dept/list")
    ServiceResult<List<DeptTreeResDTO>> getDepts(@SpringQueryMap Map<String, Object> paramMap);

    /**
     * 获取部门下的岗位列表
     */
    @GetMapping(value = "/dx-user/system/dept/postList")
    ServiceResult<List<PostInfoResDTO>> getDeptPostList(@RequestParam("deptIds") List<Long> deptIds);


    @GetMapping("/dx-user/system/dept/deptChildren/{deptId}")
    ServiceResult<List<DeptTreeResDTO>> getWorkshopsByDeptId(@PathVariable("deptId") Long deptId);

//    @GetMapping("/dx-user/system/dept/userList")
//    ServiceResult<PageResVO<PersonnelInfo>> getUserInDept(@SpringQueryMap UserSelectReqVO userSelectReqVO);

    @GetMapping("/dx-user/system/user/{userId}")
    ServiceResult<UserInfo> getUserInfo(@PathVariable("userId") Long userId);


    @GetMapping("/stripsteelmes/rollingPlan/assembleBilletTask/listChanged")
    String requestTest(@SpringQueryMap QueryDTO queryDTO);
}
