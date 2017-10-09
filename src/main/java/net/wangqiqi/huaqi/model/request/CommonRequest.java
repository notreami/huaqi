package net.wangqiqi.huaqi.model.request;

import lombok.Data;
import net.wangqiqi.huaqi.model.common.BaseInfo;
import net.wangqiqi.huaqi.model.common.ClientInfo;
import net.wangqiqi.huaqi.model.common.OperatorEnum;
import net.wangqiqi.huaqi.model.common.ProcessType;

/**
 * 用户ID？token？
 * Created by notreami on 17/9/8.
 */
@Data
public class CommonRequest<T extends BaseInfo> {
    /**
     * 调用方信息
     */
    private ClientInfo clientInfo;
    /**
     * 订单操作类型
     */
    private ProcessType processType;
    /**
     * 操作人类型
     */
    private OperatorEnum operatorType;
    /**
     * 操作人
     * 用户:userId
     * 商家: 登录用户名/账号/联系人 等
     * 客服: 客服mis号
     */
    private String operator;
    /**
     * 每种操作对应的数据
     */
    private T data;
}
