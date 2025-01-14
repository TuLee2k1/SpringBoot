<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">


<!-- CSS -->
<link rel="stylesheet" href="css/admin.css">
</head>

<body>
<main class="container">

    <head class="row text-center">

    </head>

    <section class="row">
        <div class="col-6 offset-3 mt-4">
            <form th:action="@{/admin/categories/saveOrUpdate}"  method="post" th:object="${category}">
                <div class="card">
                    <div class="card-header">
                        <h2>Add New Category</h2>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                          <label for="categoryId">Category ID: </label>
                          <input type="hidden" th:field="*{isEdit}">
                          <input type="text" class="form-control" th:field="*{categoryId}"  aria-describedby="categoryIdHid" placeholder="Category ID" readonly>
                          <small th:errors="*{categoryId}" id="categoryIdHid" class="form-text text-muted">Category id is required</small>
                        </div>
                        <div class="form-group">
                          <label for="name">Name</label>
                          <input type="text" class="form-control" th:field="*{name}" id="name" aria-describedby="nameHid" placeholder="Category Name">
                         <small th:errors="*{categoryId}" id="categoryIdHid" class="form-text text-muted">Category id is required</small>
                        </div>
                    </div>
                    <div class="card-footer text-muted">

                        <button type="reset" class="btn btn-secondary">Reset</button>
                        <a th:href="@{/admin/categories}" class="btn btn-success"> List Categories</a>
                        <button class="btn btn-primary"><i class="fas fa-save "></i> <span th:if="${category.isEdit}">Update</span>
                            <span th:unless="${category.isEdit}">Save</span>
                        </button>

                    </div>
                </div>
            </form>

        </div>
    </section>
    <footer class="row"></footer>
</main>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</body>

</html>