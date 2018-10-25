<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
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
                    alert('添加按钮')
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
</script>


<table id="dg"></table>



