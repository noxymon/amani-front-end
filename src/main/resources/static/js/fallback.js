$(function() {    
    console.log("Starting Course ..............................................");
    ZoomMtg.setZoomJSLib('/js/lib', '/av');
    ZoomMtg.preLoadWasm();
    ZoomMtg.prepareJssdk();
    ZoomMtg.init({
        debug: false,
        isSupportAV: true,
        disableInvite:true,
        screenShare: false,
        disableRecord:false,
        showMeetingHeader:false,
        meetingInfo: [
            'topic',
            'host'
        ],
        leaveUrl:meetingConfig.leaveUrl,
        success: (success) => {
            console.log(success)

            ZoomMtg.join({
                meetingNumber:meetingConfig.meetingNumber,
                signature:meetingConfig.signature,
                passWord: meetingConfig.password,
                apiKey:meetingConfig.apiKey,
                userName:meetingConfig.username,
                userEmail:meetingConfig.userEmail,
                success: (success) => {
                    console.log(success);
                },
                error: (error) => {
                    console.log(error);
                }
            })

        },
        error: (error) => {
            console.log(error)
        }
    })

    function styleMeeting() {
        $("head style").remove();
        $(".meeting-app").removeAttr("style");
        $("#wc-footer").removeClass().removeAttr("style").addClass("navbar fixed-bottom navbar-expand-sm navbar-dark bg-dark");

        // move button
        $(".send-video-container").detach().prependTo("#wc-footer");
        $(".join-audio-container").detach().prependTo("#wc-footer");
        $("#wc-footer-left").remove();
        $(".send-video-container + div").hide();
        $(".meeting-info-icon__icon-wrap").remove();

        //restyle button
        $(".join-audio-container button").addClass("btn btn-primary");
        $(".send-video-container button").addClass("btn btn-warning");
        $("button.footer__leave-btn").addClass("btn btn-danger float-right");
    }
})
