$(function() {    
    const meetConfig = {
        apiKey: 'ijEid1B3R5WA0Nfo3wghqw',
        meetingNumber: '6420593127',
        leaveUrl: 'https://google.com',
        userName: 'Cena Lagi Test',
        userEmail: 'cena.test@oi.com', // required for webinar
        role: 0 // 1 for host; 0 for attendee or webinar
    };
        
    console.log("Starting Course ..............................................");
    ZoomMtg.setZoomJSLib('https://dmogdx0jrul3u.cloudfront.net/1.7.9/lib', '/av');
    ZoomMtg.preLoadWasm();
    ZoomMtg.prepareJssdk();
})