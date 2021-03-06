<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>使用jqgrid表格</title>
    <!--引入css bootstrap -->
    <link rel="stylesheet" href="./boot/css/bootstrap.min.css">
    <!--引入jqgrid的css-->
    <link rel="stylesheet" href="./boot/css/ui.jqgrid-bootstrap.css">
    <!--引入 jquery -->
    <script src="./boot/js/jquery-3.4.1.min.js"></script>
    <!--引入 jqgrid-->
    <script src="./boot/js/jquery.jqGrid.min.js"></script>
    <!--引入 jqgrid 国际化-->
    <script src="./boot/js/grid.locale-cn.js"></script>
    <!--引入 boot的js-->
    <script src="./boot/js/bootstrap.min.js"></script>
    <%--<style>
           .aa {
               background-color: red;
           }
    </style>--%>
    <script>
        $(function () {

            //表格初始化
            $("#userlist").jqGrid({
                //width:800,
                styleUI: "Bootstrap",//设置为bootstrap风格的表格
                url: "${path}/e/qa",//获取服务端数据url 注意获取结果要json
                datatype: "json",//预期服务器返回结果类型
                mtype: "post",//请求方式
                colNames: ["编号", "姓名", "工资", "年龄", "生日", "所属部门"],//列名称数组
                colModel: [
                    {name: "id", align: 'center', classes: "aa"},//colModel中全部参数都写在列配置对象
                    {name: "name", editable: true,},
                    {name: "salary", editable: true,},
                    {name: "age", editable: true,},
                    {name: "bir", editable: true,
                    },
                    {name: "dept.name", editable: true, edittype: "select",
                        editoptions:{
                            dataUrl:"${path}/d/showAll"
                        }
                    },
                ],//列数组值配置列对象
                pager: "#pager",//设置分页工具栏html
                // 注意: 1.一旦设置分页工具栏之后在根据指定url查询时自动向后台传递page(当前页) 和 rows(每页显示记录数)两个参数
                rowNum: 2,//这个代表每页显示记录数
                rowList: [1,2,3, 4, 10, 20],//生成可以指定显示每页展示多少条下拉列表
                viewrecords: true,//显示总记录数
                caption: "用户列表",//表格标题
                cellEdit: true,//开启单元格编辑功能
                editurl: "${path}/e/cuid",//开启编辑时执行编辑操作的url路径  添加  修改  删除
                autowidth: true,//自适应外部容器
                height: 300,//指定表格高度

            }).navGrid("#pager");//开启增删改工具按钮  注意:1.这里存在一个bug surl为实现

        });
    </script>

    <!--作业: 1.通过假数剧玩jqgrid
             2.写一个员工和部门的后台
    -->
</head>
<body>


<!--创建表格-->
<table id="userlist"></table>

<!--分页工具栏-->
<div id="pager"></div>

</body>
</html>