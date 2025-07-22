<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>ajax</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
    <h1>Encoding 처리하기</h1>
    닉네임 : <input type="text" id="nick" />
    <input type="button" id="btn" value="닉네임 보내기" />
    <p id="result"></p>

    <!--<script>
      let xhr;

      function startRequest() {
        const nickname = document.querySelector("#nick").value;
        xhr = new XMLHttpRequest();
        xhr.onreadystatechange = callback;
        xhr.open("get", "/encoding?nickname=" + nickname);
        xhr.send(null);
      }

      function callback() {
        if (xhr.readyState === 4) {
          if (xhr.status === 200) {
            const nickname = xhr.responseText;
            document.querySelector("#result").innerHTML = nickname;
          }
        }
      }
      const btn = document.querySelector("#btn");
	  const text = document.querySelector("#nick");
	  text.addEventListener("input", startRequest);
      //btn.addEventListener("click", startRequest);
    </script>-->

    <!-- jQuery -->
    <script>
      $("#btn").click(() => {
        const nickname = $("#nick").val();
        $.ajax({
          // 요청
          type: "get",
          url: "/encoding",
          data: "nickname=" + nickname,
          // 응답
          success: function (result) {
            $("#result").text(result);
          },
        });
      });
    </script>
  </body>
</html>
