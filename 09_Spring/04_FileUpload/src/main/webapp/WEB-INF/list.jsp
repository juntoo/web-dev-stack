<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>파일 업로드</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <div class="container">
      <h1>List Page</h1>
      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성시간</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${list}" var="item">
            <!-- title을 누르든 tr을 누르든 눌렀을 때 해당 상세페이지
					view.jsp    /view?no=1 -->
            <tr class="items" id="${item.no}" style="cursor: pointer">
              <td>${item.no}</td>
              <td>${item.title}</td>
              <!-- <td>${item.createdAt}</td> -->
              <td>
                <fmt:formatDate
                  value="${item.createdAt}"
                  pattern="yyyy-MM-dd HH:mm"
                />
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <nav>
        <ul class="pagination">
          <li class="page-item ${paging.prev ? '' : 'disabled'}">
            <a class="page-link" href="/list?keyword=${param.keyword}&page=${paging.startPage - 1}"
              >Previous</a
            >
          </li>

          <c:forEach
            begin="${paging.startPage}"
            end="${paging.endPage}"
            var="page"
          >
            <li class="page-item">
              <a
                class="page-link ${paging.page == page ? 'active' : ''}"
                href="/list?keyword=${param.keyword}&page=${page}"
                >${page}</a
              >
            </li>
          </c:forEach>

          <li class="page-item ${paging.next ? '' : 'disabled'}">
            <a class="page-link" href="/list?keyword=${param.keyword}&page=${paging.endPage + 1}"
              >Next</a
            >
          </li>
        </ul>
      </nav>

      <button
        type="button"
        class="btn btn-outline-dark"
        data-bs-toggle="modal"
        data-bs-target="#writeModal"
      >
        글 추가
      </button>

      <br /> <!--  <a>제목 검색</a>
      <input type="text" name="keyword" value="${param.keyword}" id="keyword" />
      <button
        type="button"
        name="search"
        onclick="search()"
        class="btn btn-outline-dark"
      >
        검색
      </button>  -->
      <form action="/list">
      	<a>제목 검색</a>
      	<input type="text" name="keyword" value="${param.keyword}"/>
      	<input type="submit" value="검색" class="btn btn-outline-dark"/>
      </form>
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="writeModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 등록</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <form action="/write" method="post" enctype="multipart/form-data">
            <div class="modal-body">
              <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label"
                  >Title</label
                >
                <input type="text" class="form-control" name="title" />
              </div>
              <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label"
                  >Content</label
                >
                <textarea
                  class="form-control"
                  rows="3"
                  name="content"
                ></textarea>
              </div>
              <div class="mb-3">
                <label for="formFile" class="form-label">Add File</label>
                <input
                  class="form-control"
                  name="file"
                  type="file"
                  accept="image/*"
                />
              </div>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Close
              </button>
              <button type="submit" class="btn btn-primary">Save</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="leadModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 등록</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="mb-3">
              <label for="exampleFormControlInput1" class="form-label"
                >Title</label
              >
              <input type="text" class="form-control" name="title" />
            </div>
            <div class="mb-3">
              <label for="exampleFormControlTextarea1" class="form-label"
                >Content</label
              >
              <textarea class="form-control" rows="3" name="content"></textarea>
            </div>
            <div class="mb-3">
              <label for="formFile" class="form-label">Add File</label>
              <input
                class="form-control"
                name="file"
                type="file"
                accept="image/*"
              />
            </div>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
            >
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script>
    $(".items").click((e) => {
      console.log(e.currentTarget.id);
      location.href = "/view?no=" + e.currentTarget.id;
    });

    function search() {
      const keyword = $("#keyword").val();
      location.href = "/list?keyword=" + keyword;
    }
  </script>
</html>
<!-- <fmt:parseDate
                  value="${item.createdAt}"
                  pattern="yyyy-MM-dd'T'HH:mm"
                  var="parseDateTime"
                  type="both"
                /> -->
