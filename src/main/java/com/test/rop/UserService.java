package com.test.rop;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.session.SimpleSession;
import org.springframework.http.HttpRequest;

/**
 * @author huangchangling on 2017/6/13 0013
 * http://localhost:8080/router?method=user.getSession&v=1.0&appKey=00001&sign=abcdefg&format=json
 * 模拟的访问方式，开启sign检验的话需要重新计算sign，默认是对所有参数进行Sha1加密
 * 可以自定义这部分
 */
@ServiceMethodBean
public class UserService {

    @ServiceMethod(method = "user.getSession", version = "1.0",
            needInSession = NeedInSessionType.NO)
    public Object getSession(LogonRequest request){
        //创建一个会话
        SimpleSession session = new SimpleSession();
        session.setAttribute("userName",request.getUserName());
        request.getRopRequestContext().addSession("mockSessionId1",session);
        //返回响应
        LogonResponse logonResponse = new LogonResponse();
        logonResponse.setSessionId("mockSessionId1");
        return logonResponse;
    }
}
