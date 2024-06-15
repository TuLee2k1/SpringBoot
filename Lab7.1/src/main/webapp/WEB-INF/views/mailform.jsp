<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Send Email with File Attachment</title>
</head>
<body>
    <h1>Send Email</h1>
    <form action="sendEmail" method="post" enctype="multipart/form-data">
        <table>
        <div><h2>${message }</h2></div>
            <tr>
                <td>To:</td>
                <td><input type="email" name="to" required/></td>
            </tr>
            <tr>
                <td>Subject:</td>
                <td><input type="text" name="subject" required/></td>
            </tr>
            <tr>
                <td>Body:</td>
                <td><textarea name="body" required></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Send Email"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>