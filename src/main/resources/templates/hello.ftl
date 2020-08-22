<!DOCTYPE html>
<html lang="de" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet"/>
    <script src="js/main.js"></script>
</head>
<body>
<h2 class="title">Customers from database</h2>

<form>
    <input type="text" name="searchTerm">
    <button type="submit" class="btn btn-primary">Suche</button>
    <a href="/" class="btn btn-secondary">Alle Ergebnisse</a>
</form>

<div>
    <input type="text" id="searchTerm2" onkeyup="window.filterList();">
</div>

<table>
    <tr>
        <th>Vorname</th>
        <th>Nachname</th>
        <th>Alter</th>
    </tr>
    <#list customers as customer>
        <tr class="customer-row">
            <td>${customer.firstname}</td>
            <td>${customer.lastname}</td>
            <td>${customer.getAge()}</td>
        </tr>
    </#list>
</table>

</body>
</html>