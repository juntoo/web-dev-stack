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
      <h1>View Page</h1>
      <p>제목 : ${board.title}</p>
      <p>내용 : ${board.content}</p>
      <img src="http://192.168.0.35:8081/${board.url}" height="300px"><br />
      <p
        >작성시간 :
        <fmt:formatDate
          value="${board.createdAt}"
          pattern="yyyy-MM-dd HH:mm:ss"
      /></p>
      <button
        type="button"
        class="btn btn-outline-dark"
        data-bs-toggle="modal"
        data-bs-target="#editModal"
      >
        수정
      </button>
      <button type="button" class="btn btn-outline-dark" onclick="location.href='/delete?no=${board.no}'">삭제</button>
      <button
        type="button"
        class="btn btn-outline-dark"
        onclick="location.href='/list'"
      >
        목록으로
      </button>
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="editModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 수정</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <form action="/edit" method="post" enctype="multipart/form-data">
            <input name="no" value="${board.no}" hidden />
            <div class="modal-body">
              <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label"
                  >Title</label
                >
                <input
                  type="text"
                  class="form-control"
                  name="title"
                  value="${board.title}"
                />
              </div>
              <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label"
                  >Content</label
                >
                <textarea class="form-control" rows="3" name="content"
                >${board.content}
                </textarea>
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
              <button type="submit" class="btn btn-primary">Edit</button>
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
            <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 수정</h1>
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
</html>
