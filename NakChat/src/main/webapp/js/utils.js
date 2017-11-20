window.utils = function () {
    String.prototype.replaceAll = function(search, replacement) {
        var target = this;
        return target.replace(new RegExp(search, 'g'), replacement);
    };

    var _createHtml = function (html, values) {
        Object.keys(values).map(function(key, index) {
            var value = values[key];
            html = html.replaceAll("{{" + key + "}}", value);
        });
        return html;
    };

    return {
        createHtml: _createHtml
    }

}();