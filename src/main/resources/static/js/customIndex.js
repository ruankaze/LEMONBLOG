/**
 * 设置选择后的分类名
 * @param obj
 */
function collapseOneContent(obj) {
    $("#collapseOneContent1").html($(obj).html());
    $("#collapseOne").attr("class", "panel-collapse collapse in");
}

/**
 * 图片推荐
 */
function pictureRecommend() {
    let webdesign = [3, 6, 8, 9, 11, 15];
    selclass("web-design", webdesign);
    let appdevelopment = [2, 5, 12, 14];
    selclass("app-development", appdevelopment);
    let mobileapps = [1, 4, 7, 10, 13];
    selclass("mobile-apps", mobileapps);
    function selclass(cname, arr) {
        for (let i = 0; i < arr.length; i++) {
            $(".nzpictures .isotope-item").eq(arr[i]-1).addClass(cname);
        }
    }
}
pictureRecommend();