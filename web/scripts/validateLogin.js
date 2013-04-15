
    function registerEvents() {
        //alert("init");
        var email = window.document.getElementById( "email" );
        //alert(email);
        email.addEventListener( "keyup", validateEmail, false );

        var password = window.document.getElementById( "password" );
        //alert(email);
        password.addEventListener( "keyup", validatePassword, false );

        var search = window.document.getElementById( "searchInput" );
        //alert(search);

        search.addEventListener( "keyup", suggest, false );
    }

    function validateEmail( event ) {
        //alert("validate");
        //msg = event.target.nodeName + ":: ";
        //msg = msg + event.type;
        //alert( msg );

        //Validate email
        var emailMsgError = "";
        var email = window.document.getElementById( "email" );
        var emailErrorField = document.getElementById("emailError");

        //alert(email.value);
        //alert(!checkNotEmpty(email.value));
        if(!checkNotEmpty(email.value)){
            emailMsgError = "Email cannot be empty";
            emailErrorField.style.backgroundColor = "white";
        }else if(!checkEmail(email.value)){
            emailMsgError = "Invalid email address";
            emailErrorField.style.backgroundColor = "yellow";
        }else{
            emailMsgError = "";
            emailErrorField.style.backgroundColor = "white";
        }
        emailErrorField.innerHTML = emailMsgError;
    }

    function validatePassword( event ) {
        //Validate password
        //alert("et")
        var passwordMsgError = "";
        var password = window.document.getElementById( "password" );
        var passwordErrorField = document.getElementById("passwordError");

        //alert(password.value);
        //alert(password.value.length);
        if(!checkNotEmpty(password.value)){
            passwordMsgError = "Password cannot be empty";
            passwordErrorField.style.backgroundColor = "white";
        }else if(password.value.length < 6){
            passwordMsgError = "Password must be more than six characters";
            passwordErrorField.style.backgroundColor = "yellow";
        }else{
            passwordMsgError = "";
            passwordErrorField.style.backgroundColor = "white";
        }
        passwordErrorField.innerHTML = passwordMsgError;
    }

    function validateForm(){
        var validEmail = true;
        var validPassword = true;
        var emailMsgError = "";
        var passwordMsgError = "";

        //Validate Email
        var email = window.document.getElementById( "email" );

        if(!checkNotEmpty(email.value)){
            emailMsgError = "Email cannot be empty";
            validEmail = false;
        /*}else if(!checkEmail(email.value)){
            emailMsgError = "Invalid email address";
            validEmail = false;*/
        }

        //Validate Password
        var password = window.document.getElementById( "password" );

        if(!checkNotEmpty(password.value)){
            passwordMsgError = "Password cannot be empty";
            validPassword = false;
        /*}else if(password.value.length < 6){
            passwordMsgError = "Password must be more than six characters";
            validPassword = false;*/
        }

        if(!validEmail){
            var emailErrorField = document.getElementById("emailError");
            //alert(emailErrorField);
            emailErrorField.innerHTML = emailMsgError;
            emailErrorField.style.backgroundColor = "yellow";
            
            return false;
        }

        if(!validPassword){

            var passwordErrorField = document.getElementById("passwordError");
            passwordErrorField.innerHTML = passwordMsgError;
            passwordErrorField.style.backgroundColor = "#886644";
            return false;
        }

        if(!validPassword || !validEmail){
            //alert("Error during login:\n" + emailMsgError + "\n" + passwordMsgError);
            return false;
        }

        emailErrorField.style.backgroundColor = "white";
        passwordErrorField.style.backgroundColor = "white";
        return valid;
    }
   
