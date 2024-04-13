<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%>

<html>
    <body>
        <form action="example" method="POST" >
            <botDetect:captcha id="formCaptcha" 
                userInputID="captchaCode"
                codeLength="3"
                imageWidth="150"
                imageStyle="GRAFFITI2" />
            <input id="captchaCode" type="text" name="captchaCode">
        </form>
        <h2>Hello World!</h2>
    </body>
</html>
