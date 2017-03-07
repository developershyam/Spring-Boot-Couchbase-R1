<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function() {
		$('.nav li').removeClass('active');
		$('#bookTab').addClass('active');
	});
</script>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="body_content">
	<div class="container" id="bookController"
		ng-controller="BookController">
		<div class="row"
			style="border: grey solid 1px; padding: 10px 0 20px 20px; margin-top: 80px;">
			<span style="font-size: 1.2em; font-weight: bold;">Add New
				Book</span>
			<div class="col-sm-12">
				<div class="col-sm-3">
					<input id="empfName" class="form-control" type="text"
						ng-model="newBook.name" placeholder="Book Name">
				</div>
				<div class="col-sm-3">
					<input id="emplName" class="form-control" type="text"
						ng-model="newBook.author" placeholder="Author">
				</div>
				<div class="col-sm-3">
					<input id="empEmail" class="form-control" type="text"
						ng-model="newBook.email" placeholder="Email">
				</div>
				<div class="col-sm-3">
					<button type="button" class="btn btn-primary" ng-click="addBook()">Add</button>
				</div>
			</div>
		</div>

		<div class="row" style="margin-top: 20px; text-align: center;">
			<span style="font-size: 1.2em; font-weight: bold;"> Books</span>
			<div ng-if="dataWrapper.data.length>0" class="totalRecords">Total
				Records: {{dataWrapper.totalElement}} , Total Pages:
				{{dataWrapper.totalPages}}</div>
			<div ng-if="!dataWrapper.data.length>0" class="recordNotFound">
				<i class="fa fa-book fa-lg" aria-hidden="true"></i>
				&nbsp;Book Not Available
			</div>
		</div>
		<div class="row" style="max-height: 300px; overflow: auto;">
		
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Sr</th>
						<th>Book Id</th>
						<th>Name</th>
						<th>Author</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="book in dataWrapper.data">
						<td>#
							{{(dataWrapper.pageNumber-1)*dataWrapper.pageSize+$index+1}}</td>
						<td>{{book.bookId}} <span e-class="hidden"
							editable-text="book.bookId" e-name="bookId" e-form="rowform" e-required></td>
						<td><span editable-text="book.name" e-name="name"
							e-form="rowform" e-required> {{ book.name || 'empty' }} </span></td>
						<td><span editable-text="book.author" e-name="author"
							e-form="rowform" e-required> {{ book.author || 'empty' }}
						</span></td>
						<td><span editable-text="book.email" e-name="email"
							e-form="rowform" onbeforesave="checkEmail($data)" e-required>
								{{ book.email || 'empty' }} </span></td>
						<!-- <td><div class="btn-group">
							<button type="button" class="btn btn-default btn"
								ng-click="editBook(book.bookId);">
								<i class="glyphicon glyphicon-pencil"></i>
							</button>
							<button type="button" class="btn btn-default btn"
								ng-click="deleteBook(book.bookId);">
								<i class="glyphicon glyphicon-trash"></i>
							</button>
						</div></td> -->
						<td style="white-space: nowrap">
							<!-- form -->
							<form editable-form name="rowform"
								onbeforesave="updateBook($data)" ng-show="rowform.$visible"
								class="form-buttons form-inline">
								<button type="submit" ng-disabled="rowform.$waiting"
									class="btn btn-primary">Save</button>
								<button type="button" ng-disabled="rowform.$waiting"
									ng-click="rowform.$cancel()" class="btn btn-default">
									Cancel</button>
							</form>
							<div class="buttons" ng-show="!rowform.$visible">
								<button class="btn btn-primary" ng-click="rowform.$show()">Edit</button>
								<button class="btn btn-danger" ng-click="deleteBook(book)">Delete</button>
							</div>
						</td>
					</tr>


				</tbody>
			</table>

		</div>
		<div class="row">

			<div id="bookPaginationFooter"
				class="bookPaginationFooter text-center"></div>


		</div>

	</div>
</div>

