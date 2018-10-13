/**
 * Created by wenpeng23 on 2017-09-26.
 */
var browser = {
    // 检测是否是IE浏览器
    isIE: function() {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'msie') {
            return true;
        } else {
            return false;
        }
    },
    // 检测是否是chrome浏览器
    isChrome: function() {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'chrome') {
            return true;
        } else {
            return false;
        }
    },
    // 检测是否是Firefox浏览器
    isMozila: function() {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'mozilla') {
            return true;
        } else {
            return false;
        }
    },
    // 检测是否是Firefox浏览器
    isOpera: function() {
        var _uaMatch = $.uaMatch(navigator.userAgent);
        var _browser = _uaMatch.browser;
        if (_browser == 'webkit') {
            return true;
        } else {
            return false;
        }
    }
};

/**
 * 终极hack列冻结导致的高度问题
 * @param  {[String]} listId [列表ID]
 */

function hackHeight(listId) {
    $(listId + '_frozen tr').slice(1).each(function() {

        var rowId = $(this).attr('id');

        var frozenTdHeight = parseFloat($('td:first', this).height());
        var normalHeight = parseFloat($(listId + ' #' + $(this).attr('id')).find('td:first').height());

        // 如果冻结的列高度小于未冻结列的高度则hack之
        if (frozenTdHeight < normalHeight) {

            $('td', this).each(function() {

                /*
                 浏览器差异高度hack
                 */
                var space = 0; // opera默认使用0就可以
                if (browser.isChrome()) {
                    space = 0.6;
                } else if (browser.isIE()) {
                    space = -0.2;
                } else if (browser.isMozila()) {
                    space = 0.5;
                }

                if (!$(this).attr('style') || $(this).attr('style').indexOf('height:') == -1) {
                    $(this).attr('style', $(this).attr('style') + ";height:" + (normalHeight + space) + "px !important");
                }
            });
        }
    });
}