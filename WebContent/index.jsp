<%@page pageEncoding="GB18030" %>
<form action="show.jsp" method="post">
    <ul style="list-style: none; line-height: 30px">
        <li>�����û�������<input type="text" name="name"/><br/></li>
        <li>ѡ���Ա�
            <input name="sex" type="radio" value="��"/>��
            <input name="sex" type="radio" value="Ů"/>Ů
        </li>
        <li>
             ѡ��������ʾ���⣺
            <select name="question">
                <option value="ĸ������">ĸ������</option>
                <option value="��������">��������</option>
                <option value="��������">��������</option>
            </select>
        </li>
        <li>����������𰸣�<input type="text" name="key"/></li>
        <li><input type="submit" value="�ύ"/></li>
    </ul>
</form>