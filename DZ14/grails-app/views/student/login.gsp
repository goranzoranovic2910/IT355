<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Login</title>
    </head>
    <body>
        <div class="message" role="status">${message}</div>
        <form method="POST" action="/student/login">
            <input type="text" name="username" placeholder="username"/>
            <input type="password" name="password" placeholder="password" />
            <input type="submit" name="Login" value="Login" />
        </form>
    </body>
</html>
