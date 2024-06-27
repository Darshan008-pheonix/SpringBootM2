<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
  <h1 style="color: aquamarine;">===========ADD EMP PAGE==========</h1>
  <form action="addEmp">
    <label for="">EmpID</label>
    <input type=number name="eid"><br> <br>
    <label for="">EmpName</label>
    <input type="text" name="ename"><br><br>
    <label for="">Sal</label>
    <input type=number name="sal"><br><br>
    <label for="">Age</label>
    <input type=number name="age"><br><br>
    <label for="">design</label>
    <input type="text" name="design"><br><br>
    <button type="submit" style="color: brown;">Add EMP</button>
  </form><br><br>
  <h1>${msg}</h1> <br><br>
  <form action="Welcome.jsp">
          <button type="submit">Main Page</button>
      </form><br>
</body>
</html>