<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css.css" media="screen" title="no title" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<<<<<<< HEAD
<script src="/js.js"></script>
<link href="/css.css" rel="stylesheet" />
=======
    <script src="/js.js"></script>
    <link href="/css.css" rel="stylesheet" />
>>>>>>> ccc42f7252bf2d41cc537677b81877fbab37f200
</head>
    
<body>
	
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
    <section class="container">
        <div>
            <h2>${kategoriName }</h2>
        </div>
        <div class="container">
            <div>
                <h3>Sub Category</h3>
            </div>
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=1">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=2">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=3">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=4">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <h3>Sub Category</h3>
            </div>
            <div class="row">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=5">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=6">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="http://loremflickr.com/320/200/Playstation?random=7">
                        <div class="caption">
                            <h4>Name</h4>
                            <a href="DetailProduk.html">
                                <span>Lihat Produk</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer class="footer footer-1">
      <div class="container">
        <p class="text-muted">Dibuat Oleh Ariel Juan, ini Footer</p>
      </div>
    </footer>
</body>
</html>
