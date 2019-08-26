
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>区域管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/type.js"></script>



</head>
<body>
<!--显示所有区域-->
<table id="dg"></table>


<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:AddDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:updateDialog()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:delMoreType()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">多项删除</a>
    </div>

<!--添加对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"title="添加">
    <form method="post" action="" id="form1">

        类型名称:<input type="text" name="name">
    </form>
</div>
</div>
<!--添加对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveType()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseAddDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<!--修改对话框-->
<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form method="post"  id="form2" name="name">
        房屋编号:<input type="text" style="border: none" readonly name="id" > <br>
        类型名称:<input type="text" name="name" id="name3">
    </form>
</div>
<!--修改对话框的按钮-->
<div id="updateDialogButtons">
    <a href="javascript:updType()" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a>
    <a href="javascript:CloseupdDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


</body>

</html>
