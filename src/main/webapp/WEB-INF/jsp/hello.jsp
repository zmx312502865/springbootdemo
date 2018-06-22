<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/5/28
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>22</title>
</head>
<body>
  hello world

  <form method="POST" action="/book/upload" enctype="multipart/form-data">
      <input type="file" name="file" /><br/><br/>
      <input type="submit" value="Submit" />
  </form>

</body>
</html>
