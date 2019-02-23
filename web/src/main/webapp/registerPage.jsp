<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Create account</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="shortcut icon" type="image/png" href="https://image.flaticon.com/icons/png/512/167/167756.png"/>

<style type="text/css">
    body {
        color: #566787;
        background: #f5f5f5;
        font-family: 'Varela Round', sans-serif;
        font-size: 13px;
    }
</style>

<body cz-shortcut-listen="true">
<form class="card-body col-lg-4 mx-auto" method="post">
    <div class="text-center mb-4">
        <img class="mb-4" src="https://image.flaticon.com/icons/png/512/167/167756.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Create account</h1>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputLogin">Login</label>
            <input type="text" class="form-control" id="inputLogin" placeholder="Login" required>
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword">Password</label>
            <input type="password" class="form-control" id="inputPassword" placeholder="Password" required>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputFirstName">First name</label>
            <input type="text" class="form-control" id="inputFirstName" placeholder="Your name" required>
        </div>

        <div class="form-group col-md-6">
            <label for="inputLastName">First name</label>
            <input type="text" class="form-control" id="inputLastName" placeholder="Your last name" required>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail">Email</label>
        <input type="email" class="form-control" id="inputEmail" placeholder="Email" required>
    </div>
    <div class="form-group">
        <label for="inputPhone">Phone</label>
        <input type="text" class="form-control" id="inputPhone" placeholder="Phone number" required>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
</form>
</body>
</html>
