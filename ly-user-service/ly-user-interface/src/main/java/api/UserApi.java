package api;

import com.leyou.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author bystander
 * @date 2018/10/1
 */
public interface UserApi {

    @GetMapping("/check/{data}/{type}")
    Boolean checkData(@PathVariable("data") String data, @PathVariable("type") Integer type) ;
    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @PostMapping("send")
    void sendVerifyCode(@RequestParam("phone")String phone) ;
    /**
     * 用户注册
     * @param user
     * @param code
     * @return
     */
    @PostMapping("register")
   void register(@Valid User user, @RequestParam("code")String code) ;

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("query")
    User queryUser(@RequestParam("username") String username, @RequestParam("password") String password);
}
