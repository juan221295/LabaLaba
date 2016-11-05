<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<spring:url value="/resources/css.css" var="labalabaCSS" />
<spring:url value="/resources/js.js" var="labalabaJS" />
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
    <!-- Search, Profil, logout, signin signup, Kategori: -->
    <!-- Kategori: elektronik, barang baku makanan, furniture/peralatan rumah/home living construction -->
    <!-- Kategori: textile, machinery industrial, sport toys gift, health beauty, jewelry, bag , shoes, agriculture & food-->
    <!-- Order Page: halaman untuk memesan -->
    <!-- Konfirmasi order page -->
    <!-- Pembayaran -->
    <!-- Notif pemesanan, notif sudah di konfirm/ belum -->
    <header class="container">
      <div class="row">
        <h1 class="col-xs-8 col-md-7">
          <a href="/LabaLaba/">LabaLaba.com</a>
        </h1>

        <nav class="col-xs-4 col-md-5 text-right">
          <p>
          <a href="signIn">Sign in</a>
            <%-- <%try{
          		if(session.getAttribute("sessionla").equals(null)){	
          		}
          		%>
          		
          		<a href="logout">logout</a>	
          		
          	<%
          	}catch(NullPointerException e){%>
          		<a href="signIn">Sign in</a>
          	<% } %> --%>
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
    


    <!-- <section class="jumbotron">
    <div class="container">
      <div class="row text-center">
        <h2>
          Homemade Goods
        </h2>
        <h3>
          This Year's Best
        </h3>
        <a class="btn btn-primary" href="#" role="button">See all</a>
      </div>
    </div>
  </section> -->
  
  <div class="container">
    
    <!-- Title -->
    <!-- <div class="row">
        <div class="col-lg-12">
            <h3>Buku Naruto</h3>
        </div>
    </div> -->
    <div class="row">
      <!-- <h1>Coba</h1>
      <h2>cobaaaa</h2> -->
      <div class="col-sm-8 col-md-1 col-xs-8">
        <ul class="image-detail">
          <li><img src="https://dummyimage.com/50x50/b337b3/0b19db.png" alt="" /></li>
          <li><img src="https://dummyimage.com/50x50/b337b3/0b19db.png" alt="" /></li>
          <li><img src="https://dummyimage.com/50x50/b337b3/0b19db.png" alt="" /></li>
        </ul>
      </div>

      <div class="col-sm-8 col-md-4">
          <img class="image-produk" src="http://placehold.it/800x500">
      </div>
      <div class="col-sm-8 col-md-4">
        <div class="caption">
          <h3>Buku</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
          <!-- <p><a href="#">Details...</a></p> -->
          <!-- <a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a> -->
        </div>
      </div>
      <div class="col-sm-8 col-md-3">
        <div class="thumbnail">
          <p>
            * * * * *
          </p>
          <p>
            stock : berapa
          </p>
          <p>
            mau pesan berapa
          </p>
          <p>
            <a href="#" class="btn btn-primary">Buy Now!</a>
          </p>

           <!-- alt="..." -->
          <!-- <img src="http://3.bp.blogspot.com/-5EtAyOSCNjc/UWiDnJl7ONI/AAAAAAAABb4/rsnD8_cXZsM/s640/cover_komik_naruto_vol_64_narutolovindo.png"> -->
        </div>



      </div>
    </div>

    <hr>

    <div class="row">
      <div class="col-sm-8 col-md-8">
        <h2>Deskripsi</h2>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
        </p>

        <hr>
        <h2>Ulasan</h2>
        <div class="row">
            <div class="col-sm-4 col-md-4">
              <p>
                * * * * *
              </p>
              <p>
                oleh pengulas
              </p>

            </div>
            <div class="col-sm-8 col-md-6">

              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 col-md-4">
              <p>
                * * * * *
              </p>
              <p>
                oleh pengulas
              </p>

            </div>
            <div class="col-sm-8 col-md-6">

              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </div>
        </div>


      </div>


      <div class="col-sm-6 col-md-4">
        <h3>RELATED PRODUCT</h3>
        <div class="thumbnail">
            <img src="http://placehold.it/800x500" alt="">
            <div class="caption">
                <h3>Feature Label</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                <p>
                    <a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More Info</a>
                </p>
            </div>
        </div>
        <div class="thumbnail">
            <img src="http://placehold.it/800x500" alt="">
            <div class="caption">
                <h3>Feature Label</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                <p>
                    <a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More Info</a>
                </p>
            </div>
        </div>
      </div>
    </div>
    <hr>





  </div>




  <footer class="footer footer-1">
      <div class="container">
        <p class="text-muted">Dibuat Oleh Ariel Juan, ini Footer</p>
      </div>
    </footer>




  </body>
</html>
