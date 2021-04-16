package com.csw.controller;

import com.csw.util.SecurityCode;
import com.csw.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

@Controller
@RequestMapping("captcha")
public class CaptchaAction {
    @RequestMapping("captcha")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ������֤�������
        String securityCode = SecurityCode.getSecurityCode();
        /**
         * �����������session,δ����������֤
         */
        HttpSession session = request.getSession();
        session.setAttribute("securityCode", securityCode);

        // ����������֤��ͼƬ
        BufferedImage image = SecurityImage.createImage(securityCode);
        // ��Ӧ���ͻ���

        OutputStream out = response.getOutputStream();
        /**
         * ��һ�������� ָ����֤��ͼƬ���� �ڶ��������� ͼƬ�ĸ�ʽ ������������ ָ�������
         */
        ImageIO.write(image, "png", out);

        return null;// ����null��������ת
       /*  <%----%>
    <img src="${path}/captcha/captcha" id="captchaImg"/>
    <div class="label-text">验证码：</div>
    <input type="text" name="captchaCode"><br/>
    <a href="javascript:void(0)"
        onclick="changeCaptcha()">看不清，换一张!~</a>&nbsp;<span
                style="color:red">${errorMsg }</span><br/>
    <script type="text/javascript">
                function changeCaptcha() {
            // 根据ID获取到验证码图片对象
            var captchaImg = document.getElementById('captchaImg');
            captchaImg.src = '${path}/captcha/captcha?'
                    + Math.random();
        }
    </script>
    <input type="submit" value="提交">
    <%--*/
    }
}