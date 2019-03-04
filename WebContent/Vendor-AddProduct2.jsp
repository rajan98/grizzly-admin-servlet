<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Admin - Add Product
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js">
    </script>
    <link rel="stylesheet" href="styles/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        input[type="file"] {
    
         display:block;
        }
        .imageThumb {
         max-height: 75px;
         border: 2px solid;
         margin: 10px 10px 0 0;
         padding: 1px;
         }
        </style>
        <script type="text/javascript">
       $(document).ready(function() {
  if (window.File && window.FileList && window.FileReader) {
    $("#files").on("change", function(e) {
      var files = e.target.files,
        filesLength = files.length;
      for (var i = 0; i < filesLength; i++) {
        var f = files[i]
        var fileReader = new FileReader();
        fileReader.onload = (function(e) {
          var file = e.target;
          $("<span class=\"pip\">" +
            "<img class=\"imageThumb\" width=\"25%\" src=\"" + e.target.result + "\" title=\"" + file.name + "\"/>" +
            "<br/><span class=\"remove\">Remove image</span>" +
            "</span>").insertAfter("#files");
          $(".remove").click(function(){
            $(this).parent(".pip").remove();
          });
        
          
        });
        fileReader.readAsDataURL(f);
      }
    });
  } else {
    alert("Your browser doesn't support to File API")
  }
});
        </script>  

</head>
  <body>
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img src="images/smlogo.png" alt="logo">
      </a>
      <form class="mx-2 my-auto d-inline">
        <div class="input-group topnav1">
          <input type="text" class="form-control border border-right-0 bg-light form-rounded" placeholder="Search">
          <span class="input-group-append">
            <button class="btn btn-outline-secondary border border-left-0  form-rounded" type="button">
              <span class="fa fa-search">
              </span>
            </button>
          </span>
        </div>
      </form>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <span class="fa fa-bell">
            </span>
          </a>
        </li>
        <li class="nav-item">
          <span class="navbar-text">
            Welcome, ${user.id}
            
          </span>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class= "mx-2 my-auto w-full" method="GET">
            <a href="LogoutServlet" class="btn btn-secondary  form-rounded" >Logout
            
            </a>
          </form>
        </li>
      </ul>
    </nav>
    <div class="container-clearfix">
      <br>
    </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3 bg-light">
          <br>
          <nav class="navbar navbar-expand-md navbar-dark navbar-custom">
            <span class="navbar-text navbar-">
              <b>PROFILE
              </b>
            </span>
            <ul class="navbar-nav ml-auto">
              <li class="nav-item">
                <a href="" style="color:aliceblue">
                  <b>Edit
                  </b>
                </a>
              </li>
            </ul>
          </nav>
          <br>
          <center>
            <img src="images/profile.png" alt="Profile Picture" width="25%">
            <br>
            <br>
            <b> ${user.name}
            </b>
            <br>
            <br>
            ID:  ${user.id}
            <br> 
            <br>
            <br>
            Designation:
            <br>
             ${user.id}
            <br>
            <br>
            Office:
            <br>
             ${user.address}
          </center>
        </div>
        <div class="col-md-6">
          <div class="container">
            <ul class="nav nav-tabs" role="tablist">
              <li class="nav-item">
                <a class="nav-link active" data-toggle="tab" href="#home">PRODUCTS
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#menu1">VENDORS
                </a>
              </li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
              <div id="home" class="container tab-pane active">
                <br>
                <br>
                <br>
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-8 bg-light   ">
                         <picture>
                        <center>
                          <br>
                          <br>
                          <br>
                          <label for="files">
                            <img src="images/add.png"/>
                        </label>
                          <input type="file" id="files" name="files[]" multiple hidden />
                          <br>
                          <br>
                          <br>
                          <b>Add Images
                          </b>
                          <br>
                          <br>
                        </center>
                      </picture>
                    </div>
                    
                    <div class="col-md-4">
                      <form class= "mx-2 my-auto w-full" action="AddProductServlet" method="POST">
                        <input type="text" name="productId" placeholder="Enter Product ID" required>
                      <select name="category">
                          <option value="Category">Category
                          </option>
                           <c:forEach  var="cat"  items= "${category}">
                          <option >${cat.name}
                          </option>
                          </c:forEach>
                        </select>
                        <input type="text" name="productName" placeholder="Name" required>
                        <input type="text" name="productDescription" placeholder="Description" required>
                        <input type="number"  name="productPrice" placeholder="Price " required>
                         <input type="text"  name="brand" placeholder="Brand" required>
                                  
                       
                       <span style="color:red"><b>${productError}</b></span>
                                   </div>
                  </div>   
                </div>
              </div>
              <div id="menu1" class="container tab-pane fade">
                <br>
              </div>
            </div>
            <!--tab ends here-->
          </div>
        </div>
        <div class="col-md-3">
          <button class="btn btn-dark form-rounded" style="width:30%; position: absolute; bottom: 50px; right: 20px;">Add
          </button>
          <br>
          <button class="btn btn-secondary form-rounded" style="width:30%;  position: absolute; bottom: 0; right: 20px;"  type="reset">Cancel
         
         </button>
        </form>
        </div>
      </div>
      
      </body>
    </html>