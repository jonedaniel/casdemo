<html>
<head>
<title>Login Page for Examples</title>
<body bgcolor="white">
<form method="POST" action='/server/login' >
  <table border="0" cellspacing="5">
    <tr>
      <th align="right">Username:</th>
      <td align="left"><input type="text" name="username"></td>
    </tr>
    <tr>
      <th align="right">Password:</th>
      <td align="left"><input type="password" name="password"></td>
    </tr>
      <tr style="display: none">
          <th align="right">Service:</th>
          <td align="left"><input type="text" name="service" value="${service}"></td>
      </tr>
    <tr>
      <td align="right"><input type="submit" value="Log In"></td>
      <td align="left"><input type="reset"></td>
    </tr>
  </table>
</form>
</body>
</html>
