/************************************/
/* ProjectCookDetail.jsp			*/
/* ProjectCookEdit.jsp				*/
/* プロジェクトメニュー読み込み切り替え	*/
/** ********************************* */
function menuEntryChange(cnt) {
	var menus = document.getElementsByClassName('menus');

	for (var i = 0; i < menus.length; i++) {
		menus[i].style.display = (i === parseInt(cnt)) ? 'block' : 'none';
	}
}
