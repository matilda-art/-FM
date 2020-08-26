<%@ page import="com.matilda.service.BookService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.matilda.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 首页可以直接使用servlet完成，但servlet中一步步打印所有的html太麻烦了，所以使用jsp.
     jsp本质就是一个servlet。Tomcat会帮我们把jsp翻译成servlet。-->

<%!
    //这里定义属性方法
    private BookService bookService;

    public void jspInit() {
       bookService = new BookService();
   }
%>
<%
     //这里执行java代码
     List<Book> books = bookService.list();
%>

<!DOCTYPE html>
<html lang="zh-hans">
<head>
    <meta charset="utf-8">
    <title>书侣FM</title>
</head>
<body>
    <header>
        <nav>
            <ol>
                <li><a href="/register.html">注册</a></li>
                <li><a href="/login.html">登录</a></li>
                <li><a href="/add-book.jsp">上传书籍</a></li>
            </ol>
        </nav>
    </header>

    <main>
        <ol>
            <% for (Book book : books) { %>
            <li>
                <a href="/book.jsp?bid=<%= book.bid %>"><%= book.title %></a>
                <span>上传者：<%= book.user.username %></span>
            </li>
            <% } %>
        </ol>
        <!--
        <ol>
            <li>
                <a href="/book?bid=<bid>">书籍名称</a>上传者：用户名
            </li>
        </ol>
        -->
    </main>
</body>
</html>
