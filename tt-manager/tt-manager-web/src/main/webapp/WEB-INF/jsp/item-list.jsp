<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox">
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
        <%--<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>--%>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="dg"></table>
<script>
    function add(){

    }
    function edit(){
        alert("edit")
    }
    function remove(){
        var selections = $('#dg').datagrid('getSelections');
        //console.log(selections);
        if(selections.length ==0){
            $.messager.alert('提示','请至少选中一条记录！');
            return;
        }
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                var ids = [];
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }
                //console.log(ids);
                $.post(
                  'items/batch',
                    {'ids[]':ids},
                    function(data){
                        $('#dg').datagrid('reload');
                    },
                    'json'
                );
            }
        });
    }
    function down(){
        alert("down")
    }
    function up(){
        alert("up")
    }
    function searchForm(){
        $('#dg').datagrid("load",{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        });
    }

    $('#dg').datagrid({
        multiSort:true,
        //请求远程服务器上的url http://localhost:8080/ttshop/items
        url:'items',
        // 将工具栏添加到数据表格中
        toolbar:'#toolbar',
        method:'get',
        //隔行变色
        striped:true,
        //每行面前显示行号
        rownumbers:true,
        //使得数据表格自适应填充父容器
        fit:true,
        //添加分页工具栏
        pagination:true,
        //默认显示10条,这样就可以显示20条
        pageSize:30,
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'商品编号',sortable:true,width:100},
            {field:'title',title:'商品名称',width:100},
            {field:'sellPoint',title:'卖点',width:100,align:'right'},
            {field:'catName',title:'分类名称',width:100,align:'right'},
            {field:'price',title:'价格',width:100,align:'right',sortable:true,formatter:function(value,row,index){
                return value/100;
            }},
           {field:'status',title:'商品状态',width:100,align:'right',formatter:function(value,row,index){
                switch(value){
                    case 1:
                        return "正常";
                        break;
                    case 2:
                        return "下架";
                        break;
                    case 3:
                        return "删除";
                        break;
                    default:
                        return "未知";
                }

            }},
            {field:'created',title:'创建日期',width:100,align:'right',formatter:function(value,row,index){
               return moment(value).format('LL');
            }},
            {field:'updated',title:'修改日期',width:100,align:'right',formatter:function(value,row,index){
                return moment(value).format('LL');
            }},

        ]]
    });
</script>
