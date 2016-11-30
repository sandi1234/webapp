<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>You are now logged in as: <%= request.getAttribute("username") %> </h3>



<%
    String role = request.getAttribute("role").toString();

    if (role.equals("admin")) {
        out.println("Your are an admin and can read and create blogs");
    } else {
        out.println("you are a user and can only read blogs");
    }

%>

</body>
</html>