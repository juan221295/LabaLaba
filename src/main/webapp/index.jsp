<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD

=======
>>>>>>> ccc42f7252bf2d41cc537677b81877fbab37f200
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700' rel='stylesheet' type='text/css'>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js.js"></script>
    <link rel="stylesheet" type="text/css" href="/css.css">
    <title>LabaLaba.com</title>

</head>
<body>
<<<<<<< HEAD
    
=======
>>>>>>> ccc42f7252bf2d41cc537677b81877fbab37f200
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
			${message }
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

	 <div class="container">
	   <div class="row text-center">
	     <div id="myCarousel" class="carousel slide" data-ride="carousel">
	       <!-- Indicators -->
	       <ol class="carousel-indicators">
	         <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	         <li data-target="#myCarousel" data-slide-to="1"></li>
	         <li data-target="#myCarousel" data-slide-to="2"></li>
	         <li data-target="#myCarousel" data-slide-to="3"></li>
	       </ol>
	
	       <!-- Wrapper for slides -->
	       <div class="carousel-inner" role="listbox">
	
	         <div class="item active">
	           <img src="http://cdn3.dualshockers.com/wp-content/uploads/2016/03/FFXV_0330__13.jpg" alt="Chania" width="100%" height="345" style="margin:auto">
	           <div class="carousel-caption">
	             <h3>FF XIII</h3>
	             <p>NEW, FROM THE OVEN</p>
	           </div>
	         </div>
	
	         <div class="item">
	           <img src="http://cdn.fansided.com/wp-content/blogs.dir/229/files/2016/06/final-fantasy-xv-header.jpg" alt="Chania" width="100%" height="345" style="margin:auto">
	           <div class="carousel-caption">
	             <h3>Mountain</h3>
	             <p>Beautiful scenery isnt it...</p>
	           </div>
	         </div>
	
	         <div class="item">
	           <img src="https://upload.wikimedia.org/wikipedia/en/f/f5/Final_Fantasy_XV_key_art%3B_characters_in_battle.png" alt="Flower" width="100%" height="345" style="margin:auto">
	           <div class="carousel-caption">
	             <h3>Flowers and Fire</h3>
	             <p>Lets beat them up, Friends.</p>
	           </div>
	         </div>
	
	         <div class="item">
	           <img src="http://cdn.mos.cms.futurecdn.net/60666855057add5fac5da91ec44784e9.jpg" alt="Flower" width="100%" height="345" style="margin:auto">
	           <div class="carousel-caption">
	             <h3>Chocobo</h3>
	             <p>Kwerk Kwerk.</p>
	           </div>
	         </div>
	
	       </div>
	
	       <!-- Left and right controls -->
	       <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	         <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	         <span class="sr-only">Previous</span>
	       </a>
	       <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	         <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	         <span class="sr-only">Next</span>
	       </a>
	     </div>
	
	   </div>
	
	   <hr>
	   <!-- Title -->
	   <div class="row">
	       <div class="col-lg-12">
	           <h3>Furniture</h3>
	       </div>
	   </div>
	   <!-- /.row -->
	
	   <!-- Page Features -->
	   <div class="row text-center">
	
	       <div class="col-md-3 col-sm-6 hero-feature">
	           <div class="thumbnail">
	               <img src="http://placehold.it/800x500" alt="">
	               <div class="caption">
	                   <h3>Feature Label</h3>
	                   <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	                   <p>
	                       <a href="#" class="btn btn-primary">Buy Now!</a> <a href="infoProduk" class="btn btn-default">More Info</a>
	                   </p>
	               </div>
	           </div>
	       </div>
	
	       <div class="col-md-3 col-sm-6 hero-feature">
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
	
	       <div class="col-md-3 col-sm-6 hero-feature">
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
	
	       <div class="col-md-3 col-sm-6 hero-feature">
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
	   <!-- /.row -->
	
	   <hr>
	   
	   <!-- Title -->
	   <div class="row">
	       <div class="col-lg-12">
	           <h3>Elektronik</h3>
	       </div>
	   </div>
	   <!-- /.row -->
	
	   <!-- Page Features -->
	   <div class="row text-center">
	
	       <div class="col-md-3 col-sm-6 hero-feature">
	           <div class="thumbnail">
	               <img src="http://placehold.it/800x500" alt="">
	               <div class="caption">
	                   <h3>Feature Label</h3>
	                   <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	                   <p>
	                       <a href="#" class="btn btn-primary">Buy Now!</a> <a href="infoProduk" class="btn btn-default">More Info</a>
	                   </p>
	               </div>
	           </div>
	       </div>
	
	       <div class="col-md-3 col-sm-6 hero-feature">
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
	
	       <div class="col-md-3 col-sm-6 hero-feature">
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
	
	       <div class="col-md-3 col-sm-6 hero-feature">
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
	   <!-- /.row -->
	   <hr>
	 </div>
	<footer class="footer footer-1">
	    <div class="container">
	      <p class="text-muted">Dibuat Oleh Ariel Juan, ini Footer</p>
	    </div>
	</footer>
</body>
</html>
