<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body
    {
        height: 90vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    form
    {
        height: 100px;
        width: 300px;
        
    }
    input
    {
        width: 90%;
    }
    button
    {
        margin-top: 20px;
        margin-left: 30px;
    }
</style>
</head>
<body>
<h3 align="center" style=" color:green">${pos}</h3>
<h3 align="center" style=" color:red">${neg}</h3>
    <form action="add-task" method="post">
        <fieldset>
            <legend>Enter Task Here,</legend>
            Task Name: <input type="text" name="name">
            Task description : <input type="text" name="description">
            <button>Add Task</button>
            <button>Logout</button> 
        </fieldset>
    </form>
</body>
</html>