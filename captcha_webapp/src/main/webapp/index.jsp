<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>

<html>
    <body>
        <form action="example" method="POST" >
            <%
                Captcha captcha = Captcha.load(request, "exampleCaptcha");
                captcha.setUserInputID("captchaCode");
                String captchaHtml = captcha.getHtml();
                out.write(captchaHtml);
            %>
            <input id="captchaCode" type="text" name="captchaCode">
        </form>
        <h2>Hello World!</h2>
    </body>
</html>
