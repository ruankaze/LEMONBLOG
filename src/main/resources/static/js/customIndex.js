/**
 * 设置选择后的分类名
 * @param obj
 */
function collapseOneContent(obj){
	$("#collapseOneContent1").html($(obj).html());
	$("#collapseOne").attr("class","panel-collapse collapse in");
}