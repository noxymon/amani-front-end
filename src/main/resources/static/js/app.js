document.addEventListener("DOMContentLoaded", function(event) {
  var $$ = Dom7;

  let themeForCurrentDevice = 'md';
  if(Framework7.device.ios){
    console.log("It is Pricey Device !!!");
    themeForCurrentDevice = 'ios';
  }

  var app = new Framework7({
    root: '#app', // App root element
    name: 'inspiranesia', // App name
    theme: themeForCurrentDevice,
    data: function () {
      return {
        products: [
          {
            id: 'course1',
            title: 'Apple iPhone 8',
            startDate:'21 Januari 2020',
            bannerUrl:'https://cdn.framework7.io/placeholder/nature-1000x600-3.jpg',
            outline:[
              {
                index:1,
                text:"Peserta Mampu Memahami 1"
              },{
                index:2,
                text:"Peserta Mampu Memahami 2"
              },{
                index:3,
                text:"Peserta Mampu Memahami 3"
              },
            ],
            instrukturProfile:'nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce',
            description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi tempora similique reiciendis, error nesciunt vero, blanditiis pariatur dolor, minima sed sapiente rerum, dolorem corrupti hic modi praesentium unde saepe perspiciatis.'
          },
          {
            id: 'course2',
            title: 'Apple iPhone 8 Plus',
            startDate:'21 Januari 2020',
            bannerUrl:'https://cdn.framework7.io/placeholder/nature-1000x600-3.jpg',
            outline:[
              {
                index:1,
                text:"Peserta Mampu Memahami 1"
              },{
                index:2,
                text:"Peserta Mampu Memahami 2"
              },{
                index:3,
                text:"Peserta Mampu Memahami 3"
              },{
                index:4,
                text:"Peserta Mampu Memahami 4"
              },{
                index:5,
                text:"Peserta Mampu Memahami 5"
              },{
                index:6,
                text:"Peserta Mampu Memahami 6"
              },
            ],
            instrukturProfile:'nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce',
            description: 'Velit odit autem modi saepe ratione totam minus, aperiam, labore quia provident temporibus quasi est ut aliquid blanditiis beatae suscipit odio vel! Nostrum porro sunt sint eveniet maiores, dolorem itaque!'
          },
          {
            id: 'course3',
            title: 'Apple iPhone X',
            startDate:'21 Januari 2020',
            outline:[
              {
                index:1,
                text:"Peserta Mampu Memahami 1"
              },{
                index:2,
                text:"Peserta Mampu Memahami 2"
              },
            ],
            bannerUrl:'https://cdn.framework7.io/placeholder/nature-1000x600-3.jpg',
            instrukturProfile:'nunc sed blandit libero volutpat sed cras ornare arcu dui vivamus arcu felis bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida dictum fusce',
            description: 'Expedita sequi perferendis quod illum pariatur aliquam, alias laboriosam! Vero blanditiis placeat, mollitia necessitatibus reprehenderit. Labore dolores amet quos, accusamus earum asperiores officiis assumenda optio architecto quia neque, quae eum.'
          },
        ]
      };
    },
    routes: routes,
    serviceWorker:{
      path:'/service-worker.js',
      scope:'/',
    }
  });
  let birthDateCalendar = null;

  $$('#my-login-screen .login-button').on('click', function () {
    var username = $$('#my-login-screen [name="username"]').val();
    var password = $$('#my-login-screen [name="password"]').val();

    app.loginScreen.close('#my-login-screen');
    app.dialog.alert('Username: ' + username + '<br>Password: ' + password);
  });

  $$('#view-settings').on('tab:show', function () {
    if(birthDateCalendar == null){
      birthDateCalendar = app.calendar.create({
        inputEl: '#birthDate',
        dateFormat:'dd MM yyyy',
        backDrop:true,
        footer:true
      });
    }
  })
});