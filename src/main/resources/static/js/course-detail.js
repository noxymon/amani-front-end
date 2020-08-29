$(function () {
    $("#btnJoinCourse").click(function () {
        startLoading();

        if(loginResponse == null){
            $(location).attr('href', "/login");
        }

        $.post({
            url: "/course/" + courseResult.id + "/join",
            data: JSON.stringify({memberId: loginResponse.id}),
            contentType: 'application/json; charset=utf-8'
        }).fail(function () {
            $("#errorModal").modal('show', {keyboard: false});
            $("#btnJoinCourse").show();
        }).done(function () {
            $("#btnAlreadyJoined").show();
        }).always(function () {
            endLoading();
            window.location.reload(true);
        })
    });

    function startLoading() {
        $("#btnJoinCourse").hide();
        $("#btnJoinCourseLoading").show();
    }

    function endLoading() {
        $("#btnJoinCourseLoading").hide();
    }
})
