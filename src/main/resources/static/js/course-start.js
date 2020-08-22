$(function() {    
    console.log("Starting Course ..............................................");
    ZoomMtg.setZoomJSLib('/js/node_modules/@zoomus/websdk/dist/lib', '/av');
    ZoomMtg.preLoadWasm();
    ZoomMtg.prepareJssdk();
    ZoomMtg.init({
        leaveUrl:meetingConfig.leaveUrl,
        isSupportAV: true,
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
                    console.log(success)
                },
                error: (error) => {
                    console.log(error)
                }
            })

        },
        error: (error) => {
            console.log(error)
        }
    })
})