<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Signin </title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">

            <form class="form-signin" role="form" action="SignIn" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <input type="text" class="form-control" placeholder="Login" required autofocus id="login" name="login" />
                <input type="password" class="form-control" placeholder="Password" required id="password" name="password" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

        </div> 
    </body>
</html>
