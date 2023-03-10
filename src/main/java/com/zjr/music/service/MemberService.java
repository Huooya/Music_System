package com.zjr.music.service;

import com.zjr.music.config.HttpClientUtils;
import org.springframework.stereotype.Service;

/**
 * @author zym
 */
@Service
public class MemberService{

    /**
     * 通过码上登录获取二维码信息
     * @return
     */
    public String getQrCode() {
        String codeUrl = null;
        try {
            codeUrl = HttpClientUtils.get("https://server01.vicy.cn/8lXdSX7FSMykbl9nFDWESdc6zfouSAEz/wxlogin/wxLogin/tempUserId?secretKey=06a0b50645544c58ba32cb475ae6330a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codeUrl;
    }
}
