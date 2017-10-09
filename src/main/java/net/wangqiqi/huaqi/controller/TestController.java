package net.wangqiqi.huaqi.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.wangqiqi.huaqi.model.response.CommonResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;

/**
 * 未授权认证测试接口
 * Created by notreami on 17/9/8.
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${spring.profiles.active}")
    private String projectEnv;


    @GetMapping("/status/active")
    public CommonResponse activeStatus() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String datetime = zonedDateTime.getZone().getDisplayName(TextStyle.FULL, Locale.ROOT)
                + "(" + zonedDateTime.getZone().getDisplayName(TextStyle.SHORT, Locale.ROOT) + ")  "
                + zonedDateTime;


        val objectMap =new HashMap<String, Object>();
        objectMap.put("当前环境", projectEnv);
        objectMap.put("服务器时区", datetime);
        return CommonResponse.createSuccess(objectMap);
    }

}
