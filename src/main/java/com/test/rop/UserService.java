package com.test.rop;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.session.SimpleSession;

/**
 * @author huangchangling on 2017/6/13 0013
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
