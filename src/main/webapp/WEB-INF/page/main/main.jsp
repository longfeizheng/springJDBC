<%--
  Created by IntelliJ IDEA.
  User: YourName
  Date: 2015/9/22 0022
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css">
    <script src="${pageContext.request.contextPath}/assets/js/jquery.1.9.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
    <title>Data Tables</title>
    <script>
        $(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/authUser/list",
                type: "get",
                dataType: "json",
                contentType:"application/json",
                success: function (data) {
                    var str=data.data.toString();
                    alert(str.replace("{","[").replace("}","]"));
                    $('#example').DataTable({
                       // "ajax": data
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus); // paser error;
                }
            });

        });
    </script>
</head>

<body>
<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>City</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>City</th>
    </tr>
    </tfoot>
</table>
</body>
</html>
