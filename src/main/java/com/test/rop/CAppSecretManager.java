package com.test.rop;

import com.rop.security.AppSecretManager;

/**
 * Created by huangchangling on 2018/9/13.
 * 用于管理appKey和secret，默认从文件读取
 * sign可以忽略
 */
public class CAppSecretManager implements AppSecretManager {

    @Override
    public String getSecret(String s) {
        return null;
    }

    @Override
    public boolean isValidAppKey(String s) {
        return true;
    }
}
