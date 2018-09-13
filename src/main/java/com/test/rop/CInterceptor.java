package com.test.rop;

import com.rop.AbstractInterceptor;
import com.rop.RopRequestContext;

import java.io.Serializable;

/**
 * Created by huangchangling on 2018/9/13.
 */
public class CInterceptor extends AbstractInterceptor {
    public void beforeService(RopRequestContext ropRequestContext) {
        System.out.println("before service=========");
    }

    public void beforeResponse(RopRequestContext ropRequestContext) {
        Object ret = ropRequestContext.getRopResponse();
        CResponse c = new CResponse();
        c.setBody(ret);
        c.setMessageCode("200");
        ropRequestContext.setRopResponse(c);
        System.out.println("beforeResponse=========");
    }
    class CResponse implements Serializable {
        Object body;
        String messageCode;

        public Object getBody() {
            return body;
        }

        public void setBody(Object body) {
            this.body = body;
        }

        public String getMessageCode() {
            return messageCode;
        }

        public void setMessageCode(String messageCode) {
            this.messageCode = messageCode;
        }
    }
}
