var zTreeObj;

var setting ={
    view:{
        showIcon: true,      //设置是否显示节点图标
    },
    data:{
        simpleData: {
            enable: true,   //设置是否启用简单数据格式（zTree支持标准数据格式跟简单数据格式，上面例子中是标准数据格式）
            idKey: "mid",     //设置启用简单数据格式时id对应的属性名称
            pIdKey: "pid",    //设置启用简单数据格式时parentId对应的属性名称,ztree根据id及pid层级关系构建树结构
          
        },
    	key:{name:"popedomName"}
    }
    /*async: {
        enable: true,                      //设置启用异步加载
        type: "get",                       //异步加载类型:post和get
        contentType: "application/json",   //定义ajax提交参数的参数类型，一般为json格式
        url: "/Design/Get",                //定义数据请求路径
        autoParam: ["id=id", "name=name"]  //定义提交时参数的名称，=号前面标识节点属性，后面标识提交时json数据中参数的名称
    }*/
};
var nodes=[

];

$(document).ready(function(){
	console.log("===="+$("#menuTrees"));
	var menujson  =$("input[name='jsondata']").val();
	console.log("data"+menujson);
	zTreeObj = $.fn.zTree.init($("#menuTree3"),setting,JSON.parse(menujson));
});
