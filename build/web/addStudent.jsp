<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>Insert title here</title>
        <jsp:include page="/design/head.html"></jsp:include>

        </head>
        <body>
        <jsp:include page="/design/header.html"></jsp:include>
        <jsp:include page="/design/main_menu.html"></jsp:include>
        <div>
            <center>
                <h1 style="color: white;">New Student Registration Form</h1>
            </center>
            <form action="../StudentController" enctype="multipart/form-data"
                  method="post" style="width: 50%; margin-left: 25%">

                <input type="text" required="" autocomplete="off" autofocus="" name="sname" placeholder="Enter name"> 
                <input type="email" name="email" placeholder="Enter email"> 
                <input type="password" name="pwd" placeholder="Enter password"> 
                <input type="text" name="mno" required="" maxlength="10" placeholder="Enter mobile number">
                <input type="text"  name="dob" autocomplete="off" required="" id="dob" placeholder="Enter select dob"/><br>
                <input type="radio" value="Male" checked="checked" name="gender">
                <span style="color: white; font-size: x-large;">Male</span>
                <input
                    type="radio" value="Female" name="gender"> <span
                    style="color: white; font-size: x-large;">Female</span> <br> <br>
                <input type="file" name="image"> 
                <input type="submit" value="Register">

            </form>
        </div>
        <script src="../calander/jquery-2.1.4.min.js"></script>
        <script src="../calander/bootstrap.js"></script>
        <link rel="stylesheet" href="../calander/jquery-ui.css" />
        <script src="../calander/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#dob").datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true,
                    yearRange: '-100y:c+nn',
                });
            });

        </script>
    </body>
</html>