

var ttshop={
    registerMenuEvent:function(){
        var this_=this;
        var $tree = $("#menu .easyui-tree");
        $tree.tree({
            onClick:function(node){
              //console.log(node.attributes.href);//item-list
                var href = node.attributes.href;//item-list
                var text = node.text;//新增商品
               /* console.log(href);
                console.log(text);*/
                this_.addTabs(text,href);

            }
        })
    },
    addTabs:function(text,href){
        if( $('#tab').tabs('exists',text)){
            $('#tab').tabs('select',text);
            return;
        }
        $('#tab').tabs('add',{
            title:text,
            href:href,
            closable:true
        });
    },
    closeTabs:function(text){
        $('#tab').tabs('close',text);
    }

}