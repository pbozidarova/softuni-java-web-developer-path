        var firebaseConfig = {
            apiKey: "AIzaSyDKorLml2CoJoR1TvpktHP3JcNg_4aymGc",
            authDomain: "my-movies-4d55b.firebaseapp.com",
            databaseURL: "https://my-movies-4d55b.firebaseio.com",
            projectId: "my-movies-4d55b",
            storageBucket: "my-movies-4d55b.appspot.com",
            messagingSenderId: "891585177384",
            appId: "1:891585177384:web:1e046588621feeebbc921d"
        };
        // Initialize Firebase
        firebase.initializeApp(firebaseConfig);

        const auth = firebase.auth();
        
        let buttonElement = document.getElementById('login-button');
        buttonElement.addEventListener('click', onUserLogin);
        
        function onUserLogin(e) {
            let userElement = document.getElementById('username').value;
            let passwordElement = document.getElementById('password').value;
            let subHeaderElement = document.getElementById('sub-header');
            let loginFormElement = document.getElementById('login-form');

            auth.signInWithEmailAndPassword(userElement, passwordElement)
                .then(result => {
                    console.log('Successfully logged in!')
                    console.log(result);
                    subHeaderElement.innerText = `Hello, ${result.user.email}`;
                    loginFormElement.style.display = 'none';
                })
                .catch(err => {
                    console.log('err', err);
                });
        }
        