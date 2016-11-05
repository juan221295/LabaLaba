<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 -->
<link href="/css.css" rel="stylesheet" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js.js"></script>
<title>Sign in</title>
<style type="text/css">
/* body {
	background-image: url('http://labalaba.com/bg.png');
} */
</style>
</head>

  <body>
  <h1>${name }</h1>
   <br>
    <header class="container">
      <div class="row">
        <h1 class="col-xs-8 col-md-7">
          <a href="/LabaLaba/">LabaLaba.com</a>
        </h1>

        <nav class="col-xs-4 col-md-5 text-right">
          <p>
            
          	<a href="signIn">Sign in</a>
          </p>
        </nav>
      </div>
      <br>
      <div class="row">
        <nav>
            <div class="dropdown">
              <p class="pointer"data-toggle="dropdown">Categories
              <span class="caret"></span></p>
              <ul class="dropdown-menu">
                <li class="dropdown-header">Categories</li>
                <li><a href="kategori?kategoriName=elektronik">Electronic</a></li>
                <li><a href="kategori?kategoriName=furniture">Furniture</a></li>
                <li><a href="#">Textile</a></li>
                <li><a href="#">Machinary Industrial</a></li>
                <li><a href="#">Gift</a></li>
                <li><a href="#">Health & Beauty</a></li>
                <li><a href="#">Agriculture & Food</a></li>
                <!-- <li class="divider"></li>
                <li class="dropdown-header">Dropdown header 2</li>
                <li><a href="#">About Us</a></li> -->
              </ul>
            </div>

          <p>
            Hot Items
          </p>
          <p>
            Contact
          </p>
        </nav>
      </div>
      <hr>	
    </header>


    <div class="container">
      <div class="row row-centered">
        <div class="col-md-6 col-md-offset-3 col-centered">
          <div class="panel panel-login">
            <div class="panel-heading">
              <div class="row text-center">
                <div class="col-xs-6">
                  <a href="#" class="active" id="login-form-link">Login</a>
                </div>
                <div class="col-xs-6">
                  <a href="#" id="register-form-link">Register</a>
                </div>
              </div>
              <hr>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-lg-12">
                  <form id="login-form" action="login" method="post" role="form" style="display: block;">
                    <div class="form-group">
                      <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                    </div>
                    <div class="form-group">
                      <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group text-center">
                      <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                      <label for="remember"> Remember Me</label>
                    </div>
                    <div class="form-group">
                      <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                          <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                        </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="row">
                        <div class="col-lg-12">
                          <div class="text-center">
                            <a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </form>
                  <form id="register-form" action="register" method="post" role="form" style="display: none;">
                    <div class="form-group">
                      <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                    </div>
                    <div class="form-group">
                      <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                    </div>
                    <div class="form-group">
                      <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
                    </div>
                    <div class="form-group">
                      <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                          <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <footer class="footer footer-1">
        <div class="container">
          <p class="text-muted">Dibuat Oleh Ariel Juan, ini Footer</p>
        </div>
      </footer>


  </body>
</html>
