<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(function(){

        //⑤把div标签转换成dialog效果
        $("#addDialog").dialog({
            title:"添加",
            closed:true,
            width:250,
            height:300,
            //resizable:true
            //⑦添加一个底部按钮
            buttons:"#dialogBtn"
            //⑦添加一个底部按钮===END===

        });
        //⑤把div标签转换成dialog效果====END=====

    });

    $(function () {
        $('#dg').edatagrid({
            updateUrl:"${pageContext.request.contextPath}/banner/update.do",
            url:'${pageContext.request.contextPath}/banner/queryAllBanner.do',
            destroyUrl:"${pageContext.request.contextPath}/banner/delete.do",
            columns: [[
                {field: 'name', title: '标题', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'description', title: '描述', width: 100, align: 'right'},
                {field: 'createDate', title: '时间', width: 100},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加",
                handler: function () {
                    $("#addDialog").dialog("open")
                    //alert('添加按钮')
                }
            }, '-', {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    var row = $("#dg").edatagrid("getSelected");
                    if (row == null) {
                        alert("请先选中行")
                    } else {
                        var index = $("#dg").edatagrid("getRowIndex", row);
                        $("#dg").edatagrid("editRow", index);
                    }


                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    $('#dg').edatagrid('destroyRow');

                }
            }, '-', {
                iconCls: 'icon-save',
                text: "保存",
                handler: function () {
                   //alert("aaaaaaaaaaaaaaa")
                    $("#dg").edatagrid("saveRow")
                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.desc + '</p>' +
                    '<p>Status: ' + rowData.createDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },



        });
    })


    function doAdd() {


        $("#addForm").form("submit",{
            url:"${pageContext.request.contextPath}/banner/add.do",
            success:function(data){
                if(data=="true"){
                   // alert(data);
                    alert("添加成功");
                }else{
                    //alert(data);
                    alert("添加失败");
                }

                //关闭修改对话框
                $("#addDialog").dialog("close");

                //刷新datagrid
                $("#dg").datagrid("reload")

            }
        });

    }
</script>


<table id="dg"></table>
<div id="addDialog">
    <form id="addForm" method="post" enctype="multipart/form-data" contenteditable="true">
        标题：<input id="name" name="name"/><br/>
        图片：<input id="url" type="file" name="photo" /><br/>
        状态：<input id="status" name="status"/><br/>
       <%-- 创建时间：<input id="createDate"/><br/>--%>
        描述：<input id="description" name="description"/><br/>
    </form>
</div>
<div id="dialogBtn">
    <a class="easyui-linkbutton" id = "regBtn" onclick="doAdd()">立即添加</a>
</div>

