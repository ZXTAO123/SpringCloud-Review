package com.bjpowernode.Controller;

import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserController {
    @Resource
    private UserService userService;

    @Value("${server.port}")
    private String port;
    //------------------------------------------------------------------------------------------------------
    //该方法能正常实现从提供者节点获取数据【测试成功】
    @GetMapping(value = "/Consumer/getUser")
    @ResponseBody
    public String getUserById(@RequestParam("id") Integer id) {

        return this.userService.getUser(id).toString()+",来自"+port;
    }


    //------------------------------------------------------------------------------------------------------
    //该方法用来测试提供者节点方法报错，使用提供者节点hystrix服务降级【测试失败】

    /**2023.5.1
     * 当前方法会触发到提供者节点的hystrix服务降级，但是fallbackMethod的return返回结果，在消费者端并没有收到，报错java.util.concurrent.TimeoutException: null
     */
    @GetMapping(value = "/Consumer/ProHystrix/getUserButMistake")
    @ResponseBody
    public String getUserButMistakeProHystrix(@RequestParam("id") Integer id) {
        User user = this.userService.getUserButMistake(id);
        if(user != null){
            return user.toString();
        }else{
            return "程序出错";
        }
    }

    //------------------------------------------------------------------------------------------------------
    //该方法用来测试提供者方法报错，使用消费者节点hystrix服务降级【测试成功】
    @GetMapping(value = "/Consumer/ConHystrix/getUserButMistake")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "MistakeHandler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
    public String getUserButMistakeConHystrix(@RequestParam("id") Integer id) {
        //让线程睡眠3000ms，会触发hystrix服务降级
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //以下方法能正常从提供者节点获取数据
        User user = this.userService.getUser(id);
        return null;
    }
    //提供者端hystrix兜底方案
    public String MistakeHandler(@RequestParam("id") Integer id) {
        return "消费者端hystrix触发，进入兜底方案";
    }
}
