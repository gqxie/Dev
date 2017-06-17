<%@page pageEncoding="GB18030" %>
<form action="show.jsp" method="post">
    <ul style="list-style: none; line-height: 30px">
        <li>输入用户姓名：<input type="text" name="name"/><br/></li>
        <li>选择性别：
            <input name="sex" type="radio" value="男"/>男
            <input name="sex" type="radio" value="女"/>女
        </li>
        <li>
             选择密码提示问题：
            <select name="question">
                <option value="母亲生日">母亲生日</option>
                <option value="宠物名称">宠物名称</option>
                <option value="电脑配置">电脑配置</option>
            </select>
        </li>
        <li>请输入问题答案：<input type="text" name="key"/></li>
        <li><input type="submit" value="提交"/></li>
    </ul>
</form>