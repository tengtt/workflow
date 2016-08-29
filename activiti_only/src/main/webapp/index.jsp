<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<body>
<h2>Hello World!</h2>

<fieldset id="deployFieldset" style="">
    <legend>部署新流程</legend>
    <div><b>支持文件格式：</b>zip、bar、bpmn、bpmn20.xml</div>
    <form action="${ctx }/workflow/deploy" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="Submit" />
    </form>
</fieldset>
</body>
</html>
