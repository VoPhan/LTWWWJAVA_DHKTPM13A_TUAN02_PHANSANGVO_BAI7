<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Them moi sinh vien</title>
</head>
<body>
	<form action="SinhVienServlet" method="post" name="formAddSinhvien">
		<input type="hidden" name="command" value="ADD"/>
		<table>
			<tr>
				<td>Ma sinh vien: </td>
				<td><input type="text" name="masv" size="40" required="required"/> </td>
			</tr>
			<tr>
				<td>Ho ten: </td>
				<td><input type="text" name="hoten" size="40" required="required"/> </td>
			</tr>
			<tr>
				<td>Gioi tinh: </td>
				<td><label><input type="radio" name="gioitinh" checked="checked" value="Nam"/>Nam</label></td>
				<td><label><input type="radio" name="gioitinh" value="Nu"/>Nu</label></td>
			</tr>
			<tr>
				<td>So dien thoai : </td>
				<td><input type="text" name="phone" size="40" required="required"/> </td>
			</tr>
			<tr>
				<td>Dia chi : </td>
				<td><input type="text" name="diachi" size="40" required="required"/> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Luu"/> </td>
			</tr>
		</table>
	</form>
</body>
</html>