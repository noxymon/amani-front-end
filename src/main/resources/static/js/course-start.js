function moveToBottom(selector) {
    $(selector).css("bottom", "0px");
}

$(function () {
    moveToBottom("footer");

    $(location).attr("href", courseStartUrl);
    setTimeout(
        function () {
            $("#fallbackModal").modal('show');
        },
        10000
    );

    $("#btnUseFallback").click(function () {
        $("#fallbackModal").modal('hide');
        $(location).attr('href', "/course/"+ courseResult.id + "/start?useFallback=true");
    });
});
