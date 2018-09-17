package com.it.learn;

import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.client.RopClient;
import com.test.rop.LogonRequest;
import com.test.rop.LogonResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author huangchangling on 2017/6/13 0013
 */
public class UserServiceClient {
    public static final String SERVER_URL = "http://localhost:8080/router";
    public static final String APP_KEY = "00001";
    public static final String APP_SECRET = "abcdefg";
    private RopClient ropClient = new DefaultRopClient(SERVER_URL,APP_KEY,APP_SECRET);

    @Test
    public void createSession(){
        LogonRequest ropRequest = new LogonRequest();
        ropRequest.setUserName("tomson");
        //CompositeResponse response = ropClient.buildClientRequest().get(ropRequest,LogonResponse.class,"user.getSession","1.0");
        CompositeResponse response = ropClient.buildClientRequest().addParam("messageFormat","json").post(ropRequest,LogonResponse.class,"user.getSession","1.0");

        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof LogonResponse);
        assertEquals(((LogonResponse) response.getSuccessResponse()).getSessionId(),
                "mockSessionId1");
    }
}
